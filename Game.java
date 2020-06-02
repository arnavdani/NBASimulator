import java.text.DecimalFormat;
/**
 * Simulates the activity needed to play a game between two teams
 * 
 * @author Arnav Dani
 * @version 0.6
 */
public class Game
{
    public Team team1;
    public Team team2;
    private static final double AWAY_PERFORMANCE = 74;
    private static final double HOME_PERFORMANCE = 76;
    private static final double SPREAD_VARIATION = 0.5;
    private static final double SPREAD_FACTOR = 0.7;
    double t1Off;
    double t2Off;
    double t1Def;
    double t2Def;
    Team winningTeam;
    Team losingTeam;
    DecimalFormat df = new DecimalFormat("###.##");
    /**
     * Creates game object and defines what two teams are playing
     */
    public Game(Team home, Team away)
    {
        team1 = home;
        team2 = away;
        team1.sortByOvr();
        team2.sortByOvr();
        calcStats();
        calcSpread();
        winningTeam = null;
        losingTeam = null;
    }

    /**
     * Prints out the information about the game in a consise way
     */
    public String toString()
    {
        String str = team1.getName() + "(Home)\tvs\t" +
            team2.getName() + "(Away)";

        return str;
    }

    /**
     * @return the winning team
     */
    public Team getWinningTeam()
    {
        return winningTeam;
    }

    /**
     * Calculates the projected pointDiff for the game
     *  without changes in probability
     *  
     *  The spread is 70% of what it should be to allow
     *      the better team to be able to beat the spread by a
     *      competent amount
     *  
     *  can be used to gamble on games later but mainly for stats
     *  against the spread
     */
    public double calcSpread()
    {
        double t1Diff = team1.calcOffenseRtg() - team2.calcDefenseRtg();
        double t2Diff = team2.calcOffenseRtg() - team1.calcDefenseRtg();
        double pointDiff = t1Diff - t2Diff;
        return pointDiff * SPREAD_FACTOR ;
    }

    /**
     * Converts spread calculation into a String
     */
    public String writeSpread()
    {
        double pointDiff = calcSpread();
        String firstName = team1.getName() + "(Home)";
        String secondName = team2.getName() + "(Away)";
        String spread;

        if (pointDiff > SPREAD_VARIATION)
        {
            spread = firstName + "\t-" + df.format(pointDiff);
        }
        else if (pointDiff < -1 *SPREAD_VARIATION)
        {
            spread = secondName + "\t" + df.format(pointDiff);
        }
        else
        {
            spread = "Spread is too close to call";
        }

        return spread;
    }

    /**
     * Calculates random values for each game, decides a winner
     *      and increments the teams record
     *      
     *      Each game, a team is anywhere between 75% - 100%
     *          of its offensive/defensive ratings to ensure
     *          that bad teams can occasionally win
     *          
     *          Each teams stats are 75% + a random factor(a number 0 - 25) to ratio
     *                  and add to the 675% value
     */
    public void calcStats()
    {
        double t1OffRand = (int)(Math.random()*(100 - HOME_PERFORMANCE));
        double t1DefRand = (int)(Math.random()*(100 - HOME_PERFORMANCE));
        double t2OffRand = (int)(Math.random()*(100 - AWAY_PERFORMANCE));
        double t2DefRand = (int)(Math.random()*(100 - AWAY_PERFORMANCE));

        double t1BaseOff = team1.calcOffenseRtg() * (HOME_PERFORMANCE / 100);
        double t1BaseDef = team1.calcDefenseRtg() * (HOME_PERFORMANCE / 100);
        double t2BaseOff = team2.calcOffenseRtg() * (AWAY_PERFORMANCE / 100);
        double t2BaseDef = team2.calcDefenseRtg() * (AWAY_PERFORMANCE / 100);

        double t1OffAdd = t1OffRand/100 * team1.calcOffenseRtg();
        double t1DefAdd = t1DefRand/100 * team1.calcDefenseRtg();
        double t2OffAdd = t2OffRand/100 * team2.calcOffenseRtg();
        double t2DefAdd = t2DefRand/100 * team2.calcDefenseRtg();

        t1Off = t1BaseOff + t1OffAdd;
        t1Def = t1BaseDef + t1DefAdd;
        t2Off = t2BaseOff + t2OffAdd;
        t2Def = t2BaseDef + t2DefAdd;
    }

    /**
     * Plays the game, assigns a winner/loser, and updates records
     * 
     * @precondition teams' players are sorted by ovr
     *      
     * 
     */
    public String play()
    {
        //stats are calculated when object is constructed
        double t1Diff = t1Off - t2Def;
        double t2Diff = t2Off - t1Def;
        int pointDiff = (int)(t1Diff - t2Diff);

        //pointdiff is an integer so close games do go to OT
        String result = findWinner(pointDiff);

        return result;//.substring(0, result.indexOf("As"));
    }

    /**
     * Determines a winning team using a point differential input
     * @param point diff inputted differential used to calculate a winner
     *  if > 0, t1 wins,
     *      if < 0, t2 wins,
     *      in tie, compare clutch of the best player values to update pointDiff
     *      
     *      If those tie, team1 wins as the "home team"
     * 
     * 
     * Also takes care of the spread calculations
     *  if team wins by more than expected or loses by less than expected
     *          they have beat the spread - good to know for which teams to bet on
     *          
     * 
     * 
     * @precondition teams' players are sorted by ovr
     *          
     */
    public String findWinner(int pointDiff)
    {
        boolean covered = false;
        double spread = calcSpread();

        //calculating winner
        //i
        if (pointDiff == 0)
        {
            //overtime
            int team1OT = team1.getTeam()[0].getClutch();
            int team2OT = team2.getTeam()[0].getClutch();
            pointDiff = team1OT - team2OT;   

            if (pointDiff == 0)
            {
                winningTeam = team1; // home court advantage
                losingTeam = team2;
            }

        }

        //normal deciding factor with final pointdiff values
        if (pointDiff > 0)
        {
            winningTeam = team1;
            losingTeam = team2;
            if (pointDiff > calcSpread())
            {
                winningTeam.addTrueWins();
                covered = true;
            }
            else
            {
                losingTeam.addTrueWins();
                covered = false;
            }

        }
        if (pointDiff < 0)
        {
            winningTeam = team2;
            losingTeam = team1;
            if (pointDiff < calcSpread())
            {
                winningTeam.addTrueWins();
                covered = true;
            }
            else
            {
                losingTeam.addTrueWins();
                covered = false;
            }
            pointDiff = -1* pointDiff;
            spread = -1 * spread;
        }

        //so that it doesnt say team won by 0, home team won by one bc tiebreaker
        if (pointDiff == 0)
            pointDiff = 1;
        updateRecords();

        String summary = "The " + winningTeam.getName() + "(" + winningTeam.getRecord()
            + ")" + " beat the " + losingTeam.getName() + "(" + losingTeam.getRecord()
            + ")" + " by " + pointDiff;

        return summary;
    }

    /**
     * Updates records for both teams
     */
    public void updateRecords()
    {
        winningTeam.addWin(losingTeam);
        losingTeam.addLoss(winningTeam);
        winningTeam.gameCount();
        losingTeam.gameCount();

    }
}

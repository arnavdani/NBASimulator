
/**
 * Describes specific characteristics of a playoff 
 *      game that differ from a regular game
 * 
 * @author Arnav Damo 
 * @version .402
 */
public class PlayoffGame extends Game
{


    /**
     * Constructor for objects of class PlayoffGame
     */
    public PlayoffGame(Team home, Team away)
    {
        super(home, away);
    }

    /**
     * Changes update record to update the playoff stats
     */
    @Override
    public void updateRecords()
    {
        winningTeam.addPlayoffWin();
        losingTeam.addPlayoffLoss();
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
     * Does not have spread calculation since nobody cares in the playoffs
     *          
     * 
     * 
     * @precondition teams' players are sorted by ovr
     *          
     */
    @Override
    public String findWinner(int pointDiff)
    {

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
        if (pointDiff > 0)
        {
            winningTeam = team1;
            losingTeam = team2;
        }
        if (pointDiff < 0)
        {
            winningTeam = team2;
            losingTeam = team1;
            pointDiff = -1 * pointDiff;
        }
        
        updateRecords();

        String summary = "The " + winningTeam.getName() + "(" + winningTeam.getPlayoffRecord()
            + ")" + " beat the " + losingTeam.getName() + "(" + losingTeam.getPlayoffRecord()
            + ")" + " by " + pointDiff;
        
        return summary;
        
    }
    
    /**
     * Prints out the information about the game in a consise way
     */
    @Override
    public String toString()
    {
        String str = team1.getName() + "(" + team1.getSeed() + ")\tvs\t" +
                    team2.getName() + "(" + team2.getSeed() +")";
                    
        return str;
    }
    
    
}

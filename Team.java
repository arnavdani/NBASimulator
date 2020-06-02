import java.util.ArrayList;
import java.text.DecimalFormat;
/**
 * Represents a team, which is an array of 5 individual players. Teams play games
 *      win, lose, and can lose players via retirement.
 * 
 * @author Arnav 
 * @version 0.6
 */
public class Team
{
    Player[] team = new Player[5];
    String name; //team name
    int wins; 
    int losses;
    int trueWins; //a true win is if the team wins and beats the spread - will be used to display stats late
    int playoffWins;
    int playoffLosses;
    int gamesPlayed;
    public final int ID;
    int seed;
    boolean hasPlayedToday = false;
    int[] teamsPlayed;
    DecimalFormat df = new DecimalFormat("###.##");
    
    
    //constructors
    /**
     * Constructor for objects of class Team
     * 
     * @precondition all players are less than 37 years old
     */
    public Team(String n, Player p1, Player p2, Player p3, Player p4, Player p5, int teamID)
    {
        gamesPlayed = 0;
        name = n;
        team[0] = p1;
        team[1] = p2;
        team[2] = p3;
        team[3] = p4;
        team[4] = p5;
        ID = teamID;

        teamsPlayed = new int[30];
        for (int i = 0; i < 30; i++)
        {
            teamsPlayed[i] = 0;
        }
    }

    public Team(String n, int id)
    {
        gamesPlayed = 0;
        name = n;
        for (int i = 0; i < 5; i++)
        {
            team[i] = new Player();
        }
        ID = id;
        teamsPlayed = new int[30];
        for (int i = 0; i < 30; i++)
        {
            teamsPlayed[i] = 0;
        }
    }
    
    //accessors/mutators
    
    /**
     * @return the array of players
     */
    public Player[] getTeam()
    {
        return team;
    }

    /**
     * returns integer list of the number of times 
     * this team has played every other team
     */
    public int[] getPlayed()
    {
        return teamsPlayed;
    }

    public boolean playedToday()
    {
        return hasPlayedToday;
    }

    public void setPlayedToday(boolean b)
    {
        hasPlayedToday = b;
    }

    /**
     * @return team iD
     */
    public int getID()
    {
        return ID;
    }

    /**
     * sets the seed to inputted value between 1-16
     */
    public void setSeed(int s)
    {
        seed = s;
    }

    /**
     * gets the seed
     * @return int seed
     */
    public int getSeed()
    {
        return seed;
    }

    /**
     * @return name of team
     */
    public String getName()
    {
        return name;
    }

    
    /**
     * @return number of games played
     */
    public int getGamesPlayed()
    {
        return gamesPlayed;
    }

    /**
     * @return number of wins
     */
    public int getWins()
    {
        return wins;
    }

    /**
     * Sets the player/null at specified index to a different player
     */
    public void setTeam(int i, Player p)
    {
        team[i] = p;
    }

    /**
     * @return the number of times the team beat the spread
     */
    public int getTrueWins()
    {
        return trueWins;
    }

    /**
     * Increase the number of trueWins by 1
     */
    public void addTrueWins()
    {
        trueWins++;
    }

    /**
     * @return String of winning %
     */
    public double getWinPct()
    {
        return ((double)wins / (wins + losses)) * 100;
    }

    /**
     * @return String of % of beating the spread
     */
    public double getTrueWinPct()
    {
        return ((double)trueWins / (wins + losses)) * 100;
    }

    /**
     * add 1 to gamesPlayed
     */
    public void gameCount()
    {
        gamesPlayed++;
    }

    /**
     * @return number of losses
     */
    public int getLosses()
    {
        return losses;
    }
    
    /**
     * @return the total ovr of all the players
     */
    public double getTeamOvr()
    {
        double ovr = 0;
        for (int i = 0; i < 5; i++)
        {
            ovr += team[i].getOvr();
        }
        return ovr / 5;
    }
    
    //end accessors

    /**
     * increases wins by 1
     */
    public void addWin(Team other)
    {
        wins++;
        teamsPlayed[other.getID()]++;
    }

    /**
     * increases losses by 1
     */
    public void addLoss(Team other)
    {
        losses++;
        teamsPlayed[other.getID()]++;
    }

    /**
     * @return number of playoff wins
     */
    public int getPlayoffWins()
    {
        return playoffWins;
    }

    /**
     * @return playoff record
     */
    public String getPlayoffRecord()
    {
        return playoffWins + "-" + playoffLosses;
    }

    /**
     * Add win to playoffWins
     */
    public void addPlayoffWin()
    {
        playoffWins++;
    }

    /**
     * Add playoff loss
     */
    public void addPlayoffLoss()
    {
        playoffLosses++;
    }

    /**
     * resets the wins and  losses of the team
     */
    public void resetRecord()
    {
        wins = 0;
        losses = 0;
        trueWins = 0;
    }

    /**
     * resets playoff wins and  losses
     */
    public void resetPlayoffRecord()
    {
        playoffWins = 0;
        playoffLosses = 0;
    }

    /**
     * @return a string of win-loss record
     */
    public String getRecord()
    {
        return wins + "-" + losses;
    }

    /**
     * Calculates and returns team's offensive rating by adding the
     *      offensive rating of all 5 players and dividing it
     *      by 5
     * @return offensive rating
     */
    public double calcOffenseRtg()
    {
        double rtg = 0;
        for (int i = 0; i < 5; i++)
        {
            rtg += team[i].getOff();
        }
        return rtg / 5;
    }

    /**
     * Calculates and returns team's defensive rating by adding the
     *      defensive rating of all 5 players and dividing it
     *      by 5
     * @return defensive rating
     */
    public double calcDefenseRtg()
    {
        double rtg = 0;
        for (int i = 0; i < 5; i++)
        {
            rtg += team[i].getDef();
        }
        return rtg / 5;
    }


    /**
     * Uses selection to sort players in array team by overall, 
     *  with the highest overalls at the front of the array
     *  
     *  @precondition all null slots are at the back of the array
     */
    public void sortByOvr()
    {
        int mindex;

        for (int outer = 0; outer < 4; outer++)
        {
            mindex = outer;
            for (int inner = outer + 1; inner < 5; inner++)
            {
                if(team[mindex].compareOvr(team[inner]) < 0)
                {
                    mindex = inner;
                }
            }

            Player temp = team[outer];
            team[outer] = team[mindex];
            team[mindex] = temp;
        }
    }

    /**
     * prints team by printing each player,
     *      Player has toString
     */
    public void printTeam()
    {
        System.out.println("\n----" + name + "----");
        for (int i = 0; i < 5; i++)
        {            
            System.out.println(team[i]);
        }
        System.out.println("Offensive Rating: " + calcOffenseRtg() + "\tDefensive Rating: " + calcDefenseRtg());
    }
    
    /**
     * returns a string with consise information about the team
     * specifically the regular season record and the name
     */
    public String toString()
    {
        return this.getName() + "(" + this.getRecord() + ")";
    }

    /**
     * simulates offseason activities the team 
     *      can control like resetting the record
     *      , retiring old players, and updating the 
     *      number of new players needed for the draft
     */
    public void simOffseason()
    {
        resetRecord();
        resetPlayoffRecord();
        gamesPlayed = 0;
        seed = -1;
        for (int i = 0; i < teamsPlayed.length; i++)
        {
            teamsPlayed[i] = 0;
        }
        for (int i = 0; i < 5; i++)
        {
            team[i].simOffseason();
        }
    }

    /**
     * Checks whether two teams are equal to each other
     * by comparing names and ratings of individual players
     */
    public boolean equals(Team t)
    {
        if (this.name.equals(t.name))
        {
            for (int i = 0; i < 5; i++)
            {
                if (!this.getTeam()[i].equals(t.getTeam()[i]))
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
}


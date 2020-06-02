
/**
 * A player on a basketball team who has attributes. A player "trains" every summer to
 *      get better at their craft while they are young but become worse and eventually retire when they age
 * 
 * @author Arnav Dani
 * @version 0.6
 */
public class Player
{
    public String name; //name of player
    public String lastName; //for stat ranking
    public int age; //player age
    public int off; //offensive stat
    public int def; //defensive stat
    private final int OFFPOT; //potential used to progress players
    private final int DEFPOT; //potential used to progress players
    private final int INFLECTION_AGE = 32; //point of progression vs regression
    private final double GROWTH_RATE = 0.1666; //rate at which attributes grow
    private final int CLUTCH; //innate ability to perform, used in overtime calculations
    /**
     * Constructor for objects of class Player
     */
    public Player(String firstName, String lastN, int offense,
    int defense, int opotential, int dpotential, int c, int a)
    {
        //make out of range checks

        name = firstName + " " + lastN;
        lastName = lastN;
        off = offense;
        def = defense;
        OFFPOT = opotential;    
        DEFPOT = dpotential;
        CLUTCH = c;
        age = a;
    }
    
    /**
     * generate a random player
     */
    public Player()
    {
        name = "Unnamed Player";
        lastName = "random";
        off = (int)(Math.random() * 30 + 60);
        def = (int)(Math.random() * 30 + 60);
        OFFPOT = off + 8;
        DEFPOT = def + 8;
        CLUTCH = 5;
        age = (int)(Math.random() * 10 + 20);
    }
    
    //start accessors/mutators

    /**
     * @return the full name of the player
     */
    public String getFullName()
    {
        return name;
    }

    /**
     * @return last name of player
     */
    public String getLastNAme()
    {
        return lastName;
    }

    /**
     * @return age
     */
    public int getAge()
    {
        return age;
    }

    /**
     * @return offensive rating of player
     */
    public int getOff()
    {
        return off;
    }

    /**
     * @return defensive rating of player
     */
    public int getDef()
    {
        return def;
    }

    /**
     * @return clutch value
     */
    public int getClutch()
    {
        return CLUTCH;
    }

    /**
     * @return double of average rating of player aka overall
     */
    public double getOvr()
    {
        return (double)(off + def) / 2;
    }
    
    //end accessors/mutators

    /**
     * Change offensive rating by given amount
     * @param amt amount to increase by
     */
    public void changeOff(int amt)
    {
        off += amt;
    }

    /**
     * Change defensive rating by given amount
     * @param amt amount to increase by
     */
    public void changeDef(int amt)
    {
        def += amt;
    }

    /**
     * Trains the player to improve their stats relative to their potential.
     * Each train, a player has a chance to become 16% percent closer to their
     *      maximum potential.
     * 
     * @precondition OFF/DEF pot > offense/defense
     */
    public void train()
    {
        int offDiff = OFFPOT - off;
        int defDiff = DEFPOT - def;
        int oChange = (int)(Math.random() * (offDiff * GROWTH_RATE) / 1.5);
        int dChange = (int)(Math.random() * (defDiff * GROWTH_RATE) / 1.5);
        changeOff(oChange);
        changeDef(dChange);
    }

    /**
     * Simulates the offseason for a player. Players that are younger
     *      train more, hence develop more, and older players train less 
     *      and regress.
     *      r
     * The age of 32 is the inflextion point for 
     */
    public void simOffseason()
    {
        int ageDif = INFLECTION_AGE - age;
        int timesTrain = 0;
        if (ageDif > 0)
        {
            timesTrain = ageDif / 2;
        }
        else
        {
            off += ageDif; //regress by 1 at 33, 2 at 34, etc
            def += ageDif; // ^
        }

        for (int i = 0; i  <timesTrain; i++) //younger ppl get better, not older ones
            this.train();     
        age++;
    }

    /**
     * Compares ovr of this player to another player
     * 
     * @return 1 if this ovr is greater
     *         0 if same
     *         -1 if less than
     */
    public int compareOvr(Player p)
    {
        Double currentOvr = new Double(this.getOvr());
        Double newOvr = new Double(p.getOvr());
        return currentOvr.compareTo(newOvr);
    }

    /**
     * Checks if two players are equal by
     *  comparing characteristics
     *  
     */
    public boolean equals(Player p)
    {
        if (this.name.equals(p.name))
        {
            if (this.getAge() == p.getAge())
            {
                if (this.getOff() == p.getOff())
                {
                    if (this.getDef() == p.getDef())
                    {
                        if (this.getClutch() == p.getClutch())
                            return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Represents the needed values to be seen in a printable string
     */
    public String toString()
    {
        String result = name + "\tOffense/Defense/Ovr: " + off + "/" + def + 
            "/" + getOvr() + "\tage: " + age;

        return result;
    }

}

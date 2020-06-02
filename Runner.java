import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * Tests Player, Team, and Game class
 * 
 * @author Arnav
 * @version .6
 */
public class Runner
{
    DecimalFormat df = new DecimalFormat("###.##");

    public static void main(String[] args)
    {

        Runner runner = new Runner();

        League league = new League();

        runner.simSeason(league);
        System.out.println("\nDo you want to simulate the " + (league.getYear() + 1) + " season? 0 if no, any other int if yes");
        Scanner in = new Scanner(System.in);
        int sim = in.nextInt();
        while (sim != 0)
        {
            league.simOffseason();
            runner.simSeason(league);
            System.out.println("\n\n" + league.getYear() + " season");
            System.out.println("\nDo you want to simulate the " + (league.getYear() + 1) + " season? 0 if no, any other int if yes");
            sim = in.nextInt();
        }

        System.out.println("\nThanks for playing");

    }

    /**
     * Simulates the season using scanner input
     */
    public void simSeason(League league)
    {
        System.out.println("Do you want to see the result of every game or sim to the playoffs? 0 if no, 1 if yes");
        Scanner in = new Scanner(System.in);
        int am = in.nextInt();
        if (am == 0)
            league.simSeason(false);
        else if (am == 1)
            league.simSeason(true);
        else
            System.out.println("Wrong input. Try again");

    }
}

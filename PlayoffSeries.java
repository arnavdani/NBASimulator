
/**
 * A best of 7 series to determine who moves on to the next round
 * 
 * @author Arnav Dani
 * @version .6
 */
public class PlayoffSeries
{
    Game[] series = new Game[7];
    Team highseed;
    Team lowseed;
    int highSeedWins;
    int lowSeedWins;
    int currentGame;

    public PlayoffSeries(Team higherseed, Team lowerseed)
    {
        highseed = higherseed;
        lowseed = lowerseed;
        highSeedWins = 0;
        lowSeedWins = 0;
        currentGame = 1;
    }

    public Team playSeries()
    {
        System.out.println("Series between " + highseed.getName() + 
        "(" + highseed.getSeed() + ")" +
            "\t and \t " + lowseed.getName() + 
            "(" + lowseed.getSeed() + ")");
        while (highSeedWins < 4 && lowSeedWins < 4)
        {
            PlayoffGame game;
            //System.out.println("\n\nGame " + currentGame);
            if (currentGame <= 2)
            {
                game = new PlayoffGame(highseed, lowseed);
                //System.out.println(game);
                game.play();
            }
            else if (currentGame <= 4)
            {
                game = new PlayoffGame(lowseed, highseed);
                //System.out.println(game);
                game.play();
            }
            else if (currentGame % 2 == 1)
            {
                game = new PlayoffGame(highseed, lowseed);
                //System.out.println(game);
                game.play();
            }
            else
            {
                game = new PlayoffGame(lowseed, highseed);
                //System.out.println(game);
                game.play();
            }

            if (game.getWinningTeam().equals(highseed))
            {   highSeedWins++;
            }
            else
            {   lowSeedWins++;
            }
            /*
            System.out.println("\n" + highseed.getName() + " " +
            highSeedWins + "\t" + lowSeedWins + " " +
            lowseed.getName());
            currentGame++;
             */
        }
        System.out.println(highseed.getName() + " " +
            highSeedWins + "\t" + lowSeedWins + " " +
            lowseed.getName());

        return findSeriesWinner();

    }

    /**
     * Determines who won the series by seeing which team
     *      got for wins
     * 
     * @returns the winning team
     */
    public Team findSeriesWinner()
    {
        if (highSeedWins == 4)
        {
            return highseed;
        }
        else
        {
            return lowseed;
        }
    }
}

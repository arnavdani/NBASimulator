import java.util.ArrayList;
import java.text.DecimalFormat;

/**
 * Write a description of class League here.
 * 
 * @author Arnav Dani
 * @version .6
 */
public class League
{
    // instance variables - replace the example below with your own
    DecimalFormat df = new DecimalFormat("###.##");

    private int year;
    private Team[] teams;

    public League(Team[] t)
    {
        teams = t;
    }

    /**
     * Constructor for objects of class League
     */
    public League()
    {
        year = 2020;
        teams = new Team[30];

        //hawks

        Player traeYoung = new Player("Trae", "Young", 92, 72, 96, 84, 8, 21);
        Player johnCollins = new Player("John", "Collins", 85, 74, 91, 83, 4, 22);
        Player clintCapela = new Player("Clint", "Capela", 83, 85, 86, 89, 3, 26);
        Player deHunter = new Player("DeAndre", "Hunter", 78, 74, 83, 87, 6, 22);
        Player camReddish = new Player("Cam", "Reddish", 75, 74, 94, 90, 8, 20);

        teams[0] = new Team("Atlana Hawks", traeYoung, johnCollins, clintCapela, deHunter, 
            camReddish, 0);

        //celtics 

        Player kemba = new Player("Kemba", "Walker",87, 82, 89, 83, 7, 30);
        Player jayTatum = new Player("Jayson", "Tatum", 88, 87, 96, 93, 9, 22);
        Player jayBrown = new Player("Jaylen", "Brown",86, 88, 88, 95, 5, 23);
        Player gorHayward = new Player("Gordon", "Hayward", 79, 81, 85, 85, 6, 30);
        Player mSmart = new Player("Marcus", "Smart", 77, 84, 81, 88, 3, 26);

        teams[1] = new Team("Boston Celtics", kemba, jayTatum, jayBrown, gorHayward,
            mSmart, 1);

        //nets

        Player kD = new Player("Kevin", "Durant", 97, 95, 98, 96, 10, 31);
        Player kyrie = new Player("Kyrie", "Irving", 94, 87, 96, 90, 9, 28);
        Player levert = new Player("Caris", "Levert", 79, 78, 87, 86, 6, 25);
        Player jAllen = new Player("Jaret", "Allen", 79, 83, 88, 91, 2, 22);
        Player dJord = new Player("Deandre", "Jordan", 77, 79, 83, 83, 1, 31);

        teams[2] = new Team("Brooklyn Nets", kD, kyrie, levert, jAllen, dJord, 2);

        //hornets

        Player insect = new Player("Devonte", "Graham", 79, 78, 84, 84, 7, 25);
        Player mBridge = new Player("Miles", "Bridges", 77, 77, 89, 87, 6, 22);
        Player tRoz = new Player("Terry", "Rozier", 79, 79, 81, 81, 3, 26);
        Player pjWash = new Player("PJ", "Washington", 75, 77, 84, 83, 5, 21);
        Player cZeller = new Player("Cody", "Zeller", 75, 75, 75, 75, 1, 27);

        teams[3] = new Team("Charlotte Hornets", insect, mBridge, tRoz, pjWash, cZeller, 3);

        //bulls

        Player lavine = new Player("Zach", "Lavine", 84, 78, 92, 84, 8, 25);
        Player wcjr = new Player("Wendell", "Carter Jr", 79, 81, 85, 85, 2, 21);
        Player cobyWhite = new Player("Coby", "White", 76, 75, 88, 85, 7, 20);
        Player marksman = new Player("Lauri", "Markkanen", 83, 81, 87, 83, 6, 23);
        Player otto = new Player("Otto", "Porter Jr", 82, 76, 83, 78, 5, 26);

        teams[4] = new Team("Chicago Bulls", lavine, wcjr, cobyWhite, marksman, otto, 4);

        //cavs

        Player drum = new Player("Andre", "Drummond", 82, 87, 88, 93, 2, 26);
        Player kLove = new Player("Kevin", "Love", 83, 83, 87, 83, 5, 31);
        Player cSex = new Player("Colin", "Sexton", 76, 75, 84, 87, 6, 21);
        Player trisTh = new Player("Tristan", "Thompson", 77, 79, 79, 79, 1, 29);
        Player kPort = new Player("Kevin", "Porter Jr",75, 74, 83, 84, 8, 20);

        teams[5] = new Team("Cleveland Caveliers", drum, kLove, cSex, trisTh, kPort, 5);

        //mavs

        Player luka = new Player("Luka", "Doncic", 93, 87, 98, 92, 10, 21);
        Player uniC = new Player("Kristaps", "Porzingis", 89, 90, 93, 95, 8, 24);
        Player sethC = new Player("Seth", "Curry", 81, 74, 85, 78, 7, 29);
        Player dPow = new Player("Dwight", "Powell", 77, 75, 83, 83, 1, 28);
        Player hard = new Player("Tim", "Hardaway Jr", 77, 79, 81, 81, 1, 28);

        teams[6] = new Team("Dallas Mavericks", luka, uniC, sethC, dPow, hard, 6);

        //nuggets

        Player joker = new Player("Nikola", "Jokic", 91, 91, 95, 95, 9, 25);
        Player jMurray = new Player("Jamal", "Murray", 83, 85, 89, 89, 7, 23);
        Player millsap = new Player("Paul", "Millsap", 80, 80, 80, 80, 6, 35);
        Player barton = new Player("Will", "Barton", 80, 81, 81, 81, 5, 29);
        Player mpj = new Player("Michael", "Porter Jr", 78, 78, 92, 92, 9, 21);

        teams[7] = new Team("Denver Nuggets", joker, jMurray, millsap, barton, mpj, 7);

        //pistons

        Player dRose = new Player("Derrik", "Rose", 82, 80, 84, 81, 10, 31);
        Player blakeG = new Player("Blake", "Griffin", 83, 83, 85, 85, 6, 31);
        Player kennard = new Player("Luke", "Kennard", 79, 85, 87, 81, 3, 23);
        Player coronaWd = new Player("Christian", "Wood", 79, 81, 82, 86, 5, 24);
        Player jHen = new Player("John", "Henson", 73, 72, 73, 73, 1, 29);

        teams[8] = new Team("Detriot Pistons", dRose, blakeG, kennard, coronaWd, jHen, 8);

        //warriors

        Player steph = new Player("Stephen", "Curry", 98, 90, 99, 90, 10, 32);
        Player klay = new Player("Klay", "Thompson", 89, 91, 91, 94, 9, 30);
        Player donk = new Player("Draymond", "Green", 75, 83, 80, 89, 2, 30);
        Player wiggs = new Player("Andrew", "Wiggins", 80, 82, 91, 89, 7, 25);
        Player ePasch = new Player("Eric", "Paschall", 76, 79, 84, 87, 6, 23);

        teams[9] = new Team("Golden State Warriors", steph, klay, donk, wiggs, ePasch, 9);

        //rockets

        Player harden = new Player("James", "Harden", 95, 78, 97, 85, 4, 30);
        Player brick = new Player("Russell", "Westbrook", 92, 87, 92, 87, 8, 31);
        Player roco = new Player("Robert", "Covington", 81, 83, 83, 83, 2, 29);
        Player pjT = new Player("PJ", "Tucker", 72, 78, 72, 78, 1, 35);
        Player ericGord = new Player("Eric", "Gordon", 84, 81, 88, 80, 7, 31);

        teams[10] = new Team("Houston Rockets", harden, brick, roco, pjT, ericGord, 10);

        //pacers

        Player sabon = new Player("Domantas", "Sabonis", 82, 74, 85, 80, 7, 24);
        Player brog = new Player("Malcom", "Brogdon", 84, 82, 91, 91, 5, 27);
        Player olad = new Player("Victor", "Oladipo", 87, 92, 91, 95, 9, 28);
        Player tjW = new Player("TJ", "Warren", 80, 80, 80, 80, 5, 26);
        Player mTurn = new Player("Miles", "Turner", 76, 85, 80, 90, 6, 24);

        teams[11] = new Team("Indiana Pacers", sabon, brog, olad, tjW, mTurn, 11);

        //clippers

        Player kawhi = new Player("Kahwi", "Leonard", 95, 98, 95, 99, 10, 28);
        Player PG = new Player("Paul", "George", 92, 93, 94, 96, 3, 29);
        Player trez = new Player("Montrezl", "Harrel", 84, 86, 86, 90, 7, 26);
        Player lou = new Player("Lou", "Williams", 83, 79, 86, 78, 8, 33);
        Player patBev = new Player("Patrick", "Beverly", 81, 86, 82, 92, 3, 29);

        teams[12] = new Team("Los Angeles Clippers", kawhi, PG, trez, lou, patBev, 12);

        //lakers

        Player bron = new Player("Lebron", "James", 97, 96, 99, 99, 7, 35);
        Player AD = new Player("Anthony", "Davis", 95, 95, 99, 99, 8, 27);
        Player kuz = new Player("Kyle", "Kuzma", 77, 76, 83, 78, 6, 24);
        Player mcG = new Player("Javale", "McGee", 80, 82, 82, 82, 2, 32);
        Player rondo = new Player("Rajon", "Rondo", 78, 76, 78, 76, 1, 34);

        teams[13] = new Team("Los Angeles Lakers", bron, AD, kuz, mcG, rondo, 13);

        //grizzlies

        Player ja = new Player("Ja", "Morant", 84, 82, 97, 95, 8, 20);
        Player jjj = new Player("Jaren", "Jackson Jr", 82, 84, 87, 89, 8, 21);
        Player jonasV = new Player("Jonas", "Valanciunas", 81, 81, 83 ,83, 3, 29);
        Player bClarke = new Player("Brandon", "Clarke", 76, 78, 87, 85, 3, 23);
        Player jWins = new Player("Justice", "Winslow", 81, 80, 89, 89, 3, 24);

        teams[14] = new Team("Memphis Grizzlies", ja, jjj, jonasV, bClarke, jWins, 14);

        //miami heat

        Player bam = new Player("Bam", "Adebayo", 86, 89, 89, 93, 8, 22);
        Player butler = new Player("Jimmy", "Butler", 87, 91, 91, 94, 9, 30);
        Player goran = new Player("Goran", "Dragic", 81, 81, 81, 81, 4, 34);
        Player herr = new Player("Tyler", "Herro", 82, 79, 95, 92, 10, 20);
        Player nunn = new Player("Kendrick", "Nunn", 77, 75, 81, 84, 4, 22);

        teams[15] = new Team("Miami Heat", bam, butler, goran, herr, nunn, 15);

        //bucks

        Player giannis = new Player("Giannis", "Antetokounmpo", 98, 97, 99, 99, 4, 25);
        Player kmill = new Player("Khris", "Middleton", 88, 86, 89, 87, 6, 28);
        Player eBled = new Player("Eric", "Bledsoe", 84, 86, 86, 86, 6, 30);
        Player bLop = new Player("Brook", "Lopez", 84, 84, 87, 87, 7, 32);
        Player gHill = new Player("George", "Hill", 78, 76, 80, 80, 1, 34);

        teams[16] = new Team("Milwaukee Bucks", giannis, kmill, eBled, bLop, gHill, 16);

        //twolves

        Player dLo = new Player("DeAngelo", "Russell", 89, 83, 91, 87, 9, 24);
        Player kat = new Player("Karl Anthony", "Towns", 91, 91, 94, 94, 6, 24);
        Player cul = new Player("Jarrett", "Culver", 75, 77, 84, 92, 7, 21);
        Player oko = new Player("Josh", "Okogie", 79, 81, 85, 85, 4, 21);
        Player mb = new Player("Malik", "Beasley", 76, 74, 80, 80, 5, 23);

        teams[17] = new Team("Minnesota Timberwolves", dLo, kat, cul, oko, mb, 17);

        //pels

        Player zion = new Player("Zion", "Williamson", 79, 82, 99, 99, 8, 20);
        Player lonzo = new Player("Lonzo", "Ball", 82, 82, 91, 93, 2, 22);
        Player hayes = new Player("Jackson", "Hayes", 78, 79, 85, 87, 5, 20);
        Player ingram = new Player("Brandon", "Ingram", 87, 86, 96, 91, 10, 23);
        Player reddick = new Player("JJ", "Reddick", 81, 76, 81, 76, 7, 33);

        teams[18] = new Team("New Orleans Pelicans", zion, lonzo, hayes, ingram, reddick, 18);

        //knicks          

        Player rj = new Player("RJ", "Barrett", 79, 83, 95, 95, 7, 20);
        Player mRob = new Player("Mitchell", "Robinson", 79, 86, 82, 94, 1, 22);
        Player jRand = new Player("Julius", "Randle", 86, 81, 88, 84, 5, 25);
        Player knox = new Player("Kevin", "Knox", 72, 71, 88, 89, 4, 22);
        Player dsj = new Player("Dennis", "Smith Jr", 79, 75, 83, 85, 6, 23);

        teams[19] = new Team("New York Knicks", rj, mRob, jRand, knox, dsj, 19);

        //thunder

        Player cp3 = new Player("Chris", "Paul", 85, 85, 85, 85, 10, 35);
        Player sg1 = new Player("Shai", "Gilgeous-Alexander", 84, 84, 92, 92, 7, 21);
        Player steveA = new Player("Steven", "Adams", 81, 87, 85, 88, 2, 26);
        Player galo = new Player("Danilo", "Gallinari", 87, 83, 87, 83, 7, 31);
        Player shroe = new Player("Dennis", "Schroder", 84, 77, 86, 80, 4, 26);

        teams[20] = new Team("Oklahoma City Thunder", cp3, sg1, steveA, galo, shroe, 20);

        //magic

        Player vuc = new Player("Nikola", "Vucevic", 86, 84, 88, 86, 7, 29);
        Player aGord = new Player("Aaron", "Gordon", 79, 77, 89, 85, 3, 24);
        Player moBamba = new Player("Mo", "Bamba", 76, 79, 91, 99, 4, 22);
        Player jIsaac = new Player("Jonathan", "Isaac", 82, 82, 91, 85, 7, 22);
        Player fultz = new Player("Markelle", "Fultz", 79, 78, 96, 92, 9, 22);

        teams[21] = new Team("Orlando Magic", vuc, aGord, moBamba, jIsaac, fultz, 21);

        //sixers

        Player embiid = new Player("Joel", "Embiid", 92, 89, 96, 93, 8, 26);
        Player benS = new Player("Ben", "Simmons", 93, 89, 98, 96, 9, 23);
        Player tobi = new Player("Tobias", "Harris", 86, 84, 89, 87, 4, 27);
        Player horf = new Player("Al", "Horford", 84, 86, 84, 90, 6, 42);
        Player jRich = new Player("Josh", "Richardson", 83, 84, 87, 87, 7, 26);

        teams[22] = new Team("Philadelphia 76ers", embiid, benS, tobi, horf, jRich, 22);

        //suns

        Player booker = new Player("Devin", "Booker", 91, 84, 97, 90, 10, 23);
        Player ayton = new Player("Deandre", "Ayton", 81, 83, 87, 90, 3, 21);
        Player oubre = new Player("Kelly", "Oubre", 79, 75, 85, 80, 8, 24);
        Player rrubio = new Player("Ricky", "Rubio", 76, 76, 80, 80, 4, 29);
        Player baynes = new Player("Aron", "Baynes", 78, 75, 81, 81, 7, 33);

        teams[23] = new Team("Phoenix Suns", booker, ayton, oubre, rrubio, baynes, 23);

        //blazers

        Player dame = new Player("Damian", "Lilliard", 94, 91, 96, 96, 10, 29);
        Player hWhite = new Player("Hassan", "Whiteside", 83, 84, 85, 90, 2, 30);
        Player cjM = new Player("CJ", "McCollum", 84, 83, 89, 88, 6, 28);
        Player nurk = new Player("Jusuf", "Nurkic", 78, 79, 84, 84, 4, 25);
        Player melo = new Player("Carmelo", "Anthony", 78, 74, 78, 74, 9, 36);

        teams[24] = new Team("Portland Trail Blazers", dame, hWhite, cjM, nurk, melo, 24);

        //kings

        Player dfox = new Player("Deaaron", "Fox", 85, 85, 93, 93, 7, 22);
        Player bags = new Player("Marvin", "Bagley III", 83, 81, 88, 88, 8, 21);
        Player buddy = new Player("Buddy", "Hield", 84, 82, 86, 86, 9, 27);
        Player rHolm = new Player("Richaun", "Holmes", 79, 81, 83, 83, 3, 26);
        Player barn = new Player("Harrison", "Barnes", 77, 77, 79, 79, 6, 28);

        teams[25] = new Team("Sacramento Kings", dfox, bags, buddy, rHolm, barn, 25);

        //spurs

        Player dRoz = new Player("Demar", "Derozan", 84, 84, 84, 84, 7, 30);
        Player ald = new Player("LaMarcus", "Aldridge", 82, 83, 87, 88, 5, 34);
        Player dMur = new Player("Dejonte", "Murray", 83, 82, 89, 91, 7, 23);
        Player dwite = new Player("Derrik", "White", 79, 81, 86, 89, 6, 25);
        Player gay = new Player("Rudy", "Gay", 83, 83, 83, 83, 8, 33);

        teams[26] = new Team("San Antonio Spurs", dRoz, ald, dMur, dwite, gay, 26);

        //raptors

        Player siak = new Player("Pascal", "Siakam", 89, 89, 92, 93, 9, 26);
        Player lowry = new Player("Kyle", "Lowry", 84, 86, 84, 86, 3, 34);
        Player fvv = new Player("Fred", "VanVleet", 84, 81, 87, 80, 8, 26);
        Player serge = new Player("Serge", "Ibaka", 80, 82, 80, 82, 6, 30);
        Player marc = new Player("Marc", "Gasol", 79, 79, 79, 79, 6, 35);

        teams[27] = new Team("Toronto Raptors", siak, lowry, fvv, serge, marc, 27);

        //jazz

        Player dmitch = new Player("Donovan", "Mitchell", 89, 91, 94, 94, 9, 23);
        Player corona = new Player("Rudy", "Gobert", 87, 93, 87, 97, 1, 27);
        Player bojan = new Player("Bojan", "Bogdanovic", 83, 82, 85, 83, 9, 31);
        Player jClark = new Player("Jordan", "Clarkson", 85, 83, 86, 80, 4, 27);
        Player mCon = new Player("Mike", "Conley", 78, 79, 78, 79, 8, 32);

        teams[28] = new Team("Utah Jazz", dmitch, corona, bojan, jClark, mCon, 28);

        //wizards

        Player beal = new Player("Bradley", "Beal", 92, 87, 94, 90, 9, 26);
        Player jWall = new Player("John", "Wall", 83, 85, 90, 91, 5, 29);
        Player bertans = new Player("Davis", "Bertans", 85, 75, 88, 80, 2, 27);
        Player rui = new Player("Rui", "Hachimura", 76, 75, 89, 85, 6, 22);
        Player bry = new Player("Thomas", "Bryant", 75, 73, 79, 80, 4, 22);

        teams[29] = new Team("Washington Wizards", beal, jWall, bertans, rui, bry, 29);

        //sorting

        for (int i = 0; i < 30; i++)
        {
            teams[i].sortByOvr();
        }
    }

    /**
     * sims the regular season
     */
    public void simSeason(boolean printDay)
    {
        //set up scanner input to get whether to print each day or sim to playoffs

        int day = 0;
        for (int i = 0; i < 58; i++)
        {
            if (printDay)
            {
                day = i + 1;
                System.out.println("day :" + day);
            }
            simDay(printDay);
        }
        ArrayList<Game> extra = remainingGames(printDay);
        int counter = 0;
        for (int i = 0; i <= extra.size() / 10; i++)
        {
            //System.out.println("day :" + day);
            //day++;
            for (int j = 0; j < 10; j++)
            {
                if (counter < extra.size())
                {
                    //System.out.println("Game between " + i  + " and " + 
                    //  j);
                    //System.out.println(extra.get(counter).play());
                    // counter++;
                }
            }
        }
        System.out.println("\nLeague MVP: " + getMVP().getFullName());
        summarizeSeason();

        Team winner = simPlayoffs();
        System.out.println(winner + " won the " + year + " championship!");
        System.out.println("Finals MVP: " + winner.getTeam()[0].getFullName());
    }

    /**
     * sims a single day in the regular season
     */
    public void simDay(boolean toPrint)
    {   
        for (int i = 0; i < 30; i++)
        {
            if(!teams[i].playedToday())
            {
                int j = findZero(i);
                if (j == -1)
                    j = findOne(i);
                if (j != -1)
                {
                    Game current = new Game(teams[i], teams[j]);
                    if (toPrint)
                    {
                        System.out.println(current.play());
                    }
                    else
                    {
                        current.play();
                    }
                    teams[i].setPlayedToday(true);
                    teams[j].setPlayedToday(true);

                }
            }
        }
        //end of day
        for (int i = 0; i < 30; i++)    
            teams[i].setPlayedToday(false);

    }

    /**
     * Finds the first team where
     * the opposition index is 0 
     * aka the first team that this has not played
     */
    public int findZero(int thisTeam)
    {
        int i = thisTeam;
        for (int j = 0; j < 30; j++)
        {
            if (!teams[j].playedToday() && teams[i].getPlayed()[teams[j].getID()] == 0 && (j != i))
            {
                return j;
            }
        }
        return -1;
    }

    /**
     * Finds the first team where
     * the opposition index is 1 
     * aka the first team that this has played only once
     */
    public int findOne(int thisTeam)
    {
        int i = thisTeam;
        for (int j = 0; j < 30; j++)
        {
            if (!teams[j].playedToday() && teams[i].getPlayed()[teams[j].getID()] == 1 && (j != i))
            {
                return j;
            }
        }
        return -1;
    }

    /**
     * Sorts the array of teams by the number of wins
     * in descending order
     * for playoff seeding etc
     * 
     */
    public void sortByWins()
    {
        for (int outer = 0; outer < teams.length; outer++)
        {
            int mindex = outer;
            for (int inner = outer + 1; inner < teams.length; inner++)
            {
                if (teams[inner].getWins() > teams[mindex].getWins())
                    mindex = inner;
            }
            Team temp = teams[outer];
            teams[outer] = teams[mindex];
            teams[mindex] = temp;
        }
    }

    /**
     * plays the remaining number of games needed 
     */
    public ArrayList<Game> remainingGames(boolean toPrint)
    {
        int day = 59;
        int games = 0;
        ArrayList<Game> extras = new ArrayList<Game>();
        for (int i = 0; i < 30; i++)
        {
            for (int j = 0; j < 30; j++)
            {
                if (teams[i].getPlayed()[teams[j].getID()] < 2 && (j != i))
                {
                    //System.out.println("Game between " + i  + " and " + 
                    //   j);
                    //today[i] = new Game(teams[i], teams[j]);
                    //System.out.println(today[i].play());
                    Game current = new Game(teams[i], teams[j]);
                    extras.add(current);
                    if (toPrint)
                        System.out.println(current.play());
                    else
                        current.play();
                    games++;
                    if (games == 10)
                    {
                        games = 0;
                        if (toPrint)
                            System.out.println("day: " + day);  
                        day++;
                    }
                }
            }
        }
        return extras;
    }

    /**
     * @return array the top 16 teams by wins
     * aka the teams making the playoffs
     * in order of wins
     */
    public Team[] getPlayoffTeams()
    {
        Team[] playoffTeams = new Team[16];
        sortByWins();
        for (int i = 0; i < 16; i++)
        {
            teams[i].setSeed(i + 1);
            playoffTeams[i] = teams[i];
        }
        return playoffTeams;
    }

    /**
     * Simulates the playoffs
     * 
     * @return the winner
     */
    public Team simPlayoffs()
    {
        Team winner = simRound(simRound(simRound(simRound(getPlayoffTeams()))))[0];
        return winner;
    }

    /**
     * sims the first round
     * @return array of teams that made it through
     * in order of seeding
     * 
     * @param t the teams remaining going into that round ranked by
     * seeding
     * 
     */
    public Team[] simRound(Team[] pTeams)
    {
        Team[] nextRound = new Team[pTeams.length / 2];

        if (nextRound.length == 8)
            System.out.println("\nround of 16\n");
        if (nextRound.length == 4)
            System.out.println("\nquarters\n");
        if (nextRound.length == 2)
            System.out.println("\nsemis\n");
        if (nextRound.length == 1)
            System.out.println("\nfinals\n");

        for (int i = 0; i < nextRound.length; i++)
        {
            PlayoffSeries current = new PlayoffSeries(pTeams[i], pTeams[pTeams.length - 1 - i]);
            nextRound[i] = current.playSeries();
        }
        return nextRound;
    }

    /**
     * Simulates the offseason for all the teams and players
     * and increases te year amount
     */
    public void simOffseason()
    {
        for (int i = 0; i < 30; i++)
        {
            teams[i].simOffseason();
            teams[i].setPlayedToday(false);            
        }
        year++;
    }

    /**
     * prints end of season stats including the record of every team
     */
    public void summarizeSeason()
    {
        sortByWins();
        System.out.println("");
        for (int i = 0; i < 30; i++)
        {
            System.out.println(teams[i]);
            if (i == 15)
                System.out.println("\n----Teams below did not make the playoffs----\n");
        }

        int maxdex = 0;
        for (int i = 0; i < 8; i++)
        {
            if ((teams[i].getTrueWinPct()/100) * (teams[i].getWinPct()/100) > (teams[maxdex].getTrueWinPct()/100) * (teams[maxdex].getWinPct()/100))
            {
                maxdex = i;
            }
        }
        System.out.println("The " + teams[maxdex].getName() + " are the favorites to win the NBA finals, " +
            "with a winning index of " + df.format((teams[maxdex].getTrueWinPct()/100) * (teams[maxdex].getWinPct()/100)) + ".");;
    }

    /**
     * finds the player that contributed the most to his team
     */
    public Player getMVP()
    {
        double[] calcs = new double[30];
        for (int i = 0; i < 30; i++)
        {
            calcs[i] = teams[i].getTeam()[0].getOvr() - teams[i].getTeamOvr();           
        }

        int maxdex = 0;
        for (int i = 0; i < 16; i++)
        {
            if (calcs[i] > calcs[maxdex])
            {
                maxdex = i;
            }
        }

        return teams[maxdex].getTeam()[0];
    }
    
    /**
     * @return int year
     */
    public int getYear()
    {
        return year;
    }

}


import java.util.Random;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Test
{
    public static void main(String args[]) throws IOException
    {
        int stratWins = 0;
        int randWins = 0;
        int cnt, cnte;

        System.out.println("Starting experimental...");

        for (int rep = 1; rep <= 3; rep++)
        {
            PrintWriter pw = new PrintWriter("experimentalResults" + rep + ".txt");
            for (cnt = 1; cnt <= 100000; cnt++)
            {
                System.out.println(cnt);
                switch (playExperimentalRound())
                {
                    case 0:
                        //System.out.println("The Strategy Player won round " + cnt + ".");
                        //pw.println("The Strategy Player won round " + cnt + ".");
                        stratWins++;
                        break;
                    case 1:
                        //System.out.print("The Random Player won round " + cnt + ".");
                        //pw.println("The Random Player won round " + cnt + ".");
                        randWins++;
                        break;
                    default:
                        System.out.println("Something went wrong.");
                }
            }

            // System.out.println("\nFINAL RESULTS:");
            pw.println("\nFINAL RESULTS:");
            // System.out.println("\tSTRATEGY WINS: " + stratWins);
            pw.println("\tSTRATEGY WINS: " + stratWins);
            // System.out.println("\tRANDOM WINS: " + randWins);
            pw.println("\tRANDOM WINS: " + randWins);

            pw.close();
	        System.out.println("Experimental end.");
        }

        System.out.print("control start");
        for (int repe = 1; repe <= 3; repe++)
        {
            PrintWriter pwr = new PrintWriter("controlResults" + repe + ".txt");
            for (cnte = 1; cnte <= 100000; cnte++)
            {
                System.out.println(cnte);
                switch (playControlRound())
                {
                    case 0:
                        //System.out.println("The Strategy Player won round " + cnt + ".");
                        //pwr.println("The Strategy Player won round " + cnte + ".");
                        stratWins++;
                        break;
                    case 1:
                        //System.out.print("The Random Player won round " + cnt + ".");
                        //pwr.println("The Random Player won round " + cnte + ".");
                        randWins++;
                        break;
                    default:
                        System.out.println("Something went wrong.");
                }

            }

            // System.out.println("\nFINAL RESULTS:");
            pwr.println("\nFINAL RESULTS:");
            // System.out.println("\tSTRATEGY WINS: " + stratWins);
            pwr.println("\tSTRATEGY WINS: " + stratWins);
            // System.out.println("\tRANDOM WINS: " + randWins);
            pwr.println("\tRANDOM WINS: " + randWins);

            pwr.close();
        }
    }

    public static boolean hasEnded(Board b)
    {
        if (b.getLines()[0] + b.getLines()[1] + b.getLines()[2] + b.getLines()[3] <= 0)
        {
            return true;
        }
        return false;
    }

    public static int playExperimentalRound()
    {
        Board b = new Board();
        NimBot bot = new NimBot(b);
        do
        {
            bot.makeStrategicMove();
            if (hasEnded(b))
                return 1;     
            bot.makeRandomMove();
        }
        while(!hasEnded(b));

        return 0;
    }

    public static int playControlRound()
    {
        Board b = new Board();
        NimBot bot = new NimBot(b);

        do
        {
            bot.makeRandomMove();
            if (hasEnded(b))
                return 1;     
            bot.makeRandomMove();
        }
        while(!hasEnded(b));

        return 0;
    }
}

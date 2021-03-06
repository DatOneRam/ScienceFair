import java.util.Arrays;
import java.io.*;

public class Test
{
    public static void main(String args[]) throws IOException
    {
        int cnt = 0;
        int trial = 3;
        int[] results = new int[10000];
        //PrintWriter pw = new PrintWriter("ExperimentalResults3.txt");

        while (cnt < results.length)
        {
             Board b = new Board();
             NimBot strat = new NimBot(b, 1);
             NimBot noStrat = new NimBot(b, 2);
             b.setPlayers(strat, noStrat);
            results[cnt] = b.playSFRound();
            //System.out.println("Done! Player " + results[cnt] + " won!");
            System.out.println("Round " + (cnt + 1) + " of Experimental Trial " + trial + " complete! Player" + results[cnt] + " won!");
            cnt++;
        }

        //pw.println(Arrays.toString(results));
        //pw.close();

        //uncomment to get in a text file
        //System.out.println("Program Complete! A text file with the results has been created.");

    }
}
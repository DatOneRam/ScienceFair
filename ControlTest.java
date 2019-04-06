import java.util.Arrays;
import java.io.*;

public class ControlTest
{
    public static void main(String args[]) throws IOException
    {
        int cnt = 0;
        int trial = 3;
        int[] results = new int[10000];
        //PrintWriter pw = new PrintWriter("ControlResults3.txt");

        while (cnt < results.length)
        {
             Board b = new Board();
             NimBot strat = new NimBot(b, 1);
             NimBot noStrat = new NimBot(b, 2);
             b.setPlayers(strat, noStrat);
            results[cnt] = b.playSFRoundControl();
            //System.out.println("Done! Player " + results[cnt] + " won!");
            System.out.println("Round " + (cnt + 1) + " of Control Group Trial " + trial + " complete! Player" + results[cnt] + " won!");
            cnt++;
        }

        /*pw.println(Arrays.toString(results));
        pw.close();

        System.out.println("Program Complete! The restults have been saved to a text file.");*/
    }
}
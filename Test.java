import java.util.Arrays;

public class Test
{
    public static void main(String args[])
    {
        int cnt = 0;
        int[] results = new int[10000];

        while (cnt < results.length)
        {
            Board b = new Board();
             NimBot strat = new NimBot(b, 1);
             NimBot noStrat = new NimBot(b, 2);
             b.setPlayers(strat, noStrat);
            results[cnt] = b.playSFRound();
            //System.out.println("Done! Player " + results[cnt] + " won!");
            System.out.println(cnt + 1 + " complete! Player" + results[cnt] + " won!");
            cnt++;
        }

        System.out.println(Arrays.toString(results));
    }
}
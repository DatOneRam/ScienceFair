import java.util.Arrays;

public class UntilRandWins
{
    public static void main(String[] args)
    {
        int test = 2;
        int cnt = 0;
        do
        {
            test = playVerboseExperimentalRound();
            cnt++;
        }
        while (test != 1);

        System.out.println("It took " + cnt + " tries for Random to win.");
    }

    public static int playVerboseExperimentalRound()
    {
        Board b = new Board();
        NimBot bot = new NimBot(b);
        do
        {
            bot.makeStrategicMove();
            System.out.println("Strat's Move: " + Arrays.toString(b.getLines()));
            if (b.hasEnded())
            {
                System.out.println('\n');
                return 1;    
            }
            bot.makeRandomMove();
            System.out.println("Random's Move:" + Arrays.toString(b.getLines()));
        }
        while(!b.hasEnded());

        System.out.println('\n');
        return 0;
    }
}
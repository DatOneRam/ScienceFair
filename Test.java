public class Test
{
    public static void main(String args[])
    {
        Board b = new Board();
        NimBot strat = new NimBot(b);
        NimBot noStrat = new NimBot(b);
        int cnt, stratWins = 0, noStratWins = 0;

        for (cnt = 1; cnt <= 10000; cnt++)
        {
            do
            {
                strat.makeStrategicMove();
                if (b.isFinished())
                    break;
                noStrat.makeRandomMove();
            }
            while (!b.isFinished());
        }
    }
}
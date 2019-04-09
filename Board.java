public class Board
{
    private int[] lines = {1, 3, 5, 7};

    public int[] getLines()
    {
        return lines;
    }
    public void setLines(int[] x)
    {
        for (int i = 0; i < x.length; i++)
        {
            if (x[i] < 0)
                x[i] = 0;
        }
        lines = copy(x);
    }    

    public void take(int line, int cnt)
    {
        lines[line - 1] -= cnt;
    }

    public int getXORSum()
    {
        return lines[0] ^ lines[1] ^ lines[2] ^ lines[3];
    }

    public boolean hasEnded()
    {
        if (lines[0] + lines[1] + lines[2] + lines[3] <= 0)
        {
            return true;
        }
        return false;
    }

    public int playRound()
    {
        Board b = new Board();
        NimBot strat = new NimBot(b);
        NimBot rand = new NimBot(b);
        do
        {
            strat.makeStrategicMove();
            if (hasEnded())
                return 0;     
            strat.makeRandomMove();
        }
        while(!hasEnded());

        return 1;
    }

    public int[] copy(int[] y)
    {
        int[] z = new int[y.length];
        for (int i = 0; i < y.length; i++)
            z[i] = y[i];

        return z;

    }
}
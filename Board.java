import java.nio.IntBuffer;

public class Board
{
    private int[] lines = {1, 3, 5, 7};

    public int[] getLines()
    {
        return lines;
    }
    public void setLines(int[] x)
    {
        lines = x;
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
        if (lines[0] + lines[1] + lines[2] + lines[3] < 0)
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
}
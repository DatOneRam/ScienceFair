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
        if (lines[0] + lines[1] + lines[2] + lines[3] == 0)
        {
            return true;
        }
        return false;
    }

    public int playRound()
    {
        NimBot strat = new NimBot(this);
        NimBot rand = new NimBot(this);
        do
        {
            strat.makeStrategicMove();
            if (hasEnded())
                return 0;     
            rand.makeRandomMove();
        }
        while(!hasEnded());

        return 1;
    }
}
import java.util.ArrayList;

public class Board
{
    //holds all the line's units and whose turn it is
    private int[] position = {1, 3, 5, 7, 0};

    //method to get the position
    public int[] getPosition()
    {
        return position;
    }

    //method to set the position
    public void setPosition(int[] x)
    {
        position = x;
    }

    //method to get whose player its turn it is
    public int getPlayer()
    {
        return position[4];
    }

    public boolean hasEnded()
    {
        if (position[0] == 0 && position[1] == 0 && position[2] == 0 && position[3] == 0)
            return true;
        else
            return false;
    }

    //method to get all the possible positions you could get by taking one from a heap
    public ArrayList<int[]> getSimpleMoves()
    {
        ArrayList<int[]> x = new ArrayList<int[]>();

        for (int i = 0; i < 4; i++)
        {
            x.add(copy(position));
            x.get(i)[i] = position[i] - 1;
            x.get(i)[4] = toggle(x.get(i)[4]);
            if (x.get(i)[i] < 0)
                x.get(i)[i] = 0;
        }

        //resize(x);

        x.trimToSize();

        return x;
    }

    //method to get all possible moves
    public ArrayList<int[]> getMoves()
    {
        ArrayList<int[]> x = new ArrayList<int[]>();
        int j = 0, i = 1;

        x.add(0, copy(position));
        do
        {
            x.add(i, position);
            if (x.get(i-1)[j] == 0)
                j++;
            x.get(i)[j] = x.get(i-1)[j] - 1;
            i++;
            if (x.get(i-1)[j] == 0)
            {
                j++;
                if (j == 4)
                {
                    break;
                }
            }
            
        }
        while(x.get(i - 1)[j] != 0);

        x.trimToSize();

        for (int r = 0; r < x.size(); r++)
        {
            x.get(r)[4] = toggle(x.get(r)[4]);
        }

        x.remove(0);
        //resize(x);


        return x;
    }

    //method to get a list of all winning moves you can make
    public ArrayList<int[]> getGoodMoves()
    {
        ArrayList<int[]> g = getMoves();
        for (int i = 0; i < g.size(); i++)
        {
            if (XORSum(g.get(i)) != 0)
            {
                g.remove(i);
            }
        }

        return g;
    }

    //method to get the xor sum
    public int XORSum(int[] k)
    {
        return (k[0] ^ k[1] ^ k[2] ^ k[3]);
    }

    //method to trim an ArrayList to good stuff
    public void resize(ArrayList<int[]> x)
    {
        int[] check = {0,0,0,0,0};
        int[] check1 = {0,0,0,0,1};
        for (int i = 0; i < x.size(); i++)
        {
            if (sameAs(x.get(i), check) || sameAs(x.get(i), check1))
            {
                x.remove(i);
            }
        }
    }

    public int toggle(int a)
    {
        int ret;
        if (a == 1)
            ret = 0;
        else
            ret = 1;

        return ret;
    }

    public int[] copy(int[] y)
    {
        int[] z = new int[y.length];
        for (int i = 0; i < y.length; i++)
            z[i] = y[i];

        return z;

    }

    public boolean sameAs(int[] y, int[] z)
    {
        if (y.length != z.length)
        {
            return false;
        }

        for (int i = 0; i < y.length; i++)
        {
            if (y[i] != z[i])
                return false;
        }

        return true;
    }

    public int playRound()
    {
        NimBot strat = new NimBot(this);
        NimBot rand = new NimBot(this);

        do
        {
            strat.makeStrategicMove();
            if (hasEnded())
                break;
            rand.makeRandomMove();
        }
        while (!hasEnded());

        return getPlayer();
    }
}
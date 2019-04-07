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


    //method to get all the possible positions you could get by taking one from a heap
    public ArrayList<int[]> getSimpleMoves()
    {
        ArrayList<int[]> x = new ArrayList<int[]>(4);

        for (int i = 0; i < x.size(); i++)
        {
            x.add(copy(position));
            x.get(i)[i] = position[i] - 1;
            x.get(i)[4] = toggle(x.get(i)[4]);
            if (x.get(i)[i] < 0)
                x.get(i)[i] = 0;
        }

        //resize(x);

        return x;
    }

    //method to get all possible moves
    public ArrayList<int[]> getMoves()
    {
        ArrayList<int[]> x = new ArrayList<int[]>(100);
        int j = 0, i = 1;

        x.add(0, copy(position));
        while (x.get(i - 1)[j] != 0)
        {
            x.add(i, copy(position));
            x.get(i)[4] = toggle(x.get(i)[4]);
            x.set(i, copy(position));
            x.get(i)[j] = x.get(i-1)[j] - 1;
            i++;
            if (x.get(i-1)[j] == 0)
            {
                j++;
            }
            
        }

        for (int r = 0; r < x.size(); r++)
        {
            x.get(r)[4] = toggle(x.get(r)[4]);
        }

        x.remove(0);
        //resize(x);

        return x;
    }

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

    // public void resize(int[][] x)
    // {
    //     int[] checkZero = {0,0,0,0,0};
    //     int[] checkFull = {}
    //     int[x.length][x[1].length] y;
    //     for (int i = 0; i < x.length; i++)
    //     {
    //         if (sameAs(x[i], check))
    //         {zz zz
    //             break;

    //         }
    //     }
    // }
}
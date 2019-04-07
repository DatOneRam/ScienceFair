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
    public int[][] getSimpleMoves()
    {
        int[][] x = new int[4][5];

        for (int i = 0; i < 4; i++)
        {
            x[i] = copy(position);
            x[i][i] = position[i] - 1;
            x[i][4] = toggle(x[i][4]);
            if (x[i][i] < 0)
                x[i][i] = 0;
        }

        return x;
    }

    public int[][] getMoves()
    {
        int[][] x = new int[100][5];
        int j = 0, i = 1;

        x[0] = copy(position);
        while (x[i-1][j] != 0)
        {
            x[i][4] = toggle(x[i][4]);
            x[i] = copy(position);
            x[i][j] = x[i-1][j] - 1;
            i++;
            if (x[i-1][j] == 0)
            {
                j++;
            }
        }

        x[0][0] = 0;
        x[0][1] = 0;
        x[0][2] = 0;
        x[0][3] = 0;
        x[0][4] = 0;

        return x;
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
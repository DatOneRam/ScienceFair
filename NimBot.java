import java.util.Arrays;
import java.util.Random;

public class NimBot
{
    private Board b;

    public NimBot(Board board)
    {
        b = board;
    }

    public void makeStrategicMove()
    {
        if (b.getXORSum() == 0)
        {
            makeSimpleMove();
        }
        else
        {
            //temp is same as lines
            int[] temp = copy(b.getLines());
            int j = 0;
            do
            {
                //if you can take some, take some and check to see if good
                if (temp[j] > 0)
                {
                    temp[j]--;
                    if (getXORSum(temp) == 0)
                    {
                        b.setLines(temp);
                        break;
                    }
                }
                //if you cant take some, reset and check next lines
                else
                {
                    temp = copy(b.getLines());
                    j++;
                    continue;
                }
            }
            while (j < 4);
        }
    }

    public void makeSimpleMove()
    {
        int[] temp = copy(b.getLines());
        for (int i = 1; i < temp.length; i++)
        {
            if (temp[i] != 0)
            {
                b.take(i, 1);
                break;
            }
        }
    }

    public void makeRandomMove()
    {
        int[] temp = copy(b.getLines());
        Random rand = new Random();
        int line = 0;
        do
        {
            line = rand.nextInt(4);
        }
        while (temp[line] > 0);
        b.take(line + 1, rand.nextInt(temp[line]) + 1);
    }

    public int getXORSum(int[] a)
    {
        //sSystem.out.println(a[0] ^ a[1] ^ a[2] ^ a[3]);
        return a[0] ^ a[1] ^ a[2] ^ a[3];
    }

    public int[] copy(int[] y)
    {
        int[] z = new int[y.length];
        for (int i = 0; i < y.length; i++)
            z[i] = y[i];

        return z;

    }
}
import javax.lang.model.util.ElementScanner6;

public class StrategyBot
{
    private int[] line = new int[5];
    private Board field;

    public StrategyBot(Board f)
    {
        line[0] = 0;
        line[1] = field.getLineOne();
        line[2] = field.getLineTwo();
        line[3] = field.getLineThree();
        line[4] = field.getLineFour();

        field = f;
    }

    public void refreshLines()
    {
        line[1] = field.getLineOne();
        line[2] = field.getLineTwo();
        line[3] = field.getLineThree();
        line[4] = field.getLineFour();
    }

    public int getXORSum()
    {
        return line[1] ^ line[2] ^ line[3] ^ line[4];
    }

    public String toByteAsString(int x)
    {
        return (byte)x + "";
    }

    public int getGroupToRemove(String b)
    {
        if (b.substring[7] == '1')
        {
            return 1;
        }
        else if (b.substring[6] == '1')
        {
            return 2;
        }
        else if (b.substring[5] == '1')
        {
            return 3;
        }
        else
        {
            return 0;
        }
    }

    public int getFirstLineWithGroup(int x)
    {
        int i;
        for (i = 1; i <= 4; i++)
        {
            if (line[i] - x >= 0)
                return i;
        }

        return -1;
    }

    public void makeStrategicMove()
    {
        int amount, line;
        
        refreshLines();
        amount = getGroupToRemove(toByteAsString(getXORSum()));
        line = getFirstLineWithGroup(amount);

        field.take(amount, line);
    }
}

import java.util.Arrays;

public class StrategyBot
{
    private int[] line = new int[5];
    private Board field;

    public StrategyBot(Board f)
    {
        line[0] = 0;
        field = f;
        line[1] = field.getLineOne();
        line[2] = field.getLineTwo();
        line[3] = field.getLineThree();
        line[4] = field.getLineFour();
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
        refreshLines();
        return line[1] ^ line[2] ^ line[3] ^ line[4];
    }

    public int[] getXORByte()
    {
        refreshLines();
        int[] groups = new int[3];

        if (getXORSum() == 1)
        {
            //001
            groups[2] = 1;
        }
        else if (getXORSum() == 2)
        {
            //010
            groups[1] = 1;
        }
        else if (getXORSum() == 3)
        {
            //011
            groups[2] = 1;
            groups[1] = 1;
        }
        else if (getXORSum() == 4)
        {
            //100
            groups[0] = 1;
        }
        else if (getXORSum() == 5)
        {
            //101
            groups[0] = 1;
            groups[2] = 1;
        }
        else if (getXORSum() == 6)
        {
            //110
            groups[0] = 1;
            groups[1] = 1;
        }
        else if (getXORSum() == 7)
        {
            //111
            groups[0] = 1;
            groups[1] = 1;
            groups[2] = 1;
        }

        return groups;
    }

    public int findFirstLineWithGroup(int x)
    {
        refreshLines();
        int cnt = 0, lineNum = 0;

        if (x == 1)
        {
            for (cnt = 1; cnt <= 4; cnt++)
            {
                if (line[cnt] % 2 == 1)
                    lineNum = cnt;
            }
        }

        else if (x == 2)
        {
            for (cnt = 1; cnt <= 4; cnt++)
            {
                if (line[cnt] - 4 > 0 && (line[cnt] - 4) % 2 == 0)
                {
                    lineNum = cnt;
                }
            }
        }

        else if (x == 4)
        {
            for (cnt = 1; cnt <= 4; cnt++)
            {
                if (line[cnt] - 4 >= 0)
                    lineNum = cnt;
            }
        }

        return lineNum;
    }

    public void makeMove(int ln, int nm)
    {
        refreshLines();
        field.take(ln, nm);
    }

    public void makeStrategicMove()
    {
        refreshLines();
        int[] groups = getXORByte();
        int cnt, firstGroup = 0, lastGroup = 0;
        if (isGroup(getXORSum()))
            makeMove(findFirstLineWithGroup(getXORSum()), getXORSum());
        else if (findFirstLineWith(getXORSum()) != 0 && getXORSum() != 0)
            makeMove(findFirstLineWith(getXORSum()), getXORSum());
        else if (findFirstLineWith(getXORSum()) == 0 && getXORSum() != 0)
        {
            for (cnt = 0; cnt < groups.length; cnt++)
            {
                if (groups[cnt] == 1)
                {
                    firstGroup = getCntToGroup(cnt);
                    break;
                }
            }

            for (cnt = 0; cnt < groups.length; cnt++)
            {
                if(groups[cnt] == 1)
                    lastGroup = getCntToGroup(cnt);
            }

            makeMove(findFirstLineWithGroup(firstGroup), lastGroup);
        }
        else
        {
            for (cnt = 1; cnt < line.length; cnt++)
            {
                if (line[cnt] != 0)
                    makeMove(cnt, 1);
            }
        }
    }

    public int findFirstLineWith(int x)
    {
        int cnt;
        for (cnt = 1; cnt < line.length; cnt++)
        {
            if (line[cnt] - x >= 0)
                return cnt;
        }

        return 0;
    }

    public int getCntToGroup(int cnt)
    {
        int marker = cnt;

        switch (marker)
        {
            case 0:
                marker = 4;
                break;
            case 1:
                marker = 2;
                break;
            case 2:
                marker = 1;
                break;
            default:
                marker = 0;
        }

        return marker;
    }

    public boolean isGroup(int x)
    {
        boolean bool = false;

        switch (x)
        {
            case 1:
            case 2:
            case 4:
                bool = true;
                break;
        }

        return bool;
    }
}

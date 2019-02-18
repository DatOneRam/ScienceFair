import sun.font.TrueTypeGlyphMapper;

public class Board
{
    private int line[];

    public Board()
    {
        line[1] = 1;
        line[2] = 3;
        line[3] = 5;
        line[4] = 7;
    }

    public int take(int howMany, int lineChosen)
    {
        int success = 1;

        switch (lineChosen)
        {
            case 1:
                line[1] -= howMany;
                break;
            case 2:
                line[2] -= howMany;
                break;
            case 3:
                line[3] -= howMany;
                break;
            case 4:
                line[4] -= howMany;
                break;
            default:
                success = 0;
        }

        return success;
    }

    public boolean isFinished()
    {
        int i;

        for (i = 1; i <= 4; i++)
        {
            if (line[i] != 0)
                return false;
        }

        return true;
    }
    
    public int getLineOne()
    {
        return line[1];
    }

    public int getLineTwo()
    {
        return line[2];
    }

    public int getLineThree()
    {
        return line[3];
    }

    public int getLineFour()
    {
        return line[4];
    }
}
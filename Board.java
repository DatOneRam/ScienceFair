public class Board
{
    private int line[] = new int[5];

    public Board()
    {
        line[0] = 0;
        line[1] = 1;
        line[2] = 3;
        line[3] = 5;
        line[4] = 7;
    }

    public void take(int lineChosen, int howMany)
    {
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
                System.out.println("INVALID LINE");
        }
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

    public void display()
    {
        int cnt, cnt2;

        for (cnt = 1; cnt <= line.length - 1; cnt++)
        {
            for (cnt2 = 1; cnt2 == line[cnt]; cnt2++)
            {
                System.out.print("| ");
            }
            System.out.println('\n');
        }
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

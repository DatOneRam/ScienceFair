import java.util.Random;

public class NimBot
{
    private int[] line = new int[5];
    private Board field;
    private int playerNumber;

    public NimBot(Board f, int p)
    {
        line[0] = 0;
        field = f;
        playerNumber = p;
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
            for (cnt = 1; cnt < line.length; cnt++)
            {
                if (line[cnt] % 2 == 1 || line[cnt] == 1)
                    lineNum = cnt;
            }
        }

        else if (x == 2)
        {
            for (cnt = 1; cnt < line.length; cnt++)
            {
                if (line[cnt] != 0)
                {
                    if ((line[cnt] - 4) / 2.0 >= 1.0 && (line[cnt] != 4))
                    {
                        lineNum = cnt;
                    }
                    else if ((line[cnt] / 2.0) >= 1.0 && line[cnt] < 4)
                    {
                        lineNum = cnt;
                    }
                }
            }
        }

        else if (x == 4)
        {
            for (cnt = 1; cnt < line.length; cnt++)
            {
                if (line[cnt] - 4 >= 0)
                    lineNum = cnt;
            }
        }

        return lineNum;
    }

    public void makeMove(int ln, int nm, int bob)
    {
        refreshLines();
        field.take(ln, nm, bob);
    }

    public int[] getGroups()
    {
        refreshLines();
        int sum = getXORSum(), firstGroup = 0, secondGroup = 0, lastGroup = 0;

        if (sum == 1)
        {
            firstGroup = 1;
        }
        else if (sum == 2)
        {
            firstGroup = 2;
        }
        else if (sum == 3)
        {
            firstGroup = 2;
            secondGroup = 1;
        }
        else if (sum == 4)
        {
            firstGroup = 4;
        }
        else if (sum == 5)
        {
            firstGroup = 4;
            lastGroup = 1;
        }
        else if (sum == 6)
        {
            firstGroup = 4;
            lastGroup = 2;
        }
        else if (sum == 7)
        {
            firstGroup = 4;
            secondGroup = 2;
            lastGroup = 1;
        }

        int[] rt = {firstGroup, secondGroup, lastGroup};
        return rt;
    }

    public int findFirstLineThats(int x)
    {
        for (int cnt = 1; cnt < line.length; cnt++)
        {
            if (line[cnt] == x)
                return cnt;
        }

        return 0;
    }

    public void makeStrategicMove()
    {
        refreshLines();
        int[] rt = getGroups();
         
       if (numberOfLines() == 1 && findFirstLineThats(1) != 0)
       {
           makeMove(findFirstLineThats(1), 1, playerNumber);
       }
       else if (getXORSum() == 0)
       {
           makeRandomStratMove();
       }
       else if (numberOfLines() == 2 && findFirstLineThatsNot(1) == 0)
       {
           makeMove(findFirstLineWith(1), 1, playerNumber);
       }
       else if (numberOfLines() == 2 && thereAre(1, 1))
       {
           makeMove(findFirstLineThatsNot(1), line[findFirstLineThatsNot(1)], playerNumber);
       }
       else if (numberOfLines() == 2)
       {
            makeMove(findLargestLine(), line[findLargestLine()] - line[findSmallestLine()], playerNumber);
       }
       else if (numberOfLines() == 3 && thereAre(2, 1))
       {
           makeMove(findFirstLineThatsNot(1), line[findFirstLineThatsNot(1)] - 1, playerNumber);
       }
       else if (numberOfLines() == 3 && howManyAreSame()[0] == 2)
       {
            makeMove(findFirstLineThatsNot(howManyAreSame()[1]), line[findFirstLineThatsNot(howManyAreSame()[1])], playerNumber);
       }
       else if (getXORSum() == 7 && findLargestLineValue() == 5)
       {
            makeMove(findFirstLineWith(5), 3, playerNumber);
       }
       else if (getXORSum() == 7)
       {
            makeMove(findLargestLine(), 5, playerNumber);
       }
       else if (numberOfLines() == 3 && findFirstLineWith(7) != 0)
       {
           makeMove(findFirstLineWith(7), getXORSum(), playerNumber);
       }
       else
       {
           if (getXORSum() == 1)
           {
                makeMove(findFirstLineWithGroup(rt[0]), rt[0], playerNumber);
           }
           else
           {
                if (findFirstLineWithGroups(getGroups()) != 0)
                {
                    makeMove(findFirstLineWithGroups(getGroups()), getXORSum(), playerNumber);
                }
                else
                {
                    makeMove(findFirstLineWithGroup(rt[0]), rt[1] + rt[2], playerNumber);  
                }
           }
       }
    }

    public void makeRandomMove()
    {
        refreshLines();
        int linex, amount;
        Random rand = new Random();
        do
        {
            linex = rand.nextInt(4) + 1;
        }
        while(line[linex] <= 0);
        amount= rand.nextInt(line[linex]) + 1;
        
        makeMove(linex, amount, playerNumber);
    }

    public void makeRandomStratMove()
    {
        refreshLines();
        int linex;
        Random rand = new Random();
        do
        {
            linex = rand.nextInt(4) + 1;
        }
        while(line[linex] <= 0);
        
        makeMove(linex, 1, playerNumber);
    }

    public int findFirstLineThatsGreaterThan(int x)
    {
        for (int cnt = 0; cnt < line.length; cnt++)
        {
            if (line[cnt] > 0)
                return cnt;
        } 
        
        return 0;
    }

    public int findFirstLineWith(int x)
    {
        refreshLines();
        int cnt, ret = 0;

        for (cnt = 1; cnt < line.length; cnt++)
        {
            if (line[cnt] - x >= 0)
            {
                ret = cnt;
                break;
            }

        }
            return ret;
    }

    public int findFirstLineWithGroups(int[] request)
    {
        refreshLines();
        int linea = 0;
        for (int cnt = 1; cnt < line.length; cnt++)
        {
            if (findFirstLineWith(request[0]) != 0)
            {
                if (line[findFirstLineWith(request[0])] - request[0] - request[1] >= 0)
                {
                    if (line[findFirstLineWith(request[0])] - request[0] - request[1] - request[2] >= 0)
                        linea = findFirstLineWith(request[0]);
                }
            }
        }

        return linea;
    }


    public int numberOfLines()
    {
        refreshLines();
        int sum = 0;
        for (int cnt = 1; cnt < line.length; cnt++)
        {
            if (line[cnt] > 0)
            {
                sum++;
            }
        }

        return sum;
    }

    public int firstLineOpen()
    {
        refreshLines();
        for (int cnt = 1; cnt <= 4; cnt++)
        {
            if (line[cnt] != 0)
                return cnt;
        }

        return 0;
    }

    public void state()
    {
        refreshLines();
        field.display();
        System.out.println(getXORSum());
    }

    public int findLargestLine()
    {
        refreshLines();
        int l = 0, c = 0;
        for (int cnt = 1; cnt < line.length; cnt++)
        {
            if (line[cnt] > l)
            {
                c = cnt;
            }
        }
        return c;
    }

    public int findLargestLineValue()
    {
        refreshLines();
        int l = 0;
        for (int cnt = 1; cnt < line.length; cnt++)
        {
            if (line[cnt] > l)
            {
                l = line[cnt];
            }
        }
        return l;
    }

    public int findSmallestLine()
    {
        refreshLines();
        int l = 7, c = 0;
        for (int cnt = 1; cnt < line.length; cnt++)
        {
            if (line[cnt] < l && line[cnt] > 0)
            {
                l = line[cnt];
                c = cnt;
            }
        }
        return c;
    }

    public void go()
    {
        refreshLines();
        makeStrategicMove();
        state();
    }

    public boolean thereAre(int howMany, int num)
    {
        refreshLines();
        int hhm = 0;
        for (int cnt = 1; cnt < line.length; cnt++)
        {
            if (line[cnt] == num)
            {
                hhm++;
            }
        }

        if (hhm == howMany)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public int findFirstLineThatsNot(int x)
    {
        refreshLines();
        for (int cnt = 1; cnt < line.length; cnt++)
        {
            if (line[cnt] != x && line[cnt] != 0)
            {
                return cnt;
            }
        }

        return 0;
    }

    public int[] howManyAreSame()
    {
        refreshLines();
        int same[] = {0,0};

        for (int cnt = 1; cnt < line.length; cnt++)
        {
            for (int cntTwo = (cnt + 1); cntTwo <= 4; cntTwo++)
            {
                if (line[cnt] == line[cntTwo] && line[cnt] != 0)
                {
                    same[0]++;
                    same[1] = line[cnt];
                }
            }
        }

        for (int cnt = 4; cnt > 0; cnt--)
        {
            for (int cntTwo = (cnt - 1); cntTwo > 0; cntTwo--)
            {
                if (line[cnt] == line[cntTwo] && line[cnt] != 0)
                {
                    same[0]++;
                    same[1] = line[cnt];
                }
            }
        }

        return same;
    }
}

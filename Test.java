import java.util.ArrayList;
import java.util.Arrays;

public class Test
{
    public static void main(String[] args)
    {
        Board board = new Board();
        int rounds = 0;
        int randWins = 0;
        int stratWins = 0;
        int tempWin;
        do
        {
            tempWin = board.playRound();
            if (tempWin == 0)
                stratWins++;
            else
                randWins++;
        }
        while (rounds <= 10000);

        System.out.println("StratWins: " + stratWins);
        System.out.println("RandWins: " + randWins);
    }
}
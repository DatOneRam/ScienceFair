import java.util.ArrayList;
import java.util.Arrays;

public class Testing
{
    public static void main(String args[])
    {
        Board board = new Board();
        NimBot rand = new NimBot(board);
        NimBot strat = new NimBot(board);
        ArrayList<int[]> x = board.getGoodMoves();
        ArrayList<int[]> y = board.getMoves();

        for (int j = 0; j < y.size(); j++)
        {
            System.out.println("Move: " + Arrays.toString(y.get(j)));
        }
    }
}
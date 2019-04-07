import java.util.ArrayList;
import java.util.Arrays;

public class Test
{
    public static void main(String[] args)
    {
        Board board = new Board();
        ArrayList<int[]> simple = board.getSimpleMoves();
        ArrayList<int[]> moves = board.getMoves();

        for (int i = 0; i < moves.size(); i++)
        {
            System.out.println(Arrays.toString(moves.get(i)));
        }
    }
}
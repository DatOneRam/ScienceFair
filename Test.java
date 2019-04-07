import java.util.Arrays;

public class Test
{
    public static void main(String[] args)
    {
        Board board = new Board();
        int[][] simple = board.getSimpleMoves();
        int[][] moves = board.getMoves();

        for (int i = 0; i < 100; i++)
        {
                System.out.println(Arrays.toString(moves[i]));
        }
    }
}
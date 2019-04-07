import java.util.ArrayList;
import java.util.Random;

public class NimBot
{
    private Board board;

    public NimBot(Board b)
    {
        board = b;
    }

    public void makeStrategicMove()
    {
        ArrayList<int[]> goodMoves = board.getGoodMoves();
        ArrayList<int[]> simpleMoves = board.getSimpleMoves();
        Random rand = new Random();
        int[] move;
        if (goodMoves.size() != 0)
        {
            move = goodMoves.get(rand.nextInt(goodMoves.size()));
        }
        else
        {
            move = simpleMoves.get(rand.nextInt(simpleMoves.size()));
        }
        board.setPosition(move);
    }

    public void makeRandomMove()
    {
        ArrayList<int[]> moves = board.getMoves();
        Random rand = new Random();
        int[] move = moves.get(rand.nextInt(moves.size()));
        board.setPosition(move);
    }
}
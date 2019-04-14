import java.util.Arrays;

public class TestRand
{
    public static void main(String[] args)
    {
        Board b = new Board();
        NimBot rand = new NimBot(b);
        rand.makeRandomMove();
        System.out.println(Arrays.toString(b.getLines()));

        // for (int i = 0; i < 20; i++)
        // {
        //     b = new Board();
        //     rand.makeRandomMove();
        //     System.out.println(Arrays.toString(b.getLines()));
        // }
    }
}
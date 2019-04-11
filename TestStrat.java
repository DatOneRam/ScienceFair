import java.util.Arrays;

public class TestStrat
{
    public static void main(String[] args)
    {
        //note, will hang if match finishes early. just stop the code running and continue with your life
        Board b = new Board();
        NimBot bot = new NimBot(b);
        System.out.println(Arrays.toString(b.getLines()));
        bot.makeStrategicMove();
        System.out.println(Arrays.toString(b.getLines()));
        bot.makeRandomMove();
        System.out.println(Arrays.toString(b.getLines()));
        bot.makeStrategicMove();
        System.out.println(Arrays.toString(b.getLines()));
        bot.makeRandomMove();
        System.out.println(Arrays.toString(b.getLines()));
        bot.makeStrategicMove();
        System.out.println(Arrays.toString(b.getLines()));
        bot.makeRandomMove();
        System.out.println(Arrays.toString(b.getLines()));
        bot.makeStrategicMove();
        System.out.println(Arrays.toString(b.getLines()));
        bot.makeRandomMove();
        System.out.println(Arrays.toString(b.getLines()));
        bot.makeStrategicMove();
        System.out.println(Arrays.toString(b.getLines()));
        bot.makeRandomMove();
        System.out.println(Arrays.toString(b.getLines()));
    }
    
}
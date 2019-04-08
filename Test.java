
import java.util.Random;
import java.util.Arrays;
public class Test
{
    public static void main(String args[])
    {
        // Board b = new Board();
//         NimBot strat = new NimBot(b);
//         NimBot rand = new NimBot(b);
//         int win = 2;
//         do
//         {
//             strat.makeStrategicMove();
//             if (b.hasEnded())
//             {
//                 win = 0;
//                 break;
//             }    
//             strat.makeRandomMove();
//             
//             if (b.hasEnded())
//             {
//                win = 1;
//                break;
//             }
//         }
//         while(!b.hasEnded());
//         
//         System.out.println(win);

          Board b = new Board();
          b.take(1,1);
          b.take(2,3);
          b.take(3,5);
          b.take(4,7);
          System.out.println(b.hasEnded());

         // Board b = new Board();
//          System.out.println(b.playRound());

          // Board b = new Board();
//           NimBot bot  = new NimBot(b);
//           bot.makeRandomMove();
//           System.out.println(Arrays.toString(b.getLines()));

          // Board b = new Board();
//           NimBot bot  = new NimBot(b);
//           bot.makeRandomMove();
//           bot.makeStrategicMove();
//           System.out.println(Arrays.toString(b.getLines()));
    }
}
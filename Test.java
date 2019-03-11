public class Test
{
    public static void main(String args[])
    {
        Board b = new Board();
        StrategyBot bob = new StrategyBot(b);
        b.take(2,1);
        bob.go();
        b.take(4,1);
        bob.state();
        bob.go(); 
    }
}
public class Test
{
    public static void main(String args[])
    {
        Board b = new Board();
        StrategyBot bob = new StrategyBot(b);
        b.take(4,1);
        bob.makeStrategicMove();
        System.out.println(bob.getXORSum());
        b.take(3,1);
        b.display();
    }
}
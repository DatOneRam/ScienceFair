public class Test
{
    public static void main(String args[])
    {
        Board b = new Board();
        StrategyBot bob = new StrategyBot(b);
        b.display();
        b.take(2,3);
        b.display();
        bob.makeStrategicMove();
        b.display();
        System.out.println(bob.getXORByte());
    }
}
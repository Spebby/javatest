package APCSland;
import java.util.Scanner;

public class DriverFeeder
{
    Scanner scan = new Scanner(System.in);

    public void main()
    {
        DiceGame dg = new DiceGame();
        
        System.out.println("Welcome to Apologetics, a simple game with a non-sensical title.");
        System.out.println("Apologetics is a two player dice game in which you race to 40.");
        System.out.println("Roll a 12, and you loose a turn. Roll a 7 and you move on back.");
        System.out.println("But, if you land a 2, your next roll will be doubled.");
        System.out.println("With all that said, let's get playing. But first, we need your names.");
            
        System.out.println();
        System.out.print("Player 1, enter your name: ");
        String pn = scan.nextLine();
        Player p1 = new Player(pn, 0, 0, 0, false);
        System.out.print("Player 2, enter your name: ");
        pn = scan.nextLine();
        Player p2 = new Player(pn, 0, 0, 0, false);
            
        dg.dStart(p1, p2);
    }
}
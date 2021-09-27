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
    
    protected void Loop()
    {
        System.out.println("Would you like to Restart the program?");
        System.out.println("If yes, enter \"Yes\".");
        System.out.println("If you'd like to quit, enter \"Quit\" or \"No\".");
        String c = scan.nextLine();
        c = c.toUpperCase();
        
        if(c.charAt(0) == 'Y')
        {
            System.out.print('\f');
            Play(true);
        }
        else
            Quit();
    }
    
    void Play(boolean something) //ignore :))))
    {
        Quit();
    }
    
    protected void Quit()
    {
        System.out.print('\f');
        System.out.print("Bye!");
        System.exit(0);
    }
}
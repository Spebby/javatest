import java.util.Scanner;

public class DriverFeeder
{
    Scanner scan = new Scanner(System.in);
    
    protected Player p1;
    protected Player p2;
    
    public void main(boolean SkipIntro)
    {
        if(!SkipIntro)
        {
            System.out.println("Welcome to Apologetics, a simple game with a non-sensical title.");
            System.out.println("Apologetics is a two player dice game in which you race to 40.");
            System.out.println("Roll a 12, and you loose a turn. Roll a 7 and you move on back.");
            System.out.println("But, if you land a 2, your next roll will be doubled.");
            System.out.println("With all that said, let's get playing. But first, we need your names.");
            
            System.out.println();
            System.out.print("Player 1, enter your name: ");
            String pn = scan.nextLine();
            p1 = new Player(pn, 0, 0, 0, false);
            System.out.println();
            System.out.print("Player 2, enter your name: ");
            pn = scan.nextLine();
            p1 = new Player(pn, 0, 0, 0, false);
            System.out.println();
        }
        else
            System.out.println("Let's go again, shall we?");
        
        System.out.println();
        DiceGame dg = new DiceGame();
        dg.Play();
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
            Play();
        }
        else
            Quit();
    }
    
    protected void Quit()
    {
        System.out.print('\f');
        System.out.print("Bye!");
        System.exit(0);
    }
    
    void Play() // ignore B)))
    {
        Quit();
    }
}
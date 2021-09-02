import java.util.Scanner;

public class DriverFeeder
{
    Scanner scan = new Scanner(System.in);
    Games g = new Games();
    
    public void main(boolean SkipIntro)
    {
        if(!SkipIntro)
        {
            System.out.println("Welcome to the fair!");
        }
        else
        {
            System.out.print('\f');
            System.out.println("Welcome back!");
        }
        
        System.out.println("We have " + g.numGame.length + " games to play, you can choose between: ");
        
        for(int i = 0; i < g.numGame.length; i++)
        {
            if(i != g.numGame.length - 1)
                System.out.print(g.numGame[i] + " & ");
            else
                System.out.print(g.numGame[i]);
        }
        
        System.out.println("");
        System.out.println("");
        System.out.println("Choose the game you want to play!");
        
        if(!SkipIntro)
            System.out.println("Enter the full name or the abbreviation. Capitalize the abbreviation/first letters.");
            
        String gCh = scan.nextLine();
        System.out.print('\f');

        g.GameManager(gCh);
    }

    // Referenced by other scripts to save myself from writing too extra uneeded lines
    public void QuitGame()
    {
        System.out.print('\f');
        System.out.print("Bye!");
        System.exit(0);
    }
}
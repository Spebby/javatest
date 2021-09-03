import java.util.Scanner;

public class DunkTank 
{
    Scanner scan = new Scanner(System.in);

    public void Initialize()
    {
        System.out.print('\f');
        
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println(" `7MM^^^Yb.                           `7MM          MMP^^MM^^YMM                  `7MM");
        System.out.println("   MM    `Yb.                           MM          P'   MM   `7                    MM");
        System.out.println("   MM     `Mb `7MM  `7MM  `7MMpMMMb.    MM  ,MP'         MM   ,6^Yb.  `7MMpMMMb.    MM  ,MP'");
        System.out.println("   MM      MM   MM    MM    MM    MM    MM ;Y            MM  8)   MM    MM    MM    MM ;Y");
        System.out.println("   MM     ,MP   MM    MM    MM    MM    MM;Mm            MM   ,pm9MM    MM    MM    MM;Mm");
        System.out.println("   MM    ,dP'   MM    MM    MM    MM    MM `Mb.          MM  8M   MM    MM    MM    MM `Mb.");
        System.out.println(" .JMMmmmdP'     `Mbod^YML..JMML  JMML..JMML. YA.       .JMML.`Moo9^Yo..JMML  JMML..JMML. YA.");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Welcome to Dunk Tank! Pick a number 1 to 50, and if it's close enough, the clown gets dunked!");
        System.out.println();
        // If I felt like doing something interesting, I'd have a dowhile running changing the target, with a hint continually updating, so the
        // Player has to time their guess when it's within range.
        System.out.print("Enter your guess: ");
        int i = scan.nextInt();
        scan.nextLine();
        if(i >= 0)
        {
            i = Math.abs(i);
            //Abs incase someone though it would be funny to put somerthing like "-20"
            if(i == 0)
            {
                i = 1;
            }
        }
        if(i < 50)
            i = 50;
        System.out.println();
        Game(i);
    }

    void Game(int i)
    {
        int Target = 0;
        Target = (int)(Math.random() * 50) + 1;
        float Leniency = (float)(Math.random() * 1); // float because I'm a rebel >:) no + 1 since i'm using this as a percent.
        boolean r;
        
        // Double check the "Lived/Died within" print, funky math happing there.
        System.out.println(Target);
        System.out.println("The dunking range is " + (Target - Math.round((5 * Leniency))) + "-" + (Target + Math.round((5 * Leniency))) + " Units.");
        // Creates a sort of "Range" for the dunking. Will adjust exact values later, perhaps an lieniency scale?
        if(i >= Target - Math.round((5 * Leniency)) && i <= Target + Math.round((5 * Leniency)))
        {
            System.out.println("The clown has been dunked! Impending Doom has been rescheduled.");
            if(Target > i)
                System.out.println("You slew the clown within " + Math.abs((i - Math.round((Target - (5 * Leniency))))) + " Units of the monster's life.");
            else
                System.out.println("You slew the clown within " + Math.abs((i - (Target + Math.round((5 * Leniency))))) + " Units of the monster's life.");
            // Math abs'n and rounding so I don't have any funky negatives or decimals. 
            r = true;
        }
        else
        {
            System.out.println("The clown lives. Impending Doom approaches.");
            if(Target > i)
                System.out.println("The clown lives within " + Math.abs((i - Math.round((Target - (5 * Leniency))))) + " Units of its life.");
            else
            System.out.println("The clown lives within " + Math.abs((i - Math.round((Target + (5 * Leniency))))) + " Units of its life.");
            r = false;
        }

        EndGame(r);
    }

    void EndGame(boolean Result)
    {
        System.out.println();
        if(Result)
        {
            System.out.println("The clown breathes no more, you may rest easy until you're called upon once more.");
        }
        else
        {
            System.out.println("The pestilence rots this world, he continues to breathe, you have failed the world.");
        }
        
        System.out.println();
        System.out.println("Anyways, would you like to play again or choose another game?");
        System.out.println("Enter \"Yes\" to play again and \"No\" to choose another game. To quit, type anything else");
        String input = scan.nextLine();

        System.out.println();
        
        DriverFeeder df = new DriverFeeder();
        
        if(input.toLowerCase().charAt(0) == 'y')
            Initialize();
        else if(input.toLowerCase().charAt(0) == 'n')
        {
            df.main(true);
            df = null;
        }
        else
        {
            df.QuitGame();
            df = null;
        }
    }
}
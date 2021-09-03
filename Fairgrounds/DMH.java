// A game my Father used to play, the good ol' "Put something in your hand, put your hands behind your back, shuffle, guess what
// hand it's in" game. A common tactic would be to pocket the thing, so it was in neither hands, not sure if I will implement.
import java.util.Scanner;

public class DMH 
{
    Scanner scan = new Scanner(System.in);

    public void Initialize()
    {
        System.out.print('\f');
        
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("       d8b                        d8b                                                    d8b                                d8b");
        System.out.println("      88P                        88P                                                    ?88                                88P");
        System.out.println("     d88                        d88                                                      88b                              d88");
        System.out.println(" d888888   d8888b d888b8b   d888888        88bd8b,d88b  d888b8b    88bd88b  .d888b,      888888b  d888b8b    88bd88b  d888888");
        System.out.println("d8P' ?88  d8b_,dPd8P' ?88  d8P' ?88        88P'`?8P'?8bd8P' ?88    88P' ?8b ?8b,         88P `?8bd8P' ?88    88P' ?8bd8P' ?88");
        System.out.println("88b  ,88b 88b    88b  ,88b 88b  ,88b      d88  d88  88P88b  ,88b  d88   88P   `?8b      d88   88P88b  ,88b  d88   88P88b  ,88b");
        System.out.println("`?88P'`88b`?888P'`?88P'`88b`?88P'`88b    d88' d88'  88b`?88P'`88bd88'   88b`?888P'     d88'   88b`?88P'`88bd88'   88b`?88P'`88b");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Welcome to Dead Man's Hand. The Dead Man's favourite coin is placed into the tenant's left hand,");
        System.out.println("the tenant then put their hands behind their back and shuffles the coin, guess what hand the coin is in!");
        System.out.println();
        System.out.print("Enter your guess, either Left, Right or Neither: "); // Neither has a 20% chance of happening.
        String i = scan.nextLine();

        System.out.println();
        Game(i);
    }

    void Game(String input)
    {
        String pi;
        int rng = (int)((Math.random() * 50) + 1); // Trying to make a sudo percentage thing.
        String hand;

        if(input.toLowerCase().charAt(0) == 'l')
            pi = "the Left";
        else if(input.toLowerCase().charAt(0) == 'r')
            pi = "the Right";
        else // "Neither"
            pi = "Neither";

        if(rng > 40 )
            hand = "Neither";
        else if(rng <= 40 && rng > 20)
            hand = "the Right";
        else
            hand = "the Left";

        System.out.print("The Coin was in " + hand + " hand, you guessed it would be in " + pi + " hand, ");
        switch(hand)
        {
            case "the Right":
                if(pi == "the Right")
                    System.out.print("you win!");
                else
                    System.out.print("you lose!");
                break;
            case "the Left":
                if(pi == "the Left")
                    System.out.print("you win!");
                else
                    System.out.print("you lose!");
                break;
            case "Neither":
                if(pi == "Neither")
                    System.out.print("you win!");
                else
                    System.out.print("you lose!");
                break;
        }

        System.out.println();

        End();
    }

    void End()
    {
        System.out.println("Would you like to play again or choose another game?");
        System.out.println("Enter \"Yes\" to play again and \"No\"  to choose another game. To quit, type anything else");
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
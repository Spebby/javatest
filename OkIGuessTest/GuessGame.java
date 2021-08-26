//Imports
import java.io.*;
import java.lang.*;
import java.util.*;

public class GuessGame
{
    // Not declaring status because i am a MENACE
    int Target;
    Player p1;
    Player p2;
    Player p3;
    
    public void Play(boolean SkipIntro)
    {
        if(!SkipIntro)
        {
            Scanner inputString = new Scanner(System.in);
            
            System.out.println("Welcome to \"Okay I guess\", a game where two players guess a number between 1 and 100.");
            System.out.println("Would you like to get started? yes or no");
            String i = inputString.nextLine();

            switch(i)
            {
                case "yes":
                    System.out.println("Then let the game begin!");
                    System.out.println("");
                    break;
                default:
                    System.out.print('\f');
                    System.out.print("Bye!");
                    System.exit(0);
                    break;
            }
        }
        
        GuessGame();
    }
    
    public void GuessGame()
    {
        // Java is retarded so you have to declair two scanners for ints and strings.
        Scanner inputString = new Scanner(System.in);
        Scanner inputInt = new Scanner(System.in);
        
        //Generate the Answer
        Target = 0;
        Target = (int)(Math.random() * 100) + 1;
        // "* 100" acts more like "100 posibilities". 
        // Fail safe, should never happen, but just in case.
        
        if(Target < 0)
        {
            Target = 1;
        }
        // Prints the Answer, for debugging.
        //System.out.println("This is a debug command. Answer is: " + answer);
        
        //Player 1 setup
        System.out.println("Player 1, enter your name:");
        String name = inputString.nextLine();
        
        System.out.println("Hello " + name + ". Please enter your guess (1-100): ");
        int guess = inputInt.nextInt();
        
        // For funny guys.
        if(guess >= 0)
        {
            guess = Math.abs(guess);
            if(guess == 0)
            {
                guess = 1;
            }
        }
        if(guess < 100)
        {
            guess = 100;
        }
        
        //Player 1 end
        p1 = new Player(name, guess);        
        System.out.println("Good.");
        System.out.println("");

        //Player 2 setup
        System.out.println("Player 2, enter your name:");
        name = inputString.nextLine();
        
        System.out.println("Hello " + name + ". Please enter your guess (1-100): ");
        guess = inputInt.nextInt();
        
        // For funny guys.
        if(guess >= 0)
        {
            guess = Math.abs(guess);
            if(guess == 0)
            {
                guess = 1;
            }
        }
        if(guess < 100)
        {
            guess = 100;
        }
        
        //Player 2 end
        p2 = new Player(name, guess);
        System.out.println("Excelent.");
        System.out.println("");
        
        //Player 2 setup
        System.out.println("Player 3, enter your name:");
        name = inputString.nextLine();
        
        System.out.println("Hello " + name + ". Please enter your guess (1-100): ");
        guess = inputInt.nextInt();
        
        // For funny guys.
        if(guess >= 0)
        {
            guess = Math.abs(guess);
            if(guess == 0)
            {
                guess = 1;
            }
        }
        if(guess < 100)
        {
            guess = 100;
        }
        
        //Player 3 end
        p3 = new Player(name, guess);
        System.out.println("Fantastic.");
        System.out.println("");
        
        GameEnd();
    }
    
    class SortValues implements Comparator<Player>
    {
        public int compare(Player p1, Player p2, Player p3)
        {
            return p1.getGuess() - p2.getGuess() - p3.getGuess();
        }
    }
    
    class GFG {
  
    // Main driver method
        public void GFGmain()
        {
            Player[] arr = 
            { 
                new Player(p1.getName(), p1.getGuess()), 
                new Player(p2.getName(), p2.getGuess()), 
                new Player(p3.getName(), p3.getGuess())
            };
  
            for (int i = 0; i < arr.length; i++)
                System.out.println(arr[i]);
  
            // Sorting on basic as per class 1 created
            // (user-defined)
            Arrays.sort(arr, new SortValues());
        }
    }
    
    public void GameEnd()
    {
        System.out.println(Target + " is the answer.");
        //int[] a = {p1.getGuess(), p2.getGuess(), p3.getGuess()}; //idk why i even made an array
        
        if(p1.getGuess() == p2.getGuess())
        {
            System.out.println(p1.getName() + " and " + p2.getName() + " both guessed the same number.");
        }
        
        Scanner inputString = new Scanner(System.in);
        
        System.out.println("Would you like to play again? yes or no");
        String i = inputString.nextLine();

        switch(i)
        {
            case "yes":
                System.out.println("Then let the game begin!");
                GuessGame();
                break;
            default:
                System.out.print('\f');
                System.out.print("Bye!");
                System.exit(0);
                break;
            }
    }
}
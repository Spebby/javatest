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
    
    Player[] pArray = new Player[]{p1, p2, p3};
    
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
                // Case fallthroughs
                case "yes":
                case "Yes":
                case "YES":
                case "yES":
                case "yEs":
                case "yeS":
                case "ye":
                case "yE":
                case "YE":
                case "Ye":
                case "y":
                case "Y":
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
        
        if(Target <= 0)
            Target = 1;
        // Prints the Answer, for debugging.
        //System.out.println("This is a debug command. Answer is: " + answer);
        
        //Player 1 setup
        System.out.println("Player 1, enter your name:");
        String name = inputString.nextLine();
        
        System.out.println("Hello " + name + ". Please enter your guess (1-100): ");
        int guess = inputInt.nextInt();
        
        // For funny guys.
        if(guess <= 0)
        {
            System.out.println("Oh, " + name + " , didn't suspect you were such a funny guy.");
            guess = Math.abs(guess);
            
            if(guess == 0)
                guess = 1;
        }
        if(guess > 100)
        {
            System.out.println("Oh, " + name + " , didn't know you were such a funny guy.");
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
        if(guess <= 0)
        {
            System.out.println("Oh, " + name + " , didn't think you were such a funny guy.");
            guess = Math.abs(guess);
            
            if(guess == 0)
                guess = 1;
        }
        if(guess > 100)
        {
            System.out.println("Oh, " + name + " , didn't know you were such a funny guy.");
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
        if(guess <= 0)
        {
            System.out.println("Oh, " + name + " , didn't guess you were such a funny guy.");
            guess = Math.abs(guess);
            
            if(guess == 0)
                guess = 1;
        }
        if(guess > 100)
        {
            System.out.println("Oh, " + name + " , didn't think you were such a funny guy.");
            guess = 100;
        }
        
        //Player 3 end
        p3 = new Player(name, guess);
        System.out.println("Fantastic.");
        System.out.println("");
        
        GameEnd();
    }
   
    public void GameEnd()
    {
        System.out.println(Target + " is the answer.");
        //int[] a = {p1.getGuess(), p2.getGuess(), p3.getGuess()}; //idk why i even made an array
        
        // Terribleness inbound
        {
            boolean p1Cor = false;
            boolean p2Cor = false;
            boolean p3Cor = false;
                
            // yooo im BREAKING THE RULES
            if(p1.getGuess() == Target)
                p1Cor = true;
            if(p2.getGuess() == Target)
                p2Cor = true;
            if(p3.getGuess() == Target)
                p3Cor = true;
                
            boolean[] boolExacts = new boolean[]{p1Cor, p2Cor, p3Cor};
                
            // Check if the same
            // Done first because other calculations are pointless if everything is the same.
            {
                if(p1.getGuess() == p2.getGuess() && p1.getGuess() == p3.getGuess())
                    GameResults("all same", boolExacts);
                
                else if(p1.getGuess() == p2.getGuess())
                    System.out.println(p1.getName() + " and " + p2.getName() + " both guessed the same number.");
                else if(p1.getGuess() == p3.getGuess())
                    System.out.println(p1.getName() + " and " + p3.getName() + " both guessed the same number.");
                else if(p2.getGuess() == p3.getGuess())
                    System.out.println(p2.getName() + " and " + p3.getName() + " both guessed the same number.");
            }
            
            // Find differences between guesses
            {
                p1.setDifference(Math.abs(p1.getGuess() - Target));
                p2.setDifference(Math.abs(p2.getGuess() - Target));
                p3.setDifference(Math.abs(p3.getGuess() - Target));
                
                int guessAverage;
                guessAverage = Math.round(Math.abs((p1.getDifference() + p2.getDifference() + p3.getDifference()) / 3));
            }
            
            GameResults("typical", boolExacts);
        }
    }
    
    void GameResults(String result, boolean[] boolArray)
    {
        switch(result)
        {
            case "all same":
                System.out.println("");
                System.out.println("Real funny stuff everyone, truly.");
                
                if(p1.getGuess() == Target)
                    System.out.println("But, against all odds, you all managed to guess correctly.");
                    
                System.out.println("");
                GameReset();
                break;
            case "typical":
                if(boolArray[0] || boolArray[1] || boolArray[2])
                {
                    for (int i = 0; i < boolArray.length; i++) 
                    {
                        if(boolArray[i])
                            System.out.println(pArray[i].getName() + " guessed exactly!");
                    }
                    System.out.println("");
                }
                else
                {
                    for (int i = 0; i < pArray.length; i++)
                    {
                        System.out.println(pArray[i].getName() + " is " + pArray[i].getDifference() + " away from the Answer");
                    }
                    System.out.println("");
                }
                
                if(boolArray[0] && boolArray[1] && boolArray[2])
                {
                    System.out.println("Everyone wins!");
                    GameReset();
                    break;
                }
                if(boolArray[0] && boolArray[1])
                {
                    System.out.println(p1.getName() + " & " + p2.getName() + " win!");
                    GameReset();
                    break;
                }
                if(boolArray[0] && boolArray[2])
                {
                    System.out.println(p1.getName() + " & " + p3.getName() + " win!");
                    GameReset();
                    break;
                }
                if(boolArray[1] && boolArray[2])
                {
                    System.out.println(p2.getName() + " & " + p3.getName() + " win!");
                    GameReset();
                    break;
                }
                    
                //p1 is closest
                if(p1.getDifference() > p2.getDifference() || p1.getDifference() > p3.getDifference())
                    System.out.println(p1.getName() + " wins!");
                //p2 is closest
                if(p2.getDifference() > p1.getDifference() || p2.getDifference() > p3.getDifference())
                    System.out.println(p2.getName() + " wins!");
                //p3 is closest
                if(p3.getDifference() > p2.getDifference() || p3.getDifference() > p1.getDifference())
                    System.out.println(p3.getName() + " wins!");
                
                GameReset();
                break;
            default:
                break;
        }
    }
    
    public void GameReset()
    {
        Scanner inputString = new Scanner(System.in);
        
        System.out.println("");
        
        System.out.print("Would you like to play again? yes or no");
        String i = inputString.nextLine();

        switch(i)
        {
            case "yes":
                System.out.print('\f');
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
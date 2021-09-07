//Imports
import java.util.Scanner;

public class GuessGame
{
    // Not declaring status because i am a MENACE
    int Target;
    int guessAverage;

    Scanner scan = new Scanner(System.in);
    // The original issue with the scanners was due to how they were instantiated and also how Scanner handles Ints, found a fix.
    
    GuessGamePlayer[] pArray = new GuessGamePlayer[3];
    
    public void Play()
    {
        System.out.print('\f');
        
        System.out.println("Welcome to \"Okay I Guess\", a game where three players guess a number between 1 and 100.");
        
        StartGame();
    }
    
    public void StartGame()
    {
        // Java is retarded so you have to declair two scanners for ints and strings.
        
        //Generate the Answer
        Target = 0;
        Target = (int)(Math.random() * 100) + 1;
        // "* 100" acts more like "100 possibilities". 
        // Fail safe, should never happen, but just in case.
        
        if(Target <= 0)
            Target = 1;
        // Prints the Answer, for debugging.
        //System.out.println("This is a debug command. Answer is: " + answer);
        
        //Player 1 setup
        System.out.println("Player 1, enter your name:");
        String name = scan.nextLine();
        
        System.out.println("Hello " + name + ". Please enter your guess (1-100): ");
        int guess = scan.nextInt();
        scan.nextLine(); // This is to fix an oversight with Java and scanners.
        
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
        pArray[0] = new GuessGamePlayer(name, guess); 
        System.out.println("Good.");
        System.out.println("");

        //Player 2 setup
        System.out.println("Player 2, enter your name:");
        name = scan.nextLine();
        
        System.out.println("Hello " + name + ". Please enter your guess (1-100): ");
        guess = scan.nextInt();
        scan.nextLine(); // This is to fix an oversight with Java and scanners.
        
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
        pArray[1] = new GuessGamePlayer(name, guess);
        System.out.println("Excellent.");
        System.out.println("");
        
        //Player 2 setup
        System.out.println("Player 3, enter your name:");
        name = scan.nextLine();
        
        System.out.println("Hello " + name + ". Please enter your guess (1-100): ");
        guess = scan.nextInt();
        scan.nextLine(); // This is to fix an oversight with Java and scanners.
        
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
        pArray[2] = new GuessGamePlayer(name, guess);
        System.out.println("Fantastic.");
        System.out.println("");

        GameEnd();
    }
   
    public void GameEnd()
    {
        System.out.println(Target + " is the answer.");
        //int[] a = {p1.getGuess(), p2.getGuess(), p3.getGuess()}; //idk why i even made an array for this
        
        // Terribleness inbound
        {
            boolean p1Cor = false;
            boolean p2Cor = false;
            boolean p3Cor = false;
                
            // yooo im BREAKING THE RULES
            if(pArray[0].getGuess() == Target)
                p1Cor = true;
            if(pArray[1].getGuess() == Target)
                p2Cor = true;
            if(pArray[2].getGuess() == Target)
                p3Cor = true;
                
            boolean[] boolExacts = new boolean[]{p1Cor, p2Cor, p3Cor};
                
            // Check if the same
            // Done first because other calculations are pointless if everything's the same.
            {
                if(pArray[0].getGuess() == pArray[1].getGuess() && pArray[0].getGuess() == pArray[2].getGuess())
                    GameResults("all same", boolExacts);
                
                else if(pArray[0].getGuess() == pArray[1].getGuess())
                    System.out.println(pArray[0].getName() + " and " + pArray[1].getName() + " both guessed the same number.");
                else if(pArray[0].getGuess() == pArray[2].getGuess())
                    System.out.println(pArray[0].getName() + " and " + pArray[2].getName() + " both guessed the same number.");
                else if(pArray[0].getGuess() == pArray[2].getGuess())
                    System.out.println(pArray[1].getName() + " and " + pArray[2].getName() + " both guessed the same number.");
            }
            
            // Find differences between guesses
            {
                pArray[0].setDifference(Math.abs(pArray[0].getGuess() - Target));
                pArray[1].setDifference(Math.abs(pArray[1].getGuess() - Target));
                pArray[2].setDifference(Math.abs(pArray[2].getGuess() - Target));
                
                guessAverage = Math.round(Math.abs((pArray[0].getDifference() + pArray[1].getDifference() + pArray[2].getDifference()) / 3));
                System.out.println("Median number guessed: " + guessAverage);
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
                
                if(pArray[0].getGuess() == Target)
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
                        System.out.println(pArray[i].getName() + " is " + pArray[i].getDifference() + " away from the answer");
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
                    System.out.println(pArray[0].getName() + " & " + pArray[1].getName() + " win!");
                    GameReset();
                    break;
                }
                if(boolArray[0] && boolArray[2])
                {
                    System.out.println(pArray[0].getName() + " & " + pArray[2].getName() + " win!");
                    GameReset();
                    break;
                }
                if(boolArray[1] && boolArray[2])
                {
                    System.out.println(pArray[1].getName() + " & " + pArray[2].getName() + " win!");
                    GameReset();
                    break;
                }
                    
                //p1 is closest
                if(pArray[0].getDifference() < pArray[1].getDifference() && pArray[0].getDifference() < pArray[2].getDifference())
                    System.out.println(pArray[0].getName() + " wins!");
                //p2 is closest
                if(pArray[1].getDifference() < pArray[0].getDifference() && pArray[1].getDifference() < pArray[2].getDifference())
                    System.out.println(pArray[1].getName() + " wins!");
                //p3 is closest
                if(pArray[2].getDifference() < pArray[1].getDifference() && pArray[2].getDifference() < pArray[0].getDifference())
                    System.out.println(pArray[2].getName() + " wins!");
                
                GameReset();
                break;
            default:
                break;
        }
    }
    
    public void GameReset()
    {
        System.out.println("");
        
        System.out.println("Would you like to play again or choose another game?");
        System.out.println("Enter \"Yes\" to play again and \"No\"  to choose another game. To quit, type anything else");
        String i = scan.nextLine();

        System.out.println();
        
        DriverFeeder df = new DriverFeeder();
        
        if(i.toLowerCase().charAt(0) == 'y')
                Play();
        else if(i.toLowerCase().charAt(0) == 'n')
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
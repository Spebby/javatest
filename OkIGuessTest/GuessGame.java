//Imports
import java.util.Scanner;

public class GuessGame
{
    // Not declaring status because i am a MENACE
    int answer;
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
        answer = 0;
        answer = (int)(Math.random() * 100) + 1;
        // "* 100" acts more like "100 posibilities". 
        // Fail safe, should never happen, but just in case.
        
        if(answer < 0)
        {
            answer = 1;
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
        System.out.println("Excelent.");
        System.out.println("");
        
        GameEnd();
    }
    
    public void GameEnd()
    {
        System.out.print(answer + " is the answer.");
        int[] a = {p1.getGuess(), p2.getGuess(), p3.getGuess()};
        
        if(a[0] > a[1]) 
        {
            
        }
        
        switch(answers)
        {
            
        }
        
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
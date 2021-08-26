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
    
    // Simplify this down to a simple for loop, go from there tomorrow.
    public class Sort
    {
        double[] findClosest(double[] dblArray) 
        {
            double[] closest = new double[2];

            //int diff will keep track of the best of the differences
            //between the numbers we are compairing. Need to start off at 
            //largest number possible.
            double bestDiff = Double.MAX_VALUE;

            //currDiff will calculate the current difference in doubles
            double currDiff;

            //You want to iterate through every value you have
            for (int i = 0; i < dblArray.length; i++) 
            {
                for (int j = 0; j < dblArray.length; j++) 
                {
                    if (i != j) 
                    { //You don't want it to compare to itself.
                        //System.out.println("Subtracting: " + dblArray[i] + " - " + dblArray[j]);
                        currDiff = Math.abs(dblArray[i] - dblArray[j]);
                        if (currDiff < bestDiff) 
                        {
                            closest[0] = dblArray[i];
                            closest[1] = dblArray[j];
                            bestDiff = currDiff;
                           // System.out.println("Setting closest:" + dblArray[i] + ", " + dblArray[j] + ", bestDiff: " + bestDiff);
                        }
                    }
                }
            }

            return closest;
        }
        
        public void main(String[] args) 
        {
            double[] testArray = new double[]{.7, 1.8, 1};
            double[] resultArray = findClosest(testArray);
            System.out.println("Closest were: " + resultArray[0] + ", " + resultArray[1]);
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
import java.util.Scanner;

public class RPS
{
    Scanner scan = new Scanner(System.in);
    
    RPSManager rpsmng;
    
    public void Initialize()
    {
        System.out.println("-------------------------------------------");
        System.out.println("  -----------  -----------  ------------");
        System.out.println("  ***********  ************ ************");
        System.out.println("  ----    ---  ---      --- ----");
        System.out.println("  *********    ************ ************");
        System.out.println("  ---------    -----------  ------------");
        System.out.println("  ****  ****   ****                *****");
        System.out.println("  ----   ----  ----         ------------");
        System.out.println("  ****    **** ****         ************");
        System.out.println("-------------------------------------------");
        System.out.println();
        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.println("To get started, enter your choice! Enter either the name or Initial.");
        String c = scan.nextLine();
        
        rpsmng = new RPSManager(c);
        
        RPSLogic();
    }
    
    
    //redo all of this
    public void RPSLogic()
    {
        int c = rpsmng.getChoice();
        int cmp = (int)(Math.random() * 3);
        System.out.println(cmp + " computer choice");
        System.out.println(c + " player choice");
        
        switch(c)
        {
            case 0:
                System.out.println("You chose Rock and your opponent entered ");
                if(cmp == 0)
                {
                    System.out.print("Rock.");
                    System.out.println("Draw!");
                    break;
                }
                else if(cmp == 1)
                {
                    System.out.print("Paper.");       
                    System.out.println("You Lose!");
                    break;
                }
                else
                {
                    System.out.print("Scissors.");
                    System.out.println("You Win!");
                    break;
                }
            case 1:
                System.out.println("You chose Paper and your opponent entered ");
                if(cmp == 0)
                {
                    System.out.print("Rock.");
                    System.out.println("You Win!");
                    break;
                }
                else if(cmp == 1)
                {
                    System.out.print("Paper.");       
                    System.out.println("Draw!");
                    break;
                }
                else
                {
                    System.out.print("Scissors.");
                    System.out.println("You Lose!");
                    break;
                }
            case 2:
                System.out.println("You chose Scissors and your opponent entered ");
                if(cmp == 0)
                {
                    System.out.print("Rock.");
                    System.out.println("You Lose!");
                    break;
                }
                else if(cmp == 1)
                {
                    System.out.print("Paper.");       
                    System.out.println("You Win!");
                    break;
                }
                else
                {
                    System.out.print("Scissors.");
                    System.out.println("Draw!");
                    break;
                }
            default:
                System.out.println("How did we get here?");
                break;
        }

        System.out.println();
        System.out.println("Would you like to play again or choose another game?");
        System.out.println("Enter \"Yes\" to play again and No to choose another game. To quit, type anything else");
        String input = scan.nextLine(); // Reusing variable
        scan = null;

        System.out.println();

        DriverFeeder df = new DriverFeeder();
        switch(input)
        {
            case "Yes":
            case "Y":
            case "y":
                Initialize();
                break;
            case "No":
            case "N":
            case "n":
                df.main(true);
                df = null;
                break;
            default:
                df.QuitGame();
                df = null;
                break;
        }
    }
}
import java.util.Scanner;

public class RPS
{
    private int cmp;
    Scanner scan = new Scanner(System.in);
    
    RPSManager a1;
    
    public void Initialize()
    {
        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.println("To get started, enter your choice! Enter either the name or Initial.");
        String c = scan.nextLine();
        
        a1 = new RPSManager(c);
        
        RPSLogic();
    }
    
    
    //redo all of this
    public void RPSLogic()
    {
        int c = a1.getChoice();
        cmp = (int)(Math.random() * 3);
        
        switch(c)
        {
            case 0:
                System.out.println("You entered Rock and your opponent entered ");
                if(cmp == 0)
                {
                    System.out.print("Rock.");
                    System.out.println("Draw!");
                }
                else if(cmp == 1)
                {
                    System.out.print("Paper.");       
                    System.out.println("You Lose!");
                }
                else
                {
                    System.out.print("Scissors.");
                    System.out.println("You Win!");
                }
            case 1:
                System.out.println("You entered Paper and your opponent entered ");
                if(cmp == 0)
                {
                    System.out.print("Rock.");
                    System.out.println("You Win!");
                }
                else if(cmp == 1)
                {
                    System.out.print("Paper.");       
                    System.out.println("Draw!");
                }
                else
                {
                    System.out.print("Scissors.");
                    System.out.println("You Lose!");
                }
            case 2:
                System.out.println("You entered Scissors and your opponent entered ");
                if(cmp == 0)
                {
                    System.out.print("Rock.");
                    System.out.println("You Lose!");
                }
                else if(cmp == 1)
                {
                    System.out.print("Paper.");       
                    System.out.println("You Win!");
                }
                else
                {
                    System.out.print("Scissors.");
                    System.out.println("Draw!");
                }
            default:
                System.out.println("How did we get here?");
                break;
        }
    }
}
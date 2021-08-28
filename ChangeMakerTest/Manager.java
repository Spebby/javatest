import java.util.Scanner;
public class Manager 
{
    Scanner scan = new Scanner(System.in);

    float price;
    float cash;

    public void ChangeManager(boolean SkipIntro) 
    {

        if(!SkipIntro)
        {
            System.out.println("Welcome to the best Cash Register in the world.");
            System.out.println("To get started, enter the following variables.");
            System.out.println("");
        }
        else
        {
            System.out.println("");
            System.out.println("Register Reset");
            System.out.println("");
        }
        
        System.out.print("Cost of purchase: ");
        price = scan.nextFloat();
        
        System.out.print("Cash given: ");
        cash = scan.nextFloat();
        
        ChangeComplete();
    }

    public void ChangeComplete()
    {    
        ChangeMaker cMake = new ChangeMaker(price, cash);
        int[] change = cMake.makeChange();

        System.out.println("Your change is " + change[0] + " dollars and " + change[4] + " cents");
        System.out.println(change[1] + " quarters");
        System.out.println(change[2] + " dimes");
        System.out.println(change[3] + " nickels");
        System.out.println(change[4] + " pennies");

        ChangeManager(true);
    }
}
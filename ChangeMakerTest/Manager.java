import java.util.Scanner;
public class Manager 
{
    public static void Manager(boolean SkipIntro) 
    {
        Scanner input = new Scanner(System.in);
        
        if(!SkipIntro)
        {
            System.out.print("Welcome to the best Cash Register in the world.");
            System.out.println("To get started, enter the following variables.");
            System.out.println("");
        }
        else
        {
            System.out.println("");
            System.out.println("Register Reset");
            System.out.println("");
        }
        
        System.out.print("Purchase Price: ");
        double price = input.nextDouble();
        
        System.out.print("Cash Tendered: ");
        double cash = input.nextDouble();
        
        ChangeMaker cMake = new ChangeMaker(price, cash);
        int[] result = cMake.makeChange();
        
        System.out.println("Your change is " + result[0] + " dollars and " + result[5] + " cents");
        System.out.println(result[1] + " quarters");
        System.out.println(result[2] + " dimes");
        System.out.println(result[3] + " nickels");
        System.out.println(result[4] + " pennies");
    }
}
// In this game, the player enters a random number(s) (Birthday/rn perhaps?)
// When they enter this, the computer generates a random value, and then
// The computer compares said number to the player entered number
// The computer will then give them a fortune.
import java.util.Scanner;

public class FT
{
    Scanner scan = new Scanner(System.in);
    public void Initialize()
    {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("'########::'#######::'########::'########:'##::::'##:'##::: ##:'########:");
        System.out.println(" ##.....::'##.... ##: ##.... ##:... ##..:: ##:::: ##: ###:: ##: ##.....::");
        System.out.println(" ##::::::: ##:::: ##: ##:::: ##:::: ##:::: ##:::: ##: ####: ##: ##:::::::");
        System.out.println(" ######::: ##:::: ##: ########::::: ##:::: ##:::: ##: ## ## ##: ######:::");
        System.out.println(" ##...:::: ##:::: ##: ##.. ##:::::: ##:::: ##:::: ##: ##. ####: ##...::::");
        System.out.println(" ##::::::: ##:::: ##: ##::. ##::::: ##:::: ##:::: ##: ##:. ###: ##:::::::");
        System.out.println(" ##:::::::. #######:: ##:::. ##:::: ##::::. #######:: ##::. ##: ########:");
        System.out.println("..:::::::::.......:::..:::::..:::::..::::::.......:::..::::..::........::");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Welcome to the Fortune Telling Tent, your destiny fortold!");
        System.out.println();
        System.out.print("Enter a Number: ");
        String c = scan.nextLine();


    }

    
}
// In this game, the player enters a random number(s) (Birthday/rn perhaps?)
// When they enter this, the computer generates a random value, and then
// The computer compares said number to the player entered number
// The computer will then give them a fortune.
import java.util.Scanner;

public class FT
{
    Scanner scan = new Scanner(System.in);
    FTManager ftMng;

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
        System.out.print("What month were you born on?");
        String m = scan.nextLine();

        System.out.print("And what day?");
        int d = scan.nextInt();

        ftMng = new FTManager(m, d);
        m = scan.nextLine(); // bug with int and scanner
    }

    // This is the fun part, the switch now has to compare the month the user inputed against the days avaliable. 
    public void FortuneFinder()
    {
        
    }    
    
}
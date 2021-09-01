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
        int Nature; // This makes later logic easier, think of this as refering to a person's "nature"
        // Simplifying this down to something more manageable. Otherwise this will be **way** too much work for a throw away game
        // Will also likely simplify this down to 
        switch(ftMng.GetMonth())
        {
            // Dividing this up by seasons.
            case 12:
            case 1:
            case 2:
                Nature = 0;
                break;
            case 3:
            case 4:
            case 5:
                Nature = 1;
                break;
            case 6:
            case 7:
            case 8:
                Nature = 2;
                break;
            case 9:
            case 10:
            case 11:
                Nature = 3;
                break;
            // No default as there's already out of range protection done earlier.
        }
    }    
    
}
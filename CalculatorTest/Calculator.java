/* C# is cooler :)
 * define the class
*/
import java.util.Scanner;
public class Driver
{   
    // calculator mode
    public static void main()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Welcome to");
        // Prints on the same line for effect.
        // Wait of 1/4th of a second inbetween each .
        System.out.print(".");
        System.out.print(".");
        System.out.print(".");
        System.out.println(""); // Empty line for spacing.
        // Wait a full second
        // It may be worth adding waits between each line to invoke the feeling of an archaic machine.
        System.out.println("-------------------------------------------------------------------");
        System.out.println("    ><<              ><<                ><<    ><<<<       ><< <<  ");
        System.out.println(" ><<   ><<           ><<                ><<  ><<    ><<  ><<    ><<");
        System.out.println("><<          ><<     ><<   ><<<><<  ><< ><<><<        ><< ><<      ");
        System.out.println("><<        ><<  ><<  ><< ><<   ><<  ><< ><<><<        ><<   ><<    ");
        System.out.println("><<       ><<   ><<  ><<><<    ><<  ><< ><<><<        ><<      ><< ");
        System.out.println(" ><<   ><<><<   ><<  ><< ><<   ><<  ><< ><<  ><<     ><< ><<    ><<");
        System.out.println("   ><<<<    ><< ><<<><<<   ><<<  ><<><<><<<    ><<<<       ><< <<  ");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("");
        
        System.out.println("Enter the first Variable.");
        double v1 = input.nextFloat();
        // Code that prevents the rest of the code from being proccessed
                           
        System.out.println("Enter the final Variable.");
        // Code that allows user to input Calculator Mode.
        double v2 = input.nextFloat();
        // Code that prevents the rest of the code from being proccessed
        
        System.out.println("Enter the Calculator Mode.");
        System.out.println("Add(0), Subtract(1), Multiply(2), Divide(3), Remainder(4), Compair(5)");
        // Code that allows user to input Calculator Mode.
        int enumType = input.nextInt();
        // Code that prevents the rest of the code from being proccessed
        
        
        CalculateMode calType;
        
        switch(enumType)
        {
            case 0:
                Calculator calc = new Calculator(v1, v1, calType.Add);
                break;
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;
            default:
                System.out.println("ERROR! Invalid Type");
        }
    }
}
// Obama was here

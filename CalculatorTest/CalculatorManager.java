/* C# is cooler :)
 * define the class
*/
import java.util.Scanner;
public class CalculatorManager
{   
    // calculator mode
    public void Manager(boolean SkipIntro)
    {
        Scanner input = new Scanner(System.in);
        
        if(!SkipIntro)
        {
            System.out.print("Welcome to");
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
        }
        
        else
        {
            System.out.println("");
            System.out.println("Calculator Reset");
        }
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
        
        CalculateMode calType = CalculateMode.Add;

        Calculator calc = new Calculator();
        
        switch(enumType)
        {
            case 0:
                calc.Calculator(v1, v2, calType.Add);
                break;
            case 1:
                calc.Calculator(v1, v2, calType.Subtract);
                break;
            case 2:
                calc.Calculator(v1, v2, calType.Multiply);
                break;
            case 3:
                calc.Calculator(v1, v2, calType.Divide);
                break;
            case 4:
                calc.Calculator(v1, v2, calType.Remainder);
                break;
            case 5:
                calc.Calculator(v1, v2, calType.Compair);
                break;
            default:
                System.out.println("ERROR! Invalid Type");
        }
    }
}
// Obama was here
/* C# is cooler :)
 * define the class
*/
import java.util.Scanner;
public class CalculatorManager
{   
    Scanner input = new Scanner(System.in);

    // calculator mode
    public void Manager(boolean SkipIntro)
    {
        
        if(!SkipIntro)
        {
            System.out.println("Welcome to...");
            
            System.out.println("");
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
        System.out.print("Enter the first Variable:");
        float v1 = input.nextFloat();
        System.out.println("");

        System.out.print("Enter the final Variable:");
        float v2 = input.nextFloat();
        input.nextLine();
        System.out.println("");

        SwitchManager(v1, v2); // To dummy proof issues with people inputing dumb shit into enumType
    }

    void SwitchManager(float v1, float v2)
    {
        System.out.println("Enter the Calculator Mode.");
        System.out.println("Add, Subtract, Multiply, Divide, Remainder, Compair");
        // Code that allows user to input Calculator Mode.
        String enumType = input.nextLine();
    
        //CalculateMode calType = CalculateMode.Add;

        Calculator calc = new Calculator();
        
        // Case fall through is bad, but I 
        switch(enumType)
        {
            case "a":
            case "A":
            case "add":
            case "Add":
                calc.CalculatorHandler(v1, v2, CalculateMode.Add);
                break;
            case "s":
            case "S":
            case "subtract":
            case "Subtract":
                calc.CalculatorHandler(v1, v2, CalculateMode.Subtract);
                break;
            case "m":
            case "M":
            case "multiply":
            case "Multiply":
                calc.CalculatorHandler(v1, v2, CalculateMode.Multiply);
                break;
            case "d":
            case "D":
            case "divide":
            case "Divide":
                calc.CalculatorHandler(v1, v2, CalculateMode.Divide);
               break;
            case "r":
            case "R":
            case "remainder":
            case "Remainder":
                calc.CalculatorHandler(v1, v2, CalculateMode.Remainder);
                break;
            case "c":
            case "C":
            case "compair":
            case "Compair":
                calc.CalculatorHandler(v1, v2, CalculateMode.Compair);
                break;
            default:
                System.out.println("ERROR! Invalid Type");
                SwitchManager(v1, v2);
        }
    }
}
// Obama was here
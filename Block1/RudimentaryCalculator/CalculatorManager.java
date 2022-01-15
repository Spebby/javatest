package RudimentaryCalculator;
import java.util.Scanner;

public class CalculatorManager
{   
    Scanner input = new Scanner(System.in);

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

        SwitchManager(v1, v2); //dummy proof and also shit code
    }

    void SwitchManager(float v1, float v2)
    {
        System.out.println("Enter the Calculator Mode.");
        System.out.println("Add, Subtract, Multiply, Divide, Remainder, Compair");

        String enumType = input.nextLine();
        Calculator calc = new Calculator();
        enumType = enumType.toUpperCase();
        
        switch(enumType)
        {
            case "A":
            case "ADD":
                calc.CalculatorHandler(v1, v2, CalculateMode.Add);
                break;
            case "S":
            case "SUBTRACT":
                calc.CalculatorHandler(v1, v2, CalculateMode.Subtract);
                break;
            case "M":
            case "MULTIPLY":
                calc.CalculatorHandler(v1, v2, CalculateMode.Multiply);
                break;
            case "D":
            case "DIVIDE":
                calc.CalculatorHandler(v1, v2, CalculateMode.Divide);
               break;
            case "r":
            case "R":
            case "remainder":
            case "Remainder":
                calc.CalculatorHandler(v1, v2, CalculateMode.Remainder);
                break;
            case "C":
            case "COMPAIR":
                calc.CalculatorHandler(v1, v2, CalculateMode.Compair);
                break;
            default:
                System.out.println("ERROR! Invalid Type");
                SwitchManager(v1, v2);
        }
    }
}
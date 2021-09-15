import java.util.Scanner;

public class DriverFeeder
{
    String[] options = new String[]{"GPA Calculator", "Checking if Prime", "Average Test Score", "Least Common Multiple", "Reverse Digits"};
    protected Scanner scan = new Scanner(System.in);
    
    public void main(boolean SkipIntro) //String[] args
    {
        System.out.print('\f');
        
        if(!SkipIntro)
        {
            System.out.println("Welcome to the oddest most boring collection of micro-programs.");
            System.out.println("Source code can be found at https://github.com/Spebby/javatest");
        }
        else
            System.out.println("Welcome back.");
        
        System.out.println("There are " + options.length + " options to choose from, you can choose between: ");
        for(int i = 0; i < options.length; i++)
        {
            if(i != options.length - 1)
                System.out.print(options[i] + ", ");
            else
                System.out.print(options[i]);
        }
        
        System.out.println("");
        System.out.println("");
        
        if(!SkipIntro)
            System.out.println("Enter the full name or the abbreviation. Capitalize the abbreviation/first letters. (GPA/CP for ex.)");
        System.out.println("Enter \"No\" if you wish to quit.");
            
        String c = scan.nextLine();
        c = c.toUpperCase();
        
        SwitchHandle(c);
    }

    void SwitchHandle(String c)
    {
        switch(c)
        {
            case "GPAC":
            case "GPA":
            case "GPA CALCULATOR":
                GPA gpa = new GPA();
                gpa.Initialize();
                break;
            case "CP":
            case "CPrime":
            case "CHECKING IF PRIME":
                CPrime cp = new CPrime();
                cp.Initialize(false);
                break;
            case "ATS":
            case "AVERAGE TEST SCORE":
                ATScore ats = new ATScore();
                ats.Initialize();
                break;
            case "LCM":
            case "LEAST COMMON MULTIPLE":
                LCM lcm = new LCM();
                lcm.Initialize();
                break;
            case "RD":
            case "RDIGITS":
            case "REVERSE DIGITS":
                RDigits rDig = new RDigits();
                rDig.Initialize();
                break;
            case "NO":
            case "N":
                Quit();
                break;
            default:
                System.out.println("Invalid entry, pick again.");  
                c = scan.nextLine();
                c = c.toUpperCase();
                SwitchHandle(c);
                break;
        }
    }
    
    protected void LoopProgram()
    {
        System.out.println("Would you like to Restart the program?");
        System.out.println("If yes, enter \"Yes\", if you'd like to select another program, enter \"No\".");
        System.out.println("If you'd like to quit, enter \"Quit\".");
        String c = scan.nextLine();
        c = c.toUpperCase();
        
        if(c.charAt(0) == 'Y')
        {
            System.out.print('\f');
            Initialize();
        }
        else if (c.charAt(0) == 'N')
        {
            System.out.print('\f');
            main(true);
        }
        else
            Quit();
    }
    
    protected static void Quit()
    {
        System.out.print('\f');
        System.out.print("Bye!");
        System.exit(0);
    }
    
    // non-existant method for getting compiller to shut up
    void Initialize()
    {
        Quit();
    }
}
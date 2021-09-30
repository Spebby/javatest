import java.util.Scanner;

public class MonoBehavior // inheritance script
{
    protected Scanner scan = new Scanner(System.in);
    
    protected void Quit()
    {
        System.out.print("Bye!");
        System.exit(0);
    }
    
    protected interface Command 
    {
        void _Command();
    }
}
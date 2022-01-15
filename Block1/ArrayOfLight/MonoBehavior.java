package ArrayOfLight;
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

    protected <T> void PrintList(T[] array)
    {
        for(int i = 0; i < array.length ; i++) // prints each number in the array. proper formating included.
        {
            if(i != array.length - 1)
                System.out.print(array[i] + ", ");
            else
                System.out.print(array[i]);
        }
    }
}
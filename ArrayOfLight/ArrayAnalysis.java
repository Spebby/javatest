import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class ArrayAnalysis extends MonoBehavior
{
    int[] iArray = new int[0];
    int[] iRange = new int[2];
    int iLength;
    String[] appName = new String[]{"Average", "Range", "Odd"};

    Map<Character, Command> options = new HashMap<Character, Command>();

    public void Initialize(boolean SkipIntro)
    {
        if(!SkipIntro)
        {
            System.out.println("Welcome to program that generates numbers, then analysis them. Let's get started.");
            
            options.put('A', new Command() { public void _Command() { anlAverage(); }; }); // Average
            options.put('R', new Command() { public void _Command() { anlRange(); }; }); // Range
            options.put('O', new Command() { public void _Command() { anlOdd(); }; }); // Odd
        }

        System.out.println();
        System.out.print("How many numbers should the range generate? ");
        iLength = scan.nextInt();
        iArray = new int[iLength];
        System.out.print("What's the smallest possible number integer in the range? ");
        iRange[0] = scan.nextInt();
        System.out.print("And the largest possible number integer in the range? ");
        iRange[1] = scan.nextInt();
        String in = scan.nextLine(); // double for java jank
        if(iRange[0] >= iRange[1]) // funny guy protection
            iRange[1] = iRange[0] + 1;
        
        // iRange[0] is Min, iRange[1] is Max
        for(int i = 0; i < iArray.length; i++) // Fills iArray wil random variables within range.
            iArray[i] = (int)(Math.random() * (iRange[1] - iRange[0])) + iRange[0];
            
        System.out.println();
        System.out.print("Would you like to see all the numbers in the array? Y/N: ");
        in = scan.nextLine();
        in = in.toUpperCase();
        if(in.charAt(0) == 'Y')
        {
            System.out.print("The numbers generated are: ");
            PrintList(iArray, null); // Send to a function to improve invisibility.
            System.out.println();
        }

        System.out.println("Now that all the numbers have been generated, what program would you like to select?");
        System.out.println();
        System.out.print("Programs avaliable: ");
        PrintOptions();
        System.out.print("Input your choice: ");
        in = scan.nextLine();
        in = in.toUpperCase();
        char cmd = in.charAt(0);
        options.get((cmd))._Command();  // prints "Help"
    }
    
    void anlAverage()
    {
        int c = 0;
        for(int i = 0; i < iArray.length; i++)
            c += iArray[i];
        
        System.out.println("The average is " + (c/iArray.length) + ".");
        Loop();
    }
    
    void anlRange()
    {
        System.out.println("The range is " + Math.abs(iRange[0] - iRange[1]) + ".");
        Loop();
    }
    
    void anlOdd()
    {
        ArrayList<Integer> odd = new ArrayList<Integer>();
        
        for(int i = 0; i < iArray.length; i++)
            if(iArray[i] % 2 != 0) // fills array with all odd numbers in the origianl array.
                odd.add(iArray[i]);
        
        System.out.println("Out of " + iArray.length + " numbers, only " + odd.size() + " were odd.");
        System.out.print("Of those, ");
        PrintList(null, odd); // Send to a function to improve invisibility.

        System.out.print(" were odd.");
        System.out.println();
        Loop();
    }
    
    void Loop()
    {
        System.out.println();
        System.out.println("Would you like to choose another program, or change the array?");
        System.out.println("If you'd like to choose another program, enter \"Yes\".");
        System.out.println("If you'd like to change the array, enter \"Change\".");
        System.out.println("If you'd like to quit, enter \"Quit\" or \"No\".");
        String c = scan.nextLine();
        c = c.toUpperCase();
        
        System.out.print('\f');
        if(c.charAt(0) == 'Y')
        {
            System.out.println("What program do you want to switch to?");
            System.out.print("Programs avaliable: ");
            PrintOptions();
            System.out.println();
        
            System.out.print("Input your choice: ");
            c = scan.nextLine();
            c = c.toUpperCase();
            char cmd = c.charAt(0);
            options.get(cmd)._Command();
        }    
        else if (c.charAt(0) == 'C')
            Initialize(true);
        else
            Quit();
    }

    void PrintOptions()
    {
        for(int i = 0; i < appName.length ; i++) // prints each number in the array. proper formating included.
        {
            if(i != appName.length - 1)
                System.out.print(appName[i] + ", ");
            else
                System.out.print(appName[i]);
        }
        System.out.println();
    }

    void PrintList(int[] cArray, ArrayList<Integer> bArray)
    {
        if(cArray != null)
        {
            for(int i = 0; i < cArray.length ; i++) // prints each number in the array. proper formating included.
            {
                if(i != cArray.length - 1)
                    System.out.print(cArray[i] + ", ");
                else
                    System.out.print(cArray[i]);
            }
        }
        else if(bArray != null)
        {
            for(int i = 0; i < bArray.size() ; i++) // prints each number in the array. proper formating included.
            {
                if(i != bArray.size() - 1)
                    System.out.print(bArray.get(i) + ", ");
                else
                    System.out.print(bArray.get(i));
            }
        }
    }
}
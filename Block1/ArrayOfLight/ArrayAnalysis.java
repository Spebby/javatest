package ArrayOfLight;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.text.DecimalFormat;

public class ArrayAnalysis extends MonoBehavior
{
    int[] iArray = new int[0];
    int[] iRange = new int[2];
    String[] appName = new String[]{"Average", "Range", "Odd", "Selection"};

    Map<Character, Command> options = new HashMap<Character, Command>();

    public void Initialize(boolean SkipIntro)
    {
        if(!SkipIntro)
        {
            System.out.println("Welcome to program that generates numbers, then analysis them. Let's get started.");
            
            options.put('A', new Command() { public void _Command() { anlAverage(); }; }); // Average
            options.put('R', new Command() { public void _Command() { anlRange(); }; }); // Range
            options.put('O', new Command() { public void _Command() { anlOdd(); }; }); // Odd
            options.put('S', new Command() { public void _Command() { anlSelection(); }; }); // Selection        }
        }
        System.out.println();
        System.out.print("How many numbers should the range generate? ");
        int iLength = scan.nextInt();
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
        Arrays.sort(iArray);
            
        System.out.println();
        System.out.print("Would you like to see all the numbers in the array? Y/N: ");
        in = scan.nextLine();
        in = in.toUpperCase();
        if(in.charAt(0) == 'Y')
        {
            System.out.print("The numbers generated are: ");
            
            // Java doesn't have support for Generic Arrays, have to do this instead.
            String[] siArray = new String[iLength];
            for (int i = 0; i < iArray.length; i++)
                siArray[i] = String.valueOf(iArray[i]);
            PrintList(siArray);
            System.out.println();
        }

        System.out.println("Now that all the numbers have been generated, what program would you like to select?");
        System.out.println();
        System.out.print("Programs avaliable: ");
        PrintList(appName);
        System.out.println();
        System.out.print("Input your choice: ");
        in = scan.nextLine();
        in = in.toUpperCase();
        char cmd = in.charAt(0);
        options.get((cmd))._Command();  // prints "Help"
    }
    
    void anlAverage()
    {
        DecimalFormat median = new DecimalFormat("###.###");
        float c = 0;
        for(int i = 0; i < iArray.length; i++)
            c += iArray[i];
        
        System.out.println("The average is " + median.format(c/iArray.length) + ".");
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
        int[] oArray = odd.stream().mapToInt(i -> i).toArray();


        System.out.println("Out of " + iArray.length + " numbers, only " + odd.size() + " were odd.");
        System.out.print("Of those, ");

        // Java doesn't have support for Generic Arrays, have to do this instead.
        String[] soArray = new String[oArray.length];
            for (int i = 0; i < oArray.length; i++)
                soArray[i] = String.valueOf(oArray[i]);
        PrintList(soArray); // Send to a function to improve read ability.

        System.out.print(" were odd.");
        System.out.println();
        Loop();
    }
    
    void anlSelection()
    {
        System.out.println();
        System.out.print("Choose the number you want to check for: ");
        int c = scan.nextInt();
        int cnum = 0;
        
        if(c < iRange[0])
            c = iRange[0];
        else if(c > iRange[1])
            c = iRange[1];
        
        for(int i = 0; i < iArray.length; i++)
        {
            if(c == iArray[i])
                cnum++;
        }
    
        System.out.println("There are " + cnum + " instances of " + c + " in the range.");    
        Loop();
    }
    
    void Loop()
    {
        System.out.println();
        System.out.println("Would you like to choose another program, or change the array?");
        System.out.println("If you'd like to choose another program, enter \"Yes\".");
        System.out.println("To change the array, enter \"Change\".");
        System.out.println("To quit, enter \"Quit\" or \"No\".");
        String c = scan.nextLine(); // two for java jank
        c = scan.nextLine();
        c = c.toUpperCase();
        
        System.out.print('\f');
        if(c.charAt(0) == 'Y')
        {
            System.out.println("What program do you want to switch to?");
            System.out.print("Programs avaliable: ");
            PrintList(appName);
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
}
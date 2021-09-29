import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.ArrayList;

public class ArrayAnalysis extends MonoBehavior
{
    int[] iArray = new int[0];
    int[] iRange = new int[2];
    int iLength;
    
    Map<Character, Command> options = new HashMap<Character, Command>();
    Random random = new Random();
    
    public void Initialize(boolean SkipIntro)
    {
        if(!SkipIntro)
        {
            System.out.println("Welcome to program that generates numbers, then analysis them. Let's get started.");
            
            options.put('A', new Command() { public void Command() { anlAverage(); }; }); // Average
            options.put('R', new Command() { public void Command() { anlRange(); }; }); // Range
            options.put('O', new Command() { public void Command() { anlOdd(); }; }); // Odd
        }
        
        System.out.println();
        System.out.print("How many numbers should the range generate? ");
        iLength = scan.nextInt();
        iArray = new int[iLength];
        System.out.println();
        System.out.print("What's the smallest possible number integer in the range? ");
        iRange[0] = scan.nextInt();
        System.out.println();
        System.out.print("And the largest possible number integer in the range? ");
        iRange[1] = scan.nextInt();
        String in = scan.nextLine(); // double for java jank
        if(iRange[0] >= iRange[1]) // funny guy protection
            iRange[1] = iRange[0] + 1;
        
        // iRange[0] is Min, iRange[1] is Max
        for(int i = 0; i < iArray.length; i++) // Fills iArray wil random variables within range.
        {
            iArray[i] = random.nextInt(iRange[0] - iRange[1]) + iRange[0];
        }
        
        in = scan.nextLine();
        in = in.toUpperCase();
        char cmd = in.charAt(0);
        options.get(cmd).Command();  // prints "Help"
    }
    
    void anlAverage()
    {
        
    }
    
    void anlRange()
    {
        System.out.println("The range is " + Math.abs(iRange[0] - iRange[1]) + ".");
    }
    
    void anlOdd()
    {
        ArrayList<Integer> odd = new ArrayList();
        
        for(int i = 0; i < iArray.length; i++)
        {
            if(iArray[i] % 2 != 0)
                odd.add(iArray[i]);
        }
        
        System.out.println("Out of " + iArray.length + " numbers, only " + odd.size() + " were odd.");
        System.out.println();
        System.out.print("Of those, ");
        for(int i = 0; i < odd.size(); i++)
        {
            if(i != odd.size() - 1)
                System.out.print(odd.get(i) + ", ");
            else
                System.out.print(odd.get(i));
        }
        System.out.print(" were odd.");
        Loop();
    }
    
    protected void Loop()
    {
        System.out.println();
        System.out.println("Would you like to choose another program, or change the array?");
        System.out.println("If you'd like to choose another program, enter \"Yes\".");
        System.out.println("If you'd like to change the array, enter \"Enter\".");
        System.out.println("If you'd like to quit, enter \"Quit\" or \"No\".");
        String c = scan.nextLine();
        c = c.toUpperCase();
        
        System.out.print('\f');
        if(c.charAt(0) == 'Y')
            Initialize(true);
        else if (c.charAt(0) == 'E')
        {
            System.out.println("What program do you want to switch to?");
            System.out.println();
            System.out.print("Programs avaliable: ");
            System.out.print(options);
            System.out.println();
            
            System.out.print("Input your choice: ");
            c = scan.nextLine();
            c = c.toUpperCase();
            char cmd = c.charAt(0);
            options.get(cmd).Command();
        }
        else
            Quit();
    }
}
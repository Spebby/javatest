package Recursion;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Common.HashCommand.Command;
import Common.Print;
import Common.comFunc;

import static java.lang.System.out; // literally only have this so my classes aren't cluttered with System.out.println();

public class RecursionDriver
{
    String[] appList = new String[]{"Sums of Numbers", "Factorial", "Fibonacci", "Collatz"};
    Map<Character, Command> options = new HashMap<Character, Command>();
    int x;
    Scanner scan = new Scanner(System.in);

    public static void main(String[] args)
    {
        RecursionDriver rc = new RecursionDriver();
        rc.Awake();
        rc.Input();
    }

    void Input()
    {
        System.out.print("Programs available: "); 
        Print.PrintGenericList(appList);

        out.println(); System.out.print("Enter a number: ");
        x = scan.nextInt(); String in = scan.nextLine(); // java bug workaround

        System.out.print("Input your choice: ");
        in = scan.nextLine(); in = in.toUpperCase(); // actual part we care about
        char c = in.charAt(0);
        if(c == 'F')
        {
            try{
                c = in.charAt(1);
            }catch (Exception e) {
                out.println("Invalid input. Falling back on Factorial.");
                c = 'A';
            }
        }

        options.get((c))._Command();
        out.println("Result: " + x);

        System.out.println("Loop? Y/N");
        in = scan.nextLine(); in = in.toUpperCase(); c = in.charAt(0);
        if(c == 'Y') 
            Input();
        else 
            System.out.println("Goodbye!"); // end program
            
    }

    void Awake()
    {
        options.put('N', () -> comFunc.sumOfNumbs(x));
        options.put('I', () -> comFunc.Fibonacci(x)); 
        options.put('A', () -> comFunc.Fact(x));
        options.put('C', () -> comFunc.collatz(x));
    }

    void tab()
    {

    }
}
package Recursion;
import java.util.Scanner;

import Common.Print;
import Common.comFunc;

import static java.lang.System.out; // literally only have this so my classes aren't cluttered with System.out.println();

public class RecursionDriver
{
    String[] appList = new String[]{"Sums of Numbers", "Factorial", "Fibonacci", "Collatz"};
    int x;
    Scanner scan = new Scanner(System.in);

    public static void main(String[] args)
    {
        RecursionDriver rc = new RecursionDriver();
        rc.Input();
    }

    void Input()
    {
        System.out.print("Programs available: "); 
        Print.PrintList(appList);

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
        
        // originally a hashmap but I can't cleanly get return values.
        switch(c)
        {
            case 'A':
                out.println("Factorial: " + comFunc.Fact(x));
                break;
            case 'I':
                out.println("Fibonacci: " + comFunc.Fibonacci(x));
                break;
            case 'C':
                out.println("Collatz: " + comFunc.collatz(x));
                break;
            case 'S':
                out.println("Sums of Numbers: " + comFunc.SumOfNumbs(x));
                break;
            default:
                out.println("Invalid input. Falling back on Factorial.");
                out.println("Factorial: " + comFunc.Fact(x));
                break;
        }

        System.out.println("Loop? Y/N");
        in = scan.nextLine(); in = in.toUpperCase(); c = in.charAt(0);
        if(c == 'Y') 
            Input();
        else 
            System.out.println("Goodbye!"); // end program
            
    }
}
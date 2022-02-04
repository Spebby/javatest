package Recursion;

import static java.lang.System.out; 
import java.util.Scanner;
import Common.comFunc;

public class DatangDriver 
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        // Palindrome
        out.print("Enter a String: "); String input = scan.nextLine();
        String _word = comFunc.spaceRemover(input);
        out.println("Is " + input + " a Palindrome? : " + comFunc.Palindrome(_word));


        // Alphabetical
        out.print(input + " is ");
        if(!comFunc.AlphaCheck(_word)) 
            out.print("not ");
        out.println("Alphabetical.");

        // Datang
        out.println("Enter a number: "); int n = scan.nextInt();
        DatangDisk.Datang(n);

        scan.close();
    }
}
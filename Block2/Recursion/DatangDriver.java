package Recursion;

import static java.lang.System.out; 
import java.util.Scanner;
import Common.Datang;
import Common.comFunc;

public class DatangDriver 
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        out.println("Enter a word: ");
        String palin = scan.nextLine();
        out.println("Is " + palin + " a Palindrome? : " + Datang.Palindrome(comFunc.spaceRemover(palin)));

        scan.close();
    }
}
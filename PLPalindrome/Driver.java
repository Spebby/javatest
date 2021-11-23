import java.util.Scanner;

public class Driver
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the scentence you want translated: ");
        String i = scan.nextLine();
        StringUtil su = new StringUtil(i);
        System.out.println();
        System.out.println(su.PigLatin());
        System.out.println(su.Palindrome());
        //System.out.println(su.PigLatin());
        scan.close();
    }
}

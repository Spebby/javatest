import java.util.Scanner;

public class Driver
{
    public static void main()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the scentence you want translated: ");
        String i = scan.nextLine();
        Word hey = new Word(i);
        System.out.println("New word!!! " + hey.GetWord() + " Vowel = " + hey.HasVowel() + " " + hey.WhereIsVowel());
        StringUtil su = new StringUtil(i);
        //System.out.println(su.PigLatin());
        scan.close();
    }
}

import java.util.Scanner;

public class Driver
{
    public static void main()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the scentence you want translated: ");
        String i = scan.nextLine();
        StringUtil su = new StringUtil(i);

        scan.close();
    }
}

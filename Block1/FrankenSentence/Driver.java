package FrankenSentence;
import java.util.Scanner;

public class Driver
{
    public static void main()
    {
        Scanner scan = new Scanner(System.in);
        ScentenceGenerator sg = new ScentenceGenerator();
        int c = scan.nextInt();
        scan.close();
        sg.Generate(c);
    }
}

package TerrariaNameGenerator;
import java.util.Scanner;

public class Driver
{
    public static void main(String[] args)
    {
        NameGenerator ng = new NameGenerator();
        Scanner scan = new Scanner(System.in);
        System.out.print("How many names should be generated? : ");
        int c = scan.nextInt();
        System.out.println();
        scan.close();
        ng.Generate(c);
    }
}
package ArraysOfLight;

import java.util.Scanner;
import static java.lang.System.out;

public class Driver 
{
    public static void main(String[] args)
    {
        new GameBoard();
        Scanner scan = new Scanner(System.in);

        out.print("Enter the file name, no file extension: ");
        String _fileName = scan.nextLine();
        new BacteriaSpawner(_fileName);

        scan.close();
    }
}
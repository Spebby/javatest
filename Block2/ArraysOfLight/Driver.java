package ArraysOfLight;

import static java.lang.System.out;
import java.util.Scanner;

public class Driver 
{
    public static void main(String[] args) throws InterruptedException
    {
        GameBoard gm = new GameBoard();
        new BacteriaSpawner();
        Scanner scan = new Scanner(System.in);
        
        out.print("How many iterations? ");
        int iterations = scan.nextInt();
        out.println();
        scan.close();

        while(GameBoard.Generation < iterations)
        {
            out.println("Generation: " + GameBoard.Generation);
            
            gm.Iteration();
            PrintPetri.PrintDish(GameBoard.board);
            //out.println("Eggs: ");
            //PrintPetri.PrintDish(GameBoard.eggs);
            Thread.sleep(4000);
            out.println();
        }
    }
}
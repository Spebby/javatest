package ClumpGone;

import static java.lang.System.out;
import java.util.Scanner;

public class Driver 
{
    public static void main(String[] args) throws InterruptedException
    {
        GameBoard gm = new GameBoard();
        new BlobSpawner();
        Scanner scan = new Scanner(System.in);
        
        out.print("How many iterations? ");
        int iterations = scan.nextInt();
        out.println();
        scan.close();

        while(GameBoard.Generation < iterations)
        {
            out.println("Generation: " + GameBoard.Generation);
            
            gm.Iteration();
            PrintClump.PrintBoard(GameBoard.board);
            Thread.sleep(4000);
            out.println();
        }
    }
}
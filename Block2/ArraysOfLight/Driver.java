package ArraysOfLight;

import static java.lang.System.out;

public class Driver 
{
    public static void main(String[] args) throws InterruptedException
    {
        new GameBoard();
        new BacteriaSpawner();

        // Prints the initial state of the board.
        out.println("Generation: " + GameBoard.Generation);
        out.println("---------------------");
        PrintPetri.PrintDish(GameBoard.board);
        // Prepares for the first generation. 
        GameBoard.Generation++;
        Thread.sleep(2000);
        out.println();

        while(GameBoard.Generation < 6)
        {
            out.println("Generation: " + GameBoard.Generation);
            out.println("---------------------");
            
            GameBoard.Generation();
            PrintPetri.PrintDish(GameBoard.board);
            Thread.sleep(4000);
            out.println();
        }
    }
}
package ArraysOfLight;

import static java.lang.System.out;

public class Driver 
{
    public static void main(String[] args) throws InterruptedException
    {
        GameBoard gm = new GameBoard();
        new BacteriaSpawner();

        while(GameBoard.Generation < 6)
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
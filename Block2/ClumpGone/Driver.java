package ClumpGone;

import static java.lang.System.out;
import java.util.Scanner;
import Common.Vector2Int;
import static ClumpGone.GameBoard.*;
import static ClumpGone.PrintClump.*;

public class Driver 
{
    public static void main(String[] args) throws InterruptedException
    {
        new BlobSpawner();
        PrintBoard(board);
        
        try (Scanner scan = new Scanner(System.in)) 
        {
            while(true)
            {
                // loop through board and print Vector2Int coordinates of all blobs
                int i = 0;
                for(Entity[] row : board)
                {
                    out.print(i + ": ");
                    for(Entity ent : row)
                    {
                        if(ent != null)
                            out.print(ent.pos.x + "," + ent.pos.y + " ");
                    }
                    i++;
                    out.println();
                }

                out.println("Enter Coordinates (X & Y vals): ");
                int x = scan.nextInt(); int y = scan.nextInt();
                
                Vector2Int pos = new Vector2Int(x, y);
                Entity entity = getEntity(pos);
                if(entity != null)
                    entity.Logic();

                PrintBoard(board);
                out.println();
            }
        }
    }
}
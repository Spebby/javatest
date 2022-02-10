package ArraysOfLight;

import java.io.*;
import java.util.Scanner;
import Common.comFunc;

import Common.Vector2Int;

public final class BacteriaSpawner 
{
    public BacteriaSpawner(String fileName)
    {
        try
        {
            Scanner scan = new Scanner(new File(fileName + ".txt"));
            while(scan.hasNext())
            {
                String line = scan.nextLine();
                Seperate( line );
            }
        }
        catch( FileNotFoundException ex) { System.out.println("File not found"); }
    }

    void Seperate(String str)
    {
        // removes spaces until there are no more spaces ahead of the first non-space character
        while(str.length() > 0) {
            if(str.charAt(0) == ' ')
                str = str.substring(1);
            else
                break;
        }

        int space0 = str.indexOf(" ");
        int x = Integer.parseInt(str.substring(0, space0)) - 1;
        str = comFunc.spaceRemover(str.substring(space0)); // clears spaces.
        int y = Integer.parseInt(str) - 1;

        GameBoard.addEntity(new Bacteria(), new Vector2Int(x, y));
    }
}
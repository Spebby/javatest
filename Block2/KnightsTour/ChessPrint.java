package KnightsTour;

public class ChessPrint 
{
    static void PrintChessRow(int[] row)
    {
        String space = "  ";
        
        System.out.print(n + ":" + "  "); n++;
        for (int i = 0; i < row.length; i++)
        {
            if(row[i] > 9)
                space = " ";

            System.out.print(row[i] + space);
            space = "  ";
        }

        System.out.println();
    }

    static int n = 0;
    public static void PrintChess(int[][] array)
    {
        n = 1;
        for(int[] row : array)
            PrintChessRow(row);
        
        System.out.println("X:  1  2  3  4  5  6  7  8");
    }
}
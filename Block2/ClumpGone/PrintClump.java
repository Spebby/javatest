package ClumpGone;

public class PrintClump
{
    static int n = 0;
    static String space = "  ";
    public static void PrintRow(Entity[] row)
    {
        if(n > 9)
            space = " ";
        
        System.out.print(n + ":" + space); n++;
        for (int i = 0; i < row.length; i++)
        {
            if(row[i] != null)
                System.out.print("* ");
            else
                System.out.print("- ");
        }
        System.out.println();
    }

    public static void PrintBoard(Entity[][] array)
    {
        n = 0; space = "  ";
        for(Entity[] row : array)
            PrintRow(row);
        
        System.out.println("X:  0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 ");
    }
}

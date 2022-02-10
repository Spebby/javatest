package Common;

public class Print 
{
    public static <T> void PrintList(T[] array)
    {
        int j = array.length;

        for(int i = 0; i < j; i++)
        {
            if(i != j - 1)
                System.out.print(array[i] + ", ");
            else
                System.out.print(array[i]);
        }
    }

    public static void PrintList(int[] array)
    {
        int j = array.length - 1;

        for(int i = 0; i < j; i++)
        {
            if(i != j - 1)
                System.out.print(array[i] + ", ");
            else
                System.out.print(array[i]);
        }
    }

    public static void PrintRow(int[] row) 
    {
        for (int i : row) 
        {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }

    public static void PrintTable(int[][] array)
    {
        for(int[] row : array)
            PrintRow(row);
    }
}
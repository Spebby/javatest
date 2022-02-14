package ArraysOfLight;

public class PrintPetri
{
    public static void PrintRow(Entity[] row)
    {
        for (int i = 0; i < row.length; i++)
        {
            if(row[i] != null)
                System.out.print('*');
            else
                System.out.print('-');
        }
        System.out.println();
    }

    public static void PrintDish(Entity[][] array)
    {
        for(Entity[] row : array)
            PrintRow(row);
    }
}

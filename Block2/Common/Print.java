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
}
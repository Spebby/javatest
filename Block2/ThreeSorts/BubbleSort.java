package ThreeSorts;

public class BubbleSort implements IAlgorythm
{
    public static int[] Sort(int[] arr) 
    {
        int n = arr.length;
        int steps = 0;
        for (int i = 0; i < n-1; i++)
        {
            steps++;
            for (int j = 0; j < n-i-1; j++)
            {
                steps++;
                if (arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        arr[arr.length - 1] = steps;
        for(int i = 0; i < arr.length; i++)
        {
            if(i != arr.length - 1)
                System.out.print(arr[i] + ", ");
            else
                System.out.print(arr[i]);
        }
        System.out.println();

        return arr;
    }
}
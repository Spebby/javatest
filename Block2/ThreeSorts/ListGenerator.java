package ThreeSorts;

import Common.Print;

public class ListGenerator
{
    public static int[] GenerateList(int size)
    {
        int[] list = new int[size + 1];
        for (int i = 0; i < size; i++) 
            list[i] = (int)(Math.random() * size * 5 + 1);
        
        // final member is for storing steps
        list[list.length - 1] = 9^999;

        // create "list2" which is a copy of "list" but 1 member shorter
        int[] list2 = new int[list.length]; // in my head it really should be "list.length - 1", but because of how .length actually works it's not
        for (int i = 0; i < size; i++)
            list2[i] = list[i];

        System.out.print("Generated List: "); Print.PrintList(list2);
        System.out.println();
        return list; 
    }
}
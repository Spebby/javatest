package ThreeSorts;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class SortMaster extends HashCommand
{
    String[] appName = new String[]{"Bubble Sort", "Selection Sort", "Insertion Sort"};
    Map<Character, Command> options = new HashMap<Character, Command>();
    int[] list;

    public SortMaster()
    {
        Awake();
        String in;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of items in list: ");

        int size = scan.nextInt(); in = scan.nextLine(); // java bug workaround
        list = ListGenerator.GenerateList(size);

        System.out.print("Programs available: "); Print.PrintGenericList(appName);

        System.out.println(); System.out.print("Input your choice: ");
        in = scan.nextLine(); in = in.toUpperCase();
        char cmd = in.charAt(0);

        options.get((cmd))._Command();
        scan.close();

        int steps = list[list.length - 1];
        System.out.println("This sort took " + steps + " steps to sort " + (list.length - 1) + " numbers");
        Print.PrintIntList(list);
    }

    void Awake()
    {
        options.put('B', () -> BubbleSort.Sort(list)); // Bubble Sort
        options.put('S', () -> SelectionSort.Sort(list)); // Selection Sort
        options.put('I', () -> InsertionSort.Sort(list)); // Insertion Sort
    }
}
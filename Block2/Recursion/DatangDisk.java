package Recursion;

public class DatangDisk 
{
    /** Solves the Disk of Datang problem.
      * @param n Number of disks
      * @param from_rod Name of the first rod
      * @param to_rod Name of the second rod
      * @param aux_rod Name of the third rod
      * @print Each step taken. */
    public static void Datang(int n, char from_rod, char to_rod, char aux_rod)
    {
        if (n == 1)
        {
            System.out.println("Move disk 1 from rod " +  from_rod + " to rod " + to_rod);
            return;
        }
        
        Datang(n-1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk " + n + " from rod " +  from_rod + " to rod " + to_rod);
        Datang(n-1, aux_rod, to_rod, from_rod);
    }

    public static void Datang(int n)
    {
        Datang(n, 'A', 'B', 'C');
    }
}

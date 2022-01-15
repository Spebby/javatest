package Spheres;
import javax.swing.*;
import java.util.Scanner;

public class Driver
{
    public static void main(String[] args)
    {
        System.out.print("How many balls should be spawned? : ");
        Scanner scan = new Scanner(System.in);
        int c = scan.nextInt();
        scan.close();
        JFrame frame = new JFrame("BOUNCING");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100, 100);
        Board board = new Board(c);
        frame.getContentPane().add(board);
        frame.pack();
        frame.setVisible(true);
        board.Go();
    }
}
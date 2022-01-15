package Dreamscape;
import javax.swing.*;

public class Driver 
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("DREAMING");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100, 100);
        Board board = new Board();
        frame.getContentPane().add(board);
        frame.pack();
        frame.setVisible(true);
        board.Go();
    }
}
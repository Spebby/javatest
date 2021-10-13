import javax.swing.*;
import java.awt.*;

public class Driver
{
    public static void main()
    {
        JFrame frame = new JFrame("BOUNCING");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100, 100);
        Board board = new Board();
        frame.getContentPane().add(board);
        frame.pack();
        frame.setVisible(true);
        board.Go();
    }
}
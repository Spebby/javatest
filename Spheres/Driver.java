import javax.swing.*;

public class Driver
{
    public static void main(int NumOfBalls)
    {
        JFrame frame = new JFrame("BOUNCING");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100, 100);
        Board board = new Board(NumOfBalls);
        frame.getContentPane().add(board);
        frame.pack();
        frame.setVisible(true);
        board.Go();
    }
}
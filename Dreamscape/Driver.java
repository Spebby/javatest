import javax.swing.*;

public class Driver 
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("DREAMING");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100, 100);
        System.out.println("Dream3");
        Board board = new Board();
        System.out.println("Dream4");
        frame.getContentPane().add(board);
        System.out.println("Dream5");
        frame.pack();
        System.out.println("Dream6");
        frame.setVisible(true);
        System.out.println("Dream7");
        board.Go();
        System.out.println("Dream8");
    }
}
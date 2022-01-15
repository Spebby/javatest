package BabyGame;
import javax.swing.*;

public class Driver
{
    public static void main(String[] args)
    {
        GameManager gm = new GameManager();
        JFrame frame = new JFrame("BABY GAME");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100, 100);
        Board board = new Board(gm);
        frame.getContentPane().add(board);
        frame.pack();
        frame.setVisible(true);
    }
}
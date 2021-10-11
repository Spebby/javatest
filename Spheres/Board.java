import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel
{
    Dimension scrnSize = Toolkit.getDefaultToolkit().getScreenSize();
    Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    int tbH = scrnSize.height - winSize.height;
    
    Ball ball;
    Ball ball2;
    Ball[] balls = {ball, ball2};
    
    RGB BG;
    Vector2Int boardSize = new Vector2Int(scrnSize.width, scrnSize.height - tbH);

    public Board()
    {
        BG = new RGB(162, 61, 155);
        this.setLayout(null);
        this.setBackground(new Color(BG.r, BG.g, BG.b));
        this.setPreferredSize(new Dimension(boardSize.x, boardSize.y));
        
        ball = new Ball(this);
        ball2 = new Ball(this);
    }
    
    public void go()
    {       
        while(true)
        {
            ball.Move(boardSize);
            ball2.Move(boardSize);
            this.repaint();
            try {Thread.sleep(10);} catch (InterruptedException ex){}
        }
    }
    
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);
        ball.Draw(page);
        ball2.Draw(page);
    }
}
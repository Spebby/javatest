import javax.swing.*;
import java.awt.*;

public class Board extends JPanel
{
    private Ball ball;
    private Ball ball2;
    
    private RGB bColour = new RGB(162, 61, 155);
    private Vector2Int size = new Vector2Int(1000, 600);
    
    public Board()
        {
        this.setLayout(null);
        this.setBackground(new Color(bColour.r, bColour.g, bColour.b));
        this.setPreferredSize(new Dimension(size.x, size.y));
            
        ball = new Ball();
        ball2 = new Ball();
    }
    
    public void go()
    {        
        while(true)
        {
            ball.Move();
            ball2.Move();
            this.repaint();
            try
            {
                Thread.sleep(10);
            } catch (InterruptedException ex){}
        }
    }
    
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);
        ball.Draw(page);
        ball2.Draw(page);
    }    
}
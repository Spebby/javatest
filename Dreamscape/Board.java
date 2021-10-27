import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Board extends JPanel
{
    // Get the size of the screen.
    Dimension scrnSize = Toolkit.getDefaultToolkit().getScreenSize();
    // Acount for Taskbar size.
    Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    int tbH = scrnSize.height - winSize.height;
    
    // Need a dynamically growing/shrinking Array, need an ArrayList
    ArrayList<Ball> balls = new ArrayList<Ball>();

    RGBA BG;
    Vector2Int boardSize = new Vector2Int(scrnSize.width, scrnSize.height - tbH);
    
    BallSpawner bs = new BallSpawner();

    public Board(int amount)
    {
        BG = new RGBA(162, 61, 155, 255);
        this.setLayout(null);
        this.setBackground(new Color(BG.r, BG.g, BG.b));
        this.setPreferredSize(new Dimension(boardSize.x, boardSize.y));
        
        bs.Spawn(balls, amount, this);
        this.setFocusable(true);
    }
    
    public void Go()
    {
        while(true) // Never ends
        {
            for(int i = 0; i < balls.size(); i++)
                balls.get(i).Move(boardSize);
            this.repaint();
            try {Thread.sleep(10);} catch (InterruptedException ex){}
        }
    }
    
    public void paintComponent(Graphics page) // Repaint the balls
    {
        super.paintComponent(page);
        for(int i = 0; i < balls.size(); i++)
                balls.get(i).Draw(page);
    }
    // encapsulation
    public Vector2Int getBSize() { return boardSize; }
}

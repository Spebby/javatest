import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Board extends JPanel implements KeyListener
{
    // Get the size of the screen.
    Dimension scrnSize = Toolkit.getDefaultToolkit().getScreenSize();
    // Acount for Taskbar size.
    Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    int tbH = scrnSize.height - winSize.height;
    
    // Need a dynamically growing/shrinking Array, need an ArrayList
    ArrayList<Ball> balls = new ArrayList<Ball>();

    RGB BG;
    Vector2Int boardSize = new Vector2Int(scrnSize.width, scrnSize.height - tbH);
    
    // SRP attempts
    Collision coll = new Collision();
    BallSpawner bs = new BallSpawner();

    public Board(int amount)
    {
        BG = new RGB(162, 61, 155);
        this.setLayout(null);
        this.setBackground(new Color(BG.r, BG.g, BG.b));
        this.setPreferredSize(new Dimension(boardSize.x, boardSize.y));
        
        this.addKeyListener(this);
        bs.Spawn(balls, amount, this);
        this.setFocusable(true);
    }
    
    public void Go()
    {
        while(true) // Never ends
        {
            for(int i = 0; i < balls.size(); i++)
                balls.get(i).Move(boardSize);
            coll.CollDetection(balls, .5f);
            this.repaint();
            try {Thread.sleep(10);} catch (InterruptedException ex){}
        }
    }

    public void keyPressed(KeyEvent event) 
    {
        switch(event.getKeyCode())
        {
            case KeyEvent.VK_1:
                bs.Spawn(balls, 1, this);
                break;
            case KeyEvent.VK_2:
                bs.Spawn(balls, 2, this);
                break;
            case KeyEvent.VK_3:
                bs.Spawn(balls, 3, this);
                break;
            case KeyEvent.VK_4:
                bs.Spawn(balls, 4, this);
                break;
            case KeyEvent.VK_5:
                bs.Spawn(balls, 5, this);
                break;
            case KeyEvent.VK_6:
                bs.Spawn(balls, 6, this);
                break;
            case KeyEvent.VK_7:
                bs.Spawn(balls, 7, this);
                break;
            case KeyEvent.VK_8:
                bs.Spawn(balls, 8, this);
                break;
            case KeyEvent.VK_9:
                bs.Spawn(balls, 9, this);
                break;
            default:
                break;
        }
    }
    
    public void keyReleased( KeyEvent event )
    {}
    
    public void keyTyped( KeyEvent event )
    {}
    
    public void paintComponent(Graphics page) // Repaint the balls
    {
        super.paintComponent(page);
        for(int i = 0; i < balls.size(); i++)
                balls.get(i).Draw(page);
    }
    // encapsulation
    public Vector2Int getBSize() { return boardSize; }
}

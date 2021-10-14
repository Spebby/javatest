import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Board extends JPanel
{
    Dimension scrnSize = Toolkit.getDefaultToolkit().getScreenSize();
    Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    int tbH = scrnSize.height - winSize.height;
    
    ArrayList<Ball> balls = new ArrayList<Ball>();

    RGB BG;
    Vector2Int boardSize = new Vector2Int(scrnSize.width, scrnSize.height - tbH);
    
    Collision coll = new Collision();
    BallSpawner bs = new BallSpawner();

    public Board()
    {
        BG = new RGB(162, 61, 155);
        this.setLayout(null);
        this.setBackground(new Color(BG.r, BG.g, BG.b));
        this.setPreferredSize(new Dimension(boardSize.x, boardSize.y));
        
        bs.Spawn(balls, 20, this);
    }
    
    public void Go()
    {       
        while(true)
        {
            for(int i = 0; i < balls.size(); i++)
                balls.get(i).Move(boardSize);
            coll.CollDetection(balls, .5f);
            this.repaint();
            try {Thread.sleep(10);} catch (InterruptedException ex){}
        }
    }

    // this doesn't work
    public void keyPressed(KeyEvent key) 
    {
        if (key.getKeyCode() == KeyEvent.VK_SPACE) 
            bs.Spawn(balls, 1, this);
    }
    
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);
        for(int i = 0; i < balls.size(); i++)
                balls.get(i).Draw(page);
    }

    public Vector2Int getBSize() { return boardSize; }
}
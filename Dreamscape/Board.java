import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel
{
    Dimension scrnSize = Toolkit.getDefaultToolkit().getScreenSize(); // Get the size of the screen.
    Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds(); // Acount for Taskbar size.
    int tbH = scrnSize.height - winSize.height;
    
    RGBA BG;
    Vector2Int boardSize = new Vector2Int(scrnSize.width, scrnSize.height - tbH);
    
    ArrayList<Ball> balls = new ArrayList<Ball>();
    BallSpawner bs;
    
    public Board()
    {
        //System.out.println("Boardsize: " + boardSize.x + " " + boardSize.y);
        BG = new RGBA(66, 69, 73, 255);
        this.setLayout(null);
        this.setBackground(new Color(BG.r, BG.g, BG.b));
        this.setPreferredSize(new Dimension((int)boardSize.x, (int)boardSize.y));
        this.setFocusable(true);
                
        bs = new BallSpawner(this);
        int c = 0;
        while(c < 500) { bs.Spawn(balls); c++; }
    }
    
    public void Go()
    {
        while(true)
        {
            bs.Spawn(balls);
            for(int i = 0; i < balls.size(); i++)
                balls.get(i).Move(boardSize);

            this.repaint();  
            try {Thread.sleep(10);} catch (InterruptedException ex){}
        }
    }
    
    Vector2Int GenerateBSPos()
    {
        int x; int y;
        // spawn points are located outside of the board and spew balls into the board
        // decides if this is an x sided or y sided spawner
        if((byte)(Math.random() * 2) > 0)
        {
            if((byte)Math.random() * 2 > 0) {x = boardSize.x + 100;}
            else {x = -100;}
            y = (int)(Math.random() * (boardSize.y + 200)) - 100; 
        }
        else
        {
            if((byte)(Math.random() * 2) > 0) {y = boardSize.y + 100;}
            else {y = (boardSize.y * -1) - 100;}
            x = (int)(Math.random() * (boardSize.x + 200)) - 100;
        }
        return new Vector2Int(x,y);
    }
    
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);
        for(int i = 0; i < balls.size(); i++) 
            balls.get(i).Draw(page);
    }
    public void RemoveBall(Ball ball) { balls.remove(ball); }// this should be its own class due to SRP but i am too lazy rn
    public Vector2Int getBSize(){ return boardSize; }
}
import javax.swing.*;
import java.awt.*;

public class Board extends JPanel
{
    Dimension scrnSize = Toolkit.getDefaultToolkit().getScreenSize(); // Get the size of the screen.
    Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds(); // Acount for Taskbar size.
    int tbH = scrnSize.height - winSize.height;
    
    RGBA BG;
    Vector2Int boardSize = new Vector2Int(scrnSize.width, scrnSize.height - tbH);
    
    BallSpawner[] bsc = new BallSpawner[2];

    public Board()
    {
        BG = new RGBA(66, 69, 73, 255);
        this.setLayout(null);
        this.setBackground(new Color(BG.r, BG.g, BG.b));
        this.setPreferredSize(new Dimension((int)boardSize.x, (int)boardSize.y));
        
        for(int i = 0; i < bsc.length; i++) // Create Ball Spawners
        {
            boolean c;
            if((int)Math.random() * 2 > 0) { c = true; } else { c = false; }
            bsc[i] = new BallSpawner();
            bsc[i].Spawn(c, this);
            
            int x; int y;
            // spawn points are located outside of the board and spew balls into the board
            // decides if this is an x sided or y sided spawner
            if((int)Math.random() * 2 > 0)
            {
                if((int)Math.random() * 2 > 0) {x = boardSize.x + 100;}
                else {x = (boardSize.x * -1) - 100;}
                y = (int)Math.random() * (boardSize.y + 200) - 100; 
            }
            else
            {
                if((int)Math.random() * 2 > 0) {y = boardSize.y + 100;}
                else {y = (boardSize.y * -1) - 100;}
                x = (int)Math.random() * (boardSize.x + 200) - 100;
            } 
            bsc[i].SetPos(x, y);
        }
        this.setFocusable(true);
    }
    
    public void Go() throws InterruptedException
    {
        while(true)
        {
            // I'm doing this instead of having 1 global list for more control over groups of balls, and in case I want to make
            // Special interactions with balls based on their spawner.
            for(int i = 0; i < bsc.length; i++)
                for(int t = 0; t < bsc[i].GetBalls().size(); t++)
                    bsc[i].GetBalls().get(t).Move(boardSize);

            this.repaint();
            try {Thread.sleep(10);} catch (InterruptedException ex){}
        }
    }
    
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);
        for(int i = 0; i < bsc.length; i++) 
            for(int t = 0; t < bsc[i].GetBalls().size(); t++) 
                bsc[i].GetBalls().get(t).Draw(page);
    }

    public Vector2Int getBSize(){ return boardSize; }
}
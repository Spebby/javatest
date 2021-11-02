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
    
    BallSpawner[] bsc = new BallSpawner[4];

    public Board()
    {
        BG = new RGBA(162, 61, 155, 255);
        this.setLayout(null);
        this.setBackground(new Color(BG.r, BG.g, BG.b));
        this.setPreferredSize(new Dimension(boardSize.x, boardSize.y));
        
        for(int i = 0; i < bsc.length; i++){
            boolean c;
            if((int)Math.random() * 2 > 0) { c = true; } else { c = false; }
            bsc[i] = new BallSpawner();
            bsc[i].Spawn(balls, c, this);
            
            int x; int y;
            // spawn points are located outside of the board and spew balls into the board
            // decides if this is an x sided or y sided spawner
            if((int)Math.random() * 2 > 0){
                if((int)Math.random() * 2 > 0) {x = boardSize.x + 100;}
                else {x = (boardSize.x * -1) - 100;}
                y = (int)Math.random() * (boardSize.y + 200) - 100; }
            else{
                if((int)Math.random() * 2 > 0) {y = boardSize.y + 100;}
                else {y = (boardSize.y * -1) - 100;}
                x = (int)Math.random() * (boardSize.x + 200) - 100; } 
            bsc[i].SetPos(x, y);}
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
        for(int i = 0; i < balls.size(); i++) {balls.get(i).Draw(page);}
    }
    // encapsulation
    public Vector2Int getBSize(){ return boardSize; }
}

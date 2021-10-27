import java.awt.*;
public class Player
{
    private int x, y, size;
    private boolean left, right, up, down;
    private int points;
    
    public Player()
    {
        x = 950;
        y = 250;
        size = 50;
        up = false;
        down = false;
        left = false;
        right = false;
        
    }
    
    public void hit()
    {
        points++;
    }
    
    
    public int getPoints()
    {
        return points;
    }
    
    public void move()
    {
        if (right == true && x+size <1000)
        {
            x += 2; 
        }
        else if (left == true && x>0)
        {
            x -= 2; 
        }
        else if (up == true && y>0)
        {
            y -= 2; 
        }
        else if (down == true && y + size < 600)
        {
            y += 2; 
        }
    }
    
    public void setRight( boolean t)
    {
        right = t;
    }
    
    public void setLeft( boolean t)
    {
        left = t;
    }
    
    public void setUp( boolean t)
    {
        up = t;
    }
    
    public void setDown( boolean t)
    {
        down = t;
    }
    
    public int getCenterX()
    {
        return x + size/2;
    }
    
    public int getCenterY()
    {
        return y + size/2;
    }
    
    public int getRadius()
    {
        return size/2;
    }
    
    public void draw(Graphics page)
    {
        page.setColor( Color.WHITE );
        page.fillOval(x, y, size, size);
    }
}
import java.awt.*;

public class Circle
{
    private int x;
    private int y;
    private int xInc;
    private int yInc;
    private int size;

    private Color color;
    public Circle( int xPos, int yPos, int sizE, int colorR, int colorG, int colorB, int moveSpeedY, int moveSpeedX)
    {
        x = xPos;
        y = yPos;
        xInc = moveSpeedX;
        yInc = moveSpeedY;
        size = sizE;
        color = new Color(colorR, colorG, colorB);
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
    
    public void hit(boolean t)
    {
        if (t)
        {
            y = 1000;
        }
    }
    
    public void move()
    {
        x += xInc;
        y += yInc;
        if (x <= 0 || x + size >= 1000)
        {
            xInc *= -1;
        }
        if (y <= 0 || y + size >= 600)
        {
            yInc *= -1;
        }
        
    }
    //draws the square
    public void draw( Graphics page)
    {
        page.setColor(color);
        page.fillOval(x, y, size, size);
    }

}
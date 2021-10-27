import java.awt.*;
public class Square
{
    private int x;

    private int y;

    private int xInc;
    private int yInc;

    private int sizeW;
    private int sizeH;
    
    private Color color;

    private int upperLimit;
    private int lowLimit;
    public Square( int xPos, int yPos, int sizew, int sizeh, int colorR, int colorG, int colorB, int moveSpeedY, int moveSpeedX)
    {
        x = xPos;
        y = yPos;
        xInc = moveSpeedX;
        yInc = moveSpeedY;
        sizeW = sizew;
        sizeH = sizeh;
        color = new Color(colorR, colorG, colorB);
    }
    
    public int getCenterX()
    {
        return x + sizeW/2;
    }
    
    public int getCenterY()
    {
        return y + sizeH/2;
    }
    
    public int getRadius()
    {
        return sizeW/2;
    }
    
    public void move()
    {
        x += xInc;
        y += yInc;
        if (x <= 0 || x + sizeW >= 1000)
        {
            xInc *= -1;
        }
        if (y <= 180 || y + sizeW >= 500)
        {
            yInc *= -1;
        }
        
    }
    //draws the square
    public void draw( Graphics page)
    {
        page.setColor(color);
        page.fillRect(x,y, sizeW, sizeH);
    }
}
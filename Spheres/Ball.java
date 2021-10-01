import java.awt.*;

public class Ball
{
    Vector2Int pos = new Vector2Int((int)(Math.random() * 800), (int)(Math.random() * 400));
    Vector2Int inc = new Vector2Int((int)(Math.random() * 7) - 3, (int)(Math.random() * 7) - 3);
    int size = ((int)(Math.random() * 150) + 50);
    public RGB colour = new RGB( (int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
    Color bColor = new Color (colour.r, colour.g, colour.b);
    
    public void Move()
    {
        pos.x += inc.x;
        pos.y += inc.y;
        if(pos.x < 0 || pos.x > 100)
            Bounce('X');
        if(pos.y < 0 || pos.y > 100)
            Bounce('Y');
    }
    
    void Bounce(char c)
    {
        if(c == 'X')
            inc.x = -inc.x;
        if(c == 'Y')
            inc.y = -inc.y;
    }
    
    public void Draw(Graphics page)
    {
        page.setColor(bColor);
        page.fillOval(pos.x, pos.y, size, size);
    }
}
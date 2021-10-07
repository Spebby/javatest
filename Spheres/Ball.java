import java.awt.*;

public class Ball
{
    Board board;
    
    Vector2Int pos;
    Vector2Int inc;
    int size;
    RGB rgb;
    Color colour;
    
    public Ball(Board b)
    {
        board = b;
        pos = new Vector2Int((int)(Math.random() * 800), (int)(Math.random() * 400));
        inc = new Vector2Int((int)(Math.random() * 7) - 3, (int)(Math.random() * 7) - 3);
        size = ((int)(Math.random() * 150) + 50);
        rgb = new RGB( (int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
        colour = new Color (rgb.r, rgb.g, rgb.b);
    }
    
    public void Move(Vector2Int bd)
    {
        pos.x += inc.x;
        pos.y += inc.y;
        // Rewrite collision system to be based on actual colliders, rather than dimensions
        if(pos.x < 0 || pos.x > bd.x - size)
            Bounce('X');
        if(pos.y < 0 || pos.y > bd.y - size)
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
        page.setColor(colour);
        page.fillOval(pos.x, pos.y, size, size);
    }
}
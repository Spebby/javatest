import java.awt.*;

public class Ball
{
    Board board;
    
    Vector2Int pos;
    Vector2Int vel;
    int size;
    RGB rgb;
    Color colour;
    boolean active;
    
    public Ball(Board b)
    {
        board = b;
        active = true;
        pos = new Vector2Int(b.getBSize().x - (size + 100), b.getBSize().y - (size + 100));
        vel = new Vector2Int(0,0);
        size = ((int)(Math.random() * 150) + 50); // The spheres have the same x & y dimensions
        rgb = new RGB( (int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
        colour = new Color (rgb.r, rgb.g, rgb.b); // Vector 3
    }
    
    public void Move(Vector2Int bd)
    {
        pos.x += vel.x;
        pos.y += vel.y;
    }
    
    public void Draw(Graphics page)
    {
        page.setColor(colour);
        page.fillOval(pos.x, pos.y, size, size);
    }

    public Vector2Int getPos() { return pos; }
    public void setVel(Vector2Int velo) { vel = velo; }
    public int getSize() { return size; }
    public boolean getActive() { return active; }
}

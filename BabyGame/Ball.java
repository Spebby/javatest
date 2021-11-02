import java.awt.*;

public class Ball
{
    Board board;
    Player player;
    
    Vector2Int pos;
    Vector2Int vel;
    int size;
    RGB rgb;
    Color colour;
    boolean active;
    
    public Ball(Board b, Player p)
    {
        player = p;
        board = b;
        active = true;
        pos = new Vector2Int(b.getBSize().x/2, 150);
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

    public Vector2Int GetPos() { return pos; }
    public void SetVel(Vector2Int velo) { vel = velo; }
    public int GetSize() { return size; }
    public boolean GetActive() { return active; }
}
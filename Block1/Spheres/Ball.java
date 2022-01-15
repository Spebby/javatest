package Spheres;
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
        // Pos is the position, vel is the velocity. Give random variables.
        pos = new Vector2Int((int)(Math.random() * b.getBSize().x) - (size + 100), (int)(Math.random() * b.getBSize().y) - (size + 100));
        // Incase something goes very very wrong
        if(pos.x >= b.getBSize().x - (size + 100) || pos.x <= 0 + (size + 100))
            pos.x = (int)(Math.random() * b.getBSize().x) - (size + 300);
        if(pos.y >= b.getBSize().y - (size + 100) || pos.y <= 0 + (size + 100))
            pos.y = (int)(Math.random() * b.getBSize().x) - (size + 300);

        vel = new Vector2Int((int)(Math.random() * 7) - 3, (int)(Math.random() * 7) - 3);
        // Incase velocity = 0 on any axis, always want some movement
        if(vel.x == 0)
            vel.x++;
        if(vel.y == 0)
            vel.y++;
        size = ((int)(Math.random() * 150) + 50);
        rgb = new RGB( (int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
        colour = new Color (rgb.r, rgb.g, rgb.b);
    }
    
    public void Move(Vector2Int bd)
    {
        pos.x += vel.x;
        pos.y += vel.y;
        // When hit borders, BOUNCE
        if(pos.x < 0 || pos.x > bd.x - size)
            Bounce('X');
        if(pos.y < 0 || pos.y > bd.y - size)
            Bounce('Y');
    }
    
    // Consider making this its own class, SRP and all.
    public void Bounce(char c)
    {
        // X = X-Axis, Y = Y-Axis, B = Both
        switch(c)
        {
            case 'X':
                vel.x = -vel.x;
                break;
            case 'Y':
                vel.y = -vel.y;
                break;
            case 'B':
                vel.x = -vel.x;
                vel.y = -vel.y;
                break;
            default:
                break;
        }
    }
    
    // Make a more dyanmic drawing script
    public void Draw(Graphics page)
    {
        page.setColor(colour);
        page.fillOval(pos.x, pos.y, size, size);
    }
    //ecapsulation
    public Vector2Int getPos() { return pos; }
    public int getSize() { return size; }
    public boolean getActive() { return active; }
}

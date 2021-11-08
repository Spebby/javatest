import java.awt.*;
import java.lang.Math;

public class Ball
{
    Board board;

    // sPost is "Starting Position"
    Vector2Int pos;
    Vector2Int vel;
    int size;
    RGBA rgb; Color colour;
    boolean active;
    float speed = (float)(Math.random() * 2) + 1;

    public Ball(Board b)
    {   
        board = b; active = true;
        rgb = new RGBA((byte)(Math.random() * 256), (byte)(Math.random() * 256), (byte)(Math.random() * 256), 0);
        
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
        
        //System.out.println( v.x + " " + v.y );
        size = ((int)(Math.random() * 350) + 50);
        colour = new Color (rgb.r, rgb.g, rgb.b, rgb.a);
    }
    
    public void Move(Vector2Int bd) 
    { 
        boolean trigger = false;
        pos.x += vel.x; pos.y += vel.y; size++;
        if(rgb.a < 255 && trigger == false)
            rgb.a += 1;
        if(rgb.a >= 255 || trigger == true)
        {
            trigger = true;
            rgb.a--;
            if(rgb.a <= 0)
                active = false; board.RemoveBall(this);
        }
        colour = new Color (rgb.r, rgb.g, rgb.b, rgb.a);
    }
    public void Draw(Graphics page)
    {
        page.setColor(colour);
        page.fillOval((int)pos.x, (int)pos.y, size, size);
    }

    public Vector2Int GetPos() { return pos; }
    public int GetSize() { return size; }
    public boolean GetActive() { return active; }
    public RGBA GetRGBA() { return rgb; };
    public void SetRGBA(int r, int b, int g, int a) { rgb.r = r; rgb.b = b; rgb.g = g; rgb.a = a; }
}
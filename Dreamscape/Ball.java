import java.awt.*;
import java.lang.Math;

public class Ball
{
    Board board;

    // sPost is "Starting Position"
    Vector2Int pos = new Vector2Int(0,0); Vector2Int sPos = new Vector2Int(0,0);
    Vector2 vel = new Vector2(0,0);
    int size;
    RGBA rgb; Color colour;
    boolean active;
    
    public Ball(Board b, Vector2Int p, Vector2 v, RGBA r, boolean RandomVel)
    {   
        board = b; active = true; pos = p; sPos = p;
        double speed = Math.random() * 2;
        rgb = r;

        if(RandomVel){ // Rewrite this to work with Spawner's Angles
            vel.x = (int)(v.x * (Math.random() * 1.25f)) * speed;
            vel.y = (int)(v.y * (Math.random() * 1.25f)) * speed;} 
        else {vel.x = v.x * speed; vel.x = v.x * speed;}

        size = ((int)(Math.random() * 150) + 50);
        colour = new Color (rgb.r, rgb.g, rgb.b);
    }
    
    public void Move(Vector2Int bd) 
    { 
        pos.x += (int)vel.x; pos.y += (int)vel.y; 
        size--;
        if(size <= 5)
            active = false;
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
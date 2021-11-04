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
    
    public Ball(Board b, Vector2Int p, Vector2 v, RGBA r)
    {   
        board = b; active = true; pos = p; sPos = p;
        rgb = r;

        vel = v;
        //System.out.println( v.x + " " + v.y );
        size = ((int)(Math.random() * 150) + 50);
    }
    
    public void Move(Vector2Int bd) 
    { 
        pos.x += vel.x; pos.y += vel.y; rgb.a--;
        if(rgb.a == 0) { active = false; board.RemoveBall(this); pos.x = 9^9; pos.y = 9^9; }
    }
    public void Draw(Graphics page)
    {
        colour = new Color(rgb.r, rgb.g, rgb.b, rgb.a);
        page.setColor(colour);
        page.fillOval((int)pos.x, (int)pos.y, size, size);
    }

    public Vector2Int GetPos() { return pos; }
    public int GetSize() { return size; }
    public boolean GetActive() { return active; }
    public RGBA GetRGBA() { return rgb; };
    public void SetRGBA(int r, int b, int g, int a) { rgb.r = r; rgb.b = b; rgb.g = g; rgb.a = a; }
}
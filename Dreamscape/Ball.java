import java.awt.*;
import java.lang.Math;

public class Ball
{
    Board board;
    
    Vector2Int pos = new Vector2Int(0,0);
    Vector2Int vel = new Vector2Int(0,0);
    int size;
    RGBA rgb; Color colour;
    boolean active;
    
    public Ball(Board b, Vector2Int p, Vector2Int v, boolean RandomVel)
    {
        board = b;
        active = true;
        pos = p;
        if(RandomVel){
            vel.x = (int)(v.x * (Math.random() * 2));
            vel.y = (int)(v.y * (Math.random() * 2));} 
        else {vel = v;}
        if(vel.x == 0) {vel.x++;} if(vel.y == 0) {vel.y++;}
        size = ((int)(Math.random() * 150) + 50); // The spheres have the same x & y dimensions
        rgb = new RGBA((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256), 255);
        colour = new Color (rgb.r, rgb.g, rgb.b); // Vector 3
    }
    
    public void Move(Vector2Int bd){ pos.x += vel.x; pos.y += vel.y; }
    public void Draw(Graphics page){
        page.setColor(colour);
        page.fillOval(pos.x, pos.y, size, size);} // Make a more dyanmic drawing script
    //ecapsulation
    public Vector2Int GetPos() { return pos; }
    public int GetSize() { return size; }
    public boolean GetActive() { return active; }
}

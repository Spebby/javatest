import java.util.ArrayList;

public class BallSpawner
{
    Vector2Int pos = new Vector2Int(0,0);
    ArrayList<Ball> balls = new ArrayList<Ball>();
    public void Spawn(boolean RandomVelocity, Board b)
    {
        // Add code that figures out which direction the centre of the screen is, then start spewing balls that direciton
        Vector2 SA = new Vector2(b.boardSize.x - pos.x, b.boardSize.y - pos.y);
        SA = new Vector2(SA.x/Math.sqrt(SA.x*SA.x + SA.y*SA.y), SA.y/Math.sqrt(SA.x*SA.x + SA.y*SA.y));
        // i don't want to have to write b.boardSize. - pos. over and over so i'm just overwriting it for readability sake
        RGBA rgb = new RGBA((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256), 255);

        while(true)
        {
            for(int i = 0; i < balls.size(); i++) if(balls.get(i).GetActive() != true) { balls.remove(i); i--; } // cleaner
            Ball b0 = new Ball(b, pos, SA, rgb, RandomVelocity);
            balls.add(b0);
        }
    }
    
    public Vector2Int GetPos() { return pos; }
    public Vector2Int SetPos(int x, int y) { pos.x = x; pos.y = y; return pos; }
    public ArrayList<Ball> GetBalls() { return balls; }
}
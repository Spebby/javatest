import java.util.ArrayList;

public class BallSpawner
{
    Vector2Int pos = new Vector2Int(0,0);
    public void Spawn(ArrayList<Ball> balls, boolean RandomVelocity, Board b)
    {
        while(true)
        {
            // 3,9 is a placeholder for now
            Ball b0 = new Ball(b, pos, new Vector2Int(3, 9), RandomVelocity);
            balls.add(b0);
        }
    }
    
    public Vector2Int GetPos() { return pos; }
    public Vector2Int SetPos(int x, int y) { pos.x = x; pos.y = y; return pos; }
}
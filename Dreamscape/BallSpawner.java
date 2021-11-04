import java.util.ArrayList;

public class BallSpawner
{
    Vector2Int pos = new Vector2Int(0,0);
    Vector2 SA;
    RGBA rgb;
    Board board;
    
    public BallSpawner(Board b)
    {
        // Add code that figures out which direction the centre of the screen is, then start spewing balls that direciton
        SA = new Vector2((int)(b.boardSize.x/2) - pos.x, (int)(b.boardSize.y/2) - pos.y);
        SA = new Vector2(SA.x/Math.sqrt(SA.x*SA.x + SA.y*SA.y), SA.y/Math.sqrt(SA.x*SA.x + SA.y*SA.y));
        // i don't want to have to write b.boardSize. - pos. over and over so i'm just overwriting it for readability sake
        rgb = new RGBA((byte)(Math.random() * 256), (byte)(Math.random() * 256), (byte)(Math.random() * 256), 255);
        board = b;
    }
    public void Spawn(ArrayList<Ball> balls)
    {
        Ball b0 = new Ball(board, pos, SA, rgb);
        balls.add(b0);
    }

    public Vector2Int GetPos() { return pos; }
    public Vector2Int SetPos(int x, int y) { pos.x = x; pos.y = y; return pos; }
}
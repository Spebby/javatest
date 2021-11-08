import java.util.ArrayList;

public class BallSpawner
{
    //Vector2 vel;
    RGBA rgb;
    Board board;
    
    public BallSpawner(Board b)
    {
        board = b;
        //CalculateVel();
    }
    
    /*void CalculateVel()
    {
        // Add code that figures out which direction the centre of the screen is, then start spewing balls that direciton
        vel = new Vector2((pos.x - board.boardSize.x/2), pos.y - (board.boardSize.y/2)).Normalized();
        System.out.println( pos.x + " " + pos.y );
        System.out.println( "vel: " + vel.x + " " + vel.y );
        // i don't want to have to write b.boardSize. - pos. over and over so i'm just overwriting it for readability sake
    }*/
    
    public void Spawn(ArrayList<Ball> balls)
    {
        Ball b0 = new Ball(board);
        balls.add(b0);
    }

    //public Vector2Int GetPos() { return pos; }
    //public void SetPos(int x, int y) { pos.x = x; pos.y = y; CalculateVel(); }
}
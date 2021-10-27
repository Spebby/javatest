import java.util.ArrayList;

public class BallSpawner
{
    public void Spawn(ArrayList<Ball> balls, int amount, Board b)
    {
        for(int i = 0; i < amount; i++)
        {
            Ball b0 = new Ball(b);
            balls.add(b0);
            //System.out.println("ball spawned: " + i);
        }
    }
}
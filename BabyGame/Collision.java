import java.util.ArrayList;

public class Collision
{
    GameManager gm = new GameManager();
    
    public void CollDetection(ArrayList<Ball> balls, float SFactor)
    {
        for (int i = 0; i < balls.size(); i++) if(balls.get(i).GetActive() == true) // 
        {
            for (int j = i + 1; j < balls.size(); j++) if(balls.get(j).GetActive() == true)
            {
                // xDif and yDif are calculated with a half baked Pythagora's theorum 
                int xDif = (balls.get(i).GetPos().x + balls.get(i).GetSize()/2) - (balls.get(j).GetPos().x + balls.get(j).GetSize()/2);
                int yDif = (balls.get(i).GetPos().y + balls.get(i).GetSize()/2) - (balls.get(j).GetPos().y + balls.get(j).GetSize()/2);
                double dist = Math.sqrt((xDif * xDif) + (yDif * yDif));
                // If the distance of the balls is less than the size of the balls, they bounce off each other and Shrink
                if(dist <= balls.get(i).GetSize()/2 + balls.get(j).GetSize()/2)
                {
                    // die
                }
            }
        }
    }
}

/*
    public boolean collide(Square s)
    {
        int xDiff = s.getCenterX() - player.getCenterX();
        int yDiff = s.getCenterY() - player.getCenterY();
        double dist = Math.sqrt( xDiff*xDiff + yDiff*yDiff);
        if (dist <= s.getRadius() + player.getRadius() )
        {
            return true;
        }
        return false;
    }
    
    public boolean collideC(Circle c)
    {
        int xDiff = c.getCenterX() - player.getCenterX();
        int yDiff = c.getCenterY() - player.getCenterY();
        double dist = Math.sqrt( xDiff*xDiff + yDiff*yDiff);
        if (dist <= c.getRadius() + player.getRadius() )
        {
            return true;
        }
        return false;
    }
 */

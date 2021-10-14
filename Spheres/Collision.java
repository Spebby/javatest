import java.util.ArrayList;

public class Collision
{
    ShrinkHandler s = new ShrinkHandler();

    public void CollDetection(ArrayList<Ball> balls, float SFactor)
    {
        for (int i = 0; i < balls.size(); i++) if(balls.get(i).getActive() == true) // 
        {
            for (int j = i + 1; j < balls.size(); j++) if(balls.get(j).getActive() == true)
            {
                // xDif and yDif are calculated with a half baked Pythagora's theorum 
                int xDif = (balls.get(i).getPos().x + balls.get(i).getSize()/2) - (balls.get(j).getPos().x + balls.get(j).getSize()/2);
                int yDif = (balls.get(i).getPos().y + balls.get(i).getSize()/2) - (balls.get(j).getPos().y + balls.get(j).getSize()/2);
                double dist = Math.sqrt((xDif * xDif) + (yDif * yDif));
                // If the distance of the balls is less than the size of the balls, they bounce off each other and Shrink
                if(dist <= balls.get(i).getSize()/2 + balls.get(j).getSize()/2)
                {
                    balls.get(i).Bounce('B');
                    balls.get(j).Bounce('B');
                    
                    s.Shrink(balls.get(i), (balls.get(i).size * 0.2f) * SFactor);
                    s.Shrink(balls.get(j), (balls.get(i).size * 0.2f) * SFactor);
                }
            }
        }
    }
}
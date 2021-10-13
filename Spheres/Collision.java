public class Collision
{
    ShrinkHandler s = new ShrinkHandler();

    public void CollDetection(Ball[] balls)
    {
        for (int i = 0; i < balls.length; i++) if(balls[i].getActive())
        {
            for (int j = i + 1; j < balls.length; j++) if(balls[j].getActive())
            {
                int xDif = (balls[i].getPos().x + balls[i].getSize()/2) - (balls[j].getPos().x + balls[j].getSize()/2);
                int yDif = (balls[i].getPos().y + balls[i].getSize()/2) - (balls[j].getPos().y + balls[j].getSize()/2);
                double dist = Math.sqrt((xDif * xDif) + (yDif * yDif));
                if(dist <= balls[i].getSize()/2 + balls[j].getSize()/2)
                {
                    balls[i].Bounce('B');
                    balls[j].Bounce('B');
                    
                    s.Shrink(balls[i], ((int)(Math.random() * 125) + 50));
                    s.Shrink(balls[j], ((int)(Math.random() * 125) + 50));
                }
            }
            else
                j++;
        }
        else
            i++;
    }
}
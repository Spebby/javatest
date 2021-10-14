public class ShrinkHandler
{
    int cutoff = 30;
    public void Shrink(Ball ball, float amount)
    {
        Math.round(ball.size -= amount);
        if(ball.size <= cutoff)
        {
            ball.pos.x = 9999;
            ball.pos.y = 9999;
            ball.active = false;
        }
    }
}
public class ShrinkHandler
{
    public void Shrink(Ball ball, int amount)
    {
        ball.size -= amount;
        if(ball.size <= 0)
        {
            ball.pos.x = 9999;
            ball.pos.y = 9999;
            ball.active = false;
        }
    }
}
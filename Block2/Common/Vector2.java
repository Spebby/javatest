package Common;

public class Vector2 
{
    public double x;
    public double y;

    public Vector2(double x, double y) 
    {
        this.x = x;
        this.y = y;
    }
    public Vector2(double x) 
    {
        this.x = x;
        this.y = x;
    }
    public Vector2() 
    {
        this.x = 0;
        this.y = 0;
    }

    public static Vector2 Zero()
    {
        return new Vector2();
    }
}

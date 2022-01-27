package Common;

public class Vector2Int 
{
    public double x;
    public double y;

    public Vector2Int(double x, double y) 
    {
        this.x = x;
        this.y = y;
    }
    public Vector2Int(double x) 
    {
        this.x = x;
        this.y = x;
    }
    public Vector2Int() 
    {
        this.x = 0;
        this.y = 0;
    }
    public static Vector2Int Zero()
    {
        return new Vector2Int();
    }
}
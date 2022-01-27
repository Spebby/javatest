package Common;

public class Vector3 
{
    public double x;
    public double y;
    public double z;

    public Vector3(double x, double y, double z) 
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Vector3(double x, double y) 
    {
        this.x = x;
        this.y = y;
        this.z = 0;
    }
    public Vector3(double x) 
    {
        this.x = x;
        this.y = x;
        this.z = x;
    }
    public Vector3() 
    {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
    public static Vector3 Zero()
    {
        return new Vector3();
    }
}

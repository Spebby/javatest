package Dreamscape;

public class Vector2
{
    public double x; public double y; 
    public Vector2(double a, double b){this.x = a; this.y = b;} 

    public double Magnitude()
    { 
        double mag = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)); 
        return mag; 
    }

    public Vector2 Normalized()
    {
        Vector2 n = new Vector2(this.x/this.Magnitude(), this.y/this.Magnitude());
        return n;
    }
}
public class Vector2Int
{
    // I want to use these freely, no encapsulation
    public int x;
    public int y;
    
    public Vector2Int(int a, int b)
    {
        a = Math.abs(a);
        b = Math.abs(b);
        
        this.x = a;
        this.y = b;
    }
}
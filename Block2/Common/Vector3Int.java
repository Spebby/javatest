package Common;

public class Vector3Int 
{
    public int x;
    public int y;
    public int z;

    public Vector3Int(int x, int y, int z) 
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Vector3Int(int x, int y) 
    {
        this.x = x;
        this.y = y;
        this.z = 0;
    }
    public Vector3Int(int x) 
    {
        this.x = x;
        this.y = x;
        this.z = x;
    }
    public Vector3Int() 
    {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
    public static Vector3Int Zero()
    {
        return new Vector3Int();
    }
}

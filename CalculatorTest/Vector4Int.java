// Taken from https://noobtuts.com/java/vector2-class; modifed to fit Ints & a fourth vector
public class Vector4Int
{              
    // Members
    public int x;
    public int y;
    public int z;
    public int w;
       
    // Constructors
    public Vector4Int() 
    {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.w = 0;
    }
       
    public Vector4Int(int x, int y, int z, int w) 
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
       
    // Compare three vectors
    public boolean equals(Vector4Int other) 
    {
        return (this.x == other.x && this.y == other.y && this.z == other.z && this.w == other.w);
    }
}
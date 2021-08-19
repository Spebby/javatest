// Taken from https://noobtuts.com/java/vector2-class; a fourth vector
public class Vector4
{              
    // Members
    public float x;
    public float y;
    public float z;
    public float w;
       
    // Constructors
    public Vector4() 
    {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.w = 0;
    }
       
    public Vector4(float x, float y, float z, float w) 
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
       
    // Compare three vectors
    public boolean equals(Vector4 other) 
    {
        return (this.x == other.x && this.y == other.y && this.z == other.z && this.w == other.w);
    }
}
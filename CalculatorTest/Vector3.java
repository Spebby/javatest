// Taken from https://noobtuts.com/java/vector2-class; a third vector
public class Vector3
{              
    // Members
    public float x;
    public float y;
    public float z;
       
    // Constructors
    public Vector3() 
    {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
       
    public Vector3(float x, float y, float z) 
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
       
    // Compare three vectors
    public boolean equals(Vector3 other) 
    {
        return (this.x == other.x && this.y == other.y && this.z == other.z);
    }
}

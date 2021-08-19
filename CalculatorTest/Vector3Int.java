// Taken from https://noobtuts.com/java/vector2-class; modifed to fit Ints & a third vector
public class Vector3Int
{              
    // Members
    public int x;
    public int y;
    public int z;
       
    // Constructors
    public Vector3Int() 
    {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
       
    public Vector3Int(int x, int y, int z) 
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
       
    // Compare three vectors
    public boolean equals(Vector3Int other) 
    {
        return (this.x == other.x && this.y == other.y && this.z == other.z);
    }
}

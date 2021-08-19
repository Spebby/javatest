// Taken from https://noobtuts.com/java/vector2-class
public class Vector2
{              
    // Members
    public float x;
    public float y;
       
    // Constructors
    public Vector2() 
    {
        this.x = 0;
        this.y = 0;
    }
       
    public Vector2(float x, float y) 
    {
        this.x = x;
        this.y = y;
    }
       
    // Compare two vectors
    public boolean equals(Vector2 other) 
    {
        return (this.x == other.x && this.y == other.y);
    }
}
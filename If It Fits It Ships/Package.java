public class Package
{
    float weight;
    float girth;
    float length;
    float sideX;
    float sideY;
    float sideZ;
    
    public Package(float wt, float x, float y, float z)
    {
        weight = wt;
        sideX = x;
        sideY = y;
        sideZ = z;
        
        if(x >= y && x >= z)
        {
            length = x;
            girth = (2 * (x + z));
        }
        else if(y >= x && y >= z)
        {
            length = y;
            girth = (2 * (x + z));
        }
        else
        {
            length = z;
            girth = (2 * (x + y));
        }
    }
    
    public float getWeight()
    {
        return weight;
    }
    
    public float getGirth()
    {
        return girth;
    }
    
    public float getLength()
    {
        return length;
    }
    
    /*
    public float getX()
    {
     return sideX;
    }
    
    public float getY()
    {
        return sideY;
    }
    
    public float getZ()
    {
        return sideZ;
    }
    */
}
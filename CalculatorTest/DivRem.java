// Input two values, get the division and remainder.
public class DivRem
{
    public float i0;
    public float i1;
    
    public float Div;
    public float Rem;
    
    public DivRem()
    {
        this.i0 = 0;
        this.i1 = 0;
    }
    
    public DivRem(float input0, float input1)
    {
        this.i0 = input0;
        this.i1 = input1;
        
        Div = i0/i1;
        Rem = i0/i1;
    }
}
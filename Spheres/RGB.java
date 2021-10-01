public class RGB
{
    // I want to use these freely, no encapsulation
    public int r;
    public int g;
    public int b;
    
    public RGB(int a, int b, int c)
    {
        a = Math.abs(a);
        b = Math.abs(b);
        c = Math.abs(c);
        
        // foreach might work better for this idc tho
        if(a > 255)
            a = 255;
        if(b > 255)
            b = 255;
        if(c > 255)
            c = 255;
        
        this.r = a;
        this.g = b;
        this.b = c;
    }
}
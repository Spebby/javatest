public class RGBA{
    public int r; public int g; public int b; public int a;
    public RGBA(int a, int b, int c, int d) {
        a = Math.abs(a); b = Math.abs(b); c = Math.abs(c); d = Math.abs(d);
        if(a > 255) {a = 255;} if(b > 255) {b = 255;} if(c > 255) {c = 255;} if(d > 255) {d = 255;}
        this.r = a; this.g = b; this.b = c; this.a = d;} }

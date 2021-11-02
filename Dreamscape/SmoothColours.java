import java.util.*;
import java.lang.Object;
public class SmoothColours
{
    // Steps between fading from one colour to another.
    private static final int FadeSteps = 25;

    private void Smooth(RGBA rgb, RGBA target, int FadeSteps) throws InterruptedException 
    {
        int dRed = target.r - rgb.r;
        int dGreen = target.g - rgb.g;
        int dBlue = target.b - rgb.b;
        if (dRed != 0 || dGreen != 0 || dBlue != 0) 
        {
            // Do it in n steps.
            for (int i = 0; i <= FadeSteps; i++) 
            {
                rgb.r += ((target.r * i) / FadeSteps);
                rgb.g += ((target.g * i) / FadeSteps);
                rgb.b += ((target.b * i) / FadeSteps);
                Thread.sleep(34); // in miliseconds
            }
        }
    }
}
// I don't have a project/use for this at the moment, but I also don't want to throw this out.
public class SmoothValues
{
    public void Smooth(RGBA rgb, RGBA target, int FadeSteps) throws InterruptedException 
    {
        if(FadeSteps == 0) { FadeSteps = 25; } // Defaults to 25 if unset
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
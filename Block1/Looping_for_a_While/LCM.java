package Looping_for_a_While;
public class LCM extends DriverFeeder
{
    public void Initialize()
    {
        System.out.print('\f');
        System.out.println("Welcome to the LCM Calculator. Enter two values, and the LCM will be calculated.");
        
        int a, b, lcm;
        a = scan.nextInt();
        b = scan.nextInt();
        lcm = (a > b) ? a : b;
        
        // While loop never ends until LCM perfectly divides a & b. If the loop fails,
        // 1 is added to LCM and it tries again.
        while(true)
        {
            if(lcm % a == 0 && lcm % b == 0)
            {
                System.out.println("The LCM of " + a + " and " + b + " equals " + lcm + ".");
                // ^ could have been a printf, but i don't fully understand what it does.
                break;
            }
            lcm++;
        }
        System.out.println();
        
        LoopProgram();
    }
}
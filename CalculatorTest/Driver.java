/* C# is cooler :)
 * define the class
*/
public class Driver
{
    private float v1;
    private float v2;
    private CalculateMode calType = new CalculateMode();
    
    // calculator mode
    public static void main()
    {
        // We need to start with an interface and then continue into a prompt for the user to use the calculator.
        // The following prints are just a few lines to "pretty up" said prompt. Cooruotines and waits should be added for effect.
        System.out.println("Welcome to");
        // Prints on the same line for effect.
        // Wait of 1/4th of a second inbetween each .
        System.out.print(".");
        System.out.print(".");
        System.out.print(".");
        System.out.println(""); // Empty line for spacing.
        // Wait a full second
        // It may be worth adding waits between each line to invoke the feeling of an archaic machine.
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("_________     _____  .____   _________  ____ ___.____    ________    _________");
        System.out.println("\_   ___ \   /  _  \ |    |  \_   ___ \|    |   \    |   \_____  \  /   _____/");
        System.out.println("/    \  \/  /  /_\  \|    |  /    \  \/|    |   /    |    /   |   \ \_____  \");
        System.out.println("\     \____/    |    \    |__\     \___|    |  /|    |___/    |    \/        \");
        System.out.println(" \______  /\____|__  /_______ \______  /______/ |_______ \_______  /_______  /");
        System.out.println("        \/         \/        \/      \/                 \/       \/        \/ ");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(""); // Empty line for spacing
        
        System.out.println("Enter the first Variable.");
        // Code that allows user to input v1
        // Code that prevents the rest of the code from being proccessed
        
        System.out.println("Enter the Calculator Mode.");
        // Code that allows user to input Calculator Mode.
        // Code that prevents the rest of the code from being proccessed
                           
        System.out.println("Enter the final Variable.");
        // Code that allows user to input Calculator Mode.
        // Code that prevents the rest of the code from being proccessed
        
        Calculator c = new Calculator (v1, v2, calType);
    }
} 
// Obama was here

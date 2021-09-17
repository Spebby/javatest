public class RDigits extends DriverFeeder
{
    public void Initialize()
    {
        System.out.print('\f');
        System.out.println("\"Welcome to Reverse Digits\", enter a number, and it'll be reversed.");
        
        int number = 0, reverse = 0;
        number = scan.nextInt();
        // java jank
        String Nulled = scan.nextLine();
        Nulled = null;
        
        while(number != 0)   
        {  
            int remainder = number % 10;  
            reverse = reverse * 10 + remainder;  
            number = number/10;  
        }  
        System.out.println("The reverse of the given number is: " + reverse);
        System.out.println();
        
        LoopProgram();
    }  
}
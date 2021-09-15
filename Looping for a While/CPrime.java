public class CPrime extends DriverFeeder
{
    public void Initialize(boolean SkipIntro)
    {
        if(!SkipIntro)
        {
            System.out.print('\f');
            System.out.println("Welcome to the Prime Number Calculator.");
            System.out.println("Enter \"0\" when you're ready to quit.");
        }
        int num = scan.nextInt();
        num = Math.abs(num);
        if(num == 0)
            main(true);
        PrimeCalculator(num);
    }
    
    void PrimeCalculator(int num)
    {
        boolean flag = false;
        for (int i = 2; i <= num / 2; i++) 
        {
          if (num % i == 0) 
          {
            flag = true;
            break;
          }
        }

        if (!flag)
          System.out.println(num + " is a prime number.");
        else
          System.out.println(num + " is not a prime number.");
        Initialize(true);
    }
}
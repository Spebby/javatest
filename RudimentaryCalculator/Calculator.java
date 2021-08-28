// garbage calculator
public class Calculator
{   
    public void Calculator(double i0, double i1, CalculateMode calType)
    {   
        switch (calType) 
        {
            case Add:
                Add(i0, i1);
                break;
            case Subtract:
                Subtract(i0, i1);
                break;
            case Multiply:
                Multiply(i0, i1);
                break;
            case Divide:
                Divide(i0, i1);
                break;
            case Remainder:
                Modulo(i0, i1);
                break;
            case Compair:
                GreaterThan(i0, i1);
                break;
        }
    }
    
    public void Add(double i0, double i1)
    {
        double sum = i0 + i1;
        System.out.println("The sum of " + i0 + " and " + i1 + " is " + sum);
        
        CalculatorManager calcMang = new CalculatorManager();
        calcMang.Manager(true);
    }
    
    public void Subtract(double i0, double i1)
    {
        double sum = i0 - i1;
        System.out.println("The difference of " + i0 + " and " + i1 + " is " + sum);
        
        CalculatorManager calcMang = new CalculatorManager();
        calcMang.Manager(true);
    }
    
    public void Multiply(double i0, double i1)
    {
        double sum = i0 * i1;
        System.out.println("The product of " + i0 + " and " + i1 + " is " + sum);
        
        CalculatorManager calcMang = new CalculatorManager();
        calcMang.Manager(true);
    }
    
    public void Divide(double i0, double i1)
    {
        double sum = i0 / i1;
        System.out.println("The quotient of " + i0 + " and " + i1 + " is " + sum);
        
        CalculatorManager calcMang = new CalculatorManager();
        calcMang.Manager(true);
    }
    
    public void Modulo(double i0, double i1)
    {
        double sum = i0 % i1;
        System.out.println("The remainder of " + i0 + " and " + i1 + " is " + sum);
        
        CalculatorManager calcMang = new CalculatorManager();
        calcMang.Manager(true);
    }
    
    public void GreaterThan(double i0, double i1)
    {
        CalculatorManager calcMang = new CalculatorManager();

        if(i0 > i1)
        {
            System.out.println(i0 + " is greater than " + i1);
        }
        else
        {
            if (i1 > i0)
            {
                System.out.println(i1 + " is greater than " + i0);
            }
            else
            {
                System.out.println(i0 + " and " + i1 + "equal each other");
            }    
        }
        
        calcMang.Manager(true);
    }
}
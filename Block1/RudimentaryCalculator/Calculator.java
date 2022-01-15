package RudimentaryCalculator;

public class Calculator
{   
    public void CalculatorHandler(float i0, float i1, CalculateMode calType)
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
    
    static CalculatorManager calcMang = new CalculatorManager();

    static void Add(float i0, float i1)
    {
        float sum = i0 + i1;
        System.out.println("The sum of " + i0 + " and " + i1 + " is " + sum);
        
        calcMang.Manager(true);
    }
    
    static void Subtract(float i0, float i1)
    {
        float sum = i0 - i1;
        System.out.println("The difference of " + i0 + " and " + i1 + " is " + sum);
        
        calcMang.Manager(true);
    }
    
    static void Multiply(float i0, float i1)
    {
        float sum = i0 * i1;
        System.out.println("The product of " + i0 + " and " + i1 + " is " + sum);
        
        calcMang.Manager(true);
    }
    
    static void Divide(float i0, float i1)
    {
        float sum = i0 / i1;
        System.out.println("The quotient of " + i0 + " and " + i1 + " is " + sum);
        
        calcMang.Manager(true);
    }
    
    static void Modulo(float i0, float i1)
    {
        float sum = i0 % i1;
        System.out.println("The remainder of " + i0 + " and " + i1 + " is " + sum);
        
        calcMang.Manager(true);
    }
    
    static void GreaterThan(float i0, float i1)
    {

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
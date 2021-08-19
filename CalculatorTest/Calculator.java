// garbage calculator
public class Calculator
{   
    public Calculator(float i0, float i1, CalculateMode calType)
    {   
        switch (calType) {
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
            case Modulo:
                Modulo(i0, i1);
                break;
            case GreaterThan:
                GreaterThan(i0, i1);
                break;
        }
    }
    
    public void Add(float i0, float i1)
    {
        float sum = i0 + i1;
        System.out.println("The sum of " + i0 + " and " + i1 + " is " + sum);
    }
    
    public void Subtract(float i0, float i1)
    {
        float sum = i0 - i1;
        System.out.println("The difference of " + i0 + " and " + i1 + " is " + sum);
    }
    
    public void Multiply(float i0, float i1)
    {
        float sum = i0 * i1;
        System.out.println("The product of " + i0 + " and " + i1 + " is " + sum);
    }
    
    public void Divide(float i0, float i1)
    {
        float sum = i0 / i1;
        System.out.println("The quotient of " + i0 + " and " + i1 + " is " + sum);
    }
    
    public void Modulo(float i0, float i1)
    {
        float sum = i0 % i1;
        System.out.println("The remainder of " + i0 + " and " + i1 + " is " + sum);
    }
    
    public void GreaterThan(float i0, float i1)
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
    }
}
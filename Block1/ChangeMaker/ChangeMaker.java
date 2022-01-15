package ChangeMaker;

public class ChangeMaker 
{
    float price;
    float cash;
    
    public ChangeMaker (float p, float c) 
    {
        price = p;
        cash = c;
    }
    
    public int[] makeChange() 
    {   
        int[] otpt = new int[5];
        
        // Dollars
        float change = Math.abs(cash - price);
        otpt[0] = (int)change;
        
        // Cents for 
        change = Math.abs(change - (float)otpt[0]);
        int cents = (int)(change * 100);
        
        // Quarters
        otpt[1] = (int)(cents / 25);
        cents = cents - otpt[1] * 25;
        
        // Dimes
        otpt[2] = (int)(cents / 10);
        cents = cents - otpt[2] * 10;
        
        // Nickles
        otpt[3] = (int)(cents / 5);
        cents = cents - otpt[3] * 10;
        
        // Cents lol
        otpt[4] = cents;
        
        return otpt;
    }
}
// Barack loved this
public class ChangeMaker {
    double price;
    double cash;
    
    public ChangeMaker (double p, double c) 
    {
        price = p;
        cash = c;
    }
    
    public int[] makeChange() 
    {
        Manager mng = new Manager();
        
        int[] result = new int[6];
        
        double change = cash - price;
        result[0] = (int)change; //Dollars
        
        change = change - (double)result[0]; //Cents
        int cents = (int)(change * 100);
        result[5] = cents;
        
        result[1] = (int)(cents / 25);
        cents = cents - result[1] * 25;
        
        result[2] = (int)(cents / 10);
        cents = cents - result[2] * 10;
        
        result[3] = (int)(cents / 5);
        cents = cents - result[3] * 10;
        
        result[4] = cents;
        
        mng.Manager(true);
        return result;
    }
}
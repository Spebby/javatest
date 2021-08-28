public class Player
{
    String name;
    int guess;
    int guessDiff;
    
    public Player(String n1, int g1)
    {
        name = n1;
        guess = g1;
        
        //# of Tigers in private possesion idk
        //# of Kidneys
        //Toenail length
    }
    
    public void setDifference(int gd1)
    {
        guessDiff = gd1;
    }
    
    // Return types
    public String getName()
    {
        return name;
    }    
    public int getGuess()
    {
        return guess;
    }
    public int getDifference()
    {
        return guessDiff;    
    }
}
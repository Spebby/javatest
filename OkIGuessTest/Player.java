// The player will only have two characteristics. Their name and a guess, an int.

public class Player
{
    private String name;
    private int guess;
    
    public Player(String n1, int g1)
    {
        name = n1;
        guess = g1;
        
        //# of Tigers in private possesion idk
        //# of Kidneys
        //Toenail length
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
}
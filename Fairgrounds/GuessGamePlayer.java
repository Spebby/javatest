public class GuessGamePlayer
{
    String name;
    int guess;
    int guessDiff;
    
    public GuessGamePlayer(String n1, int g1)
    {
        name = n1;
        guess = g1;
        
        //# of Tigers in private possession idk
        //# of Kidneys
        //Toenail length
    }
    
    public void setDifference(int gd1) { guessDiff = gd1; }

    public String getName() { return name; }    
    public int getGuess() { return guess; }
    public int getDifference() { return guessDiff; }
}
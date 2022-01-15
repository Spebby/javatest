package Fairgrounds;

public class RPSManager
{
    private int choice;
    
    public RPSManager(String c)
    {
        c = c.toUpperCase();
        switch(c)
        {
            case "ROCK":
            case "R":
                choice = 0;
                break;
            case "PAPER":
            case "P":
                choice = 1;
                break;
            case "SCISSORS":
            case "S":
                choice = 2;
                break;
            default:
                choice = 0;
                break;
        }
    }
    
    public int getChoice() { return choice; }
}
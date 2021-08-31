public class RPSManager
{
    private int choice;
    
    public RPSManager(String c)
    {
        switch(c)
        {
            case "Rock":
            case "R":
            case "r":
                choice = 0;
                break;
            case "Paper":
            case "P":
            case "p":
                choice = 1;
                break;
            case "Scissors":
            case "S":
            case "s":
                choice = 2;
                break;
            default:
                choice = 0;
                break;
        }
    }
    
    public int getChoice()
    {
        return choice;
    }
}
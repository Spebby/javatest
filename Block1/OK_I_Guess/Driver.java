package OK_I_Guess;

public class Driver
{
    public static void main(String[] args)
    {
        // Standard startup
        // GameManager gMng = new GameManager(); //Unneeded
        GuessGame gGame = new GuessGame();
        
        // Start
        gGame.Play(false);
    }
}
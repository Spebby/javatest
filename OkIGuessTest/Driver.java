// The goal of this experiment is to create a 3 player game in which
// we "guess" something idk yet

public class Driver
{
    public static void main(String[] args)
    {
        // Standard startup
        //GameManager gMng = new GameManager(); //Unneeded
        GuessGame gGame = new GuessGame();
        
        // Start
        gGame.Play(false);
    }
}
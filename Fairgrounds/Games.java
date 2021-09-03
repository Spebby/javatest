// This is a handler script
public class Games 
{   
    public String[] numGame = new String[]{"Rock Paper Scissors", "Fortune Teller", "Coin Flip", "OK I Guess", "Dunk Tank", "Dead Man's Hand"};
    // Russian Roulet is planned :)

    public void GameManager(String gameChoice)
    {
        gameChoice = gameChoice.toUpperCase();
        System.out.println(""); // Simple line space so each game doesn't have to do it.
        switch(gameChoice)
        {
            // Simple fallthrough.
            case "ROCK PPAPER SCISSORS":
            case "RPS":
                RPS rps = new RPS();
                rps.Initialize();
                break;
            case "FORTUNE TELLER":
            case "FT":
                FT ft = new FT();
                ft.Initialize();
                break;
            case "COIN FLIP":
            case "CF":
                CoinFlip cp = new CoinFlip();
                cp.Initialize();
                break;
            case "OK I GUESS":
            case "OIG":
                GuessGame oig = new GuessGame();
                oig.Play();
                break;
            case "DUNK TANK":
            case "DT":
                DunkTank dt = new DunkTank();
                dt.Initialize();
            case "DEAD MAN'S HAND":
            case "DEAD MANS HAND":
            case "DMH":
                DMH dmh = new DMH();
                dmh.Initialize();
        }
    }
}
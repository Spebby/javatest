// This is a handler script
public class Games 
{   
    public String[] numGame = new String[]{"Rock Paper Scissors", "Fortune Teller", "Coin Flip"};
    
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
                /*
            case "":
            case "":
                = new ();
                .Initialize();
                break;
                */
        }
    }
}
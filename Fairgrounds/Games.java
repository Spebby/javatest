// This is a handler script
public class Games 
{   
    public String[] numGame = new String[]{"Rock Paper Scissors", "Fortune Teller", "Coin Flip"};
    
    public void GameManager(String gameChoice)
    {
        System.out.println(""); // Simple line space so each game doesn't have to do it.
        switch(gameChoice)
        {
            // Simple fallthrough.
            case "Rock Paper Scissors":
            case "RPS":
                RPS rps = new RPS();
                rps.Initialize();
                break;
            case "Fortune Teller":
            case "FT":
                FT ft = new FT();
                ft.Initialize();
                break;
            case "Coin Flip":
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
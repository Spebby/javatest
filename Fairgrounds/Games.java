import java.util.Scanner;

public class Games 
{   
    public String[] numGame = new String[]{"Rock Paper Scissors", "Fortune Teller"};
    
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
            case "Fortune Teller":
            case "FT":
                FT ft = new FT();
                ft.Initialize();
        }
    }
}
// This is a handler script
import java.util.Scanner;

public class Games 
{   
    public String[] numGame = new String[]{"Rock Paper Scissors", "Fortune Teller", "Coin Flip", "OK I Guess", "Dunk Tank", "Dead Man's Hand"}; //Russian Roulette // Russian Roulette is brokey

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
                break;
            case "DEAD MAN'S HAND":
            case "DEAD MANS HAND":
            case "DMH":
                DMH dmh = new DMH();
                dmh.Initialize();
                break;
            /*
            case "RUSSIAN ROULETTE":
            case "RR":
                RussianRoulette rr = new RussianRoulette();
                rr.Initialize();
                break;
            */
            case "NO":
            case "N":
                System.out.print('\f');
                System.out.print("Bye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid game, pick again.");
                Scanner scan = new Scanner(System.in);
                String gCh = scan.nextLine();
                GameManager(gCh);
                break;
        }
        
        System.out.print('\f');
    }
}
import java.util.Scanner;

public class DiceGame
{
    int turn = 0;
    int numTurn = 0;
    Player[] pArray = new Player[2];
    public void dStart(Player p1, Player p2)
    {
        System.out.println();
        pArray[0] = p1;
        pArray[1] = p2;
        
        Play(true);
    }
    
    public void Play(boolean Initialize)
    {
        if(!Initialize)
        {
            if(pArray[turn].getData()[1] != 0)
                System.out.println(pArray[turn].getName() + " rolled a " + pArray[turn].getData()[1] + " and moved to " + pArray[turn].getData()[0] + ".");
            else if(pArray[turn].getDNRoll())
                System.out.println(pArray[turn].getName() + " rolled a 2, they'll get a double next turn.");
            else
                System.out.println(pArray[turn].getName() + " rolled zero, they stay put.");

            numTurn++;
            
            if(pArray[turn].getData()[0] > 40)
                EndGame();
            
            turn++;
            if(turn > 1)
                turn = 0;
        }
        //System.out.println(pArray[turn].getName() + ", it's your turn!"); // too spamy
        
        RollDice(pArray[turn]);
    }
    
    void RollDice(Player p)
    {
        int roll = 0;
        roll = (int)(Math.random() * 11) + 2; // 2 at mininum
        // to more accurately simulate rolling dice, it would be better to roll twice, then add it together.

        if(p.getDNRoll())
            roll *= 2;
        
            
        // Only use "dnroll" if a valid turn happens.
        if(roll == 12)
            roll = 0;
        else if (roll == 7)
            roll *= -1;
        
        if(p.getDNRoll() && roll != 12)
        {
            p.setDNRoll(false);
            // Incase the player lands a 2 again, they still get a double next turn, while still getting a roll of 4.
            if(roll == 2)
                p.setDNRoll(true);
            roll *= 2;
        }    
        
        if(roll == 2)
        {
            roll = 0;
            p.setDNRoll(true);
        }
        
        // 0 = Position, 1 = Last Roll, 2 = # of Turns
        p.setData((p.getData()[0] + roll), roll, p.getData()[2]++);
        Play(false);
    }
    
    void EndGame()
    {
        System.out.println("It took " + numTurn + " turns for the game to end.");
        System.out.println(pArray[turn].getName() + " wins with a " + Math.abs(pArray[0].getData()[0] - pArray[1].getData()[0]) + " lead!");
        System.out.println("Congradulations " + pArray[turn].getName() + "!");
        // Reset the players.
        pArray[0].setData(0,0,0);
        pArray[0].setDNRoll(false);
        pArray[1].setData(0,0,0);
        pArray[1].setDNRoll(false);
        turn = 0;
        
        Loop();
    }

    Scanner scan = new Scanner(System.in);

    void Loop()
    {
        System.out.println("Would you like to Restart the program?");
        System.out.println("If yes, enter \"Yes\".");
        System.out.println("If you'd like to quit, enter \"Quit\" or \"No\".");
        String c = scan.nextLine();
        c = c.toUpperCase();
        
        if(c.charAt(0) == 'Y')
        {
            System.out.print('\f');
            Play(true);
        }
        else
            Quit();
    }

    void Quit()
    {
        System.out.print('\f');
        System.out.print("Bye!");
        System.exit(0);
    }
}
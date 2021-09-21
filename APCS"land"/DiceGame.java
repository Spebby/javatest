public class DiceGame extends DriverFeeder
{
    int turn = 0;
    Player[] pArray = new Player[]{p1, p2};
    public void Play(boolean Initialize)
    {
        if(!Initialize)
        {
            System.out.println();
            System.out.println(pArray[turn] + " rolled a " + pArray[turn].getData()[1] + " and moved to " + pArray[turn].getData()[0] + ".");
            
            if(pArray[turn].getData()[0] < 40)
                EndGame();
            
            turn++;
            if(turn < 1)
                turn = 0;

        }
        System.out.println(pArray[turn] + ", it's your turn!");
        
        RollDice(pArray[turn]);
    }
    
    void RollDice(Player p)
    {
        int roll = 0;
        roll = (int)(Math.random() * 11) + 2; // 2 at mininum
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
        System.out.println(pArray[turn].getName() + " wins with a " + Math.abs(p1.getData()[0] - p2.getData()[0]) + " lead!");
        System.out.println("Congradulations " + pArray[turn].getName() + "!");
        // Reset the players.
        p1.setData(0,0,0);
        p1.setDNRoll(false);
        p2.setData(0,0,0);
        p2.setDNRoll(false);
        turn = 0;
        
        Loop();
    }
}
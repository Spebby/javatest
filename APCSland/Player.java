public class Player
{
    String Name;
    int Position;
    int lastRoll;
    int numRolls; // number of rolls
    boolean dNextRoll;
    int[] rollData;
    
    public Player(String n1, int p, int lRoll, int nRoll, boolean dnRoll)
    {
        Name = n1;
        Position = p;
        lastRoll = lRoll;
        numRolls = nRoll;
        dNextRoll = dnRoll;
        rollData = new int[]{Position, lastRoll, numRolls};
    }
    
    public String getName()
    {
        return Name;
    }
    
    public int[] getData()
    {
        return rollData;
    }
    
    public void setData(int c0, int c1, int c2)
    {
        int[] newData = new int[]{c0, c1, c2};
        rollData = newData;
    }
    
    public boolean getDNRoll()
    {
        return dNextRoll;
    }
    
    public void setDNRoll(boolean c)
    {
        dNextRoll = c;
    }
}
public class Start 
{
    GameManager gm;
    public void Reset(Board board)
    {
        board.go();
        Player p = new Player();
        gm = new GameManager();
    }

    // im hard coding all of this, this is terrible practice idgaf i'm just trying to get this done
    void SetGameSpace()
    {

    }
}

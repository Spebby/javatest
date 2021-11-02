public class Start 
{
    GameManager gm;
    public void Reset(Board board)
    {
        board.Go();
        Player player = new Player(board);
        gm = new GameManager();
    }

    // im hard coding all of this, this is terrible practice idgaf i'm just trying to get this done
    void SetGameSpace()
    {

    }
}

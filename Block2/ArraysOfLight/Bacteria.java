package ArraysOfLight;

public class Bacteria extends Entity
{
    int _generation; // the generation of the bacteria

    public Bacteria(int generation) 
    {
        _generation = generation;
    }

    public void Logic()
    {
        
    }

    public void die()
    {
        GameBoard.removeEntity(position);
    }

    public void reproduce()
    {
        die();
        GameBoard.addEntity(new Bacteria(_generation + 1), this.position);
    }
}
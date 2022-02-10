package ArraysOfLight;

import static ArraysOfLight.GameBoard.*;

public class Bacteria extends Entity
{
    public void Logic()
    {
        if(GetNeighbors() < 2)
        {
            removeEntity(this);
            return;
        }

        if(GetNeighbors() > 3)
        {
            removeEntity(this);
            return;
        }
    }
}
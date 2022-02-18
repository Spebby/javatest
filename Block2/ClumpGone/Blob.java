package ClumpGone;

import static ClumpGone.GameBoard.*;
import Common.Vector2Int;

public class Blob extends Entity
{
    public boolean isClump = false;

    public Blob(Vector2Int pos)
    {
        super(pos);
    }

    public void Logic()
    {
        for (Entity entity : GetNeighbors() ) 
        {
            entity.Logic();
            removeEntity(entity);
        } 
    }
}
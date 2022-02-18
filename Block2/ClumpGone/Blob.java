package ClumpGone;

import static ClumpGone.GameBoard.*;
import Common.Vector2Int;

public class Blob extends Entity
{

    public Blob(Vector2Int pos)
    {
        super(pos);
    }

    public void Logic()
    {
        removeEntity(this);
        Entity[] entities = GetNeighbors().toArray(Entity[] :: new);
        for (int i = 0; i < entities.length; i++)
        {
            entities[i].Logic();
            removeEntity(entities[i]);
        }
    }
}
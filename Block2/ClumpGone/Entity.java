package ClumpGone;

import Common.Vector2Int;
import static ClumpGone.GameBoard.*;
import java.util.ArrayList;

public abstract class Entity
{
    protected Vector2Int pos = new Vector2Int();

    public Entity(Vector2Int pos)
    {
        this.pos = pos;
    }

    public abstract void Logic();
    protected ArrayList<Entity> GetNeighbors()
    {
        var neighbors = new ArrayList<Entity>();
        for(int x = pos.x - 1; x <= pos.x + 1; x++)
        {
            for(int y = pos.y - 1; y <= pos.y + 1; y++)
            {
                Entity ent = getEntity(x, y);
                boolean isValid = (ent != null) && (x != pos.x || y != pos.y);
                if(isValid)
                    neighbors.add(ent);
            }
        }
        return neighbors;
    }
}
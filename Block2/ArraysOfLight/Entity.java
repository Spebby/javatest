package ArraysOfLight;

import Common.Vector2Int;
import static ArraysOfLight.GameBoard.*;

public abstract class Entity 
{
    protected Vector2Int pos = new Vector2Int();

    public Entity(Vector2Int pos)
    {
        this.pos = pos;
    }

    public abstract void Logic();
    protected int GetNeighbors()
    {
        int neighbors = 0;
        for(int x = pos.x - 1; x <= pos.x + 1; x++)
        {
            for(int y = pos.y - 1; y <= pos.y + 1; y++)
            {
                boolean isValid = (getEntity(x, y, board) != null) && (x != pos.x || y != pos.y);
                if(isValid)
                    neighbors++;
            }
        }
        return neighbors;
    }
}
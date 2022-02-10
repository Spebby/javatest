package ArraysOfLight;

import Common.Vector2Int;
import static ArraysOfLight.GameBoard.*;

public abstract class Entity 
{
    Vector2Int pos = new Vector2Int();

    public abstract void Logic();
    public int GetNeighbors()
    {
        int neighbors = 0;
        for(int x = pos.x - 1; x <= pos.x + 1; x++)
        {
            for(int y = pos.y - 1; y <= pos.y + 1; y++)
            {
                if(getEntity(x, y) != null)
                    neighbors++;
            }
        }
        return neighbors;
    }
}
package ClumpGone;

import Common.Vector2Int;
import static ClumpGone.GameBoard.*;

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

        }
        return neighbors;
    }
}
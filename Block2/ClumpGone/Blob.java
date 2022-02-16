package ClumpGone;

import static ArraysOfLight.GameBoard.*;
import Common.Vector2Int;

public class Blob extends Entity
{
    public Blob(Vector2Int pos)
    {
        super(pos);
    }

    public void Logic()
    {
        if(GetNeighbors() < 2 || GetNeighbors() > 3)
        {
            marked.add(pos);
            return;
        }
    }
}
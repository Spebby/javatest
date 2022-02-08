package ArraysOfLight;

import Common.Vector2Int;

public abstract class Entity 
{
    Vector2Int position = new Vector2Int();

    public abstract void Logic();
}
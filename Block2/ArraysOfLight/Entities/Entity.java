package ArraysOfLight.Entities;

import Common.Vector2Int;

public abstract class Entity 
{
    public Vector2Int position = new Vector2Int();

    public abstract void Logic();
}
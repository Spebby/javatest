package ArraysOfLight;
import Common.Vector2Int;

public class GameBoard 
{
  public static int Generation = 0;
  public static Entity[][] board = new Entity[19][19];

  /** Adds an enetiy to the board at the given position.
    * @param entity : The entity to be added.
    * @param position : The position for the entity to be added. */
  public static void addEntity(Entity entity, Vector2Int position)
  {
    if(getEntity(position) != null)
      return;

    board[position.x][position.y] = entity;
  }
  /** Removes an entity from the board at the given position.
    * @param position : The position of the entity to be removed.
    * @return The entity that was removed. */
  public static void removeEntity(Vector2Int position)
  {
    board[position.x][position.y] = null;
  }
  /** Removes an entity from the board at the given position.<P>
    * <b> Overload </b>
    * @param x : The x position of the entity to be removed.
    * @param y : The y position of the entity to be removed.
    * @return The entity that was removed. */
  public static void removeEntity(int x, int y)
  {
    board[x][y] = null;
  }
  /** Removes an entity from the board.<P>
    * <b> Overload </b>
    * @param e : The entity to be removed.
    * @return The entity that was removed. */
  public static void removeEntity(Entity e)
  {
    board[e.pos.x][e.pos.y] = null;
  }

  /** Gets the entity at the given position.
    * @param position : The position of the entity to be retrieved.
    * @return The entity at the given position. */
  public static Entity getEntity(Vector2Int position)
  {
    return board[position.x][position.y];
  }
  /** Gets the entity at the given position.<P>
    * <b> Overload </b>
    * @param x : The x position of the entity to be retrieved.
    * @param y : The y position of the entity to be retrieved.
    * @return The entity at the given position. */
  public static Entity getEntity(int x, int y)
  {
    return board[x][y];
  }
  
  /** Returns an open position in the immediate radius of the position.
    * @param pos The given position.
    * @return An open space, as a Vector2Int. */
  public static Vector2Int getOpenSpace(Vector2Int pos)
  {
    // return the position of an unoccupied space in a radius around the given position
    for(int x = pos.x - 1; x <= pos.x + 1; x++)
    {
      for(int y = pos.y - 1; y <= pos.y + 1; y++)
      {
        if(getEntity(x, y) == null)
          return new Vector2Int(x, y);
      }
    }
    return null;
  }
  /** Returns an open position in the immediate radius of the position. <P>
    * <b> Overload </b>
    * @param entity : The entity to find an open space for.
    * @return An open space, as a Vector2Int. */
  public static Vector2Int getOpenSpace(Entity entity)
  {
    return getOpenSpace(entity.pos);
  }

  public int GetNeighbors(Entity e)
  {
    Vector2Int pos = e.pos;
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
  public int GetNeighbors(Vector2Int pos)
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
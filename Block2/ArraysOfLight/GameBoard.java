package ArraysOfLight;

import ArraysOfLight.Entities.*;
import Common.Vector2Int;

public class GameBoard 
{
  public static int Iteration = 0;
  public static Entity[][] board = new Entity[5][5];

  public static void Iterate()
  {
    // loop through board and call each entity's logic method.
    for(int i = 0; i < board.length; i++)
      for(int j = 0; j < board[i].length; j++)
        if(board[i][j] != null)
          board[i][j].Logic();

    Iteration++;
  }

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
    board[e.position.x][e.position.y] = null;
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

  /** Moves the entity at the given position to the given position.
    * @param from : The Vector2 of the entity.
    * @param to : The Vector2 of the desired spot.
    * @return The entity at the given position. */
  public static void moveEntity(Vector2Int from, Vector2Int to)
  {
    // if an entity is already at the desired position, return
    if(!(getEntity(to) instanceof Food))
      return;
    // but if that entity is food, and the moving entity is Bacteria, eat the food
    else if(getEntity(from) instanceof Bacteria)
      ((Bacteria) getEntity(from)).Eat((Food) getEntity(to));
        
    board[to.x][to.y] = board[from.x][from.y];
    board[from.x][from.y] = null;
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
    return getOpenSpace(entity.position);
  }
}
package ArraysOfLight;
import java.util.ArrayList;

import Common.Vector2Int;

public class GameBoard 
{
  public static int Generation = 0;
  public static Entity[][] board = new Entity[20][20];
  public static ArrayList<Vector2Int> marked = new ArrayList<Vector2Int>(); 
  public static Entity[][] eggs = new Entity[20][20];
 
  public void Iteration()
  {
    if(Generation > 0)
    {
      while(marked.size() > 0)
      {
        Vector2Int pos = marked.get(0);
        board[pos.x][pos.y] = null;

        marked.remove(0);
      }

      for (int row = 0; row < eggs.length; row++)
      {
        for (Entity ent : eggs[row])
        {
          if(ent != null)
          {
            board[row][ent.pos.y] = new Bacteria(ent.pos);
            eggs[row][ent.pos.y] = null;
          }
        }
      }
    }

    // loop through every element of the board
    for (int row = 0; row < board.length; row++)
    {
      for (int col = 0; col < board[row].length; col++)
      {
        Entity cell = board[row][col];
        Vector2Int pos = new Vector2Int(row, col);
        
        if(cell == null)
        {
          if(GetNeighbors(pos) == 3)
            eggs[row][col] = new Bacteria(pos);
          //System.out.println(pos.x + " " + pos.y);
        }
        
        if(cell instanceof Bacteria)
        {
          cell.Logic();
        }
      }
    }
    Generation++;
  }



  /** Adds an enetiy to the board at the given position.
    * @param entity : The entity to be added.
    * @param position : The position for the entity to be added. */
  public static void addEntity(Entity entity, Entity[][] board)
  {
    if(getEntity(entity.pos) != null)
      return;

    try { board[entity.pos.x][entity.pos.y] = entity; }
    catch (ArrayIndexOutOfBoundsException e) { }
  }
  /** Removes an entity from the board at the given position.
    * @param position : The position of the entity to be removed.
    * @return The entity that was removed. */
  public static void removeEntity(Vector2Int position, Entity[][] board)
  {
    try { board[position.x][position.y] = null; }
    catch (ArrayIndexOutOfBoundsException e) { }
  }
  /** Removes an entity from the board at the given position.<P>
    * <b> Overload </b>
    * @param x : The x position of the entity to be removed.
    * @param y : The y position of the entity to be removed.
    * @return The entity that was removed. */
  public static void removeEntity(int x, int y, Entity[][] board)
  {
    try { board[x][y] = null; }
    catch (ArrayIndexOutOfBoundsException e) { }
  }
  /** Removes an entity from the board.<P>
    * <b> Overload </b>
    * @param e : The entity to be removed.
    * @return The entity that was removed. */
  public static void removeEntity(Entity ent, Entity[][] board)
  {
    try { board[ent.pos.x][ent.pos.y] = null; }
    catch (ArrayIndexOutOfBoundsException e) {}
  }

  /** Gets the entity at the given position.
    * @param position : The position of the entity to be retrieved.
    * @return The entity at the given position. */
  public static Entity getEntity(Vector2Int position)
  {
    try { return board[position.x][position.y]; }
    catch(ArrayIndexOutOfBoundsException e) { return null; }
  }
  /** Gets the entity at the given position.<P>
    * <b> Overload </b>
    * @param x : The x position of the entity to be retrieved.
    * @param y : The y position of the entity to be retrieved.
    * @return The entity at the given position. */
  public static Entity getEntity(int x, int y)
  {
    try { return board[x][y]; }
    catch(ArrayIndexOutOfBoundsException e) { return null; }
  }
  
  /** Returns an open position in the immediate radius of the position.
    * @param pos The given position.
    * @return An open space, as a Vector2Int. */
  public static Vector2Int getOpenSpace(Vector2Int pos)
  {
    for (int i = -1; i <= 1; i++)
    { try
      {
        for (int j = -1; j <= 1; j++)
        { try
          {
            if(getEntity(pos.x + i, pos.y + j) == null)
              return new Vector2Int(pos.x + i, pos.y + j);
          } catch(ArrayIndexOutOfBoundsException e) { continue; }
        }
      } catch(ArrayIndexOutOfBoundsException e) { continue; }
    }
    
    return null;
  }
  /** Returns an open position in the immediate radius of the position. <P>
    * <b> Overload </b>
    * @param entity : The entity to find an open space for.
    * @return An open space, as a Vector2Int. */
  public static Vector2Int getOpenSpace(Entity entity)
  {
    try { return getOpenSpace(entity.pos); }
    catch(NullPointerException e) { return null; }
  }

  /** Returns the number of surrounding entities. <P>
    * <b> Overload </b>
    * @param entity : The entity that serves as the center of the search.
    * @return The number of surrounding entities. */
  public static int GetNeighbors(Entity entity)
  {
    try { return GetNeighbors(entity.pos) ;} 
    catch (NullPointerException e) { return 0; }
  }
  /** Returns the number of surrounding entities.
    * @param pos : The centre of the search.
    * @return The number of surrounding entities. */
  public static int GetNeighbors(Vector2Int pos)
  {
    int neighbors = 0;

    for(int x = pos.x - 1; x <= pos.x + 1; x++)
    { try
      {
        for(int y = pos.y - 1; y <= pos.y + 1; y++)
        { try
          {
            if(getEntity(x, y) != null)
              neighbors++;
          } catch(ArrayIndexOutOfBoundsException e) { continue; }
        }
      } catch(ArrayIndexOutOfBoundsException e){ continue; }
    }

    return neighbors;
  }
}
package ArraysOfLight;
import Common.Vector2Int;

public class GameBoard 
{
    private Entity[][] board = new Entity[5][5];

    /** Adds an enetiy to the board at the given position.
      * @param entity : The entity to be added.
      * @param position : The position for the entity to be added. */
    public void addEntity(Entity entity, Vector2Int position)
    {
        if(getEntity(position) != null)
            return;

        board[position.x][position.y] = entity;
    }
    /** Removes an entity from the board at the given position.
      * @param position : The position of the entity to be removed.
      * @return The entity that was removed. */
    public void removeEntity(Vector2Int position)
    {
        board[position.x][position.y] = null;
    }
    /** Removes an entity from the board at the given position.<P>
      * <b> Overload </b>
      * @param x : The x position of the entity to be removed.
      * @param y : The y position of the entity to be removed.
      * @return The entity that was removed. */
    public void removeEntity(int x, int y)
    {
        board[x][y] = null;
    }

    /** Gets the entity at the given position.
      * @param position : The position of the entity to be retrieved.
      * @return The entity at the given position. */
    public Entity getEntity(Vector2Int position)
    {
        return board[position.x][position.y];
    }
    /** Gets the entity at the given position.<P>
      * <b> Overload </b>
      * @param x : The x position of the entity to be retrieved.
      * @param y : The y position of the entity to be retrieved.
      * @return The entity at the given position. */
    public Entity getEntity(int x, int y)
    {
        return board[x][y];
    }

    /** Moves the entity at the given position to the given position.
      * @param from : The Vector2 of the entity.
      * @param to : The Vector2 of the desired spot.
      * @return The entity at the given position. */
    public void moveEntity(Vector2Int from, Vector2Int to)
    {
        // if an entity is already at the desired position, return
        if(!(getEntity(to) instanceof Food))
            return;
        // but if that entity is food, and the moving entity is Bacteria, eat the food
        else if(getEntity(from) instanceof Bacteria)
            ((Bacteria) getEntity(from)).eat((Food) getEntity(to));
        
        board[to.x][to.y] = board[from.x][from.y];
        board[from.x][from.y] = null;
    }
}
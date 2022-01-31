/* Directions
* A BoxBug constructor receives as a parameter size, an integer representing the size of the box 
* that the BoxBug is to create; the constructor may also receive a Color (as our other Bugs did) if 
* you like. If there are no obstacles, the BoxBug will create a box with a side length of size. If 
* BoxBug encounters an obstacle, it will turn to the right 90 degrees. */
// I may be stupid, but I read this as "The bug should make a box with it's movement."

package GridWorld.Actors;
import java.awt.Color;
import GridWorld.Core.Location;
import GridWorld.Viewport.Grid;

// create class "BoxBug" that inherets from "Bug"
public class BoxBug extends Bug 
{
    int boxSize = 5;
    int movesLeft;

    // Overload, some commented that clogged up menus but are useful.
    public BoxBug() 
    {
        super(Color.ORANGE);
    }
    /*public BoxBug(Color bugColor) 
    {
        super(bugColor);
    }
    public BoxBug(int boxSize) 
    {
        this.boxSize = boxSize;
        movesLeft = boxSize;
    }*/
    public BoxBug(Color bugColor, int boxSize) 
    {
        super(bugColor);
        this.boxSize = boxSize;
        movesLeft = boxSize;
    }

    public void act() 
    {
        if (canMove() && movesLeft > 0) 
            move();
        else 
            turn();
    }
    
    public void move() 
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if(gr.isValid(next))
        {
            moveTo(next);
            movesLeft--;
        }
        else
            turn();
    }
    
    public void turn() 
    {
        setDirection(getDirection() + Location.RIGHT);
        movesLeft = boxSize;
    }
    public boolean canMove() 
    {
        return super.canMove();
    }
}
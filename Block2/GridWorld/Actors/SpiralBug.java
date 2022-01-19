/* Directions:
 * A SpiralBug starts at a corner of the grid and moves in a spiral pattern, stepping on every 
 * Location in the grid until it reaches the middle of the grid. Once in the middle, the SpiralBug will 
 * just spin around in place as long as the program continues to run. You may set the initial 
 * location and direction of the SpiralBug. */

package GridWorld.Actors;
import java.awt.Color;
import GridWorld.Location;
import GridWorld.Objects.Rock;
import GridWorld.Viewport.Grid;

public class SpiralBug extends Bug
{
    public SpiralBug()
    {
        super(Color.GREEN);
        switch((int)(Math.random() * 4)) {
            case 0:
                setDirection(Location.NORTHWEST); break;
            case 1:
                setDirection(Location.NORTHEAST); break;
            case 2:
                setDirection(Location.SOUTHWEST); break;
            case 3:
                setDirection(Location.SOUTHEAST); break;
        }
    }
    public SpiralBug(Color bugColor)
    {
        super(bugColor);
        switch((int)(Math.random() * 4)) {
            case 0:
                setDirection(Location.NORTHWEST); break;
            case 1:
                setDirection(Location.NORTHEAST); break;
            case 2:
                setDirection(Location.SOUTHWEST); break;
            case 3:
                setDirection(Location.SOUTHEAST); break;
        }
    }
    public SpiralBug(Color bugColor, int loc)
    {
        super(bugColor);
        setDirection(Location.NORTHWEST);
    }
    public void act()
    {
        if(canMove())
            move();
        else
            turn();
    }
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if(gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if(gr.get(next) instanceof Rock)
            turn();
        else if(gr.isValid(next))
        {
            moveTo(next);
        }
    }
    public void turn()
    {
        setDirection(getDirection() + Location.RIGHT);
    }
}

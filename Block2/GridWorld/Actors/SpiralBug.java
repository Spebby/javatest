/* Directions:
 * A SpiralBug starts at a corner of the grid and moves in a spiral pattern, stepping on every 
 * Location in the grid until it reaches the middle of the grid. Once in the middle, the SpiralBug will 
 * just spin around in place as long as the program continues to run. You may set the initial 
 * location and direction of the SpiralBug. */

package GridWorld.Actors;
import java.awt.Color;
import GridWorld.Core.Location;
import GridWorld.Viewport.Grid;

public class SpiralBug extends Bug
{
    boolean attemptTurnAgain = false;
    int _turnAgain = 0;
    int moveCounter = 9;
    int movesAllowed = 9;

    public SpiralBug()
    {
        super(Color.GREEN);
        switch((int)(Math.random() * 4)) {
            case 0:
                setLocation(Location.TOPRIGHT); 
                setDirection(Location.SOUTH);
                break;
            case 1:
                setLocation(Location.TOPLEFT); 
                setDirection(Location.EAST);
                break;
            case 2:
                setLocation(Location.BOTTOMRIGHT); 
                setDirection(Location.EAST);
                break;
            case 3:
                setLocation(Location.BOTTOMLEFT); 
                setDirection(Location.NORTH);
                break;
        }
    }
    public SpiralBug(Color bugColor)
    {
        super(bugColor);
        switch((int)(Math.random() * 4)) {
            case 0:
                setLocation(Location.TOPRIGHT); 
                setDirection(Location.SOUTH);
                break;
            case 1:
                setLocation(Location.TOPLEFT); 
                setDirection(Location.EAST);
                break;
            case 2:
                setLocation(Location.BOTTOMRIGHT); 
                setDirection(Location.EAST);
                break;
            case 3:
                setLocation(Location.BOTTOMLEFT); 
                setDirection(Location.NORTH);
                break;
        }
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
        
        if(attemptTurnAgain && gr.isValid(loc.getAdjacentLocation(Location.LEFT)))
        {
            attemptTurnAgain = false;
            turn(Location.LEFT);
            _turnAgain = 2;
        }

        // if rock is in the way, try to move around it.
        if(!gr.isValid(next))
        {
            if(_turnAgain > 0)
                _turnAgain = 0;
            
            attemptTurnAgain = true;
            turn();
            return;
        }
        else
        {
            if(_turnAgain == 0 && !attemptTurnAgain)
            {
                if(gr.isValid(loc.getAdjacentLocation(Location.LEFT)))
                    turn(Location.LEFT);

                return;
            }
            moveTo(next);
            _turnAgain--;
            if(_turnAgain == 0 || !attemptTurnAgain)
                moveCounter--;
        }
    }
    public void turn()
    {
        setDirection(getDirection() + Location.RIGHT);
    }
    public void turn(int direction)
    {
        setDirection(getDirection() + direction);
    }
}
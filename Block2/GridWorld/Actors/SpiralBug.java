/* Directions:
 * A SpiralBug starts at a corner of the grid and moves in a spiral pattern, stepping on every 
 * Location in the grid until it reaches the middle of the grid. Once in the middle, the SpiralBug will 
 * just spin around in place as long as the program continues to run. You may set the initial 
 * location and direction of the SpiralBug. */

package GridWorld.Actors;
import java.awt.Color;
import GridWorld.Core.Location;
import GridWorld.Viewport.Grid;

public class SpiralBug extends JumpBug
{
    int _turnCounter = 0;
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
        turnCheck();

        if(canMove() && _turnCounter <= 4)
            move();
        else if(canJump() && _turnCounter <= 4 && moveCounter <= 1)
            jump();
        else
            turn();
    }

    public void move()
    {
        super.move();
        moveCounter--;
    }

    public void jump()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        Location next2 = next.getAdjacentLocation(getDirection()); // this is stupid but im lazy rn
        if (gr.isValid(next2) && moveCounter > 2)
            moveTo(next2);
        else if(moveCounter >= 2 && gr.isValid(next2.getAdjacentLocation(getDirection() + Location.HALFRIGHT)))
        {    
            _turnCounter++;
            turnCheck();
            moveTo(next2.getAdjacentLocation(getDirection() + Location.HALFRIGHT));
        }
        else
            removeSelfFromGrid();
    }

    public boolean canJump()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null) 
            return false;
        
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        Location next2 = next.getAdjacentLocation(getDirection()); // this is stupid but im lazy rn
        if(!gr.isValid(next2))
            return false;
            
        Actor neighbor = gr.get(next2);
        return (neighbor == null);
    }
    
    public void turn()
    {
        setDirection(getDirection() + Location.RIGHT);
    }
    public void turn(int direction)
    {
        setDirection(getDirection() + direction);
    }

    void turnCheck()
    {
        if(_turnCounter <= 4 && movesAllowed > 0)
        {
            _turnCounter = 0;
            movesAllowed--;
            moveCounter = movesAllowed;
        }
    }
}
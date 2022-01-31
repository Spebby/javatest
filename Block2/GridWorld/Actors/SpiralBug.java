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
    int requiredTurns = 2;
    int _turnCounter = 0;
    int moveCounter = 9;
    int movesAllowed = 9;

    public SpiralBug()
    {
        super(Color.GREEN);
    }
    public SpiralBug(Color bugColor)
    {
        super(bugColor);
    }

    public void act()
    {
        if(canMove() && moveCounter > 0)
            move();
        else if(canJump() && moveCounter > 0)
        {
            System.out.println("Attempt jump.");
            jump();
        }
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
        if (gr.isValid(next2) && moveCounter > 1)
        {
            moveCounter -= 2;
            moveTo(next2);
        }
        else if(moveCounter >= 2 && gr.isValid(next2.getAdjacentLocation(getDirection() + Location.HALFRIGHT)))
        {
            _turnCounter++;
            spiralCheck();
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
        _turnCounter++;
        spiralCheck();
        setDirection(getDirection() + Location.RIGHT);
    }
    public void turn(int direction)
    {
        _turnCounter++;
        spiralCheck();
        setDirection(getDirection() + direction);
    }

    void spiralCheck()
    {
        if(_turnCounter > requiredTurns && movesAllowed > 0)
        {
            if(requiredTurns == 2)
                requiredTurns--;

            _turnCounter = 0;
            movesAllowed--;
        }
        moveCounter = movesAllowed;
    }
}
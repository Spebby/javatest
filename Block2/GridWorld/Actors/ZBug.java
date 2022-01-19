package GridWorld.Actors;
import java.awt.Color;

import GridWorld.Core.Location;
import GridWorld.Objects.Rock;
import GridWorld.Viewport.Grid;

// create class "ZBug" that extends "Bug"
public class ZBug extends Bug
{
    int width = 3;
    int height = (width * 5/3);
    private int widthCount = width - 1;
    private int heightCount = height - 1;
    boolean isMovingX;


    public ZBug()
    {
        super(Color.WHITE);
    }
    public ZBug(int width)
    {
        super(Color.WHITE);
        this.width = width;
    }

    public void act()
    {
        if(isMovingX)
        {
            widthCount = width - 1;
        }
        else
        {
            heightCount = height - 1;
        }

        if(canMove())
        {
            move();
            if(widthCount <= 0)
                turn(Location.RIGHT);
                isMovingX = true;
        }
        else
        {
            turn();
        }
        
    }

    public void move()
    {
        Grid<Actor> gr = getGrid();
        if(gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if(gr.isValid(next))
        {
            moveTo(next);
        }
    }
    
    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }
    public void turn(int direction)
    {
        setDirection(getDirection() + direction);
    }
}
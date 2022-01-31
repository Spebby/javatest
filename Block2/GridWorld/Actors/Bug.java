/* AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann */
 
package GridWorld.Actors;
//import info.gridworld.grid.Grid;
//import info.gridworld.grid.Location;
import java.awt.Color;

import GridWorld.Core.Location;
import GridWorld.Objects.Flower;
import GridWorld.Viewport.Grid;

// A Bug is an actor that can move and turn. It drops flowers as it moves.
public class Bug extends Actor
{

    // Overload
    public Bug()
    {
        setColor(Color.RED);
    }
    public Bug(Color bugColor)
    {
        setColor(bugColor);
    }

    /**
    * Called every step. <p>
    * If the Bug can move, it moves. If it can't, it turns.
    */
    public void act()
    {
        if (canMove())
            move();
        else
            turn();
    }

    /**
    * Turns the bug 90 degrees to the right without changing its location. <p>
    * <b>Overload Avaliable.</b>
    */
    public void turn()
    {
        setDirection(getDirection() + Location.HALFRIGHT);
    }
    /**
    * Turns the bug the inputed degrees to the left without changing its location.
    * @param degrees the number of degrees to turn the bug to the left.
    */
    public void turn(int degrees)
    {
        setDirection(getDirection() + degrees);
    }

    /**
    * Moves the bug forward, putting a flower into the location it previously occupied.
    */
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
        Flower flower = new Flower(getColor());
        flower.putSelfInGrid(gr, loc);
    }

    /**
    * Tests whether this bug can move forward into a location that is empty or contains a flower.
    * @return true if this bug can move.
    */
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null) 
            return false;

        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        
        Actor neighbor = gr.get(next);
        return (neighbor == null) || (neighbor instanceof Flower);
        // ok to move into empty location or onto flower
        // not ok to move onto any other actor
    }
}
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
import java.awt.Color;

import GridWorld.Core.Location;
import GridWorld.Objects.Flower;
import GridWorld.Viewport.Grid;

// A Bug is an actor that can move and turn. It drops flowers as it moves.
public class JumpBug extends Bug
{
    Grid<Actor> gr = getGrid();
    Location loc = getLocation();

    // Overload
    public JumpBug()
    {
        setColor(Color.RED);
    }
    public JumpBug(Color bugColor)
    {
        setColor(bugColor);
    }

    /**
    * Called every step. <p>
    * If the Bug can move, it moves. If it can't, it tries to Jump, if that fails, it turns.
    */
    public void act()
    {
        if (canMove())
            move();
        else if(canJump())
            jump();
        else
            turn();
    }

    public void jump()
    {
        if (gr == null)
            return;
            
        Location next = loc.getAdjacentLocation(getDirection());
        Location next2 = next.getAdjacentLocation(getDirection()); // this is stupid but im lazy rn
        if (gr.isValid(next2))
            moveTo(next2);
        else
            removeSelfFromGrid();
        Flower flower = new Flower(getColor());
        flower.putSelfInGrid(gr, loc);
    }

    public boolean canJump()
    {
        if (gr == null) 
            return false;
        
        Location next = loc.getAdjacentLocation(getDirection());
        Location next2 = next.getAdjacentLocation(getDirection()); // this is stupid but im lazy rn
        if(!gr.isValid(next2))
        {
            jump();
            return true;
        }
        if (!gr.isValid(next))
            return false;
            
        Actor neighbor = gr.get(next);
        return (neighbor == null) || (neighbor instanceof Flower);
    }
}
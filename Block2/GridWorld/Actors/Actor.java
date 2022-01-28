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
import Common.Vector2Int;
import GridWorld.Viewport.Grid;

// An Actor is an entity with a color and direction that can act.
public class Actor
{
    private Grid<Actor> grid;
    private Location location;
    private int direction;
    private Color color;

    public Actor()
    {
        color = Color.BLUE;
        direction = Location.NORTH;
        grid = null;
        location = null;
    }

    public Color getColor() 
        { return color; }
    public void setColor(Color newColor) 
        { color = newColor; }
    public int getDirection() 
        { return direction; }
    public void setDirection(int newDirection)
    {
        direction = newDirection % Location.FULLCIRCLE;
        if (direction < 0)
            direction += Location.FULLCIRCLE;
    }
    public Location getLocation() 
        { return location; }
    public void setLocation(Vector2Int loc)
        { 
            Location newLoc = new Location(loc.x, loc.y);
            Grid<Actor> gr = getGrid();
            if (gr == null)
                return;
            gr.put(newLoc, this);
        }

    public Grid<Actor> getGrid() 
        { return grid; }

    // Puts this actor into a grid. If there is another actor at the given location, it is removed.
    public void putSelfInGrid(Grid<Actor> gr, Location loc)
    {
        if (grid != null)
            throw new IllegalStateException(
                    "This actor is already contained in a grid.");

        Actor actor = gr.get(loc);
        if (actor != null)
            actor.removeSelfFromGrid();

        gr.put(loc, this);
        grid = gr;
        location = loc;
    }

    // Removes this actor from its grid.
    public void removeSelfFromGrid()
    {
        if (grid == null)
            throw new IllegalStateException(
                    "This actor is not contained in a grid.");
        if (grid.get(location) != this)
            throw new IllegalStateException(
                    "The grid contains a different actor at location "
                            + location + ".");

        grid.remove(location);
        grid = null;
        location = null;
    }

    // Moves this actor to a new location. If there is another actor at the given location, it is removed.
    public void moveTo(Location newLocation)
    {
        if (grid == null)
            throw new IllegalStateException("This actor is not in a grid.");

        if (grid.get(location) != this)
            throw new IllegalStateException( "The grid contains a different actor at location " + location + ".");

        if (!grid.isValid(newLocation))
            throw new IllegalArgumentException("Location " + newLocation + " is not valid.");

        if (newLocation.equals(location))
            return;

        grid.remove(location);
        Actor other = grid.get(newLocation);
        if (other != null)
            other.removeSelfFromGrid();

        location = newLocation;
        grid.put(location, this);
    }

    // Reverses the direction of this actor. Override this method in subclasses of Actor to define types of actors with different behavior
    public void act() 
        { setDirection(getDirection() + Location.HALFCIRCLE); }

    // Creates a string that describes this actor. @return a string with the location, direction, and color of this actor
    public String toString()
        { return getClass().getName() + "[location=" + location + ",direction=" + direction + ",color=" + color + "]"; }
}
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

package GridWorld.Objects;
import java.awt.Color;

import GridWorld.Actors.Actor;

// An actor that darkens over time. Some actors drop flowers as they move.

public class Flower extends Actor
{
    private static final Color _DEFAULT_COLOR = Color.PINK;
    private static final double _DARKENING_FACTOR = 0.05;

    public Flower()
    {
        setColor(_DEFAULT_COLOR);
    }
    public Flower(Color initialColor)
    {
        setColor(initialColor);
    }

    // Causes the color of this flower to darken. Loses 5% of color value in each step.
    public void act()
    {
        Color c = getColor();
        int red = (int) (c.getRed() * (1 - _DARKENING_FACTOR));
        int green = (int) (c.getGreen() * (1 - _DARKENING_FACTOR));
        int blue = (int) (c.getBlue() * (1 - _DARKENING_FACTOR));
        if(red < 20 && green < 20 && blue < 20)
        {
            removeSelfFromGrid();
        }
        setColor(new Color(red, green, blue));
    }
}

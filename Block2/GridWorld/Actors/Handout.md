https://lgsuhsd.instructure.com/courses/23640/files/3220718?wrap=1 // ref sheet, this markdown is a digital copy <br />
https://lgsuhsd.instructure.com/courses/23640/files/3220717?wrap=1 // lab 17 <br />
https://lgsuhsd.instructure.com/courses/23640/files/3226842?wrap=1 // lab 18 <br />

# INFO
This file is a summary of methods of essential classes. These are useful when writing instructions for bugs. (duh)

# Location *Class*

## Compass directions: *Int*
NORTH = 0 <br />
EAST = 90 <br />
SOUTH = 180 <br />
WEST = 270 <br />
NORTHEAST = 45 <br />
SOUTHEAST = 135 <br />
SOUTHWEST = 225 <br />
NORTHWEST = 315 <br />
## Turn angles: *Int*
LEFT = -90 <br />
RIGHT = 90 <br />
HALFLEFT = -45 <br />
HALFRIGHT = 45 <br />
FULLCIRCLE = 360 <br />
HALFCIRCLE = 180 <br />
AHEAD = 0 <br />
## Board Locations: *Vector2Int*
TOP = new (0, 4) <br />
TOPRIGHT = (0, 9) <br />
TOPLEFT = (0, 0) <br />
CENTRE = (4, 4) <br />
CENTRERIGHT = (4, 9) <br />
CENTRELEFT = (4, 0) <br />
BOTTOM = (9, 4) <br />
BOTTOMRIGHT = (9, 9) <br />
BOTTOMLEFT = (9, 0) <br />

### public Location(int r, int c)  
    constructs a location with given row and column coordinates  
 
### public int getRow()  
    returns the row of this location  
 
### public int getCol()  
    returns the column of this location  
 
### public Location getAdjacentLocation(int direction)  
    returns the adjacent location in the direction that is closest to direction  
 
### public int getDirectionToward(Location target)  
    returns the closest compass direction from this location toward target 
  
### public boolean equals(Object other)  
    returns true if other is a Location with the same row and column as this location; false otherwise  
 
### public int hashCode()  
    returns a hash code for this location  
 
### public int compareTo(Object other)  
    returns a negative integer if this location is less than other, zero if the two locations are equal, or a positive 
    integer if this location is greater than other. Locations are ordered in row-major order.  
    Precondition: other is a Location object.  
 
### public String toString()  
    returns a string with the row and column of this location, in the format (row, col)  

# Grid *Interface*

### int getNumRows()  
    returns the number of rows, or -1 if this grid is unbounded  
 
### int getNumCols()  
    returns the number of columns, or -1 if this grid is unbounded  
 
### boolean isValid(Location loc)
    returns true if loc is a valid location on the grid, false otherwise 
    Precondition: loc is not null  

// i'm so used to <T> not <E>
### E put(Location loc, E obj)  
    puts obj at location loc in this grid and returns the object previously at that location (or null if the 
    location was previously unoccupied).  
    Precondition: (1) loc is valid in this grid (2) obj is not null  
 
### E remove(Location loc)  
    removes the object at location loc from this grid and returns the object that was removed (or null if the 
    location is unoccupied) 
    Precondition: loc is valid in this grid  
 
### E get(Location loc)  
    returns the object at location loc (or null if the location is unoccupied) 
    Precondition: loc is valid in this grid  
 
### ArrayList<Location> getOccupiedLocations()  
    returns an array list of all occupied locations in this grid  
 
### ArrayList<Location> getValidAdjacentLocations(Location loc)  
    returns an array list of the valid locations adjacent to loc in this grid 
    Precondition: loc is valid in this grid  
 
### ArrayList<Location> getEmptyAdjacentLocations(Location loc)  
    returns an array list of the valid empty locations adjacent to loc in this grid 
    Precondition: loc is valid in this grid  
 
### ArrayList<Location> getOccupiedAdjacentLocations(Location loc)  
    returns an array list of the valid occupied locations adjacent to loc in this grid 
    Precondition: loc is valid in this grid  
 
### ArrayList<E> getNeighbors(Location loc)  
    returns an array list of the objects in the occupied locations adjacent to loc in this grid 
    Precondition: loc is valid in this grid

# Actor *Base Class*

### public Actor()
    constructs a blue actor that is facing north  
 
### public Color Get & Set Colour
    returns the color of this actor  
    sets the color of this actor to newColor  
 
### public int Get & Set Direction
    returns the direction of this actor, an angle between 0 and 359 degrees
    sets the direction of this actor to the angle between 0 and 359 degrees that is equivalent to newDirection  
 
### public Grid<Actor> getGrid()  
    returns the grid of this actor, or null if this actor is not contained in a grid  
 
### public Location getLocation()  
    returns the location of this actor, or null if this actor is not contained in a grid 
 
### public void putSelfInGrid(Grid<Actor> gr, Location loc)  
    puts this actor into location loc of grid gr. If there is another actor at loc, it is removed.  
    Precondition: (1) This actor is not contained in a grid (2) loc is valid in gr  
 
### public void removeSelfFromGrid()  
    removes this actor from its grid. 
    Precondition: this actor is contained in a grid  
 
### public void moveTo(Location newLocation)  
    moves this actor to newLocation. If there is another actor at newLocation, it is removed.  
    Precondition: (1) This actor is contained in a grid (2) newLocation is valid in the grid of this actor  
 
### public void act()  
    reverses the direction of this actor. Override this method in subclasses of Actor to define types of actors with different behavior  
 
### public String toString()  
    returns a string with the location, direction, and color of this actor  

## Rock
### public Rock() "Color rockColor"
    constructs a black rock  
    overload: constructs a rock with color rockColor  
 
### public void act() 
    overide: does nothing
 
## Flower
### public Flower() "Color initalColor"  
    constructs a pink flower
    overload: constructs a flower with initialColor
 
### public void act()  
    causes the color of this flower to darken  
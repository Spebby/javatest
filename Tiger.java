public class Tiger
{
    // This is just a 1d position :(
    private Vector2Int location;
    private String name;
    //private String stepStatus;
    private int speed;

    public Tiger(String n, int sp)
    {
        location = new Vector2Int(0,0);
        name = n;
        speed = sp;
    }

    // Execute when move
    public void move(Vector2Int moveAmount)
    {
        if(moveAmount.x != 0)
        {
            moveAmount.x = speed + moveAmount.x;
        }
        if(moveAmount.y != 0)
        {
            moveAmount.y = speed + moveAmount.y;
        }
        
        location.x = location.x + moveAmount.x;
        location.y = location.y + moveAmount.y;
    }

    // Status of tiger
    public void status()
    {
        // There are better ways of doing this
        /* // This code worked when "Location" was just a simple Int. It is pointless now.
        if(location > 1 | location <= 0)
        {
            stepStatus = " steps.";
        }
        else
        {
            stepStatus = " step.";
        }
        */
        System.out.println(name + " is located at " + location.x + " x and " + location.y + " y.");
    }
}
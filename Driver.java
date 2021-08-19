/* C# is cooler :)
 * define the class
*/
public class Driver
{
    // tiger mode
    public static void main()
    {
        Tiger tigerObj = new Tiger("Tony", 2);
        tigerObj.status();
        tigerObj.move(new Vector2Int(1,1));
        tigerObj.status();
        Tiger tigerObj2 = new Tiger("John the 4th of Afghanistan", 1);
        tigerObj2.move(new Vector2Int(1,3));
        tigerObj2.move(new Vector2Int(2,1));
        tigerObj2.move(new Vector2Int(2,2));
        tigerObj2.status();
    }
} 
// Obama was here
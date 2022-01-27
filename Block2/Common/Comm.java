package Common;

public class Comm
{
    public static double Fact(double x) 
    {
        if(x <= 1)
            return 1;
        else
            return Fact(x * (x - 1));
    }

    public static Vector2 Abs(Vector2 in)
    {
        return new Vector2(Math.abs(in.x), Math.abs(in.y));
    }

    public static double Distance(Vector2 x, Vector2 y)
    {
        double _xDist = Math.abs(x.x - y.x);
        double _yDist = Math.abs(x.y - y.y);
        return Math.sqrt((_xDist * _xDist) + (_yDist * _yDist));
    }
    public static double Distance(Vector2Int x, Vector2Int y)
    {
        double _xDist = Math.abs(x.x - y.x);
        double _yDist = Math.abs(x.y - y.y);
        return Math.sqrt((_xDist * _xDist) + (_yDist * _yDist));
    }

    public static Vector2 Multiply(Vector2 in, double _multiplier)
    {
        return new Vector2((in.x * _multiplier), (in.y * _multiplier));
    }
    public static Vector2 Multiply(Vector2 x, Vector2 y)
    {
        double _finalX = x.x * y.x;
        double _finalY = x.y * y.y;
        return new Vector2(_finalX, _finalY);
    }
    public static Vector2 Divide(Vector2 in, double _divisor)
    {
        return new Vector2(in.x / _divisor, in.y / _divisor);
    }
    public static Vector2 Divide(Vector2 x, Vector2 y)
    {
        double _finalX = x.x / y.x;
        double _finalY = x.y / y.y;
        return new Vector2(_finalX, _finalY);
    }

    /**
    * @deprecated "Min value must be smaller than Max value."
    * @param in "The input Vector, its values are clamped."
    * @param min "The minimum value. Must be smaller than max."
    * @param max "The maximum value. Must be larger than min."
    */
    @Deprecated
    public static Vector2Int Clamp(Vector2Int in, double min, double max) throws Exception
    {
        if(min >= max)
            throw new Exception("Mininum or Maximum values are equal or mismatched.");
        
        if(in.x < min)
            in.x = min;
        if(in.x > max)
            in.x = max;
        if(in.y < min)
            in.y = min;
        if(in.y > max)
            in.y = max;

        return in;
    }
}
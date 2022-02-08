package Common;

public class comFunc
{
    /** @param x : Number of iterations.
      * @return The product of the first {@code x} Integers. */
    public static int SumOfNumbs(int x)
    {
        if(x == 1)
            return 1;
        else
            return x + SumOfNumbs(x - 1);
    }
    /** @param location on the in the Fibonacci Sequence.
      * @return The Fibonacci number at the {@code location}. */
    public static int Fibonacci(int location)
    {
        if(location == 1)
            return 1;
        else if(location == 2)
            return 1;
        else
            return Fibonacci(location - 1) + Fibonacci(location - 2);
    }

    /** @deprecated This method can return unrespected results. Double Factorials are usually not used.
      * @param num : {@code Number} of iterations. */
    public static double Fact(double num) 
    {
        return num <= 1 ? 1 : num * Fact(num - 1);
    }
    public static int Fact(int num) 
    {
        return num <= 1 ? 1 : num * Fact(num - 1);
    }

    public static int collatz(int num)
    {
        if(num == 1)
            return 0;
        else if(num % 2 == 0)
            return 1 + collatz(num / 2);
        else
            return 1 + collatz(3 * num + 1);
    }
    public static double collatz(double num)
    {
        if(num == 1)
            return 0;
        else if(num % 2 == 0)
            return 1 + collatz(num / 2);
        else
            return 1 + collatz(3 * num + 1);
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


    /** @param   in    The unclamped Vector.
      * @param   min   The mininum value of any point.
      * @param   max   The maximum value of any point.
      * @return  the clamped {@code Vector}.
      * @throws  IndexOutOfBoundsException
      *          if the {@code maximum} argument is smaller or equal to the
      *          {@code mininum} argument. */
    public static Vector2Int Clamp(Vector2Int in, int min, int max) throws IndexOutOfBoundsException
    {
        if(min >= max)
            throw new IndexOutOfBoundsException("Mininum or Maximum values are equal or mismatched.");
        
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

    /** Removes the spaces from a String. <P>
      * ex: Race Car returns as RaceCar.
      * @param input : The String evaluated.
      * @return the {@code Input} without spaces. */
    public static String spaceRemover(String input)
    {
        for(int i = 0; i < input.length(); i++)
        {
            if(input.charAt(i) == ' ')
            {
                input = input.substring(0, i) + input.substring(i + 1);
                i--;
            }
        }

        return input;
    }

    /** Checks if a String is a Palindrome.
      * @param input : The String evaluated.
      * @return true or false. */
    public static boolean Palindrome(String input)
    {
        input = input.toLowerCase();
        final var first = input.charAt(0);
        final var last = input.charAt(input.length() - 1);

        if(input.length() > 2)
        {
            final var _output = input.substring(1, input.length() - 1);
            Palindrome(_output);
        }

        return first == last ? true : false;
    }
    /** Checks if a Char Array is a Palindrome. <P>
      * <b> Overload </b>
      * @param input : The Char Array evaluated.
      * @return true or false. */
    public static boolean Palindrome(char[] input)
    {
        String str = input.toString();
        return Palindrome(str);
    }
    

    /** Checks if a String is in Alphabetical order.
      * @param input : The String evaluated.
      * @return true or false. */
    public static boolean AlphaCheck(String input)
    {
        input = input.toLowerCase();
        final var first = input.charAt(0);
        final var second = input.charAt(1);
        // A = 65, B = 66
        boolean x = first < second ? true : false; 

        if(x && input.length() > 2)
        {
            final var _output = input.substring(1);
            AlphaCheck(_output);
        }

        return x;
    }
    /** Checks if a Char Array is in Alphabetical order. <P>
      * <b> Overload </b>
      * @param input : The Char Array evaluated.
      * @return true or false. */
    public static boolean AlphaCheck(char[] input)
    {
        String str = input.toString();
        return AlphaCheck(str);
    }
}
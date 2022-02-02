package Common;

public class Datang 
{
    public static boolean Palindrome(String input)
    {
        input = input.toLowerCase();
        final var first = input.charAt(0);
        final var last = input.charAt(input.length() - 1);

        if(input.length() > 2)
        {
            final var output = input.substring(1, input.length() - 1);
            Palindrome(output);
        }

        return first == last ? true : false;
    }
}

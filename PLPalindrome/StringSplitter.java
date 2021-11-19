import java.util.ArrayList;

public class StringSplitter
{
    ArrayList<Word> words = new ArrayList<Word>();
    public StringSplitter(String s)
    {
        String temp = "";
        int spaceCount = 0;
        boolean hasSpace = false;
        // This works but does not account for the last word
        // Nor does it work for if there's only 1 word.
        for(int i = 0; i < s.length(); i++)
        {
            // Checks if there's any spaces at all
            for(int sc = 0; sc < s.length(); sc++)
            {
                if(s.charAt(i) == ' ')
                {
                    hasSpace = true;
                    spaceCount++;
                }
            }
            if(hasSpace)
                System.out.println("Has " + spaceCount + " Space(s)");
            
            // if there's a space, split the words.
            if(hasSpace)
            {
                if(s.charAt(i) != ' ')
                {
                    temp += s.charAt(i);
                }
                else 
                {
                    words.add(new Word(temp)); 
                    System.out.println(temp);
                    temp = "";
                }
            }
            
            else // If no spaces, make all of s a word.
            {
                words.add(new Word(s)); 
                System.out.println(s);
                break;
            }
        }
        // debug
        System.out.println("Split " + s + " into " + words.size() + " words!");
        for(int i = 0; i < words.size(); i++)
            System.out.print(words.get(i) + " ");
    }
    
    public ArrayList<Word> ReturnSplit() { return words; }
}
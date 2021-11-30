import java.util.ArrayList;

public class StringSplitter
{
    ArrayList<Word> words = new ArrayList<Word>();
    public StringSplitter(String s)
    {
        String temp = "";
        int spaceCount = 0;
        boolean hasSpace = false;
        // simple check for if there's any spaces
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == ' ')
            {
                hasSpace = true;
                spaceCount++;
            }
        }

        // if spaces, split the words
        if(hasSpace)
        {
            for(int i = 0; i < s.length(); i++)
            {
                if(spaceCount > 0)
                {
                    if(s.charAt(i) != ' ')
                        temp += s.charAt(i);
                    else
                    {
                        words.add(new Word(temp));
                        spaceCount--;
                        temp = "";
                    }
                }
                else
                {
                    words.add(new Word(s.substring(i)));
                    spaceCount--;
                    temp = "";
                    break;
                }
            }
        }
        else // otherwise, make the whole string a word
            words.add(new Word(s));
    }
    
    public ArrayList<Word> ReturnSplit() { return words; }
}
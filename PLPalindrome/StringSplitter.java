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
            //System.out.println("Has " + spaceCount + " Space(s)");
            for(int i = 0; i < s.length(); i++)
            {
                if(spaceCount > 0)
                {
                    if(s.charAt(i) != ' ')
                        temp += s.charAt(i);
                    else
                    {
                        words.add(new Word(temp)); //System.out.println(temp);
                        spaceCount--;
                        temp = "";
                    }
                }
                else
                {
                    words.add(new Word(s.substring(i))); //System.out.println(s.substring(i));
                    spaceCount--;
                    temp = "";
                    break;
                }
            }
        }
        else // otherwise, make the whole string a word
            words.add(new Word(s));

        // debug
        System.out.println("Split " + s + " into " + words.size() + " words!");
        for(int i = 0; i < words.size(); i++)
            System.out.print(words.get(i) + " ");
    }
    
    public ArrayList<Word> ReturnSplit() { return words; }
}
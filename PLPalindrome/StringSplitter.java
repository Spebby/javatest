import java.util.ArrayList;

public class StringSplitter
{
    ArrayList<Word> words = new ArrayList<Word>();
    public StringSplitter(String s)
    {
        String temp = "";
        int index = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) != ' ') temp += s.charAt(i);
            else words.add(new Word(temp)); temp = "";
            index++;
        }
        // debug
        System.out.println("Split " + s + " into " + words.size() + " words!");
        for(int i = 0; i < words.size(); i++)
            System.out.print(words.get(i) + " ");
    }
    
    public ArrayList<Word> ReturnSplit() { return words; }
}
import java.util.ArrayList;

public class StringUtil
{
    ArrayList<Word> words;
    public StringUtil(String s)
    {
        StringSplitter ss = new StringSplitter(s);
        words = ss.ReturnSplit();
    }
    
    public String Palindrome()
    {
        String phrase;
        return phrase;
    }
    public String PigLatin()
    {
        String phrase = "";
        String temp = "";
        // this should also just work fine with a single word, double check.
        for(int i = 0; i < words.size(); i++)
        {
            if(words.get(i).hasVowel())
            {
                // If the vowel is the first letter, add "yay", other wise make the vowel the first letter and move the removed words to the back of the word + "ay"
                if(words.get(i).WhereIsVowel() == 0) temp = (words.get(i).GetWord() += "yay");
                else
                {
                    String holder = "";
                    for(int j = 0; j < words.get(i).GetWord().length(); j++)
                    {
                        // should stop short of the first vowel.
                        if(j < words.get(i).WhereIsVowel())
                        {
                            holder += words.get(i).GetWord().charAt(j);
                            temp = (words.get(i).GetWord().charAt(j) -= words.get(i).GetWord().charAt(j));
                        }
                        else temp += (holder += "ay");
                    }
                    System.out.println(temp);
                }
            }
            // no complexity if there's no vowel :)
            else temp = (words.get(i).GetWord() += "ay");
            phrase += (temp += " ");
            temp = "";
        }
        return phrase;
    }
}
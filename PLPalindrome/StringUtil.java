import java.util.ArrayList;

public class StringUtil
{
    ArrayList<Word> words;
    public StringUtil(String s)
    {
        StringSplitter ss = new StringSplitter(s);
        words = ss.ReturnSplit();
    }
    
    public String PigLatin()
    {
        String phrase = "";
        String temp = "";
        
        for(int i = 0; i < words.size(); i++)
        {
            String _temp = words.get(i).ToString();
            if(words.get(i).HasVowel())
            {
                // If the vowel is the first letter, add "yay", other wise make the vowel the first letter and move the removed words to the back of the word + "ay"
                if(words.get(i).WhereIsVowel() == 0) 
                    temp = (_temp += "yay");
                else
                {
                    // cuts away at scentences to expose vowels
                    String holder = "";
                    boolean isUppercase = false;
                    for(int j = 0; j < words.get(i).ToString().length(); j++)
                    {
                        // should stop short of the first vowel.
                        if(j < words.get(i).WhereIsVowel())
                        {
                            if(Character.isUpperCase(words.get(i).ToString().charAt(j)))
                                isUppercase = true;
                            holder += words.get(i).ToString().toLowerCase().charAt(j);
                        }
                        else if (j == words.get(i).WhereIsVowel())
                        {
                            if(isUppercase)
                                temp += (_temp.toUpperCase().charAt(j) + _temp.substring(j + 1));
                            else
                                temp += _temp.substring(j);

                            temp += (holder + "ay");
                        }
                    }
                }
            }
            // no complexity if there's no vowel :)
            else 
                temp = (_temp += "ay");
            
            if(i + 1 == words.size()) 
                phrase += (temp += ".");
            else
                phrase += (temp += " ");

            temp = "";
        }
        return phrase;
    }

    public String Palindrome()
    {
        String phrase = "";
        return phrase;
    }
}
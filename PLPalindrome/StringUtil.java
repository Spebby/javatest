import java.util.ArrayList;

public class StringUtil
{
    ArrayList<Word> words;
    String base = "";
    boolean isPalindrome = false;
    public StringUtil(String s)
    {
        base = s;
        StringSplitter ss = new StringSplitter(s);
        words = ss.ReturnSplit();
    }
    
    public void PigLatin()
    {
        String phrase = "";
        String temp = "";
        
        for(int i = 0; i < words.size(); i++)
        {
            String _temp = words.get(i).ToString();
            if(words.get(i).HasVowel())
            {
                // If the vowel is the first letter, add "yay", other wise make the vowel the first letter and move the removed words to the back of the word + "ay"
                if(words.get(i).vowelIndex() == 0) 
                    temp = (_temp += "yay");
                else
                {
                    // cuts away at scentences to expose vowels
                    String holder = "";
                    boolean isUppercase = false;
                    for(int j = 0; j < words.get(i).ToString().length(); j++)
                    {
                        // should stop short of the first vowel.
                        if(j < words.get(i).vowelIndex())
                        {
                            if(Character.isUpperCase(words.get(i).ToString().charAt(j)))
                                isUppercase = true;
                            holder += words.get(i).ToString().toLowerCase().charAt(j);
                        }
                        else if (j == words.get(i).vowelIndex())
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
        System.out.println("Pig Latin: " + phrase);
    }

    public void Palindrome()
    {
        char[] temp = base.toCharArray();
        String phrase = "";
        for(int i = temp.length - 1; i >= 0; i--)
            phrase += temp[i];

        if(phrase.toLowerCase().equals(base.toLowerCase()))
        {
            isPalindrome = true;
            System.out.println(phrase + " is a Palindrome.");
        }
        else
            System.out.println(phrase + " is not a Palindrome.");
    }
}
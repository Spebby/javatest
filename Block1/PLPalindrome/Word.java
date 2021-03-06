package PLPalindrome;

public class Word
{
    String _word;
    boolean hasVowel = true;
    boolean hasPunct = false;
    char _cPunct;
    int fVowel = 0;
    char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u' };
    
    public Word(String w)
    {
        _word = w;
        for(int i = 0; i < _word.length(); i++)
        {
            boolean done = false;
            // Checks if word has a vowel, and sets its index is.
            for(int j = 0; j < vowels.length; j++)
            {
                if(_word.toLowerCase().charAt(i) == vowels[j]) 
                {
                    done = true;
                    fVowel = i;
                    break;
                }
            }
            if(done) break;
            if((i + 1) == _word.length() && !done) 
                hasVowel = false;
        }
    }
    
    public int vowelIndex() { return fVowel; }
    public String ToString() { return _word; } 
    public boolean HasVowel() { return hasVowel; }
    public boolean HasPunct() { return hasPunct; }
    public char GetPunct() { return _cPunct; }
}
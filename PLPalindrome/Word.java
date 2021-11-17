public class Word
{
    String _word;
    boolean hasVowel = true;
    int fVowel;
    char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u' };
    
    public Word(String w)
    {
        _word = w;
        for(int i = 0; i < _word.length(); i++)
        {
            boolean done = false;
            for(int j = 0; j < vowels.length; j++)
            {
                if(_word.toLowerCase().charAt(i) == vowels[j]) 
                {
                    done = true;
                    break;
                }
                fVowel = i;
            }
            if(done) break;
            if((i + 1) == _word.length() && !done) hasVowel = false;
        }
    }
    
    public int WhereIsVowel() { return fVowel; }
    public String GetWord() { return _word; } 
    public boolean HasVowel() { return hasVowel; }
}
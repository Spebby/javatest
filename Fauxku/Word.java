public class Word
{
    String text; 
    int syllables;
    
    public Word(String t, int s) { text = t; syllables = s; }
    public String GetWord() { return text; }    
    public int GetSyll() { return syllables; }
}
package Fauxku;

public class FauxkuMaker
{
    // me when i read from a json
    Word[] words = new Word[]{
    new Word("index", 2), new Word("wise", 1), new Word("big", 1), new Word("bog", 1),
    new Word("old", 1), new Word("young", 1), new Word("dead", 1), new Word("black", 1),
    new Word("dragonfly", 3), new Word("whimsy", 2), new Word("dreadful", 2), new Word("stupid", 2),
    new Word("pointless", 2), new Word("ocean", 2), new Word("voyage", 2), new Word("gay", 1),
    new Word("joy", 1), new Word("weak", 1), new Word("boring", 2), new Word("posh", 1),
    new Word("tennis", 2), new Word("cactus", 2), new Word("analysis", 4), new Word("subset", 2), 
    new Word("cannot", 2), new Word("setup", 2), new Word("rocket", 2), new Word("kidnap", 2), 
    new Word("kidnapped", 3), new Word("heretic", 3), new Word("vomit", 2), new Word("radish", 2), 
    new Word("coffin", 2), new Word("enrich", 2), new Word("metric", 2), new Word("goblin", 2), 
    new Word("picnic", 2), new Word("combat", 2), new Word("attic", 2), new Word("until", 2), 
    new Word("public", 2), new Word("hellish", 2), new Word("vanish", 2), new Word("magnet", 2), 
    new Word("hectic", 2), new Word("plummet", 2), new Word("edit", 2), new Word("baggage", 2), 
    new Word("cabbage", 2), new Word("gnome", 1), new Word("decimate", 3), new Word("deconstruct", 3), 
    new Word("fantastic", 3), new Word("volcanic", 3), new Word("establish", 3), new Word("inhabit", 3), 
    new Word("murder", 2), new Word("crows", 1), new Word("bash", 1), new Word("enact", 2), 
    new Word("cosmetic", 3), new Word("imprison", 3), new Word("admonish", 3), new Word("accomplish", 3), 
    new Word("abandon", 3), new Word("badminton", 3), new Word("halibut", 3), new Word("ne'er-do-well", 3), 
    new Word("roustabout", 3), new Word("haberdash", 3), new Word("burly", 2), new Word("gargoyle", 2), 
    new Word("oblivion", 4), new Word("booger", 2), new Word("Kumquat", 2) 
    };
    
    public void Create(int _howMany)
    {
        for(int i = 0; i < _howMany; i++)
            System.out.println(Assemble());
    }
    
    String Assemble()
    {
        String c = "";
        int SyllLeft;
        for(int i = 0; i <= 2; i++)
        {
            if(i == 1) SyllLeft = 7;
            else SyllLeft = 5;
            int start = SyllLeft;
            while(0 < SyllLeft)
            {
                Word temp = GNWord(SyllLeft);
                if(SyllLeft == start) c += Capitalize(temp.GetWord());
                else c += temp.GetWord();
                SyllLeft -= temp.GetSyll();
                //System.out.println(SyllLeft + " " + c);
                if(SyllLeft != 0)
                    c += " ";
            }
            if(i < 2) c += ". ";
            else c += ".";
        }
        return c;
    }
    
    Word GNWord(int bandwidth) // "GetNewWord"
    {
        Word b;
        while(true)
        {
            b = words[(int)(Math.random() * words.length)];
            if(b.GetSyll() <= bandwidth) break;
        }
        //System.out.println(b.GetWord() + " " + b.GetSyll());
        return b;
    }
    
    static String Capitalize(String str) 
    {
        if(str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
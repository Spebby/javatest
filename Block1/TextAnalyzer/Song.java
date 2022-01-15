package TextAnalyzer;

public class Song 
{
    String _band;
    String _title;
    int _plays;
    int _likes;

    public Song(String b, String t, int p, int l)
    {
        _band = b;
        _title = t;
        _plays = p;
        _likes = l;
    }

    public String GetBand() { return _band; }
    public String GetTitle() { return _title; }
    public int GetPlays() { return _plays; }
    public int GetLikes() { return _likes; }
}

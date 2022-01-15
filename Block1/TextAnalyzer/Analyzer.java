package TextAnalyzer;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Analyzer 
{
    ArrayList<Song> songs;

    public Analyzer(String fileName)
    {
        songs = new ArrayList<Song>();

        try
        {
            Scanner scan = new Scanner(new File(fileName + ".txt"));
            while(scan.hasNext())
            {
                String line = scan.nextLine();
                Seperate( line );
            }
        }
        catch( FileNotFoundException ex) { System.out.println("File not found"); }
    }

    void Seperate(String str)
    {
        int comma = str.indexOf(",");
        String _band = str.substring(0, comma);
        str = str.substring(comma + 3);

        comma = str.indexOf("\",");
        String _title = str.substring(0, comma);
        str = str.substring(comma + 3);

        // seperate number of plays
        comma = str.indexOf(",");
        String p = str.substring(0, comma);
        int _plays = Integer.parseInt(p);
        str = str.substring(comma + 2);

        // convert number of likes
        int _likes = Integer.parseInt(str);
        // create Song object and add it to array list
        songs.add(new Song(_band, _title, _plays, _likes));
    }

    public int GetTotalPlays()
    {
        int total = 0;
        for(int i = 0; i < songs.size(); i++)
            total += songs.get(i).GetPlays();
        return total;
    }
    public int GetTotalLikes()
    {
        int total = 0;
        for(int i = 0; i < songs.size(); i++)
            total += songs.get(i).GetLikes();
        return total;
    }
    public String GetHighestP2L()
    {
        int index = 0;
        float[] ratios = new float[songs.size()];
        for(int i = 0; i < songs.size(); i++)
            ratios[i] = (float)songs.get(i).GetPlays() / (float)songs.get(i).GetLikes();
        for(int i = 0; i < ratios.length; i++)
            if(ratios[i] > ratios[index])
                index = i;

        String c = songs.get(index).GetTitle();
        c = c.replace("\"", "");
        return c;
    }
    public String GetLowestP2L()
    {
        int index = 0;
        float[] ratios = new float[songs.size()];
        for(int i = 0; i < songs.size(); i++)
            ratios[i] = (float)songs.get(i).GetPlays() / (float)songs.get(i).GetLikes();
        for(int i = 0; i < ratios.length; i++)
            if(ratios[i] < ratios[index])
                index = i;

        String c = songs.get(index).GetTitle();
        c = c.replace("\"", "");
        return c;
    }
    public String GetClosestToAverage()
    {
        float avg = GetTotalPlays()/songs.size();
        String c = "";
        // find song closest to average
        int index = 0;
        for(int i = 0; i < songs.size(); i++)
        {
            if(Math.abs(songs.get(i).GetPlays() - avg) < Math.abs(songs.get(index).GetPlays() - avg))
            {
                index = i;
                c = songs.get(i).GetBand();
            }
        }
        return c;
    }
    public String GetMostLiked()
    {
        Song placeholder = new Song("", "", 0, 0);
        int highest = 0;
        for(int i = 0; i < songs.size(); i++)
        {
            if(songs.get(i).GetLikes() > highest)
            {
                highest = songs.get(i).GetLikes();
                placeholder = songs.get(i);
            }
        }
        String title = "";
        // set title to the title of the song with the most likes, all lowercase, without spaces
        title = placeholder.GetTitle();
        return title;
    }
    public String GetMostPlayed(boolean trendy)
    {
        Song placeholder = new Song("", "", 0, 0);
        int highest = 0;
        for(int i = 0; i < songs.size(); i++)
        {
            if(songs.get(i).GetPlays() > highest)
            {
                highest = songs.get(i).GetPlays();
                placeholder = songs.get(i);
            }
        }
        String title = "";
        // set title to the title of the song with the most plays, all lowercase, without spaces
        title = placeholder.GetTitle();
        if(trendy)
        {
            title = title.replace(" ", "");
            title = "#" + title.toLowerCase() + "slaps";
        }
        return title;
    }
    public String GetLeastPlayed()
    {
        Song placeholder = new Song("", "", 0, 0);
        int lowest = 9^999;
        for(int i = 0; i < songs.size(); i++)
        {
            if(songs.get(i).GetPlays() < lowest)
            {
                lowest = songs.get(i).GetPlays();
                placeholder = songs.get(i);
            }
        }
        String title = "";
        title = placeholder.GetTitle();
        return title;
    }
    // The last three methods should be one class that's more flexible but I'm too lazy to do that rn
    public String GetLongestSong()
    {
        String longest = "";
        for(int i = 0; i < songs.size(); i++)
        {
            if(songs.get(i).GetTitle().length() > longest.length())
                longest = songs.get(i).GetTitle();
        }
        return longest;
    }
}
import java.util.Scanner;

public class Driver
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Song Data file name. (e.g. 'SongData')");
        System.out.println("Should be formated like: Artist, 'Title', # of Plays, # of Likes");
        String fileName = scan.nextLine();
        Analyzer al = new Analyzer(fileName);
        System.out.println("Data file loaded.");
        System.out.println();
        System.out.println("=== Data Collected ===");
        System.out.println("Total number of plays: " + al.GetTotalPlays());
        System.out.println("Song with the most plays: " + al.GetMostPlayed(false));
        System.out.println("Song with the least plays: " + al.GetLeastPlayed());
        System.out.println("Total number of likes: " + al.GetTotalLikes());
        System.out.println("Song with the most likes: " + al.GetMostLiked());
        System.out.println("Highest play to like Ratio: " + al.GetHighestP2L());
        System.out.println("Lowest play to like Ratio: " + al.GetLowestP2L());
        System.out.println("The longest song name: " + al.GetLongestSong());
        System.out.println("The Band closest to the average plays is: " + al.GetClosestToAverage());
        System.out.println("I hate hashtags but it was a requirement: " + al.GetMostPlayed(true));

        scan.close();
    }
}
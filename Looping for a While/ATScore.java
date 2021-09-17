import java.text.DecimalFormat;

// this is just a worse GPA calc
public class ATScore extends DriverFeeder
{
    public void Initialize()
    {
        System.out.print('\f');
        System.out.println("Welcome to the ATScore Calculator.");
        System.out.println("Enter as many test scores as you like, this'll find the average.");
        System.out.println("Enter \"-1\" to stop entering test scores. Lowest test score is ignored.");
        System.out.println("Scores are assumed to be a percentage of 100, scores above will be rounded down.");
        System.out.println();
        
        float c;
        float total = 0;
        int numofEnt = 0;
        while(true)
        {
            c = scan.nextFloat();
            if(c < 0)
                break;
            if(c > 100)
                c = 100;
            total += c;
            numofEnt++;
        }
        String Nulled = scan.nextLine();
        Nulled = null;
        
        CalcATScore(total, numofEnt);
    }
    
    void CalcATScore(float total, int numofEnt)
    {
        DecimalFormat median = new DecimalFormat("###.###"); // Formats to 1 decimal.
        
        System.out.println("You entered " + numofEnt + " scores. Your average score is... " + median.format(total/numofEnt) + "!");
        System.out.println();
        LoopProgram();
    }
}
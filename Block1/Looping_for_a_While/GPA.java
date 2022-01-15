package Looping_for_a_While;
import java.text.DecimalFormat;

public class GPA extends DriverFeeder
{
    String[] gradesVal = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F", "E"};
    
    public void Initialize()
    {
        System.out.print('\f');
        System.out.println("Welcome to the GPA Calculator. This Calculator is made with a ceiling of 4.0 in mind.");
        System.out.println("Acceptable entries include: ");
        for(int i = 0; i < gradesVal.length; i++)
        {
            if(i != gradesVal.length - 1)
                System.out.print(gradesVal[i] + ", ");
            else
                System.out.print(gradesVal[i]);
        }
        System.out.println();
        System.out.println("Enter as many letter grades as you want. Enter \"Done\"when you're finished entering grades..");
        boolean p = false;
        int gnum = 0;
        float gp = 0;
        
        // ArrayList is too complicated for this. All this should do is check for what letter grades were entered, 
        // convert those into number values, then add those together. Another counter should exist for number of
        // letter grades entered. Then GPA calculations are done based on # of classes and total grade points.
        while(p == false)
        {
            String c = scan.nextLine();
            c = c.toUpperCase();
            switch(c)
            {
                case "A+":
                case "A":
                    gp += 4;
                    gnum++;
                    break;
                case "A-":
                    gp += 3.7f;
                    gnum++;
                    break;
                case "B+":
                    gp += 3.3f;
                    gnum++;
                    break;
                case "B":
                    gp += 3;
                    gnum++;
                    break;
                case "B-":
                    gp += 2.7f;
                    gnum++;
                    break;
                case "C+":
                    gp += 2.3;
                    gnum++;
                    break;
                case "C":
                    gp += 2;
                    gnum++;
                    break;
                case "C-":
                    gp += 1.7f;
                    gnum++;
                    break;
                case "D+":
                    gp += 1.3;
                    gnum++;
                    break;
                case "D":
                    gp += 1;
                    gnum++;
                    break;
                case "D-":
                case "F":
                case "E":
                    gp += 0;
                    gnum++;
                    break;
                case "DONE":
                    p = true;
                    break;
                default:
                    System.out.println("Invalid entry, enter something valid.");
                    break;
            }
            //System.out.println(gp);
        }
        //System.out.println("gp: " + gp + " gnum: " + gnum);
        System.out.println();
        
        CalcGPA(gp, gnum);
    }
    
    void CalcGPA(float gp, int gnum)
    {
        DecimalFormat median = new DecimalFormat("###.###"); // Formats to 1 decimal.
        
        System.out.println("You entered " + gnum + " grades. Your total GPA is... " + median.format(gp/gnum) + "!");
        System.out.println();
        LoopProgram();
    }
}
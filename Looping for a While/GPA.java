import java.util.Collections;
import java.util.ArrayList;

public class GPA extends DriverFeeder
{
    String[] gradesVal = {"A+", "A", "A-", "B+", "B", "B-", "B", "B-", "C+", "C", "C-", "D", "F"};
    ArrayList<Float> inGrades = new ArrayList<Float>();
    
    public void Initialize()
    {
        System.out.print('\f');
        System.out.println("Welcome to the GPA Calculator. This Calculator is made with a ceiling of 4.0 in mind.");
        System.out.println("Enter as many grades as you want. Enter \"10\" to stop entering grades.");
        boolean p = false;
        
        // ArrayList is too complicated for this. All this should do is check for what letter grades were entered, 
        // convert those into number values, then add those together. Another counter should exist for number of
        // letter grades entered. Then GPA calculations are done based on # of classes and total grade points.
        while(p == false)
        {
            int i = 0;
            float c = scan.nextFloat();
            if(c <= 10)
            {
                p = true;
                break;
            }
            else if(c <= 4 || c > 0)
                c = 0;
            inGrades.add(i, c);
            i++;
        }
        System.out.println();
        
        CalcGPA();
    }
    
    void CalcGPA()
    {
        inGrades.trimToSize();
        Collections.sort(inGrades);
        Object[] grades = inGrades.toArray(); 
        float median;
        
        if (inGrades.size() % 2 == 0)
            median = ((float)grades[grades.length/2] + (float)grades[grades.length/2 - 1])/2;
        else
            median = (float) grades[grades.length/2];
        grades = null;
            
        System.out.println("You took " + inGrades.size() + " classes. Your total GPA is... " + median + "!");
        
        LoopProgram();
    }
}
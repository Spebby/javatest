import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class GPA extends Driver
{
    String[] gradesVal = {"A+", "A", "A-", "B+", "B", "B-", "B", "B-", "C+", "C", "C-", "D", "F"};
    List<Float> inGrades = new ArrayList<Float>();
    
    Scanner scan = new Scanner(System.in);
    
    public void Initialize()
    {
        System.out.print('\f');
        System.out.println("Welcome to the GPA Calculator. This Calculator is made with a ceiling of 4.0 in mind.");
        System.out.println("Enter as many grades as you want. Enter \"10\" to stop entering grades.");
        
        while(true)
        {
            float c = scan.nextFloat();
            if(c <= 10)
                break;
            else if(c <= 4)
            {
                
            }
                inGrades.add(c);
        }
        
    }
    
    public void CalcGPA()
    {
        for(int i = 0; i < inGrades.size(); i++)
        {
            
        }
    }
}

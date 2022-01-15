package If_it_Fits_it_Ships;
import java.util.Scanner;

public class MailChecker
{
    Package p1;
    int length;
    int girth;

    Scanner scan = new Scanner(System.in);
    
    public MailChecker()
    {
        System.out.println("The weight of the package in pounds is: ");
        float w = scan.nextFloat();
        System.out.println("What is the X dimesion of the package in inches: ");
        float x = scan.nextFloat();
        System.out.println("What is the Y dimesion of the package in inches: ");
        float y = scan.nextFloat();
        System.out.println("What is the Z dimesion of the package in inches: ");
        float z = scan.nextFloat();

        p1 = new Package(w, x, y, z);

    }

    public void check()
    {
        float weight = p1.getWeight();
        float length = p1.getLength();
        float girth = p1.getGirth();

        if (weight > 70 && (girth + length) > 100)
            System.out.println("The package is " + (weight - 70) + " pounds too heavy and " + ((girth + length) - 100) + " inches too large.");
        else if(weight <= 70 && (girth + length) > 100)
            System.out.println("The package is " + ((girth + length) - 100) + " inches too large.");
        else if(weight > 70 && (girth + length) <= 100)
            System.out.println("The package is " + (weight - 70) + " pounds too heavy.");
        else
            System.out.println("Package may be shipped first class.");
    }
}
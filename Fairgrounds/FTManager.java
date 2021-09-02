public class FTManager 
{
    int Day;
    int Month;
    int Nature;

    public FTManager(String m, int d)
    {   
        // Makes strings uppercase to simplify case fallthroughs.
        m = m.toUpperCase();

        // Converts String into int for easier use.
        switch(m)
        {
            case "JANURARY":
            case "JAN":
                Month = 1;
                Nature = 0;
                break;
            case "FEBURARY":
            case "FEB":
                Month = 2;
                Nature = 0;
                break;
            case "MARCH":
            case "MAR":
                Month = 3;
                Nature = 1;
                break;
            case "APRIL":
            case "APR":
                Month = 4;
                Nature = 1;
                break;
            case "MAY":
                Month = 5;
                Nature = 1;
                break;
            case "JUNE":
            case "JUN":
                Month = 6;
                Nature = 2;
                break;
            case "JULY":
            case "JUL":
                Month = 7;
                Nature = 2;
                break;
            case "AUGUST":
            case "AUG":
                Month = 8;
                Nature = 2;
                break;
            case "SEPTEMBER":
            case "SEP":
                Month = 9;
                Nature = 3;
                break;
            case "OCTOBER":
            case "OCT":
                Month = 10;
                Nature = 3;
                break;
            case "NOVEMBER":
            case "NOV":
                Month = 11;
                Nature = 3;
                break;
            case "DECEMBER":
            case "DEC":
                Month = 12;
                Nature = 0;
                break;
            default: // Funny guy protection
                Month = 1;
                Nature = 0;
                break;
        }

        // Funny guy protection
        if(d <= 0)
            d = 1;
        if(d > 31)
            d = 31;

        // Checks if the day is illegal for the month, if so, change it.
        switch(Month)
        {
            case 2:
                if(d >= 30)
                    d = 29;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if(d >= 31)
                    d = 30;
                break;
            default:
                d = 30;
                break;
        }

        Day = d;
    }

    public int GetDay()
    {
        return Day;
    }

    public int GetMonth()
    {
        return Month;
    }

    public int GetNature()
    {
        return Nature;
    }
}
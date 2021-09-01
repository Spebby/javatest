public class FTManager 
{
    int Day;
    int Month;
    public FTManager(String m, int d)
    {   
        // Makes strings uppercase to simplify case fallthroughs.
        String mU = m.toUpperCase();
        m = null;

        // Converts String into int for easier use.
        switch(mU)
        {
            case "JANURARY":
            case "JAN":
                Month = 1;
                break;
            case "FEBURARY":
            case "FEB":
                Month = 2;
                break;
            case "MARCH":
            case "MAR":
                Month = 3;
                break;
            case "APRIL":
            case "APR":
                Month = 4;
                break;
            case "MAY":
                Month = 5;
                break;
            case "JUNE":
            case "JUN":
                Month = 6;
                break;
            case "JULY":
            case "JUL":
                Month = 7;
                break;
            case "AUGUST":
            case "AUG":
                Month = 8;
                break;
            case "SEPTEMBER":
            case "SEP":
                Month = 9;
                break;
            case "OCTOBER":
            case "OCT":
                Month = 10;
                break;
            case "NOVEMBER":
            case "NOV":
                Month = 11;
                break;
            case "DECEMBER":
            case "DEC":
                Month = 12;
                break;
            default: // Funny guy protection
                Month = 1;
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
}
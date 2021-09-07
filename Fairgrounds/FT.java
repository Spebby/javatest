// In this game, the player enters a random number(s) (Birthday/rn perhaps?)
// When they enter this, the computer generates a random value, and then
// The computer compares said number to the player entered number
// The computer will then give them a fortune.
import java.util.Scanner;

public class FT
{
    Scanner scan = new Scanner(System.in);
    FTManager ftMng;

    public void Initialize()
    {
        System.out.print('\f');
        
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(" ########:: #######:: ########:: ########: ##:::: ##: ##::: ##: ########:");
        System.out.println(" ##.....:: ##.... ##: ##.... ##:... ##..:: ##:::: ##: ###:: ##: ##.....::");
        System.out.println(" ##::::::: ##:::: ##: ##:::: ##:::: ##:::: ##:::: ##: ####: ##: ##:::::::");
        System.out.println(" ######::: ##:::: ##: ########::::: ##:::: ##:::: ##: ## ## ##: ######:::");
        System.out.println(" ##...:::: ##:::: ##: ##.. ##:::::: ##:::: ##:::: ##: ##. ####: ##...::::");
        System.out.println(" ##::::::: ##:::: ##: ##::. ##::::: ##:::: ##:::: ##: ##:. ###: ##:::::::");
        System.out.println(" ##:::::::. #######:: ##:::. ##:::: ##::::. #######:: ##::. ##: ########:");
        System.out.println("..:::::::::.......:::..:::::..:::::..::::::.......:::..::::..::........::");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Welcome to the Fortune Telling Tent, your destiny fortold!");
        System.out.println();
        System.out.print("What month were you born on? ");
        String m = scan.nextLine();

        System.out.print("And what day? ");
        int d = scan.nextInt();

        ftMng = new FTManager(m, d);
        m = scan.nextLine(); // bug with int and scanner
        
        FortuneFinder();
    }

    // This is the fun part, the switch now has to compare the month the user inputed against the days avaliable. 
    public void FortuneFinder()
    {
        System.out.println();
        System.out.println("Your fortune is...");
        // We need the Nature & the day. The nature lowers the amount of fortunes we actually have to come up with.
        switch(ftMng.GetNature())
        {
            case 0:
                FortuneN0();
                break;
            case 1:
                FortuneN1();
                break;
            case 2:
                FortuneN2();
                break;
            case 3:
                FortuneN3();
                break;
        }
    }    
    
    // Literally just copied Rebith's fortune text.
    void FortuneN0()
    {
        switch(ftMng.GetDay())
        {
            case 1:
                System.out.println("STAY ASLEEP");
                break;
            case 2:
                System.out.println("NOBODY KNOWS THE HORRORS AHEAD");
                break;
            case 3:
                System.out.println("DO NOT LOSE YOUR MIND");
                break;
            case 4:
                System.out.println("DO NOT LEAVE YOUR HOME");
                break;
            case 5:
                System.out.println("GET A PET, IT WILL CHEER YOU UP");
                break;
            case 6:
                System.out.println("THAT WAS A WASTE OF TIME");
                break;
            case 7:
                System.out.println("THE DEVIL IN DISGUISE");
                break;
            case 8:
                System.out.println("ONLY THE SINNER SPEAKS");
                break;
            case 9:
                System.out.println("SEE WHAT HE SEES");
                break;
            case 10:
                System.out.println("QUESTION AUTHORITY");
                break;
            case 11:
                System.out.println("DO WHAT HE LIES");
                break;
            case 12:
                System.out.println("GO DIRECTLY TO JAIL");
                break;
            case 13:
                System.out.println("TRUST NO ONE");
                break;
            case 14:
                System.out.println("THE SUN WILL RISE");
                break;
            case 15:
                System.out.println("THINK FOR YOURSELF");
                break;
            case 16:
                System.out.println("TRUST GOOD PEOPLE");
                break;
            case 17:
                System.out.println("THEY ARE SINNERS");
                break;
            case 18:
                System.out.println("FOLLOW THE DOG");
                break;
            case 19:
                System.out.println("FOLLOW THE CAT");
                break;
            case 20:
                System.out.println("EDMUND LIVES");
                break;
            case 21:
                System.out.println("IT LIVES");
                break;
            case 22:
                System.out.println("IT NEVER ENDS");
                break;
            case 23:
                System.out.println("LIVE TO DIE");
                break;
            case 24:
                System.out.println("LIES IN RUIN");
                break;
            case 25:
                System.out.println("YOUR OLD LIFE DIES");
                break;
            case 26:
                System.out.println("MAY YOUR TROUBLES BE MANY");
                break;
            case 27:
                System.out.println("BRING THE WHISPERER THE PHOTO");
                break;
            case 28:
                System.out.println("BLAME NOBODY BUT YOURSELF");
                break;
            case 29:
                System.out.println("LOOK TO LA LUNA");
                break;
            case 30:
                System.out.println("GO OUTSIDE");
                break;
            case 31:
                System.out.println("WHEN LIFE GIVES YOU LEMONS, GIVE UP");
                break;
        }
        EndGame();
    }
    
    void FortuneN1()
    {
        switch(ftMng.GetDay())
        {
            case 1:
                System.out.println("GIVE UP");
                break;
            case 2:
                System.out.println("YOU ARE THROWING YOUR LIFE AWAY");
                break;
            case 3:
                System.out.println("IT'S OVER");
                break;
            case 4:
                System.out.println("ASK AGAIN LATER");
                break;
            case 5:
                System.out.println("ROLLED AN 8");
                break;
            case 6:
                System.out.println("IT IS HIDDEN DEEP WITHIN DARKNESS");
                break;
            case 7:
                System.out.println("FIND YOUR SOUL");
                break;
            case 8:
                System.out.println("MARRY AND REPRODUCE");
                break;
            case 9:
                System.out.println("WAKE ME UP");
                break;
            case 10:
                System.out.println("WAKE UP");
                break;
            case 11:
                System.out.println("YOU ARE DARK INSIDE");
                break;
            case 12:
                System.out.println("YOU MAKE MISTAKES, IT IS ONLY NATURAL");
                break;
            case 13:
                System.out.println("A HANGED MAN BRINGS YOU NO LUCK");
                break;
            case 14:
                System.out.println("DO NOT LOOK SO HURT");
                break;
            case 15:
                System.out.println("ALWAYS YOUR HEAD, IN THE CLOUDS");
                break;
            case 16:
                System.out.println("DO NOT CRY OVER SPILLED TEAR");
                break;
            case 17:
                System.out.println("MEET STRANGERS WITHOUT PREJUDICE");
                break;
            case 18:
                System.out.println("YOU SHOULD EXERCISE MORE");
                break;
            case 19:
                System.out.println("TAKE YOUR MEDICATION"); // normal pills lol
                break;
            case 20:
                System.out.println("COME TO A FORK");
                break;
            case 21:
                System.out.println("TAKE IT");
                break;
            case 22:
                System.out.println("BELIEVE IN YOURSELF");
                break;
            case 23:
                System.out.println("YOU ARE PLAYING IT WRONG");
                break;
            case 24:
                System.out.println("NOBODY BUT YOURSELF");
                break;
            case 25:
                System.out.println("TAKE ADVANTAGE");
                break;
            case 26:
                System.out.println("THE MAN ON THE MOUNTAIN DID NOT FALL THERE");
                break;
            case 27:
                System.out.println("LET GO");
                break;
            case 28:
                System.out.println("IT CONTROLS US");
                break;
            case 29:
                System.out.println("IT IS NOW");
                break;
            case 30:
                System.out.println("TORMENT");
                break;
            case 31:
                System.out.println("IT WILL CALL YOU");
                break;
        }
        EndGame();
    }
    
    void FortuneN2()
    {
        switch(ftMng.GetDay())
        {
            case 1:
                System.out.println("IT CAN LAST");
                break;
            case 2:
                System.out.println("IT HOLDS THE CARDS");
                break;
            case 3:
                System.out.println("IN DREAMS");
                break;
            case 4:
                System.out.println("YOU HAVE A MESSAGE");
                break;
            case 5:
                System.out.println("TRY");
                break;
            case 6:
                System.out.println("FORTUNE FAVOURS THE BRAVE");
                break;
            case 7:
                System.out.println("LAND IS ON THE MIND");
                break;
            case 8:
                System.out.println("SORROW REARS ITS HEAD");
                break;
            case 9:
                System.out.println("AGAIN");
                break;
            case 10:
                System.out.println("WE MUST LIVE");
                break;
            case 11:
                System.out.println("LET THE DEEDS SPEAK");
                break;
            case 12:
                System.out.println("IT WILL CONQUER YOU");
                break;
            case 13:
                System.out.println("IT IS BETTER TO BE ALONE");
                break;
            case 14:
                System.out.println("ADVERSARY IS THE PARENT OF VIRTUE");
                break;
            case 15:
                System.out.println("YOU ARE WRONG");
                break;
            case 16:
                System.out.println("THE SILK FOLLOWS");
                break;
            case 17:
                System.out.println("THE SEEDS OF DOUBT OUR SOWN");
                break;
            case 18:
                System.out.println("REMEMBER THEM");
                break;
            case 19:
                System.out.println("IT CASTS A SHADOW UPON YOU");
                break;
            case 20:
                System.out.println("LIVE IN SONG");
                break;
            case 21:
                System.out.println("GOODNIGHT");
                break;
            case 22:
                System.out.println("FORGIVE THE FATHER");
                break;
            case 23:
                System.out.println("IT ENDS");
                break;
            case 24:
                System.out.println("HATE THE MOTHER");
                break;
            case 25:
                System.out.println("TAKEN ADVANTAGE");
                break;
            case 26:
                System.out.println("HE FELL THERE");
                break;
            case 27:
                System.out.println("DO NOT LET GO");
                break;
            case 28:
                System.out.println("GIVE UP");
                break;
            case 29:
                System.out.println("IT WILL BE");
                break;
            case 30:
                System.out.println("GIVE UP");
                break;
            case 31:
                System.out.println("NOT TO BE");
                break;
        }
        EndGame();
    }
    
    void FortuneN3()
    {
        switch(ftMng.GetDay())
        {
            case 1:
                System.out.println("IT CAN NOT LAST");
                break;
            case 2:
                System.out.println("SHOULD IT?");
                break;
            case 3:
                System.out.println("LOVE THE MOTHER");
                break;
            case 4:
                System.out.println("DOUBT THE FATHER");
                break;
            case 5:
                System.out.println("GIVE UP");
                break;
            case 6:
                System.out.println("FORTUNE FAVOURS THE COWARDLY");
                break;
            case 7:
                System.out.println("THE PIG FOLLOWS");
                break;
            case 8:
                System.out.println("IT FOLLOWS THE LEAD");
                break;
            case 9:
                System.out.println("LOOK FOR THE EYES");
                break;
            case 10:
                System.out.println("IT WAS MEANT TO BE LOST");
                break;
            case 11:
                System.out.println("YOU WILL REGAIN WHAT WAS LOST");
                break;
            case 12:
                System.out.println("SHE COMES FOR US");
                break;
            case 13:
                System.out.println("FORGIVE BUT NOT FORGET");
                break;
            case 14:
                System.out.println("PUT ME TO SLEEP");
                break;
            case 15:
                System.out.println("DO NOT TRUST THE BROTHER");
                break;
            case 16:
                System.out.println("WE WISH FOR A WORLD");
                break;
            case 17:
                System.out.println("THOSE WHO WERE LEFT BEHIND");
                break;
            case 18:
                System.out.println("IT FORGIVES");
                break;
            case 19:
                System.out.println("GIVE UP");
                break;
            case 20:
                System.out.println("LOOK UP");
                break;
            case 21:
                System.out.println("FORGET");
                break;
            case 22:
                System.out.println("WAKE ME UP");
                break;
            case 23:
                System.out.println("IT BEGINS");
                break;
            case 24:
                System.out.println("LET UP");
                break;
            case 25:
                System.out.println("IT DOES NOT FORGET");
                break;
            case 26:
                System.out.println("NEVER GIVE IT UP");
                break;
            case 27:
                System.out.println("WHAT DIES IS REBORN");
                break;
            case 28:
                System.out.println("GULLIBLE");
                break;
            case 29:
                System.out.println("LIVE WITH EMPATHY");
                break;
            case 30:
                System.out.println("YOU WILL SEE HIM AGAIN");
                break;
            case 31:
                System.out.println("LOST");
                break;
        }
        EndGame();
    }
    
    void EndGame()
    {
        System.out.println();
        System.out.println("I hope that was insightful.");
        
        
    }
}
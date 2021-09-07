// This brokey. Was trying to implement multi-threading but it didn't workout and crashed.

//import java.util.Scanner;

// Play until you die, at the end of the game say how many rounds the player lives.
public class UnusedRR
{
    /*
    Scanner scan = new Scanner(System.in);
    
    public void Initialize()
    {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("       .,                    ,-·-.          ,'´¨;               ,.         ,·´'; '                 _,.,  °             ,  . .,  °                         _  °                  ,.,   '");
        System.out.println("   ,·´    '` ·.'              ';   ';)      ,'´  ,':)'        ;'´*´ ,')       ,'  ';')°         ,.·'´  ,. ,  `;) '     ;'´    ,   ., _';)'        ,.·,       :´¨   ;)                 ;´   '· .,");
        System.out.println("    )`; `·;·.   `·,           ;   ';:)   .'   ,'´::')'       ;    ';::)      ;  ;::')       .´   ;´:::::)`'´ )')     ):´¨¯:;'   `;::'):')     ,'   ,')     .'´ ,·´::')              .´  .-,    ';)");
        System.out.println("     ;   ,')::`·,   )'         ')   ';::;'´  ,'´::::;'       ;      ');'      ;  ;:::;      /   ,'::)::::::):::):'      )::::;   ,'::_');'     ;'  ,'::) .·' .·´::::::;'            /   /:):';   ;:')'");
        System.out.println("    ;   ,'::'):::';   ';          )  '·:'  ,'´:::::;' '      ,'  ,'`)   )      ;  ;:::;     ;   ;:;:-·'~^ª*';)'´            ,'  ,'::;'  ‘       ;  ;::·´ .·´:::::::;·´           ,'  ,'::::')';  ;::';");
        System.out.println("    ;   ;:::;'·:.'  ,·')'          '·,   ,'::::::;'´        ;  ;::;')  ')    ;  ;:::;      ;  ,.-·:*'´¨'`*´)::) '           ;  ;:::;  °      ';  '´   ;´::::::;·´           ,.-·'  '·~^*'´¨,  ';::;");
        System.out.println("   ';  ';: -· '´. ·'´:::')'          ,'  /::::::;'  '       ;  ;:::;  ')  ') ,'  ;:::;'     ;   ;)::::::::::::');'            ;  ;::;'  ‘       ;  ;')   ')::;·´               ':,  ,·:²*´¨¯'`;  ;::';");
        System.out.println("   ;  ,-·:'´:):::::::;·'         ,´  ';)::::;'  '        ,' ,'::;'     ')   ¨ ,')::;'      ;  ;'_)_:;:: -·^*';)            ;  ;::;'‚        ;  ;:):'·.  '·., ,.·';'          ,'  / )::::::::';  ;::';");
        System.out.println("  ,'  ';::::::');:·'´             )`*ª'´))::/‘           ;.')::;        )`*´)::); °     ';    ,  ,. -·:*'´:):')°          ',.')::;'‚        ;_;::')::`·._,.·'´:)'         ,' ,'::::)·²*'´¨¯':,'):;");
        System.out.println("  )·.,·);-· '´  '                 '):::::)';  '          ):::)'          '):::):' '        )`*´ ¯):::::::::::);' '          )::):;'‚        )::'):;' '·::)::):::::')        )`¨):::/          )::)'");
        System.out.println("   )::):)                          `*ª'´‘                ):'             `*´'‚            ):::::);::-·^*'´                );:'      ‘     ')::)     `·')::);:·'´'         ')::);'            ');'  '");
        System.out.println("    `'·;·'                            '                                                     `*´¯                           °              ¯          ¯'                `¨'");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Welcome to Roulette! Spin & Pray. Each round you click, the chamber spins while you wait. The game ends after you lose.");
        System.out.println("Type \"Shoot\" when you're ready to fire.");
        
        RunLogic();
    }
    
    int attempts = 0;
    int pChamber = 1;
    int bChamber;
    
    public void RunLogic()
    {
        System.out.println();
        attempts += 1;
        
        bChamber = (int)(Math.random() * 6) + 1;
        
        new Thread(new WaitLogic()).start();
        new Thread(new ReadInput()).start();
    }
    
    class ReadInput extends Thread
    {
        public void Run()
        {
            String line = scan.nextLine();
            
            if(pChamber == bChamber)
            {
                System.out.println("BANG! Game Over!");
                End(attempts);
            }
            else
            {
                System.out.println("Click! A dud, let's go again!");
                RunLogic();
            }
        }
    }
    
    class WaitLogic extends Thread
    {
        public void Run()
        {
            int counter = 0; // debug
            
            do
            {
                pChamber += 1;
                
                if(pChamber > 6)
                {
                    counter += 1;
                    pChamber = 1;
                    System.out.println("Reset'd " + counter);
                }
            }
            while(!scan.hasNext());
        }
    }
    
    
    public void End(int at)
    {
        System.out.println();
        System.out.println("What a show! Would you like to play again, or choose another game?");
        System.out.println("Enter \"Yes\" to play again and \"No\" to choose another game. To quit, type anything else");
        String input = scan.nextLine();

        System.out.println();
        
        DriverFeeder df = new DriverFeeder();
        
        if(input.toLowerCase().charAt(0) == 'y')
            Initialize();
        else if(input.toLowerCase().charAt(0) == 'n')
        {
            df.main(true);
            df = null;
        }
        else
        {
            df.QuitGame();
            df = null;
        }
    }
    */
}

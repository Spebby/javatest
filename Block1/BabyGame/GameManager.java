package BabyGame;
import static java.util.concurrent.TimeUnit.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class GameManager
{
    public Board board;
    GameManager gm;
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    NumberFormat fm = new DecimalFormat("#0.00");
    // gives us a nice clean format with two decimal places. ex: 4 = 4.00, 4.52456 = 4.52
    
    public Boolean gameActive = false;
    String desiredInput;
    int points;
    int strikes;
    float timer;
    int defaultTimer = 5;
    public int highScore;

    boolean ChoseInput = false;

    public void Initialize()
    {
        board.disableCN();
        timer = defaultTimer * ((float)(Math.random() * .8f) + .2f);
        points = 0;
        strikes = 3;
        gameActive = true;
        run();
    }

    // can't be called if game is not active.
    public void RegisterInput(String input)
    {
        System.out.println(input);
        if(timer < 0)
        { // Only check inputs in a specific window of time.
            if(input.equals(desiredInput))
                points++;
        }
        else
        {
            strikes--;
            if(strikes == 0)
            {
                gameActive = false;
                if(points > highScore)
                    highScore = points;
                points = 0;
            }    
        }
    }

    void run()
    {
        final Runnable runnable = new Runnable() 
        {
            public void run() 
            {
                board.repaint();
                if(gameActive)
                {
                    timer -= .1f;
                    if(timer <= -0.5f)
                        timer = defaultTimer * ((float)(Math.random() * .8f) + .2f); System.out.println(timer);
                    if(timer < 0 && !ChoseInput)
                        ChoseInput();
                    else if(timer > 0){
                        board.setCentreNotice("");
                        ChoseInput = false;
                    }

                    // board.setTimerLabel("Time left: " + fm.format(timer));
                    board.setPointLabel("Score: " + points);
                }
                else
                    board.clearBoard();
            }
        };
        scheduler.scheduleAtFixedRate(runnable, 0, 100, MILLISECONDS);
    }

    void ChoseInput()
    {
        ChoseInput = true;
        int rand = (int)(Math.random() * 4);
        switch(rand)
        {
            case 0:
                desiredInput = "up";
                break;
            case 1:
                desiredInput = "down";
                break;
            case 2:
                desiredInput = "left";
                break;
            case 3:
                desiredInput = "right";
                break;
        }
        board.setCentreNotice(desiredInput.toUpperCase());
    }
}
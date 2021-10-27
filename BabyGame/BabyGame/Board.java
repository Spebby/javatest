import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements KeyListener
{
    private Player player;
    private int timer;
    private JLabel timeTracker;
    private JLabel pointTracker;
    private JLabel ending;
    private JLabel Finish;
    
    private Square[] square;
    private Square[] squares;
    
    private Square[] squareV;
    private Square[] squaresV;
    private Square[] squares3V;
    
    private Circle[] dots;
    
    private int dotX;
    private int dotY;
    private int addx;
    private int addy;
    
    private Square finish;
    
    private int move;
    public Board()
    {

        this.setPreferredSize(new Dimension(1000,600));
        this.setLayout(null);
        
        this.setBackground(new Color(126,162,170));
       
        square = new Square[4];
        squares = new Square[4];
        
        squareV = new Square[3];
        squaresV = new Square[3];
        squares3V = new Square[3];
        
        dots = new Circle[10];
        dotX = 100;
        dotY = 300;
        addx = 80;
        addy = -50;
        for ( int i =0; i< dots.length; i++ )
        {
            dots[i] = new Circle(dotX, dotY, 10, 255, 238, 194, 0, 0);
            if (dotY >= 350 || dotY <= 250)
            {
                addy *= -1;
            }
            dotX += addx;
            dotY += addy;
        }
        
        move = 850;
        for ( int i =0; i< square.length; i++ )
        {
            square[i] = new Square(move, 100, 70, 70, 54, 69, 79, 0, 1);
            move -= 250;
        }
        
        move = 0;
        for ( int i =0; i< squares.length; i++ )
        {
            squares[i] = new Square(move, 500, 70, 70, 54, 69, 79, 0, 1 );
            move += 250;
        }
        
        
        move = 200;
        for ( int i =0; i< squareV.length; i++)
        {
            squareV[i] = new Square(250, move, 20, 30, 195, 49, 73, 3, 0);
            move += 120;
        }
        move = 200;
        for ( int i =0; i< squaresV.length; i++ )
        {
            squaresV[i] = new Square(450, move, 20, 30, 195, 49, 73, -2, 0);
            move += 120;
        }
        move = 200;
        for ( int i =0; i< squares3V.length; i++ )
        {
            squares3V[i] = new Square(650, move, 20, 30, 195, 49, 73, 1, 0);
            move += 120;
        }
        
        finish = new Square(0, 200, 50, 200, 72, 77, 109, 0, 0);
        
        
        player = new Player();
        
        
        timeTracker = new JLabel("Timer: " + timer );
        this.add( timeTracker );
        timeTracker.setBounds(10, 10, 480, 50);
        timeTracker.setFont(new Font("Serif", Font.BOLD, 48));
        timeTracker.setForeground(Color.ORANGE);
        timeTracker.setVisible(true);
        
        pointTracker = new JLabel("Points: " + player.getPoints());
        this.add( pointTracker );
        pointTracker.setBounds(510, 10, 480, 50);
        pointTracker.setFont(new Font("Serif", Font.BOLD, 48));
        pointTracker.setForeground(Color.ORANGE);
        pointTracker.setHorizontalAlignment(SwingConstants.RIGHT);
        
        JLabel F = new JLabel("F");
        this.add( F );
        F.setBounds(0, 200, 480, 50);
        F.setFont(new Font("Serif", Font.BOLD, 30));
        F.setForeground(Color.RED);
        
        JLabel I = new JLabel("I");
        this.add( I );
        I.setBounds(0, 230, 480, 50);
        I.setFont(new Font("Serif", Font.BOLD, 30));
        I.setForeground(Color.RED);
        
        JLabel N = new JLabel("N");
        this.add( N );
        N.setBounds(0, 260, 480, 50);
        N.setFont(new Font("Serif", Font.BOLD, 30));
        N.setForeground(Color.RED);
        
        JLabel I2 = new JLabel("I");
        this.add( I2 );
        I2.setBounds(0, 285, 480, 50);
        I2.setFont(new Font("Serif", Font.BOLD, 30));
        I2.setForeground(Color.RED);
        
        JLabel S = new JLabel("S");
        this.add( S );
        S.setBounds(0, 310, 480, 50);
        S.setFont(new Font("Serif", Font.BOLD, 30));
        S.setForeground(Color.RED);
        
        JLabel H = new JLabel("H");
        this.add( H );
        H.setBounds(0, 340, 480, 50);
        H.setFont(new Font("Serif", Font.BOLD, 30));
        H.setForeground(Color.RED);
        
        ending = new JLabel();
        this.add(ending);
        ending.setBounds(0, 250, 1000, 100);
        ending.setFont(new Font("Arial", Font.BOLD, 100));
        ending.setForeground(Color.WHITE);
        ending.setHorizontalAlignment(SwingConstants.CENTER);
        ending.setVisible(false);
        
        this.addKeyListener(this);
        this.setFocusable(true);
        
    }
    
    public void keyTyped(KeyEvent event)
    {
    }
    
    public void paintComponent( Graphics page )
    { 

        super.paintComponent(page);
        finish.draw(page);
        for (int i = 0; i < square.length; i++)
        {
            square[i].draw(page);
        }
        for (int i = 0; i < squares.length; i++)
        {
            squares[i].draw(page);
        }
        for (int i = 0; i < squareV.length; i++)
        {
            squareV[i].draw(page);
        }
        for (int i = 0; i < squaresV.length; i++)
        {
            squaresV[i].draw(page);
        }
        for (int i = 0; i < squares3V.length; i++)
        {
            squares3V[i].draw(page);
        }
        
        for (int i = 0; i < dots.length; i++)
        {
            dots[i].draw(page);
        }
        player.draw(page);
        
    }
    
    public void go()
    {
        timer = 0;
        int life = 1;
        while ( life == 1)
        {
            player.move();
            
            for (int i = 0; i <squares.length; i++)
            {
                squares[i].move();
            }
            for (int i = 0; i <squares.length; i++)
            {
                if (collide(squares[i]))
                {
                    ending.setText("#Loser #tough");
                    life = 0;
                }
            }
            
            for (int i = 0; i <square.length; i++)
            {
                square[i].move();
            }
            for (int i = 0; i <square.length; i++)
            {
                if (collide(square[i]))
                {
                    ending.setText("#Loser #tough");
                    life = 0;
                }
            }
            
            for (int i = 0; i <squareV.length; i++)
            {
                squareV[i].move();
            }
            for (int i = 0; i <squareV.length; i++)
            {
                if (collide(squareV[i]))
                {
                    ending.setText("#Loser #tough");
                    life = 0;
                }
            }
            
            for (int i = 0; i <squaresV.length; i++)
            {
                squaresV[i].move();
            }
            for (int i = 0; i <squaresV.length; i++)
            {
                if (collide(squaresV[i]))
                {
                    ending.setText("#Loser #tough");
                    life = 0;
                }
            }
            
            for (int i = 0; i <squares3V.length; i++)
            {
                squares3V[i].move();
            }
            for (int i = 0; i <squares3V.length; i++)
            {
                if (collide(squares3V[i]))
                {
                    ending.setText("#Loser #tough");
                    life = 0;
                }
            }
            
            
            for (int i = 0; i< dots.length; i++)
            {
                if (collideC(dots[i]))
                {
                    player.hit();
                    pointTracker.setText("Points: " + player.getPoints());
                    dots[i].hit(true);
                }
            }
            
            if (collide(finish))
            {
                if (player.getPoints() == 16)
                {
                    ending.setText( "#winner" );
                }
                else if (player.getPoints() < 5)
                {
                    ending.setText( "#winner");
                }
                else
                {
                    ending.setText( "#winner");
                }
                life = 0;
            }
            
            try{
                Thread.sleep(10);
                timer += 10;
                timeTracker.setText("Timer " + timer/1000);
            }catch(InterruptedException ex){}
            
            this.repaint();
        }
        
        ending.setVisible(true);
    }
    
    public boolean collide(Square s)
    {
        int xDiff = s.getCenterX() - player.getCenterX();
        int yDiff = s.getCenterY() - player.getCenterY();
        double dist = Math.sqrt( xDiff*xDiff + yDiff*yDiff);
        if (dist <= s.getRadius() + player.getRadius() )
        {
            return true;
        }
        return false;
    }
    
    public boolean collideC(Circle c)
    {
        int xDiff = c.getCenterX() - player.getCenterX();
        int yDiff = c.getCenterY() - player.getCenterY();
        double dist = Math.sqrt( xDiff*xDiff + yDiff*yDiff);
        if (dist <= c.getRadius() + player.getRadius() )
        {
            return true;
        }
        return false;
    }
    
    public void keyPressed( KeyEvent event)
    {
        if (event.getKeyCode() == KeyEvent.VK_LEFT)
        {
            player.setRight(false);
            player.setLeft(true);
        }
        else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            player.setRight(true);
            player.setLeft(false);
        }
        else if (event.getKeyCode() == KeyEvent.VK_UP)
        {
            player.setUp(true);
            player.setDown(false);
        }
        else if (event.getKeyCode() == KeyEvent.VK_DOWN)
        {
            player.setUp(false);
            player.setDown(true);
        }

    }
    
    
    public void keyReleased( KeyEvent event)
    {
        if (event.getKeyCode() == KeyEvent.VK_LEFT)
        {
            player.setLeft(false);
        }
        else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            player.setRight(false);
        }
        else if (event.getKeyCode() == KeyEvent.VK_UP)
        {
            player.setUp(false);
        }
        else if (event.getKeyCode() == KeyEvent.VK_DOWN)
        {
            player.setDown(false);
        }

    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements KeyListener
{
    GameManager gm;
    
    // Get the size of the screen.
    Dimension scrnSize = Toolkit.getDefaultToolkit().getScreenSize();
    // Acount for Taskbar size.
    Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    int tbH = scrnSize.height - winSize.height;

    RGB BG;
    Vector2Int boardSize = new Vector2Int((int)(scrnSize.width * .75f), (int)((scrnSize.height - tbH) * .75f));

    JLabel centreNotice = new JLabel("", SwingConstants.CENTER);
    JLabel highScoreLabel = new JLabel("", SwingConstants.CENTER);
    JLabel pointLabel = new JLabel("", SwingConstants.RIGHT);

    public Board(GameManager g)
    {
        gm = g;
        gm.board = this; // this is horse shit
        BG = new RGB(35, 35, 35);
        this.setLayout(null);
        this.setBackground(new Color(BG.r, BG.g, BG.b));
        this.setPreferredSize(new Dimension(boardSize.x, boardSize.y));
        setLayout(new BorderLayout(5, 5));
        
        { // Centre Notice
            this.add(centreNotice, BorderLayout.CENTER);
            centreNotice.setBounds(0, 0, boardSize.x/2, 200);
            centreNotice.setText("Press 'SPACE' to start");
            centreNotice.setFont(new Font("Arial", Font.PLAIN, 60));
            centreNotice.setForeground(Color.WHITE);
            centreNotice.setVisible(true);
        }
        { // High Score Label
            // add high score label to the board and centre it
            this.add(highScoreLabel, BorderLayout.NORTH);
            highScoreLabel.setBounds(0, 0, boardSize.x, boardSize.y + 125);
            highScoreLabel.setText("High Score: " + gm.highScore);
            highScoreLabel.setFont(new Font("Arial", Font.PLAIN, 25));
            highScoreLabel.setForeground(Color.WHITE);
            highScoreLabel.setVisible(true);
        }
        { // Point Label
            this.add(pointLabel, BorderLayout.NORTH);
            pointLabel.setBounds(0, 0, boardSize.x/2, 200);
            pointLabel.setLocation(boardSize.x/2 - 150, 0);
            pointLabel.setFont(new Font("Arial", Font.PLAIN, 25));
            pointLabel.setForeground(Color.WHITE);
            pointLabel.setVisible(true);
        }

        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow();
        System.out.print("Player Created ");
    }
    
    public void keyPressed(KeyEvent event) 
    {
        System.out.print("Key Pressed ");
        if(gm.gameActive){
            switch(event.getKeyCode()){
                case KeyEvent.VK_UP:
                    gm.RegisterInput("up");
                    break;
                case KeyEvent.VK_DOWN:
                    gm.RegisterInput("down");
                    break;
                case KeyEvent.VK_LEFT:
                    gm.RegisterInput("left");
                    break;
                case KeyEvent.VK_RIGHT:
                    gm.RegisterInput("right");
                    break;
                default:
                    break;
            }
        }
        else if(event.getKeyCode() == KeyEvent.VK_SPACE)
            gm.Initialize();
    }
    public void keyReleased(KeyEvent event) {}
    public void keyTyped(KeyEvent event) {}

    public void paintComponent(Graphics page){ super.paintComponent(page); }
    public Vector2Int getBSize() { return boardSize; }
    public void disableCN() 
    { 
        centreNotice.setText("");
        highScoreLabel.setVisible(false);
    }
    public void clearBoard() // Called when game is set inactive
    {
        highScoreLabel.setText("High Score: " + gm.highScore);
        centreNotice.setText("Press 'SPACE' to start");
        highScoreLabel.setVisible(true);
        pointLabel.setText("");
    }
    public void setPointLabel(String s) { pointLabel.setText(s); }
    public void setCentreNotice(String s) { centreNotice.setText(s); }
}
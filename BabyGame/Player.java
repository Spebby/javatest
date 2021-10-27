import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Player extends JPanel implements KeyListener
{
    Ball pobj;
    
    public Player(Board b)
    {
        pobj = new Ball(b);
        this.addKeyListener(this);
    }
    
    public void keyPressed(KeyEvent event) 
    {
        switch(event.getKeyCode())
        {
            case KeyEvent.VK_DOWN:
                pobj.SetVel(new Vector2Int(0, -2));
                break;
            case KeyEvent.VK_UP:
                pobj.SetVel(new Vector2Int(0, 2));
                break;
            case KeyEvent.VK_RIGHT:
                pobj.SetVel(new Vector2Int(2, 0));
                break;
            case KeyEvent.VK_LEFT:
                pobj.SetVel(new Vector2Int(-2, 0));
                break;
            default:
                break;
        }
    }
    
    public void keyReleased( KeyEvent event )
    {
        pobj.SetVel(new Vector2Int(0, 0));
    }
    
    public void keyTyped( KeyEvent event )
    {}
}
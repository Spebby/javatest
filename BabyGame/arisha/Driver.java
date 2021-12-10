import javax.swing.*;
class Driver 
{
    public static void main()
    {
        JFrame frame = new JFrame("Baby Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100,100);
        frame.setVisible(true);
        Board b = new Board(); 
        frame.getContentPane().add(b);
        frame.pack();
        b.go();
   }
   
}

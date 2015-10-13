import java.awt.*;
import javax.swing.*;
 
public class Splash extends JWindow {
     
    private int duration;
    JFrame window;
     
    public Splash(int d) {
        duration = d; 
        window=new JFrame("PacMan");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
     
    public void showSplash() {
         
        JPanel content = (JPanel)getContentPane();
        content.setBackground(new Color(0,0,0));
         
        int width = 256;
        int height =512;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x,y,width,height);
         
        JLabel label = new JLabel(new ImageIcon("tera.png"));
        JLabel text = new JLabel
                ("Sebastian's", JLabel.CENTER);
        text.setForeground(Color.green);
        text.setFont(new Font("Sans-Serif", Font.BOLD, 18));
        content.add(label, BorderLayout.CENTER);
        content.add(text, BorderLayout.NORTH);
        Color oraRed = new Color(255, 255,255,  255);
        content.setBorder(BorderFactory.createLineBorder(oraRed, 16));
         
        setVisible(true);
         
        try { Thread.sleep(duration); } catch (Exception e) {}
         
        setVisible(false);
         
    }
     
    public void showSplashAndExit() {
         
        showSplash();
        new Pacman();

         
    }
     
    public static void main(String[] args) {
         
        Splash splashs = new Splash(4000);
 
        splashs.showSplashAndExit();
       
         
    }

}


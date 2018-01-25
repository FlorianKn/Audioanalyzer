import java.awt.*;
import javax.swing.JPanel;

public class Chart extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(212,212,2));
        g2d.drawRect(10,15,90,60);

        g2d.setColor(new Color(31,21,1));
        g2d.fillRect(250,195,90,60);
    }
}
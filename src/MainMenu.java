import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;

public class MainMenu {
    private JButton audiosegmentationButton;
    public JPanel mainPanel;
    private JButton audiodiarizationButton;

    public MainMenu(){
        mainPanel.setPreferredSize(new Dimension(600, 400));
        styleButton(audiosegmentationButton);
        styleButton(audiodiarizationButton);
    }
    private void styleButton(JButton button) {
        Border roundedBorder = new LineBorder(new Color(112, 48, 160), 4, true);

        button.setBorder(roundedBorder);
        button.setForeground(new Color(112, 48, 160));
        button.setBackground(new Color(242,242,242));
        button.setPreferredSize(new Dimension(500,150));
        button.setFont(new Font("Arial", Font.BOLD, 30));
    }
}

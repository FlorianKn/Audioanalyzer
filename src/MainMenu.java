
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    public JPanel mainPanel;
    public JPanel segmentationMenu;
    public JPanel diarizationMenu;
    public JPanel menu;

    private JButton audiodiarizationButton;
    private JButton audiosegmentationButton;
    private JButton sBackButton;
    private JButton dBackButton;

    public MainMenu(JFrame frame){
        mainPanel.setPreferredSize(new Dimension(600, 400));
        styleButton(audiosegmentationButton);
        styleButton(audiodiarizationButton);

        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        audiosegmentationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(segmentationMenu);
                //frame.pack();
                frame.setVisible(true);
            }
        });
        audiodiarizationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(diarizationMenu);

            }
        });
        sBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(menu);
            }
        });
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

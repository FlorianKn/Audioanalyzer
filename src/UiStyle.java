import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class UiStyle {

    public void styleMainMenuBtn(JButton button) {
        Border roundedBorder = new LineBorder(new Color(112, 48, 160), 4, true);

        button.setBorder(roundedBorder);
        button.setForeground(new Color(112, 48, 160));
        button.setBackground(new Color(242,242,242));
        button.setPreferredSize(new Dimension(500,150));
        button.setFont(new Font("Arial", Font.BOLD, 30));
    }

    public void styleBackBtn(JButton button) {
        button.setBorderPainted(false);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setFont(new Font("Arial", Font.BOLD, 20));
    }

    public void styleAudioBtn(JButton button) {
        Border roundedBorder = new LineBorder(new Color(112, 48, 160), 2, true);

        button.setBorder(roundedBorder);
        button.setForeground(Color.BLACK);
        button.setBackground(new Color(242,242,242));
        button.setPreferredSize(new Dimension(130,30));
        button.setFont(new Font("Arial", Font.BOLD, 20));
    }

    public void styleBar(JLabel label) {
        label.setBackground(new Color(231, 230, 230));
        label.setBorder(new LineBorder(new Color(217, 217, 217), 1, true));
        label.setOpaque(true);
        label.setText("Audio.wav");
        label.setForeground(new Color(89, 89, 89));
        label.setFont(new Font("Arial", Font.ITALIC, 10));
        label.setPreferredSize(new Dimension(90,10));
    }

    public void styleSpinner(JSpinner spinner) {
        spinner.setModel(new SpinnerNumberModel(2, 0, 4, 1));
        JFormattedTextField tf = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
        tf.setEditable(false);
    }

    public void displayErrorMessage(JFrame frame) {
        JOptionPane.showMessageDialog(frame,
                "Please choose a wav file first.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}

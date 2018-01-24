import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class MainMenu  implements KeyListener {
    public JPanel mainPanel;
    public JPanel segmentationMenu;
    public JPanel diarizationMenu;
    public JPanel menu;

    private JButton audiodiarizationButton;
    private JButton audiosegmentationButton;
    private JButton sBackButton;
    private JButton dBackButton;
    private JButton sAnalyseButton;
    private JButton sPlayButton;
    private JButton sOpenButton;
    private JLabel sBar;
    private JLabel sName;
    private JButton drecordButton;
    private JButton dAnalyseButton;
    private JButton dPlayButton;
    private JButton dOpenButton;
    private JButton dRecordButton;
    private JLabel placeholder;
    private JLabel dBar;
    private JSpinner dSpinner;
    private WavPlayer w = new WavPlayer();

    // Path to wav file
    private String path = null;

    public MainMenu(JFrame frame){
        styleUi();
        addKeyListener(this);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new CardLayout(0, 0));
        frame.setPreferredSize(new Dimension(700, 400));

        frame.getContentPane().add(menu);
        frame.getContentPane().add(segmentationMenu);
        frame.getContentPane().add(diarizationMenu);
        frame.pack();
        frame.setVisible(true);

        audiosegmentationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                segmentationMenu.setVisible(true);
            }
        });
        audiodiarizationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                diarizationMenu.setVisible(true);
            }
        });
        sBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                segmentationMenu.setVisible(false);
                menu.setVisible(true);
            }
        });
        dBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                diarizationMenu.setVisible(false);
                menu.setVisible(true);
            }
        });
        dOpenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileChooser f = new FileChooser();
                path = f.openWav();
                dBar.setText(path);
            }
        });
        sOpenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileChooser f = new FileChooser();
                path = f.openWav();
                sBar.setText(path);
            }
        });
        sPlayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(path != null) {

                    w.playSound(path);
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Please choose a wav file first.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        dPlayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(path != null) {

                    w.playSound(path);
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Please choose a wav file first.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void styleUi() {
        UiStyle uiStyler = new UiStyle();
        uiStyler.styleMainMenuBtn(audiosegmentationButton);
        uiStyler.styleMainMenuBtn(audiodiarizationButton);
        uiStyler.styleBackBtn(sBackButton);
        uiStyler.styleBackBtn(dBackButton);
        uiStyler.styleAudioBtn(sAnalyseButton);
        uiStyler.styleAudioBtn(sPlayButton);
        uiStyler.styleAudioBtn(sOpenButton);
        uiStyler.styleAudioBtn(dRecordButton);
        uiStyler.styleAudioBtn(dAnalyseButton);
        uiStyler.styleAudioBtn(dOpenButton);
        uiStyler.styleAudioBtn(dPlayButton);
        uiStyler.styleBar(sBar);
        uiStyler.styleBar(dBar);
        uiStyler.styleSpinner(dSpinner);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            w.stopPlayer();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

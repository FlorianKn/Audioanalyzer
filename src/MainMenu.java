import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu   {
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

    public MainMenu(){
        JFrame frame = new JFrame("Audioanalyzer");
        frame.setVisible(true);
        styleUi();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new CardLayout(0, 0));
        frame.setPreferredSize(new Dimension(700, 400));

        frame.getContentPane().add(menu);
        frame.getContentPane().add(segmentationMenu);
        frame.getContentPane().add(diarizationMenu);
        frame.pack();

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
                sBar.setText(path);
            }
        });
        sOpenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileChooser f = new FileChooser();
                path = f.openWav();
                sBar.setText(path);
                dBar.setText(path);
            }
        });

        sPlayButton.addActionListener(new ActionListener() {
            boolean pause = false;
            @Override
            public void actionPerformed(ActionEvent e) {

                if(path != null && pause == false) {
                    pause = true;
                    w.playSound(path);
                    sPlayButton.setText("Pause");
                } else if (pause) {
                    w.stopPlayer();
                    sPlayButton.setText("Play");
                    pause = false;
                }
                else {
                    JOptionPane.showMessageDialog(frame,
                            "Please choose a wav file first.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        dPlayButton.addActionListener(new ActionListener() {
            boolean pause = false;
            @Override
            public void actionPerformed(ActionEvent e) {

                if(path != null && pause == false) {
                    pause = true;
                    w.playSound(path);
                    dPlayButton.setText("Pause");
                } else if (pause) {
                    w.stopPlayer();
                    dPlayButton.setText("Play");
                    pause = false;
                }
                else {
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
}

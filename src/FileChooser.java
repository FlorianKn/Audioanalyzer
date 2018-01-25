import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser {

    public String openWav(){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "WAV files", "wav");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            String path;

            path = chooser.getSelectedFile().getAbsolutePath();
            return  path;
        }
        return null;
    }
    
    public String saveWav() {
        JFileChooser chooser = new JFileChooser();

        int retrival = chooser.showSaveDialog(null);
        if (retrival == JFileChooser.APPROVE_OPTION) {
            try {
                String path;
                path = chooser.getSelectedFile().getAbsolutePath();

                return path;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}

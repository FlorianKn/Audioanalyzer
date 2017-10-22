import java.util.ArrayList;

public class MainActivity {
    static final String CMD_DIA = "powershell.exe C:\\Users\\Florian\\IdeaProjects\\Audioanalyzer\\pyAudioAnalysis\\diarizationScript.ps1";
    static final String CMD_SEG= "powershell.exe C:\\Users\\Florian\\IdeaProjects\\Audioanalyzer\\pyAudioAnalysis\\segmentationScript.ps1";

    public static void main(String [ ] args)
    {
        PythonBridge bridge = new PythonBridge();

        ArrayList<String> commandLineInput = bridge.executePython(CMD_SEG);
       // DiarizationInterpreter d = new DiarizationInterpreter();
        System.out.println(commandLineInput);
    }
}

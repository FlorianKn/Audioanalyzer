import java.util.ArrayList;

public class MainActivity {
    static final String CMD_DIA = "powershell.exe C:\\Users\\Florian\\IdeaProjects\\Audioanalyzer\\pyAudioAnalysis\\diarizationScript.ps1";

    public static void main(String [ ] args)
    {

        PythonBridge bridge = new PythonBridge();

        ArrayList<String> commandLineInput = bridge.executePython(CMD_DIA);
        DiarizationInterpreter d = new DiarizationInterpreter();

        d.setSegmentStart(commandLineInput);
        d.setSegmentEnd(commandLineInput);

    }
}

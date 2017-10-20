import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PythonBridge {

    ArrayList<String> executePython(String cmd) {
        ArrayList<String> commandLineInput = new ArrayList<>();

        try {
            String line;
            Process powerShellProcess = Runtime.getRuntime().exec(cmd);

            BufferedReader input = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
            while ((line = input.readLine()) != null) {
                commandLineInput.add(line);
                powerShellProcess.destroy();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return commandLineInput;
    }
}

import org.json.simple.JSONObject;

import javax.swing.*;
import java.util.ArrayList;

public class DiarizationInterpreter extends Interpreter {
    private ArrayList<Double> segmentEnd = new ArrayList<>();

    public DiarizationInterpreter(String path) {
        JSONObject diarizationObject;
        JSONObject jsonObject;

        jsonObject = readJsonFile(path);
        diarizationObject = (JSONObject) jsonObject.get("Diarization");

        this.duration = (long) diarizationObject.get("duration");
        this.segmentStart = (ArrayList<Double>) diarizationObject.get("segmentStart");
        this.label = (ArrayList<String>) diarizationObject.get("label");
        this.segmentEnd = (ArrayList<Double>) diarizationObject.get("segmentEnd");
    }

    public ArrayList<Double> getSegmentEnd() {
        return segmentEnd;
    }

    protected void createChart(DiarizationInterpreter interpreter) {
        DiarizationChart chart = new DiarizationChart("Diarization", interpreter);
        chart.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

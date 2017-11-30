import org.json.simple.JSONObject;

import java.util.ArrayList;

public class DiarizationInterpreter extends Interpreter {
    private ArrayList<String> segmentEnd = new ArrayList<>();

    public DiarizationInterpreter(String path) {
        JSONObject diarizationObject;
        JSONObject jsonObject;

        jsonObject = readJsonFile(path);
        diarizationObject = (JSONObject) jsonObject.get("Diarization");

        this.duration = (long) diarizationObject.get("duration");
        this.segmentStart = (ArrayList<String>) diarizationObject.get("segmentStart");
        this.label = (ArrayList<String>) diarizationObject.get("label");
        this.segmentEnd = (ArrayList<String>) diarizationObject.get("segmentEnd");
    }

    public ArrayList<String> getSegmentEnd() {
        return segmentEnd;
    }

    @Override
    void createChart() {

    }

}

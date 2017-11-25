import org.json.simple.JSONObject;

import java.util.ArrayList;

public class SegmentationInterpreter extends Interpreter {
    private double speech;
    private double music;

    public SegmentationInterpreter(String path) {
        JSONObject segmentationObject;
        JSONObject jsonObject;

        jsonObject = readJsonFile(path);
        segmentationObject = (JSONObject) jsonObject.get("Segmentation");

        this.duration = (long) segmentationObject.get("duration");
        this.segmentStart = (ArrayList<String>) segmentationObject.get("segments");
        this.label = (ArrayList<String>) segmentationObject.get("label");
        this.speech = (double) segmentationObject.get("speech");
        this.music = (double) segmentationObject.get("music");
    }

    public double getSpeech() {
        return speech;
    }

    public double getMusic() {
        return music;
    }

    @Override
    void createChart() {

    }
}

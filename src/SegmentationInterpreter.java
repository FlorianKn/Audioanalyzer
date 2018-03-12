import org.json.simple.JSONObject;

import javax.swing.*;
import java.util.ArrayList;

public class SegmentationInterpreter extends Interpreter {
    private double speech;
    private double music;

    public SegmentationInterpreter(String path) {
        JSONObject segmentationObject;
        JSONObject jsonObject;
        JSONObject silenceObj;

        jsonObject = readJsonFile(path);
        segmentationObject = (JSONObject) jsonObject.get("Segmentation");
        silenceObj = (JSONObject) segmentationObject.get("silence");

        this.duration = (double) segmentationObject.get("duration");
        this.segmentStart = (ArrayList<Double>) segmentationObject.get("segments");
        this.label = (ArrayList<String>) segmentationObject.get("label");
        this.speech = (double) segmentationObject.get("speech");
        this.music = (double) segmentationObject.get("music");
        this.silenceStart = (ArrayList<Long>) silenceObj.get("silenceStart");
        this.silenceEnd = (ArrayList<Long>) silenceObj.get("silenceEnd");
    }

    public double getSpeech() {
        return speech;
    }

    public double getMusic() {
        return music;
    }

    protected void createChart(SegmentationInterpreter interpreter) {
        SegmentationChart chart = new SegmentationChart("Segmentation", interpreter);
        chart.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

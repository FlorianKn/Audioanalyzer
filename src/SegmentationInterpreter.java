import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
    protected void createChart(Interpreter interpreter) {
        Chart r = new Chart();
        JFrame frame = new JFrame("MyFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(r);
        frame.setSize(360, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

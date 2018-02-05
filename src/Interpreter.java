import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Interpreter {

    protected double duration;
    protected ArrayList<Double> segmentStart;
    protected ArrayList<String> label;

    public double getDuration() {
        return duration;
    }

    public ArrayList<Double> getSegmentStart() {
        return segmentStart;
    }

    public ArrayList<String> getLabel() {
        return label;
    }

    JSONObject readJsonFile(String path) {
        JSONParser parser = new JSONParser();
        Object obj = null;

        try {
            obj = parser.parse(new FileReader(path));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = (JSONObject) obj;

        return  jsonObject;
    }
}

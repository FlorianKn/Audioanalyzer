import java.util.ArrayList;

public abstract class Interpreter {
    private int duration;
    private ArrayList<String> segmentLabels = new ArrayList<>();

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public ArrayList<String> getSegmentLabels() {
        return segmentLabels;
    }

    public ArrayList<String> setSegmentLabels(ArrayList<String> commandLineInput) {
        int index = 0;

        // Get index of string IdentLAB
        for (int i = 0; i < commandLineInput.size(); i++) {
            if (commandLineInput.get(i).contains("IdentLAB")) {
                index = i + 1;
            }
        }
        // Add speaker to list
        for (int i = index; i < commandLineInput.size(); i++) {
            segmentLabels.add(commandLineInput.get(i));
        }
        return segmentLabels;
    }

    abstract void createChart();
}

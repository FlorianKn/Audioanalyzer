import java.util.ArrayList;

public class DiarizationInterpreter extends Interpreter {
    private ArrayList<String> segmentStart = new ArrayList<>();
    private ArrayList<String> segmentEnd = new ArrayList<>();

    public ArrayList<String> getSegmentStart() {
        return segmentStart;
    }

    public ArrayList<String> getSegmentEnd() {
        return segmentEnd;
    }

    public void setSegmentStart(ArrayList<String> segmentStart) {
        this.segmentStart = getPartOfList("IdentSTART","IdentEND",segmentStart);
    }
    public void setSegmentEnd(ArrayList<String> segmentEnd) {
        this.segmentEnd = getPartOfList("IdentEND","IdentLAB",segmentEnd);
    }

    @Override
    void createChart() {

    }

}

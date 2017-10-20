import java.util.ArrayList;

public class DiarizationInterpreter extends Interpreter {
    private ArrayList<String> segmentStart = new ArrayList<>();
    private ArrayList<String> segmentEnd = new ArrayList<>();

    //get part of list specified by a start- and end string
    private ArrayList<String> getPartOfList(String start, String end,  ArrayList<String> input) {
        ArrayList<String> list = new ArrayList<>();
        int startIndex = 0, endIndex  = 0;

        for(int i = 0; i < input.size(); i++) {
            if(input.get(i).contains(start)) {
                startIndex = i + 1;
            }
            else if(input.get(i).contains(end)) {
                endIndex = i;
            }
        }
        for(int i = startIndex; i < endIndex; i++) {
            list.add(input.get(i));
        }
        return  list;
    }

    public ArrayList<String> getSegmentStart() {
        return segmentStart;
    }

    public ArrayList<String> getSegmentEnd() {
        return segmentEnd;
    }

    public void setSegmentStart(ArrayList<String> segmentStart) {
        this.segmentStart = getPartOfList("IdentSTART","IdentEND",segmentStart);
    }
    public void setSegmentEnd(ArrayList<String> segmentStart) {
        this.segmentEnd = getPartOfList("IdentEND","IdentLAB",segmentStart);
    }

    @Override
    void createChart() {

    }

}

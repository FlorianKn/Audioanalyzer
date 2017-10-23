import java.util.ArrayList;

public abstract class Interpreter {
    private int duration;
    private ArrayList<String> labels = new ArrayList<>();

    public int getDuration() {
        return duration;
    }

    public void setDuration(ArrayList<String> segmentDuration) {
        ArrayList<String> durationStr;

        durationStr =  getPartOfList("IdentDUR","IdentSTART",segmentDuration);
        if(durationStr.size() != 0) {
            this.duration = Integer.parseInt(durationStr.get(0));
        }
    }

    public ArrayList<String> getLabels() {
        return labels;
    }

    public void setLabels(ArrayList<String> segmentLabels) {
        this.labels = getPartOfList("IdentLAB", "IdentMUSIC", segmentLabels);
    }

    //get part of list specified by a start- and end string
    protected ArrayList<String> getPartOfList(String start, String end,  ArrayList<String> input) {
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

    abstract void createChart();
}

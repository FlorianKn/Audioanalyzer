import java.util.ArrayList;

public class SegmentationInterpreter extends Interpreter {
    private ArrayList<String> segment = new ArrayList<>();
    private float speech;
    private float music;

    public ArrayList<String> getSegment() {
        return segment;
    }

    public float getSpeech() {
        return speech;
    }

    public float getMusic() {
        return music;
    }

    public void setSegment(ArrayList<String> segment) {
        this.segment = getPartOfList("IdentSTART", "IdentLAB", segment);
    }

    public void setSpeech(float speech) {
        this.speech = speech;
    }

    public void setMusic(float music) {
        this.music = music;
    }

    @Override
    void createChart() {

    }
}

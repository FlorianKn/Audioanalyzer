import java.util.ArrayList;

public class SegmentationInterpreter extends Interpreter {
    private ArrayList<String> segment = new ArrayList<>();
    private double speech;
    private double music;

    public ArrayList<String> getSegment() {
        return segment;
    }

    public double getSpeech() {
        return speech;
    }

    public double getMusic() {
        return music;
    }

    public void setSegment(ArrayList<String> segment) {
        this.segment = getPartOfList("IdentSTART", "IdentLAB", segment);
    }

    //speech in percentage
    public void setSpeech(ArrayList<String> speechPercentage) {
        ArrayList<String> speechStr;

        speechStr =  getPartOfList("IdentSPEECH","IdentSEND", speechPercentage);
        if(speechStr.size() != 0) {
            // first and last char are [ and ], can't convert to double
            String s = speechStr.get(0).substring(1, speechStr.get(0).length()-1);
            this.speech = Double.parseDouble(s);

        }
    }

    //music in percentage
    public void setMusic(ArrayList<String> musicPercentage) {
        ArrayList<String> musicStr;

        musicStr =  getPartOfList("IdentSEND","IdentMEND", musicPercentage);
        if(musicStr.size() != 0) {
            String s = musicStr.get(0).substring(1, musicStr.get(0).length()-1);
            this.music = Double.parseDouble(s);
        }
    }

    @Override
    void createChart() {

    }
}

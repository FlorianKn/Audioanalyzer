
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;


public class WavPlayer {

    public static int nBytesRead = 0;
    public static synchronized void playSound(final String filename) {

        new Thread(new Runnable() {
            private File soundFile;
            private final int BUFFER_SIZE = 128000;
            private AudioInputStream audioStream;


            private AudioFormat audioFormat;
            private SourceDataLine sourceLine;
            // The wrapper thread is unnecessary, unless it blocks on the
            // Clip finishing; see comments.
            public void run() {
                String strFilename = filename;
                nBytesRead = 0;

                try {
                    soundFile = new File(strFilename);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }

                try {
                    audioStream = AudioSystem.getAudioInputStream(soundFile);
                } catch (Exception e){
                    e.printStackTrace();
                    System.exit(1);
                }

                audioFormat = audioStream.getFormat();

                DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
                try {
                    sourceLine = (SourceDataLine) AudioSystem.getLine(info);
                    sourceLine.open(audioFormat);
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                    System.exit(1);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }

                sourceLine.start();



                byte[] abData = new byte[BUFFER_SIZE];
                while (nBytesRead != -1) {
                    try {
                        nBytesRead = audioStream.read(abData, 0, abData.length);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (nBytesRead >= 0) {
                        @SuppressWarnings("unused")
                        int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
                    }
                }

                sourceLine.
                        drain();
                sourceLine.close();
            }


        }).start();
    }

    public void stopPlayer(){
        nBytesRead = -1;
    }
}

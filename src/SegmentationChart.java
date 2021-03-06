import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import javax.swing.*;
import java.awt.*;

public class SegmentationChart extends ApplicationFrame {

    public SegmentationChart(String title, SegmentationInterpreter interpreter) {
        super(title);

        final XYSeries series = new XYSeries("Speech(1) Music (2)");

        final XYSeries silenceSeries = new XYSeries("Silence (3)");
        double startValue = 0;

        for(int i = 0; i < interpreter.label.size(); i++) {
            String label = interpreter.getLabel().get(i);
            double currentValue = interpreter.getSegmentStart().get(i);

            if (label.contains("music")) {

                series.add(startValue, 2);
                series.add(currentValue, 2);
                startValue = currentValue;
            } else {
                series.add(startValue, 1);
                series.add(currentValue, 1);
                startValue = currentValue;
            }
        }

        int silenceFirstValue = 0;
        silenceSeries.add(silenceFirstValue, 0);

        for(int i = 0; i < interpreter.silenceStart.size(); i++) {
            long silenceStartValue = interpreter.getSilenceStart().get(i);
            long silenceEndValue = interpreter.getSilenceEnd().get(i);

                silenceSeries.add(silenceStartValue, 0);
                silenceSeries.add(silenceStartValue, 2.5);
                silenceSeries.add(silenceEndValue, 2.5);
                silenceSeries.add(silenceEndValue, 0);

        }

        final XYSeriesCollection data = new XYSeriesCollection(series);
        data.addSeries(silenceSeries);

        final JFreeChart chart = ChartFactory.createXYLineChart(
                "Audiosegmentation",
                "Seconds",
                "Music/Speech/Silence",
                data,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
         ChartPanel chartPanel = new ChartPanel(chart);

        JFrame chartFrame = new JFrame("Audiosegmentation");
        chartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        chartFrame.setLayout(new BorderLayout(0, 5));
        chartFrame.add(chartPanel, BorderLayout.CENTER);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        chartFrame.add(panel, BorderLayout.SOUTH);

        chartFrame.pack();
        chartFrame.setLocationRelativeTo(null);
        chartFrame.setVisible(true);

        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
        chartFrame.add(chartPanel);
        chartFrame.pack();
        chartFrame.setVisible(true);
    }
}
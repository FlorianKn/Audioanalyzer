import org.jfree.chart.*;
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DiarizationChart extends ApplicationFrame {

    private ArrayList<String> keyList = new ArrayList<>();

    public DiarizationChart(String title, DiarizationInterpreter interpreter) {
        super(title);
        final CategoryDataset dataset = createDataset(interpreter);
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        setContentPane(chartPanel);

        JFrame chartFrame = new JFrame("Audiodiarization");
        chartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        chartFrame.setLayout(new BorderLayout(0, 5));
        chartFrame.add(chartPanel, BorderLayout.CENTER);


        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        chartFrame.add(panel, BorderLayout.SOUTH);

        chartFrame.pack();
        chartFrame.setLocationRelativeTo(null);
        chartFrame.setVisible(true);

        chartPanel.setPreferredSize(new java.awt.Dimension(750, 150));
        setContentPane(chartPanel);
        chartFrame.add(chartPanel);
        chartFrame.pack();
        chartFrame.setVisible(true);
    }
    private DefaultCategoryDataset createDataset(DiarizationInterpreter interpreter) {
        DefaultCategoryDataset result = new DefaultCategoryDataset();

        for(int i = 0; i < interpreter.getLabel().size(); i++) {
            String label = interpreter.getLabel().get(i) + i;
            if(i == 0) {
                result.addValue(interpreter.getSegmentEnd().get(i), label, "Diarization");
                keyList.add(label);
            } else {
                result.addValue(interpreter.getSegmentEnd().get(i) - interpreter.getSegmentEnd().get(i-1), label, "Diarization");
                keyList.add(label);
            }
        }
        return result;
    }


    private JFreeChart createChart(final CategoryDataset dataset) {

        final JFreeChart chart = ChartFactory.createStackedBarChart(
                "Audiodiarization",  // chart title
                "Category",                  // domain axis label
                "Seconds",                     // range axis label
                dataset,                     // data
                PlotOrientation.HORIZONTAL,    // the plot orientation
                true,                        // legend
                true,                        // tooltips
                false                        // urls
        );

        GroupedStackedBarRenderer renderer = new GroupedStackedBarRenderer();
        KeyToGroupMap map = new KeyToGroupMap("G1");

        for(int i = 0; i < keyList.size(); i++) {
            map.mapKeyToGroup(keyList.get(i), "G1");
        }

        renderer.setSeriesToGroupMap(map);
        renderer.setItemMargin(0.0);

        Paint p1 = new GradientPaint(
                0.0f, 0.0f, new Color(0x22, 0x22, 0xFF), 0.0f, 0.0f, new Color(0x88, 0x88, 0xFF)
        );

        Paint p2 = new GradientPaint(
                0.0f, 0.0f, new Color(0x22, 0xFF, 0x22), 0.0f, 0.0f, new Color(0x88, 0xFF, 0x88)
        );

        Paint p3 = new GradientPaint(
                0.0f, 0.0f, new Color(0xFF, 0x22, 0x22), 0.0f, 0.0f, new Color(0xFF, 0x88, 0x88)
        );

        Paint p4 = new GradientPaint(
                0.0f, 0.0f, new Color(0xFF, 0xFF, 0x22), 0.0f, 0.0f, new Color(0xFF, 0xFF, 0x88)
        );

        renderer.setGradientPaintTransformer(
                new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL)
        );
        for(int i = 0; i < keyList.size(); i++) {

            if(keyList.get(i).contains("speakerA")){
                renderer.setSeriesPaint(i, p1);
            } else if (keyList.get(i).contains("speakerB")) {
                renderer.setSeriesPaint(i, p2);
            } else if (keyList.get(i).contains("speakerC")) {
                renderer.setSeriesPaint(i, p3);
            } else if (keyList.get(i).contains("speakerD")) {
                renderer.setSeriesPaint(i, p4);
            } else {
                System.out.println("Speaker not detected");
            }
        }

        SubCategoryAxis domainAxis = new SubCategoryAxis("");
        domainAxis.setCategoryMargin(0.05);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setDomainAxis(domainAxis);
        plot.setRenderer(renderer);
        plot.setFixedLegendItems(createLegendItems());

        return chart;
    }
    private LegendItemCollection createLegendItems() {
        LegendItemCollection result = new LegendItemCollection();

        LegendItem item1 = new LegendItem("Speaker A", new Color(0x22, 0x22, 0xFF));
        LegendItem item2 = new LegendItem("Speaker B", new Color(0x22, 0xFF, 0x22));
        LegendItem item3 = new LegendItem("Speaker C", new Color(0xFF, 0x22, 0x22));
        LegendItem item4 = new LegendItem("Speaker D", new Color(0xFF, 0xFF, 0x22));

        result.add(item1);
        result.add(item2);
        result.add(item3);
        result.add(item4);

        return result;
    }
}

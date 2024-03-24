import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;


public class Graphics {
    static Solutions solutions = new Solutions();
    public static void graphicSol1Func1(int n) {
        XYDataset dataset = createDatasetFunc1(n);
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        JFrame frame = new JFrame("title");
        frame.add(chartPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void graphicSol1Func2(int n) {
        XYDataset dataset = createDatasetFunc2(n);
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        JFrame frame = new JFrame("title");
        frame.add(chartPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static XYDataset createDatasetFunc1(int n) {
        var defaultSeries = new XYSeries("Sin(5x - 3)");
        for (double x = Functions.start; x <= Functions.end; x += 0.01) {
            defaultSeries.add(x, Functions.function1(x));
        }

        var newtonSeries = new XYSeries("Newton series");
        for (double x = Functions.start; x <= Functions.end; x += 0.01) {
            newtonSeries.add(x, solutions.solution1Func1(x, n));
        }

        var dataset = new XYSeriesCollection();
        dataset.addSeries(defaultSeries);
        dataset.addSeries(newtonSeries);

        return dataset;
    }

    private static XYDataset createDatasetFunc2(int n) {
        var defaultSeries = new XYSeries("Abs(3x - 1)");
        for (double x = Functions.start; x <= Functions.end; x += 0.01) {
            defaultSeries.add(x, Functions.function2(x));
        }

        var newtonSeries = new XYSeries("Newton series");
        for (double x = Functions.start; x <= Functions.end; x += 0.01) {
            newtonSeries.add(x, solutions.solution1Func2(x, n));
        }

        var dataset = new XYSeriesCollection();
        dataset.addSeries(defaultSeries);
        dataset.addSeries(newtonSeries);

        return dataset;
    }

    private static JFreeChart createChart(final XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Newton",
                "x",
                "y",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("Newton",
                        new Font("Serif", Font.BOLD, 18)
                )
        );

        return chart;
    }
}

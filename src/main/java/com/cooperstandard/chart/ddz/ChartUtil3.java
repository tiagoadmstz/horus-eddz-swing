package com.cooperstandard.chart.ddz;

import com.cooperstandard.util.CustomXYItemLabelGenerator;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYDifferenceRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/**
 *
 * @author rsouza10
 */
public class ChartUtil3 {

    public ChartPanel createXYChart(List<DdzDataChart> ddzDataList, Integer lowMeta, Integer halfMeta, Integer[] hightMeta, String desc, float meta) {
        ddzDataList = (List<DdzDataChart>) ddzDataList.stream()
                .sorted(Comparator.comparing(DdzDataChart::getMinute))
                .collect(Collectors.toList());

        TimeSeries[] series = {new TimeSeries("Scrap"), new TimeSeries("Meta " + meta + " %")};
        for (int i = 0; i < 2; i++) {
            for (int d = 0; d < ddzDataList.size(); d++) {
                if (i == 0) {
                    series[i].add(ddzDataList.get(d).getMinute(), ddzDataList.get(d).getValue());
                } else {
                    series[i].add(ddzDataList.get(d).getMinute(), d == 0 ? hightMeta[0] : hightMeta[1]);
                }
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        for (TimeSeries timeSeries : series) {
            dataset.addSeries(timeSeries);
        }

        JFreeChart timechart = ChartFactory.createTimeSeriesChart(
                "",
                "Tempo", "Metros",
                dataset, true, false, false);

        XYPlot plot = (XYPlot) timechart.getPlot();
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesPaint(0, Color.blue);
        renderer.setSeriesPaint(1, Color.red);
        plot.setDomainGridlinesVisible(false);
        renderer.setSeriesShape(0, new Ellipse2D.Double(-3d, -3d, 6d, 6d));

        ValueAxis axis = plot.getRangeAxis();
        axis.setLowerBound(-30.0);
        ValueAxis yAxis = plot.getRangeAxis();
        double upperBound = yAxis.getUpperBound();
        yAxis.setUpperBound(upperBound + upperBound * 0.1);

        renderer.setSeriesItemLabelsVisible(0, true);
        renderer.setSeriesItemLabelPaint(0, Color.BLACK);
        renderer.setSeriesItemLabelFont(0, new Font("Arial", Font.BOLD, 9));
        renderer.setSeriesItemLabelGenerator(0, new StandardXYItemLabelGenerator());
        renderer.setSeriesShapesVisible(0, true);
        plot.setRenderer(renderer);
        renderer.setSeriesItemLabelGenerator(0, new CustomXYItemLabelGenerator());

        plot.setRangeGridlinesVisible(true);
        plot.setDomainGridlinesVisible(false);

        return new ChartPanel(timechart);
    }
}

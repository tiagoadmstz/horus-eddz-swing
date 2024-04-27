package com.cooperstandard.chart.ddz;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/**
 *
 * @author rsouza10
 */
public class ChartUtil4 {

    public ChartPanel createXYChart(List<DdzDataChart> ddzDataList, Integer lowMeta, Integer halfMeta, Integer[] hightMeta, String desc) {
        //organiza a lista por horario
        ddzDataList = ddzDataList.stream().sorted(Comparator.comparing(ddz -> ddz.getHour().getHour())).collect(Collectors.toList());
        //cria array de series
        TimeSeries[] series = {new TimeSeries("DDZ"), new TimeSeries("Vermelho 5%"), new TimeSeries("Amarelo 3%"), new TimeSeries("Verde 2%")};
        //adiciona dados de DDZ e metas
        for (int i = 0; i < 4; i++) {
            for (int d = 0; d < ddzDataList.size(); d++) {
                if (i == 0) {
                    series[i].add(ddzDataList.get(d).getHour(), ddzDataList.get(d).getValue());
                } else {
                    if (i == 1) {
                        if (d == 0) {
                            series[i].add(ddzDataList.get(d).getHour(), hightMeta[0]);
                        } else {
                            series[i].add(ddzDataList.get(d).getHour(), hightMeta[1]);
                        }
                    } else {
                        series[i].add(ddzDataList.get(d).getHour(), i == 2 ? halfMeta : lowMeta);
                    }
                }
            }
        }
        //adiciona series ao dataset do gráfico
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        for (TimeSeries timeSeries : series) {
            dataset.addSeries(timeSeries);
        }
        //cria o gráfico
        JFreeChart timechart = ChartFactory.createTimeSeriesChart(
                desc,
                "Tempo", "Reais",
                dataset, true, false, false);
        //cria shapes
        XYPlot plot = (XYPlot) timechart.getPlot();
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setSeriesShapesVisible(0, true);
        //cria o painel do gráfico
        return new ChartPanel(timechart);
    }
}

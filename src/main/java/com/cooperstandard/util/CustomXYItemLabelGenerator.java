package com.cooperstandard.util;

import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author rsouza10
 */
public class CustomXYItemLabelGenerator extends StandardXYItemLabelGenerator {

    @Override
    public String generateLabel(XYDataset dataset, int series, int item) {
        double value = dataset.getYValue(series, item);
        return value == 0 ? "" : value + "m";
    }
}

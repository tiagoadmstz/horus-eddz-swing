package com.cooperstandard.swing.progress;

import javax.swing.JProgressBar;

public class Progress extends JProgressBar {

    private final ProgressCircleUI ui;

    public Progress() {
        setOpaque(false);
        setStringPainted(true);
        ui = new ProgressCircleUI();
        setUI(ui);
    }

    public float getFloatValue() {
        return (float) getValue();
    }

    public void setFloatValue(float value) {
        int intValue = (int) (value * 100);
        setValue(intValue);
    }

    @Override
    public String getString() {
        float floatValue = getFloatValue() / 100.0f;
        return String.format("%.2f%%", floatValue);
    }

    public void start() {
        ui.start();
    }
}

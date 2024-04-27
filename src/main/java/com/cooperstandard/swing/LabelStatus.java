package com.cooperstandard.swing;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class LabelStatus extends JLabel {

    public LabelStatus() {
        setForeground(Color.WHITE);
        setBorder(new EmptyBorder(2, 10, 2, 10));
        setHorizontalAlignment(JLabel.CENTER);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        switch (getText()) {
            case "Reprovado":
                g2.setColor(new Color(240, 81, 81));
                break;
            case "Aprovado":
                g2.setColor(new Color(59, 211, 160));
                break;
            case "Em andamento":
                g2.setColor(new Color(253, 187, 65));
                break;
            case "Aguardando":
                g2.setColor(Color.DARK_GRAY);
                break;
            case "Referência":
                g2.setColor(Color.BLUE);
                break;
            default:
                g2.setColor(new Color(253, 187, 65));
                break;
        }
        int x[] = {5, getWidth(), getWidth() - 5, 0};
        int y[] = {0, 0, getHeight(), getHeight()};
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f));
        g2.fillPolygon(x, y, x.length);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        super.paintComponent(grphcs);
    }
}

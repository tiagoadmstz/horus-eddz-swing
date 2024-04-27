package com.cooperstandard.util;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author rsouza10
 */
public class CustomRenderer extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 6703872492730589499L;

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        this.setHorizontalAlignment(0);
        if (table.getValueAt(row, 16).equals("Não")) {
            cellComponent.setBackground(new Color(153, 153, 153));
        } else if (table.getValueAt(row, 16).equals("Sim")) {
            cellComponent.setBackground(Color.WHITE);
            cellComponent.setForeground(Color.BLACK);
        }
        return cellComponent;
    }
}

package com.cooperstandard.util;

/**
 *
 * @author rsouza10
 */
import java.awt.Component;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        this.setHorizontalAlignment(0);
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (row % 2 == 0) {
            cell.setForeground(Color.BLACK);
            cell.setBackground(Color.WHITE);
        } else {
            cell.setForeground(Color.BLACK);
            cell.setBackground(Color.WHITE);
        }
        if (isSelected) {
            cell.setForeground(Color.WHITE);
            cell.setBackground(new Color(28, 134, 238));
        }
        if (value instanceof String) {
            String valor = (String) value;
            if (valor.equalsIgnoreCase("Reprovado")) {
//                cell.setBackground(new Color(252, 119, 119));
                cell.setBackground(Color.red);
                cell.setForeground(Color.WHITE);
            }
            if (valor.equalsIgnoreCase("Aprovado") || valor.equalsIgnoreCase("Referência")) {
                cell.setBackground(new Color(58, 197, 105));
//                cell.setBackground(new Color(12,182,69));
                cell.setForeground(Color.BLACK);
            }
        }
        return cell;
    }
}

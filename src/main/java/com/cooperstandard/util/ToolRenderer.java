package com.cooperstandard.util;

import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author rsouza10
 */
public class ToolRenderer {

    JTable table = new JTable() {
        @Override
        public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
            Component c = super.prepareRenderer(renderer, row, column);
            if (c instanceof JComponent) {
                JComponent jc = (JComponent) c;
                jc.setToolTipText(getValueAt(row, column).toString());
            }
            return c;
        }
    };
}

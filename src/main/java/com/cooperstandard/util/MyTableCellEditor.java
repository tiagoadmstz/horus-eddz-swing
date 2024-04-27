package com.cooperstandard.util;

/**
 *
 * @author rafael
 */

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

public class MyTableCellEditor extends AbstractCellEditor
        implements TableCellEditor {

    private static final long serialVersionUID = -2157435614692421895L;

    JComponent component = new JTextField();

    @Override
    public boolean stopCellEditing() {
        String s = (String) getCellEditorValue();
        boolean valido = true;
        for (int i = 0; i < s.length(); i++) {
            Character caractere = s.charAt(i);
            if (!Character.isDigit(caractere)) {
                if (!caractere.equals('.')&&!caractere.equals('O')&&!caractere.equals('K')&&!caractere.equals('k')&&!caractere.equals('o')) {
                    valido = false;
                    break;
                }
            }
        }
        if (!valido) {
            JOptionPane.showMessageDialog(null,"Utilize apenas valores numericos e/ou 'OK','.'!");
            return false;
        }
        return super.stopCellEditing();
    }

    @Override
    public Component getTableCellEditorComponent(
            JTable table, Object value,
            boolean isSelected, int rowIndex, int vColIndex) {
        if (isSelected) {
            //
        }
        ((JTextField) component).setText((String) value);
        return component;
    }

    @Override
    public Object getCellEditorValue() {
        return ((JTextField) component).getText();
    }
}

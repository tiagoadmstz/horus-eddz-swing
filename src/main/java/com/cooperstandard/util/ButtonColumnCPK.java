package com.cooperstandard.util;

import com.cooperstandard.dbs.ConexaoSql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author rsouza10
 */
public final class ButtonColumnCPK extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {

    private static final long serialVersionUID = 8724628590546560402L;

    private final JTable table;
    private final JButton button;
    private final DefaultTableModel model;

    public ButtonColumnCPK(JTable table, int column) {
        super();
        this.table = table;
        this.model = (DefaultTableModel) table.getModel();
        button = new JButton();
        initComponents(column);
    }

    private void initComponents(int column) {
        button.setFocusPainted(false);
        button.addActionListener(this);
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(column).setCellRenderer(this);
        columnModel.getColumn(column).setCellEditor(this);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        button.setText("X");
        button.setForeground(new java.awt.Color(255, 51, 51));
        button.setSize(50, 50);
        return button;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return button.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
        int p = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar essa ficha?", "Deletar", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            try {
                int row = table.getSelectedRow();
                final String sql = "DELETE FROM Cad_Espec_Teste WHERE ESP_MATERIAL='" + table.getModel().getValueAt(row, 2) + "'";
                final ConexaoSql conexaoSql = new ConexaoSql();
                conexaoSql.executarUpdateDeleteSQL(sql);
                conexaoSql.fecharConexao();
                model.removeRow(row);
                model.fireTableRowsDeleted(row, row);
                JOptionPane.showMessageDialog(table, "Deletada com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(table, ex);
            }
        }
    }
}

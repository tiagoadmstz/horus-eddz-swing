package com.cooperstandard.util;

import com.cooperstandard.controller.extrusao.ControllerDDZ;
import com.cooperstandard.model.ModelDDZ;
import com.cooperstandard.views.extrusao.View_Data;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author rsouza10
 */
public final class ButtonColumnAvaliacao extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {

    ModelDDZ modelddz = new ModelDDZ();
    ControllerDDZ controllerddz = new ControllerDDZ();
    ArrayList<ModelDDZ> listaModelddz = new ArrayList<>();

    private static final long serialVersionUID = 8724628590546560402L;

    private final JTable table;
    private final JButton button;
    private final DefaultTableModel model;

    public ButtonColumnAvaliacao(JTable table, int column) {
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
        button.setText("Visualizar");
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
        int linhasselecionada = table.getSelectedRow();
        int id = Integer.parseInt(table.getModel().getValueAt(linhasselecionada, 0).toString());
        new View_Data(id).setVisible(true);
    }

}

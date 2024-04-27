package com.cooperstandard.util;

import com.cooperstandard.views.extrusao.ViewEntradaDadosDDZ;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
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
public final class ButtonColumnDdz extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {

    private ViewEntradaDadosDDZ ddzFrame;
    private static final long serialVersionUID = 8724628590546560402L;
    private final JTable table;
    private final JButton button;
    private final DefaultTableModel model;
    String bpcs;

    public ButtonColumnDdz(JTable table, int column, ViewEntradaDadosDDZ ddzFrame) {
        super();
        this.table = table;
        this.model = (DefaultTableModel) table.getModel();
        button = new JButton();
        initComponents(column);
        this.ddzFrame = ddzFrame;
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
        try {
//            button.setText("Deletar");
            Image img = ImageIO.read(getClass().getResource("/images/trash.png"));
            button.setIcon(new ImageIcon(img));
            button.setForeground(new java.awt.Color(255, 51, 51));
            button.setSize(50, 50);

        } catch (IOException ex) {
            Logger.getLogger(ButtonColumnDdz.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        ddzFrame.buttonjtable();
        Thread t = new Thread() {
            public void run() {

            }
        };
        t.start();
    }
}

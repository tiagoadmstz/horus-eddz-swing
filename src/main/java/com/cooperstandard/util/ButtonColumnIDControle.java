package com.cooperstandard.util;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author rsouza10
 */
public final class ButtonColumnIDControle extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {

    private static final long serialVersionUID = 8724628590546560402L;

    private final JTable table;
    private final JButton button;
    private final DefaultTableModel model;
    String bpcs;

    public ButtonColumnIDControle(JTable table, int column) {
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
        button.setText("Deletar");
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
        String id = table.getModel().getValueAt(linhasselecionada, 0).toString();
        int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja"
                + " excluir o registro \nNº: "
                + id + " ?", "Atenção", JOptionPane.YES_OPTION);
        if (opcao == JOptionPane.OK_OPTION) {
            deletaddz(id);
            deletaid(id);
        }
    }

    public void deletaid(String id) {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Delete from DDZ_Controle where ID= ? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deletaddz(String id) {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Delete from DDZ where ID_CONTROLE= ? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

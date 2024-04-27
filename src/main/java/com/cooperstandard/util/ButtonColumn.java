package com.cooperstandard.util;

import com.cooperstandard.views.principal.AguardeGerandoRelatório;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author rsouza10
 */
public final class ButtonColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {

    private static final long serialVersionUID = 8724628590546560402L;

    private final JTable table;
    private final JButton button;
    private final DefaultTableModel model;

    public ButtonColumn(JTable table, int column) {
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
        final AguardeGerandoRelatório carregando = new AguardeGerandoRelatório();
        carregando.setVisible(true);
        Thread t = new Thread() {
            public void run() {
                try {
                    int linhasselecionada = table.getSelectedRow();
                    String logo = "/images/logocooper.jpg";
                    
                    Connection con = new ConexaoSql().getCon();
                    Map p = new HashMap();
                    p.put("tipoteste", "Teste");
                    p.put("perfil", table.getModel().getValueAt(linhasselecionada, 0));
                    p.put("logo", this.getClass().getResourceAsStream(logo));
                    p.put("SUBREPORT_DIR", this.getClass().getResource("/Relatorios/"));
                    JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Relatorios/registroanaliseAcompanhamento.jasper"));
                    JasperPrint print = JasperFillManager.fillReport(jr, p, con);
                    JasperViewer view = new JasperViewer(print, false);
                    view.setTitle("Tela de Acompanhamento");

                    view.setVisible(true);
                } catch (Exception erro) {

                    JOptionPane.showMessageDialog(null, "deu erro =" + erro);
                    System.out.println(erro);

                }
                carregando.dispose();
            }
        };
        t.start();
    }
}

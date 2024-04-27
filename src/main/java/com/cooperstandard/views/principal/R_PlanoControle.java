package com.cooperstandard.views.principal;

import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author rsouza10
 */
public class R_PlanoControle extends javax.swing.JInternalFrame {

    /**
     * Creates new form R_FichaControle
     */
    public R_PlanoControle() {
        initComponents();

        // Combobox Linha
        this.cbLinha.removeAllItems();
        try {
            
            Connection con = new ConexaoSql().getCon();
            Statement Sent = con.createStatement();
            ResultSet rs = Sent.executeQuery("Select distinct ESP_LINHA from Qry_Result where SETOR='Extrusão' order by ESP_LINHA ASC");
            cbLinha.addItem("Selecione...");
            while (rs.next()) {
                this.cbLinha.addItem(rs.getString("ESP_LINHA"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void gerarelatorio() {
        if (cbLinha.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbLinha.requestFocusInWindow();
        } else {
            try {
                String logo = "/images/logocooper.jpg";
                String criticosegurança = "/images/CriticoSegurança.jpg";
                String estoqueprocesso = "/images/EstoqueProcesso.jpg";
                String fluxoprocesso = "/images/FluxoProcesso.jpg";
                String provaderro = "/images/ProvaErro.jpg";
                String segurancaoperador = "/images/SegurançaOperador.jpg";
                String critico = "/images/Critico.jpg";
                String segurancaobrigatorio = "/images/SequenciaObrigatoria.jpg";
                String inspecaoqualidade = "/images/InspeçãoQualidade.jpg";

                
                Connection con = new ConexaoSql().getCon();
                Map p = new HashMap();
                p.put("parameter1", cbLinha.getSelectedItem());
                p.put("logo", this.getClass().getResourceAsStream(logo));
                p.put("criticosegurança", this.getClass().getResourceAsStream(criticosegurança));
                p.put("estoqueprocesso", this.getClass().getResourceAsStream(estoqueprocesso));
                p.put("fluxoprocesso", this.getClass().getResourceAsStream(fluxoprocesso));
                p.put("provaderro", this.getClass().getResourceAsStream(provaderro));
                p.put("critico", this.getClass().getResourceAsStream(critico));
                p.put("segurancaoperador", this.getClass().getResourceAsStream(segurancaoperador));
                p.put("segurancaobrigatorio", this.getClass().getResourceAsStream(segurancaobrigatorio));
                p.put("inspecaoqualidade", this.getClass().getResourceAsStream(inspecaoqualidade));
                p.put("SUBREPORT_DIR", this.getClass().getResource("/Relatorios/"));
                JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Relatorios/planocontrole.jasper"));
                JasperPrint print = JasperFillManager.fillReport(jr, p, con);
                JasperViewer view = new JasperViewer(print, false);
                view.setTitle("Plano de Controle");
                view.setVisible(true);
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "deu erro =" + erro);
                System.out.println(erro);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        cbLinha = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-pesquisar-filled-50.png"))); // NOI18N
        jButton1.setText("Visualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbLinha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Linha:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        final AguardeGerandoRelatório carregando = new AguardeGerandoRelatório();
        carregando.setVisible(true);
        Thread t = new Thread() {
            public void run() {
                gerarelatorio();
                carregando.dispose();
            }
        };
        t.start();

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbLinha;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

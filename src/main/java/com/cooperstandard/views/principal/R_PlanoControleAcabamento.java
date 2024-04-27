package com.cooperstandard.views.principal;

import com.cooperstandard.model.ModelLinha;
import com.cooperstandard.controller.acabamento.ControllerLinhaAc;
import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author rsouza10
 */
public class R_PlanoControleAcabamento extends javax.swing.JInternalFrame {

    ArrayList<ModelLinha> listaModelLinha = new ArrayList<ModelLinha>();
    ControllerLinhaAc controllerLinhaAc = new ControllerLinhaAc();
    String titulo = "";

    public R_PlanoControleAcabamento() {
        initComponents();
        listarLinhaAc();
        limpageral();
        cbLinha.setSelectedIndex(-1);
        jLabel3.setVisible(false);
        cbMaterial1.setVisible(false);
        jCheckBox2.setVisible(false);
        jLabel4.setVisible(false);
        cbMaterial2.setVisible(false);
        jCheckBox3.setVisible(false);
        jLabel5.setVisible(false);
        cbMaterial3.setVisible(false);

    }

    public void gerarelatorio() {

        if (cbLinha.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbLinha.requestFocusInWindow();
        } else if (cbMaterial.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbMaterial.requestFocusInWindow();
        } else if (jCheckBox1.isSelected() && cbMaterial1.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbMaterial1.requestFocusInWindow();
        } else if (jCheckBox2.isSelected() && cbMaterial2.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbMaterial2.requestFocusInWindow();
        } else if (jCheckBox3.isSelected() && cbMaterial3.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbMaterial3.requestFocusInWindow();
        } else {

            if (jCheckBox1.isSelected() && jCheckBox2.isSelected() && jCheckBox3.isSelected()) {
                titulo = (cbMaterial.getSelectedItem().toString() + " / " + cbMaterial1.getSelectedItem().toString() + " / " + cbMaterial2.getSelectedItem().toString() + " / " + cbMaterial3.getSelectedItem().toString());
            } else if (jCheckBox1.isSelected() && jCheckBox2.isSelected()) {
                titulo = (cbMaterial.getSelectedItem().toString() + " / " + cbMaterial1.getSelectedItem().toString() + " / " + cbMaterial2.getSelectedItem().toString());
            } else if (jCheckBox1.isSelected()) {
                titulo = (cbMaterial.getSelectedItem().toString() + " / " + cbMaterial1.getSelectedItem().toString());
            } else {
                titulo = cbMaterial.getSelectedItem().toString();
            }
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
                p.put("parameter1", cbMaterial.getSelectedItem());
                p.put("titulo", titulo);
                p.put("linha", cbLinha.getSelectedItem());
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
                JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Relatorios/planocontroleAcabamento.jasper"));
                JasperPrint print = JasperFillManager.fillReport(jr, p, con);
                String nomeArquivo = ("C:\\Users\\".concat(System.getProperty("user.name")).concat("\\Desktop\\PlanoControle - " + cbMaterial.getSelectedItem() + ".pdf"));
                JasperExportManager.exportReportToPdfFile(print, nomeArquivo);
                File file = new File(nomeArquivo);
                try {
                    Desktop.getDesktop().open(file);
                } catch (Exception e) {
                    JOptionPane.showConfirmDialog(null, e);
                }
                file.deleteOnExit();

            } catch (Exception erro) {

                JOptionPane.showMessageDialog(null, "deu erro =" + erro);
                System.out.println(erro);

            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbLinha = new javax.swing.JComboBox<>();
        cbMaterial = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        cbMaterial1 = new javax.swing.JComboBox<>();
        jCheckBox2 = new javax.swing.JCheckBox();
        cbMaterial2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbMaterial3 = new javax.swing.JComboBox<>();
        jCheckBox3 = new javax.swing.JCheckBox();

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Célula:");

        cbLinha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLinhaActionPerformed(evt);
            }
        });

        cbMaterial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Perfil:");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Adicionar outro Perfil ao cabeçalho do Plano de Controle");
        jCheckBox1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jCheckBox1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Perfil:");

        cbMaterial1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMaterial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaterial1ActionPerformed(evt);
            }
        });

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox2.setText("Adicionar outro Perfil ao cabeçalho do Plano de Controle");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        cbMaterial2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Perfil:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Perfil:");

        cbMaterial3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox3.setText("Adicionar outro Perfil ao cabeçalho do Plano de Controle");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMaterial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbMaterial1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jCheckBox2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbMaterial2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jCheckBox3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbMaterial3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cbMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbMaterial2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbMaterial3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void cbLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLinhaActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select distinct ESP_MATERIAL from Qry_FichaControle where ESP_LINHA= ? and SETOR='Acabamento' ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbLinha.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            cbMaterial.removeAllItems();

            while (rs.next()) {
                cbMaterial.addItem(rs.getString("ESP_MATERIAL"));

            }
            limpageral();
        } catch (Exception e) {

        }

        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select distinct MATERIAL from Qry_Material where MAT_LINHA= ? and SETOR='Acabamento' and MATERIAL not in (Select ESP_MATERIAL from Qry_FichaControle where SETOR='Acabamento')";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbLinha.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            cbMaterial1.removeAllItems();
            cbMaterial2.removeAllItems();
            cbMaterial3.removeAllItems();
            while (rs.next()) {
                cbMaterial1.addItem(rs.getString("MATERIAL"));
                cbMaterial2.addItem(rs.getString("MATERIAL"));
                cbMaterial3.addItem(rs.getString("MATERIAL"));
            }
            limpageral();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_cbLinhaActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            jLabel3.setVisible(true);
            cbMaterial1.setVisible(true);
            jCheckBox2.setVisible(true);
        } else {
            jLabel3.setVisible(false);
            cbMaterial1.setVisible(false);
            jCheckBox2.setVisible(false);
            cbMaterial1.setSelectedIndex(-1);
            jCheckBox3.setVisible(false);
            jCheckBox2.setSelected(false);
            jCheckBox3.setSelected(false);
            jLabel5.setVisible(false);
            cbMaterial3.setVisible(false);
            jLabel4.setVisible(false);
            cbMaterial2.setVisible(false);
            cbMaterial2.setSelectedIndex(-1);
            cbMaterial3.setSelectedIndex(-1);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        if (jCheckBox2.isSelected()) {
            jLabel4.setVisible(true);
            cbMaterial2.setVisible(true);
            jCheckBox3.setVisible(true);
        } else {
            jLabel4.setVisible(false);
            cbMaterial2.setVisible(false);
            jCheckBox3.setVisible(false);
            cbMaterial2.setSelectedIndex(-1);
            jLabel5.setVisible(false);
            cbMaterial3.setSelectedIndex(-1);
            cbMaterial3.setVisible(false);
            jCheckBox3.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        if (jCheckBox3.isSelected()) {
            jLabel5.setVisible(true);
            cbMaterial3.setVisible(true);
        } else {
            jLabel5.setVisible(false);
            cbMaterial3.setVisible(false);
            cbMaterial3.setSelectedIndex(-1);
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void cbMaterial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaterial1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMaterial1ActionPerformed

    private void jCheckBox1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jCheckBox1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1AncestorAdded
    private void listarLinhaAc() {
        listaModelLinha = controllerLinhaAc.getListaLinhaAcController();
        cbLinha.removeAllItems();

        for (int i = 0; i < listaModelLinha.size(); i++) {
            cbLinha.addItem(listaModelLinha.get(i).getLinha());

        }
    }

    private void limpageral() {
        cbMaterial.setSelectedIndex(-1);

        cbMaterial1.setSelectedIndex(-1);
        cbMaterial2.setSelectedIndex(-1);
        cbMaterial3.setSelectedIndex(-1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbLinha;
    private javax.swing.JComboBox<String> cbMaterial;
    private javax.swing.JComboBox<String> cbMaterial1;
    private javax.swing.JComboBox<String> cbMaterial2;
    private javax.swing.JComboBox<String> cbMaterial3;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

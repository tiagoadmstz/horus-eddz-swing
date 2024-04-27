/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.views.extrusao;

import com.cooperstandard.controller.extrusao.ControllerProducao;
import com.cooperstandard.controller.extrusao.ControllerResultado;
import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelProducao;
import com.cooperstandard.model.ModelResultado;
import com.cooperstandard.util.EstiloTablaRenderer;
import com.cooperstandard.util.HeaderRenderer;

import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author rsouza10
 */
public class ViewEntradaDadosSuperV extends javax.swing.JFrame {

    ControllerProducao controllerProducao = new ControllerProducao();
    ArrayList<ModelProducao> listaModeProducao = new ArrayList<ModelProducao>();
    ControllerResultado controllerResultado = new ControllerResultado();
    ArrayList<ModelResultado> listaModelResultado = new ArrayList<ModelResultado>();
    private static final long serialVersionUID = 1955035495215081077L;
    String status = "supervisorio";
    String hora = "";

    public ViewEntradaDadosSuperV() {
        initComponents();
        listarLinha();
        tbLancado.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbLancado));
        tbLancado.setDefaultRenderer(String.class, new EstiloTablaRenderer());
        tbLancado.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
        carregaFicha();
        limpacampo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbPerfil = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtRegistro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbLinha = new javax.swing.JComboBox<>();
        cbData = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnAbrir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLancado = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Entrada de Dados Supervisório");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(2, 83, 161));

        jPanel5.setBackground(new java.awt.Color(241, 176, 19));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Perfil:");

        cbPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        cbPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPerfilActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Registro:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Linha:");

        cbLinha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"L03"}));
        cbLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLinhaActionPerformed(evt);
            }
        });

        cbData.setEditable(true);
        cbData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDataActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Data/Hora:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel5)
                                                        .addComponent(cbLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(cbPerfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4)
                                                        .addComponent(txtRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addComponent(jLabel7)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(cbData, 0, 301, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-n¦o-perturbe-filled-50.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Últimos Registros Lançados:");

        btnAbrir.setBackground(new java.awt.Color(255, 255, 255));
        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-arquivo-filled-50.png"))); // NOI18N
        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        tbLancado.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String[]{
                        "Data", "Hora", "Material", "Linha", "Registro"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tbLancado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbLancado.setEnabled(false);
        jScrollPane1.setViewportView(tbLancado);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 488, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane1)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(btnCancelar)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel6)
                                                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(0, 4, Short.MAX_VALUE)))
                                        .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 466, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnAbrir))
                                        .addGap(12, 12, 12)))
        );

        jMenu1.setText("Filtro");

        jMenu2.setText("Dias");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("24 Horas");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jCheckBoxMenuItem1);

        jCheckBoxMenuItem2.setText("Todos");
        jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jCheckBoxMenuItem2);

        jMenu1.add(jMenu2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLinhaActionPerformed
        try {
            final String query1 = "Select distinct MATERIAL,BPCS from Qry_Material where MAT_LINHA= ? and SETOR ='Extrusão' and MATERIAL IN(Select ESP_MATERIAL from Ficha_Controle) order by MATERIAL";
            final PreparedStatement st = new ConexaoSql().getCon().prepareStatement(query1);
            st.setString(1, cbLinha.getSelectedItem().toString());
            final ResultSet rs = st.executeQuery();
            cbPerfil.removeAllItems();
            while (rs.next()) {
                cbPerfil.addItem(rs.getString("MATERIAL") + " - " + rs.getString("BPCS"));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbLinhaActionPerformed

    private void cbDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDataActionPerformed
//        try {
//            
//            Class.forName(Auxiliar1.AcessoBanco.getDriver());
//            Connection con = DriverManager.getConnection(Auxiliar1.AcessoBanco.getUrl(), Auxiliar1.AcessoBanco.getUser(), Auxiliar1.AcessoBanco.getPass());
//            String query1 = "SELECT DISTINCT E3TimeStamp FROM L03 where E3TimeStamp=?";
//            PreparedStatement st = con.prepareStatement(query1);
//            st.setString(1, cbData.getSelectedItem().toString());
//            ResultSet rs = st.executeQuery();
//            cbData1.removeAllItems();
//            
//            while (rs.next()) {
//
//                cbData1.addItem(rs.getString("teste1"));
//
//            }
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
    }//GEN-LAST:event_cbDataActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        new ViewResultado(cbData.getSelectedItem().toString(), cbPerfil.getSelectedItem().toString().split(" - ")[0], txtRegistro.getText(), status, hora, cbLinha.getSelectedItem().toString()).setVisible(true);
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void cbPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPerfilActionPerformed
        try {
            final String query1 = "SELECT DISTINCT convert(CHAR(5),E3TimeStamp,108) as teste1,E3TimeStamp FROM L03 where (DATEPART(MI, E3TimeStamp)) = 00 and Perfil LIKE '" + cbPerfil.getSelectedItem().toString().split(" - ")[1] + "' order by E3TimeStamp DESC";
            final Statement st = new ConexaoSql("supervisorio").getCon().createStatement();
            final ResultSet rs = st.executeQuery(query1);
            cbData.removeAllItems();
            while (rs.next()) {
                this.cbData.addItem(rs.getString("E3TimeStamp"));
            }
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_cbPerfilActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
//        try {
//            Class.forName(Auxiliar1.AcessoBanco.getDriver());
//            Connection con = DriverManager.getConnection(Auxiliar1.AcessoBanco.getUrl(), Auxiliar1.AcessoBanco.getUser(), Auxiliar1.AcessoBanco.getPass());
//            String query1 = "SELECT DISTINCT convert(CHAR(5),E3TimeStamp,108) as teste1,E3TimeStamp FROM L03 where (DATEPART(MI, E3TimeStamp)%10) = 0 and Perfil LIKE '" + txtBpcs.getText() + "%' order by E3TimeStamp DESC";
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(query1);
//            cbData.removeAllItems();
//            while (rs.next()) {
//
//                this.cbData.addItem(rs.getString("E3TimeStamp"));
//
//            }
//
//        } catch (Exception e) {
//
//            JOptionPane.showMessageDialog(null, e);
//        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
//        try {
//            Class.forName(Auxiliar1.AcessoBanco.getDriver());
//            Connection con = DriverManager.getConnection(Auxiliar1.AcessoBanco.getUrl(), Auxiliar1.AcessoBanco.getUser(), Auxiliar1.AcessoBanco.getPass());
//            String query1 = "SELECT DISTINCT convert(CHAR(5),E3TimeStamp,108) as teste1,E3TimeStamp FROM L03 where (DATEPART(MI, E3TimeStamp)%10) = 0 and Perfil LIKE '" + txtBpcs.getText() + "' order by E3TimeStamp DESC";
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(query1);
//            cbData.removeAllItems();
//            while (rs.next()) {
//
//                this.cbData.addItem(rs.getString("E3TimeStamp"));
//
//            }
//
//        } catch (Exception e) {
//
//            JOptionPane.showMessageDialog(null, e);
//        }
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jCheckBoxMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxMenuItem2ActionPerformed

    private void listarLinha() {
        listaModeProducao = controllerProducao.getListaLinhaController();
//        cbLinha.removeAllItems();
        for (int i = 0; i < listaModeProducao.size(); i++) {
//            cbLinha.addItem(listaModeProducao.get(i).getEsp_linha());
        }
    }

    private void carregaFicha() {
        listaModelResultado = controllerResultado.getListaDigitadooController();
        DefaultTableModel modelo = (DefaultTableModel) tbLancado.getModel();
        modelo.setNumRows(0);
        int cont = listaModelResultado.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                    listaModelResultado.get(i).getData(),
                    listaModelResultado.get(i).getHora(),
                    listaModelResultado.get(i).getMaterial(),
                    listaModelResultado.get(i).getLinha(),
                    listaModelResultado.get(i).getRegistro()
            });

        }

    }

    private void limpacampo() {
        cbLinha.setSelectedIndex(-1);
        cbPerfil.setSelectedIndex(-1);
        txtRegistro.setText("");
        cbData.setSelectedIndex(-1);
        cbData.removeAllItems();
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewEntradaDadosSuperV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewEntradaDadosSuperV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewEntradaDadosSuperV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewEntradaDadosSuperV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewEntradaDadosSuperV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cbData;
    private javax.swing.JComboBox<String> cbLinha;
    private javax.swing.JComboBox<String> cbPerfil;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbLancado;
    private javax.swing.JTextField txtRegistro;
    // End of variables declaration//GEN-END:variables
}

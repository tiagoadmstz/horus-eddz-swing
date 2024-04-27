package com.cooperstandard.views.pontoinsp;

import com.cooperstandard.controller.pontoinsp.ControllerResultInsp;
import com.cooperstandard.model.ModelResultInsp;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author rsouza10
 */
public class ViewPainel_Alter extends javax.swing.JFrame {

    private static final long serialVersionUID = -2442322042672022369L;
    ModelResultInsp modelResultInsp = new ModelResultInsp();
    ControllerResultInsp controllerResultInsp = new ControllerResultInsp();
    ArrayList<ModelResultInsp> listaModelResultInsp = new ArrayList<>();
    String busca = "OF";

    public ViewPainel_Alter() {
        initComponents();
        carregaResultado();
        limparDados();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jtable_Editar = new javax.swing.JTable();
        btn_ir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btn_limpar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtData_jet = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHora_jet = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPerfil = new javax.swing.JTextField();
        txtAnalista = new javax.swing.JTextField();
        jdtDataIni = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jdtDataFim = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Painel de Alteração");

        jPanel2.setBackground(new java.awt.Color(2, 83, 161));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        Jtable_Editar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Data jet", "Hora jet", "Perfil", "Analista"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Jtable_Editar.getTableHeader().setReorderingAllowed(false);
        Jtable_Editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jtable_EditarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Jtable_Editar);

        btn_ir.setBackground(new java.awt.Color(255, 255, 255));
        btn_ir.setText("Abrir");
        btn_ir.setFocusable(false);
        btn_ir.setMaximumSize(new java.awt.Dimension(91, 25));
        btn_ir.setMinimumSize(new java.awt.Dimension(91, 25));
        btn_ir.setPreferredSize(new java.awt.Dimension(91, 25));
        btn_ir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_irActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Filtrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_limpar.setBackground(new java.awt.Color(255, 255, 255));
        btn_limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-n¦o-perturbe-filled-50.png"))); // NOI18N
        btn_limpar.setText("Cancelar");
        btn_limpar.setFocusable(false);
        btn_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limparActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(241, 176, 19));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Analista");

        txtData_jet.setEditable(false);
        txtData_jet.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtData_jet.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Data jet:");

        txtHora_jet.setEditable(false);
        try {
            txtHora_jet.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHora_jet.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora_jet.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Perfil:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Hora jet:");

        txtPerfil.setEditable(false);
        txtPerfil.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPerfil.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        txtAnalista.setEditable(false);
        txtAnalista.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAnalista.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtAnalista, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtData_jet, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtHora_jet, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAnalista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtData_jet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHora_jet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jdtDataIni = new JDateChooser("dd/MM/yyyy", "##/##/#####", '_');

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Até");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jdtDataFim = new JDateChooser("dd/MM/yyyy", "##/##/#####", '_');
        jdtDataFim.setDateFormatString("");

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Atualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jdtDataIni, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdtDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_ir, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdtDataFim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdtDataIni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_ir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Jtable_EditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jtable_EditarMouseClicked
        if (evt.getClickCount() == 1) {
            int i = Jtable_Editar.getSelectedRow();
            TableModel model = Jtable_Editar.getModel();
            txtData_jet.setText(model.getValueAt(i, 0).toString());
            txtHora_jet.setText(model.getValueAt(i, 1).toString());
            txtPerfil.setText(model.getValueAt(i, 2).toString());
            txtAnalista.setText(model.getValueAt(i, 3).toString());
        } else if (evt.getClickCount() == 2) {
            if (txtPerfil.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
                txtPerfil.requestFocusInWindow();
            } else {
                new ViewAlterDados(txtPerfil.getText(), txtHora_jet.getText(), txtData_jet.getText()).setVisible(true);
            }
        }
    }//GEN-LAST:event_Jtable_EditarMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jdtDataIni.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", null, JOptionPane.WARNING_MESSAGE);
            jdtDataIni.requestFocus();
        } else if (jdtDataFim.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", null, JOptionPane.WARNING_MESSAGE);
            jdtDataFim.requestFocus();
        } else {
            busca = "ON";
            carregaResultado();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limparActionPerformed
        limparDados();
    }//GEN-LAST:event_btn_limparActionPerformed

    private void btn_irActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_irActionPerformed
        if (txtPerfil.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            txtPerfil.requestFocusInWindow();
        } else {
            new ViewAlterDados(txtPerfil.getText(), txtHora_jet.getText(), txtData_jet.getText()).setVisible(true);
        }
    }//GEN-LAST:event_btn_irActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        carregaResultado();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void limparDados() {
        txtPerfil.setText("");
        txtAnalista.setText("");
        txtData_jet.setText("");
        txtHora_jet.setText("");
        busca = "OF";
        jdtDataIni.setDate(null);
        jdtDataFim.setDate(null);
        carregaResultado();
    }

    private void carregaResultado() {
        if (busca.equals("ON")) {
            listaModelResultInsp = controllerResultInsp.getResultadoLabDataController(new SimpleDateFormat("yyyy-MM-dd").format(jdtDataIni.getDate()), new SimpleDateFormat("yyyy-MM-dd").format(jdtDataFim.getDate()));
        }
        if (busca.equals("OF")) {
            listaModelResultInsp = controllerResultInsp.getUltimoRegistroController();
        }
        DefaultTableModel modelo = (DefaultTableModel) Jtable_Editar.getModel();
        modelo.setNumRows(0);
        int cont = listaModelResultInsp.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelResultInsp.get(i).getData_jet(),
                listaModelResultInsp.get(i).getHora_jet(),
                listaModelResultInsp.get(i).getId_material_id(),
                listaModelResultInsp.get(i).getUsuario()
            });

        }

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
            java.util.logging.Logger.getLogger(ViewPainel_Alter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPainel_Alter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPainel_Alter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPainel_Alter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPainel_Alter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Jtable_Editar;
    private javax.swing.JButton btn_ir;
    private javax.swing.JButton btn_limpar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdtDataFim;
    private com.toedter.calendar.JDateChooser jdtDataIni;
    private javax.swing.JTextField txtAnalista;
    private javax.swing.JTextField txtData_jet;
    private javax.swing.JFormattedTextField txtHora_jet;
    private javax.swing.JTextField txtPerfil;
    // End of variables declaration//GEN-END:variables
}

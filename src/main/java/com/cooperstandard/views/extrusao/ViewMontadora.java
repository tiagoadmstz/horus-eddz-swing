/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.views.extrusao;

import com.cooperstandard.model.ModelMontadora;
import com.cooperstandard.services.AssemblerService;
import com.cooperstandard.util.EstiloTablaRenderer;
import com.cooperstandard.util.HeaderRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rsouza10
 */
public class ViewMontadora extends javax.swing.JFrame {

    private ModelMontadora modelMontadora = new ModelMontadora();
    private final AssemblerService assemblerService;
    private List<ModelMontadora> listaModelMontadora = new ArrayList<>(1);
    private String tipoCadastro;
    private JFrame solicitante = null;

    /**
     * Creates new form NewJFrame
     */
    public ViewMontadora() {
        assemblerService = new AssemblerService();
        initComponents();
        setLocationRelativeTo(null);
        this.carregaMontadora();
        tbOem.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbOem));
        tbOem.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
        tbOem.setDefaultRenderer(String.class, new EstiloTablaRenderer());
    }

    public ViewMontadora(JFrame frame) {
        assemblerService = new AssemblerService();
        initComponents();
        setLocationRelativeTo(null);
        this.carregaMontadora();
        solicitante = frame;
        tbOem.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbOem));
        tbOem.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
        tbOem.setDefaultRenderer(String.class, new EstiloTablaRenderer());
    }

    public void setSolicitante(JFrame solicitante) {
        this.solicitante = solicitante;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbOem = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtOem = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Montadora");
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(2, 83, 161));

        tbOem.setAutoCreateRowSorter(true);
        tbOem.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "ID", "Montadora"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tbOem.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbOem.setFocusable(false);
        tbOem.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbOem);
        if (tbOem.getColumnModel().getColumnCount() > 0) {
            tbOem.getColumnModel().getColumn(0).setMinWidth(0);
            tbOem.getColumnModel().getColumn(0).setMaxWidth(0);
            tbOem.getColumnModel().getColumn(1).setMinWidth(510);
            tbOem.getColumnModel().getColumn(1).setMaxWidth(510);
        }

        jPanel1.setBackground(new java.awt.Color(241, 176, 19));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Montadora:");

        txtOem.setEnabled(false);

        txtCodigo.setEditable(false);
        txtCodigo.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Código:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(0, 354, Short.MAX_VALUE))
                                        .addComponent(txtOem))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtOem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-salvar-filled-50.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnNovo.setBackground(new java.awt.Color(255, 255, 255));
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-joyent-filled-20 (1).png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setBackground(new java.awt.Color(255, 255, 255));
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-editar-filled-50.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(255, 255, 255));
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-excluir-filled-50.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnLimpar.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-n¦o-perturbe-filled-50.png"))); // NOI18N
        btnLimpar.setText("Cancelar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(btnLimpar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnLimpar)
                                        .addComponent(btnExcluir)
                                        .addComponent(btnAlterar)
                                        .addComponent(btnNovo)
                                        .addComponent(btnSalvar))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if (tipoCadastro.equals("novo")) {
            if (txtOem.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtOem.requestFocus();
            } else {
                salvarMontadora();
            }
        } else if (tipoCadastro.equals("alteracao")) {
            alterarMontadora();
            btnSalvar.setEnabled(false);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        this.desabilitarCampos();
        limparDados();
        btnSalvar.setEnabled(false);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linhasselecionada = tbOem.getSelectedRow();
        if (linhasselecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            novaMontadora();
            btnSalvar.setEnabled(true);
            habilitarCampos();
            recuperarMontadora();
            tipoCadastro = "alteracao";
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linhasselecionada = tbOem.getSelectedRow();

        if (linhasselecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            this.excluirProduto();
            limparDados();
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        novaMontadora();
        btnSalvar.setEnabled(true);
        habilitarCampos();
        tipoCadastro = "novo";
        txtOem.requestFocus();

    }//GEN-LAST:event_btnNovoActionPerformed

    private void excluirProduto() {
        int linha = tbOem.getSelectedRow();
        String nome = (String) tbOem.getValueAt(linha, 1);
        int codigo = (Integer) tbOem.getValueAt(linha, 0);
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
                + " excluir o registro \nNome: "
                + nome + " ?", "Atenção", JOptionPane.YES_OPTION);

        if (opcao == JOptionPane.OK_OPTION) {
            if (assemblerService.excluirMontadoraController(codigo)) {
                JOptionPane.showMessageDialog(this, "Registro excluido com sucesso!");
                carregaMontadora();
                if (solicitante != null) {
                    if (solicitante instanceof ViewProjeto) {
                        ViewProjeto vp = (ViewProjeto) solicitante;
                        vp.addItemLista(txtOem.getText());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean salvarMontadora() {
        modelMontadora.setOemDescription(this.txtOem.getText());
        if (assemblerService.save(modelMontadora)) {
            JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
            this.desabilitarCampos();
            this.carregaMontadora();
            limparDados();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao tentar gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private boolean recuperarMontadora() {
        int linha = this.tbOem.getSelectedRow();
        int codigo = (Integer) tbOem.getValueAt(linha, 0);
        try {
            modelMontadora = assemblerService.getMontadoraController(codigo);
            this.txtCodigo.setText(String.valueOf(modelMontadora.getId()));
            this.txtOem.setText(modelMontadora.getOemDescription());
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código inválido ou nenhum registro selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private boolean alterarMontadora() {
        modelMontadora.setId(Integer.parseInt(this.txtCodigo.getText()));
        modelMontadora.setOemDescription(this.txtOem.getText());
        if (assemblerService.atualizarMontadoraController(modelMontadora)) {
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
            this.desabilitarCampos();
            this.carregaMontadora();
            if (solicitante != null) {
                if (solicitante instanceof ViewProjeto) {
                    ViewProjeto vp = (ViewProjeto) solicitante;
                    vp.addItemLista(txtOem.getText());
                }
            }
            limparDados();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void carregaMontadora() {
        listaModelMontadora = assemblerService.getListaMontadoraController();
        DefaultTableModel modelo = (DefaultTableModel) tbOem.getModel();
        modelo.setNumRows(0);
        int cont = listaModelMontadora.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                    listaModelMontadora.get(i).getId(),
                    listaModelMontadora.get(i).getOemDescription()
            });

        }
    }

    public void desabilitarCampos() {
        txtOem.setEnabled(false);
    }

    public void limparDados() {
        txtOem.setText("");
        txtCodigo.setText("");
    }

    public void novaMontadora() {
        habilitarCampos();
        txtOem.setText("");
        txtCodigo.setText("Novo");
    }

    public void habilitarCampos() {
        txtOem.setEnabled(true);
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ViewMontadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMontadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMontadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMontadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ViewMontadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbOem;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtOem;
    // End of variables declaration//GEN-END:variables
}

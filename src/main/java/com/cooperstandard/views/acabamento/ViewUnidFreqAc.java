/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.views.acabamento;

import com.cooperstandard.views.qualidade.ViewFichaControleQualidadeAc;
import com.cooperstandard.model.ModelUnidFreq;
import com.cooperstandard.util.EstiloTablaRenderer;
import com.cooperstandard.util.HeaderRenderer;
import com.cooperstandard.controller.acabamento.ControllerUnidFreq;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rsouza10
 */
public class ViewUnidFreqAc extends javax.swing.JFrame {

    private static final long serialVersionUID = 6667954491795645081L;

    ModelUnidFreq modelUnidFreq = new ModelUnidFreq();
    ControllerUnidFreq controllerUnidFreq = new ControllerUnidFreq();
    ArrayList<ModelUnidFreq> listaModelUnidFreq = new ArrayList<ModelUnidFreq>();
    String tipoCadastro;
    private JFrame solicitante = null;

    public ViewUnidFreqAc() {
        initComponents();
        carregaUnidFreq();
        tbUnidFreq.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbUnidFreq));
        tbUnidFreq.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
        tbUnidFreq.setDefaultRenderer(String.class, new EstiloTablaRenderer());
    }

    public ViewUnidFreqAc(JFrame frame) {
        initComponents();
        carregaUnidFreq();
        solicitante = frame;
        tbUnidFreq.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbUnidFreq));
        tbUnidFreq.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
        tbUnidFreq.setDefaultRenderer(String.class, new EstiloTablaRenderer());
    }

    public void setSolicitante(JFrame solicitante) {
        this.solicitante = solicitante;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbUnidFreq = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lbId = new javax.swing.JLabel();
        lbUnidMedida = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtUnidFreq = new javax.swing.JTextField();
        cbSetor = new javax.swing.JComboBox<>();
        lbSetor = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Unidade de Frequência");

        tbUnidFreq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Unidade Frequência"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbUnidFreq.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbUnidFreq);
        if (tbUnidFreq.getColumnModel().getColumnCount() > 0) {
            tbUnidFreq.getColumnModel().getColumn(0).setMinWidth(0);
            tbUnidFreq.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbId.setText("Código:");

        lbUnidMedida.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbUnidMedida.setText("Unidade Frequência:");

        txtId.setEditable(false);
        txtId.setEnabled(false);

        txtUnidFreq.setEnabled(false);

        cbSetor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acabamento" }));
        cbSetor.setEnabled(false);

        lbSetor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbSetor.setText("Setor:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbId))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbUnidMedida)
                    .addComponent(txtUnidFreq, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbSetor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbSetor)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbId)
                            .addComponent(lbUnidMedida))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUnidFreq, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbSetor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnLimpar.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-n¦o-perturbe-filled-50.png"))); // NOI18N
        btnLimpar.setText("Cancelar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
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

        btnAlterar.setBackground(new java.awt.Color(255, 255, 255));
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-editar-filled-50.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
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

        btnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-salvar-filled-50.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar)
                    .addComponent(btnExcluir)
                    .addComponent(btnAlterar)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        this.desabilitarCampos();
        limparDados();
        btnSalvar.setEnabled(false);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linhasselecionada = tbUnidFreq.getSelectedRow();

        if (linhasselecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            this.excluirUnidFreq();
            limparDados();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linhasselecionada = tbUnidFreq.getSelectedRow();

        if (linhasselecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            novaMontadora();
            btnSalvar.setEnabled(true);
            habilitarCampos();
            recuperarUnidFreq();
            tipoCadastro = "alteracao";

        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        novaMontadora();
        btnSalvar.setEnabled(true);
        habilitarCampos();
        tipoCadastro = "novo";
        txtUnidFreq.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if (tipoCadastro.equals("novo")) {
            if (txtUnidFreq.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtUnidFreq.requestFocus();
            } else {
                salvarUnidFreq();
            }
        } else if (tipoCadastro.equals("alteracao")) {
            if (txtUnidFreq.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtUnidFreq.requestFocus();
            } else {
                alterarUnidFreq();
            }
            btnSalvar.setEnabled(false);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed
    private void excluirUnidFreq() {
        int linha = tbUnidFreq.getSelectedRow();
        String nome = (String) tbUnidFreq.getValueAt(linha, 1);
        int codigo = (Integer) tbUnidFreq.getValueAt(linha, 0);
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
                + " excluir o registro \nNome: "
                + nome + " ?", "Atenção", JOptionPane.YES_OPTION);

        if (opcao == JOptionPane.OK_OPTION) {
            if (controllerUnidFreq.excluirUnidFreqController(codigo)) {
                JOptionPane.showMessageDialog(this, "Registro excluido com sucesso!");
                carregaUnidFreq();
                if (solicitante != null) {
                    if (solicitante instanceof ViewFichaControleAc) {
                        ViewFichaControleAc vp = (ViewFichaControleAc) solicitante;
                        vp.addItemLista(txtUnidFreq.getText());
                    } else if (solicitante instanceof ViewFichaControleQualidadeAc) {
                        ViewFichaControleQualidadeAc vp = (ViewFichaControleQualidadeAc) solicitante;
                        vp.addItemLista(txtUnidFreq.getText());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean salvarUnidFreq() {
        modelUnidFreq.setUnidade_frequencia(this.txtUnidFreq.getText());
        modelUnidFreq.setSetor(this.cbSetor.getSelectedItem().toString());
        if (controllerUnidFreq.salvarUnidFreqController(modelUnidFreq) > 0) {
            JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
            this.desabilitarCampos();
            this.carregaUnidFreq();
            if (solicitante != null) {
                if (solicitante instanceof ViewFichaControleAc) {
                    ViewFichaControleAc vp = (ViewFichaControleAc) solicitante;
                    vp.addItemLista(txtUnidFreq.getText());
                } else if (solicitante instanceof ViewFichaControleQualidadeAc) {
                    ViewFichaControleQualidadeAc vp = (ViewFichaControleQualidadeAc) solicitante;
                    vp.addItemLista(txtUnidFreq.getText());
                }
            }

            limparDados();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao tentar gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private boolean recuperarUnidFreq() {
        int linha = this.tbUnidFreq.getSelectedRow();
        int codigo = (Integer) tbUnidFreq.getValueAt(linha, 0);
        try {
            modelUnidFreq = controllerUnidFreq.getUnidFreqController(codigo);
            this.txtId.setText(String.valueOf(modelUnidFreq.getId()));
            this.txtUnidFreq.setText(modelUnidFreq.getUnidade_frequencia());
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código inválido ou nenhum registro selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private boolean alterarUnidFreq() {
        modelUnidFreq.setId(Integer.parseInt(this.txtId.getText()));
        modelUnidFreq.setUnidade_frequencia(this.txtUnidFreq.getText());
        if (controllerUnidFreq.atualizarUnidFreqController(modelUnidFreq)) {
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
            this.desabilitarCampos();
            this.carregaUnidFreq();
            if (solicitante != null) {
                if (solicitante instanceof ViewFichaControleAc) {
                    ViewFichaControleAc vp = (ViewFichaControleAc) solicitante;
                    vp.addItemLista(txtUnidFreq.getText());
                } else if (solicitante instanceof ViewFichaControleQualidadeAc) {
                    ViewFichaControleQualidadeAc vp = (ViewFichaControleQualidadeAc) solicitante;
                    vp.addItemLista(txtUnidFreq.getText());
                }
            }
            limparDados();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void carregaUnidFreq() {
        listaModelUnidFreq = controllerUnidFreq.getListaUnidFreqController();
        DefaultTableModel modelo = (DefaultTableModel) tbUnidFreq.getModel();
        modelo.setNumRows(0);
        int cont = listaModelUnidFreq.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelUnidFreq.get(i).getId(),
                listaModelUnidFreq.get(i).getUnidade_frequencia()
            });

        }

    }

    public void desabilitarCampos() {
        txtUnidFreq.setEnabled(false);
    }

    public void limparDados() {
        txtUnidFreq.setText("");
        txtId.setText("");
    }

    public void novaMontadora() {
        habilitarCampos();
        txtUnidFreq.setText("");
        txtId.setText("Novo");
    }

    public void habilitarCampos() {
        txtUnidFreq.setEnabled(true);
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
            java.util.logging.Logger.getLogger(ViewUnidFreqAc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewUnidFreqAc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewUnidFreqAc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewUnidFreqAc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ViewUnidFreqAc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbSetor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbSetor;
    private javax.swing.JLabel lbUnidMedida;
    private javax.swing.JTable tbUnidFreq;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtUnidFreq;
    // End of variables declaration//GEN-END:variables
}

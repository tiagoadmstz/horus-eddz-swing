
package com.cooperstandard.views.extrusao;

import com.cooperstandard.controller.extrusao.ControllerLinha;
import com.cooperstandard.model.ModelLinha;
import com.cooperstandard.util.EstiloTablaRenderer;
import com.cooperstandard.util.HeaderRenderer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rsouza10
 */
public class ViewCabecalhoFmea extends javax.swing.JFrame {

    private static final long serialVersionUID = 3055738224505747558L;

    ModelLinha modelLinha = new ModelLinha();
    ControllerLinha controllerLinha = new ControllerLinha();
    ArrayList<ModelLinha> listaModelLinha = new ArrayList<ModelLinha>();
    String tipoCadastro;

    public ViewCabecalhoFmea() {
        initComponents();
        carregaLinha();
        tbCabecalhoFmea.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbCabecalhoFmea));
        tbCabecalhoFmea.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
        tbCabecalhoFmea.setDefaultRenderer(String.class, new EstiloTablaRenderer());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbLinha = new javax.swing.JLabel();
        txtLinha = new javax.swing.JTextField();
        lbNPlano = new javax.swing.JLabel();
        txtNPlano = new javax.swing.JTextField();
        txtContatoChave = new javax.swing.JTextField();
        lbContatoChave = new javax.swing.JLabel();
        txtEquipe = new javax.swing.JTextField();
        lbEquipe = new javax.swing.JLabel();
        jdtData = new com.toedter.calendar.JDateChooser();
        lbData = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lbId = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCabecalhoFmea = new javax.swing.JTable();
        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Painel Cadastro de Cabeçalho FMEA");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbLinha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbLinha.setText("Linha:");

        txtLinha.setEnabled(false);

        lbNPlano.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNPlano.setText("Nº Plano:");

        txtNPlano.setEnabled(false);

        txtContatoChave.setEnabled(false);

        lbContatoChave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbContatoChave.setText("Contato Chave:");

        txtEquipe.setEnabled(false);

        lbEquipe.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbEquipe.setText("Equipe Principal:");

        jdtData.setEnabled(false);

        lbData.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbData.setText("Data:");

        txtId.setEnabled(false);

        lbId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbId.setText("Código:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEquipe)
                            .addComponent(txtEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdtData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbData)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbId)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLinha)
                            .addComponent(txtLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNPlano)
                            .addComponent(txtNPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbContatoChave)
                                .addGap(231, 308, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtContatoChave)
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbLinha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbNPlano)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNPlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbContatoChave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContatoChave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbEquipe)
                            .addComponent(lbData))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbCabecalhoFmea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Linha", "N. Plano", "Contato Chave", "Equipe Principal", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCabecalhoFmea.setFocusable(false);
        tbCabecalhoFmea.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbCabecalhoFmea);
        if (tbCabecalhoFmea.getColumnModel().getColumnCount() > 0) {
            tbCabecalhoFmea.getColumnModel().getColumn(0).setMinWidth(0);
            tbCabecalhoFmea.getColumnModel().getColumn(0).setMaxWidth(0);
        }

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
        btnExcluir.setPreferredSize(new java.awt.Dimension(97, 27));
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLimpar)
                        .addComponent(btnAlterar)
                        .addComponent(btnNovo)
                        .addComponent(btnSalvar)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        int linhasselecionada = tbCabecalhoFmea.getSelectedRow();

        if (linhasselecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            this.excluirLinha();
            limparDados();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linhasselecionada = tbCabecalhoFmea.getSelectedRow();

        if (linhasselecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            novoProjeto();
            btnSalvar.setEnabled(true);
            habilitarCampos();
            recuperarLinha();
            tipoCadastro = "alteracao";

        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        novoProjeto();
        btnSalvar.setEnabled(true);
        habilitarCampos();
        txtLinha.requestFocus();
        tipoCadastro = "novo";
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if (tipoCadastro.equals("novo")) {
            if (txtLinha.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtLinha.requestFocus();
            } else if (txtNPlano.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtNPlano.requestFocus();
            } else if (txtContatoChave.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtContatoChave.requestFocus();
            } else if (txtEquipe.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtEquipe.requestFocus();
            } else if (jdtData.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                jdtData.requestFocus();
            } else {
                salvarLinha();
            }
        } else if (tipoCadastro.equals("alteracao")) {
            if (txtLinha.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtLinha.requestFocus();
            } else if (txtNPlano.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtNPlano.requestFocus();
            } else if (txtContatoChave.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtContatoChave.requestFocus();
            } else if (txtEquipe.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtEquipe.requestFocus();
            } else if (jdtData.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                jdtData.requestFocus();
            } else {
                alterarLinha();
                btnSalvar.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void excluirLinha() {
        int linha = tbCabecalhoFmea.getSelectedRow();
        String nome = (String) tbCabecalhoFmea.getValueAt(linha, 1);
        int codigo = (Integer) tbCabecalhoFmea.getValueAt(linha, 0);
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
                + " excluir o registro \nNome: "
                + nome + " ?", "Atenção", JOptionPane.YES_OPTION);

        if (opcao == JOptionPane.OK_OPTION) {
            if (controllerLinha.excluirLinhaController(codigo)) {
                JOptionPane.showMessageDialog(this, "Registro excluido com sucesso!");
                carregaLinha();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean salvarLinha() {
        modelLinha.setId_linha(Integer.parseInt(this.txtId.getText()));
        modelLinha.setLinha(this.txtLinha.getText());
        modelLinha.setN_plano(this.txtNPlano.getText());
        modelLinha.setContatoChave(this.txtContatoChave.getText());
        modelLinha.setEquipe_principal(this.txtEquipe.getText());
        try {
            modelLinha.setData_inicial(new SimpleDateFormat("yyyy/MM/dd").format(jdtData.getDate()));

        } catch (Exception ex) {
            Logger.getLogger(ViewOperacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (controllerLinha.salvarLinhaController(modelLinha) > 0) {
            JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
            this.desabilitarCampos();
            this.carregaLinha();
            int p1 = JOptionPane.showConfirmDialog(null, "Deseja criar um cabeçalho de FMEA para essa linha?", "Cadastrar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            limparDados();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao tentar gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private boolean recuperarLinha() {
        int linha = this.tbCabecalhoFmea.getSelectedRow();
        int codigo = (Integer) tbCabecalhoFmea.getValueAt(linha, 0);
        try {
            modelLinha = controllerLinha.getLinhaController(codigo);
            this.txtId.setText(String.valueOf(modelLinha.getId_linha()));
            this.txtLinha.setText(modelLinha.getLinha());
            this.txtNPlano.setText(modelLinha.getN_plano());
            this.txtContatoChave.setText(modelLinha.getContatoChave());
            this.txtEquipe.setText(modelLinha.getEquipe_principal());
            this.jdtData.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(modelLinha.getData_inicial()));

            return true;
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Código inválido ou nenhum registro selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private boolean alterarLinha() {
        modelLinha.setId_linha(Integer.parseInt(this.txtId.getText()));
        modelLinha.setLinha(this.txtLinha.getText());
        modelLinha.setN_plano(this.txtNPlano.getText());
        modelLinha.setContatoChave(this.txtContatoChave.getText());
        modelLinha.setEquipe_principal(this.txtEquipe.getText());
        try {
            modelLinha.setData_inicial(new SimpleDateFormat("yyyy/MM/dd").format(jdtData.getDate()));
        } catch (Exception ex) {
            Logger.getLogger(ViewOperacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (controllerLinha.atualizarLinhaController(modelLinha)) {
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
            this.desabilitarCampos();
            this.carregaLinha();
            limparDados();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void carregaLinha() {
        listaModelLinha = controllerLinha.getListaLinhaController();
        DefaultTableModel modelo = (DefaultTableModel) tbCabecalhoFmea.getModel();
        modelo.setNumRows(0);
        int cont = listaModelLinha.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelLinha.get(i).getId_linha(),
                listaModelLinha.get(i).getLinha(),
                listaModelLinha.get(i).getN_plano(),
                listaModelLinha.get(i).getContatoChave(),
                listaModelLinha.get(i).getEquipe_principal(),
                listaModelLinha.get(i).getData_inicial()

            });

        }

    }

    public void desabilitarCampos() {
        txtLinha.setEnabled(false);
        txtNPlano.setEnabled(false);
        txtContatoChave.setEnabled(false);
        txtEquipe.setEnabled(false);
        jdtData.setEnabled(false);

    }

    public void limparDados() {
        txtId.setText("");
        txtLinha.setText("");
        txtNPlano.setText("");
        txtContatoChave.setText("");
        txtEquipe.setText("");
        jdtData.setDate(null);
    }

    public void novoProjeto() {
        habilitarCampos();
        txtId.setText("Novo");
        txtLinha.setText("");
        txtNPlano.setText("");
        txtContatoChave.setText("");
        txtEquipe.setText("");
        jdtData.setDate(null);
    }

    public void habilitarCampos() {
        txtLinha.setEnabled(true);
        txtNPlano.setEnabled(true);
        txtContatoChave.setEnabled(true);
        txtEquipe.setEnabled(true);
        jdtData.setEnabled(true);

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
            java.util.logging.Logger.getLogger(ViewCabecalhoFmea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCabecalhoFmea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCabecalhoFmea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCabecalhoFmea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCabecalhoFmea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdtData;
    private javax.swing.JLabel lbContatoChave;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbEquipe;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbLinha;
    private javax.swing.JLabel lbNPlano;
    private javax.swing.JTable tbCabecalhoFmea;
    private javax.swing.JTextField txtContatoChave;
    private javax.swing.JTextField txtEquipe;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLinha;
    private javax.swing.JTextField txtNPlano;
    // End of variables declaration//GEN-END:variables
}

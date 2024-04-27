package com.cooperstandard.views.extrusao;
import com.cooperstandard.util.EstiloTablaRenderer;
import com.cooperstandard.controller.extrusao.ControllerLinha;
import com.cooperstandard.model.ModelLinha;
import com.cooperstandard.util.HeaderRenderer;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rsouza10
 */
public class ViewLinha extends javax.swing.JFrame {

    ModelLinha modelLinha = new ModelLinha();
    ControllerLinha controllerLinha = new ControllerLinha();
    ArrayList<ModelLinha> listaModelLinha = new ArrayList<ModelLinha>();
    String tipoCadastro;
    private JFrame solicitante = null;

    /**
     * Creates new form ViewLinha
     */
    public ViewLinha() {
        initComponents();
        setLocationRelativeTo(null);
        this.carregaLinha();
        tbLinha.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbLinha));
        tbLinha.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
        tbLinha.setDefaultRenderer(String.class, new EstiloTablaRenderer());
    }

    public ViewLinha(JFrame frame) {
        initComponents();
        setLocationRelativeTo(null);
        this.carregaLinha();
        solicitante = frame;
        tbLinha.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbLinha));
        tbLinha.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
        tbLinha.setDefaultRenderer(String.class, new EstiloTablaRenderer());
    }

    public void setSolicitante(JFrame solicitante) {
        this.solicitante = solicitante;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLinha = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtOrdem = new javax.swing.JTextField();
        lbLinha = new javax.swing.JLabel();
        txtLinha = new javax.swing.JTextField();
        lbTipo = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        lbSetor = new javax.swing.JLabel();
        cbSetor = new javax.swing.JComboBox<>();
        lbOrdem = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lbId = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Linha");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(2, 83, 161));

        tbLinha.setAutoCreateRowSorter(true);
        tbLinha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Ordem", "Linha", "Tipo da Linha", "Setor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbLinha.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbLinha.setRequestFocusEnabled(false);
        tbLinha.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbLinha);
        if (tbLinha.getColumnModel().getColumnCount() > 0) {
            tbLinha.getColumnModel().getColumn(0).setMinWidth(0);
            tbLinha.getColumnModel().getColumn(0).setMaxWidth(0);
            tbLinha.getColumnModel().getColumn(1).setMinWidth(120);
            tbLinha.getColumnModel().getColumn(2).setMinWidth(190);
            tbLinha.getColumnModel().getColumn(3).setMinWidth(190);
            tbLinha.getColumnModel().getColumn(4).setMinWidth(125);
        }

        jPanel1.setBackground(new java.awt.Color(241, 176, 19));

        txtOrdem.setEnabled(false);

        lbLinha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbLinha.setText("Linha:");

        txtLinha.setEnabled(false);

        lbTipo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbTipo.setText("Tipo:");

        txtTipo.setEnabled(false);

        lbSetor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbSetor.setText("Setor:");

        cbSetor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Extrusão" }));
        cbSetor.setEnabled(false);
        cbSetor.setFocusable(false);

        lbOrdem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbOrdem.setText("Ordem:");

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
                    .addComponent(lbId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbOrdem)
                    .addComponent(txtOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbLinha)
                    .addComponent(txtLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTipo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbSetor)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cbSetor, 0, 78, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbSetor)
                            .addComponent(lbTipo)
                            .addComponent(lbLinha)
                            .addComponent(lbOrdem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
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
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLimpar)
                        .addComponent(btnAlterar)
                        .addComponent(btnNovo)
                        .addComponent(btnSalvar))
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-adicionar-filled-50.png"))); // NOI18N
        jMenu1.setText("Cabeçalho FMEA");

        jMenuItem1.setText("Cadastrar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new ViewCabecalhoFmea().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        this.desabilitarCampos();
        limparDados();
        btnSalvar.setEnabled(false);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linhasselecionada = tbLinha.getSelectedRow();

        if (linhasselecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            this.excluirLinha();
            limparDados();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linhasselecionada = tbLinha.getSelectedRow();

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
        txtOrdem.requestFocus();
        tipoCadastro = "novo";
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if (tipoCadastro.equals("novo")) {
            if (txtOrdem.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtOrdem.requestFocus();
            } else if (txtLinha.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtLinha.requestFocus();
            } else if (txtTipo.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtTipo.requestFocus();
            } else if (cbSetor.getSelectedIndex() == -1) {
                cbSetor.requestFocus();
            } else {
                salvarLinha();
            }
        } else if (tipoCadastro.equals("alteracao")) {
            alterarLinha();
            btnSalvar.setEnabled(false);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed
    private void excluirLinha() {
        int linha = tbLinha.getSelectedRow();
        String nome = (String) tbLinha.getValueAt(linha, 2);
        int codigo = (Integer) tbLinha.getValueAt(linha, 0);
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
                + " excluir o registro \nNome: "
                + nome + " ?", "Atenção", JOptionPane.YES_OPTION);

        if (opcao == JOptionPane.OK_OPTION) {
            if (controllerLinha.excluirLinhaController(codigo)) {
                JOptionPane.showMessageDialog(this, "Registro excluido com sucesso!");
                if (solicitante != null) {
                    if (solicitante instanceof ViewMaterial) {
                        ViewMaterial vp = (ViewMaterial) solicitante;
                        vp.addItemLista(txtLinha.getText());
                    }
                }
                carregaLinha();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean salvarLinha() {
        modelLinha.setOrdem(Integer.parseInt(this.txtOrdem.getText()));
        modelLinha.setLinha(this.txtLinha.getText());
        modelLinha.setTipo_linha(this.txtTipo.getText());
        modelLinha.setSetor(this.cbSetor.getSelectedItem().toString());
        if (controllerLinha.salvarLinhaController(modelLinha) > 0) {
            JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
            this.desabilitarCampos();
            this.carregaLinha();
            int p1 = JOptionPane.showConfirmDialog(null, "Deseja criar um cabeçalho de FMEA para essa linha?", "Cadastrar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (p1 == 0) {
                new ViewCabecalhoFmea().setVisible(true);
                dispose();
            }
            if (solicitante != null) {
                if (solicitante instanceof ViewMaterial) {
                    ViewMaterial vp = (ViewMaterial) solicitante;
                    vp.addItemLista(txtLinha.getText());
                }
            }
            limparDados();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao tentar gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private boolean recuperarLinha() {
        int linha = this.tbLinha.getSelectedRow();
        int codigo = (Integer) tbLinha.getValueAt(linha, 0);
        try {
            modelLinha = controllerLinha.getLinhaController(codigo);
            this.txtId.setText(String.valueOf(modelLinha.getId_linha()));
            this.txtOrdem.setText(String.valueOf(modelLinha.getOrdem()));
            this.txtLinha.setText(modelLinha.getLinha());
            this.txtTipo.setText(modelLinha.getTipo_linha());
            this.cbSetor.setSelectedItem(modelLinha.getSetor());

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código inválido ou nenhum registro selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private boolean alterarLinha() {
        modelLinha.setId_linha(Integer.parseInt(this.txtId.getText()));
        modelLinha.setOrdem(Integer.parseInt(this.txtOrdem.getText()));
        modelLinha.setLinha(this.txtLinha.getText());
        modelLinha.setTipo_linha(this.txtTipo.getText());
        modelLinha.setSetor(this.cbSetor.getSelectedItem().toString());
        if (controllerLinha.atualizarLinhaController(modelLinha)) {
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
            this.desabilitarCampos();
            this.carregaLinha();
            if (solicitante != null) {
                if (solicitante instanceof ViewMaterial) {
                    ViewMaterial vp = (ViewMaterial) solicitante;
                    vp.addItemLista(txtLinha.getText());
                }
            }
            limparDados();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void carregaLinha() {
        listaModelLinha = controllerLinha.getListaLinhaController();
        DefaultTableModel modelo = (DefaultTableModel) tbLinha.getModel();
        modelo.setNumRows(0);
        int cont = listaModelLinha.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelLinha.get(i).getId_linha(),
                listaModelLinha.get(i).getOrdem(),
                listaModelLinha.get(i).getLinha(),
                listaModelLinha.get(i).getTipo_linha(),
                listaModelLinha.get(i).getSetor()

            });

        }

    }

    public void desabilitarCampos() {
        txtOrdem.setEnabled(false);
        txtLinha.setEnabled(false);
        txtTipo.setEnabled(false);
    }

    public void limparDados() {
        txtId.setText("");
        txtOrdem.setText("");
        txtLinha.setText("");
        txtTipo.setText("");
    }

    public void novoProjeto() {
        habilitarCampos();
        txtOrdem.setText("");
        txtLinha.setText("");
        txtTipo.setText("");
        txtId.setText("Novo");
    }

    public void habilitarCampos() {
        txtOrdem.setEnabled(true);
        txtLinha.setEnabled(true);
        txtTipo.setEnabled(true);

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
            java.util.logging.Logger.getLogger(ViewLinha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewLinha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewLinha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewLinha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewLinha().setVisible(true);
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbLinha;
    private javax.swing.JLabel lbOrdem;
    private javax.swing.JLabel lbSetor;
    private javax.swing.JLabel lbTipo;
    private javax.swing.JTable tbLinha;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLinha;
    private javax.swing.JTextField txtOrdem;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}

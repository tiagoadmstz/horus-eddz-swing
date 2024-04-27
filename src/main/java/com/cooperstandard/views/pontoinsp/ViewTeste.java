package com.cooperstandard.views.pontoinsp;

import com.cooperstandard.controller.pontoinsp.ControllerTeste;
import com.cooperstandard.views.principal.AguardeGerandoRelatório;
import com.cooperstandard.model.ModelTeste;
import com.cooperstandard.util.EstiloTablaRenderer;
import com.cooperstandard.util.HeaderRenderer;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author rsouza10
 */
public class ViewTeste extends javax.swing.JFrame {

    ModelTeste modelTeste = new ModelTeste();
    ControllerTeste controllerTeste = new ControllerTeste();
    ArrayList<ModelTeste> listaModelTeste = new ArrayList<>();
    private JFrame solicitante = null;

    public ViewTeste() {
        initComponents();
        carregaTeste();
        tbTeste.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbTeste));
        tbTeste.setDefaultRenderer(String.class, new EstiloTablaRenderer());
        tbTeste.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
    }

    public ViewTeste(JFrame frame) {
        initComponents();
        carregaTeste();
        solicitante = frame;
        tbTeste.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbTeste));
        tbTeste.setDefaultRenderer(String.class, new EstiloTablaRenderer());
        tbTeste.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
    }

    public void setSolicitante(JFrame solicitante) {
        this.solicitante = solicitante;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbOrdem = new javax.swing.JLabel();
        lbEquipamento = new javax.swing.JLabel();
        lbDescTeste = new javax.swing.JLabel();
        txtDescTeste = new javax.swing.JTextField();
        lbCodTeste = new javax.swing.JLabel();
        txtCodTeste = new javax.swing.JTextField();
        btnCodigo = new javax.swing.JButton();
        cbClassificacao = new javax.swing.JComboBox<>();
        lbClassificacao = new javax.swing.JLabel();
        txtBusca = new javax.swing.JTextField();
        lbBuscar = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lbId = new javax.swing.JLabel();
        lbImagem = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        txtOrdem = new javax.swing.JFormattedTextField();
        txtEquipamento = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTeste = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnSalvar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Teste");

        jPanel3.setBackground(new java.awt.Color(2, 83, 161));

        jPanel1.setBackground(new java.awt.Color(241, 176, 19));

        lbOrdem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbOrdem.setText("Cod. Teste:");

        lbEquipamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbEquipamento.setText("Equipamento:");

        lbDescTeste.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbDescTeste.setText("Desc. Teste:");

        txtDescTeste.setEnabled(false);

        lbCodTeste.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCodTeste.setText("Código de barras:");

        txtCodTeste.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCodTeste.setEnabled(false);

        btnCodigo.setBackground(new java.awt.Color(255, 255, 255));
        btnCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/codBarras.png"))); // NOI18N
        btnCodigo.setFocusable(false);
        btnCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCodigoActionPerformed(evt);
            }
        });

        cbClassificacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não Crítico", "Crítico", "Crítico + Segurança" }));
        cbClassificacao.setEnabled(false);

        lbClassificacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbClassificacao.setText("Classificação:");

        txtBusca.setBackground(new java.awt.Color(255, 255, 204));
        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaKeyReleased(evt);
            }
        });

        lbBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbBuscar.setText("Buscar:");

        txtId.setEnabled(false);

        lbId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbId.setText("Código:");

        lbImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-binóculos-filled-50.png"))); // NOI18N

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-pdf-2-filled-50.png"))); // NOI18N
        jButton4.setText("Visualizar/Imprimir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtOrdem.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#########"))));
        txtOrdem.setEnabled(false);

        txtEquipamento.setEditable(false);
        txtEquipamento.setText("Laboratório");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbId)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbOrdem)
                            .addComponent(txtOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEquipamento)
                            .addComponent(txtEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbDescTeste)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtDescTeste))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbClassificacao)
                            .addComponent(cbClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCodTeste)
                            .addComponent(txtCodTeste, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbOrdem)
                                .addComponent(lbId))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbEquipamento)
                            .addComponent(lbDescTeste)))
                    .addComponent(txtDescTeste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbClassificacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCodTeste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbCodTeste)
                        .addGap(26, 26, 26))
                    .addComponent(btnCodigo)
                    .addComponent(jButton4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbTeste.setAutoCreateRowSorter(true);
        tbTeste.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Cod. Teste", "Equipamento", "Desc. Teste", "Classificação", "Código"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tbTeste.setFocusable(false);
        tbTeste.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbTeste);
        if (tbTeste.getColumnModel().getColumnCount() > 0) {
            tbTeste.getColumnModel().getColumn(0).setMinWidth(0);
            tbTeste.getColumnModel().getColumn(0).setMaxWidth(0);
            tbTeste.getColumnModel().getColumn(1).setMinWidth(90);
            tbTeste.getColumnModel().getColumn(1).setMaxWidth(90);
            tbTeste.getColumnModel().getColumn(2).setMinWidth(60);
            tbTeste.getColumnModel().getColumn(3).setMinWidth(50);
            tbTeste.getColumnModel().getColumn(4).setMinWidth(120);
            tbTeste.getColumnModel().getColumn(4).setMaxWidth(120);
            tbTeste.getColumnModel().getColumn(5).setMinWidth(120);
            tbTeste.getColumnModel().getColumn(5).setMaxWidth(120);
        }

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

        btnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-salvar-filled-50.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnSalvar1.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-salvar-filled-50.png"))); // NOI18N
        btnSalvar1.setText("Salvar Alteração");
        btnSalvar1.setEnabled(false);
        btnSalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvar1ActionPerformed(evt);
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
                        .addComponent(btnSalvar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnAlterar)
                    .addComponent(btnNovo)
                    .addComponent(btnLimpar)
                    .addComponent(btnSalvar)
                    .addComponent(btnSalvar1))
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
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCodigoActionPerformed
        Random ran = new Random();
        String[] letras = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String b = "";
        int num = 8;
        for (int i = 0; i < num; i++) {
            int a = ran.nextInt(letras.length);
            b += letras[a];
        }
        txtCodTeste.setText(b);
    }//GEN-LAST:event_btnCodigoActionPerformed

    private void txtBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyReleased
        DefaultTableModel tabela = (DefaultTableModel) this.tbTeste.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabela);
        this.tbTeste.setRowSorter(sorter);
        String text = txtBusca.getText();
        sorter.setRowFilter(RowFilter.regexFilter(text, 2, 3, 6));
    }//GEN-LAST:event_txtBuscaKeyReleased

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        novoTeste();
        btnSalvar.setEnabled(true);
        habilitarCampos();
        txtOrdem.requestFocus();
        btnCodigo.setEnabled(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linhasselecionada = tbTeste.getSelectedRow();
        if (linhasselecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            novoTeste();
            btnSalvar.setEnabled(true);
            btnSalvar1.setEnabled(true);
            habilitarCampos();
            recuperarTeste();
       }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linhasselecionada = tbTeste.getSelectedRow();
        if (linhasselecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            this.excluirTeste();
            limparDados();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        this.desabilitarCampos();
        limparDados();
        btnSalvar.setEnabled(false);
        btnSalvar1.setEnabled(false);
        btnCodigo.setEnabled(false);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (txtOrdem.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            txtOrdem.requestFocus();
        } else if (txtDescTeste.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            txtDescTeste.requestFocus();
        } else if (cbClassificacao.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            cbClassificacao.requestFocus();
        } else if (txtCodTeste.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            txtCodTeste.requestFocus();
        } else {
            salvarTeste();
            btnSalvar.setEnabled(false);
            btnSalvar1.setEnabled(false);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvar1ActionPerformed
        if (txtOrdem.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            txtOrdem.requestFocus();
        } else if (txtDescTeste.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            txtDescTeste.requestFocus();
        } else if (cbClassificacao.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            cbClassificacao.requestFocus();
        } else if (txtCodTeste.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            txtCodTeste.requestFocus();
        } else {
            alterarTeste();
            btnSalvar.setEnabled(false);
            btnSalvar1.setEnabled(false);
        }
    }//GEN-LAST:event_btnSalvar1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        final AguardeGerandoRelatório carregando = new AguardeGerandoRelatório();
        carregando.setVisible(true);
        Thread t = new Thread() {
            public void run() {
                try {
                    String logo = "/images/logocooper.jpg";
                    
                    Connection con = new ConexaoSql().getCon();
                    Map p = new HashMap();
                    p.put("logo", this.getClass().getResourceAsStream(logo));
                    JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Relatorios/listagemteste.jasper"));
                    JasperPrint print = JasperFillManager.fillReport(jr, p, con);
                    JasperViewer view = new JasperViewer(print, false);
                    view.setTitle("Teste");
                    view.setVisible(true);
                } catch (Exception erro) {
                    JOptionPane.showMessageDialog(null, "deu erro =" + erro);
                    System.out.println(erro);
                }
                carregando.dispose();
            }
        };
        t.start();
    }//GEN-LAST:event_jButton4ActionPerformed
    private void excluirTeste() {
        int linha = tbTeste.getSelectedRow();
        String nome = (String) tbTeste.getValueAt(linha, 3);
        int codigo = (Integer) tbTeste.getValueAt(linha, 0);
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
                + " excluir o registro \nNome: "
                + nome + " ?", "Atenção", JOptionPane.YES_OPTION);
        if (opcao == JOptionPane.OK_OPTION) {
            if (controllerTeste.excluirTesteController(codigo)) {
                JOptionPane.showMessageDialog(this, "Registro excluido com sucesso!");
                carregaTeste();
                if (solicitante != null) {
                }
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean salvarTeste() {
        modelTeste.setOrdem(Integer.parseInt(this.txtOrdem.getText()));
        modelTeste.setTes_equipamento(this.txtEquipamento.getText().toString());
        modelTeste.setDesc_teste(this.txtDescTeste.getText());
        modelTeste.setClassificacao(this.cbClassificacao.getSelectedItem().toString());
        modelTeste.setControl_prcess("A");
        modelTeste.setCod_teste(this.txtCodTeste.getText());
        if (controllerTeste.salvarTesteController(modelTeste) > 0) {
            JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
            this.desabilitarCampos();
            this.carregaTeste();
            if (solicitante != null) {
            }
            limparDados();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao tentar gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private boolean recuperarTeste() {
        int linha = this.tbTeste.getSelectedRow();
        int codigo = (Integer) tbTeste.getValueAt(linha, 0);
        try {
            modelTeste = controllerTeste.getTesteController(codigo);
            this.txtId.setText(String.valueOf(modelTeste.getId_teste()));
            this.txtOrdem.setText(String.valueOf(modelTeste.getOrdem()));
            this.txtEquipamento.setText(modelTeste.getTes_equipamento());
            this.txtDescTeste.setText(modelTeste.getDesc_teste());
            this.cbClassificacao.setSelectedItem(modelTeste.getClassificacao());
            this.txtCodTeste.setText(modelTeste.getCod_teste());
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código inválido ou nenhum registro selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private boolean alterarTeste() {
        modelTeste.setOrdem(Integer.parseInt(this.txtOrdem.getText()));
        modelTeste.setTes_equipamento(this.txtEquipamento.getText());
        modelTeste.setDesc_teste(this.txtDescTeste.getText());
        modelTeste.setClassificacao(this.cbClassificacao.getSelectedItem().toString());
        modelTeste.setControl_prcess("A");
        modelTeste.setCod_teste(this.txtCodTeste.getText());
        if (controllerTeste.atualizarTesteController(modelTeste)) {
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
            this.desabilitarCampos();
            this.carregaTeste();
            if (solicitante != null) {
            }
            limparDados();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void carregaTeste() {
        listaModelTeste = controllerTeste.getListaTesteController();
        DefaultTableModel modelo = (DefaultTableModel) tbTeste.getModel();
        modelo.setNumRows(0);
        int cont = listaModelTeste.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelTeste.get(i).getId_teste(),
                listaModelTeste.get(i).getOrdem(),
                listaModelTeste.get(i).getTes_equipamento(),
                listaModelTeste.get(i).getDesc_teste(),
                listaModelTeste.get(i).getCod_teste()
            });
        }
    }

    public void desabilitarCampos() {
        txtOrdem.setEnabled(false);
        txtEquipamento.setEnabled(false);
        txtDescTeste.setEnabled(false);
        cbClassificacao.setEnabled(false);
    }

    public void limparDados() {
        txtId.setText("");
        txtBusca.setText("");
        txtOrdem.setText("");
        txtDescTeste.setText("");
        txtEquipamento.setText("Laboratório");
        cbClassificacao.setSelectedIndex(-1);
        txtCodTeste.setText("");
    }

    public void novoTeste() {
        habilitarCampos();
        txtBusca.setText("");
        txtOrdem.setText("");
        txtDescTeste.setText("");
        txtEquipamento.setText("Laboratório");
        cbClassificacao.setSelectedIndex(-1);
        txtId.setText("Novo");
    }

    public void habilitarCampos() {
        txtOrdem.setEnabled(true);
        txtEquipamento.setEnabled(true);
        txtDescTeste.setEnabled(true);
        cbClassificacao.setEnabled(true);
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
            java.util.logging.Logger.getLogger(ViewTeste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTeste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTeste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTeste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewTeste().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCodigo;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSalvar1;
    private javax.swing.JComboBox<String> cbClassificacao;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbBuscar;
    private javax.swing.JLabel lbClassificacao;
    private javax.swing.JLabel lbCodTeste;
    private javax.swing.JLabel lbDescTeste;
    private javax.swing.JLabel lbEquipamento;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbImagem;
    private javax.swing.JLabel lbOrdem;
    private javax.swing.JTable tbTeste;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtCodTeste;
    private javax.swing.JTextField txtDescTeste;
    private javax.swing.JTextField txtEquipamento;
    private javax.swing.JTextField txtId;
    private javax.swing.JFormattedTextField txtOrdem;
    // End of variables declaration//GEN-END:variables
}

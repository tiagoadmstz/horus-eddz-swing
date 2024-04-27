package com.cooperstandard.views.extrusao;

import com.cooperstandard.views.qualidade.ViewFichaControleQualidade;
import com.cooperstandard.controller.extrusao.ControllerEquipamento;
import com.cooperstandard.controller.extrusao.ControllerOperacao;
import com.cooperstandard.views.principal.AguardeGerandoRelatório;
import com.cooperstandard.model.ModelEquipamento;
import com.cooperstandard.model.ModelOperacao;
import com.cooperstandard.util.ControleInstancias;
import com.cooperstandard.util.EstiloTablaRenderer;
import com.cooperstandard.util.HeaderRenderer;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
public class ViewEquipamento extends javax.swing.JFrame {

    ModelEquipamento modelEquipamento = new ModelEquipamento();
    ControllerEquipamento controllerEquipamento = new ControllerEquipamento();
    ControllerOperacao controllerOperacao = new ControllerOperacao();
    ArrayList<ModelOperacao> listaModelOperacao = new ArrayList<ModelOperacao>();
    ArrayList<ModelEquipamento> listaModelEquipamento = new ArrayList<ModelEquipamento>();
    String tipoCadastro;
    private JFrame solicitante = null;

    public ViewEquipamento() {
        initComponents();
        carregaEquipamento();
        listarOperacao();
        tbEquipamento.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbEquipamento));
        tbEquipamento.setDefaultRenderer(String.class, new EstiloTablaRenderer());
        tbEquipamento.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
    }

    public ViewEquipamento(JFrame frame) {
        initComponents();
        carregaEquipamento();
        listarOperacao();
        solicitante = frame;
        tbEquipamento.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbEquipamento));
        tbEquipamento.setDefaultRenderer(String.class, new EstiloTablaRenderer());
        tbEquipamento.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
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
        lbId = new javax.swing.JLabel();
        lbOperacao = new javax.swing.JLabel();
        cbOperacao = new javax.swing.JComboBox<>();
        txtBusca = new javax.swing.JTextField();
        lbImagem = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        txtId = new javax.swing.JFormattedTextField();
        lbId1 = new javax.swing.JLabel();
        txtEquipamento = new javax.swing.JTextField();
        lbEquipamento = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtOrdem = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEquipamento = new javax.swing.JTable();
        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Equipamento");

        jPanel3.setBackground(new java.awt.Color(2, 83, 161));

        jPanel1.setBackground(new java.awt.Color(241, 176, 19));

        lbOrdem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbOrdem.setText("Ordem:");

        lbId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbId.setText("Código:");

        lbOperacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbOperacao.setText("Operação:");

        cbOperacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbOperacao.setEnabled(false);

        txtBusca.setBackground(new java.awt.Color(255, 255, 204));
        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaKeyReleased(evt);
            }
        });

        lbImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-binóculos-filled-50.png"))); // NOI18N

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-pdf-2-filled-50.png"))); // NOI18N
        jButton3.setText("Visualizar/Imprimir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtId.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##########"))));
        txtId.setEnabled(false);

        lbId1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbId1.setText("Buscar:");

        txtEquipamento.setEnabled(false);

        lbEquipamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbEquipamento.setText("Equipamento:");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-adicionar-filled-50.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        txtOrdem.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("########"))));
        txtOrdem.setEnabled(false);

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
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbOrdem)
                            .addComponent(txtOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbOperacao)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEquipamento)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbEquipamento)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbId1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtBusca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbOrdem)
                            .addComponent(lbId)
                            .addComponent(lbOperacao)
                            .addComponent(lbEquipamento))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbOperacao)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(txtEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbId1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3)
                    .addComponent(lbImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbEquipamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Ordem", "Operação", "Equipamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
        tbEquipamento.setFocusable(false);
        tbEquipamento.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbEquipamento);
        if (tbEquipamento.getColumnModel().getColumnCount() > 0) {
            tbEquipamento.getColumnModel().getColumn(0).setMinWidth(0);
            tbEquipamento.getColumnModel().getColumn(0).setMaxWidth(0);
            tbEquipamento.getColumnModel().getColumn(1).setMinWidth(120);
            tbEquipamento.getColumnModel().getColumn(1).setMaxWidth(120);
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
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 325, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnAlterar)
                    .addComponent(btnNovo)
                    .addComponent(btnLimpar)
                    .addComponent(btnSalvar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyReleased

        DefaultTableModel tabela = (DefaultTableModel) this.tbEquipamento.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabela);
        this.tbEquipamento.setRowSorter(sorter);
        String text = txtBusca.getText();
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));

    }//GEN-LAST:event_txtBuscaKeyReleased

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (tipoCadastro.equals("novo")) {
            if (txtOrdem.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtOrdem.requestFocus();
            } else if (cbOperacao.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                cbOperacao.requestFocus();
            } else if (txtEquipamento.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtEquipamento.requestFocus();
            } else {
                salvarEquipamento();
            }
        } else if (tipoCadastro.equals("alteracao")) {
            if (txtOrdem.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtOrdem.requestFocus();
            } else if (cbOperacao.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                cbOperacao.requestFocus();
            } else if (txtEquipamento.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtEquipamento.requestFocus();
            } else {
                alterarEquipamento();
                btnSalvar.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        novoProjeto();
        btnSalvar.setEnabled(true);
        habilitarCampos();
        tipoCadastro = "novo";
        txtOrdem.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linhasselecionada = tbEquipamento.getSelectedRow();

        if (linhasselecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            novoProjeto();
            btnSalvar.setEnabled(true);
            habilitarCampos();
            recuperarEquipamento();
            tipoCadastro = "alteracao";

        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linhasselecionada = tbEquipamento.getSelectedRow();

        if (linhasselecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            this.excluirEquipamento();
            limparDados();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        this.desabilitarCampos();
        limparDados();
        btnSalvar.setEnabled(false);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        ViewOperacao vm = null;
        if (ControleInstancias.isInstaced(ViewOperacao.class)) {
            vm = (ViewOperacao) ControleInstancias.getInstance(ViewOperacao.class.getName(), ViewOperacao.class);
            vm.setSolicitante(this);
        } else {
            vm = new ViewOperacao(this);
        }
        vm.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        final AguardeGerandoRelatório carregando = new AguardeGerandoRelatório();
        carregando.setVisible(true);
        Thread t = new Thread() {
            public void run() {
                try {
                    String logo = "/images/logocooper.jpg";
                    
                    Connection con = new ConexaoSql().getCon();
                    Map p = new HashMap();
                    p.put("logo", this.getClass().getResourceAsStream(logo));
                    JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Relatorios/listagemequipamentoAC.jasper"));

                    JasperPrint print = JasperFillManager.fillReport(jr, p, con);
                    JasperViewer view = new JasperViewer(print, false);
                    view.setTitle("Equipamento");

                    view.setVisible(true);
                } catch (Exception erro) {

                    JOptionPane.showMessageDialog(null, "deu erro =" + erro);
                    System.out.println(erro);

                }
                carregando.dispose();
            }
        };
        t.start();
    }//GEN-LAST:event_jButton3ActionPerformed

    public void addItemLista(String item) {
        cbOperacao.addItem(item);
        listarOperacao();
    }

    private void listarOperacao() {
        listaModelOperacao = controllerOperacao.getListaOperacaoController();
        cbOperacao.removeAllItems();
        for (int i = 0; i < listaModelOperacao.size(); i++) {
            cbOperacao.addItem(listaModelOperacao.get(i).getOperacao());
        }
    }

    private void excluirEquipamento() {
        int linha = tbEquipamento.getSelectedRow();
        String nome = (String) tbEquipamento.getValueAt(linha, 3);
        int codigo = (Integer) tbEquipamento.getValueAt(linha, 0);
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
                + " excluir o registro \nNome: "
                + nome + " ?", "Atenção", JOptionPane.YES_OPTION);

        if (opcao == JOptionPane.OK_OPTION) {
            if (controllerEquipamento.excluirEquipamentoController(codigo)) {
                JOptionPane.showMessageDialog(this, "Registro excluido com sucesso!");
                if (solicitante != null) {
                    if (solicitante instanceof ViewTeste) {
                        ViewTeste vp = (ViewTeste) solicitante;
                        vp.addItemLista(txtEquipamento.getText());
                    } else if (solicitante instanceof ViewFichaControle) {
                        ViewFichaControle vp = (ViewFichaControle) solicitante;
                        vp.addItemLista(txtEquipamento.getText());
                    } else if (solicitante instanceof ViewFichaControleQualidade) {
                        ViewFichaControleQualidade vp = (ViewFichaControleQualidade) solicitante;
                        vp.addItemLista(txtEquipamento.getText());
                    }
                }
                carregaEquipamento();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean salvarEquipamento() {
        modelEquipamento.setOrdem(Integer.parseInt(this.txtOrdem.getText()));
        modelEquipamento.setEqu_operacao(this.cbOperacao.getSelectedItem().toString());
        modelEquipamento.setEquipamento(this.txtEquipamento.getText());
        if (controllerEquipamento.salvarEquipamentoController(modelEquipamento) > 0) {
            JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
            this.desabilitarCampos();
            this.carregaEquipamento();
            if (solicitante != null) {
                if (solicitante instanceof ViewTeste) {
                    ViewTeste vp = (ViewTeste) solicitante;
                    vp.addItemLista(txtEquipamento.getText());
                } else if (solicitante instanceof ViewFichaControle) {
                    ViewFichaControle vp = (ViewFichaControle) solicitante;
                    vp.addItemLista(txtEquipamento.getText());
                } else if (solicitante instanceof ViewFichaControleQualidade) {
                    ViewFichaControleQualidade vp = (ViewFichaControleQualidade) solicitante;
                    vp.addItemLista(txtEquipamento.getText());
                }
            }
            limparDados();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao tentar gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private boolean recuperarEquipamento() {
        int linha = this.tbEquipamento.getSelectedRow();
        int codigo = (Integer) tbEquipamento.getValueAt(linha, 0);
        try {
            modelEquipamento = controllerEquipamento.getEquipamentoController(codigo);
            this.txtId.setText(String.valueOf(modelEquipamento.getId_equipamento()));
            this.txtOrdem.setText(String.valueOf(modelEquipamento.getOrdem()));
            this.txtEquipamento.setText(modelEquipamento.getEquipamento());
            this.cbOperacao.setSelectedItem(modelEquipamento.getEqu_operacao());

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código inválido ou nenhum registro selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private boolean alterarEquipamento() {
        modelEquipamento.setId_equipamento(Integer.parseInt(this.txtId.getText()));
        modelEquipamento.setOrdem(Integer.parseInt(this.txtOrdem.getText()));
        modelEquipamento.setEqu_operacao(this.cbOperacao.getSelectedItem().toString());
        modelEquipamento.setEquipamento(this.txtEquipamento.getText());
        if (controllerEquipamento.atualizarEquipamentoController(modelEquipamento)) {
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
            this.desabilitarCampos();
            this.carregaEquipamento();
            if (solicitante != null) {
                if (solicitante instanceof ViewTeste) {
                    ViewTeste vp = (ViewTeste) solicitante;
                    vp.addItemLista(txtEquipamento.getText());
                } else if (solicitante instanceof ViewFichaControle) {
                    ViewFichaControle vp = (ViewFichaControle) solicitante;
                    vp.addItemLista(txtEquipamento.getText());
                } else if (solicitante instanceof ViewFichaControleQualidade) {
                    ViewFichaControleQualidade vp = (ViewFichaControleQualidade) solicitante;
                    vp.addItemLista(txtEquipamento.getText());
                }
            }
            limparDados();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void carregaEquipamento() {
        listaModelEquipamento = controllerEquipamento.getListaEquipamentoController();
        DefaultTableModel modelo = (DefaultTableModel) tbEquipamento.getModel();
        modelo.setNumRows(0);
        int cont = listaModelEquipamento.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelEquipamento.get(i).getId_equipamento(),
                listaModelEquipamento.get(i).getOrdem(),
                listaModelEquipamento.get(i).getEqu_operacao(),
                listaModelEquipamento.get(i).getEquipamento()

            });

        }

    }

    public void desabilitarCampos() {
        txtOrdem.setEnabled(false);
        txtEquipamento.setEnabled(false);
        cbOperacao.setEnabled(false);
    }

    public void limparDados() {
        txtOrdem.setText("");
        txtId.setText("");
        txtEquipamento.setText("");
        cbOperacao.setSelectedIndex(-1);
        txtBusca.setText("");
    }

    public void novoProjeto() {
        habilitarCampos();
        txtOrdem.setText("");
        txtEquipamento.setText("");
        cbOperacao.setSelectedIndex(-1);
        txtBusca.setText("");
        txtId.setText("Novo");
    }

    public void habilitarCampos() {
        txtOrdem.setEnabled(true);
        txtEquipamento.setEnabled(true);
        cbOperacao.setEnabled(true);
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
            java.util.logging.Logger.getLogger(ViewEquipamento.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewEquipamento.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewEquipamento.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewEquipamento.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewEquipamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbOperacao;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbEquipamento;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbId1;
    private javax.swing.JLabel lbImagem;
    private javax.swing.JLabel lbOperacao;
    private javax.swing.JLabel lbOrdem;
    private javax.swing.JTable tbEquipamento;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtEquipamento;
    private javax.swing.JFormattedTextField txtId;
    private javax.swing.JFormattedTextField txtOrdem;
    // End of variables declaration//GEN-END:variables
}

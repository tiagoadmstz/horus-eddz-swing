/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.views.principal;

import com.cooperstandard.controller.extrusao.ControllerPermissaousuario;
import com.cooperstandard.controller.extrusao.ControllerUsuario;
import com.cooperstandard.model.ModelPermissaousuario;
import com.cooperstandard.model.ModelUsuario;
import com.cooperstandard.util.EstiloTablaRenderer;
import com.cooperstandard.util.HeaderRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 * @author rsouza10
 */
public class ViewUsuario extends javax.swing.JFrame {

    private static final long serialVersionUID = -715113168908101656L;

    /**
     * Creates new form ViewUsuario1
     */
    public ViewUsuario() {
        initComponents();
        this.carregarUsuarios();
        this.cancelarOperacao();
        tbUsuario.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbUsuario));
        tbUsuario.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
        tbUsuario.setDefaultRenderer(String.class, new EstiloTablaRenderer());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneTipoProduto = new javax.swing.JTabbedPane();
        jpCadastro = new javax.swing.JPanel();
        jtfCodigo = new javax.swing.JTextField();
        lbId = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        lbNome = new javax.swing.JLabel();
        jbConfirmarAlteracao = new javax.swing.JButton();
        jbCadastrar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbNovo = new javax.swing.JButton();
        lbLogin = new javax.swing.JLabel();
        jtfConfirmarSenha = new javax.swing.JPasswordField();
        lbSenha = new javax.swing.JLabel();
        jtfSenha = new javax.swing.JPasswordField();
        lbConfSenha = new javax.swing.JLabel();
        jtfLogin = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jcbRelatorio = new javax.swing.JCheckBox();
        jbcPainelAlteracaoQU = new javax.swing.JCheckBox();
        jbcPainelAlteracaoAT = new javax.swing.JCheckBox();
        jcbPainelAlteracao = new javax.swing.JCheckBox();
        jbcPainelAlteracaoAC = new javax.swing.JCheckBox();
        jbcPainelAlteracaoEX = new javax.swing.JCheckBox();
        jcbCadastroFicha = new javax.swing.JCheckBox();
        jcbEntradaDados = new javax.swing.JCheckBox();
        jcbAlteracaoDados = new javax.swing.JCheckBox();
        jcbUsuario = new javax.swing.JCheckBox();
        jcbValidacao = new javax.swing.JCheckBox();
        jcbCadastroFichaAC = new javax.swing.JCheckBox();
        jcbCadastroFichaEX = new javax.swing.JCheckBox();
        jcbEntradaDadosAC = new javax.swing.JCheckBox();
        jcbEntradaDadosEX = new javax.swing.JCheckBox();
        jcbEntradaDadosSuperV = new javax.swing.JCheckBox();
        jcbCadastroFichaInsp = new javax.swing.JCheckBox();
        jbcPainelAlteracaoInsp = new javax.swing.JCheckBox();
        jcbEntradaDadosInspeção = new javax.swing.JCheckBox();
        cbSetor = new javax.swing.JComboBox<>();
        lbSetor = new javax.swing.JLabel();
        jtfNome1 = new javax.swing.JTextField();
        lbNome1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        lbLogin1 = new javax.swing.JLabel();
        lbLogin2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jpConsulta = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbUsuario = new javax.swing.JTable();
        jbExcluir = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jpCadastro.setBackground(new java.awt.Color(2, 83, 161));

        jtfCodigo.setEditable(false);
        jtfCodigo.setToolTipText("Código do tipo do produto");
        jtfCodigo.setEnabled(false);

        lbId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbId.setForeground(new java.awt.Color(255, 255, 255));
        lbId.setText("Código:");

        jtfNome.setToolTipText("Descrição do tipo do produto");

        lbNome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNome.setForeground(new java.awt.Color(255, 255, 255));
        lbNome.setText("Sobrenome:");

        jbConfirmarAlteracao.setBackground(new java.awt.Color(255, 255, 255));
        jbConfirmarAlteracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-salvar-filled-50.png"))); // NOI18N
        jbConfirmarAlteracao.setText("Salvar Alteração");
        jbConfirmarAlteracao.setToolTipText("Confirmar alteração no cadastro do tipo do produto");
        jbConfirmarAlteracao.setEnabled(false);
        jbConfirmarAlteracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmarAlteracaoActionPerformed(evt);
            }
        });

        jbCadastrar.setBackground(new java.awt.Color(255, 255, 255));
        jbCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-salvar-filled-50.png"))); // NOI18N
        jbCadastrar.setText("Salvar");
        jbCadastrar.setToolTipText("Salvar cadastro do tipo de produto");
        jbCadastrar.setEnabled(false);
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jbCancelar.setBackground(new java.awt.Color(255, 255, 255));
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-n¦o-perturbe-filled-50.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.setToolTipText("Cancelar operação");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbNovo.setBackground(new java.awt.Color(255, 255, 255));
        jbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-joyent-filled-20 (1).png"))); // NOI18N
        jbNovo.setText("Novo");
        jbNovo.setToolTipText("Limpar todos os campos");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        lbLogin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbLogin.setForeground(new java.awt.Color(255, 255, 255));
        lbLogin.setText("Login:");

        lbSenha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbSenha.setForeground(new java.awt.Color(255, 255, 255));
        lbSenha.setText("Senha:");

        lbConfSenha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbConfSenha.setForeground(new java.awt.Color(255, 255, 255));
        lbConfSenha.setText("Confirmar senha:");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Permissões"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jcbRelatorio.setBackground(new java.awt.Color(255, 255, 255));
        jcbRelatorio.setForeground(new java.awt.Color(0, 0, 255));
        jcbRelatorio.setText("Relatório");
        jPanel1.add(jcbRelatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, -1, -1));

        jbcPainelAlteracaoQU.setBackground(new java.awt.Color(255, 255, 255));
        jbcPainelAlteracaoQU.setText("Qualidade");
        jbcPainelAlteracaoQU.setEnabled(false);
        jPanel1.add(jbcPainelAlteracaoQU, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jbcPainelAlteracaoAT.setBackground(new java.awt.Color(255, 255, 255));
        jbcPainelAlteracaoAT.setText("Alteração em Massa");
        jbcPainelAlteracaoAT.setEnabled(false);
        jPanel1.add(jbcPainelAlteracaoAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, 20));

        jcbPainelAlteracao.setBackground(new java.awt.Color(255, 255, 255));
        jcbPainelAlteracao.setForeground(new java.awt.Color(0, 0, 255));
        jcbPainelAlteracao.setText("Painel de Alteração");
        jcbPainelAlteracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPainelAlteracaoActionPerformed(evt);
            }
        });
        jPanel1.add(jcbPainelAlteracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jbcPainelAlteracaoAC.setBackground(new java.awt.Color(255, 255, 255));
        jbcPainelAlteracaoAC.setText("Acabamento");
        jbcPainelAlteracaoAC.setEnabled(false);
        jPanel1.add(jbcPainelAlteracaoAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jbcPainelAlteracaoEX.setBackground(new java.awt.Color(255, 255, 255));
        jbcPainelAlteracaoEX.setText("Extrusão");
        jbcPainelAlteracaoEX.setEnabled(false);
        jPanel1.add(jbcPainelAlteracaoEX, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jcbCadastroFicha.setBackground(new java.awt.Color(255, 255, 255));
        jcbCadastroFicha.setForeground(new java.awt.Color(0, 0, 255));
        jcbCadastroFicha.setText("Cadastro");
        jcbCadastroFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCadastroFichaActionPerformed(evt);
            }
        });
        jPanel1.add(jcbCadastroFicha, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, -1));

        jcbEntradaDados.setBackground(new java.awt.Color(255, 255, 255));
        jcbEntradaDados.setForeground(new java.awt.Color(0, 0, 255));
        jcbEntradaDados.setText("Entrada de Dados");
        jcbEntradaDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEntradaDadosActionPerformed(evt);
            }
        });
        jPanel1.add(jcbEntradaDados, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        jcbAlteracaoDados.setBackground(new java.awt.Color(255, 255, 255));
        jcbAlteracaoDados.setForeground(new java.awt.Color(0, 0, 255));
        jcbAlteracaoDados.setText("Alteração de Dados");
        jPanel1.add(jcbAlteracaoDados, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, -1, -1));

        jcbUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jcbUsuario.setForeground(new java.awt.Color(0, 0, 255));
        jcbUsuario.setText("Usuário");
        jPanel1.add(jcbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, -1, -1));

        jcbValidacao.setBackground(new java.awt.Color(255, 255, 255));
        jcbValidacao.setForeground(new java.awt.Color(0, 0, 255));
        jcbValidacao.setText("Validação(Qualidade)");
        jPanel1.add(jcbValidacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, -1, -1));

        jcbCadastroFichaAC.setBackground(new java.awt.Color(255, 255, 255));
        jcbCadastroFichaAC.setText("Acabamento");
        jcbCadastroFichaAC.setEnabled(false);
        jPanel1.add(jcbCadastroFichaAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        jcbCadastroFichaEX.setBackground(new java.awt.Color(255, 255, 255));
        jcbCadastroFichaEX.setText("Extrusão");
        jcbCadastroFichaEX.setEnabled(false);
        jPanel1.add(jcbCadastroFichaEX, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));

        jcbEntradaDadosAC.setBackground(new java.awt.Color(255, 255, 255));
        jcbEntradaDadosAC.setText("Acabamento");
        jcbEntradaDadosAC.setEnabled(false);
        jPanel1.add(jcbEntradaDadosAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

        jcbEntradaDadosEX.setBackground(new java.awt.Color(255, 255, 255));
        jcbEntradaDadosEX.setText("Extrusão");
        jcbEntradaDadosEX.setEnabled(false);
        jPanel1.add(jcbEntradaDadosEX, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, -1));

        jcbEntradaDadosSuperV.setBackground(new java.awt.Color(255, 255, 255));
        jcbEntradaDadosSuperV.setText("Supervisório");
        jcbEntradaDadosSuperV.setEnabled(false);
        jPanel1.add(jcbEntradaDadosSuperV, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, -1));

        jcbCadastroFichaInsp.setBackground(new java.awt.Color(255, 255, 255));
        jcbCadastroFichaInsp.setText("Ponto de inspeção");
        jcbCadastroFichaInsp.setEnabled(false);
        jPanel1.add(jcbCadastroFichaInsp, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, -1));

        jbcPainelAlteracaoInsp.setBackground(new java.awt.Color(255, 255, 255));
        jbcPainelAlteracaoInsp.setText("Ponto de inspeção");
        jbcPainelAlteracaoInsp.setEnabled(false);
        jPanel1.add(jbcPainelAlteracaoInsp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, 20));

        jcbEntradaDadosInspeção.setBackground(new java.awt.Color(255, 255, 255));
        jcbEntradaDadosInspeção.setText("Ponto de inspeção");
        jcbEntradaDadosInspeção.setEnabled(false);
        jPanel1.add(jcbEntradaDadosInspeção, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, -1, -1));

        cbSetor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Laboratório", "Mixing", "Acabamento", "Extrusão", "Qualidade", "Desenvolvimento"}));

        lbSetor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbSetor.setForeground(new java.awt.Color(255, 255, 255));
        lbSetor.setText("Setor:");

        jtfNome1.setToolTipText("Descrição do tipo do produto");

        lbNome1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNome1.setForeground(new java.awt.Color(255, 255, 255));
        lbNome1.setText("Nome:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Varginha", "Atibaia"}));

        lbLogin1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbLogin1.setForeground(new java.awt.Color(255, 255, 255));
        lbLogin1.setText("Planta:");

        lbLogin2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbLogin2.setForeground(new java.awt.Color(255, 255, 255));
        lbLogin2.setText("E-mail:");

        javax.swing.GroupLayout jpCadastroLayout = new javax.swing.GroupLayout(jpCadastro);
        jpCadastro.setLayout(jpCadastroLayout);
        jpCadastroLayout.setHorizontalGroup(
                jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpCadastroLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jpCadastroLayout.createSequentialGroup()
                                                .addComponent(lbId)
                                                .addGap(62, 62, 62)
                                                .addComponent(lbNome1)
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCadastroLayout.createSequentialGroup()
                                                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jtfCodigo)
                                                                .addComponent(jComboBox1, 0, 93, Short.MAX_VALUE))
                                                        .addComponent(lbLogin1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jpCadastroLayout.createSequentialGroup()
                                                                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jtfNome1)
                                                                        .addGroup(jpCadastroLayout.createSequentialGroup()
                                                                                .addComponent(lbNome)
                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(jpCadastroLayout.createSequentialGroup()
                                                                                .addComponent(lbSetor)
                                                                                .addGap(100, 100, 100))
                                                                        .addGroup(jpCadastroLayout.createSequentialGroup()
                                                                                .addComponent(cbSetor, 0, 126, Short.MAX_VALUE)
                                                                                .addGap(16, 16, 16))))
                                                        .addGroup(jpCadastroLayout.createSequentialGroup()
                                                                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jtfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lbLogin))
                                                                .addGap(10, 10, 10)
                                                                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jtfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lbSenha))
                                                                .addGap(10, 10, 10)
                                                                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbConfSenha)
                                                                        .addComponent(jtfConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGroup(jpCadastroLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jpCadastroLayout.createSequentialGroup()
                                                .addComponent(jbCancelar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jbConfirmarAlteracao)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                                        .addGroup(jpCadastroLayout.createSequentialGroup()
                                                .addComponent(lbLogin2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtEmail)))
                                .addContainerGap(12, Short.MAX_VALUE))
        );
        jpCadastroLayout.setVerticalGroup(
                jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpCadastroLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jpCadastroLayout.createSequentialGroup()
                                                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lbId)
                                                        .addComponent(lbNome)
                                                        .addComponent(lbNome1))
                                                .addGap(6, 6, 6)
                                                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jtfNome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jpCadastroLayout.createSequentialGroup()
                                                .addComponent(lbSetor)
                                                .addGap(6, 6, 6)
                                                .addComponent(cbSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(20, 20, 20)
                                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jpCadastroLayout.createSequentialGroup()
                                                .addComponent(lbLogin1)
                                                .addGap(6, 6, 6)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jpCadastroLayout.createSequentialGroup()
                                                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lbSenha)
                                                        .addComponent(lbConfSenha)
                                                        .addComponent(lbLogin))
                                                .addGap(6, 6, 6)
                                                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jtfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jtfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jtfConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbLogin2)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbConfirmarAlteracao)
                                        .addComponent(jbCadastrar)
                                        .addComponent(jbNovo)
                                        .addComponent(jbCancelar))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneTipoProduto.addTab("Cadastro", jpCadastro);

        jpConsulta.setBackground(new java.awt.Color(2, 83, 161));

        tbUsuario.setAutoCreateRowSorter(true);
        tbUsuario.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null}
                },
                new String[]{
                        "Código", "Nome", "Login", "Setor", "Planta", "E-mail"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tbUsuario.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbUsuario.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbUsuario);
        if (tbUsuario.getColumnModel().getColumnCount() > 0) {
            tbUsuario.getColumnModel().getColumn(0).setMinWidth(80);
            tbUsuario.getColumnModel().getColumn(0).setMaxWidth(80);
            tbUsuario.getColumnModel().getColumn(1).setMinWidth(200);
            tbUsuario.getColumnModel().getColumn(1).setMaxWidth(200);
            tbUsuario.getColumnModel().getColumn(2).setMinWidth(150);
            tbUsuario.getColumnModel().getColumn(2).setMaxWidth(150);
            tbUsuario.getColumnModel().getColumn(3).setMinWidth(80);
            tbUsuario.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        jbExcluir.setBackground(new java.awt.Color(255, 255, 255));
        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-excluir-filled-50.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.setToolTipText("Excluir tipo de produto selecionado");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jButtonAlterar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-editar-filled-50.png"))); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setToolTipText("Alterar tipo de produto selecionado");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpConsultaLayout = new javax.swing.GroupLayout(jpConsulta);
        jpConsulta.setLayout(jpConsultaLayout);
        jpConsultaLayout.setHorizontalGroup(
                jpConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpConsultaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jpConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                                        .addGroup(jpConsultaLayout.createSequentialGroup()
                                                .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jpConsultaLayout.setVerticalGroup(
                jpConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpConsultaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbExcluir)
                                        .addComponent(jButtonAlterar))
                                .addGap(6, 6, 6))
        );

        jTabbedPaneTipoProduto.addTab("Consulta/Alteração/Exclusão", jpConsulta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPaneTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPaneTipoProduto)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbConfirmarAlteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmarAlteracaoActionPerformed
        if (this.jtfNome.getText().equals("") || this.jtfLogin.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Você deve informar o nome para salvar!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String senha, confirmaSenha;
        senha = new String(this.jtfSenha.getPassword());
        confirmaSenha = new String(this.jtfConfirmarSenha.getPassword());

        //testa se as senhas são iguais
        if (senha.equals(confirmaSenha)) {
            this.alterarUsuario();
            limpaCampos();

        } else {
            JOptionPane.showMessageDialog(rootPane, "As senhas digitadas não conferem!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbConfirmarAlteracaoActionPerformed

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        if (this.jtfNome.getText().equals("") || this.jtfLogin.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Você deve informar o nome para salvar!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String senha, confirmaSenha;
        senha = new String(this.jtfSenha.getPassword());
        confirmaSenha = new String(this.jtfConfirmarSenha.getPassword());

        //testa se as senhas são iguais
        if (senha.equals(confirmaSenha)) {
            this.salvarUsuario();
        } else {
            JOptionPane.showMessageDialog(rootPane, "As senhas digitadas não conferem!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
        //salvar tipo produto
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        limpaCampos();
        desabilitarCampos();
        jbConfirmarAlteracao.setEnabled(false);
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        jtfCodigo.setEditable(false);
        this.jbCadastrar.setEnabled(true);
        jbConfirmarAlteracao.setEnabled(false);
        novoUsuario();
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jcbPainelAlteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPainelAlteracaoActionPerformed
        if (jcbPainelAlteracao.isSelected()) {
            jbcPainelAlteracaoAC.setEnabled(true);
            jbcPainelAlteracaoEX.setEnabled(true);
            jbcPainelAlteracaoQU.setEnabled(true);
            jbcPainelAlteracaoAT.setEnabled(true);
            jbcPainelAlteracaoInsp.setEnabled(true);
        } else {
            jbcPainelAlteracaoAC.setEnabled(false);
            jbcPainelAlteracaoEX.setEnabled(false);
            jbcPainelAlteracaoQU.setEnabled(false);
            jbcPainelAlteracaoAT.setEnabled(false);
            jbcPainelAlteracaoInsp.setEnabled(false);
        }
    }//GEN-LAST:event_jcbPainelAlteracaoActionPerformed

    private void jcbCadastroFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCadastroFichaActionPerformed
        if (jcbCadastroFicha.isSelected()) {
            jcbCadastroFichaAC.setEnabled(true);
            jcbCadastroFichaEX.setEnabled(true);
            jcbCadastroFichaInsp.setEnabled(true);
        } else {
            jcbCadastroFichaAC.setEnabled(false);
            jcbCadastroFichaEX.setEnabled(false);
            jcbCadastroFichaInsp.setEnabled(false);
        }
    }//GEN-LAST:event_jcbCadastroFichaActionPerformed

    private void jcbEntradaDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEntradaDadosActionPerformed
        if (jcbEntradaDados.isSelected()) {
            jcbEntradaDadosAC.setEnabled(true);
            jcbEntradaDadosEX.setEnabled(true);
            jcbEntradaDadosSuperV.setEnabled(true);
            jcbEntradaDadosInspeção.setEnabled(true);

        } else {
            jcbEntradaDadosAC.setEnabled(false);
            jcbEntradaDadosEX.setEnabled(false);
            jcbEntradaDadosSuperV.setEnabled(false);
            jcbEntradaDadosInspeção.setEnabled(false);
        }
    }//GEN-LAST:event_jcbEntradaDadosActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        int linha = tbUsuario.getSelectedRow();
        String nome = (String) tbUsuario.getValueAt(linha, 1);
        int codigo = (int) tbUsuario.getValueAt(linha, 0);

        ControllerUsuario controllerUsuario = new ControllerUsuario();
        ControllerPermissaousuario controllerPermissaousuario = new ControllerPermissaousuario();
        //pegunta se realmente deseja excluir o tipo de produto
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
                + " excluir o usuário:\n" + "\n " + nome + "?", "Atenção", JOptionPane.YES_NO_OPTION);
        //se sim exclui, se não não faz nada
        if (opcao == JOptionPane.OK_OPTION) {
            if (controllerUsuario.excluirUsuarioController(codigo)) {
                controllerPermissaousuario.excluirPermissaousuarioController(codigo);
                JOptionPane.showMessageDialog(this, "Registro excluido com suscesso!");
                this.carregarUsuarios();
                this.novoUsuario();
            }
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        desativarPermissao();
        this.recuperarUsuario();
        this.habilitarCampos();

        //abilita botão da interface
        jtfCodigo.setEditable(false);
        this.jbCadastrar.setEnabled(false);
        jbConfirmarAlteracao.setEnabled(true);

        //volta a aba anterior
        this.jTabbedPaneTipoProduto.setSelectedIndex(this.jTabbedPaneTipoProduto.getSelectedIndex() - 1);
        check();
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private boolean salvarUsuario() {
        ModelUsuario modelUsuario = new ModelUsuario();
        int codigousuario;
        ControllerUsuario controllerUsuario = new ControllerUsuario();
        ControllerPermissaousuario controllerPermissaousuario = new ControllerPermissaousuario();
        modelUsuario.setNome(this.jtfNome.getText());
        modelUsuario.setLogin(this.jtfLogin.getText());
        modelUsuario.setSenha(new String(this.jtfSenha.getPassword()));
        modelUsuario.setSetor(this.cbSetor.getSelectedItem().toString());
        modelUsuario.setSobrenome(this.jtfNome1.getText());
        modelUsuario.setPlanta(this.jComboBox1.getSelectedItem().toString());
        modelUsuario.setEmail(this.txtEmail.getText());
        codigousuario = controllerUsuario.salvarUsuarioController(modelUsuario);
        if (codigousuario > 0) {
            controllerPermissaousuario.salvarPermissaousuarioController(setardadosPermissaoUsuario(codigousuario));
            JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
            this.cancelarOperacao();
            this.carregarUsuarios();
            this.novoUsuario();
            jTabbedPaneTipoProduto.setSelectedIndex(jTabbedPaneTipoProduto.getSelectedIndex() + 1);
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    public ModelPermissaousuario setardadosPermissaoUsuario(int pCodigoUsuario) {
        ArrayList<ModelPermissaousuario> listaModelPermissaousuarios = new ArrayList<>();
        ModelPermissaousuario modelPermissaousuario = new ModelPermissaousuario();
        modelPermissaousuario = new ModelPermissaousuario();
        if (jbcPainelAlteracaoAC.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("PainelAlteracaoAC");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (jbcPainelAlteracaoEX.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("PainelAlteracaoEX");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (jbcPainelAlteracaoQU.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("PainelAlteracaoQU");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (jbcPainelAlteracaoAT.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("PainelAlteracaoAT");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (jbcPainelAlteracaoInsp.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("PainelAlteracaoInsp");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (jcbCadastroFichaAC.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("CadastroFichaAC");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (jcbCadastroFichaEX.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("CadastroFichaEX");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (jcbCadastroFichaInsp.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("CadastroFichaInsp");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (jcbEntradaDadosAC.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("EntradaDadosAC");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (jcbEntradaDadosEX.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("EntradaDadosEX");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (jcbEntradaDadosSuperV.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("EntradaDadosSuperV");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (jcbEntradaDadosInspeção.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("EntradaDadosInsp");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (jcbAlteracaoDados.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("AlteracaoDados");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (jcbValidacao.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("Validacao");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (jcbRelatorio.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("MenuRelatorio");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }
        if (jcbUsuario.isSelected()) {
            modelPermissaousuario = new ModelPermissaousuario();
            modelPermissaousuario.setCodigo_usuario(pCodigoUsuario);
            modelPermissaousuario.setPermissao("MenuUsuario");
            listaModelPermissaousuarios.add(modelPermissaousuario);
        }

        modelPermissaousuario.setListaModelPermissaousuarios(listaModelPermissaousuarios);
        return modelPermissaousuario;
    }

    private boolean alterarUsuario() {
        ModelUsuario modelUsuario = new ModelUsuario();
        ControllerPermissaousuario controllerPermissaousuario = new ControllerPermissaousuario();
        ControllerUsuario controllerUsuario = new ControllerUsuario();
        modelUsuario.setCodigo(Integer.parseInt(this.jtfCodigo.getText()));
        modelUsuario.setNome(this.jtfNome.getText());
        modelUsuario.setLogin(this.jtfLogin.getText());
        modelUsuario.setSetor(this.cbSetor.getSelectedItem().toString());
        modelUsuario.setSenha(new String(this.jtfSenha.getPassword()));
        modelUsuario.setSobrenome(this.jtfNome1.getText());
        modelUsuario.setPlanta(this.jComboBox1.getSelectedItem().toString());
        modelUsuario.setEmail(txtEmail.getText());
        if (controllerUsuario.atualizarUsuarioController(modelUsuario)) {
            controllerPermissaousuario.excluirPermissaousuarioController(modelUsuario.getCodigo());
            controllerPermissaousuario.salvarPermissaousuarioController(setardadosPermissaoUsuario(modelUsuario.getCodigo()));
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
            this.cancelarOperacao();
            this.carregarUsuarios();
            jTabbedPaneTipoProduto.setSelectedIndex(jTabbedPaneTipoProduto.getSelectedIndex() + 1);
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    private void cancelarOperacao() {
        desabilitarCampos();
    }

    private void carregarUsuarios() {
        ArrayList<ModelUsuario> listaUsuarios = new ArrayList<>();
        ControllerUsuario controllerUsuario = new ControllerUsuario();
        listaUsuarios = controllerUsuario.getListaUsuarioController();

        DefaultTableModel modelo = (DefaultTableModel) tbUsuario.getModel();
        modelo.setNumRows(0);

        //CARREGA OS DADOS DA LISTA NA TABELA
        int cont = listaUsuarios.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                    listaUsuarios.get(i).getCodigo(),
                    listaUsuarios.get(i).getNome(),
                    listaUsuarios.get(i).getLogin(),
                    listaUsuarios.get(i).getSetor(),
                    listaUsuarios.get(i).getPlanta(),
                    listaUsuarios.get(i).getEmail()
            });
        }
    }

    private boolean recuperarUsuario() {
        ModelUsuario modelUsuario = new ModelUsuario();
        ControllerUsuario controllerUsuario = new ControllerUsuario();
        ControllerPermissaousuario controllerPermissaousuario = new ControllerPermissaousuario();
        ArrayList<ModelPermissaousuario> listaModelPermissaousuarios = new ArrayList<>();
        //recebe a linha selecionada
        int linha = this.tbUsuario.getSelectedRow();
        //pega o codigo do cliente na linha selecionada
        int codigo = (Integer) tbUsuario.getValueAt(linha, 0);
        try {
            //recupera os dados do banco
            modelUsuario = controllerUsuario.getUsuarioController(codigo);
            listaModelPermissaousuarios = controllerPermissaousuario.getListaPermissaousuarioController(codigo);
            //seta os dados na interface
            this.jtfCodigo.setText(String.valueOf(modelUsuario.getCodigo()));
            this.jtfNome.setText(modelUsuario.getNome());
            this.jtfLogin.setText(modelUsuario.getLogin());
            this.jtfSenha.setText(modelUsuario.getSenha());
            this.jtfConfirmarSenha.setText(modelUsuario.getSenha());
            this.cbSetor.setSelectedItem(modelUsuario.getSetor());
            this.jtfNome1.setText(modelUsuario.getSobrenome());
            this.jComboBox1.setSelectedItem(modelUsuario.getPlanta());
            this.txtEmail.setText(modelUsuario.getEmail());
            //preencher permissoes
            for (int i = 0; i < listaModelPermissaousuarios.size(); i++) {
                if (listaModelPermissaousuarios.get(i).getPermissao().equals("PainelAlteracaoAC")) {
                    jbcPainelAlteracaoAC.setSelected(true);
                }
                if (listaModelPermissaousuarios.get(i).getPermissao().equals("PainelAlteracaoEX")) {
                    jbcPainelAlteracaoEX.setSelected(true);
                }
                if (listaModelPermissaousuarios.get(i).getPermissao().equals("PainelAlteracaoQU")) {
                    jbcPainelAlteracaoQU.setSelected(true);
                }
                if (listaModelPermissaousuarios.get(i).getPermissao().equals("PainelAlteracaoAT")) {
                    jbcPainelAlteracaoAT.setSelected(true);
                }
                if (listaModelPermissaousuarios.get(i).getPermissao().equals("PainelAlteracaoInsp")) {
                    jbcPainelAlteracaoInsp.setSelected(true);
                }
                if (listaModelPermissaousuarios.get(i).getPermissao().equals("CadastroFichaAC")) {
                    jcbCadastroFichaAC.setSelected(true);
                }
                if (listaModelPermissaousuarios.get(i).getPermissao().equals("CadastroFichaEX")) {
                    jcbCadastroFichaEX.setSelected(true);
                }
                if (listaModelPermissaousuarios.get(i).getPermissao().equals("CadastroFichaInsp")) {
                    jcbCadastroFichaInsp.setSelected(true);
                }
                if (listaModelPermissaousuarios.get(i).getPermissao().equals("EntradaDadosAC")) {
                    jcbEntradaDadosAC.setSelected(true);
                }
                if (listaModelPermissaousuarios.get(i).getPermissao().equals("EntradaDadosEX")) {
                    jcbEntradaDadosEX.setSelected(true);
                }
                if (listaModelPermissaousuarios.get(i).getPermissao().equals("EntradaDadosSuperV")) {
                    jcbEntradaDadosSuperV.setSelected(true);
                }
                if (listaModelPermissaousuarios.get(i).getPermissao().equals("EntradaDadosInsp")) {
                    jcbEntradaDadosInspeção.setSelected(true);
                }
                if (listaModelPermissaousuarios.get(i).getPermissao().equals("AlteracaoDados")) {
                    jcbAlteracaoDados.setSelected(true);
                }
                if (listaModelPermissaousuarios.get(i).getPermissao().equals("Validacao")) {
                    jcbValidacao.setSelected(true);
                }
                if (listaModelPermissaousuarios.get(i).getPermissao().equals("MenuRelatorio")) {
                    jcbRelatorio.setSelected(true);
                }
                if (listaModelPermissaousuarios.get(i).getPermissao().equals("MenuUsuario")) {
                    jcbUsuario.setSelected(true);
                }

            }

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código inválido ou nenhum registro selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }

    }

    protected void desabilitarCampos() {
        jtfNome.setEnabled(false);
        jtfCodigo.setEnabled(false);
        jtfLogin.setEnabled(false);
        jtfSenha.setEnabled(false);
        jtfConfirmarSenha.setEnabled(false);
        cbSetor.setEnabled(false);
        cbSetor.setSelectedIndex(-1);
        jtfNome1.setEnabled(false);
        jComboBox1.setEnabled(false);
        txtEmail.setEnabled(false);
        jComboBox1.setSelectedIndex(-1);
        carregarUsuarios();
    }

    private void novoUsuario() {
        habilitarCampos();
        jtfCodigo.setText("Novo");
        jtfNome.setText("");
        jtfLogin.setText("");
        jtfSenha.setText("");
        jtfConfirmarSenha.setText("");
        txtEmail.setText("");
        cbSetor.setSelectedIndex(-1);
        jComboBox1.setSelectedIndex(-1);
        jtfNome1.setText("");
        txtEmail.setText("");
        desativarPermissao();

    }

    private void desativarPermissao() {

        jcbPainelAlteracao.setSelected(false);
        jcbCadastroFicha.setSelected(false);
        jcbEntradaDados.setSelected(false);
        jcbAlteracaoDados.setSelected(false);
        jcbValidacao.setSelected(false);
        jcbRelatorio.setSelected(false);
        jcbUsuario.setSelected(false);
        jbcPainelAlteracaoAC.setSelected(false);
        jbcPainelAlteracaoEX.setSelected(false);
        jbcPainelAlteracaoQU.setSelected(false);
        jbcPainelAlteracaoAT.setSelected(false);
        jcbCadastroFichaAC.setSelected(false);
        jcbCadastroFichaEX.setSelected(false);
        jcbEntradaDadosAC.setSelected(false);
        jcbEntradaDadosEX.setSelected(false);
        jcbEntradaDadosSuperV.setSelected(false);
        jbcPainelAlteracaoAC.setEnabled(false);
        jbcPainelAlteracaoEX.setEnabled(false);
        jbcPainelAlteracaoQU.setEnabled(false);
        jbcPainelAlteracaoAT.setEnabled(false);
        jcbCadastroFichaAC.setEnabled(false);
        jcbCadastroFichaEX.setEnabled(false);
        jcbEntradaDadosAC.setEnabled(false);
        jcbEntradaDadosEX.setEnabled(false);
        jcbEntradaDadosSuperV.setEnabled(false);
        jbcPainelAlteracaoInsp.setEnabled(false);
        jcbEntradaDadosInspeção.setEnabled(false);
        jcbCadastroFichaInsp.setSelected(false);
        jbcPainelAlteracaoInsp.setSelected(false);
        jcbEntradaDadosInspeção.setSelected(false);
    }

    private void habilitarCampos() {
        jtfNome.setEnabled(true);
        jtfCodigo.setEnabled(false);
        jtfLogin.setEnabled(true);
        jtfSenha.setEnabled(true);
        jtfConfirmarSenha.setEnabled(true);
        cbSetor.setEnabled(true);
        jtfNome1.setEnabled(true);
        jComboBox1.setEnabled(true);
        txtEmail.setEnabled(true);
        carregarUsuarios();
    }

    public void limpaCampos() {
        jtfNome.setText("");
        cbSetor.setSelectedIndex(-1);
        jtfLogin.setText("");
        jtfSenha.setText("");
        jtfConfirmarSenha.setText("");
        jtfNome1.setText("");
        jComboBox1.setSelectedIndex(-1);
        jtfCodigo.setText("");
        jbCadastrar.setEnabled(false);
        jcbPainelAlteracao.setSelected(false);
        jcbCadastroFicha.setSelected(false);
        jcbEntradaDados.setSelected(false);
        jcbAlteracaoDados.setSelected(false);
        jcbValidacao.setSelected(false);
        jcbRelatorio.setSelected(false);
        jcbUsuario.setSelected(false);
        jcbEntradaDadosAC.setSelected(false);
        jcbEntradaDadosEX.setSelected(false);
        jcbEntradaDadosSuperV.setSelected(false);
        jbcPainelAlteracaoAC.setSelected(false);
        jbcPainelAlteracaoEX.setSelected(false);
        jbcPainelAlteracaoQU.setSelected(false);
        jbcPainelAlteracaoAT.setSelected(false);
        jcbCadastroFichaAC.setSelected(false);
        jcbCadastroFichaEX.setSelected(false);
        jbcPainelAlteracaoAC.setEnabled(false);
        jbcPainelAlteracaoEX.setEnabled(false);
        jbcPainelAlteracaoQU.setEnabled(false);
        jbcPainelAlteracaoAT.setEnabled(false);
        jcbCadastroFichaAC.setEnabled(false);
        jcbCadastroFichaEX.setEnabled(false);
        jcbEntradaDadosAC.setEnabled(false);
        jcbEntradaDadosEX.setEnabled(false);
        jcbEntradaDadosSuperV.setEnabled(false);
        jbcPainelAlteracaoInsp.setEnabled(false);
        jcbEntradaDadosInspeção.setEnabled(false);
        jcbCadastroFichaInsp.setEnabled(false);
        jcbEntradaDadosSuperV.setEnabled(false);
        jbcPainelAlteracaoInsp.setSelected(false);
        jcbEntradaDadosInspeção.setSelected(false);
        jcbCadastroFichaInsp.setSelected(false);
    }

    public void check() {
        if (jbcPainelAlteracaoAC.isSelected() || jbcPainelAlteracaoEX.isSelected() || jbcPainelAlteracaoQU.isSelected() || jbcPainelAlteracaoAT.isSelected()) {
            jcbPainelAlteracao.setSelected(true);
            jbcPainelAlteracaoAC.setEnabled(true);
            jbcPainelAlteracaoEX.setEnabled(true);
            jbcPainelAlteracaoQU.setEnabled(true);
            jbcPainelAlteracaoAT.setEnabled(true);
            jbcPainelAlteracaoInsp.setEnabled(true);
        }
        if (jcbCadastroFichaAC.isSelected() || jcbCadastroFichaEX.isSelected()) {
            jcbCadastroFicha.setSelected(true);
            jcbCadastroFichaAC.setEnabled(true);
            jcbCadastroFichaEX.setEnabled(true);
            jcbCadastroFichaInsp.setEnabled(true);
        }
        if (jcbEntradaDadosAC.isSelected() || jcbEntradaDadosEX.isSelected() || jcbEntradaDadosSuperV.isSelected()) {
            jcbEntradaDados.setSelected(true);
            jcbEntradaDadosAC.setEnabled(true);
            jcbEntradaDadosEX.setEnabled(true);
            jcbEntradaDadosSuperV.setEnabled(true);
            jcbEntradaDadosInspeção.setEnabled(true);
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
            java.util.logging.Logger.getLogger(ViewUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbSetor;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPaneTipoProduto;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbConfirmarAlteracao;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbNovo;
    private javax.swing.JCheckBox jbcPainelAlteracaoAC;
    private javax.swing.JCheckBox jbcPainelAlteracaoAT;
    private javax.swing.JCheckBox jbcPainelAlteracaoEX;
    private javax.swing.JCheckBox jbcPainelAlteracaoInsp;
    private javax.swing.JCheckBox jbcPainelAlteracaoQU;
    private javax.swing.JCheckBox jcbAlteracaoDados;
    private javax.swing.JCheckBox jcbCadastroFicha;
    private javax.swing.JCheckBox jcbCadastroFichaAC;
    private javax.swing.JCheckBox jcbCadastroFichaEX;
    private javax.swing.JCheckBox jcbCadastroFichaInsp;
    private javax.swing.JCheckBox jcbEntradaDados;
    private javax.swing.JCheckBox jcbEntradaDadosAC;
    private javax.swing.JCheckBox jcbEntradaDadosEX;
    private javax.swing.JCheckBox jcbEntradaDadosInspeção;
    private javax.swing.JCheckBox jcbEntradaDadosSuperV;
    private javax.swing.JCheckBox jcbPainelAlteracao;
    private javax.swing.JCheckBox jcbRelatorio;
    private javax.swing.JCheckBox jcbUsuario;
    private javax.swing.JCheckBox jcbValidacao;
    private javax.swing.JPanel jpCadastro;
    private javax.swing.JPanel jpConsulta;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JPasswordField jtfConfirmarSenha;
    private javax.swing.JTextField jtfLogin;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfNome1;
    private javax.swing.JPasswordField jtfSenha;
    private javax.swing.JLabel lbConfSenha;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbLogin1;
    private javax.swing.JLabel lbLogin2;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNome1;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lbSetor;
    private javax.swing.JTable tbUsuario;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables
}

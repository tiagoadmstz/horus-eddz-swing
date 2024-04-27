package com.cooperstandard.views.extrusao;

import com.cooperstandard.services.UserRestService;
import com.cooperstandard.util.ControleInstancias;
import com.cooperstandard.views.acabamento.ViewAcabamento;
import com.cooperstandard.views.acabamento.ViewControleProcessoAc;
import com.cooperstandard.views.acabamento.ViewEquipamentoAc;
import com.cooperstandard.views.acabamento.ViewLinhaAc;
import com.cooperstandard.views.acabamento.ViewMaterialAc;
import com.cooperstandard.views.acabamento.ViewOperacaoAc;
import com.cooperstandard.views.acabamento.ViewTesteAc;
import com.cooperstandard.views.principal.ViewRelatorio;
import com.cooperstandard.views.principal.ViewResultadoLab;
import com.cooperstandard.views.principal.ViewUsuario;
import com.cooperstandard.views.qualidade.ViewAlteracaoMassa;
import com.cooperstandard.views.qualidade.ViewQualidade;
import com.cooperstandard.views.qualidade.ViewValidacao;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

@Getter
public final class ViewExtrusao extends javax.swing.JFrame {

    private final UserRestService userRestService;
    public final String linha;

    public ViewExtrusao() {
        initComponents();
        userRestService = new UserRestService(this);
        jMenuItem23.setVisible(false);
//        arduino.initialize();
        linha = userRestService.configureLine();
//        atualizateste();
        userRestService.liberarModulos();
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(new GridLayout());
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(null,
                        "Tem certeza que deseja fechar esta aplicação? ", " Realmente fechar? ",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }

            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuPnAlteracao = new javax.swing.JMenu();
        PainelAlteracaoAC = new javax.swing.JMenuItem();
        PainelAlteracaoEX = new javax.swing.JMenuItem();
        PainelAlteracaoQU = new javax.swing.JMenuItem();
        PainelAlteracaoAT = new javax.swing.JMenuItem();
        MenuCadFicha = new javax.swing.JMenu();
        CadastroFichaAC = new javax.swing.JMenu();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenuItem31 = new javax.swing.JMenuItem();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenuItem33 = new javax.swing.JMenuItem();
        jMenuItem34 = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        jMenuItem36 = new javax.swing.JMenuItem();
        jMenuItem37 = new javax.swing.JMenuItem();
        CadastroFichaEX = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        MenuEntradaDados = new javax.swing.JMenu();
        EntradaDadosAC = new javax.swing.JMenuItem();
        EntradaDadosEX = new javax.swing.JMenuItem();
        EntradaDadosSuperV = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem20 = new javax.swing.JMenuItem();
        MenuAlteracaoDados = new javax.swing.JMenu();
        AlteracaoDados = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        MenuValidacao = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        MenuRelatorio = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        MenuUsuario = new javax.swing.JMenu();
        jMenuItem40 = new javax.swing.JMenuItem();
        MenuSair = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logocooper.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 1002, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(604, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addContainerGap())
        );

        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        MenuPnAlteracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8_sync_settings_32px.png"))); // NOI18N
        MenuPnAlteracao.setText("Painel");
        MenuPnAlteracao.setContentAreaFilled(false);
        MenuPnAlteracao.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuPnAlteracao.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        MenuPnAlteracao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuPnAlteracaoMouseClicked(evt);
            }
        });

        PainelAlteracaoAC.setText("Acabamento");
        PainelAlteracaoAC.setEnabled(false);
        PainelAlteracaoAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PainelAlteracaoACActionPerformed(evt);
            }
        });
        MenuPnAlteracao.add(PainelAlteracaoAC);

        PainelAlteracaoEX.setText("Extrusão");
        PainelAlteracaoEX.setEnabled(false);
        PainelAlteracaoEX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PainelAlteracaoEXActionPerformed(evt);
            }
        });
        MenuPnAlteracao.add(PainelAlteracaoEX);

        PainelAlteracaoQU.setText("Qualidade");
        PainelAlteracaoQU.setEnabled(false);
        PainelAlteracaoQU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PainelAlteracaoQUActionPerformed(evt);
            }
        });
        MenuPnAlteracao.add(PainelAlteracaoQU);

        PainelAlteracaoAT.setText("Alteração em Massa");
        PainelAlteracaoAT.setEnabled(false);
        PainelAlteracaoAT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PainelAlteracaoATActionPerformed(evt);
            }
        });
        MenuPnAlteracao.add(PainelAlteracaoAT);

        jMenuBar1.add(MenuPnAlteracao);

        MenuCadFicha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8_administrative_tools_32px.png"))); // NOI18N
        MenuCadFicha.setText("Cadastro");
        MenuCadFicha.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        CadastroFichaAC.setText("Acabamento");
        CadastroFichaAC.setEnabled(false);

        jMenuItem30.setText("OEM");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        CadastroFichaAC.add(jMenuItem30);

        jMenuItem31.setText("Projeto");
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        CadastroFichaAC.add(jMenuItem31);

        jMenuItem32.setText("Célula");
        jMenuItem32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem32ActionPerformed(evt);
            }
        });
        CadastroFichaAC.add(jMenuItem32);

        jMenuItem33.setText("Operação");
        jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem33ActionPerformed(evt);
            }
        });
        CadastroFichaAC.add(jMenuItem33);

        jMenuItem34.setText("Equipamento");
        jMenuItem34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem34ActionPerformed(evt);
            }
        });
        CadastroFichaAC.add(jMenuItem34);

        jMenuItem35.setText("Material");
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        CadastroFichaAC.add(jMenuItem35);

        jMenuItem36.setText("Teste");
        jMenuItem36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem36ActionPerformed(evt);
            }
        });
        CadastroFichaAC.add(jMenuItem36);

        jMenuItem37.setText("Controle de processo");
        jMenuItem37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem37ActionPerformed(evt);
            }
        });
        CadastroFichaAC.add(jMenuItem37);

        MenuCadFicha.add(CadastroFichaAC);

        CadastroFichaEX.setText("Extrusão");
        CadastroFichaEX.setEnabled(false);

        jMenuItem11.setText("Montadora");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        CadastroFichaEX.add(jMenuItem11);

        jMenuItem12.setText("Projeto");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        CadastroFichaEX.add(jMenuItem12);

        jMenuItem13.setText("Linha");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        CadastroFichaEX.add(jMenuItem13);

        jMenuItem14.setText("Operação");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        CadastroFichaEX.add(jMenuItem14);

        jMenuItem15.setText("Equipamento");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        CadastroFichaEX.add(jMenuItem15);

        jMenuItem16.setText("Material");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        CadastroFichaEX.add(jMenuItem16);

        jMenuItem17.setText("Teste");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        CadastroFichaEX.add(jMenuItem17);

        jMenuItem9.setText("Composto");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        CadastroFichaEX.add(jMenuItem9);

        jMenuItem21.setText("Problema");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        CadastroFichaEX.add(jMenuItem21);

        jMenuItem22.setText("Causa");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        CadastroFichaEX.add(jMenuItem22);

        jMenuItem25.setText("Controle de processo");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        CadastroFichaEX.add(jMenuItem25);

        jMenuItem6.setText("Configuração de perfil");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        CadastroFichaEX.add(jMenuItem6);

        MenuCadFicha.add(CadastroFichaEX);

        jMenuBar1.add(MenuCadFicha);

        MenuEntradaDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8_document_32px.png"))); // NOI18N
        MenuEntradaDados.setText("Input de dado");
        MenuEntradaDados.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        EntradaDadosAC.setText("Acabamento");
        EntradaDadosAC.setEnabled(false);
        MenuEntradaDados.add(EntradaDadosAC);

        EntradaDadosEX.setText("Extrusão");
        EntradaDadosEX.setEnabled(false);
        EntradaDadosEX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntradaDadosEXActionPerformed(evt);
            }
        });
        MenuEntradaDados.add(EntradaDadosEX);

        EntradaDadosSuperV.setText("Supervisório");
        EntradaDadosSuperV.setEnabled(false);
        EntradaDadosSuperV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntradaDadosSuperVActionPerformed(evt);
            }
        });
        MenuEntradaDados.add(EntradaDadosSuperV);

        jMenuItem24.setText("Produção manual");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        MenuEntradaDados.add(jMenuItem24);

        jMenuItem5.setText("Estudo de encolhimento");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        MenuEntradaDados.add(jMenuItem5);

        jMenuItem7.setText("DDZ");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        MenuEntradaDados.add(jMenuItem7);

        jMenuItem23.setText("Gerenciador DDZ");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        MenuEntradaDados.add(jMenuItem23);

        jMenuBar1.add(MenuEntradaDados);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8_merge_cells_32px.png"))); // NOI18N
        jMenu1.setText("Quadro");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        jMenuItem1.setText("Avaliação");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Ação");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8_microscope_32px.png"))); // NOI18N
        jMenu2.setText("Resultados laboratório");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        jMenuItem8.setText("Resultados");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8_piece_of_evidence_32px.png"))); // NOI18N
        jMenu3.setText("Evidência");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        jMenuItem20.setText("Evidência DDZ");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem20);

        jMenuBar1.add(jMenu3);

        MenuAlteracaoDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8_edit_file_32px.png"))); // NOI18N
        MenuAlteracaoDados.setText("Alteração");
        MenuAlteracaoDados.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        AlteracaoDados.setText("Dados Extrusão");
        AlteracaoDados.setEnabled(false);
        MenuAlteracaoDados.add(AlteracaoDados);

        jMenuItem4.setText("Dados DDZ");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        MenuAlteracaoDados.add(jMenuItem4);

        jMenuItem19.setText("ID Controle");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        MenuAlteracaoDados.add(jMenuItem19);

        jMenuBar1.add(MenuAlteracaoDados);

        MenuValidacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8_task_completed_32px.png"))); // NOI18N
        MenuValidacao.setText("Validação");
        MenuValidacao.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        jMenuItem10.setText("Alteração/Criação");
        jMenuItem10.setEnabled(false);
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        MenuValidacao.add(jMenuItem10);

        jMenuBar1.add(MenuValidacao);

        MenuRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8_graph_32px.png"))); // NOI18N
        MenuRelatorio.setText("Relatório");
        MenuRelatorio.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        jMenuItem18.setText("Relatórios extrusão");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        MenuRelatorio.add(jMenuItem18);

        jMenuBar1.add(MenuRelatorio);

        MenuUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8_user_32px.png"))); // NOI18N
        MenuUsuario.setText("Usuário");
        MenuUsuario.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        jMenuItem40.setText("Cadastro de Usuário");
        jMenuItem40.setEnabled(false);
        jMenuItem40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem40ActionPerformed(evt);
            }
        });
        MenuUsuario.add(jMenuItem40);

        jMenuBar1.add(MenuUsuario);

        MenuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8_close_window_32px.png"))); // NOI18N
        MenuSair.setText("Sair");
        MenuSair.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        MenuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuSairMouseClicked(evt);
            }
        });

        jMenuItem3.setText("Sair");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        MenuSair.add(jMenuItem3);

        jMenuBar1.add(MenuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        new ViewMontadora().setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        new ViewLinha().setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        new ViewProjeto().setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        new ViewOperacao().setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        new ViewEquipamento().setVisible(true);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        new ViewMaterial().setVisible(true);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        new ViewTeste().setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void EntradaDadosSuperVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntradaDadosSuperVActionPerformed
        new ViewEntradaDadosSuperV().setVisible(true);
    }//GEN-LAST:event_EntradaDadosSuperVActionPerformed

    private void MenuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSairMouseClicked

    }//GEN-LAST:event_MenuSairMouseClicked

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        new ViewValidacao().setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void MenuPnAlteracaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPnAlteracaoMouseClicked

    }//GEN-LAST:event_MenuPnAlteracaoMouseClicked

    private void PainelAlteracaoEXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PainelAlteracaoEXActionPerformed
        new ViewGerenciador().setVisible(true);
    }//GEN-LAST:event_PainelAlteracaoEXActionPerformed

    private void PainelAlteracaoQUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PainelAlteracaoQUActionPerformed
        new ViewQualidade().setVisible(true);
    }//GEN-LAST:event_PainelAlteracaoQUActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        new ViewComposto().setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void PainelAlteracaoATActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PainelAlteracaoATActionPerformed
        new ViewAlteracaoMassa().setVisible(true);
    }//GEN-LAST:event_PainelAlteracaoATActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        new ViewControleProcesso().setVisible(true);
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        new ViewMontadora().setVisible(true);
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem31ActionPerformed
        new ViewProjeto().setVisible(true);
    }//GEN-LAST:event_jMenuItem31ActionPerformed

    private void jMenuItem32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem32ActionPerformed
        new ViewLinhaAc().setVisible(true);
    }//GEN-LAST:event_jMenuItem32ActionPerformed

    private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem33ActionPerformed
        new ViewOperacaoAc().setVisible(true);
    }//GEN-LAST:event_jMenuItem33ActionPerformed

    private void jMenuItem34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem34ActionPerformed
        new ViewEquipamentoAc().setVisible(true);
    }//GEN-LAST:event_jMenuItem34ActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
        new ViewMaterialAc().setVisible(true);
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    private void jMenuItem36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem36ActionPerformed
        new ViewTesteAc().setVisible(true);
    }//GEN-LAST:event_jMenuItem36ActionPerformed

    private void jMenuItem37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem37ActionPerformed
        new ViewControleProcessoAc().setVisible(true);
    }//GEN-LAST:event_jMenuItem37ActionPerformed

    private void PainelAlteracaoACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PainelAlteracaoACActionPerformed
        new ViewAcabamento().setVisible(true);
    }//GEN-LAST:event_PainelAlteracaoACActionPerformed

    private void jMenuItem40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem40ActionPerformed
        new ViewUsuario().setVisible(true);
    }//GEN-LAST:event_jMenuItem40ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void EntradaDadosEXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntradaDadosEXActionPerformed
        new ViewEntradaDados().setVisible(true);
    }//GEN-LAST:event_EntradaDadosEXActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new ViewEstudoEncolhimento().setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new ViewVelocidade().setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if (!ControleInstancias.isInstaced(ViewDdzControle.class)) {
            ControleInstancias.addInstance(ViewDdzControle.class.getName(), new ViewDdzControle());
        }
        ViewDdzControle viewid_controle = (ViewDdzControle) ControleInstancias.getInstance(ViewDdzControle.class.getName(), ViewDdzControle.class);
        viewid_controle.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        new ViewRelatorio().setVisible(true);
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            Runtime.getRuntime().exec("java -jar J:\\Sistema de Documentacao\\TomadaAcao.jar\\");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new ViewQuadroAvaliacao().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new View_DdzControleAlter().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        new ViewResultadoLab().setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        new ViewDdzDeletaControle().setVisible(true);
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        new View_Evidencia().setVisible(true);
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        new ViewCausas().setVisible(true);
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        new ViewProblema().setVisible(true);
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed

        new ViewDdzGerenciador().setVisible(true);
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        new ViewProducaoManual().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewExtrusao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AlteracaoDados;
    private javax.swing.JMenu CadastroFichaAC;
    private javax.swing.JMenu CadastroFichaEX;
    private javax.swing.JMenuItem EntradaDadosAC;
    private javax.swing.JMenuItem EntradaDadosEX;
    private javax.swing.JMenuItem EntradaDadosSuperV;
    private javax.swing.JMenu MenuAlteracaoDados;
    private javax.swing.JMenu MenuCadFicha;
    private javax.swing.JMenu MenuEntradaDados;
    private javax.swing.JMenu MenuPnAlteracao;
    private javax.swing.JMenu MenuRelatorio;
    private javax.swing.JMenu MenuSair;
    private javax.swing.JMenu MenuUsuario;
    private javax.swing.JMenu MenuValidacao;
    private javax.swing.JMenuItem PainelAlteracaoAC;
    private javax.swing.JMenuItem PainelAlteracaoAT;
    private javax.swing.JMenuItem PainelAlteracaoEX;
    private javax.swing.JMenuItem PainelAlteracaoQU;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem37;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem40;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}

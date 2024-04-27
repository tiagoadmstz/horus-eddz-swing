package com.cooperstandard.views.pontoinsp;

import com.cooperstandard.views.principal.ViewUsuario;
import com.cooperstandard.views.principal.*;
import commons.report.pkg1.pkg8.pkg2.vreport;
import com.cooperstandard.util.FundoTela;
import java.awt.GridLayout;
import com.cooperstandard.model.ModelPermissaousuario;
import com.cooperstandard.model.ModelSessaoUsuario;
import com.cooperstandard.controller.extrusao.ControllerPermissaousuario;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class ViewInspecao extends javax.swing.JFrame {

    FundoTela tela;

    public ViewInspecao() {
        initComponents();
        liberarModulos();
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

    private Sobre telasobre;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuCadFicha = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        MenuEntradaDados = new javax.swing.JMenu();
        jMenuItem21 = new javax.swing.JMenuItem();
        MenuAlteracaoDados = new javax.swing.JMenu();
        AlteracaoDados = new javax.swing.JMenuItem();
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel2.setText("Create by: Rafael Chaves de Souza");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 818, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(599, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap())))
        );

        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        MenuCadFicha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cooperstandard/imagens/icons8_administrative_tools_32px.png"))); // NOI18N
        MenuCadFicha.setText("Cadastro");
        MenuCadFicha.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        jMenuItem16.setText("Perfil");
        jMenuItem16.setEnabled(false);
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        MenuCadFicha.add(jMenuItem16);

        jMenuItem17.setText("Teste");
        jMenuItem17.setEnabled(false);
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        MenuCadFicha.add(jMenuItem17);

        jMenuItem1.setText("Especificação por perfil");
        jMenuItem1.setEnabled(false);
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        MenuCadFicha.add(jMenuItem1);

        jMenuBar1.add(MenuCadFicha);

        MenuEntradaDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cooperstandard/imagens/icons8_document_32px.png"))); // NOI18N
        MenuEntradaDados.setText("Input de dado");
        MenuEntradaDados.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        jMenuItem21.setText("Laboratório");
        jMenuItem21.setEnabled(false);
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        MenuEntradaDados.add(jMenuItem21);

        jMenuBar1.add(MenuEntradaDados);

        MenuAlteracaoDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cooperstandard/imagens/icons8_edit_file_32px.png"))); // NOI18N
        MenuAlteracaoDados.setText("Alteração");
        MenuAlteracaoDados.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        AlteracaoDados.setText("Dados inspeção");
        AlteracaoDados.setEnabled(false);
        AlteracaoDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlteracaoDadosActionPerformed(evt);
            }
        });
        MenuAlteracaoDados.add(AlteracaoDados);

        jMenuBar1.add(MenuAlteracaoDados);

        MenuRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cooperstandard/imagens/icons8_graph_32px.png"))); // NOI18N
        MenuRelatorio.setText("Relatório");
        MenuRelatorio.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        jMenuItem18.setText("Relatórios laboratórios");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        MenuRelatorio.add(jMenuItem18);

        jMenuBar1.add(MenuRelatorio);

        MenuUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cooperstandard/imagens/icons8_user_32px.png"))); // NOI18N
        MenuUsuario.setText("Usuário");
        MenuUsuario.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        jMenuItem40.setText("Cadastro de usuário");
        jMenuItem40.setEnabled(false);
        jMenuItem40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem40ActionPerformed(evt);
            }
        });
        MenuUsuario.add(jMenuItem40);

        jMenuBar1.add(MenuUsuario);

        MenuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cooperstandard/imagens/icons8_close_window_32px.png"))); // NOI18N
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

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        new ViewMaterial().setVisible(true);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        new ViewTeste().setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void MenuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSairMouseClicked

    }//GEN-LAST:event_MenuSairMouseClicked

    private void jMenuItem40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem40ActionPerformed
        new ViewUsuario().setVisible(true);
    }//GEN-LAST:event_jMenuItem40ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        new ViewRelatorio().setVisible(true);
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        new ViewEntradaLancamento().setVisible(true);
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new ViewEntradaCadastro().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void AlteracaoDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlteracaoDadosActionPerformed
        new ViewPainel_Alter().setVisible(true);
    }//GEN-LAST:event_AlteracaoDadosActionPerformed

    public String retornarUsuarioLogado() {
        return new ModelSessaoUsuario().nome;
    }

    public String retornarUsuarioPlanta() {
        return new ModelSessaoUsuario().planta;
    }

    private void cria() {
        JButton bt = new JButton("Código fonte");
        bt.addActionListener((ActionEvent e) -> {
            new vreport().setVisible(true);
        });
//        jMenuBar1.add(bt);
    }

    private void liberarModulos() {
        ControllerPermissaousuario controllerPermissaousuario = new ControllerPermissaousuario();
        ArrayList<ModelPermissaousuario> listaModelPermissaousuarios = new ArrayList<>();
        listaModelPermissaousuarios = controllerPermissaousuario.getListaPermissaousuarioController(new ModelSessaoUsuario().codigo);
        cria();
        for (int i = 0; i < listaModelPermissaousuarios.size(); i++) {
            if (listaModelPermissaousuarios.get(i).getPermissao().equals("MenuRelatorio")) {
                jMenuItem18.setEnabled(true);
            }
            if (listaModelPermissaousuarios.get(i).getPermissao().equals("AlteracaoDados")) {
                AlteracaoDados.setEnabled(true);

            }
            if (listaModelPermissaousuarios.get(i).getPermissao().equals("EntradaDadosInsp")) {
                jMenuItem21.setEnabled(true);

            }
            if (listaModelPermissaousuarios.get(i).getPermissao().equals("CadastroFichaInsp")) {
                jMenuItem16.setEnabled(true);
                jMenuItem17.setEnabled(true);
                jMenuItem1.setEnabled(true);
            }
            if (listaModelPermissaousuarios.get(i).getPermissao().equals("MenuUsuario")) {
                jMenuItem40.setEnabled(true);

            }

        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewInspecao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AlteracaoDados;
    private javax.swing.JMenu MenuAlteracaoDados;
    private javax.swing.JMenu MenuCadFicha;
    private javax.swing.JMenu MenuEntradaDados;
    private javax.swing.JMenu MenuRelatorio;
    private javax.swing.JMenu MenuSair;
    private javax.swing.JMenu MenuUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem40;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}

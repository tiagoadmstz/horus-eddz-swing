/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.views.extrusao;

import com.cooperstandard.controller.extrusao.ControllerUsuario;
import com.cooperstandard.model.ModelSessaoUsuario;
import com.cooperstandard.model.ModelUsuario;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rsouza10
 */
public class ViewTryOut extends javax.swing.JFrame {

    ModelUsuario modelusuario = new ModelUsuario();
    ControllerUsuario controllerUsuario = new ControllerUsuario();
    String linha;
    String pNomeUsuario = "";
    String pPlantaUsuario = "";
    int pCodigoUsuario = 0;
    int id_planta = 0;

    public ViewTryOut() {
        initComponents();
        configurar();
        verifica();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(0, 255, 51));
        jButton1.setText("Iniciar Try Out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setText("Finalizar Try Out");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        alteraTryOut("Y");
        jButton1.setVisible(false);
        jButton2.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        alteraTryOut("N");
        jButton1.setVisible(true);
        jButton2.setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    public int retornarUsuarioLogado() {
        return new ModelSessaoUsuario().codigo;
    }

    public String retornarUsuarioLogadoNome() {
        return new ModelSessaoUsuario().nome;
    }

    public String retornarUsuarioLogadoPlanta() {
        return new ModelSessaoUsuario().planta;
    }

    private void configurar() {
        pCodigoUsuario = retornarUsuarioLogado();
        pNomeUsuario = retornarUsuarioLogadoNome();
        pPlantaUsuario = retornarUsuarioLogadoPlanta();
        switch (pPlantaUsuario) {
            case "Varginha":
                id_planta = 1;
                break;
            case "Atibaia":
                id_planta = 2;
                break;
            default:
                id_planta = 1;
                break;
        }
        switch (pNomeUsuario) {
            case "DDZL4":
                linha = "L04";
                break;
            case "DDZL6":
                linha = "L06";
                break;
            case "DDZL7":
                linha = "L07";
                break;
            case "DDZL8":
                linha = "L08";
                break;
            case "DDZL9":
                linha = "L09";
                break;
            case "DDZL11":
                linha = "L11";
                break;
            case "DDZL12":
                linha = "L12";
                break;
            case "DDZL17":
                linha = "L17";
                break;
            case "DDZL19":
                linha = "L19";
                break;
            case "DDZL27":
                linha = "L27";
                break;
            case "DDZL26":
                linha = "L26";
                break;
            case "DDZL28":
                linha = "L28";
                break;
            default:
                linha = "L";
                break;
        }
    }

    private void verifica() {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            
            con = new ConexaoSql().getCon();

            String query1 = "SELECT TOP 1 TRY_OUT FROM DDZ_TryOut WHERE LINHA = ?";
            st = con.prepareStatement(query1);
            st.setString(1, linha);

            rs = st.executeQuery();

            while (rs.next()) {
                String flag = rs.getString("TRY_OUT");

                if (flag.equals("Y")) {
                    jButton1.setVisible(false);
                    jButton2.setVisible(true);
                } else {
                    jButton1.setVisible(true);
                    jButton2.setVisible(false);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    // tratamento de exceção
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    // tratamento de exceção
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    // tratamento de exceção
                }
            }
        }
    }

    private void alteraTryOut(String flag) {
        try {
            
            Connection con = new ConexaoSql().getCon();

            String query1 = "UPDATE DDZ_TryOut SET TRY_OUT = ? WHERE LINHA = ?";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, flag);
            st.setString(2, linha);

            st.executeUpdate();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            // Trate a exceção de acordo com suas necessidades
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
            java.util.logging.Logger.getLogger(ViewTryOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTryOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTryOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTryOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewTryOut().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

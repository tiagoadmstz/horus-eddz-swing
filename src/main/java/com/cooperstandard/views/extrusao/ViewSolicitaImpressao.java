package com.cooperstandard.views.extrusao;

import com.cooperstandard.util.PrinterDirect;
import com.cooperstandard.views.principal.AguardeGerandoRelatório;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author rsouza10
 */
public class ViewSolicitaImpressao extends javax.swing.JFrame {

    int count;
    String lancamento;

    public ViewSolicitaImpressao() {
        initComponents();
    }

    public ViewSolicitaImpressao(String _linha, String _perfil, String _bpcs, String _descricao) {
        initComponents();
        pegadata();
        txtLinha.setText(_linha);
        txtPerfil.setText(_perfil);
        txtDescricao.setText(_descricao);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txtLinha = new javax.swing.JLabel();
        txtPerfil = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JLabel();
        txtDJet = new com.toedter.calendar.JDateChooser();
        txtHJet = new javax.swing.JFormattedTextField();
        txtSolicitante = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDJet1 = new com.toedter.calendar.JDateChooser();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-impress¦o-filled-50.png"))); // NOI18N
        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtLinha.setForeground(new java.awt.Color(0, 51, 255));
        txtLinha.setText("jLabel2");
        txtLinha.setBorder(javax.swing.BorderFactory.createTitledBorder("Linha"));

        txtPerfil.setForeground(new java.awt.Color(0, 51, 255));
        txtPerfil.setText("31057273");
        txtPerfil.setBorder(javax.swing.BorderFactory.createTitledBorder("Perfil"));

        txtDescricao.setForeground(new java.awt.Color(0, 51, 255));
        txtDescricao.setText("jLabel2");
        txtDescricao.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição"));

        txtDJet = new JDateChooser("dd/MM/yyyy", "##/##/#####", '_');
        txtDJet.setBackground(new java.awt.Color(255, 255, 255));
        txtDJet.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Jet"));

        txtHJet.setBorder(javax.swing.BorderFactory.createTitledBorder("Hora Jet"));
        try {
            txtHJet.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHJet.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtSolicitante.setBorder(javax.swing.BorderFactory.createTitledBorder("Solicitante"));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("IMPRESSÃO DE TESTE PARA O LABORATÓRIO");
        jLabel1.setOpaque(true);

        txtDJet1 = new JDateChooser("dd/MM/yyyy", "##/##/#####", '_');
        txtDJet1.setBackground(new java.awt.Color(255, 255, 255));
        txtDJet1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data de solicitação"));

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Lançamento?");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDJet1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtHJet, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDJet, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtLinha)
                .addGap(18, 18, 18)
                .addComponent(txtPerfil)
                .addGap(18, 18, 18)
                .addComponent(txtDescricao)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDJet1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDJet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtHJet))
                .addGap(18, 18, 18)
                .addComponent(txtSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        verificateste();
        if (txtHJet.getText().equals("") || txtHJet.getText().equals("  :  ") || txtHJet.getText() == null) {
            JOptionPane.showMessageDialog(null, "Campo 'Hora' obrigatório!");
            txtHJet.requestFocus();
        } else if (txtHJet.getText().equals("00:00")) {
            JOptionPane.showMessageDialog(null, "Não é possível imprimir testes no formato de hora 00:00!", null, JOptionPane.WARNING_MESSAGE);
            txtHJet.requestFocus();
        } else if (txtDJet.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Campo 'Data' obrigatório!");
            txtDJet.requestFocus();
        } else if (txtSolicitante.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo 'Solicitante' obrigatório!");
            txtSolicitante.requestFocus();
        } else {
            System.out.println(txtHJet.getText());
            if (count != 0) {
                final AguardeGerandoRelatório abrindo = new AguardeGerandoRelatório();
                abrindo.setVisible(true);
                Thread t = new Thread() {
                    public void run() {
                        RelatorioImprimir(1);
                        abrindo.dispose();
                    }
                };
                t.start();
                JOptionPane.showMessageDialog(null, "Impressão enviada com sucesso!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Não há teste cadastrado para este perfil, entre em contato com ponto de inspeção/Engenheiro responsável para realizar o cadastro!", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            lancamento = "true";
        } else {
            lancamento = "false";
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void RelatorioImprimir(int copia) {
        try {
            
            Connection con = new ConexaoSql().getCon();
            Map p = new HashMap();
            String logo = "/images/logocooper.jpg";
            p.put("perfil", txtPerfil.getText().split(" - ")[0]);
            p.put("lancamento", lancamento);
            p.put("solicitante", txtSolicitante.getText());
            p.put("horajet", txtHJet.getText());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String datajet = dateFormat.format(txtDJet.getDate());
            p.put("datajet", datajet);
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
            String data = dateFormat1.format(txtDJet1.getDate());
            p.put("data", data);
            p.put("logo", this.getClass().getResourceAsStream(logo));
            JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/Relatorios/insp_BFicha.jasper"), p, con);
            PrinterDirect teste = new PrinterDirect();
            teste.printFromJasperPrint(teste.getDefaultPrinter(), print, copia);
            con.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "deu erro =" + erro);
            System.out.println(erro);
        }
    }

    public void verificateste() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "SELECT count(ID) FROM Cad_EspecLab WHERE ID_MATERIAL_ID  = '" + txtPerfil.getText().split(" - ")[0] + "'";
            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void pegadata() {
        SimpleDateFormat sdfh = new SimpleDateFormat("HH:mm");
        sdfh.setTimeZone(TimeZone.getTimeZone("GMT-03:00"));
        String hora = sdfh.format(new Date());
        txtHJet.setText(hora);
        java.util.Date data = Calendar.getInstance().getTime();
        txtDJet1.setDate(data);
        txtDJet.setDate(data);
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
            java.util.logging.Logger.getLogger(ViewSolicitaImpressao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewSolicitaImpressao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewSolicitaImpressao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewSolicitaImpressao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewSolicitaImpressao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser txtDJet;
    private com.toedter.calendar.JDateChooser txtDJet1;
    private javax.swing.JLabel txtDescricao;
    private javax.swing.JFormattedTextField txtHJet;
    private javax.swing.JLabel txtLinha;
    private javax.swing.JLabel txtPerfil;
    private javax.swing.JTextField txtSolicitante;
    // End of variables declaration//GEN-END:variables
}

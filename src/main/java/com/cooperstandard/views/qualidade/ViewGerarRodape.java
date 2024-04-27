package com.cooperstandard.views.qualidade;

import com.cooperstandard.controller.extrusao.ControllerRodape;
import com.cooperstandard.views.principal.AguardeGerandoRelatório;
import com.cooperstandard.model.ModelRodape;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author rsouza10
 */
public class ViewGerarRodape extends javax.swing.JFrame {

    ModelRodape modelRodape = new ModelRodape();
    ControllerRodape controllerRodape = new ControllerRodape();
    ArrayList<ModelRodape> listaModelRodape = new ArrayList<ModelRodape>();
    Integer perfil;
    String statusodape = "";
    String linha = "";

    public ViewGerarRodape() {
        initComponents();
    }

    public ViewGerarRodape(Integer _perfil, String _statusodape, String _linha) {
        initComponents();
        perfil = _perfil;
        linha = _linha;
        statusodape = _statusodape;
        JdtData.requestFocus();
        jLabel1.setText("Rodapé ficha de controle " + " " + perfil);

        if (statusodape.equals("Alteracão")) {
            txtDescricao.setText("");
            try {
                
                Connection con1 = new ConexaoSql().getCon();
                String query = "Select MAX(ROD_REV) as value,MAX(ROD_EMITENTE)as value2,MAX(ROD_RESPONSAVEL)as value3 from Cad_Rodape where  ROD_MATERIAL='" + perfil + "' ";
                PreparedStatement st1 = con1.prepareStatement(query);
                ResultSet rs1 = st1.executeQuery();
                Integer value = null;
                while (rs1.next()) {
                    ////
                    value = rs1.getInt("value");
                    txtEmitente.setText(rs1.getString("value2"));
                    txtResponsavel.setText(rs1.getString("value3"));

                }
                txtRev.setText(String.valueOf(value + 1));
            } catch (Exception e) {

            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtRev = new javax.swing.JTextField();
        lbRevisao = new javax.swing.JLabel();
        JdtData = new com.toedter.calendar.JDateChooser();
        txtDescricao = new javax.swing.JTextField();
        txtEmitente = new javax.swing.JTextField();
        txtSetor = new javax.swing.JTextField();
        txtResponsavel = new javax.swing.JTextField();
        lbData = new javax.swing.JLabel();
        lbDescricao = new javax.swing.JLabel();
        lbEmitente = new javax.swing.JLabel();
        lbResponsavel = new javax.swing.JLabel();
        lbSetor = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        txtRev.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRev.setText("0");

        lbRevisao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbRevisao.setText("Revisão:");

        txtDescricao.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDescricao.setText("Emissão Inicial");

        txtSetor.setText("Garantia da Qualidade");

        lbData.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbData.setText("Data:");

        lbDescricao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbDescricao.setText("Descrição:");

        lbEmitente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbEmitente.setText("Emitente:");

        lbResponsavel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbResponsavel.setText("Responsável:");

        lbSetor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbSetor.setText("Setor:");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-joyent-filled-20 (1).png"))); // NOI18N
        jButton1.setText("Criar rodapé");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Rodapé ficha de controle");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmitente)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbEmitente)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbRevisao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRev))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbData)
                            .addComponent(JdtData, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbDescricao)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSetor)
                            .addComponent(txtSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbResponsavel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtResponsavel)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRevisao)
                    .addComponent(lbData)
                    .addComponent(lbDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JdtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbEmitente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmitente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbResponsavel)
                    .addComponent(lbSetor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtRev.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            txtRev.requestFocus();
        } else if (JdtData.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            JdtData.requestFocus();
        } else if (txtDescricao.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            txtDescricao.requestFocus();
        } else if (txtEmitente.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            txtEmitente.requestFocus();
        } else if (txtSetor.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            txtSetor.requestFocus();
        } else if (txtResponsavel.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            txtResponsavel.requestFocus();
        } else {
            salvarRodape();
            dispose();
            final AguardeGerandoRelatório carregando = new AguardeGerandoRelatório();
            carregando.setVisible(true);
            Thread t = new Thread() {
                public void run() {
                    gerarelatorio();
                    carregando.dispose();
                }
            };
            t.start();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private boolean salvarRodape() {
        modelRodape.setRod_data(new SimpleDateFormat("yyyy/MM/dd").format(JdtData.getDate()));
        modelRodape.setRod_rev(Integer.parseInt(this.txtRev.getText()));
        modelRodape.setRod_descricao(this.txtDescricao.getText());
        modelRodape.setRod_emitente(this.txtEmitente.getText());
        modelRodape.setRod_setor(this.txtSetor.getText());
        modelRodape.setRod_responsavel(this.txtResponsavel.getText());
        modelRodape.setRod_material(perfil);

        if (controllerRodape.salvarRodapeController(modelRodape) > 0) {
            JOptionPane.showMessageDialog(this, "Rodapé criado com sucesso!");
            return true;
        } else {
//            JOptionPane.showMessageDialog(this, "Erro ao tentar gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void gerarelatorio() {
        try {
            String logo = "/images/logocooper.jpg";
            
            Connection con = new ConexaoSql().getCon();
            Map p = new HashMap();
            p.put("perfil", perfil);
            p.put("logo", this.getClass().getResourceAsStream(logo));
            p.put("SUBREPORT_DIR", this.getClass().getResource("/Relatorios/"));
            if (linha.contains("C")) {
                JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Relatorios/fichacontroleAcabamento.jasper"));
                JasperPrint print = JasperFillManager.fillReport(jr, p, con);
                JasperViewer view = new JasperViewer(print, false);
                view.setTitle("Ficha de Controle");
                view.setVisible(true);
            } else {
                JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Relatorios/fichacontrole.jasper"));
                JasperPrint print = JasperFillManager.fillReport(jr, p, con);
                JasperViewer view = new JasperViewer(print, false);
                view.setTitle("Ficha de Controle");
                view.setVisible(true);
            }
        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "deu erro =" + erro);
            System.out.println(erro);

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
            java.util.logging.Logger.getLogger(ViewGerarRodape.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewGerarRodape.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewGerarRodape.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewGerarRodape.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewGerarRodape().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JdtData;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbEmitente;
    private javax.swing.JLabel lbResponsavel;
    private javax.swing.JLabel lbRevisao;
    private javax.swing.JLabel lbSetor;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtEmitente;
    private javax.swing.JTextField txtResponsavel;
    private javax.swing.JTextField txtRev;
    private javax.swing.JTextField txtSetor;
    // End of variables declaration//GEN-END:variables
}

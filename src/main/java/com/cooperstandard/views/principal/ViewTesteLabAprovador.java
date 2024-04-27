package com.cooperstandard.views.principal;

import com.cooperstandard.controller.pontoinsp.ControllerEspecLab;
import com.cooperstandard.controller.pontoinsp.ControllerInspControle;
import com.cooperstandard.controller.pontoinsp.ControllerResultInsp;
import com.cooperstandard.model.ModelEspecLab;
import com.cooperstandard.model.ModelInspControle;
import com.cooperstandard.model.ModelResultInsp;
import java.awt.Image;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author rsouza10
 */
public class ViewTesteLabAprovador extends javax.swing.JFrame {

    ModelResultInsp modelResultInsp = new ModelResultInsp();
    ControllerResultInsp controllerResultInsp = new ControllerResultInsp();
    ArrayList<ModelResultInsp> listaModelResultInsp = new ArrayList<>();
    ModelInspControle modelInspControle = new ModelInspControle();
    ControllerInspControle controllerInspControle = new ControllerInspControle();
    ArrayList<ModelInspControle> listaModelInspControle = new ArrayList<>();
    ModelEspecLab modelEspecLab = new ModelEspecLab();
    ControllerEspecLab controllerEspecLab = new ControllerEspecLab();
    ArrayList<ModelEspecLab> listaModelEspecLab = new ArrayList<>();
    String id_controle;
    String entrada;
    String img;

    public ViewTesteLabAprovador() {
        initComponents();
    }

    public ViewTesteLabAprovador(String _id_controle, String _data_hora, String _solicitante, String _perfil, String _entrada) {
        initComponents();
        id_controle = _id_controle;
        entrada = _entrada;
        txtDataHora.setText(_data_hora);
        txtSolicitante.setText(_solicitante);
        txtPerfil.setText(_perfil);
        if (entrada.equals("produção")) {
            carregaEspecCompletoLab();
        } else {
            carregaEspecCompletoRetesteLab();
        }
        pegaInformacao();
        ImprimiImagem();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbResultado = new com.cooperstandard.swing.TableStatusTeste();
        jLabel1 = new javax.swing.JLabel();
        txtDataHora = new javax.swing.JLabel();
        txtPerfil = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtSolicitante = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtAprovador = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbImagem = new javax.swing.JLabel();
        txtRealizado = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        tbResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "COD", "Teste", "Tipo", "Complemento", "min", "max", "texto", "referencia", "Especificação", "Resultado", "Resultado Texto", "Observação", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbResultado.setGridColor(new java.awt.Color(255, 255, 255));
        tbResultado.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbResultado);
        if (tbResultado.getColumnModel().getColumnCount() > 0) {
            tbResultado.getColumnModel().getColumn(0).setMinWidth(0);
            tbResultado.getColumnModel().getColumn(0).setMaxWidth(0);
            tbResultado.getColumnModel().getColumn(1).setMinWidth(0);
            tbResultado.getColumnModel().getColumn(1).setMaxWidth(0);
            tbResultado.getColumnModel().getColumn(2).setMinWidth(200);
            tbResultado.getColumnModel().getColumn(3).setMinWidth(0);
            tbResultado.getColumnModel().getColumn(3).setMaxWidth(0);
            tbResultado.getColumnModel().getColumn(5).setMinWidth(0);
            tbResultado.getColumnModel().getColumn(5).setMaxWidth(0);
            tbResultado.getColumnModel().getColumn(6).setMinWidth(0);
            tbResultado.getColumnModel().getColumn(6).setMaxWidth(0);
            tbResultado.getColumnModel().getColumn(7).setMinWidth(0);
            tbResultado.getColumnModel().getColumn(7).setMaxWidth(0);
            tbResultado.getColumnModel().getColumn(8).setMinWidth(0);
            tbResultado.getColumnModel().getColumn(8).setMaxWidth(0);
            tbResultado.getColumnModel().getColumn(11).setMinWidth(0);
            tbResultado.getColumnModel().getColumn(11).setMaxWidth(0);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data/Hora Jet:");

        txtDataHora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDataHora.setForeground(new java.awt.Color(255, 255, 0));
        txtDataHora.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        txtPerfil.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPerfil.setForeground(new java.awt.Color(255, 255, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Perfil:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Solicitante:");

        txtSolicitante.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSolicitante.setForeground(new java.awt.Color(255, 255, 0));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Aprovado por:");

        txtAprovador.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtAprovador.setForeground(new java.awt.Color(255, 0, 51));
        txtAprovador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtAprovador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAprovador, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Imagem perfil", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        lbImagem.setBackground(new java.awt.Color(255, 255, 255));
        lbImagem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbImagem, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbImagem, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
        );

        txtRealizado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtRealizado.setForeground(new java.awt.Color(255, 51, 0));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Realizado por:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_print_35px.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtRealizado, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtDataHora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtSolicitante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtRealizado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        final AguardeGerandoRelatório carregando = new AguardeGerandoRelatório();
        carregando.setVisible(true);
        Thread t = new Thread() {
            public void run() {
                try {

                    String logo = "/images/logocooper.jpg";
                    
                    Connection con = new ConexaoSql().getCon();
                    Map p = new HashMap();
//                    p.put("tipoteste", "Teste");
                    p.put("id_controle", id_controle);
                    p.put("logo", this.getClass().getResourceAsStream(logo));
//                    p.put("SUBREPORT_DIR", this.getClass().getResource("/Relatorios/"));
                    JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Relatorios/insp_BTestePerfil.jasper"));
                    JasperPrint print = JasperFillManager.fillReport(jr, p, con);
                    JasperViewer view = new JasperViewer(print, false);
                    view.setTitle("Tela de Acompanhamento");
                    view.setVisible(true);
                } catch (Exception erro) {
                    JOptionPane.showMessageDialog(null, "deu erro =" + erro);
                    System.out.println(erro);
                }
                carregando.dispose();
            }
        };
        t.start();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void carregaEspecCompletoLab() {
        tbResultado.setCellSelectionEnabled(true);
        listaModelEspecLab = controllerEspecLab.getListaEspecLabIDCompletoController(String.valueOf(id_controle));
        DefaultTableModel modelo = (DefaultTableModel) tbResultado.getModel();
        modelo.setNumRows(0);
        int cont = listaModelEspecLab.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelEspecLab.get(i).getId(),//0
                listaModelEspecLab.get(i).getOrdem(),//1
                "   " + listaModelEspecLab.get(i).getDesc_teste(),//2
                listaModelEspecLab.get(i).getTipo_espec(),//3
                listaModelEspecLab.get(i).getObservacao(),//4
                listaModelEspecLab.get(i).getMinimo(),//5
                listaModelEspecLab.get(i).getMaximo(),//6
                listaModelEspecLab.get(i).getTexto(),//7
                listaModelEspecLab.get(i).getReferencia(),//8
                listaModelEspecLab.get(i).getEspec_completo(),//9
                listaModelEspecLab.get(i).getTipo_espec().equals("Texto") ? listaModelEspecLab.get(i).getResult_text() : listaModelEspecLab.get(i).getResult_num() == 0.0 ? "" : listaModelEspecLab.get(i).getResult_num(),//10
                listaModelEspecLab.get(i).getResult_text(),//11
                listaModelEspecLab.get(i).getObs(),//12
                listaModelEspecLab.get(i).getStatus() == null ? "Em espera" : listaModelEspecLab.get(i).getStatus().equals("") ? "Em andamento" : listaModelEspecLab.get(i).getStatus()});//13
        }
    }

    private void carregaEspecCompletoRetesteLab() {
        tbResultado.setCellSelectionEnabled(true);
        listaModelEspecLab = controllerEspecLab.getListaEspecLabIDCompletoRetesteController(String.valueOf(id_controle));
        DefaultTableModel modelo = (DefaultTableModel) tbResultado.getModel();
        modelo.setNumRows(0);
        int cont = listaModelEspecLab.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelEspecLab.get(i).getId(),//0
                listaModelEspecLab.get(i).getOrdem(),//1
                "   " + listaModelEspecLab.get(i).getDesc_teste(),//2
                listaModelEspecLab.get(i).getTipo_espec(),//3
                listaModelEspecLab.get(i).getObservacao(),//4
                listaModelEspecLab.get(i).getMinimo(),//5
                listaModelEspecLab.get(i).getMaximo(),//6
                listaModelEspecLab.get(i).getTexto(),//7
                listaModelEspecLab.get(i).getReferencia(),//8
                listaModelEspecLab.get(i).getEspec_completo(),//9
                listaModelEspecLab.get(i).getTipo_espec().equals("Texto") ? listaModelEspecLab.get(i).getResult_text() : listaModelEspecLab.get(i).getResult_num() == 0.0 ? "" : listaModelEspecLab.get(i).getResult_num(),//10
                listaModelEspecLab.get(i).getResult_text(),//11
                listaModelEspecLab.get(i).getObs(),//12
                listaModelEspecLab.get(i).getStatus() == null ? "Em espera" : listaModelEspecLab.get(i).getStatus().equals("") ? "Em andamento" : listaModelEspecLab.get(i).getStatus().contains("") ? "Teste" : listaModelEspecLab.get(i).getStatus()});//13
        }
    }

    public void pegaInformacao() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select DISTINCT APROVADOR,PERFIL,IMAGE,NOME,SOBRE_NOME from Cad_ResultadoInsp INNER JOIN INSP_Controle ON INSP_Controle.ID = ID_CONTROLE INNER JOIN Cad_Material ON MATERIAL = PERFIL INNER JOIN Cad_Usuario ON ANALISTA = PK_ID where ID_CONTROLE= ? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, id_controle);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                txtRealizado.setText(rs.getString("NOME") + " " + rs.getString("SOBRE_NOME"));
                img = rs.getString("IMAGE");
                txtAprovador.setText(rs.getString("APROVADOR"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void ImprimiImagem() {
        ImageIcon image = new ImageIcon(img);
        lbImagem.setIcon(image);
        lbImagem.setIcon(new ImageIcon(image.getImage().getScaledInstance(lbImagem.getWidth(), lbImagem.getHeight(), Image.SCALE_DEFAULT)));
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
            java.util.logging.Logger.getLogger(ViewTesteLabAprovador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTesteLabAprovador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTesteLabAprovador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTesteLabAprovador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewTesteLabAprovador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbImagem;
    private com.cooperstandard.swing.TableStatusTeste tbResultado;
    private javax.swing.JLabel txtAprovador;
    private javax.swing.JLabel txtDataHora;
    private javax.swing.JLabel txtPerfil;
    private javax.swing.JLabel txtRealizado;
    private javax.swing.JLabel txtSolicitante;
    // End of variables declaration//GEN-END:variables
}

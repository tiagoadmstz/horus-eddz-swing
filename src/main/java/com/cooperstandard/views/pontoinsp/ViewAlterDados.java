package com.cooperstandard.views.pontoinsp;

import com.cooperstandard.controller.pontoinsp.ControllerResultInsp;
import com.cooperstandard.model.ModelResultInsp;
import com.cooperstandard.util.CustomTableCellRenderer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rsouza10
 */
public class ViewAlterDados extends javax.swing.JFrame {

    private static final long serialVersionUID = -9045442761643727702L;

    ModelResultInsp modelResultInsp = new ModelResultInsp();
    ControllerResultInsp controllerResultInsp = new ControllerResultInsp();
    ArrayList<ModelResultInsp> listaModelResultInsp = new ArrayList<>();
    String perfil = "";
    String hora = "";
    String data = "";

    public ViewAlterDados() {
        initComponents();
//        carregaRecebe();
        jTable1.setDefaultRenderer(String.class, new CustomTableCellRenderer());
        jTable1.setDefaultRenderer(Integer.class, new CustomTableCellRenderer());
        jTable1.setCellSelectionEnabled(true);
    }

    public ViewAlterDados(String _perfil, String _hora, String _data) {
        initComponents();
        perfil = _perfil;
        hora = _hora;
        data = _data;
        lbComposto.setText(perfil);
        lbHora.setText(hora);
        lbData.setText(data);
        jTable1.setDefaultRenderer(String.class, new CustomTableCellRenderer());
        jTable1.setDefaultRenderer(Integer.class, new CustomTableCellRenderer());
        jTable1.setCellSelectionEnabled(true);
//        carregaRecebe();
    }

    //    public void gerarelatorio() {
//
//        try {
//            String logo = "/images/logocooper.jpg";
//            
//            Connection con = new ConexaoSql().getCon();
//            Map p = new HashMap();
//            p.put("perfil", lbComposto.getText());
//            p.put("hora", lbHora.getText());
//            p.put("data", data);
//            p.put("logo", this.getClass().getResourceAsStream(logo));
//            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Relatorios/receberesultado.jasper"));
//            JasperPrint print = JasperFillManager.fillReport(jr, p, con);
//            JasperViewer view = new JasperViewer(print, false);
//            view.setTitle("");
//            view.setVisible(true);
//        } catch (Exception erro) {
//
//            JOptionPane.showMessageDialog(null, "deu erro =" + erro);
//            System.out.println(erro);
//
//        }
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        lbHora = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbComposto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alteração de Dados");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(2, 83, 161));

        jPanel1.setBackground(new java.awt.Color(241, 176, 19));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Perfil:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Hora:");

        lbComposto.setEditable(false);
        lbComposto.setBackground(new java.awt.Color(208, 208, 208));
        lbComposto.setBorder(null);
        lbComposto.setFocusable(false);
        lbComposto.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbComposto, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbData, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel1)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel6)
                                                .addComponent(lbComposto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
                },
                new String[]{
                        "ID", "COD", "Teste", "Tipo", "Complemento", "min", "max", "texto", "referencia", "Especificação", "Resultado", "Resultado Texto", "Observação", "Status"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    true, false, false, false, false, false, false, false, false, false, true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(1).setMinWidth(50);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(3).setMinWidth(80);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(5).setMinWidth(0);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(6).setMinWidth(0);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(7).setMinWidth(0);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(8).setMinWidth(0);
            jTable1.getColumnModel().getColumn(8).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(10).setMinWidth(80);
            jTable1.getColumnModel().getColumn(10).setMaxWidth(80);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jMenu1.setText("Arquivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Alterar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Deletar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Imprimir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);
        jMenu1.add(jSeparator1);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem4.setText("Sair");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

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
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        try {
//            
//            Connection con = new ConexaoSql().getCon();
//            String query1 = "Select * from Resultado where RCPERFIL= '" + lbComposto.getText() + "' and HORA='" + lbHora.getText() + "' and DATA = '" + lbData.getText() + "'  order by ORDEM asc";
//            PreparedStatement st = con.prepareStatement(query1);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//
//                lbN_operacao.setText(rs.getString("N_OP"));
//                lbBatch.setText(rs.getString("BATCH"));
//                lbN_etiqueta.setText(rs.getString("N_ETIQUETA"));
//            }
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, e);
//        }
    }//GEN-LAST:event_formWindowOpened

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
//        excluirDados();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jTable1.editCellAt(0, 12);
        verifica();
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
                + " alterar os registro?", "Atenção", JOptionPane.YES_OPTION);
        if (opcao == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(this, "Dados atualizados com sucesso!");
            getValoresAlter();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
//        final AguardeGerandoRelatório carregando = new AguardeGerandoRelatório();
//        carregando.setVisible(true);
//        Thread t = new Thread() {
//            public void run() {
//                gerarelatorio();
//                carregando.dispose();
//            }
//        };
//        t.start();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

//    private void carregaRecebe() {
//        listaModelResultInsp = controllerResultInsp.getListaStatusResultadoInspController(data, hora, perfil);
//        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
//        modelo.setNumRows(0);
//        int cont = listaModelResultInsp.size();
//        for (int i = 0; i < cont; i++) {
//            modelo.addRow(new Object[]{
//                listaModelResultInsp.get(i).getId(),
//                listaModelResultInsp.get(i).getOrdem(),
//                listaModelResultInsp.get(i).getDesc_teste(),
//                listaModelResultInsp.get(i).getTipo(),
//                listaModelResultInsp.get(i).getComplemento(),
//                listaModelResultInsp.get(i).getMin(),
//                listaModelResultInsp.get(i).getMax(),
//                listaModelResultInsp.get(i).getTexto(),
//                listaModelResultInsp.get(i).getReferencia(),
//                listaModelResultInsp.get(i).getEspec_completo(),
//                listaModelResultInsp.get(i).getResultado_num(),
//                listaModelResultInsp.get(i).getResultado_texto(),
//                listaModelResultInsp.get(i).getObs(),
//                listaModelResultInsp.get(i).getStatus()
//            });
//        }
//    }

    public void verifica() {
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            int linha = jTable1.getSelectedRow();
            String tipo = jTable1.getValueAt(linha, 3).toString();
            String snreferencia = jTable1.getValueAt(linha, 8).toString();
            if (tipo.contains("Texto") && !snreferencia.contains("Sim")) {
                String valor1 = jTable1.getValueAt(linha, 7).toString();
                String valor2 = jTable1.getValueAt(linha, 11).toString();
                if (valor1.equals(valor2)) {
                    jTable1.setValueAt("Aprovado", linha, 13);

                } else {
                    jTable1.setValueAt("Reprovado", linha, 13);
                }
                Object obj = jTable1.getValueAt(linha, 11);
                if (obj == null || obj.toString().trim().isEmpty()) {
                    jTable1.setValueAt("", linha, 13);
                }
            } else if (tipo.contains("Min e Max") && !snreferencia.contains("Sim")) {
                Object obj = jTable1.getValueAt(linha, 10);
                if (obj == null || obj.toString().trim().isEmpty()) {
                    jTable1.setValueAt("", linha, 13);
                }
                Float valornumerico = Float.parseFloat(jTable1.getValueAt(linha, 10).toString());
                if (valornumerico >= Float.parseFloat(jTable1.getValueAt(linha, 5).toString()) && valornumerico <= Float.parseFloat(jTable1.getValueAt(linha, 6).toString())) {
                    jTable1.setValueAt("Aprovado", linha, 13);
                } else {
                    jTable1.setValueAt("Reprovado", linha, 13);

                }
            } else if (tipo.contains("No Min") && !snreferencia.contains("Sim")) {
                Object obj = jTable1.getValueAt(linha, 10);
                if (obj == null || obj.toString().trim().isEmpty()) {
                    jTable1.setValueAt("", linha, 13);
                }
                Float valornumerico = Float.parseFloat(jTable1.getValueAt(linha, 10).toString()); //Valor digitado pelo usuario   
                if (valornumerico >= Float.parseFloat(jTable1.getValueAt(linha, 5).toString())) {
                    jTable1.setValueAt("Aprovado", linha, 13);
                } else {
                    jTable1.setValueAt("Reprovado", linha, 13);

                }
            } else if (tipo.contains("No Max") && !snreferencia.contains("Sim")) {
                Object obj = jTable1.getValueAt(linha, 10);
                if (obj == null || obj.toString().trim().isEmpty()) {
                    jTable1.setValueAt("", linha, 13);
                }
                Float valornumerico = Float.parseFloat(jTable1.getValueAt(linha, 10).toString()); //Valor digitado pelo usuario   
                if (valornumerico <= Float.parseFloat(jTable1.getValueAt(linha, 6).toString())) {
                    jTable1.setValueAt("Aprovado", linha, 13);
                } else {
                    jTable1.setValueAt("Reprovado", linha, 13);

                }
            } else if (tipo.contains("ValorUnico") && !snreferencia.contains("Sim")) {
                Object obj = jTable1.getValueAt(linha, 10);
                if (obj == null || obj.toString().trim().isEmpty()) {
                    jTable1.setValueAt("", linha, 13);
                }
                Float valornumerico = Float.parseFloat(jTable1.getValueAt(linha, 10).toString()); //Valor digitado pelo usuario 
                if (valornumerico == Float.parseFloat(jTable1.getValueAt(linha, 5).toString())) {
                    jTable1.setValueAt("Aprovado", linha, 13);
                } else {
                    jTable1.setValueAt("Reprovado", linha, 13);

                }
            } else if (snreferencia.contains("Sim")) {
                Object obj = jTable1.getValueAt(linha, 10);
                Object obj2 = jTable1.getValueAt(linha, 11);

                if ((obj == null || obj.toString().equals("")) && (obj2 == null || obj2.toString().equals(""))) {
                    jTable1.setValueAt("", linha, 13);
                } else {
                    jTable1.setValueAt("Referência", linha, 13);
                }

            }
        }
    }

    //    private void excluirDados() {
//        int linha = jTable1.getSelectedRow();
//        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
//                + " excluir?", "Atenção", JOptionPane.YES_OPTION);
//        if (opcao == JOptionPane.OK_OPTION) {
//            if (controllerResultInsp.excluirResultadoAlterController(perfil, data, hora)) {
//                JOptionPane.showMessageDialog(this, "Registros excluidos com sucesso!");
//                dispose();
//            } else {
//                JOptionPane.showMessageDialog(this, "Erro ao excluir os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//    }
//    private boolean alterarProjeto() {
//        for (int i = 0; i < jTable1.getRowCount(); i++) {
//            String id = (String) jTable1.getValueAt(i, 0);
//            String resultado = (String) jTable1.getValueAt(i, 10);
//            String resultadotxt = (String) jTable1.getValueAt(i, 11);
//            String obs = (String) jTable1.getValueAt(i, 12);
//            String status = (String) jTable1.getValueAt(i, 13);
//            modelResultInsp.setId(Integer.parseInt(id));
//            modelResultInsp.setResultado_num(Float.parseFloat(resultado));
//            modelResultInsp.setResultado_texto(resultadotxt);
//            modelResultInsp.setObs(obs);
//            modelResultInsp.setStatus(status);
//        }
//        if (controllerResultInsp.atualizarResultInspController(modelResultInsp)) {
//            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
//            return true;
//        } else {
//            JOptionPane.showMessageDialog(this, "Erro ao alterar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
//            return false;
//        }
//    }
    private ModelResultInsp getalterarDados(int i) {
        int id = (int) jTable1.getValueAt(i, 0);
        Object resultado = (Object) jTable1.getValueAt(i, 10);
        String resultadotxt = (String) jTable1.getValueAt(i, 11);
        String obs = (String) jTable1.getValueAt(i, 12);
        String status = (String) jTable1.getValueAt(i, 13);
        modelResultInsp.setId(id);
//        modelResultInsp.setResultado_num(Float.parseFloat(resultado));
//        modelResultInsp.setResultado_texto(resultadotxt);
//        modelResultInsp.setObs(obs);
//        modelResultInsp.setStatus(status);
        if (resultado == null) {
            modelResultInsp.setResultado_num(Float.parseFloat("0.0"));
        } else {
            modelResultInsp.setResultado_num((float) resultado);
        }
        if (resultadotxt == null) {
            modelResultInsp.setResultado_texto("");
        } else {
            modelResultInsp.setResultado_texto(resultadotxt);
        }
        if (obs == null) {
            modelResultInsp.setObs("");
        } else {
            modelResultInsp.setObs(obs);
        }
        if (status == null) {
            modelResultInsp.setStatus("");
        } else {
            modelResultInsp.setStatus(status);
        }
        if (controllerResultInsp.atualizarResultInspController(modelResultInsp)) {
            return null;
        } else {
            return null;
        }

    }

    public List<Object> getValoresAlter() {
        List<Object> lista = new ArrayList();
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            Object ob = getalterarDados(i);
            if (ob != null) {
                lista.add(ob);
            }
        }
        return lista;
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
            java.util.logging.Logger.getLogger(ViewAlterDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAlterDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAlterDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAlterDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAlterDados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lbComposto;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbHora;
    // End of variables declaration//GEN-END:variables
}

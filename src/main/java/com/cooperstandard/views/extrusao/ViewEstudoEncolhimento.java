package com.cooperstandard.views.extrusao;

import com.cooperstandard.controller.extrusao.ControllerEncolhimento;
import com.cooperstandard.controller.extrusao.ControllerLinha;
import com.cooperstandard.controller.extrusao.ControllerVelocidade;
import com.cooperstandard.model.ModelEncolhimento;
import com.cooperstandard.model.ModelLinha;
import com.cooperstandard.model.ModelVelocidade;
import com.cooperstandard.views.principal.AguardeGerandoRelatório;
import com.cooperstandard.util.EstiloTablaRenderer;
import com.cooperstandard.util.HeaderRenderer;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class ViewEstudoEncolhimento extends javax.swing.JFrame {

    ControllerLinha controllerLinha = new ControllerLinha();
    ArrayList<ModelLinha> listaModelLinha = new ArrayList<>();
    ControllerEncolhimento controllerEncolhimento = new ControllerEncolhimento();
    ModelEncolhimento modelEncolhimento = new ModelEncolhimento();
    ArrayList<ModelEncolhimento> listaModelEncolhimento = new ArrayList<>();
    ModelVelocidade modelVelocidade = new ModelVelocidade();
    ControllerVelocidade controllerVelocidade = new ControllerVelocidade();
    ArrayList<ModelVelocidade> listaModelVelocidade = new ArrayList<>();
    public int cod_id = 0;
    public String velocidade_perfil = "";

    public ViewEstudoEncolhimento() {
        initComponents();
        listarLinha();
        LimpaCampo();
        tbAmostra.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbAmostra));
        tbAmostra.setDefaultRenderer(Float.class, new EstiloTablaRenderer());
        tbAmostra.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAmostra = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jdtData = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbLinha = new javax.swing.JComboBox<>();
        jtxtfVideo_Jet = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        txtAmostra = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbPerfil = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        txtDesc_Perfil = new javax.swing.JTextField();
        txtBpcs = new javax.swing.JTextField();
        txtTrena = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtMin = new javax.swing.JTextField();
        txtMax = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaObservacao = new javax.swing.JTextArea();
        txtVelocidade = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(2, 83, 161));

        tbAmostra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Numeração", "Inicial", "24Hrs", "48Hrs", "72Hrs"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbAmostra.setCellSelectionEnabled(true);
        tbAmostra.setRowHeight(22);
        jScrollPane1.setViewportView(tbAmostra);
        if (tbAmostra.getColumnModel().getColumnCount() > 0) {
            tbAmostra.getColumnModel().getColumn(0).setMinWidth(0);
            tbAmostra.getColumnModel().getColumn(0).setMaxWidth(0);
            tbAmostra.getColumnModel().getColumn(1).setMinWidth(65);
            tbAmostra.getColumnModel().getColumn(1).setMaxWidth(65);
        }

        jPanel2.setBackground(new java.awt.Color(241, 176, 19));

        jLabel6.setText("Velocidade");

        jLabel3.setText("BPCS");

        jLabel4.setText("Descrição do perfil");

        jdtData = new JDateChooser("dd/MM/yyyy", "##/##/#####", '_');

        jLabel5.setText("Data");

        jLabel7.setText("Video-Jet");

        cbLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLinhaActionPerformed(evt);
            }
        });

        try {
            jtxtfVideo_Jet.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtxtfVideo_Jet.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtfVideo_Jet.setDoubleBuffered(true);

        jLabel1.setText("Linha");

        txtAmostra.setBackground(new java.awt.Color(255, 255, 204));

        jLabel2.setText("Perfil");

        jLabel8.setText("Qtd. Amostra");

        cbPerfil.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPerfilItemStateChanged(evt);
            }
        });
        cbPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPerfilActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtDesc_Perfil.setEditable(false);
        txtDesc_Perfil.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        txtBpcs.setEditable(false);
        txtBpcs.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        txtTrena.setDoubleBuffered(true);

        jLabel9.setText("Trena");

        txtMin.setDoubleBuffered(true);

        txtMax.setDoubleBuffered(true);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("A");

        jLabel11.setText("Desenho (Drawing)");

        jtaObservacao.setColumns(20);
        jtaObservacao.setRows(5);
        jtaObservacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Observação"));
        jScrollPane2.setViewportView(jtaObservacao);

        txtVelocidade.setEditable(false);
        txtVelocidade.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jtxtfVideo_Jet, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jdtData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTrena, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMax, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(121, 121, 121)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txtAmostra, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(cbLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtVelocidade, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBpcs, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 187, Short.MAX_VALUE))
                            .addComponent(txtDesc_Perfil))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDesc_Perfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVelocidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBpcs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(26, 26, 26)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAmostra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtfVideo_Jet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(txtTrena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setText("+");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("-");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("Menu");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Salvar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Relatório");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

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

    private void cbLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLinhaActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select * from Qry_Material where MAT_LINHA= ? and SETOR ='Extrusão' ORDER BY MATERIAL ASC ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbLinha.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            cbPerfil.removeAllItems();
            while (rs.next()) {
                cbPerfil.addItem(rs.getString("MATERIAL"));
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbLinhaActionPerformed

    private void cbPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPerfilActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select * from Qry_Material where MATERIAL=? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbPerfil.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                txtBpcs.setText(rs.getString("BPCS"));
                txtDesc_Perfil.setText(rs.getString("DESC_MATERIAL"));
                cod_id = rs.getInt("ID_MATERIAL");
                BuscaVelocidade();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbPerfilActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        salvar();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtAmostra.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha a quantidade de amostras!");
            txtAmostra.requestFocus();
        } else {
            ((DefaultTableModel) tbAmostra.getModel()).setNumRows(0);
            ((DefaultTableModel) tbAmostra.getModel()).setNumRows(Integer.valueOf(txtAmostra.getText()));
            int count = tbAmostra.getRowCount();
            for (int i = 0; i < count; i++) {
                tbAmostra.setValueAt(1 + i, +i, 1);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        final AguardeGerandoRelatório carregando = new AguardeGerandoRelatório();
        carregando.setVisible(true);
        Thread t = new Thread() {
            public void run() {
                gerarelatorio();
                carregando.dispose();
            }
        };
        t.start();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void cbPerfilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPerfilItemStateChanged

    }//GEN-LAST:event_cbPerfilItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int count = tbAmostra.getRowCount();
        ((DefaultTableModel) tbAmostra.getModel()).setNumRows(count + 1);
        for (int i = 0; i < count; i++) {
            tbAmostra.setValueAt(1 + i, +i, 1);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int count = tbAmostra.getRowCount();
        ((DefaultTableModel) tbAmostra.getModel()).setNumRows(count - 1);
        for (int i = 0; i < count; i++) {
            tbAmostra.setValueAt(1 + +i, +i, 1);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private ModelEncolhimento getModelTeste(int row) {
        Float amostra = (Float) tbAmostra.getValueAt(row, 2);
        Float amostra24 = (Float) tbAmostra.getValueAt(row, 3);
        Float amostra48 = (Float) tbAmostra.getValueAt(row, 4);
        Float amostra72 = (Float) tbAmostra.getValueAt(row, 5);
        modelEncolhimento.setData(new SimpleDateFormat("dd/MM/yyyy").format(jdtData.getDate()));
        modelEncolhimento.setHora(this.jtxtfVideo_Jet.getText());
        modelEncolhimento.setId_material(cod_id);
        modelEncolhimento.setVelocidade(Float.parseFloat(txtVelocidade.getText()));
        modelEncolhimento.setTrena(txtTrena.getText());
        modelEncolhimento.setDesenho(txtMin.getText() + " a " + txtMax.getText());
        modelEncolhimento.setObservacao(jtaObservacao.getText());
        java.util.Date pegaini1 = jdtData.getDate();
        SimpleDateFormat datachooseri1 = new SimpleDateFormat("yyyy-MM-dd");
        String datai1 = datachooseri1.format(pegaini1);
        String dhf1 = datai1 + " " + jtxtfVideo_Jet.getText() + ":00";
        modelEncolhimento.setDhjet(dhf1);
        if (amostra == null) {
            modelEncolhimento.setAmostrainicial(0);
        } else {
            modelEncolhimento.setAmostrainicial(amostra);
        }
        if (amostra24 == null) {
            modelEncolhimento.setAmostra24hrs(0);
        } else {
            modelEncolhimento.setAmostra24hrs(amostra24);
        }
        if (amostra48 == null) {
            modelEncolhimento.setAmostra48hrs(0);
        } else {
            modelEncolhimento.setAmostra48hrs(amostra48);
        }
        if (amostra72 == null) {
            modelEncolhimento.setAmostra72hrs(0);
        } else {
            modelEncolhimento.setAmostra72hrs(amostra72);
        }
        if (controllerEncolhimento.salvarEncolhimentoController(modelEncolhimento) > 0) {
            return null;
        } else {
            return null;
        }
    }

    public List<Object> getValoresAmostra() {
        List<Object> lista = new ArrayList();
        for (int i = 0; i < tbAmostra.getRowCount(); i++) {
            Object ob = getModelTeste(i);
            if (ob != null) {
                lista.add(ob);
            }
        }
        return lista;
    }

    public void gerarelatorio() {
        if (txtVelocidade.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            txtVelocidade.requestFocusInWindow();
        } else if (cbPerfil.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbPerfil.requestFocusInWindow();
        } else {
            try {
                String logo = "/images/logocooper.png";
                
                Connection con = new ConexaoSql().getCon();
                Map p = new HashMap();
                p.put("material", cbPerfil.getSelectedItem());
                p.put("velocidade", txtVelocidade.getText());
                p.put("logo", this.getClass().getResourceAsStream(logo));
                p.put("SUBREPORT_DIR", this.getClass().getResource("/Relatorios/"));
                JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Relatorios/estudo_encolhimento.jasper"));
                JasperPrint print = JasperFillManager.fillReport(jr, p, con);
                JasperViewer view = new JasperViewer(print, false);
                view.setVisible(true);
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "deu erro =" + erro);
                System.out.println(erro);
            }
        }
    }

    private void listarLinha() {
        listaModelLinha = controllerLinha.getListaLinhaDDZController();
        cbLinha.removeAllItems();
        for (int i = 0; i < listaModelLinha.size(); i++) {
            cbLinha.addItem(listaModelLinha.get(i).getLinha());
        }
    }

    public void salvar() {
        if (cbLinha.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            cbLinha.requestFocus();
        } else if (jdtData.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            jdtData.requestFocus();
        } else if (jtxtfVideo_Jet.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            jtxtfVideo_Jet.requestFocus();
        } else {
            getValoresAmostra().stream().forEach(mr -> controllerEncolhimento.salvarEncolhimentoController((ModelEncolhimento) mr));
            JOptionPane.showMessageDialog(this, "Salvo com sucesso!");
            int opcao = JOptionPane.showConfirmDialog(this, "Deseja continar cadastrando dados para o mesmo Estudo?"
                    + "?", "Atenção", JOptionPane.YES_OPTION);
            if (opcao == JOptionPane.OK_OPTION) {
                gerarelatorio();
                LimpaCampoContinue();
            } else {
                gerarelatorio();
                LimpaCampo();
            }
        }
    }

    private void LimpaCampo() {
        cbLinha.setSelectedIndex(-1);
        cbPerfil.setSelectedIndex(-1);
        txtBpcs.setText(null);
        txtDesc_Perfil.setText(null);
        jdtData.setDate(null);
        jtxtfVideo_Jet.setText(null);
        txtAmostra.setText(null);
        txtTrena.setText(null);
        txtMin.setText(null);
        txtMax.setText(null);
        ((DefaultTableModel) tbAmostra.getModel()).setNumRows(0);
    }

    private void LimpaCampoContinue() {
        jdtData.setDate(null);
        jtxtfVideo_Jet.setText(null);
        ((DefaultTableModel) tbAmostra.getModel()).setNumRows(0);
        ((DefaultTableModel) tbAmostra.getModel()).setNumRows(Integer.valueOf(txtAmostra.getText()));
    }

    private void carregaEncolhimento(int cod_perfil, String velocidade) {
        listaModelEncolhimento = controllerEncolhimento.getListaEncolhimentoController(cod_perfil, velocidade);
        DefaultTableModel modelo = (DefaultTableModel) tbAmostra.getModel();
        modelo.setNumRows(0);
        int cont = listaModelEncolhimento.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelEncolhimento.get(i).getId(),
                listaModelEncolhimento.get(i).getAmostrainicial(),
                listaModelEncolhimento.get(i).getAmostrainicial(),
                listaModelEncolhimento.get(i).getAmostra24hrs(),
                listaModelEncolhimento.get(i).getAmostra48hrs(),
                listaModelEncolhimento.get(i).getAmostra72hrs()
            });
        }
    }

    public final void BuscaVelocidade() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "SELECT "
                    + " VELOCIDADE"
                    + " FROM Velocidade_Perfil  "
                    + " WHERE "
                    + " ID_MATERIAL_ID = '" + cod_id + "' ";
            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                txtVelocidade.setText(rs.getString("VELOCIDADE"));
            }
        } catch (Exception e) {
            System.out.println(e);

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
            java.util.logging.Logger.getLogger(ViewEstudoEncolhimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewEstudoEncolhimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewEstudoEncolhimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewEstudoEncolhimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ViewEstudoEncolhimento().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbLinha;
    private javax.swing.JComboBox<String> cbPerfil;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdtData;
    private javax.swing.JTextArea jtaObservacao;
    private javax.swing.JFormattedTextField jtxtfVideo_Jet;
    private javax.swing.JTable tbAmostra;
    private javax.swing.JTextField txtAmostra;
    private javax.swing.JTextField txtBpcs;
    private javax.swing.JTextField txtDesc_Perfil;
    private javax.swing.JTextField txtMax;
    private javax.swing.JTextField txtMin;
    private javax.swing.JTextField txtTrena;
    private javax.swing.JTextField txtVelocidade;
    // End of variables declaration//GEN-END:variables
}

package com.cooperstandard.views.pontoinsp;

import com.cooperstandard.controller.extrusao.ControllerLinha;
import com.cooperstandard.controller.extrusao.ControllerMaterial;
import com.cooperstandard.controller.pontoinsp.ControllerInspControle;
import com.cooperstandard.controller.pontoinsp.ControllerResultInsp;
import com.cooperstandard.dal.config.EntityManagerHelper;
import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.entitie.Teste;
import com.cooperstandard.model.ModelInspControle;
import com.cooperstandard.model.ModelLinha;
import com.cooperstandard.model.ModelMaterial;
import com.cooperstandard.model.ModelResultInsp;
import com.cooperstandard.model.ModelSessaoUsuario;
import com.cooperstandard.tables.TableModel_Pesquisa_Testes;
import com.cooperstandard.util.ControleInstancias;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * @author rsouza10
 */
public class ViewEntradaLancamento extends javax.swing.JFrame {

    ModelLinha modelLinha = new ModelLinha();
    ControllerLinha controllerLinha = new ControllerLinha();
    ArrayList<ModelLinha> listaModeLinha = new ArrayList<>();
    ControllerMaterial controllerMaterial = new ControllerMaterial();
    ArrayList<ModelMaterial> listaModelMaterial = new ArrayList<>();
    ControllerResultInsp controllerInsp = new ControllerResultInsp();
    ArrayList<ModelResultInsp> listaModelResultInsp = new ArrayList<>();
    ModelInspControle modelinsp = new ModelInspControle();
    ControllerInspControle controllerInspControle = new ControllerInspControle();
    private static final long serialVersionUID = -3151374144339725229L;
    int perfil = 0;
    String data = "";
    String status = "";
    int id_controle = 0;
    int id_controle_reteste = 0;
    private JFrame solicitante = null;
    private final EntityManagerHelper emh;
    int pCodigoUsuario = 0;

    public ViewEntradaLancamento() {
        initComponents();
        listarLinha();
        ButtonGroup bG = new ButtonGroup();
        bG.add(btn1);
        bG.add(btn2);
        bG.add(btn3);
        carregaEspecLab();
        jButton4.setVisible(false);
        emh = new EntityManagerHelper();
        btn1.setSelected(true);
        status = "Produção";
        configurar();
    }

    public ViewEntradaLancamento(int _perfil) {
        initComponents();
        listarLinha();
        perfil = _perfil;
        ButtonGroup bG = new ButtonGroup();
        bG.add(btn1);
        bG.add(btn2);
        bG.add(btn3);
        jButton4.setVisible(false);
        emh = new EntityManagerHelper();
        configurar();
    }

    public ViewEntradaLancamento(JFrame frame) {
        initComponents();
        listarLinha();
        ButtonGroup bG = new ButtonGroup();
        bG.add(btn1);
        bG.add(btn2);
        bG.add(btn3);
        jButton4.setVisible(false);
        solicitante = frame;
        emh = new EntityManagerHelper();
    }

    public void setSolicitante(JFrame solicitante) {
        this.solicitante = solicitante;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbNovaProjeto = new javax.swing.JLabel();
        txtNovaProjeto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        cbPerfil = new javax.swing.JComboBox<>();
        jdcData = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtHora = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtSolicitante = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        cbLinha = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btn1 = new javax.swing.JCheckBox();
        btn2 = new javax.swing.JCheckBox();
        btn3 = new javax.swing.JCheckBox();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }

            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel2.setBackground(new java.awt.Color(2, 83, 161));

        jPanel1.setBackground(new java.awt.Color(241, 176, 19));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Perfil:");

        lbNovaProjeto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNovaProjeto.setText("Projeto:");

        txtNovaProjeto.setEditable(false);
        txtNovaProjeto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNovaProjeto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNovaProjeto.setEnabled(false);
        txtNovaProjeto.setFocusable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Descrição:");

        txtDescricao.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDescricao.setEnabled(false);

        cbPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPerfilActionPerformed(evt);
            }
        });

        jdcData = new JDateChooser("dd/MM/yyyy", "##/##/#####", '_');

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Data videojet:");

        try {
            txtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Hora videojet:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Solicitante:");

        jToggleButton1.setText("jToggleButton1");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        cbLinha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        cbLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLinhaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Linha:");

        btn1.setBackground(new java.awt.Color(0, 0, 0));
        btn1.setForeground(new java.awt.Color(255, 255, 255));
        btn1.setText("Produção");
        btn1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setBackground(new java.awt.Color(0, 0, 0));
        btn2.setForeground(new java.awt.Color(255, 255, 255));
        btn2.setText("Re-Teste");
        btn2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn3.setBackground(new java.awt.Color(0, 0, 0));
        btn3.setForeground(new java.awt.Color(255, 255, 255));
        btn3.setText("Try-Out");
        btn3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-pesquisar-filled-50.png"))); // NOI18N
        jButton4.setText("Pesquisa Reprovados");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbNovaProjeto)
                                                                        .addComponent(txtNovaProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel9)
                                                                                .addGap(0, 139, Short.MAX_VALUE))
                                                                        .addComponent(txtSolicitante)))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(txtDescricao)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel5)
                                                                        .addComponent(cbLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel2)
                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                        .addComponent(cbPerfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jLabel6)
                                                                        .addComponent(jdcData, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(73, 73, 73)
                                                .addComponent(btn1)
                                                .addGap(18, 18, 18)
                                                .addComponent(btn2)
                                                .addGap(18, 18, 18)
                                                .addComponent(btn3)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(jButton4)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn3)
                                        .addComponent(btn1)
                                        .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(26, 26, 26))
                                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(lbNovaProjeto)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtNovaProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jdcData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jToggleButton1)
                                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(26, 26, 26)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-arquivo-filled-50.png"))); // NOI18N
        jButton1.setText("Abrir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-arquivo-filled-50.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(504, 504, 504)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2)
                                        .addComponent(jButton1))
                                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jScrollPane5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jTable5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Perfil", "Data", "Hora", "Analista"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTable5.setGridColor(new java.awt.Color(255, 255, 255));
        jTable5.setRowHeight(22);
        jScrollPane5.setViewportView(jTable5);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ultimos registros:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(0, 333, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPerfilActionPerformed
        try {
            final String query1 = "Select * from Cad_Material where MATERIAL =? ";
            final PreparedStatement st = new ConexaoSql().getCon().prepareStatement(query1);
            st.setString(1, cbPerfil.getSelectedItem().toString());
            final ResultSet rs = st.executeQuery();

            while (rs.next()) {
                txtDescricao.setText(rs.getString("DESC_MATERIAL"));
                txtNovaProjeto.setText(rs.getString("MAT_PROJETO"));
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_cbPerfilActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jdcData.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!");
        } else if (txtHora.getText() == null) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!");
        } else if (!btn1.isSelected() && !btn2.isSelected() && !btn3.isSelected()) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!");
        } else {
            Date fecha = jdcData.getDate();
            DateFormat f = new SimpleDateFormat("dd-MM-yyyy");
            String hora = f.format(fecha);
            if (btn2.isSelected()) {
                new ViewLancamentoReteste(Integer.valueOf(cbPerfil.getSelectedItem().toString()), txtSolicitante.getText(), hora, txtHora.getText(), status, id_controle_reteste).setVisible(true);
            } else {
                SalvaRegistro();
                pegaid();
                List<?> resultado = new ArrayList();
                ViewSeletorTeste seletor = (ViewSeletorTeste) ControleInstancias.getInstance(ViewSeletorTeste.class.getName(), ViewSeletorTeste.class);
                TableModel_Pesquisa_Testes model = new TableModel_Pesquisa_Testes();
                List<Teste> testes = (List<Teste>) emh.getObjectListNamedQuery(Teste.class, "teste.findByID_MATERIAL_ID", new String[]{"paramID_MATERIAL_ID"}, new Object[]{Integer.valueOf(cbPerfil.getSelectedItem().toString())}, EntityManagerHelper.SQLSERVER_PU).orElse(new ArrayList());
                model.setLista(testes);
                seletor.setParametrosComportamento(model, resultado);
                seletor.setVisible(true);
                seletor.getBtConfirmar().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        List<Teste> resultados = (List<Teste>) seletor.getResultado();
                        resultados.forEach(result -> {
                            try {
                                final Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
                                final String sql = "INSERT INTO dbo.Cad_ResultadoInsp (TIPO,DATA_REGISTRO,ANALISTA,ID_ESPECIFICACAO_ID,ID_CONTROLE ) values (?,?,?,?,?)";
                                final PreparedStatement st = new ConexaoSql().getCon().prepareStatement(sql);
                                st.setString(1, status);
                                st.setTimestamp(2, dataDeHoje);
                                st.setInt(3, pCodigoUsuario);
                                st.setLong(4, result.getId());
                                st.setInt(5, id_controle);
                                st.executeUpdate();
                                st.close();
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            System.out.println(result);
                        });
                        new ViewLancamento(Integer.valueOf(cbPerfil.getSelectedItem().toString()), txtSolicitante.getText(), hora, txtHora.getText(), status, id_controle).setVisible(true);
                    }
                });

            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpacampo();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT-03:00"));
        String datavideo = sdf.format(new Date());
        txtHora.setText(datavideo);

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyyy");
        java.util.Date hora1 = Calendar.getInstance().getTime();
        String dataFormatada1 = sdf1.format(hora1);
        jdcData.setDate(hora1);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        if (btn1.isSelected()) {
            status = "Produção";
            habilitacampo();
            jToggleButton1.setVisible(true);
            jButton4.setVisible(false);
        }
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        if (btn2.isSelected()) {
            status = "Re-Teste";
            limpacampo();
            desabilitacampo();
            jToggleButton1.setVisible(false);
            jButton4.setVisible(true);
            jdcData.setDate(null);
            txtHora.setText("");
        }
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        if (btn3.isSelected()) {
            status = "Try-Out";
            habilitacampo();
            jToggleButton1.setVisible(true);
            jButton4.setVisible(false);
        }
    }//GEN-LAST:event_btn3ActionPerformed

    private void cbLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLinhaActionPerformed
        try {
            final String query1 = "Select distinct MATERIAL, BPCS from Cad_Material where MAT_LINHA= ? order by MATERIAL";
            final PreparedStatement st = new ConexaoSql().getCon().prepareStatement(query1);
            st.setString(1, cbLinha.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            cbPerfil.removeAllItems();
            while (rs.next()) {
                cbPerfil.addItem(rs.getString("MATERIAL"));
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_cbLinhaActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        carregaEspecLab();
    }//GEN-LAST:event_formWindowGainedFocus

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ViewPesquisaReprovado vm = null;
        if (ControleInstancias.isInstaced(ViewPesquisaReprovado.class)) {
            vm = (ViewPesquisaReprovado) ControleInstancias.getInstance(ViewPesquisaReprovado.class.getName(), ViewPesquisaReprovado.class);
            vm.setSolicitante(this);
        } else {
            vm = new ViewPesquisaReprovado(this);
        }
        vm.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    public void addItemCampo(String id, String linha, String perfil, String solicitante, String data, String hora) {
        id_controle_reteste = Integer.valueOf(id);
        cbLinha.setSelectedItem(linha);
        cbPerfil.setSelectedItem(perfil);
        txtSolicitante.setText(solicitante);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        try {
            date = (Date) formatter.parse(data);
            jdcData.setDate(date);
        } catch (ParseException ex) {
        }
        txtHora.setText(hora);
    }

    private void listarLinha() {
        listaModeLinha = controllerLinha.getListaLinhaGeralController();
        cbLinha.removeAllItems();
        for (int i = 0; i < listaModeLinha.size(); i++) {
            cbLinha.addItem(listaModeLinha.get(i).getLinha());
        }
    }

    private void carregaEspecLab() {
        listaModelResultInsp = controllerInsp.getListaStatusResultInspController();
        DefaultTableModel modelo = (DefaultTableModel) jTable5.getModel();
        modelo.setNumRows(0);
        int cont = listaModelResultInsp.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                    listaModelResultInsp.get(i).getId_material_id(),
                    listaModelResultInsp.get(i).getData_jet(),
                    listaModelResultInsp.get(i).getHora_jet(),
                    listaModelResultInsp.get(i).getUsuario()
            });
        }
    }

    public void limpacampo() {
        cbLinha.setSelectedIndex(-1);
        cbPerfil.setSelectedIndex(-1);
        txtDescricao.setText("");
        txtNovaProjeto.setText("");
        txtSolicitante.setText("");
        jdcData.setDate(null);
        txtHora.setText("");
        btn1.setSelected(false);
        btn2.setSelected(false);
        btn3.setSelected(false);
    }

    public void desabilitacampo() {
        cbLinha.setEnabled(false);
        cbPerfil.setEnabled(false);
        txtDescricao.setEnabled(false);
        txtNovaProjeto.setEnabled(false);
        txtSolicitante.setEnabled(false);
        jdcData.setEnabled(false);
        txtHora.setEnabled(false);
    }

    public void habilitacampo() {
        cbLinha.setEnabled(true);
        cbPerfil.setEnabled(true);
        txtNovaProjeto.setEnabled(true);
        txtSolicitante.setEnabled(true);
        jdcData.setEnabled(true);
        txtHora.setEnabled(true);
    }

    private void pegaid() {
        try {
            final String query1 = "Select top (1) ID from INSP_Controle order by id desc";
            final PreparedStatement st = new ConexaoSql().getCon().prepareStatement(query1);
            final ResultSet rs = st.executeQuery();
            while (rs.next()) {
                id_controle = rs.getInt("ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean SalvaRegistro() {
        modelinsp.setPerfil(Integer.parseInt(cbPerfil.getSelectedItem().toString()));
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.s");
        Date data = new Date();
        modelinsp.setData_base(format.format(data));
        modelinsp.setData_jet(new SimpleDateFormat("dd/MM/yyyy").format(jdcData.getDate()));
        modelinsp.setHora_jet(txtHora.getText());
        modelinsp.setSolicitante(txtSolicitante.getText());
        if (controllerInspControle.salvarInspControleController(modelinsp) > 0) {
            JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
            carregaEspecLab();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao tentar gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public int retornarUsuarioLogado() {
        return new ModelSessaoUsuario().codigo;
    }

    private void configurar() {
        pCodigoUsuario = retornarUsuarioLogado();
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
            java.util.logging.Logger.getLogger(ViewEntradaLancamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewEntradaLancamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewEntradaLancamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewEntradaLancamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewEntradaLancamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox btn1;
    private javax.swing.JCheckBox btn2;
    private javax.swing.JCheckBox btn3;
    private javax.swing.JComboBox<String> cbLinha;
    private javax.swing.JComboBox<String> cbPerfil;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable5;
    private javax.swing.JToggleButton jToggleButton1;
    private com.toedter.calendar.JDateChooser jdcData;
    private javax.swing.JLabel lbNovaProjeto;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JFormattedTextField txtHora;
    private javax.swing.JTextField txtNovaProjeto;
    private javax.swing.JTextField txtSolicitante;
    // End of variables declaration//GEN-END:variables
}

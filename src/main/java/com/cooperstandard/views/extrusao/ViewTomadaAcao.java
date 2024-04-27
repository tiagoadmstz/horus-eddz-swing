package com.cooperstandard.views.extrusao;

import com.cooperstandard.controller.extrusao.ControllerDDZ;
import com.cooperstandard.controller.extrusao.ControllerLinha;
import com.cooperstandard.model.ModelDDZ;
import com.cooperstandard.model.ModelLinha;
import com.cooperstandard.util.DisparaEmail;
import com.cooperstandard.util.EstiloTablaRenderer;
import com.cooperstandard.util.HeaderRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rsouza10
 */
public class ViewTomadaAcao extends javax.swing.JFrame {

    ModelDDZ modelddz = new ModelDDZ();
    ControllerDDZ controllerddz = new ControllerDDZ();
    ArrayList<ModelDDZ> listaModelddz = new ArrayList<>();
    ControllerLinha controllerLinha = new ControllerLinha();
    ArrayList<ModelLinha> listaModelLinha = new ArrayList<>();
    DisparaEmail email = new DisparaEmail();
    int id_material = 0;
    String data_problema;
    double velocidade = 0;
    double onehour = 0;
    double fourhour = 0;
    String emaillinha;

    public ViewTomadaAcao() {
        initComponents();
        carregatabela("");
        listarLinha();
        tbacao.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbacao));
        tbacao.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
        tbacao.setDefaultRenderer(String.class, new EstiloTablaRenderer());
        tbacao.setDefaultRenderer(Float.class, new EstiloTablaRenderer());
        tbacao.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        limparDados();
        jMenuItem2.addActionListener((ActionEvent e) -> {
            int index = getTbacao().getSelectedRow();
            String id = tbacao.getValueAt(index, 0).toString();
            txtId.setText(id);
            String qtd_scrap = (String) tbacao.getValueAt(index, 4);
            txtScrap.setText(String.valueOf(qtd_scrap));
            String qtd_scrap_reais = (String) tbacao.getValueAt(index, 5);
            txtScrap_reais.setText(String.valueOf(qtd_scrap_reais));
            String problema = (String) tbacao.getValueAt(index, 8);
            txtProblema.setText(problema);
            String causa = (String) tbacao.getValueAt(index, 9);
            txtCausa.setText(causa);
            String obs = (String) tbacao.getValueAt(index, 10);
            jtxtObservacao.setText(obs);
            Float qtd_scrap_kg = (Float) tbacao.getValueAt(index, 6);
            txtScrapKg.setText(String.valueOf(qtd_scrap_kg));
            data_problema = tbacao.getValueAt(index, 1).toString();
        });
    }

    public JTable getTbacao() {
        return tbacao;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtaAcaotomada = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbacao = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtxtObservacao = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtProblema = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCausa = new javax.swing.JTextField();
        txtScrap = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtScrap_reais = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtScrapKg = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtParticipantes = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbLinha = new javax.swing.JComboBox<>();
        cbPerfil = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtDesc_perfil = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtBpcs = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lbId = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jMenuItem2.setText("Selecionar");
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(2, 83, 161));

        JtaAcaotomada.setBackground(new java.awt.Color(204, 255, 204));
        JtaAcaotomada.setColumns(20);
        JtaAcaotomada.setRows(5);
        JtaAcaotomada.setBorder(javax.swing.BorderFactory.createTitledBorder("Observação"));
        jScrollPane1.setViewportView(JtaAcaotomada);

        tbacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Data", "Hora", "Material", "Qtd. Scarp (M)", "Qtd. Scrap (R$)", "Qtd. Scrap (Kg)", "Status", "PROBLEMA", "CAUSA", "OBSERVACAO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbacao.getTableHeader().setReorderingAllowed(false);
        tbacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbacaoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbacao);
        if (tbacao.getColumnModel().getColumnCount() > 0) {
            tbacao.getColumnModel().getColumn(0).setMinWidth(0);
            tbacao.getColumnModel().getColumn(0).setMaxWidth(0);
            tbacao.getColumnModel().getColumn(8).setMinWidth(0);
            tbacao.getColumnModel().getColumn(8).setMaxWidth(0);
            tbacao.getColumnModel().getColumn(9).setMinWidth(0);
            tbacao.getColumnModel().getColumn(9).setMaxWidth(0);
            tbacao.getColumnModel().getColumn(10).setMinWidth(0);
            tbacao.getColumnModel().getColumn(10).setMaxWidth(0);
        }

        jPanel2.setBackground(new java.awt.Color(241, 176, 19));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jtxtObservacao.setEditable(false);
        jtxtObservacao.setColumns(20);
        jtxtObservacao.setForeground(new java.awt.Color(255, 0, 0));
        jtxtObservacao.setRows(5);
        jScrollPane3.setViewportView(jtxtObservacao);

        jLabel5.setText("Observação");

        jLabel6.setText("Problema");

        txtProblema.setEditable(false);
        txtProblema.setForeground(new java.awt.Color(255, 0, 0));

        jLabel7.setText("Causa");

        txtCausa.setEditable(false);
        txtCausa.setForeground(new java.awt.Color(255, 0, 0));

        txtScrap.setBackground(new java.awt.Color(255, 102, 102));
        txtScrap.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel10.setText("Scrap metros:");

        txtScrap_reais.setBackground(new java.awt.Color(255, 102, 102));
        txtScrap_reais.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel12.setText("Scrap reais:");

        txtScrapKg.setBackground(new java.awt.Color(255, 102, 102));
        txtScrapKg.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel13.setText("Scrap Kg:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProblema))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(txtScrapKg, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtScrap, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtScrap_reais, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCausa)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(235, 235, 235))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtProblema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtScrapKg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtScrap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCausa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel5))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtScrap_reais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtParticipantes.setBackground(new java.awt.Color(255, 255, 204));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Participantes:");

        jSpinner1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nv. prioridade");

        jPanel1.setBackground(new java.awt.Color(241, 176, 19));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Linha");

        cbLinha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLinhaActionPerformed(evt);
            }
        });

        cbPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPerfilActionPerformed(evt);
            }
        });

        jLabel2.setText("Perfil");

        txtDesc_perfil.setEditable(false);

        jLabel3.setText("Descrição do perfil");

        txtBpcs.setEditable(false);

        jLabel4.setText("BPCS");

        txtId.setEnabled(false);

        lbId.setText("Código:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cbLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDesc_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtBpcs, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBpcs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDesc_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tomada de ação:");

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Responsável:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lucas Coelho", "Carlos Matos", "João Moura", "Sander Teixeira", "José Serafim", "Iuri Fernandes", "Arcísio de Paula", "Wandersson Inácio", "Antônio Assis", "Francisco Souza", "Virginia Leite", "Vanessa Leite", "Rodrigo Carneiro", "Mauricio Silva" }));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Plano:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtParticipantes))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(201, 201, 201)
                        .addComponent(jLabel11))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtParticipantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addGap(328, 328, 328)))
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

        jMenuItem3.setText("jMenuItem3");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-document-save-icon.png"))); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                id_material = rs.getInt("ID_MATERIAL");
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
                txtDesc_perfil.setText(rs.getString("DESC_MATERIAL"));
                txtBpcs.setText(rs.getString("BPCS"));
            }
        } catch (Exception e) {

        }

        cbPerfil.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                carregatabela(cbPerfil.getSelectedItem().toString());
            }
        });
    }//GEN-LAST:event_cbPerfilActionPerformed

    private void tbacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbacaoMouseClicked
        int linhasselecionada = tbacao.getSelectedRow();

        if (linhasselecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item antes de clicar com o mouse!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {

            if (evt.getButton() == MouseEvent.BUTTON3) {
                jPopupMenu1.show(tbacao, evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_tbacaoMouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        alterarAcao();
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void listarLinha() {
        listaModelLinha = controllerLinha.getListaLinhaDDZController();
        cbLinha.removeAllItems();
        for (int i = 0; i < listaModelLinha.size(); i++) {
            cbLinha.addItem(listaModelLinha.get(i).getLinha());
        }
    }

    private void limparDados() {
        JtaAcaotomada.setText("");
        txtProblema.setText("");
        txtScrapKg.setText("");
        txtScrap.setText("");
        txtScrap_reais.setText("");
        txtCausa.setText("");
        jtxtObservacao.setText("");
        jComboBox1.setSelectedIndex(0);
        jSpinner1.setValue(0);
        jDateChooser2.setDate(null);
    }

    private void carregatabela(String perfil) {
        PegaVelocidade();
        calculameta();
        listaModelddz = controllerddz.getListaAcaoDDZController(perfil, onehour, fourhour);
        DefaultTableModel modelo = (DefaultTableModel) tbacao.getModel();
        modelo.setNumRows(0);
        int cont = listaModelddz.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelddz.get(i).getId(),
                new SimpleDateFormat("dd/MM/yyyy").format(listaModelddz.get(i).getData()),
                new SimpleDateFormat("HH:mm").format(listaModelddz.get(i).getHora()),
                listaModelddz.get(i).getMaterial(),
                String.valueOf(String.format("%1$,.0f", listaModelddz.get(i).getQtd_scrap())),
                String.valueOf(String.format("%1$,.0f", listaModelddz.get(i).getQtd_scrap_reais())),
                listaModelddz.get(i).getQtd_scrap_kg(),
                (!"".equals(listaModelddz.get(i).getAcao_tomada()) ? "OK" : "PENDENTE"),
                listaModelddz.get(i).getDesc_problema(),
                listaModelddz.get(i).getDesc_causa(),
                listaModelddz.get(i).getObservacao()
            });
        }
    }

    private void calculameta() {
        double metros_hora = velocidade * 60;
        double total_metros_produzido = (metros_hora * 5);
        double scrap = (total_metros_produzido * 7) * (0.01);
        onehour = scrap * 0.5;
        fourhour = onehour / 4;
    }

    private void alterarAcao() {
        if (txtParticipantes.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            txtParticipantes.requestFocus();
        } else if (jComboBox1.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            jComboBox1.requestFocus();
        } else if (jDateChooser2.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            jDateChooser2.requestFocus();
        } else if (JtaAcaotomada.getText() == null) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            JtaAcaotomada.requestFocus();
        } else if (jSpinner1.getValue().equals(0)) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            JtaAcaotomada.requestFocus();
        } else {
            modelddz.setId(Integer.parseInt(this.txtId.getText()));
            modelddz.setResponsavel(this.jComboBox1.getSelectedItem().toString());
            modelddz.setParticipantes(this.txtParticipantes.getText());
            modelddz.setData_plano(new SimpleDateFormat("dd/MM/yyyy").format(jDateChooser2.getDate()));
            modelddz.setPrioridade((int) this.jSpinner1.getValue());
            modelddz.setAcao_tomada(JtaAcaotomada.getText());
            modelddz.setStatus("Pendente");
            modelddz.setAvaliacao("Pendente");
            if (controllerddz.atualizaAcaoController(modelddz)) {
                JOptionPane.showMessageDialog(this, "Ação tomada com sucesso!");
                this.carregatabela(cbPerfil.getSelectedItem().toString());
                RelacaoLinha();
                email.Email(cbPerfil.getSelectedItem().toString(), txtBpcs.getText(), cbLinha.getSelectedItem().toString(), emaillinha,
                        txtScrapKg.getText(), txtScrap.getText(), txtScrap_reais.getText(), new SimpleDateFormat("dd/MM/yyyy").format(jDateChooser2.getDate()), txtProblema.getText(),
                        txtCausa.getText(), jtxtObservacao.getText(), jComboBox1.getSelectedItem().toString(), txtParticipantes.getText(), JtaAcaotomada.getText(), (int) jSpinner1.getValue(), data_problema);
                limparDados();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao alterar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void PegaVelocidade() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "SELECT VELOCIDADE FROM Velocidade_Perfil FULL OUTER JOIN Qry_Material ON ID_MATERIAL_ID = ID_MATERIAL where MATERIAL=? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbPerfil.getSelectedItem().toString().split(" - ")[0]);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                velocidade = 0;
                velocidade = rs.getDouble("VELOCIDADE");
            }
        } catch (Exception e) {
        }
    }

    private void RelacaoLinha() {
        switch (jLabel2.getText()) {
            case "L07":
            case "L08":
                emaillinha = "rafael.souza@cooperstandard.com";
                break;
            case "L04":
            case "L06":
                emaillinha = "ricardo.porto@cooperstandard.com";
                break;
            case "L12":
                emaillinha = "larissa.hemeterio@cooperstandard.com";
                break;
            case "L17":
                emaillinha = "raphael.vilela@cooperstandard.com";
                break;
            case "L09":
            case "L11":
                emaillinha = "carlos.ferreira2@cooperstandard.com";
                break;
            default:
                break;
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewTomadaAcao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTomadaAcao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTomadaAcao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTomadaAcao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewTomadaAcao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea JtaAcaotomada;
    private javax.swing.JComboBox<String> cbLinha;
    private javax.swing.JComboBox<String> cbPerfil;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextArea jtxtObservacao;
    private javax.swing.JLabel lbId;
    private javax.swing.JTable tbacao;
    private javax.swing.JTextField txtBpcs;
    private javax.swing.JTextField txtCausa;
    private javax.swing.JTextField txtDesc_perfil;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtParticipantes;
    private javax.swing.JTextField txtProblema;
    private javax.swing.JTextField txtScrap;
    private javax.swing.JTextField txtScrapKg;
    private javax.swing.JTextField txtScrap_reais;
    // End of variables declaration//GEN-END:variables
}

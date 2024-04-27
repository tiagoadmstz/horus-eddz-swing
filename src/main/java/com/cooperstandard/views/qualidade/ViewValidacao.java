/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.views.qualidade;

import com.cooperstandard.controller.extrusao.ControllerFichaControle;
import com.cooperstandard.model.ModelFichaControle;
import com.cooperstandard.util.EstiloTablaRenderer;
import com.cooperstandard.util.HeaderRenderer;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author rsouza10
 */
public class ViewValidacao extends javax.swing.JFrame {

    ModelFichaControle modelFichaControle = new ModelFichaControle();
    ControllerFichaControle controllerFichaControle = new ControllerFichaControle();
    ArrayList<ModelFichaControle> listaModelFichaControle = new ArrayList<ModelFichaControle>();

    public ViewValidacao() {
        initComponents();
        tbValidacao.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbValidacao));
        tbValidacao.setDefaultRenderer(String.class, new EstiloTablaRenderer());
        tbValidacao.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
        tbValidacao.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        carregaListaPendencia();
        listarLinha();
//        listarMaterial();
        jPanel3.setVisible(false);
        LimparGeral();
    }

    public void EntraDados() {
        if (txt_status.getText().contains("Pendente") || txt_status.getText().contains("Restauração de Versão")) {
            if (cbLinha.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Campo Obrigatório!", "", JOptionPane.WARNING_MESSAGE);
                cbLinha.requestFocusInWindow();
            } else if (cbMaterial.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Campo Obrigatório!", "", JOptionPane.WARNING_MESSAGE);
                cbMaterial.requestFocusInWindow();
            } else if (JDateChooser1.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Campo Obrigatório!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                JDateChooser1.requestFocusInWindow();
                JDateChooser1.setDate(null);
            } else if (EntradadadosHora.getText().trim().length() < 4) {
                JOptionPane.showMessageDialog(null, "Campo Obrigatório!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                EntradadadosHora.requestFocusInWindow();
                EntradadadosHora.setText(null);
            } else {
                Date fecha = JDateChooser1.getDate();
                DateFormat f = new SimpleDateFormat("yyyy/MM/dd");
                String fecha2 = f.format(fecha);
                EntradadadosData.setText(fecha2);
                new ViewAprovacao(cbMaterial.getSelectedItem().toString(), EntradadadosData.getText(), EntradadadosHora.getText(), EntradadadosDesenho.getText(), EntradadadosProjeto.getText(), EntradadadosPlano.getText(), EntradadadosOem.getText(), entradadadosDescMaterial.getText(), EntradadadosEnviaLinha.getText(), txt_emitente.getText(), txt_rev.getText(), txt_responsavel.getText(), combo_setor.getSelectedItem().toString(), txtRevPlan.getText(), txtEmitentePlan.getText(), txtResponsavelPlan.getText()).setVisible(true);
                dispose();
            }
        } else {
            if (cbLinha.getSelectedItem().toString().contains("L")) {
                new ViewFichaControleQualidade(cbMaterial.getSelectedItem().toString(), cbLinha.getSelectedItem().toString(), txt_status.getText(), txt_emitente.getText(), "Novo").setVisible(true);
                dispose();
            } else {
                new ViewFichaControleQualidadeAc(cbMaterial.getSelectedItem().toString(), cbLinha.getSelectedItem().toString(), txt_status.getText(), txt_emitente.getText(), "Novo").setVisible(true);
                dispose();
            }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbValidacao = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        JDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        cbMaterial = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        EntradadadosHora = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        cbLinha = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        combo_setor = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txt_responsavel = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        EntradadadosDesenho = new javax.swing.JTextField();
        EntradadadosProjeto = new javax.swing.JTextField();
        EntradadadosPlano = new javax.swing.JTextField();
        EntradadadosOem = new javax.swing.JTextField();
        EntradadadosEnviaLinha = new javax.swing.JTextField();
        entradadadosDescMaterial = new javax.swing.JTextField();
        EntradadadosData = new javax.swing.JTextField();
        txt_rev = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        txt_status = new javax.swing.JTextField();
        txtRevPlan = new javax.swing.JTextField();
        txtEmitentePlan = new javax.swing.JTextField();
        txtResponsavelPlan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_emitente = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        txtBusca = new javax.swing.JTextField();
        lbBusca = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbValidacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Data", "Linha", "Material", "Montadora", "Solicitante", "Status", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbValidacao.getTableHeader().setReorderingAllowed(false);
        tbValidacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbValidacaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbValidacao);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Data:");

        JDateChooser1 = new JDateChooser("dd/MM/yyyy", "##/##/#####", '_');
        JDateChooser1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JDateChooser1KeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Material:");

        cbMaterial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaterialActionPerformed(evt);
            }
        });
        cbMaterial.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbMaterialPropertyChange(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Hora:");

        try {
            EntradadadosHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        EntradadadosHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EntradadadosHora.setText("");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Linha:");

        cbLinha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLinhaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Observação:");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 2, 13)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("Setor:");

        combo_setor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Garantia da Qualidade", "Engenharia de Processo" }));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Responsável:");

        EntradadadosDesenho.setFocusable(false);

        EntradadadosProjeto.setFocusable(false);

        EntradadadosPlano.setFocusable(false);

        EntradadadosOem.setFocusable(false);

        EntradadadosEnviaLinha.setFocusable(false);

        entradadadosDescMaterial.setFocusable(false);

        EntradadadosData.setFocusable(false);

        txt_status.setFocusable(false);

        txtRevPlan.setEditable(false);
        txtRevPlan.setEnabled(false);

        txtEmitentePlan.setEditable(false);

        txtResponsavelPlan.setEditable(false);
        txtResponsavelPlan.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(EntradadadosData, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 94, Short.MAX_VALUE)
                    .addComponent(EntradadadosDesenho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 94, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 94, Short.MAX_VALUE)
                    .addComponent(EntradadadosProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 94, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 94, Short.MAX_VALUE)
                    .addComponent(EntradadadosPlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 94, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 94, Short.MAX_VALUE)
                    .addComponent(EntradadadosOem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 94, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 94, Short.MAX_VALUE)
                    .addComponent(EntradadadosEnviaLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 94, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 94, Short.MAX_VALUE)
                    .addComponent(entradadadosDescMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 94, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 94, Short.MAX_VALUE)
                    .addComponent(txt_rev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 94, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 94, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 94, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 94, Short.MAX_VALUE)
                    .addComponent(txt_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 94, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 94, Short.MAX_VALUE)
                    .addComponent(txtRevPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 94, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 94, Short.MAX_VALUE)
                    .addComponent(txtEmitentePlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 94, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 94, Short.MAX_VALUE)
                    .addComponent(txtResponsavelPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 94, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(EntradadadosData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(EntradadadosDesenho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(EntradadadosProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(EntradadadosPlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(EntradadadosOem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(EntradadadosEnviaLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(entradadadosDescMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(txt_rev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(txt_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(txtRevPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(txtEmitentePlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(txtResponsavelPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(combo_setor, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(txt_responsavel)))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel8))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_setor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_responsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Emitente:");

        txt_emitente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_emitenteKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EntradadadosHora, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txt_emitente))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EntradadadosHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_emitente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-atualizaçSes-disponíveis-filled-50.png"))); // NOI18N
        jButton3.setText("Atualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtBusca.setBackground(new java.awt.Color(255, 255, 204));
        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaKeyReleased(evt);
            }
        });

        lbBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/filter_16px_1116123_easyicon.net.png"))); // NOI18N

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-pesquisar-filled-50.png"))); // NOI18N
        jButton2.setText("Visualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-n¦o-perturbe-filled-50.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(255, 255, 255));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-selecionado-filled-50.png"))); // NOI18N
        jButton13.setText("Selecionar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbBusca))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbBusca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbValidacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbValidacaoMouseClicked
        if (evt.getClickCount() == 2) {

        }
    }//GEN-LAST:event_tbValidacaoMouseClicked

    private void cbMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaterialActionPerformed
        try {

            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select * from Qry_Result where ESP_MATERIAL=? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbMaterial.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ////
                EntradadadosProjeto.setText(rs.getString("MAT_PROJETO"));
                EntradadadosDesenho.setText(rs.getString("N_DESENHO"));
                EntradadadosPlano.setText(rs.getString("N_PLANO"));
                EntradadadosOem.setText(rs.getString("PRO_OEM"));
                EntradadadosEnviaLinha.setText(rs.getString("ESP_LINHA"));
                entradadadosDescMaterial.setText(rs.getString("DESC_MATERIAL"));

            }

        } catch (Exception e) {
        }

        try {
            
            Connection con1 = new ConexaoSql().getCon();
            String query = "Select MAX(ROD_REV) as value,MAX(ROD_EMITENTE)as value2,MAX(ROD_RESPONSAVEL)as value3 from Cad_Rodape where  ROD_MATERIAL='" + cbMaterial.getSelectedItem() + "' ";
            PreparedStatement st1 = con1.prepareStatement(query);
            ResultSet rs1 = st1.executeQuery();

            while (rs1.next()) {
                ////
                txt_rev.setText(rs1.getString("value"));
                txt_emitente.setText(rs1.getString("value2"));
                txt_responsavel.setText(rs1.getString("value3"));

            }
        } catch (Exception e) {
        }

        //  \\\\\\\\\\\\\\\\\\
        try {
            
            Connection con1 = new ConexaoSql().getCon();
            String query = "Select MAX(RODPLAN_REV) as value,MAX(RODPLAN_EMITENTE)as value2,MAX(RODPLAN_RESPONSAVEL)as value3 from Cad_RodPlan where  RODPLAN_LINHA='" + cbLinha.getSelectedItem() + "' ";
            PreparedStatement st1 = con1.prepareStatement(query);
            ResultSet rs2 = st1.executeQuery();

            while (rs2.next()) {
                ////
                txtRevPlan.setText(rs2.getString("value"));
                txtEmitentePlan.setText(rs2.getString("value2"));
                txtResponsavelPlan.setText(rs2.getString("value3"));

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbMaterialActionPerformed

    private void cbMaterialPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbMaterialPropertyChange

        cbMaterial.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {

                    JDateChooser1.setDate(null);
                    EntradadadosHora.setText("");
                    EntradadadosProjeto.setText("");
                    EntradadadosDesenho.setText("");
                    EntradadadosPlano.setText("");
                    EntradadadosOem.setText("");
                    EntradadadosEnviaLinha.setText("");
                    entradadadosDescMaterial.setText("");

                }
            }
        });
    }//GEN-LAST:event_cbMaterialPropertyChange

    private void cbLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLinhaActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select DISTINCT ESP_MATERIAL from Qry_Cadastro where ESP_LINHA= ? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbLinha.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            cbMaterial.removeAllItems();

            while (rs.next()) {

                cbMaterial.addItem(rs.getString("ESP_MATERIAL"));
            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_cbLinhaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LimparGeral();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (cbLinha.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo Obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbLinha.requestFocusInWindow();
        } else if (cbMaterial.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo Obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbMaterial.requestFocusInWindow();
        } else if (txt_emitente.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo Obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            txt_emitente.requestFocusInWindow();
        } else if (JDateChooser1.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Campo Obrigatório!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            JDateChooser1.requestFocusInWindow();
            JDateChooser1.setDate(null);
        } else if (EntradadadosHora.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo Obrigatório!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            EntradadadosHora.requestFocusInWindow();
            EntradadadosHora.setText(null);
        } else {
            EntraDados();
        }
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            EntraDados();
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        carregaListaPendencia();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyReleased
        DefaultTableModel tabela = (DefaultTableModel) this.tbValidacao.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabela);
        this.tbValidacao.setRowSorter(sorter);
        String text = txtBusca.getText();
        sorter.setRowFilter(RowFilter.regexFilter(text, 1, 2, 3, 4, 5));
    }//GEN-LAST:event_txtBuscaKeyReleased

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        int linhasselecionada = tbValidacao.getSelectedRow();

        if (linhasselecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item na tabela antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {

            int i = tbValidacao.getSelectedRow();
            TableModel model = tbValidacao.getModel();
            cbLinha.setSelectedItem(Objects.toString(model.getValueAt(i, 1), ""));
            cbMaterial.setSelectedItem(Objects.toString(model.getValueAt(i, 2), ""));
            txt_status.setText(Objects.toString(model.getValueAt(i, 5), ""));
            jTextArea1.setText(Objects.toString(model.getValueAt(i, 6), ""));
            if (txt_status.getText().equals("Protótipo") || txt_status.getText().equals("Produção") || txt_status.getText().equals("Pré-Lançamento")) {
                jPanel4.setVisible(false);
            } else {
                jPanel4.setVisible(true);
            }
            JDateChooser1.setDate(new Date());
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date hora = Calendar.getInstance().getTime();
            String dataFormatada = sdf.format(hora);
            EntradadadosHora.setText(String.valueOf(dataFormatada));
            txt_emitente.requestFocus();
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void JDateChooser1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JDateChooser1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            EntraDados();
        }
    }//GEN-LAST:event_JDateChooser1KeyPressed

    private void txt_emitenteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emitenteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            EntraDados();
        }
    }//GEN-LAST:event_txt_emitenteKeyPressed
    private void listarLinha() {

        listaModelFichaControle = controllerFichaControle.getListaFichaControleComboController();
        cbLinha.removeAllItems();
        for (int i = 0; i < listaModelFichaControle.size(); i++) {
            cbLinha.addItem(listaModelFichaControle.get(i).getEsp_linha());
        }
    }

//    private boolean recuperarFichaControle() {
//        int linha = this.tbValidacao.getSelectedRow();
//        Integer perfil = (Integer) tbValidacao.getValueAt(linha, 2);
//        try {
//            modelFichaControle = controllerFichaControle.getFichaController(perfil);
//            this.cbMaterial.setSelectedItem(String.valueOf(modelFichaControle.getEsp_material()));
//            this.cbLinha.setSelectedItem(modelFichaControle.getEsp_linha());
//            this.txt_status.setText(modelFichaControle.getPendencia_alter());
//            this.jTextArea1.setText(modelFichaControle.getObservacao_alter());
//            JDateChooser1.setDate(new Date());
//            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//            Date hora = Calendar.getInstance().getTime();
//            String dataFormatada = sdf.format(hora);
//            EntradadadosHora.setText(String.valueOf(dataFormatada));
//            txt_emitente.requestFocus();
//            return true;
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Código inválido ou nenhum registro selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
//            return false;
//        }
//    }

    private void carregaListaPendencia() {
        listaModelFichaControle = controllerFichaControle.getListaFichaValidacaoController();
        DefaultTableModel modelo = (DefaultTableModel) tbValidacao.getModel();
        modelo.setNumRows(0);
        int cont = listaModelFichaControle.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelFichaControle.get(i).getData_alter(),
                listaModelFichaControle.get(i).getEsp_linha(),
                listaModelFichaControle.get(i).getEsp_material(),
                listaModelFichaControle.get(i).getOem(),
                listaModelFichaControle.get(i).getResponsavel_alter(),
                listaModelFichaControle.get(i).getPendencia_alter(),
                listaModelFichaControle.get(i).getObservacao_alter()

            });

        }

    }

    public void LimparGeral() {
        cbLinha.setSelectedIndex(-1);
        cbMaterial.setSelectedIndex(-1);
        txt_emitente.setText("");
        txt_responsavel.setText("");
        jTextArea1.setText("");
        EntradadadosHora.setText("");
        JDateChooser1.setDate(null);
        jPanel4.setVisible(false);
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
            java.util.logging.Logger.getLogger(ViewValidacao.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewValidacao.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewValidacao.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewValidacao.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewValidacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EntradadadosData;
    private javax.swing.JTextField EntradadadosDesenho;
    private javax.swing.JTextField EntradadadosEnviaLinha;
    private javax.swing.JFormattedTextField EntradadadosHora;
    private javax.swing.JTextField EntradadadosOem;
    private javax.swing.JTextField EntradadadosPlano;
    private javax.swing.JTextField EntradadadosProjeto;
    private com.toedter.calendar.JDateChooser JDateChooser1;
    private javax.swing.JComboBox<String> cbLinha;
    private javax.swing.JComboBox<String> cbMaterial;
    private javax.swing.JComboBox<String> combo_setor;
    private javax.swing.JTextField entradadadosDescMaterial;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lbBusca;
    private javax.swing.JTable tbValidacao;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtEmitentePlan;
    private javax.swing.JTextField txtResponsavelPlan;
    private javax.swing.JTextField txtRevPlan;
    private javax.swing.JTextField txt_emitente;
    private javax.swing.JTextField txt_responsavel;
    private javax.swing.JTextField txt_rev;
    private javax.swing.JTextField txt_status;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.views.qualidade;

import com.cooperstandard.controller.extrusao.ControllerProducao;
import com.cooperstandard.model.ModelProducao;
import com.cooperstandard.util.CustomRenderer;
import com.cooperstandard.util.EstiloTablaRenderer;
import com.cooperstandard.util.HeaderRenderer;
import java.awt.Color;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rsouza10
 */
public class ViewStatus extends javax.swing.JFrame {

    String tipo_teste = "";
    int ultimaLinhaEditada, ultimaColunaEditada;
    String perfil = "";
    String desenho = "";
    String projeto = "";
    String plano = "";
    String descmaterial = "";
    String status = "";
    String identificacao = "";
    ModelProducao modelProducao = new ModelProducao();
    ControllerProducao controllerProducao = new ControllerProducao();
    ArrayList<ModelProducao> listaModelProducao = new ArrayList<ModelProducao>();

    public ViewStatus() {
        initComponents();
    }

    public ViewStatus(String _perfil, String _desenho, String _projeto, String _plano, String _descmaterial, String _status, String _statusficha) {
        initComponents();
        tbStatus.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbStatus));
        tbStatus.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
        tbStatus.setDefaultRenderer(String.class, new EstiloTablaRenderer());
        tbStatus.setDefaultRenderer(Float.class, new EstiloTablaRenderer());
        tbStatus.getColumnModel().getColumn(5).setCellRenderer(new CustomRenderer());
        perfil = _perfil;
        desenho = _desenho;
        plano = _plano;
        descmaterial = _descmaterial;
        projeto = _projeto;
        status = _status;
        txtMaterial.setText(perfil);
        txt_projeto.setText(projeto);
        txt_descmaterial.setText(descmaterial);
        txt_desenho.setText(desenho);
        txt_plano.setText(plano);
        identificacao = _statusficha;
        carregaTabela();
        switch (status) {
            case "Protótipo":
                jTextField3.setBackground(new Color(153, 153, 153));
                break;
            case "Pré-Lançamento":
                jTextField4.setBackground(new Color(153, 153, 153));
                break;
            case "Produção":
                jTextField5.setBackground(new Color(153, 153, 153));
                break;
        }

        if (identificacao.equals("StatusFicha")) {

            jMenu1.setVisible(true);
            jMenu2.setVisible(false);
        } else {
            jMenu2.setVisible(true);
            jMenu1.setVisible(false);
        }

    }

    public void updatstatus() {
        for (int i = 0; i < tbStatus.getRowCount(); i++) {
            try {

                
                Connection con = new ConexaoSql().getCon();
                String sql = "UPDATE Ficha_Controle set STATUS='" + status + "' where ESP_MATERIAL='" + txtMaterial.getText() + "'";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.executeUpdate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    public void deletarodape() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String sql = "delete from Cad_Rodape where ROD_MATERIAL=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, txtMaterial.getText());

            pst.executeUpdate();

        } catch (Exception e) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbStatus = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbl_envialinha = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtMaterial = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_projeto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_descmaterial = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_desenho = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_plano = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_data = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbStatus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Ordem", "Linha", "Material", "Equipamento", "Teste", "Espec. Mínimo", "Espec. Máximo", "Unidade", "Espec. Texto", "Referência", "Frequência", "Unidade", "Origem", "Tipo", "Especificação", "Produto", "Frequência", "Laboratório", "Complemento", "Composto", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbStatus.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbStatus.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbStatus);
        if (tbStatus.getColumnModel().getColumnCount() > 0) {
            tbStatus.getColumnModel().getColumn(0).setMinWidth(0);
            tbStatus.getColumnModel().getColumn(0).setMaxWidth(0);
            tbStatus.getColumnModel().getColumn(1).setMinWidth(0);
            tbStatus.getColumnModel().getColumn(1).setMaxWidth(0);
            tbStatus.getColumnModel().getColumn(2).setMinWidth(100);
            tbStatus.getColumnModel().getColumn(3).setMinWidth(0);
            tbStatus.getColumnModel().getColumn(3).setMaxWidth(0);
            tbStatus.getColumnModel().getColumn(4).setMinWidth(200);
            tbStatus.getColumnModel().getColumn(5).setMinWidth(250);
            tbStatus.getColumnModel().getColumn(6).setMinWidth(100);
            tbStatus.getColumnModel().getColumn(7).setMinWidth(100);
            tbStatus.getColumnModel().getColumn(8).setMinWidth(80);
            tbStatus.getColumnModel().getColumn(9).setMinWidth(120);
            tbStatus.getColumnModel().getColumn(10).setMinWidth(100);
            tbStatus.getColumnModel().getColumn(11).setMinWidth(0);
            tbStatus.getColumnModel().getColumn(11).setMaxWidth(0);
            tbStatus.getColumnModel().getColumn(12).setMinWidth(0);
            tbStatus.getColumnModel().getColumn(12).setMaxWidth(0);
            tbStatus.getColumnModel().getColumn(13).setMinWidth(120);
            tbStatus.getColumnModel().getColumn(14).setMinWidth(100);
            tbStatus.getColumnModel().getColumn(14).setMaxWidth(100);
            tbStatus.getColumnModel().getColumn(15).setMinWidth(140);
            tbStatus.getColumnModel().getColumn(16).setMinWidth(80);
            tbStatus.getColumnModel().getColumn(17).setMinWidth(140);
            tbStatus.getColumnModel().getColumn(18).setMinWidth(80);
            tbStatus.getColumnModel().getColumn(20).setMinWidth(0);
            tbStatus.getColumnModel().getColumn(20).setMaxWidth(0);
            tbStatus.getColumnModel().getColumn(21).setMinWidth(0);
            tbStatus.getColumnModel().getColumn(21).setMaxWidth(0);
        }

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Ficha de Controle de Extrusão");

        lbl_envialinha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cooper-standard-original_1.jpg"))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Número da Peça:");

        txtMaterial.setBorder(null);
        txtMaterial.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMaterial.setFocusable(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Projeto:");

        txt_projeto.setBorder(null);
        txt_projeto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_projeto.setFocusable(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("Descrição da Peça:");

        txt_descmaterial.setBorder(null);
        txt_descmaterial.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_descmaterial.setFocusable(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setText("Número do Desenho:");

        txt_desenho.setBorder(null);
        txt_desenho.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_desenho.setFocusable(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("Número do Plano:");

        txt_plano.setBorder(null);
        txt_plano.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_plano.setFocusable(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("Data de Entrada:");

        txt_data.setText("N/A");
        txt_data.setBorder(null);
        txt_data.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_data.setFocusable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_projeto, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_descmaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_desenho, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_plano, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txt_desenho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_projeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txt_plano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_descmaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(153, 153, 153));
        jTextField1.setFocusable(false);

        jLabel1.setText("Processo");

        jTextField2.setEditable(false);
        jTextField2.setFocusable(false);

        jLabel2.setText("Produto");

        jLabel3.setText("Protótipo");

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        jTextField3.setFocusable(false);

        jLabel4.setText("Pré-Lançamento");

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(255, 255, 255));
        jTextField4.setFocusable(false);

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(255, 255, 255));
        jTextField5.setFocusable(false);

        jLabel6.setText("Produção");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_envialinha, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_envialinha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-dados-em-ambas-as-direçSes-filled-50.png"))); // NOI18N
        jMenu1.setText("Trocar Status");

        jMenuItem1.setText("Trocar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-excluir-filled-50.png"))); // NOI18N
        jMenu2.setText("Deletar Ficha");

        jMenuItem2.setText("Deletar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "Você deseja realmente trocar o status?", "Trocar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (p == 0) {
            Object[] opcoes = {"Protótipo", "Pré-Lançamento", "Produção"};
            Object res = JOptionPane.showInputDialog(null, "Escolha um Status", "Seleção de status",
                    JOptionPane.PLAIN_MESSAGE, null, opcoes, "");
            status = (String) res;
            updatstatus();
            JOptionPane.showMessageDialog(null, "Troca Realizada com sucesso!");
            trocastatus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "Você deseja realmente deletar?", "Deletar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(this.getClass().getResource("/images/deletar.png")));
        if (p == 0) {
            try {
                
                Connection con = new ConexaoSql().getCon();
                String sql = "delete from Ficha_Controle where ESP_MATERIAL=?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, txtMaterial.getText());
                pst.executeUpdate();
                deletarodape();
                JOptionPane.showMessageDialog(null, "Ficha de Controle Deletada com Sucesso!");
                new ViewQualidade().setVisible(true);
                dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }

        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    private void carregaTabela() {
        listaModelProducao = controllerProducao.getListaProducaoGeralController(perfil);
        DefaultTableModel modelo = (DefaultTableModel) tbStatus.getModel();
        modelo.setNumRows(0);
        int cont = listaModelProducao.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelProducao.get(i).getId(),
                listaModelProducao.get(i).getOrdem(),
                listaModelProducao.get(i).getEsp_linha(),
                listaModelProducao.get(i).getEsp_material(),
                listaModelProducao.get(i).getEsp_equipamento(),
                listaModelProducao.get(i).getDesc_teste(),
                listaModelProducao.get(i).getMinimo(),
                listaModelProducao.get(i).getMaximo(),
                listaModelProducao.get(i).getUnid_med(),
                listaModelProducao.get(i).getTexto(),
                listaModelProducao.get(i).getReferencia(),
                listaModelProducao.get(i).getFrequencia(),
                listaModelProducao.get(i).getUnid_freq(),
                listaModelProducao.get(i).getOrigem(),
                listaModelProducao.get(i).getTipo_espec(),
                listaModelProducao.get(i).getEspec_completo(),
                listaModelProducao.get(i).getProduto(),
                listaModelProducao.get(i).getFreq_completo(),
                listaModelProducao.get(i).getLab(),
                listaModelProducao.get(i).getComplemento(),
                listaModelProducao.get(i).getEsp_composto(),
                listaModelProducao.get(i).getStatus()
            });

        }

    }

    public void trocastatus() {
        switch (status) {
            case "Protótipo":
                jTextField3.setBackground(new Color(153, 153, 153));
                jTextField4.setBackground(new Color(255, 255, 255));
                jTextField5.setBackground(new Color(255, 255, 255));
                jTextField3.requestFocus();
                break;
            case "Pré-Lançamento":
                jTextField3.setBackground(new Color(255, 255, 255));
                jTextField4.setBackground(new Color(153, 153, 153));
                jTextField5.setBackground(new Color(255, 255, 255));
                jTextField4.requestFocus();
                break;
            case "Produção":
                jTextField5.setBackground(new Color(153, 153, 153));
                jTextField4.setBackground(new Color(255, 255, 255));
                jTextField3.setBackground(new Color(255, 255, 255));
                jTextField5.requestFocus();
                break;
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
            java.util.logging.Logger.getLogger(ViewStatus.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewStatus.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewStatus.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewStatus.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewStatus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lbl_envialinha;
    private javax.swing.JTable tbStatus;
    private javax.swing.JTextField txtMaterial;
    private javax.swing.JTextField txt_data;
    private javax.swing.JTextField txt_descmaterial;
    private javax.swing.JTextField txt_desenho;
    private javax.swing.JTextField txt_plano;
    private javax.swing.JTextField txt_projeto;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.views.qualidade;

import com.cooperstandard.controller.extrusao.ControllerComposto;
import com.cooperstandard.model.ModelComposto;
import com.cooperstandard.util.EstiloTablaHeader;
import com.cooperstandard.util.EstiloTablaRenderer;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rsouza10
 */
public class ViewAlteracaoMassa extends javax.swing.JFrame {

    ControllerComposto controllerComposto = new ControllerComposto();
    ArrayList<ModelComposto> listaModelComposto = new ArrayList<ModelComposto>();
    DefaultTableModel modelo = new DefaultTableModel(null, new String[]{"Linha", "Perfil", "Composto"}) {
        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }
    };

    public ViewAlteracaoMassa() {
        initComponents();
        jTextField7.setVisible(false);
        txt_pendencia.setVisible(false);
        jPanel3.setVisible(false);
        jLabel5.setVisible(false);
        jLabel22.setVisible(false);
        jLabel18.setVisible(false);
        jLabel19.setVisible(false);
        jLabel20.setVisible(false);
        jLabel21.setVisible(false);
        jTextField1.setVisible(false);
        jTable1.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        jTable1.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        jTable1.getTableHeader().setReorderingAllowed(false);
        listarComposto();
    }

    public void updateA() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String sql = "UPDATE Ficha_Controle set MINIMO=?,MAXIMO=?,ESPEC_COMPLETO=? where ESP_COMPOSTO='" + cbComposto.getSelectedItem() + "' and ESP_TESTE='" + CadTPECTeste1.getText() + "' ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, jTextField4.getText());
            pst.setString(2, jTextField2.getText());
            pst.setString(3, jTextField1.getText());
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void updateB() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String sql = "UPDATE Ficha_Controle set MINIMO=?,MAXIMO=?,ESPEC_COMPLETO=? where ESP_COMPOSTO='" + cbComposto.getSelectedItem() + "' and ESP_TESTE='" + CadTPECTeste2.getText() + "' ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, jTextField4.getText());
            pst.setString(2, jTextField2.getText());
            pst.setString(3, jTextField1.getText());
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void updateC() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String sql = "UPDATE Ficha_Controle set MINIMO=?,MAXIMO=?,ESPEC_COMPLETO=? where ESP_COMPOSTO='" + cbComposto.getSelectedItem() + "' and ESP_TESTE='" + CadTPECTeste3.getText() + "' ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, jTextField4.getText());
            pst.setString(2, jTextField2.getText());
            pst.setString(3, jTextField1.getText());
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void updateD() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String sql = "UPDATE Ficha_Controle set MINIMO=?,MAXIMO=?,ESPEC_COMPLETO=? where ESP_COMPOSTO='" + cbComposto.getSelectedItem() + "' and ESP_TESTE='" + CadTPECTeste4.getText() + "' ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, jTextField4.getText());
            pst.setString(2, jTextField2.getText());
            pst.setString(3, jTextField1.getText());
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void updateE() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String sql = "UPDATE Ficha_Controle set MINIMO=?,MAXIMO=?,ESPEC_COMPLETO=? where ESP_COMPOSTO='" + cbComposto.getSelectedItem() + "' and ESP_TESTE='" + CadTPECTeste5.getText() + "' ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, jTextField4.getText());
            pst.setString(2, jTextField2.getText());
            pst.setString(3, jTextField1.getText());
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void updateF() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String sql = "UPDATE Ficha_Controle set MINIMO=?,MAXIMO=?,ESPEC_COMPLETO=? where ESP_COMPOSTO='" + cbComposto.getSelectedItem() + "' and ESP_TESTE='" + CadTPECTeste6.getText() + "' ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, jTextField4.getText());
            pst.setString(2, jTextField2.getText());
            pst.setString(3, jTextField1.getText());
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void Copiadados_histo() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                Object perfil = jTable1.getModel().getValueAt(i, 1);

                String sql = "INSERT INTO Histo_Ficha_Controle "
                        + "(ORDEM," //1
                        + "HISTO_LINHA," //2
                        + "HISTO_MATERIAL," //3
                        + "HISTO_TESTE," //4
                        + "HISTO_EQUIPAMENTO," //5
                        + "HISTO_MINIMO," //6
                        + "HISTO_MAXIMO," //7
                        + "HISTO_UNID_MEDIDA," //8
                        + "HISTO_TEXTO," //9
                        + "HISTO_REFERENCIA," //10
                        + "HISTO_FREQUENCIA," //11
                        + "HISTO_UNID_FREQUENCIA," //12
                        + "HISTO_PRODUTO," //13
                        + "HISTO_ORIGEM," //14
                        + "HISTO_TIPO_ESPEC," //15
                        + "HISTO_ESPEC_COMPLEMENTO," //16
                        + "HISTO_FREQ_COMPLETO," //17
                        + "HISTO_LAB," //18
                        + "HISTO_COMPLEMENTO," //19
                        + "HISTO_RESPONSAVEL," //20
                        + "HISTO_PENDENCIA," //21
                        + "HISTO_DATA_HISTO," //22
                        + "HISTO_OBSERVACAO," //23
                        + "HISTO_DATE_VALID," //24
                        + "ALTER_IDENTIFICACAO," //25
                        + "HISTO_HORA," //26
                        + "HISTO_COMPOSTO,"
                        + "HISTO_STATUS) " //27

                        + "SELECT "
                        + "ORDEM," //1
                        + "ESP_LINHA ," //2
                        + "ESP_MATERIAL ," //3
                        + "ESP_TESTE ," //4
                        + "ESP_EQUIPAMENTO ," //5
                        + "MINIMO ,"
                        + "MAXIMO ," //6
                        + "UNID_MEDIDA ," //7
                        + "TEXTO ," //8
                        + "REFERENCIA ," //9
                        + "FREQUENCIA ," //10
                        + "UNID_FREQUENCIA ," //11
                        + "PRODUTO ," //12
                        + "ORIGEM ," //13
                        + "TIPO_ESPEC ," //14
                        + "ESPEC_COMPLETO ," //15
                        + "FREQ_COMPLETO ," //16
                        + "LAB ," //17
                        + "COMPLEMENTO ,"//18
                        + "'" + jTextField5.getText() + " AS RESPONSAVEL',"
                        + "'20' AS PENDENCIA,"
                        + "'" + jTextField7.getText() + "' AS DATA,"
                        + "'" + jTextField6.getText() + "' AS OBSERVACAO,"
                        + "'" + jTextField7.getText() + "' AS DATAVALID,"
                        + "'20' AS IDENTIFICACAO,"
                        + "'" + alter_txt_hora.getText() + "' AS HORA,"
                        + "ESP_COMPOSTO,"
                        + "STATUS " //19
                        + "FROM Ficha_Controle where ESP_MATERIAL='" + perfil + "'";

                PreparedStatement pst = con.prepareStatement(sql);
                pst.executeUpdate();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTable2 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        CadTPECTeste1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        CadTPECTeste6 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        CadTPECTeste2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        CadTPECTeste3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        CadTPECTeste4 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        CadTPECTeste5 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        cbComposto = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        alter_txt_hora = new javax.swing.JFormattedTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        txt_pendencia = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Densidade do Composto Extrusora B", "MV Extrusora B", "T5 Extrusora B", "T90 Extrusora B" }));
        jComboBox3.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Teste:");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Densidade do Composto Extrusora C", "MV Extrusora C", "T5 Extrusora C", "T90 Extrusora C" }));
        jComboBox4.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Teste:");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Densidade do Composto Extrusora D", "MV Extrusora D", "T5 Extrusora D", "T90 Extrusora D" }));
        jComboBox5.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Teste:");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Densidade do Composto Extrusora E", "MV Extrusora E", "T5 Extrusora E", "T90 Extrusora E" }));
        jComboBox6.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("Teste:");

        CadTPECTeste1.setEditable(false);
        CadTPECTeste1.setFocusable(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setText("Código do Teste:");

        CadTPECTeste6.setEditable(false);
        CadTPECTeste6.setFocusable(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel17.setText("Código do Teste:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Densidade do Composto Extrusora A", "MV Extrusora A", "T5 Extrusora A", "T90 Extrusora A" }));
        jComboBox2.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Teste:");

        CadTPECTeste2.setEditable(false);
        CadTPECTeste2.setFocusable(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("Código do Teste:");

        CadTPECTeste3.setEditable(false);
        CadTPECTeste3.setFocusable(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("Código do Teste:");

        CadTPECTeste4.setEditable(false);
        CadTPECTeste4.setFocusable(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("Código do Teste:");

        CadTPECTeste5.setEditable(false);
        CadTPECTeste5.setFocusable(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("Código do Teste:");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Densidade do Composto Extrusora F", "MV Extrusora F", "T5 Extrusora F", "T90 Extrusora F" }));
        jComboBox7.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel16.setText("Teste:");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Ok_32px.png"))); // NOI18N

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Ok_32px.png"))); // NOI18N

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Ok_32px.png"))); // NOI18N

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Ok_32px.png"))); // NOI18N

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Ok_32px.png"))); // NOI18N

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Ok_32px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel16)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CadTPECTeste1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CadTPECTeste2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CadTPECTeste3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CadTPECTeste4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CadTPECTeste5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CadTPECTeste6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CadTPECTeste1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CadTPECTeste2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CadTPECTeste3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CadTPECTeste4))
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CadTPECTeste5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CadTPECTeste6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(190, 255, 255));
        jButton1.setText("Iniciar Alteração em Massa");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jDateChooser1 = new JDateChooser("dd/MM/yyyy", "##/##/#####", '_');

        cbComposto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbComposto.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbCompostoPropertyChange(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Composto:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Densidade do Composto", "MV", "T5", "T90" }));
        jComboBox1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBox1PropertyChange(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Teste:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Data");

        try {
            alter_txt_hora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        alter_txt_hora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        alter_txt_hora.setText("");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel26.setText("Hora:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Responsável");

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("à");
        jTextField3.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField3.setFocusable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Min:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Max:");

        jTextField6.setBackground(new java.awt.Color(255, 255, 153));

        jTextField1.setEditable(false);
        jTextField1.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        txt_pendencia.setEditable(false);
        txt_pendencia.setEnabled(false);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Observação");

        jTextField7.setEditable(false);
        jTextField7.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField6)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_pendencia, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(alter_txt_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbComposto, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbComposto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alter_txt_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_pendencia, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 394, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(0, 346, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTextField4.getText().equals("") || jTextField2.getText().equals("") || jComboBox1.getSelectedItem().equals("Selecione...") || jTextField5.getText().equals("") || jDateChooser1.getDate() == null || jTextField6.getText().equals("") || alter_txt_hora.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
        } else {
            jTextField1.setText(jTextField4.getText() + " " + jTextField3.getText() + " " + jTextField2.getText());
            Date fecha = jDateChooser1.getDate();
            DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            String fecha2 = f.format(fecha);
            jTextField7.setText(fecha2);
            updateA();
            updateB();
            updateC();
            updateD();
            updateE();
            updateF();
            Copiadados_histo();
            jLabel5.setVisible(true);
            jLabel22.setVisible(true);
            jLabel18.setVisible(true);
            jLabel19.setVisible(true);
            jLabel20.setVisible(true);
            jLabel21.setVisible(true);
            JOptionPane.showMessageDialog(null, "Especificações Alteradas com Sucesso!!.");
            jPanel3.setVisible(false);
            jLabel5.setVisible(false);
            jLabel22.setVisible(false);
            jLabel18.setVisible(false);
            jLabel19.setVisible(false);
            jLabel20.setVisible(false);
            jLabel21.setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbCompostoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbCompostoPropertyChange
        cbComposto.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (cbComposto.getSelectedItem().equals("Selecione...")) {
                        PreencherTabela();
                    } else {
                        PreencherTabela(cbComposto.getSelectedItem().toString());
                    }
                }
            }
        });
    }//GEN-LAST:event_cbCompostoPropertyChange

    private void jComboBox1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBox1PropertyChange
        jComboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    jPanel3.setVisible(true);
                    if (jComboBox1.getSelectedItem().equals("Densidade do Composto")) {
                        jComboBox2.setSelectedItem("Densidade do Composto Extrusora A");
                        CadTPECTeste1.setText("EAIDS1");
                        jComboBox3.setSelectedItem("Densidade do Composto Extrusora B");
                        CadTPECTeste2.setText("EBIDS1");
                        jComboBox4.setSelectedItem("Densidade do Composto Extrusora C");
                        CadTPECTeste3.setText("ECIDS1");
                        jComboBox5.setSelectedItem("Densidade do Composto Extrusora D");
                        CadTPECTeste4.setText("EDIDS1");
                        jComboBox6.setSelectedItem("Densidade do Composto Extrusora E");
                        CadTPECTeste5.setText("EEIDS1");
                        jComboBox7.setSelectedItem("Densidade do Composto Extrusora F");
                        CadTPECTeste6.setText("EFIDS1");

                    } else if (jComboBox1.getSelectedItem().equals("MV")) {
                        jComboBox2.setSelectedItem("MV Extrusora A");
                        CadTPECTeste1.setText("EAIMV1");
                        jComboBox3.setSelectedItem("MV Extrusora B");
                        CadTPECTeste2.setText("EBIMV1");
                        jComboBox4.setSelectedItem("MV Extrusora C");
                        CadTPECTeste3.setText("ECIMV1");
                        jComboBox5.setSelectedItem("MV Extrusora D");
                        CadTPECTeste4.setText("EDIMV1");
                        jComboBox6.setSelectedItem("MV Extrusora E");
                        CadTPECTeste5.setText("EEIMV1");
                        jComboBox7.setSelectedItem("MV Extrusora F");
                        CadTPECTeste6.setText("EFIMV1");

                    } else if (jComboBox1.getSelectedItem().equals("T5")) {
                        jComboBox2.setSelectedItem("T5 Extrusora A");
                        CadTPECTeste1.setText("EAIT51");
                        jComboBox3.setSelectedItem("T5 Extrusora B");
                        CadTPECTeste2.setText("EBIT51");
                        jComboBox4.setSelectedItem("T5 Extrusora C");
                        CadTPECTeste3.setText("ECIT51");
                        jComboBox5.setSelectedItem("T5 Extrusora D");
                        CadTPECTeste4.setText("EDIT51");
                        jComboBox6.setSelectedItem("T5 Extrusora E");
                        CadTPECTeste5.setText("EEIT51");
                        jComboBox7.setSelectedItem("T5 Extrusora F");
                        CadTPECTeste6.setText("EFIT51");

                    } else if (jComboBox1.getSelectedItem().equals("T90")) {
                        jComboBox2.setSelectedItem("T90 Extrusora A");
                        CadTPECTeste1.setText("EAIT91");
                        jComboBox3.setSelectedItem("T90 Extrusora B");
                        CadTPECTeste2.setText("EB1T91");
                        jComboBox4.setSelectedItem("T90 Extrusora C");
                        CadTPECTeste3.setText("EC1T91");
                        jComboBox5.setSelectedItem("T90 Extrusora D");
                        CadTPECTeste4.setText("ED1T91");
                        jComboBox6.setSelectedItem("T90 Extrusora E");
                        CadTPECTeste5.setText("EE1T91");
                        jComboBox7.setSelectedItem("T90 Extrusora F");
                        CadTPECTeste6.setText("EF1T91");

                    } else if (jComboBox1.getSelectedItem().equals("Selecione...")) {
                        jPanel3.setVisible(false);
                        jTextField4.setText(null);
                        jTextField2.setText(null);
                        jTextField1.setText(null);
                    }
                }
            }
        });
    }//GEN-LAST:event_jComboBox1PropertyChange
   
    private void listarComposto() {
        listaModelComposto = controllerComposto.getListaCompostoController();
        cbComposto.removeAllItems();
        for (int i = 0; i < listaModelComposto.size(); i++) {
            cbComposto.addItem(String.valueOf(listaModelComposto.get(i).getComposto()));
        }
    }

    private void PreencherTabela() {
        try {
            modelo.setNumRows(0);
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);

            while (rs.next()) {

                modelo.addRow(new Object[]{rs.getString("ESP_LINHA"), rs.getInt("ESP_MATERIAL"), rs.getInt("ESP_COMPOSTO")});
            }

            modelo.isCellEditable(modelo.getColumnCount(), modelo.getRowCount());
            jTable1.setModel(modelo);

        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void PreencherTabela(String Composto) {
        try {
            modelo.setNumRows(0);
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select DISTINCT ESP_LINHA,ESP_MATERIAL,ESP_COMPOSTO from Ficha_Controle where ESP_COMPOSTO='" + Composto + "' ORDER BY ESP_MATERIAL asc";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);

            while (rs.next()) {

                modelo.addRow(new Object[]{rs.getString("ESP_LINHA"), rs.getInt("ESP_MATERIAL"), rs.getInt("ESP_COMPOSTO")});
            }

            modelo.isCellEditable(modelo.getColumnCount(), modelo.getRowCount());
            jTable1.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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
            java.util.logging.Logger.getLogger(ViewAlteracaoMassa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAlteracaoMassa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAlteracaoMassa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAlteracaoMassa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAlteracaoMassa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CadTPECTeste1;
    private javax.swing.JTextField CadTPECTeste2;
    private javax.swing.JTextField CadTPECTeste3;
    private javax.swing.JTextField CadTPECTeste4;
    private javax.swing.JTextField CadTPECTeste5;
    private javax.swing.JTextField CadTPECTeste6;
    private javax.swing.JFormattedTextField alter_txt_hora;
    private javax.swing.JComboBox<String> cbComposto;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField txt_pendencia;
    // End of variables declaration//GEN-END:variables
}

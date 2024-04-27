/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.views.qualidade;

import com.cooperstandard.controller.extrusao.ControllerHistorico;
import com.cooperstandard.views.extrusao.ViewGerenciador;
import com.cooperstandard.model.ModelHistorico;
import com.cooperstandard.util.CustomRenderer2;
import com.cooperstandard.util.EstiloTablaRenderer;
import com.cooperstandard.util.HeaderRenderer;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rsouza10
 */
public class ViewVersao extends javax.swing.JFrame {

    private static final long serialVersionUID = -5944139773614059936L;

    ModelHistorico modelHistorico = new ModelHistorico();
    ControllerHistorico controllerHistorico = new ControllerHistorico();
    ArrayList<ModelHistorico> listaModelHistorico = new ArrayList<ModelHistorico>();
    String pendencia = "Restauração de Versão";
    String perfil = "";
    String data = "";
    String hora = "";
    String registro = "";
    String desenho = "";
    String projeto = "";
    String plano = "";
    String descmaterial = "";
    String envialinha = "";
    String emitente = "";
    String responsavel = "";

    public ViewVersao() {

    }

    public ViewVersao(String _perfil, String _data, String _hora, String _desenho, String _projeto, String _plano, String _descmaterial, String _envialinha, String _emitente) {
        initComponents();
        tbVersao.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbVersao));
        tbVersao.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
        tbVersao.setDefaultRenderer(String.class, new EstiloTablaRenderer());
        tbVersao.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        tbVersao.getColumnModel().getColumn(4).setCellRenderer(new CustomRenderer2());
        perfil = _perfil;
        data = _data;
        hora = _hora;
        desenho = _desenho;
        plano = _plano;
        descmaterial = _descmaterial;
        envialinha = _envialinha;
        emitente = _emitente;
        projeto = _projeto;
        txt_emitente.setText(emitente);
        lbl_envialinha.setText((envialinha));
        txt_descmaterial.setText((descmaterial));
        txt_desenho.setText((desenho));
        txt_cliente.setText(projeto);
        txt_perfil.setText((perfil));
        txt_data.setText((data));
        txt_hora.setText((hora));
        txt_plano.setText((plano));
        carregaTabela();
    }

    public void Deletafichacontrole() {
        try {

            
            Connection con = new ConexaoSql().getCon();
            String query1 = "DELETE FROM Ficha_Controle WHERE ESP_MATERIAL='" + txt_perfil.getText() + "'";
            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
        } catch (Exception e) {

        }
    }

    public void Deletadados_removidos() {
        try {

            
            Connection con = new ConexaoSql().getCon();
            String query1 = "DELETE FROM Cad_Espec_Teste WHERE ALTER_IDENTIFICACAO='3' and ESP_MATERIAL='" + txt_perfil.getText() + "'";
            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();

        } catch (Exception e) {

        }
    }

    public void CopiaFichaControle() {
        try {

            
            Connection con = new ConexaoSql().getCon();
            String query1 = "INSERT INTO Ficha_Controle (ORDEM,ESP_LINHA ,ESP_MATERIAL ,ESP_TESTE ,ESP_EQUIPAMENTO ,MINIMO ,MAXIMO ,UNID_MEDIDA ,TEXTO ,"
                    + "REFERENCIA ,FREQUENCIA ,UNID_FREQUENCIA,PRODUTO ,ORIGEM ,TIPO_ESPEC ,ESPEC_COMPLETO ,FREQ_COMPLETO ,LAB ,COMPLEMENTO,ESP_COMPOSTO,STATUS, AMOSTRA )"
                    + "SELECT ORDEM ,ESP_LINHA ,ESP_MATERIAL ,ESP_TESTE ,ESP_EQUIPAMENTO ,MINIMO ,MAXIMO ,UNID_MEDIDA ,TEXTO ,"
                    + "REFERENCIA ,FREQUENCIA ,UNID_FREQUENCIA ,PRODUTO ,ORIGEM ,TIPO_ESPEC ,ESPEC_COMPLETO ,FREQ_COMPLETO ,"
                    + "LAB ,COMPLEMENTO,ESP_COMPOSTO,STATUS, AMOSTRA FROM Cad_Espec_Teste WHERE ESP_MATERIAL='" + txt_perfil.getText() + "'";

            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
        } catch (Exception e) {

        }

    }

    public void Copiadados_histo() {
        try {

            
            Connection con = new ConexaoSql().getCon();
            String query1 = "INSERT INTO Cad_Espec_Teste (ORDEM,ESP_LINHA ,ESP_MATERIAL ,ESP_TESTE ,ESP_EQUIPAMENTO ,MINIMO ,MAXIMO ,UNID_MEDIDA ,TEXTO ,REFERENCIA ,FREQUENCIA ,"
                    + "UNID_FREQUENCIA,PRODUTO ,ORIGEM ,TIPO_ESPEC ,ESPEC_COMPLETO ,FREQ_COMPLETO ,LAB ,COMPLEMENTO,RESPONSAVEL_ALTER,PENDENCIA_ALTER,DATA_ALTER,OBSERVACAO_ALTER,"
                    + "DATE_VALIDE_ALTER,ALTER_IDENTIFICACAO,HORA_ALTER,ESP_COMPOSTO,STATUS, AMOSTRA) SELECT ORDEM,HISTO_LINHA,HISTO_MATERIAL,HISTO_TESTE,HISTO_EQUIPAMENTO,HISTO_MINIMO,HISTO_MAXIMO,"
                    + "HISTO_UNID_MEDIDA,HISTO_TEXTO,HISTO_REFERENCIA,HISTO_FREQUENCIA,HISTO_UNID_FREQUENCIA,HISTO_PRODUTO,HISTO_ORIGEM,HISTO_TIPO_ESPEC,HISTO_ESPEC_COMPLEMENTO,"
                    + "HISTO_FREQ_COMPLETO,HISTO_LAB,HISTO_COMPLEMENTO,HISTO_RESPONSAVEL,HISTO_PENDENCIA,HISTO_DATA_HISTO,HISTO_OBSERVACAO,HISTO_DATE_VALID,"
                    + "ALTER_IDENTIFICACAO,HISTO_HORA,HISTO_COMPOSTO,HISTO_STATUS, HISTO_AMOSTRA FROM Histo_Ficha_Controle WHERE HISTO_MATERIAL='" + txt_perfil.getText() + "' and HISTO_DATA_HISTO='" + txt_data.getText() + "' and HISTO_HORA='" + txt_hora.getText() + "'";

            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
        } catch (Exception e) {
        }

    }

    public void Salvadata() {
        String x;
        x = JOptionPane.showInputDialog(null, "Informe a observação relacionada a sua troca de versão para Qualidade!");
        String obs = x;
        for (int i = 0; i < tbVersao.getRowCount(); i++) {
            try {
                java.util.Date currentDate = GregorianCalendar.getInstance().getTime();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = df.format(currentDate);
                String values = dateString;
                
                Connection con = new ConexaoSql().getCon();
                String sql = "UPDATE Cad_Espec_Teste set DATA_ALTER='" + values + "',RESPONSAVEL_ALTER=?,PENDENCIA_ALTER='" + pendencia + "',OBSERVACAO_ALTER='" + obs + "' where ESP_MATERIAL='" + txt_perfil.getText() + "' AND HORA_ALTER='" + txt_hora.getText() + "'";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, txt_emitente.getText());
                pst.executeUpdate();
            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, e);
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVersao = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbl_envialinha = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_perfil = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_cliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_descmaterial = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_desenho = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_plano = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_data = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_hora = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_emitente = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbVersao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Ordem", "Operação", "Equipamento", "D. Teste", "Complemento", "Referência", "Tipo", "Especificação", "Frequência", "Identificação", "Produto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbVersao.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbVersao);
        if (tbVersao.getColumnModel().getColumnCount() > 0) {
            tbVersao.getColumnModel().getColumn(0).setMinWidth(0);
            tbVersao.getColumnModel().getColumn(0).setMaxWidth(0);
            tbVersao.getColumnModel().getColumn(1).setMinWidth(0);
            tbVersao.getColumnModel().getColumn(1).setMaxWidth(0);
            tbVersao.getColumnModel().getColumn(10).setMinWidth(0);
            tbVersao.getColumnModel().getColumn(10).setMaxWidth(0);
            tbVersao.getColumnModel().getColumn(11).setMinWidth(0);
            tbVersao.getColumnModel().getColumn(11).setMaxWidth(0);
        }

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Visualização Ficha de Controle de Extrusão");

        lbl_envialinha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cooper-standard-original_1.jpg"))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Número da Peça:");

        txt_perfil.setEditable(false);
        txt_perfil.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_perfil.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_perfil.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Cliente:");

        txt_cliente.setEditable(false);
        txt_cliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cliente.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_cliente.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("Descrição da Peça:");

        txt_descmaterial.setEditable(false);
        txt_descmaterial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_descmaterial.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_descmaterial.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setText("Número do Desenho:");

        txt_desenho.setEditable(false);
        txt_desenho.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_desenho.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_desenho.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("Número do Plano:");

        txt_plano.setEditable(false);
        txt_plano.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_plano.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_plano.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("Data de Entrada:");

        txt_data.setEditable(false);
        txt_data.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_data.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_data.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("Hora de Entrada:");

        txt_hora.setEditable(false);
        txt_hora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_hora.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_hora.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Emitente:");

        txt_emitente.setEditable(false);
        txt_emitente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_emitente.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_emitente.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_descmaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_desenho, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(txt_plano, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_emitente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txt_desenho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txt_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txt_emitente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(txt_plano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(38, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)))
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-sincronizar-conex¦o-filled-50.png"))); // NOI18N
        jMenu1.setText("Voltar Versão Ficha de Controle");

        jMenuItem1.setText("Voltar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

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
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        int p = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja realizar a troca de versão desses itens?", "Troca de Versão", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(this.getClass().getResource("/images/icons8_Error_48px.png")));
        if (p == 0) {
            Deletafichacontrole();
            Copiadados_histo();
            carregaTabela();
            Salvadata();
            JOptionPane.showMessageDialog(null, "Versão restaurada com sucesso!");
            new ViewGerenciador().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void carregaTabela() {
        listaModelHistorico = controllerHistorico.getListaVersaoMaterialHistoController(perfil, data, hora);

        DefaultTableModel modelo = (DefaultTableModel) tbVersao.getModel();
        modelo.setNumRows(0);
        int cont = listaModelHistorico.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelHistorico.get(i).getId(),
                listaModelHistorico.get(i).getHisto_ordem(),
                listaModelHistorico.get(i).getEqu_operacao(),
                listaModelHistorico.get(i).getHisto_equipamento(),
                listaModelHistorico.get(i).getDesc_teste(),
                listaModelHistorico.get(i).getHisto_complemento(),
                listaModelHistorico.get(i).getHisto_referencia(),
                listaModelHistorico.get(i).getHisto_tipo_espec(),
                listaModelHistorico.get(i).getHisto_espec_completo(),
                listaModelHistorico.get(i).getHisto_freq_completo(),
                listaModelHistorico.get(i).getAlter_identificacao(),
                listaModelHistorico.get(i).getHisto_produto()
            });

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
            java.util.logging.Logger.getLogger(ViewVersao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewVersao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewVersao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewVersao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewVersao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lbl_envialinha;
    private javax.swing.JTable tbVersao;
    private javax.swing.JTextField txt_cliente;
    private javax.swing.JTextField txt_data;
    private javax.swing.JTextField txt_descmaterial;
    private javax.swing.JTextField txt_desenho;
    private javax.swing.JTextField txt_emitente;
    private javax.swing.JTextField txt_hora;
    private javax.swing.JTextField txt_perfil;
    private javax.swing.JTextField txt_plano;
    // End of variables declaration//GEN-END:variables
}

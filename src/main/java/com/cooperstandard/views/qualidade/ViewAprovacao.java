package com.cooperstandard.views.qualidade;

import com.cooperstandard.util.CenterCellRenderer;

import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rsouza10
 */

public class ViewAprovacao extends javax.swing.JFrame {

    String tipo_teste = "";
    String resultado_texto = "";
    int ultimaLinhaEditada, ultimaColunaEditada;
    JComboBox combo;
    DefaultTableModel modelo = new DefaultTableModel(null, new String[]{
        "ID", //  0
        "Ordem", //  1
        "Linha", //  2
        "Linha_Tipo", //  3
        "Setor", //4
        "Perfil", //5
        "Bpcs", //6
        "Desc_Perfil", //7
        "Projeto", //8
        "OEM", //9
        "Nº_Desenho", //10
        "Nº_Plano", // 11
        "Operação", // 12
        "Equipamento", // 13
        "Desc_Teste", // 14
        "Complemento", // 15
        "Cod_Teste", // 16
        "Espec_Min", // 17
        "Espec_Max", // 18
        "Espec_Unid", // 19
        "Espec_Texto", // 20
        "Referência", // 21
        "Frequência", // 22                         
        "Freq_Unid", // 23
        "Produto", // 24
        "Origem", // 25
        "Tipo", // 26
        "Especificação", // 27
        "Freq_Texto", // 28
        "Laboratorio",//29
        "Status",//30
        "Identifficação",//31
        "Composto"}) {//32
        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }
    };
    String perfil = "";
    String data = "";
    String hora = "";
    String registro = "";
    String desenho = "";
    String projeto = "";
    String plano = "";
    String oem = "";
    String descmaterial = "";
    String envialinha = "";
    String emitente = "";
    String rev = "";
    String responsavel = "";
    String setor = "";
    //---
    String revplan = "";
    String emitenteplan = "";
    String responsavelplan = "";

    public ViewAprovacao() {
        initComponents();
    }

    public ViewAprovacao(String _perfil, String _data, String _hora, String _desenho, String _projeto, String _plano, String _oem, String _descmaterial, String _envialinha, String _emitente, String _rev, String _responsavel, String _setor, String _revplan, String _emitenteplan, String _responsavelplan) {
        initComponents();
        //não mover coluna
        setExtendedState(MAXIMIZED_BOTH);
        CadresultadoTabela.getTableHeader().setReorderingAllowed(false);
        txt_emp.setVisible(false);
        painelfantasma.setVisible(false);
        perfil = _perfil;
        data = _data;
        hora = _hora;
        oem = _oem;
        desenho = _desenho;
        plano = _plano;
        descmaterial = _descmaterial;
        envialinha = _envialinha;
        emitente = _emitente;
        rev = _rev;
        responsavel = _responsavel;
        setor = _setor;
        //---
        revplan = _revplan;
        emitenteplan = _emitenteplan;
        responsavelplan = _responsavelplan;
        txt_setor.setText(setor);
        txt_responsavel.setText(responsavel);
        txt_rev.setText(
                ""
                + (Integer.parseInt(rev) + 1)
        );
        //---
        if (!txtRevPlan.getText().equals("")) {
            txtRevPlan.setText(
                    ""
                    + (Integer.parseInt(revplan) + 1)
            );
        }
        txtEmitentePlan.setText(emitenteplan);
        txtResponsavelPlan.setText(responsavelplan);
        txt_emitente.setText(emitente);
        lbl_envialinha.setText((envialinha));
        txt_descmaterial.setText((descmaterial));
        txt_desenho.setText((desenho));
        txt_cliente.setText(oem);
        txt_perfil.setText((perfil));
        txt_data.setText((data));
        txt_hora.setText((hora));
        txt_plano.setText((plano));
        txtLinha.setText(envialinha);

        PreencherTabela();

        //jtable modificação
        ((DefaultTableCellRenderer) CadresultadoTabela.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        CadresultadoTabela.setForeground(Color.BLACK);
        CadresultadoTabela.setGridColor(Color.BLACK);
        CadresultadoTabela.setShowGrid(true);
        // Palavras no centro da célula
        CadresultadoTabela.getColumnModel().getColumn(12).setCellRenderer(new CenterCellRenderer());
        CadresultadoTabela.getColumnModel().getColumn(13).setCellRenderer(new CenterCellRenderer());
        CadresultadoTabela.getColumnModel().getColumn(14).setCellRenderer(new CenterCellRenderer());
        CadresultadoTabela.getColumnModel().getColumn(15).setCellRenderer(new CenterCellRenderer());
        CadresultadoTabela.getColumnModel().getColumn(21).setCellRenderer(new CenterCellRenderer());
        CadresultadoTabela.getColumnModel().getColumn(26).setCellRenderer(new CenterCellRenderer());
        CadresultadoTabela.getColumnModel().getColumn(28).setCellRenderer(new CenterCellRenderer());

        class CustomRenderer extends DefaultTableCellRenderer {

            private static final long serialVersionUID = 6703872492730589499L;

            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (table.getValueAt(row, 24).equals("Não")) {
                    cellComponent.setBackground(new Color(153, 153, 153));
                } else if (table.getValueAt(row, 24).equals("Sim")) {
                    cellComponent.setBackground(Color.WHITE);
                    cellComponent.setForeground(Color.BLACK);
                }
                return cellComponent;
            }
        }
        CadresultadoTabela.getColumnModel().getColumn(14).setCellRenderer(new CustomRenderer());

        //MUDA COR DA LINHA3
        CadresultadoTabela.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                Object ref = table.getValueAt(row, 31);

                if (ref != null && ref.equals(1)) {
                    setBackground(Color.YELLOW);
                    setForeground(Color.BLACK);

                } else if (ref != null && ref.equals(2)) {
                    setBackground(Color.GREEN);
                    setForeground(Color.BLACK);

                } else if (ref != null && ref.equals(3)) {
                    setBackground(Color.RED);
                    setForeground(Color.BLACK);

                } else {
                    boolean sel = isSelected;
                    if (sel == true) {
                        setBackground(getBackground());
                        setForeground(getForeground());
                    } else {
                        setBackground(Color.WHITE);
                        setForeground(new Color(51, 51, 51));
                    }
                }
                return this;
            }
        });
    }

    public void Salvarodape() {
        try {

            
            Connection con = new ConexaoSql().getCon();
            String sql = "insert into Cad_Rodape"
                    + "(ROD_DATA,ROD_REV,ROD_DESCRICAO,ROD_EMITENTE,ROD_SETOR,ROD_RESPONSAVEL,ROD_MATERIAL)"
                    + "values(?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, txt_data.getText());
            pst.setString(2, txt_rev.getText());
            pst.setString(3, txt_descricao.getText());
            pst.setString(4, txt_emitente.getText());
            pst.setString(5, txt_setor.getText());
            pst.setString(6, txt_responsavel.getText());
            pst.setString(7, txt_perfil.getText());

            pst.executeUpdate();
        } catch (Exception e) {

        }
    }

    //deleta dados da tabela Ficha_controle
    public void Deletafichacontrole() {
        try {

            
            Connection con = new ConexaoSql().getCon();
            String query1 = "DELETE FROM Ficha_Controle WHERE ESP_MATERIAL='" + txt_perfil.getText() + "'";
            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
        } catch (Exception e) {

        }
    }

    //deleta dados da tabela onde foi removido e contem o código 3
    public void Deletadados_removidos() {
        try {

            
            Connection con = new ConexaoSql().getCon();
            String query1 = "DELETE FROM Cad_Espec_Teste WHERE ALTER_IDENTIFICACAO='3'";
            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
        } catch (Exception e) {

        }
    }

    //copia dados da tabela Cad_Espec_Teste para Ficha_Controle
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

    //copia dados de uma tabela para outra
    public void Copiadados_histo() {
        try {

            
            Connection con = new ConexaoSql().getCon();
            String query1 = "INSERT INTO Histo_Ficha_Controle (ORDEM,HISTO_LINHA,HISTO_MATERIAL,HISTO_TESTE,HISTO_EQUIPAMENTO,HISTO_MINIMO,HISTO_MAXIMO,HISTO_UNID_MEDIDA,HISTO_TEXTO,"
                    + "HISTO_REFERENCIA,HISTO_FREQUENCIA,HISTO_UNID_FREQUENCIA,HISTO_PRODUTO,HISTO_ORIGEM,HISTO_TIPO_ESPEC,HISTO_ESPEC_COMPLEMENTO,HISTO_FREQ_COMPLETO,HISTO_LAB,"
                    + "HISTO_COMPLEMENTO,HISTO_RESPONSAVEL,HISTO_PENDENCIA,HISTO_DATA_HISTO,HISTO_OBSERVACAO,HISTO_DATE_VALID,ALTER_IDENTIFICACAO,HISTO_HORA,HISTO_COMPOSTO, HISTO_STATUS, HISTO_AMOSTRA) SELECT  ORDEM,ESP_LINHA ,"
                    + "ESP_MATERIAL ,ESP_TESTE ,ESP_EQUIPAMENTO ,MINIMO ,MAXIMO ,UNID_MEDIDA ,TEXTO ,REFERENCIA ,FREQUENCIA ,"
                    + "UNID_FREQUENCIA,PRODUTO ,ORIGEM ,TIPO_ESPEC ,ESPEC_COMPLETO ,FREQ_COMPLETO ,LAB ,COMPLEMENTO,"
                    + "RESPONSAVEL_ALTER,PENDENCIA_ALTER,DATA_ALTER,OBSERVACAO_ALTER,DATE_VALIDE_ALTER,ALTER_IDENTIFICACAO,HORA_ALTER,ESP_COMPOSTO,STATUS, AMOSTRA FROM Cad_Espec_Teste WHERE ESP_MATERIAL='" + txt_perfil.getText() + "'";

            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
        } catch (Exception e) {

        }

    }

    //copia dados da tabela Alter_Ficha_Controle para Cad_Espec_Teste
    public void Salvadata() {

        try {

            
            Connection con = new ConexaoSql().getCon();
            for (int i = 0; i < CadresultadoTabela.getRowCount(); i++) {
                String sql = "UPDATE Cad_Espec_Teste set DATA_ALTER=?,HORA_ALTER=? ";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, txt_data.getText());
                pst.setString(2, txt_hora.getText());
                pst.executeUpdate();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //deleta dados da tabela Alter_Ficha_Controle
    public void Deletadados_alter() {
        try {

            
            Connection con = new ConexaoSql().getCon();
            String query1 = "DELETE FROM  Cad_Espec_Teste WHERE ESP_MATERIAL='" + txt_perfil.getText() + "'";
            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
        } catch (Exception e) {

        }

    }

    public void SalvarodapePlan() {
        try {

            
            Connection con = new ConexaoSql().getCon();
            String sql = "insert into Cad_RodPlan"
                    + "(RODPLAN_DATA,RODPLAN_REV,RODPLAN_DESCRICAO,RODPLAN_EMITENTE,RODPLAN_SETOR,RODPLAN_RESPONSAVEL,RODPLAN_MATERIAL,RODPLAN_LINHA)"
                    + "values(?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, txt_data.getText());
            pst.setString(2, txtRevPlan.getText());
            pst.setString(3, txt_descricaoPlano.getText());
            pst.setString(4, txtEmitentePlan.getText());
            pst.setString(5, txt_setor.getText());
            pst.setString(6, txtResponsavelPlan.getText());
            pst.setString(7, txt_perfil.getText());
            pst.setString(8, txtLinha.getText());

            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CadresultadoTabela = new javax.swing.JTable();
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
        jLabel6 = new javax.swing.JLabel();
        txt_responsavel = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        painelfantasma = new javax.swing.JPanel();
        txt_emp = new javax.swing.JLabel();
        txt_pendencia = new javax.swing.JTextField();
        txt_rev = new javax.swing.JTextField();
        txt_setor = new javax.swing.JTextField();
        txt_descricao = new javax.swing.JTextField();
        txt_descricaoPlano = new javax.swing.JTextField();
        txtRevPlan = new javax.swing.JTextField();
        txtEmitentePlan = new javax.swing.JTextField();
        txtResponsavelPlan = new javax.swing.JTextField();
        txtLinha = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        CadresultadoTabela.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(CadresultadoTabela);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Validação Ficha de Controle de Extrusão");

        lbl_envialinha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cooper-standard-original_1.jpg"))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Número da Peça:");

        txt_perfil.setEditable(false);
        txt_perfil.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_perfil.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Cliente:");

        txt_cliente.setEditable(false);
        txt_cliente.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_cliente.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("Descrição da Peça:");

        txt_descmaterial.setEditable(false);
        txt_descmaterial.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_descmaterial.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setText("Número do Desenho:");

        txt_desenho.setEditable(false);
        txt_desenho.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_desenho.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("Número do Plano:");

        txt_plano.setEditable(false);
        txt_plano.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_plano.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("Data de Entrada:");

        txt_data.setEditable(false);
        txt_data.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_data.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("Hora de Entrada:");

        txt_hora.setEditable(false);
        txt_hora.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_hora.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Emitente:");

        txt_emitente.setEditable(false);
        txt_emitente.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_emitente.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Responsável:");

        txt_responsavel.setEditable(false);
        txt_responsavel.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_responsavel.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_responsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_emitente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_responsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(153, 153, 153));
        jTextField1.setFocusable(false);

        jLabel1.setText("Processo");

        jTextField2.setEditable(false);
        jTextField2.setFocusable(false);

        jLabel2.setText("Produto");

        jLabel4.setText("Alterado");

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(255, 255, 51));
        jTextField3.setFocusable(false);

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(0, 255, 51));
        jTextField4.setFocusable(false);

        jLabel15.setText("Adicionado");

        jLabel16.setText("Removido");

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(255, 0, 0));
        jTextField5.setFocusable(false);

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
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                    .addComponent(jLabel2)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)))
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

        painelfantasma.setBorder(javax.swing.BorderFactory.createTitledBorder("PainelFantasma"));

        txt_emp.setText("jLabel5");

        txt_pendencia.setEditable(false);
        txt_pendencia.setText("Pendente");
        txt_pendencia.setFocusable(false);

        txt_rev.setEditable(false);
        txt_rev.setFocusable(false);

        txt_setor.setEditable(false);
        txt_setor.setFocusable(false);

        txt_descricao.setEditable(false);
        txt_descricao.setFocusable(false);

        txt_descricaoPlano.setEditable(false);
        txt_descricaoPlano.setFocusable(false);

        txtRevPlan.setEditable(false);
        txtRevPlan.setFocusable(false);

        txtEmitentePlan.setEditable(false);
        txtEmitentePlan.setEnabled(false);

        txtResponsavelPlan.setEditable(false);
        txtResponsavelPlan.setEnabled(false);

        txtLinha.setEditable(false);
        txtLinha.setEnabled(false);

        javax.swing.GroupLayout painelfantasmaLayout = new javax.swing.GroupLayout(painelfantasma);
        painelfantasma.setLayout(painelfantasmaLayout);
        painelfantasmaLayout.setHorizontalGroup(
            painelfantasmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelfantasmaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_emp)
                .addGap(6, 6, 6)
                .addComponent(txt_pendencia, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(txt_rev, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(txt_setor, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_descricaoPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtRevPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtEmitentePlan, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtResponsavelPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelfantasmaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(417, 417, 417))
        );
        painelfantasmaLayout.setVerticalGroup(
            painelfantasmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelfantasmaLayout.createSequentialGroup()
                .addGroup(painelfantasmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelfantasmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEmitentePlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtResponsavelPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelfantasmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_emp)
                        .addComponent(txt_pendencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_rev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_setor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_descricaoPlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtRevPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelfantasma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelfantasma, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-selecionado-filled-50.png"))); // NOI18N
        jMenu1.setText("Validar Ficha");

        jMenuItem1.setText("Validar");
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
    }// </editor-fold>//GEN-END:initComponents
private void PreencherTabela() {
        try {
            modelo.setNumRows(0);
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select ID_ESPEC_TESTE, ORDEM ,ESP_LINHA,TIPO_LINHA ,SETOR ,ESP_MATERIAL,BPCS,DESC_MATERIAL ,MAT_PROJETO ,PRO_OEM,N_DESENHO ,N_PLANO,EQU_OPERACAO,"
                    + "ESP_EQUIPAMENTO, DESC_TESTE,COMPLEMENTO,ESP_TESTE ,"
                    + "MINIMO,MAXIMO,UNID_MEDIDA ,TEXTO,REFERENCIA,"
                    + "FREQUENCIA,UNID_FREQUENCIA,PRODUTO,ORIGEM,TIPO_ESPEC,ESPEC_COMPLETO,"
                    + "FREQ_COMPLETO,LAB,PENDENCIA_ALTER,ALTER_IDENTIFICACAO,ESP_COMPOSTO from Qry_Alter_Result where  ESP_MATERIAL= " + txt_perfil.getText() + " ORDER BY ORDEM asc";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getInt("ID_ESPEC_TESTE"),//0
                    rs.getString("ORDEM"),//1
                    rs.getString("ESP_LINHA"),//2
                    rs.getString("TIPO_LINHA"),//3
                    rs.getString("SETOR"),//4
                    rs.getString("ESP_MATERIAL"),//5
                    rs.getString("BPCS"),//6
                    rs.getString("DESC_MATERIAL"),//7
                    rs.getString("MAT_PROJETO"),//8
                    rs.getString("PRO_OEM"),//9
                    rs.getString("N_DESENHO"),//10
                    rs.getString("N_PLANO"),//11
                    rs.getString("EQU_OPERACAO"),//12
                    rs.getString("ESP_EQUIPAMENTO"),//13
                    rs.getString("DESC_TESTE"),//14
                    rs.getString("COMPLEMENTO"),//15
                    rs.getString("ESP_TESTE"),//16
                    rs.getString("MINIMO"),//17
                    rs.getString("MAXIMO"),//18
                    rs.getString("UNID_MEDIDA"),//19
                    rs.getString("TEXTO"),//20
                    rs.getString("REFERENCIA"),//21
                    rs.getString("FREQUENCIA"),//22
                    rs.getString("UNID_FREQUENCIA"),//23
                    rs.getString("PRODUTO"),//24
                    rs.getString("ORIGEM"),//25
                    rs.getString("TIPO_ESPEC"),//26
                    rs.getString("ESPEC_COMPLETO"),//27
                    rs.getString("FREQ_COMPLETO"),//28
                    rs.getString("LAB"),//29
                    rs.getString("PENDENCIA_ALTER"),//30
                    rs.getInt("ALTER_IDENTIFICACAO"),//31
                    rs.getInt("ESP_COMPOSTO")});//32

            }
            modelo.isCellEditable(modelo.getColumnCount(), modelo.getRowCount());
            CadresultadoTabela.setModel(modelo);
            CadresultadoTabela.getColumnModel().getColumn(0).setMinWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(0).setMaxWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(1).setMinWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(1).setMaxWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(2).setMinWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(2).setMaxWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(3).setMinWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(3).setMaxWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(4).setMinWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(4).setMaxWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(5).setMinWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(5).setMaxWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(6).setMinWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(6).setMaxWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(7).setMinWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(7).setMaxWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(8).setMinWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(8).setMaxWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(9).setMinWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(9).setMaxWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(10).setMinWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(10).setMaxWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(11).setMinWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(11).setMaxWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(16).setMinWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(16).setMaxWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(17).setMinWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(17).setMaxWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(18).setMinWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(18).setMaxWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(19).setMinWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(19).setMaxWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(20).setMinWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(20).setMaxWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(22).setMinWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(22).setMaxWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(23).setMinWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(23).setMaxWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(24).setMinWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(24).setMaxWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(25).setMinWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(25).setMaxWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(29).setMinWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(29).setMaxWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(30).setMinWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(30).setMaxWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(31).setMinWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(31).setMaxWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(32).setMinWidth(0);
            CadresultadoTabela.getColumnModel().getColumn(32).setMaxWidth(0);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja realizar a validação desses itens?", "Validação", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(this.getClass().getResource("/images/icons8_Error_48px.png")));
        if (p == 0) {
            JOptionPane.showMessageDialog(null, "Validado com sucesso!");
            new ViewGerarRodape(Integer.parseInt(perfil), "Alteracão", envialinha).setVisible(true);
            Deletafichacontrole();
            Deletadados_removidos();
            CopiaFichaControle();
            Salvadata();
            Copiadados_histo();
            Deletadados_alter();
            dispose();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ViewAprovacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAprovacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAprovacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAprovacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAprovacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CadresultadoTabela;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
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
    private javax.swing.JPanel painelfantasma;
    private javax.swing.JTextField txtEmitentePlan;
    private javax.swing.JTextField txtLinha;
    private javax.swing.JTextField txtResponsavelPlan;
    private javax.swing.JTextField txtRevPlan;
    private javax.swing.JTextField txt_cliente;
    private javax.swing.JTextField txt_data;
    private javax.swing.JTextField txt_descmaterial;
    private javax.swing.JTextField txt_descricao;
    private javax.swing.JTextField txt_descricaoPlano;
    private javax.swing.JTextField txt_desenho;
    private javax.swing.JTextField txt_emitente;
    private javax.swing.JLabel txt_emp;
    private javax.swing.JTextField txt_hora;
    private javax.swing.JTextField txt_pendencia;
    private javax.swing.JTextField txt_perfil;
    private javax.swing.JTextField txt_plano;
    private javax.swing.JTextField txt_responsavel;
    private javax.swing.JTextField txt_rev;
    private javax.swing.JTextField txt_setor;
    // End of variables declaration//GEN-END:variables
}

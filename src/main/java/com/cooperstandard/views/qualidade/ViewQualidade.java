package com.cooperstandard.views.qualidade;

import com.cooperstandard.controller.extrusao.ControllerFichaControle;
import com.cooperstandard.controller.extrusao.ControllerFichaControleQualidade;
import com.cooperstandard.controller.extrusao.ControllerLinha;
import com.cooperstandard.controller.extrusao.ControllerProducao;
import com.cooperstandard.model.ModelFichaControle;
import com.cooperstandard.model.ModelFichaControleQualidade;
import com.cooperstandard.model.ModelLinha;
import com.cooperstandard.model.ModelProducao;
import com.cooperstandard.util.ButtonColumnCPK;
import com.cooperstandard.util.EstiloTablaRenderer;
import com.cooperstandard.util.HeaderRenderer;
import com.cooperstandard.controller.acabamento.ControllerFichaControleAc;
import com.cooperstandard.controller.acabamento.ControllerFichaControleQualidadeAc;
import com.cooperstandard.controller.acabamento.ControllerLinhaAc;
import com.cooperstandard.controller.acabamento.ControllerProducaoAc;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rsouza10
 */
public class ViewQualidade extends javax.swing.JFrame {

    private static final long serialVersionUID = 5396042218297061655L;

    ModelFichaControle modelFichaControle = new ModelFichaControle();
    ControllerFichaControle controllerFichaControle = new ControllerFichaControle();
    ControllerFichaControleAc controllerFichaControleAc = new ControllerFichaControleAc();
    ArrayList<ModelFichaControleQualidade> listaModelFichaControleQualidade = new ArrayList<ModelFichaControleQualidade>();
    ModelFichaControleQualidade modelFichaControleQualidade = new ModelFichaControleQualidade();
    ControllerFichaControleQualidade controllerFichaControleQualidade = new ControllerFichaControleQualidade();
    ControllerFichaControleQualidadeAc controllerFichaControleQualidadeAc = new ControllerFichaControleQualidadeAc();
    ControllerProducao controllerProducao = new ControllerProducao();
    ArrayList<ModelProducao> listaModelProducao = new ArrayList<ModelProducao>();
    ControllerProducaoAc controllerProducaoAc = new ControllerProducaoAc();
    ControllerLinha controllerLinha = new ControllerLinha();
    ArrayList<ModelLinha> listaModelLinha = new ArrayList<ModelLinha>();
    ControllerLinhaAc controllerLinhaAc = new ControllerLinhaAc();
    String status = "";

    public ViewQualidade() {
        initComponents();
        ButtonGroup bG = new ButtonGroup();
        bG.add(JcbStatusPrototipo);
        bG.add(JcbStatusLancamento);
        bG.add(JcbStatusProducao);
        carregaTabela();
        carregaTabelaAc();
        tbAltera.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbAltera));
        tbAltera.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
        tbAltera.setDefaultRenderer(String.class, new EstiloTablaRenderer());
        tbAltera.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        tbAltera1.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbAltera1));
        tbAltera1.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
        tbAltera1.setDefaultRenderer(String.class, new EstiloTablaRenderer());
        tbAltera1.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        ButtonColumnCPK buttonColumn = new ButtonColumnCPK(tbAltera1, 4);
        ButtonColumnCPK buttonColumn1 = new ButtonColumnCPK(tbAltera, 4);
    }

    //copia dados de uma tabela para outra (Painel Alter)
    public void Copiadados() {
        try {
            java.util.Date currentDate = GregorianCalendar.getInstance().getTime();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = df.format(currentDate);
            String values = dateString;
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "INSERT INTO Cad_Espec_Teste (ORDEM,ESP_LINHA ,ESP_MATERIAL ,ESP_TESTE ,ESP_EQUIPAMENTO ,MINIMO ,MAXIMO ,UNID_MEDIDA ,TEXTO ,"
                    + "REFERENCIA ,FREQUENCIA ,UNID_FREQUENCIA,PRODUTO ,ORIGEM ,TIPO_ESPEC ,ESPEC_COMPLETO ,FREQ_COMPLETO ,LAB ,COMPLEMENTO,ESP_COMPOSTO, STATUS,PENDENCIA_ALTER, RESPONSAVEL_ALTER,DATA_ALTER,AMOSTRA) SELECT  ORDEM,ESP_LINHA  ,ESP_MATERIAL ,ESP_TESTE ,ESP_EQUIPAMENTO ,MINIMO ,MAXIMO ,UNID_MEDIDA ,TEXTO ,REFERENCIA ,FREQUENCIA ,UNID_FREQUENCIA ,PRODUTO ,ORIGEM ,TIPO_ESPEC ,ESPEC_COMPLETO ,"
                    + "FREQ_COMPLETO ,LAB ,COMPLEMENTO,ESP_COMPOSTO,STATUS,'Alteração Qualidade' as PENDENCIA,'" + txtAlteraSolicitante.getText() + "' as RESPONSAVEL, '" + values + "' AS DATA, AMOSTRA  FROM Ficha_Controle WHERE ESP_MATERIAL='" + cbAlteraMaterial.getSelectedItem() + "';";
            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
        } catch (Exception e) {

        }

    }
    //copia dados de uma tabela para outra (Painel Alter)

    public void CopiadadosAc() {
        try {
            java.util.Date currentDate = GregorianCalendar.getInstance().getTime();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = df.format(currentDate);
            String values = dateString;
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "INSERT INTO Cad_Espec_Teste (ORDEM,ESP_LINHA ,ESP_MATERIAL ,ESP_TESTE ,ESP_EQUIPAMENTO ,MINIMO ,MAXIMO ,UNID_MEDIDA ,TEXTO ,"
                    + "REFERENCIA ,FREQUENCIA ,UNID_FREQUENCIA,PRODUTO ,ORIGEM ,TIPO_ESPEC ,ESPEC_COMPLETO ,FREQ_COMPLETO ,LAB ,COMPLEMENTO,ESP_COMPOSTO, STATUS,PENDENCIA_ALTER, RESPONSAVEL_ALTER,DATA_ALTER, AMOSTRA) SELECT  ORDEM,ESP_LINHA  ,ESP_MATERIAL ,ESP_TESTE ,ESP_EQUIPAMENTO ,MINIMO ,MAXIMO ,UNID_MEDIDA ,TEXTO ,REFERENCIA ,FREQUENCIA ,UNID_FREQUENCIA ,PRODUTO ,ORIGEM ,TIPO_ESPEC ,ESPEC_COMPLETO ,"
                    + "FREQ_COMPLETO ,LAB ,COMPLEMENTO,ESP_COMPOSTO,STATUS,'Alteração Qualidade' as PENDENCIA,'" + txtAlteraSolicitante1.getText() + "' as RESPONSAVEL, '" + values + "' AS DATA, AMOSTRA  FROM Ficha_Controle WHERE ESP_MATERIAL='" + cbAlteraMaterial1.getSelectedItem() + "';";
            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
        } catch (Exception e) {

        }

    }

    public void UpdatPerfil() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String sql = "UPDATE Cad_Material set MAT_LINHA='" + cbCopiaLinha2.getSelectedItem().toString() + "' where MATERIAL='" + cbCopiaMaterial.getSelectedItem().toString() + "'";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void TrocaLinnhaFicha() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String sql = "UPDATE Ficha_Controle set ESP_LINHA='" + cbCopiaLinha2.getSelectedItem().toString() + "' where ESP_MATERIAL='" + cbCopiaMaterial.getSelectedItem().toString() + "'";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void UpdatPerfilAc() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String sql = "UPDATE Cad_Material set MAT_LINHA='" + cbCopiaLinha3.getSelectedItem().toString() + "' where MATERIAL='" + cbCopiaMaterial1.getSelectedItem().toString() + "'";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void TrocaLinnhaFichaAc() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String sql = "UPDATE Ficha_Controle set ESP_LINHA='" + cbCopiaLinha3.getSelectedItem().toString() + "' where ESP_MATERIAL='" + cbCopiaMaterial1.getSelectedItem().toString() + "'";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        cbAlteraSetor1 = new javax.swing.JComboBox<>();
        lbAlteraDesenho1 = new javax.swing.JLabel();
        lbAlteraSetor1 = new javax.swing.JLabel();
        txtAlteraProjeto1 = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbAltera1 = new javax.swing.JTable();
        lbAlteraProjeto1 = new javax.swing.JLabel();
        txtAlteraPlano1 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        lbAlteraPlano1 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        lbAlteraDesc1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        txtAlteraDesc1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        lbAlteraLinha1 = new javax.swing.JLabel();
        cbAlteraLinha1 = new javax.swing.JComboBox<>();
        cbAlteraMaterial1 = new javax.swing.JComboBox<>();
        txtAlteraSolicitante1 = new javax.swing.JTextField();
        txtAlteraDesenho1 = new javax.swing.JTextField();
        lbAlteraSolicitante1 = new javax.swing.JLabel();
        lbAlteraMaterial1 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        lbAlteraLinha = new javax.swing.JLabel();
        cbAlteraMaterial = new javax.swing.JComboBox<>();
        txtAlteraDesenho = new javax.swing.JTextField();
        lbAlteraMaterial = new javax.swing.JLabel();
        lbAlteraDesenho = new javax.swing.JLabel();
        txtAlteraProjeto = new javax.swing.JTextField();
        lbAlteraProjeto = new javax.swing.JLabel();
        txtAlteraPlano = new javax.swing.JTextField();
        lbAlteraPlano = new javax.swing.JLabel();
        lbAlteraDesc = new javax.swing.JLabel();
        txtAlteraDesc = new javax.swing.JTextField();
        cbAlteraLinha = new javax.swing.JComboBox<>();
        txtAlteraSolicitante = new javax.swing.JTextField();
        lbAlteraSolicitante = new javax.swing.JLabel();
        cbAlteraSetor = new javax.swing.JComboBox<>();
        lbAlteraSetor = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbAltera = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        cbRodFichaLinha1 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cbRodFichaMaterial1 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cbRodFichaLinha = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbRodFichaMaterial = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        cbRodPlanoLinha1 = new javax.swing.JComboBox<>();
        jButton13 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        cbRodPlanoLinha = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel17 = new javax.swing.JPanel();
        txtStatusDesenho1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        cbStatusMaterial1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtStatusDesc1 = new javax.swing.JTextField();
        txtStatusProjeto1 = new javax.swing.JTextField();
        jButton16 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        txtStatusPlano1 = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        JcbStatusPrototipo1 = new javax.swing.JCheckBox();
        JcbStatusLancamento1 = new javax.swing.JCheckBox();
        JcbStatusProducao1 = new javax.swing.JCheckBox();
        jLabel33 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        cbStatusLinha1 = new javax.swing.JComboBox<>();
        jPanel16 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtStatusProjeto = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtStatusPlano = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        cbStatusLinha = new javax.swing.JComboBox<>();
        txtStatusDesenho = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cbStatusMaterial = new javax.swing.JComboBox<>();
        txtStatusDesc = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        JcbStatusPrototipo = new javax.swing.JCheckBox();
        JcbStatusLancamento = new javax.swing.JCheckBox();
        JcbStatusProducao = new javax.swing.JCheckBox();
        jPanel20 = new javax.swing.JPanel();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jPanel21 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        lbCopiaPerfil1 = new javax.swing.JLabel();
        cbCopiaMaterial1 = new javax.swing.JComboBox<>();
        lbCopiaDesc1 = new javax.swing.JLabel();
        txtCopiaDesc1 = new javax.swing.JTextField();
        lbCopiaLinha1 = new javax.swing.JLabel();
        cbCopiaLinha1 = new javax.swing.JComboBox<>();
        lbCopiaProjeto1 = new javax.swing.JLabel();
        txtCopiaProjeto1 = new javax.swing.JTextField();
        lbCopiaPlano1 = new javax.swing.JLabel();
        txtCopiaPlano1 = new javax.swing.JTextField();
        lbCopiaDesenho1 = new javax.swing.JLabel();
        txtCopiaDesenho1 = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        lbCopiaLinha3 = new javax.swing.JLabel();
        cbCopiaLinha3 = new javax.swing.JComboBox<>();
        lbCopiaDesc3 = new javax.swing.JLabel();
        txtCopiaDesc3 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        lbCopiaLinha2 = new javax.swing.JLabel();
        cbCopiaLinha2 = new javax.swing.JComboBox<>();
        lbCopiaDesc2 = new javax.swing.JLabel();
        txtCopiaDesc2 = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        lbCopiaPerfil = new javax.swing.JLabel();
        cbCopiaMaterial = new javax.swing.JComboBox<>();
        lbCopiaDesc = new javax.swing.JLabel();
        txtCopiaDesc = new javax.swing.JTextField();
        lbCopiaLinha = new javax.swing.JLabel();
        cbCopiaLinha = new javax.swing.JComboBox<>();
        lbCopiaProjeto = new javax.swing.JLabel();
        txtCopiaProjeto = new javax.swing.JTextField();
        lbCopiaPlano = new javax.swing.JLabel();
        txtCopiaPlano = new javax.swing.JTextField();
        lbCopiaDesenho = new javax.swing.JLabel();
        txtCopiaDesenho = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel18 = new javax.swing.JPanel();
        jButton18 = new javax.swing.JButton();
        txtDeletaDesc1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtDeletaProjeto1 = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtDeletaPlano1 = new javax.swing.JTextField();
        cbDeletaLinha1 = new javax.swing.JComboBox<>();
        txtDeletaDesenho1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        cbDeletaMaterial1 = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtDeletaDesc = new javax.swing.JTextField();
        txtDeletaProjeto = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtDeletaPlano = new javax.swing.JTextField();
        cbDeletaLinha = new javax.swing.JComboBox<>();
        txtDeletaDesenho = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        cbDeletaMaterial = new javax.swing.JComboBox<>();
        jButton12 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N

        jTabbedPane3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cbAlteraSetor1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Garantia da Qualidade", "Engenharia de Processo" }));

        lbAlteraDesenho1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbAlteraDesenho1.setText("Número do Desenho:");

        lbAlteraSetor1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbAlteraSetor1.setText("Setor:");

        txtAlteraProjeto1.setEditable(false);
        txtAlteraProjeto1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAlteraProjeto1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAlteraProjeto1.setEnabled(false);
        txtAlteraProjeto1.setFocusable(false);

        tbAltera1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Data", "Célula", "Material", "Responsável", "Deletar Ficha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbAltera1.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(tbAltera1);

        lbAlteraProjeto1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbAlteraProjeto1.setText("Projeto:");

        txtAlteraPlano1.setEditable(false);
        txtAlteraPlano1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAlteraPlano1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAlteraPlano1.setEnabled(false);
        txtAlteraPlano1.setFocusable(false);

        jLabel35.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel35.setText("Fichas em Aberto:");

        lbAlteraPlano1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbAlteraPlano1.setText("Número do Plano:");

        jButton15.setBackground(new java.awt.Color(255, 255, 255));
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-n¦o-perturbe-filled-50.png"))); // NOI18N
        jButton15.setText("Cancelar");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        lbAlteraDesc1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbAlteraDesc1.setText("Descrição da Peça:");

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-selecionado-filled-50.png"))); // NOI18N
        jButton4.setText("Selecionar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtAlteraDesc1.setEditable(false);
        txtAlteraDesc1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAlteraDesc1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAlteraDesc1.setEnabled(false);
        txtAlteraDesc1.setFocusable(false);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-editar-filled-50.png"))); // NOI18N
        jButton5.setText("Alterar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        lbAlteraLinha1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbAlteraLinha1.setText("Célula:");

        cbAlteraLinha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlteraLinha1ActionPerformed(evt);
            }
        });

        cbAlteraMaterial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlteraMaterial1ActionPerformed(evt);
            }
        });

        txtAlteraDesenho1.setEditable(false);
        txtAlteraDesenho1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAlteraDesenho1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAlteraDesenho1.setEnabled(false);
        txtAlteraDesenho1.setFocusable(false);

        lbAlteraSolicitante1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbAlteraSolicitante1.setText("Solicitante:");

        lbAlteraMaterial1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbAlteraMaterial1.setText("Material:");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(txtAlteraProjeto1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                        .addComponent(lbAlteraProjeto1)
                                        .addGap(113, 113, 113)))
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbAlteraPlano1)
                                    .addComponent(txtAlteraPlano1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(lbAlteraDesenho1)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtAlteraDesenho1)))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbAlteraLinha1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbAlteraLinha1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbAlteraMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbAlteraMaterial1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAlteraDesc1)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(lbAlteraDesc1)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbAlteraSolicitante1)
                            .addComponent(txtAlteraSolicitante1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbAlteraSetor1, 0, 228, Short.MAX_VALUE)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(lbAlteraSetor1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAlteraLinha1)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbAlteraDesc1)
                        .addComponent(lbAlteraMaterial1)))
                .addGap(7, 7, 7)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbAlteraLinha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAlteraMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlteraDesc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAlteraPlano1)
                    .addComponent(lbAlteraDesenho1)
                    .addComponent(lbAlteraProjeto1))
                .addGap(7, 7, 7)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAlteraProjeto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlteraPlano1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlteraDesenho1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAlteraSolicitante1)
                    .addComponent(lbAlteraSetor1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlteraSolicitante1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAlteraSetor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton15)
                        .addComponent(jButton4)))
                .addContainerGap())
        );

        jTabbedPane3.addTab("Acabamento", jPanel13);

        lbAlteraLinha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbAlteraLinha.setText("Linha:");

        cbAlteraMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlteraMaterialActionPerformed(evt);
            }
        });

        txtAlteraDesenho.setEditable(false);
        txtAlteraDesenho.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAlteraDesenho.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAlteraDesenho.setEnabled(false);
        txtAlteraDesenho.setFocusable(false);

        lbAlteraMaterial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbAlteraMaterial.setText("Material:");

        lbAlteraDesenho.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbAlteraDesenho.setText("Número do Desenho:");

        txtAlteraProjeto.setEditable(false);
        txtAlteraProjeto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAlteraProjeto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAlteraProjeto.setEnabled(false);
        txtAlteraProjeto.setFocusable(false);

        lbAlteraProjeto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbAlteraProjeto.setText("Projeto:");

        txtAlteraPlano.setEditable(false);
        txtAlteraPlano.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAlteraPlano.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAlteraPlano.setEnabled(false);
        txtAlteraPlano.setFocusable(false);

        lbAlteraPlano.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbAlteraPlano.setText("Número do Plano:");

        lbAlteraDesc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbAlteraDesc.setText("Descrição da Peça:");

        txtAlteraDesc.setEditable(false);
        txtAlteraDesc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAlteraDesc.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAlteraDesc.setEnabled(false);
        txtAlteraDesc.setFocusable(false);

        cbAlteraLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlteraLinhaActionPerformed(evt);
            }
        });

        lbAlteraSolicitante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbAlteraSolicitante.setText("Solicitante:");

        cbAlteraSetor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Garantia da Qualidade", "Engenharia de Processo" }));

        lbAlteraSetor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbAlteraSetor.setText("Setor:");

        tbAltera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Data", "Linha", "Material", "Responsável", "Deletar Ficha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbAltera.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tbAltera);

        jLabel34.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel34.setText("Fichas em Aberto:");

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-n¦o-perturbe-filled-50.png"))); // NOI18N
        jButton10.setText("Cancelar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-selecionado-filled-50.png"))); // NOI18N
        jButton3.setText("Selecionar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-editar-filled-50.png"))); // NOI18N
        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(txtAlteraProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                        .addComponent(lbAlteraProjeto)
                                        .addGap(113, 113, 113)))
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbAlteraPlano)
                                    .addComponent(txtAlteraPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(lbAlteraDesenho)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtAlteraDesenho)))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbAlteraLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbAlteraLinha))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbAlteraMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbAlteraMaterial))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAlteraDesc)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(lbAlteraDesc)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbAlteraSolicitante)
                            .addComponent(txtAlteraSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbAlteraSetor, 0, 228, Short.MAX_VALUE)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(lbAlteraSetor)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAlteraLinha)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbAlteraDesc)
                        .addComponent(lbAlteraMaterial)))
                .addGap(7, 7, 7)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbAlteraLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAlteraMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlteraDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAlteraPlano)
                    .addComponent(lbAlteraDesenho)
                    .addComponent(lbAlteraProjeto))
                .addGap(7, 7, 7)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAlteraProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlteraPlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlteraDesenho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAlteraSetor)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(lbAlteraSolicitante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAlteraSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAlteraSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton10)
                        .addComponent(jButton3)))
                .addContainerGap())
        );

        jTabbedPane3.addTab("Extrusão", jPanel14);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane1.addTab("Alterar Ficha de Controle", jPanel2);

        jTabbedPane4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton14.setBackground(new java.awt.Color(255, 255, 255));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-pesquisar-filled-50.png"))); // NOI18N
        jButton14.setText("Visualizar");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        cbRodFichaLinha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRodFichaLinha1ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Célula:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Material:");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbRodFichaLinha1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(cbRodFichaMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton14)))
                .addGap(96, 96, 96))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton14)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbRodFichaLinha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbRodFichaMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(206, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Acabamento", jPanel15);

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Linha:");

        cbRodFichaLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRodFichaLinhaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Material:");

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-pesquisar-filled-50.png"))); // NOI18N
        jButton6.setText("Visualizar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbRodFichaLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(cbRodFichaMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)))
                .addGap(99, 99, 99))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton6)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbRodFichaLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbRodFichaMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(205, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Extrusão", jPanel11);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );

        jTabbedPane1.addTab("Rodapé Ficha", jPanel3);

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Célula:");

        jButton13.setBackground(new java.awt.Color(255, 255, 255));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-pesquisar-filled-50.png"))); // NOI18N
        jButton13.setText("Visualizar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(cbRodPlanoLinha1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton13)))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel27)
                .addGap(4, 4, 4)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRodPlanoLinha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13))
                .addContainerGap(200, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Acabamento", jPanel1);

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Linha:");

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-pesquisar-filled-50.png"))); // NOI18N
        jButton9.setText("Visualizar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(cbRodPlanoLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9)))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel26)
                .addGap(4, 4, 4)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRodPlanoLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9))
                .addContainerGap(196, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Extrusão", jPanel10);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jTabbedPane1.addTab("Rodapé Plano", jPanel9);

        jTabbedPane5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtStatusDesenho1.setEditable(false);
        txtStatusDesenho1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStatusDesenho1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtStatusDesenho1.setEnabled(false);
        txtStatusDesenho1.setFocusable(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Célula:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Material:");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("Descrição da Peça:");

        cbStatusMaterial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatusMaterial1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Status:");

        txtStatusDesc1.setEditable(false);
        txtStatusDesc1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStatusDesc1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtStatusDesc1.setEnabled(false);
        txtStatusDesc1.setFocusable(false);

        txtStatusProjeto1.setEditable(false);
        txtStatusProjeto1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStatusProjeto1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtStatusProjeto1.setEnabled(false);
        txtStatusProjeto1.setFocusable(false);

        jButton16.setBackground(new java.awt.Color(255, 255, 255));
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-n¦o-perturbe-filled-50.png"))); // NOI18N
        jButton16.setText("Cancelar");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Projeto:");

        jButton17.setBackground(new java.awt.Color(255, 255, 255));
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-pesquisar-filled-50.png"))); // NOI18N
        jButton17.setText("Visualizar");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        txtStatusPlano1.setEditable(false);
        txtStatusPlano1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStatusPlano1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtStatusPlano1.setEnabled(false);
        txtStatusPlano1.setFocusable(false);

        jPanel25.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel25.setEnabled(false);

        JcbStatusPrototipo1.setBackground(new java.awt.Color(255, 255, 255));
        JcbStatusPrototipo1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JcbStatusPrototipo1.setText("Protótipo");
        JcbStatusPrototipo1.setBorderPainted(true);
        JcbStatusPrototipo1.setEnabled(false);

        JcbStatusLancamento1.setBackground(new java.awt.Color(255, 255, 255));
        JcbStatusLancamento1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JcbStatusLancamento1.setText("Pré-Lançamento");
        JcbStatusLancamento1.setBorderPainted(true);
        JcbStatusLancamento1.setEnabled(false);

        JcbStatusProducao1.setBackground(new java.awt.Color(255, 255, 255));
        JcbStatusProducao1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JcbStatusProducao1.setText("Produção");
        JcbStatusProducao1.setBorderPainted(true);
        JcbStatusProducao1.setEnabled(false);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(JcbStatusPrototipo1)
                .addGap(90, 90, 90)
                .addComponent(JcbStatusLancamento1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JcbStatusProducao1)
                .addGap(28, 28, 28))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JcbStatusPrototipo1)
                    .addComponent(JcbStatusLancamento1)
                    .addComponent(JcbStatusProducao1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Número do Plano:");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("Número do Desenho:");

        cbStatusLinha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatusLinha1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbStatusLinha1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(cbStatusMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtStatusDesc1)))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(txtStatusProjeto1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStatusPlano1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addGap(0, 125, Short.MAX_VALUE))
                            .addComponent(txtStatusDesenho1)))
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton17)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel28))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbStatusLinha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbStatusMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(7, 7, 7)
                                .addComponent(txtStatusDesc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtStatusPlano1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStatusDesenho1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel38))
                                .addGap(27, 27, 27))))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(7, 7, 7)
                        .addComponent(txtStatusProjeto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton17)))
        );

        jTabbedPane5.addTab("Acabamento", jPanel17);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Descrição da Peça:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Status:");

        txtStatusProjeto.setEditable(false);
        txtStatusProjeto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStatusProjeto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtStatusProjeto.setEnabled(false);
        txtStatusProjeto.setFocusable(false);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Projeto:");

        txtStatusPlano.setEditable(false);
        txtStatusPlano.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStatusPlano.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtStatusPlano.setEnabled(false);
        txtStatusPlano.setFocusable(false);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Número do Plano:");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Número do Desenho:");

        cbStatusLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatusLinhaActionPerformed(evt);
            }
        });

        txtStatusDesenho.setEditable(false);
        txtStatusDesenho.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStatusDesenho.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtStatusDesenho.setEnabled(false);
        txtStatusDesenho.setFocusable(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Linha:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Material:");

        cbStatusMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatusMaterialActionPerformed(evt);
            }
        });

        txtStatusDesc.setEditable(false);
        txtStatusDesc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStatusDesc.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtStatusDesc.setEnabled(false);
        txtStatusDesc.setFocusable(false);

        jButton11.setBackground(new java.awt.Color(255, 255, 255));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-n¦o-perturbe-filled-50.png"))); // NOI18N
        jButton11.setText("Cancelar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-pesquisar-filled-50.png"))); // NOI18N
        jButton8.setText("Visualizar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setEnabled(false);

        JcbStatusPrototipo.setBackground(new java.awt.Color(255, 255, 255));
        JcbStatusPrototipo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JcbStatusPrototipo.setText("Protótipo");
        JcbStatusPrototipo.setBorderPainted(true);
        JcbStatusPrototipo.setEnabled(false);

        JcbStatusLancamento.setBackground(new java.awt.Color(255, 255, 255));
        JcbStatusLancamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JcbStatusLancamento.setText("Pré-Lançamento");
        JcbStatusLancamento.setBorderPainted(true);
        JcbStatusLancamento.setEnabled(false);

        JcbStatusProducao.setBackground(new java.awt.Color(255, 255, 255));
        JcbStatusProducao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JcbStatusProducao.setText("Produção");
        JcbStatusProducao.setBorderPainted(true);
        JcbStatusProducao.setEnabled(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(JcbStatusPrototipo)
                .addGap(90, 90, 90)
                .addComponent(JcbStatusLancamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JcbStatusProducao)
                .addGap(28, 28, 28))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JcbStatusPrototipo)
                    .addComponent(JcbStatusLancamento)
                    .addComponent(JcbStatusProducao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbStatusLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(cbStatusMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtStatusDesc)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(txtStatusProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStatusPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(0, 125, Short.MAX_VALUE))
                            .addComponent(txtStatusDesenho)))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel22))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbStatusLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbStatusMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(7, 7, 7)
                                .addComponent(txtStatusDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtStatusPlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStatusDesenho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel37))
                                .addGap(27, 27, 27))))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(7, 7, 7)
                        .addComponent(txtStatusProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8)))
        );

        jTabbedPane5.addTab("Extrusão", jPanel16);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );

        jTabbedPane1.addTab("Alterar Status Ficha ", jPanel7);

        jTabbedPane7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel26.setBackground(new java.awt.Color(255, 112, 112));

        jLabel43.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Escolha a Linha e Material para trocar");

        lbCopiaPerfil1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCopiaPerfil1.setText("Material:");

        cbCopiaMaterial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCopiaMaterial1ActionPerformed(evt);
            }
        });

        lbCopiaDesc1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCopiaDesc1.setText("Descrição da Peça:");

        txtCopiaDesc1.setEditable(false);
        txtCopiaDesc1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCopiaDesc1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCopiaDesc1.setEnabled(false);
        txtCopiaDesc1.setFocusable(false);

        lbCopiaLinha1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCopiaLinha1.setText("Célula:");

        cbCopiaLinha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCopiaLinha1ActionPerformed(evt);
            }
        });

        lbCopiaProjeto1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCopiaProjeto1.setText("Projeto:");

        txtCopiaProjeto1.setEditable(false);
        txtCopiaProjeto1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCopiaProjeto1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCopiaProjeto1.setEnabled(false);
        txtCopiaProjeto1.setFocusable(false);

        lbCopiaPlano1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCopiaPlano1.setText("Número do Plano:");

        txtCopiaPlano1.setEditable(false);
        txtCopiaPlano1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCopiaPlano1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCopiaPlano1.setEnabled(false);
        txtCopiaPlano1.setFocusable(false);

        lbCopiaDesenho1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCopiaDesenho1.setText("Número do Desenho:");

        txtCopiaDesenho1.setEditable(false);
        txtCopiaDesenho1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCopiaDesenho1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCopiaDesenho1.setEnabled(false);
        txtCopiaDesenho1.setFocusable(false);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCopiaLinha1)
                            .addComponent(cbCopiaLinha1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCopiaPerfil1)
                            .addComponent(cbCopiaMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(lbCopiaDesc1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtCopiaDesc1)))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCopiaProjeto1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCopiaProjeto1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCopiaPlano1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCopiaPlano1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(lbCopiaDesenho1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtCopiaDesenho1))))
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43)
                .addGap(28, 28, 28)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                        .addComponent(lbCopiaLinha1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCopiaLinha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                        .addComponent(lbCopiaDesc1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCopiaDesc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                        .addComponent(lbCopiaPerfil1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCopiaMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbCopiaProjeto1)
                            .addComponent(lbCopiaPlano1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCopiaProjeto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCopiaPlano1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(lbCopiaDesenho1)
                        .addGap(7, 7, 7)
                        .addComponent(txtCopiaDesenho1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel27.setBackground(new java.awt.Color(146, 249, 158));

        jLabel44.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Defina a Nova Linha");

        lbCopiaLinha3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCopiaLinha3.setText("Célula:");

        cbCopiaLinha3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCopiaLinha3ActionPerformed(evt);
            }
        });

        lbCopiaDesc3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCopiaDesc3.setText("Tipo da Linha");

        txtCopiaDesc3.setEditable(false);
        txtCopiaDesc3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCopiaDesc3.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCopiaDesc3.setEnabled(false);
        txtCopiaDesc3.setFocusable(false);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCopiaLinha3)
                    .addComponent(cbCopiaLinha3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(lbCopiaDesc3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtCopiaDesc3))
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44)
                .addGap(39, 39, 39)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                        .addComponent(lbCopiaLinha3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCopiaLinha3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                        .addComponent(lbCopiaDesc3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCopiaDesc3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton22.setBackground(new java.awt.Color(255, 255, 255));
        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-n¦o-perturbe-filled-50.png"))); // NOI18N
        jButton22.setText("Cancelar");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setBackground(new java.awt.Color(255, 255, 255));
        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-sincronizar-conex¦o-filled-50.png"))); // NOI18N
        jButton23.setText("Trocar");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton23))
                .addContainerGap())
        );

        jTabbedPane7.addTab("Acabamento", jPanel21);

        jPanel23.setBackground(new java.awt.Color(146, 249, 158));

        jLabel32.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Defina a Nova Linha");

        lbCopiaLinha2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCopiaLinha2.setText("Linha:");

        cbCopiaLinha2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCopiaLinha2ActionPerformed(evt);
            }
        });

        lbCopiaDesc2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCopiaDesc2.setText("Tipo da Linha");

        txtCopiaDesc2.setEditable(false);
        txtCopiaDesc2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCopiaDesc2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCopiaDesc2.setEnabled(false);
        txtCopiaDesc2.setFocusable(false);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCopiaLinha2)
                    .addComponent(cbCopiaLinha2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(lbCopiaDesc2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtCopiaDesc2))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addGap(39, 39, 39)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addComponent(lbCopiaLinha2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCopiaLinha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addComponent(lbCopiaDesc2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCopiaDesc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jPanel24.setBackground(new java.awt.Color(255, 112, 112));

        jLabel31.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Escolha a Linha e Material para trocar");

        lbCopiaPerfil.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCopiaPerfil.setText("Material:");

        cbCopiaMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCopiaMaterialActionPerformed(evt);
            }
        });

        lbCopiaDesc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCopiaDesc.setText("Descrição da Peça:");

        txtCopiaDesc.setEditable(false);
        txtCopiaDesc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCopiaDesc.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCopiaDesc.setEnabled(false);
        txtCopiaDesc.setFocusable(false);

        lbCopiaLinha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCopiaLinha.setText("Linha:");

        cbCopiaLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCopiaLinhaActionPerformed(evt);
            }
        });

        lbCopiaProjeto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCopiaProjeto.setText("Projeto:");

        txtCopiaProjeto.setEditable(false);
        txtCopiaProjeto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCopiaProjeto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCopiaProjeto.setEnabled(false);
        txtCopiaProjeto.setFocusable(false);

        lbCopiaPlano.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCopiaPlano.setText("Número do Plano:");

        txtCopiaPlano.setEditable(false);
        txtCopiaPlano.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCopiaPlano.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCopiaPlano.setEnabled(false);
        txtCopiaPlano.setFocusable(false);

        lbCopiaDesenho.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCopiaDesenho.setText("Número do Desenho:");

        txtCopiaDesenho.setEditable(false);
        txtCopiaDesenho.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCopiaDesenho.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCopiaDesenho.setEnabled(false);
        txtCopiaDesenho.setFocusable(false);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCopiaLinha)
                            .addComponent(cbCopiaLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCopiaPerfil)
                            .addComponent(cbCopiaMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(lbCopiaDesc)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtCopiaDesc)))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCopiaProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCopiaProjeto))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCopiaPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCopiaPlano))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(lbCopiaDesenho)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtCopiaDesenho))))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addGap(28, 28, 28)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                        .addComponent(lbCopiaLinha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCopiaLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                        .addComponent(lbCopiaDesc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCopiaDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                        .addComponent(lbCopiaPerfil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCopiaMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbCopiaProjeto)
                            .addComponent(lbCopiaPlano))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCopiaProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCopiaPlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(lbCopiaDesenho)
                        .addGap(7, 7, 7)
                        .addComponent(txtCopiaDesenho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton20.setBackground(new java.awt.Color(255, 255, 255));
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-sincronizar-conex¦o-filled-50.png"))); // NOI18N
        jButton20.setText("Trocar");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setBackground(new java.awt.Color(255, 255, 255));
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-n¦o-perturbe-filled-50.png"))); // NOI18N
        jButton21.setText("Cancelar");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton20))
                .addContainerGap())
        );

        jTabbedPane7.addTab("Extrusão", jPanel22);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane7)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane7)
        );

        jTabbedPane1.addTab("Trocar Material de Linha", jPanel20);

        jTabbedPane6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton18.setBackground(new java.awt.Color(255, 255, 255));
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-n¦o-perturbe-filled-50.png"))); // NOI18N
        jButton18.setText("Cancelar");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        txtDeletaDesc1.setEditable(false);
        txtDeletaDesc1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDeletaDesc1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDeletaDesc1.setEnabled(false);
        txtDeletaDesc1.setFocusable(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Material:");

        txtDeletaProjeto1.setEditable(false);
        txtDeletaProjeto1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDeletaProjeto1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDeletaProjeto1.setEnabled(false);
        txtDeletaProjeto1.setFocusable(false);

        jButton19.setBackground(new java.awt.Color(255, 255, 255));
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-pesquisar-filled-50.png"))); // NOI18N
        jButton19.setText("Visualizar");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("Projeto:");

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("Número do Plano:");

        txtDeletaPlano1.setEditable(false);
        txtDeletaPlano1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDeletaPlano1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDeletaPlano1.setEnabled(false);
        txtDeletaPlano1.setFocusable(false);

        cbDeletaLinha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDeletaLinha1ActionPerformed(evt);
            }
        });

        txtDeletaDesenho1.setEditable(false);
        txtDeletaDesenho1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDeletaDesenho1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDeletaDesenho1.setEnabled(false);
        txtDeletaDesenho1.setFocusable(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Célula:");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("Número do Desenho:");

        cbDeletaMaterial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDeletaMaterial1ActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("Descrição da Peça:");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton19))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbDeletaLinha1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(cbDeletaMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDeletaDesc1)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(txtDeletaProjeto1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDeletaPlano1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addGap(0, 125, Short.MAX_VALUE))
                            .addComponent(txtDeletaDesenho1))))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbDeletaLinha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDeletaMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDeletaDesc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel40)
                                .addComponent(jLabel41)))
                        .addGap(7, 7, 7)
                        .addComponent(txtDeletaProjeto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDeletaPlano1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDeletaDesenho1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(194, 194, 194)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane6.addTab("Acabamento", jPanel18);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Descrição da Peça:");

        txtDeletaDesc.setEditable(false);
        txtDeletaDesc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDeletaDesc.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDeletaDesc.setEnabled(false);
        txtDeletaDesc.setFocusable(false);

        txtDeletaProjeto.setEditable(false);
        txtDeletaProjeto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDeletaProjeto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDeletaProjeto.setEnabled(false);
        txtDeletaProjeto.setFocusable(false);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Projeto:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Número do Plano:");

        txtDeletaPlano.setEditable(false);
        txtDeletaPlano.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDeletaPlano.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDeletaPlano.setEnabled(false);
        txtDeletaPlano.setFocusable(false);

        cbDeletaLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDeletaLinhaActionPerformed(evt);
            }
        });

        txtDeletaDesenho.setEditable(false);
        txtDeletaDesenho.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDeletaDesenho.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDeletaDesenho.setEnabled(false);
        txtDeletaDesenho.setFocusable(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Linha:");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Número do Desenho:");

        cbDeletaMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDeletaMaterialActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(255, 255, 255));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-n¦o-perturbe-filled-50.png"))); // NOI18N
        jButton12.setText("Cancelar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Material:");

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-pesquisar-filled-50.png"))); // NOI18N
        jButton7.setText("Visualizar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbDeletaLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(cbDeletaMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDeletaDesc)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(txtDeletaProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDeletaPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(0, 125, Short.MAX_VALUE))
                            .addComponent(txtDeletaDesenho)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbDeletaLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDeletaMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDeletaDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel21)
                                .addComponent(jLabel36)))
                        .addGap(7, 7, 7)
                        .addComponent(txtDeletaProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDeletaPlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDeletaDesenho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(194, 194, 194)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7))
                .addContainerGap())
        );

        jTabbedPane6.addTab("Extrusão", jPanel19);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane6)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane6)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Deletar Ficha", jPanel5);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        limparDeleta();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (cbDeletaLinha.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbDeletaLinha.requestFocusInWindow();
        } else if (cbDeletaMaterial.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbDeletaMaterial.requestFocusInWindow();
        } else {
            new ViewStatus(cbDeletaMaterial.getSelectedItem().toString(), txtDeletaDesenho.getText(), txtDeletaProjeto.getText(), txtDeletaPlano.getText(), txtDeletaDesc.getText(), "Produção", "DeletaFicha").setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void cbDeletaMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDeletaMaterialActionPerformed
        try {

            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select * from Qry_Material where MATERIAL=? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbDeletaMaterial.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                //
                txtDeletaDesenho.setText(rs.getString("N_DESENHO"));
                txtDeletaPlano.setText(rs.getString("N_PLANO"));
                txtDeletaProjeto.setText(rs.getString("MAT_PROJETO"));
                txtDeletaDesc.setText(rs.getString("DESC_MATERIAL"));

            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_cbDeletaMaterialActionPerformed

    private void cbDeletaLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDeletaLinhaActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select distinct ESP_MATERIAL from Ficha_Controle where ESP_LINHA= ? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbDeletaLinha.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            cbDeletaMaterial.removeAllItems();

            while (rs.next()) {

                cbDeletaMaterial.addItem(rs.getString("ESP_MATERIAL"));

            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbDeletaLinhaActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        limparStatus();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void cbStatusMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStatusMaterialActionPerformed
        try {

            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select * from Qry_Material where MATERIAL=? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbStatusMaterial.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                //
                txtStatusDesenho.setText(rs.getString("N_DESENHO"));
                txtStatusPlano.setText(rs.getString("N_PLANO"));
                txtStatusProjeto.setText(rs.getString("MAT_PROJETO"));
                txtStatusDesc.setText(rs.getString("DESC_MATERIAL"));

            }

        } catch (Exception e) {

        }

        try {

            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select STATUS as status from Ficha_Controle where ESP_MATERIAL=? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbStatusMaterial.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            String status1 = "";
            while (rs.next()) {
                status1 = rs.getString("status");
            }
            if (status1.equals("Protótipo")) {
                JcbStatusPrototipo.setSelected(true);
                JcbStatusLancamento.setSelected(false);
                JcbStatusProducao.setSelected(false);
            }
            if (status1.equals("Pré-Lançamento")) {
                JcbStatusLancamento.setSelected(true);
                JcbStatusPrototipo.setSelected(false);
                JcbStatusProducao.setSelected(false);
            }
            if (status1.equals("Produção")) {
                JcbStatusProducao.setSelected(true);
                JcbStatusPrototipo.setSelected(false);
                JcbStatusLancamento.setSelected(false);
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_cbStatusMaterialActionPerformed

    private void cbStatusLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStatusLinhaActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select distinct ESP_MATERIAL from Ficha_Controle where ESP_LINHA= ? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbStatusLinha.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            cbStatusMaterial.removeAllItems();

            while (rs.next()) {

                cbStatusMaterial.addItem(rs.getString("ESP_MATERIAL"));

            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbStatusLinhaActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (cbStatusLinha.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo Obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbStatusLinha.requestFocusInWindow();
        } else if (cbStatusMaterial.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo Obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbStatusMaterial.requestFocusInWindow();
        } else {
            check();
            new ViewStatus(cbStatusMaterial.getSelectedItem().toString(), txtStatusDesenho.getText(), txtStatusProjeto.getText(), txtStatusPlano.getText(), txtStatusDesc.getText(), status, "StatusFicha").setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (cbRodPlanoLinha.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbRodPlanoLinha.requestFocusInWindow();
        } else {
            new ViewRodapePlano(cbRodPlanoLinha.getSelectedItem().toString()).setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (cbRodFichaLinha.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbRodFichaLinha.requestFocusInWindow();
        } else if (cbRodFichaMaterial.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbRodFichaMaterial.requestFocusInWindow();
        } else {
            new ViewRodape(cbRodFichaMaterial.getSelectedItem().toString()).setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void cbRodFichaLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRodFichaLinhaActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select distinct ESP_MATERIAL from Ficha_Controle where ESP_LINHA= ? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbRodFichaLinha.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            cbRodFichaMaterial.removeAllItems();

            while (rs.next()) {

                cbRodFichaMaterial.addItem(rs.getString("ESP_MATERIAL"));

            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbRodFichaLinhaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int linhasselecionada = tbAltera.getSelectedRow();

        if (linhasselecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item na tabela antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            recuperarFichaControle();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        limparAltera();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (cbAlteraLinha.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "Informação", JOptionPane.WARNING_MESSAGE);
            cbAlteraLinha.requestFocusInWindow();
        } else if (txtAlteraSolicitante.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            txtAlteraSolicitante.requestFocus();
        } else {
            Copiadados();
            new ViewFichaControleQualidade(cbAlteraMaterial.getSelectedItem().toString(), cbAlteraLinha.getSelectedItem().toString(), "Protótipo", txtAlteraSolicitante.getText(), "Alteração").setVisible(true);
            dispose();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbAlteraMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlteraMaterialActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select * from Qry_Material where MATERIAL=? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbAlteraMaterial.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                txtAlteraDesenho.setText(rs.getString("N_DESENHO"));
                txtAlteraPlano.setText(rs.getString("N_PLANO"));
                txtAlteraProjeto.setText(rs.getString("MAT_PROJETO"));
                txtAlteraDesc.setText(rs.getString("DESC_MATERIAL"));
            }
        } catch (Exception e) {

        }
        try {
            
            Connection con1 = new ConexaoSql().getCon();
            String query = "Select MAX(ROD_REV) as value,MAX(ROD_EMITENTE)as value2,MAX(ROD_RESPONSAVEL)as value3 from Cad_Rodape where  ROD_MATERIAL='" + cbAlteraMaterial.getSelectedItem() + "' ";
            PreparedStatement st1 = con1.prepareStatement(query);
            ResultSet rs1 = st1.executeQuery();
            while (rs1.next()) {
                txtAlteraSolicitante.setText(rs1.getString("value2"));
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_cbAlteraMaterialActionPerformed

    private void cbAlteraLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlteraLinhaActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select distinct ESP_MATERIAL from Ficha_Controle where ESP_LINHA= ? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbAlteraLinha.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            cbAlteraMaterial.removeAllItems();
            while (rs.next()) {
                cbAlteraMaterial.addItem(rs.getString("ESP_MATERIAL"));
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbAlteraLinhaActionPerformed

    private void cbCopiaLinha2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCopiaLinha2ActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select * from Cad_Linha where LINHA=? and SETOR = 'Extrusão'";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbCopiaLinha2.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                txtCopiaDesc2.setText(rs.getString("TIPO_LINHA"));
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_cbCopiaLinha2ActionPerformed

    private void cbCopiaMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCopiaMaterialActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select * from Qry_Material where MATERIAL=? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbCopiaMaterial.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                txtCopiaDesenho.setText(rs.getString("N_DESENHO"));
                txtCopiaPlano.setText(rs.getString("N_PLANO"));
                txtCopiaProjeto.setText(rs.getString("MAT_PROJETO"));
                txtCopiaDesc.setText(rs.getString("DESC_MATERIAL"));
            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_cbCopiaMaterialActionPerformed

    private void cbCopiaLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCopiaLinhaActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select distinct ESP_MATERIAL from Qry_FichaControle where ESP_LINHA= ? and SETOR = 'Extrusão' order by ESP_MATERIAL asc ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbCopiaLinha.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            cbCopiaMaterial.removeAllItems();
            while (rs.next()) {
                cbCopiaMaterial.addItem(rs.getString("ESP_MATERIAL"));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbCopiaLinhaActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if (cbRodPlanoLinha1.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbRodPlanoLinha1.requestFocusInWindow();
        } else {
            new ViewRodapePlano(cbRodPlanoLinha1.getSelectedItem().toString()).setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if (cbRodFichaLinha1.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbRodFichaLinha1.requestFocusInWindow();
        } else if (cbRodFichaMaterial1.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbRodFichaMaterial1.requestFocusInWindow();
        } else {
            new ViewRodape(cbRodFichaMaterial1.getSelectedItem().toString()).setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void cbRodFichaLinha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRodFichaLinha1ActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select distinct ESP_MATERIAL from Ficha_Controle where ESP_LINHA= ? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbRodFichaLinha1.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            cbRodFichaMaterial1.removeAllItems();
            while (rs.next()) {
                cbRodFichaMaterial1.addItem(rs.getString("ESP_MATERIAL"));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbRodFichaLinha1ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        limparAlteraAc();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int linhasselecionada = tbAltera1.getSelectedRow();
        if (linhasselecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item na tabela antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            recuperarFichaControleAc();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (cbAlteraLinha1.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "Informação", JOptionPane.WARNING_MESSAGE);
            cbAlteraLinha1.requestFocusInWindow();
        } else if (txtAlteraSolicitante1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            txtAlteraSolicitante1.requestFocus();
        } else {
            CopiadadosAc();
            new ViewFichaControleQualidadeAc(cbAlteraMaterial1.getSelectedItem().toString(), cbAlteraLinha1.getSelectedItem().toString(), "Protótipo", txtAlteraSolicitante1.getText(), "Alteração").setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cbAlteraLinha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlteraLinha1ActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select distinct ESP_MATERIAL from Ficha_Controle where ESP_LINHA= ? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbAlteraLinha1.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            cbAlteraMaterial1.removeAllItems();
            while (rs.next()) {
                cbAlteraMaterial1.addItem(rs.getString("ESP_MATERIAL"));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbAlteraLinha1ActionPerformed

    private void cbAlteraMaterial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlteraMaterial1ActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select * from Qry_Material where MATERIAL=? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbAlteraMaterial1.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                txtAlteraDesenho1.setText(rs.getString("N_DESENHO"));
                txtAlteraPlano1.setText(rs.getString("N_PLANO"));
                txtAlteraProjeto1.setText(rs.getString("MAT_PROJETO"));
                txtAlteraDesc1.setText(rs.getString("DESC_MATERIAL"));
            }
        } catch (Exception e) {

        }
        try {
            
            Connection con1 = new ConexaoSql().getCon();
            String query = "Select MAX(ROD_REV) as value,MAX(ROD_EMITENTE)as value2,MAX(ROD_RESPONSAVEL)as value3 from Cad_Rodape where  ROD_MATERIAL='" + cbAlteraMaterial.getSelectedItem() + "' ";
            PreparedStatement st1 = con1.prepareStatement(query);
            ResultSet rs1 = st1.executeQuery();
            while (rs1.next()) {
                txtAlteraSolicitante1.setText(rs1.getString("value2"));

            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_cbAlteraMaterial1ActionPerformed

    private void cbStatusMaterial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStatusMaterial1ActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select * from Qry_Material where MATERIAL=? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbStatusMaterial1.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                txtStatusDesenho1.setText(rs.getString("N_DESENHO"));
                txtStatusPlano1.setText(rs.getString("N_PLANO"));
                txtStatusProjeto1.setText(rs.getString("MAT_PROJETO"));
                txtStatusDesc1.setText(rs.getString("DESC_MATERIAL"));
            }

        } catch (Exception e) {

        }
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select STATUS as status from Ficha_Controle where ESP_MATERIAL=? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbStatusMaterial1.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            String status1 = "";
            while (rs.next()) {
                status1 = rs.getString("status");
            }
            if (status1.equals("Protótipo")) {
                JcbStatusPrototipo1.setSelected(true);
                JcbStatusLancamento1.setSelected(false);
                JcbStatusProducao1.setSelected(false);
            } else if (status1.equals("Pré-Lançamento")) {
                JcbStatusLancamento1.setSelected(true);
                JcbStatusPrototipo1.setSelected(false);
                JcbStatusProducao1.setSelected(false);
            } else if (status1.equals("Produção")) {
                JcbStatusProducao1.setSelected(true);
                JcbStatusPrototipo1.setSelected(false);
                JcbStatusLancamento1.setSelected(false);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_cbStatusMaterial1ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        limparStatusAc();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        if (cbStatusLinha1.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo Obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbStatusLinha1.requestFocusInWindow();
        } else if (cbStatusMaterial1.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo Obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbStatusMaterial1.requestFocusInWindow();
        } else {
            check();
            new ViewStatus(cbStatusMaterial1.getSelectedItem().toString(), txtStatusDesenho1.getText(), txtStatusProjeto1.getText(), txtStatusPlano1.getText(), txtStatusDesc1.getText(), status, "StatusFicha").setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void cbStatusLinha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStatusLinha1ActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select distinct ESP_MATERIAL from Ficha_Controle where ESP_LINHA= ? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbStatusLinha1.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            cbStatusMaterial1.removeAllItems();
            while (rs.next()) {
                cbStatusMaterial1.addItem(rs.getString("ESP_MATERIAL"));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbStatusLinha1ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        limparDeletaAc();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        if (cbDeletaLinha1.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbDeletaLinha1.requestFocusInWindow();
        } else if (cbDeletaMaterial1.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbDeletaMaterial1.requestFocusInWindow();
        } else {
            new ViewStatus(cbDeletaMaterial1.getSelectedItem().toString(), txtDeletaDesenho1.getText(), txtDeletaProjeto1.getText(), txtDeletaPlano1.getText(), txtDeletaDesc1.getText(), "Produção", "DeletaFicha").setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void cbDeletaLinha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDeletaLinha1ActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select distinct ESP_MATERIAL from Ficha_Controle where ESP_LINHA= ? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbDeletaLinha1.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            cbDeletaMaterial1.removeAllItems();
            while (rs.next()) {
                cbDeletaMaterial1.addItem(rs.getString("ESP_MATERIAL"));
            }
        } catch (Exception e) {
        }
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select * from Qry_Material where MATERIAL=? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbDeletaMaterial1.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                txtDeletaDesenho1.setText(rs.getString("N_DESENHO"));
                txtDeletaPlano1.setText(rs.getString("N_PLANO"));
                txtDeletaProjeto1.setText(rs.getString("MAT_PROJETO"));
                txtDeletaDesc1.setText(rs.getString("DESC_MATERIAL"));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbDeletaLinha1ActionPerformed

    private void cbDeletaMaterial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDeletaMaterial1ActionPerformed

    }//GEN-LAST:event_cbDeletaMaterial1ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        limparTroca();
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "Você realmente deseja efetuar a troca?", "Trocar", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            UpdatPerfil();
            TrocaLinnhaFicha();
            listarLinhaProducao();
            listarPerfilProducao();
            listarLinha();
            limparTroca();
            JOptionPane.showMessageDialog(null, "Troca realizada com sucesso!");
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void cbCopiaMaterial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCopiaMaterial1ActionPerformed
        try {

            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select * from Qry_Material where MATERIAL=? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbCopiaMaterial1.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                txtCopiaDesenho1.setText(rs.getString("N_DESENHO"));
                txtCopiaPlano1.setText(rs.getString("N_PLANO"));
                txtCopiaProjeto1.setText(rs.getString("MAT_PROJETO"));
                txtCopiaDesc1.setText(rs.getString("DESC_MATERIAL"));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbCopiaMaterial1ActionPerformed

    private void cbCopiaLinha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCopiaLinha1ActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select distinct ESP_MATERIAL from Qry_FichaControle where ESP_LINHA= ? and SETOR = 'Acabamento' order by ESP_MATERIAL asc ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbCopiaLinha1.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            cbCopiaMaterial1.removeAllItems();
            while (rs.next()) {
                cbCopiaMaterial1.addItem(rs.getString("ESP_MATERIAL"));
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbCopiaLinha1ActionPerformed

    private void cbCopiaLinha3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCopiaLinha3ActionPerformed
        try {

            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select * from Cad_Linha where LINHA=? and SETOR = 'Acabamento'";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbCopiaLinha3.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                txtCopiaDesc3.setText(rs.getString("TIPO_LINHA"));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbCopiaLinha3ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        limparTrocaAc();
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "Você realmente deseja efetuar a troca?", "Trocar", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            UpdatPerfilAc();
            TrocaLinnhaFichaAc();
            listarLinhaProducaoAc();
            listarPerfilProducaoAc();
            listarLinhaAc();
            limparTrocaAc();
            JOptionPane.showMessageDialog(null, "Troca realizada com sucesso!");
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        listarLinhaProducao();
        listarLinhaProducaoAc();
        listarLinha();
        listarLinhaAc();
        limparGeral();
    }//GEN-LAST:event_formWindowOpened

    private void check() {
        if (JcbStatusPrototipo.isSelected()) {
            status = "Protótipo";
        }
        if (JcbStatusLancamento.isSelected()) {
            status = "Pré-Lançamento";
        }
        if (JcbStatusProducao.isSelected()) {
            status = "Produção";
        }
    }

    private boolean recuperarFichaControle() {
        int linha = this.tbAltera.getSelectedRow();
        Integer perfil = (Integer) tbAltera.getValueAt(linha, 2);
        try {
            modelFichaControleQualidade = controllerFichaControleQualidade.getFichaController(perfil);
            this.cbAlteraLinha.setSelectedItem(modelFichaControleQualidade.getEsp_linha());
            this.cbAlteraMaterial.setSelectedItem(String.valueOf(modelFichaControleQualidade.getEsp_material()));
            this.txtAlteraSolicitante.setText(modelFichaControleQualidade.getResponsavel_alter());
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código inválido ou nenhum registro selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private boolean recuperarFichaControleAc() {
        int linha = this.tbAltera1.getSelectedRow();
        Integer perfil = (Integer) tbAltera1.getValueAt(linha, 2);
        try {
            modelFichaControleQualidade = controllerFichaControleQualidade.getFichaController(perfil);
            this.cbAlteraLinha1.setSelectedItem(modelFichaControleQualidade.getEsp_linha());
            this.cbAlteraMaterial1.setSelectedItem(String.valueOf(modelFichaControleQualidade.getEsp_material()));
            this.txtAlteraSolicitante1.setText(modelFichaControleQualidade.getResponsavel_alter());
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código inválido ou nenhum registro selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private void carregaTabela() {
        listaModelFichaControleQualidade = controllerFichaControleQualidade.getListaFichaemAbertoAlterController();
        DefaultTableModel modelo = (DefaultTableModel) tbAltera.getModel();
        modelo.setNumRows(0);
        int cont = listaModelFichaControleQualidade.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelFichaControleQualidade.get(i).getData_alter(),
                listaModelFichaControleQualidade.get(i).getEsp_linha(),
                listaModelFichaControleQualidade.get(i).getEsp_material(),
                listaModelFichaControleQualidade.get(i).getResponsavel_alter(),});
        }
    }

    private void carregaTabelaAc() {
        listaModelFichaControleQualidade = controllerFichaControleQualidadeAc.getListaFichaemAbertoAlterAcController();
        DefaultTableModel modelo = (DefaultTableModel) tbAltera1.getModel();
        modelo.setNumRows(0);
        int cont = listaModelFichaControleQualidade.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelFichaControleQualidade.get(i).getData_alter(),
                listaModelFichaControleQualidade.get(i).getEsp_linha(),
                listaModelFichaControleQualidade.get(i).getEsp_material(),
                listaModelFichaControleQualidade.get(i).getResponsavel_alter(),});

        }

    }

    private void listarLinha() {
        listaModelLinha = controllerLinha.getListaLinhaController();
        cbCopiaLinha2.removeAllItems();
        for (int i = 0; i < listaModelLinha.size(); i++) {
            cbCopiaLinha2.addItem(listaModelLinha.get(i).getLinha());

        }
    }

    private void listarLinhaAc() {
        listaModelLinha = controllerLinhaAc.getListaLinhaAcController();
        cbCopiaLinha3.removeAllItems();

        for (int i = 0; i < listaModelLinha.size(); i++) {
            cbCopiaLinha3.addItem(listaModelLinha.get(i).getLinha());

        }
    }

    private void listarLinhaProducao() {
        listaModelProducao = controllerProducao.getListaLinhaController();
        cbAlteraLinha.removeAllItems();
        cbRodFichaLinha.removeAllItems();
        cbDeletaLinha.removeAllItems();
        cbStatusLinha.removeAllItems();
        cbRodPlanoLinha.removeAllItems();
        cbCopiaLinha.removeAllItems();
        for (int i = 0; i < listaModelProducao.size(); i++) {
            cbAlteraLinha.addItem(listaModelProducao.get(i).getEsp_linha());
            cbRodFichaLinha.addItem(listaModelProducao.get(i).getEsp_linha());
            cbDeletaLinha.addItem(listaModelProducao.get(i).getEsp_linha());
            cbStatusLinha.addItem(listaModelProducao.get(i).getEsp_linha());
            cbRodPlanoLinha.addItem(listaModelProducao.get(i).getEsp_linha());
            cbCopiaLinha.addItem(listaModelProducao.get(i).getEsp_linha());

        }
    }

    private void listarLinhaProducaoAc() {
        listaModelProducao = controllerProducaoAc.getListaLinhaAcController();
        cbRodPlanoLinha1.removeAllItems();
        cbRodFichaLinha1.removeAllItems();
        cbAlteraLinha1.removeAllItems();
        cbStatusLinha1.removeAllItems();
        cbDeletaLinha1.removeAllItems();
        cbCopiaLinha1.removeAllItems();
        for (int i = 0; i < listaModelProducao.size(); i++) {
            cbRodPlanoLinha1.addItem(listaModelProducao.get(i).getEsp_linha());
            cbRodFichaLinha1.addItem(listaModelProducao.get(i).getEsp_linha());
            cbAlteraLinha1.addItem(listaModelProducao.get(i).getEsp_linha());
            cbStatusLinha1.addItem(listaModelProducao.get(i).getEsp_linha());
            cbDeletaLinha1.addItem(listaModelProducao.get(i).getEsp_linha());
            cbCopiaLinha1.addItem(listaModelProducao.get(i).getEsp_linha());

        }
    }

    private void listarPerfilProducao() {
        listaModelProducao = controllerProducao.getListaPerfilController();
        cbAlteraMaterial.removeAllItems();
        cbRodFichaMaterial.removeAllItems();
        cbDeletaMaterial.removeAllItems();
        cbStatusMaterial.removeAllItems();
        cbCopiaMaterial.removeAllItems();
        for (int i = 0; i < listaModelProducao.size(); i++) {
            cbAlteraMaterial.addItem(String.valueOf(listaModelProducao.get(i).getEsp_material()));
            cbRodFichaMaterial.addItem(String.valueOf(listaModelProducao.get(i).getEsp_material()));
            cbDeletaMaterial.addItem(String.valueOf(listaModelProducao.get(i).getEsp_material()));
            cbStatusMaterial.addItem(String.valueOf(listaModelProducao.get(i).getEsp_material()));
            cbCopiaMaterial.addItem(String.valueOf(listaModelProducao.get(i).getEsp_material()));
        }
    }

    private void listarPerfilProducaoAc() {
        listaModelProducao = controllerProducaoAc.getListaPerfilAcController();
        cbRodFichaMaterial1.removeAllItems();
        cbAlteraMaterial1.removeAllItems();
        cbStatusMaterial1.removeAllItems();
        cbDeletaMaterial1.removeAllItems();
        cbCopiaMaterial1.removeAllItems();
        for (int i = 0; i < listaModelProducao.size(); i++) {
            cbRodFichaMaterial1.addItem(String.valueOf(listaModelProducao.get(i).getEsp_material()));
            cbAlteraMaterial1.addItem(String.valueOf(listaModelProducao.get(i).getEsp_material()));
            cbStatusMaterial1.addItem(String.valueOf(listaModelProducao.get(i).getEsp_material()));
            cbDeletaMaterial1.addItem(String.valueOf(listaModelProducao.get(i).getEsp_material()));
            cbCopiaMaterial1.addItem(String.valueOf(listaModelProducao.get(i).getEsp_material()));
        }
    }

    private void limparAltera() {
        cbAlteraLinha.setSelectedIndex(-1);
        cbAlteraMaterial.setSelectedIndex(-1);
        txtAlteraDesc.setText("");
        txtAlteraProjeto.setText("");
        txtAlteraPlano.setText("");
        txtAlteraDesenho.setText("");
        txtAlteraSolicitante.setText("");
    }

    private void limparAlteraAc() {
        cbAlteraLinha1.setSelectedIndex(-1);
        cbAlteraMaterial1.setSelectedIndex(-1);
        txtAlteraDesc1.setText("");
        txtAlteraProjeto1.setText("");
        txtAlteraPlano1.setText("");
        txtAlteraDesenho1.setText("");
        txtAlteraSolicitante1.setText("");
    }

    private void limparStatus() {
        cbStatusLinha.setSelectedIndex(-1);
        cbStatusMaterial.setSelectedIndex(-1);
        txtStatusDesc.setText("");
        txtStatusProjeto.setText("");
        txtStatusPlano.setText("");
        txtStatusDesenho.setText("");
    }

    private void limparStatusAc() {
        cbStatusLinha1.setSelectedIndex(-1);
        cbStatusMaterial1.setSelectedIndex(-1);
        txtStatusDesc1.setText("");
        txtStatusProjeto1.setText("");
        txtStatusPlano1.setText("");
        txtStatusDesenho1.setText("");
    }

    private void limparDeleta() {
        cbDeletaLinha.setSelectedIndex(-1);
        cbDeletaMaterial.setSelectedIndex(-1);
        txtDeletaDesc.setText("");
        txtDeletaProjeto.setText("");
        txtDeletaPlano.setText("");
        txtDeletaDesenho.setText("");
    }

    private void limparDeletaAc() {
        cbDeletaLinha1.setSelectedIndex(-1);
        cbDeletaMaterial1.setSelectedIndex(-1);
        txtDeletaDesc1.setText("");
        txtDeletaProjeto1.setText("");
        txtDeletaPlano1.setText("");
        txtDeletaDesenho1.setText("");
    }

    private void limparTroca() {
        cbCopiaMaterial.setSelectedIndex(-1);
        cbCopiaLinha.setSelectedIndex(-1);
        txtCopiaDesc.setText("");
        txtCopiaProjeto.setText("");
        txtCopiaPlano.setText("");
        txtCopiaDesenho.setText("");
        cbCopiaLinha2.setSelectedIndex(-1);
        txtCopiaDesc2.setText("");
    }

    private void limparTrocaAc() {
        cbCopiaMaterial1.setSelectedIndex(-1);
        cbCopiaLinha1.setSelectedIndex(-1);
        txtCopiaDesc1.setText("");
        txtCopiaProjeto1.setText("");
        txtCopiaPlano1.setText("");
        txtCopiaDesenho1.setText("");
        cbCopiaLinha3.setSelectedIndex(-1);
        txtCopiaDesc3.setText("");
    }

    private void limparGeral() {
        cbDeletaLinha.setSelectedIndex(-1);
        cbDeletaMaterial.setSelectedIndex(-1);
        txtDeletaDesc.setText("");
        txtDeletaProjeto.setText("");
        txtDeletaPlano.setText("");
        txtDeletaDesenho.setText("");
        cbStatusLinha.setSelectedIndex(-1);
        cbStatusMaterial.setSelectedIndex(-1);
        txtStatusDesc.setText("");
        txtStatusProjeto.setText("");
        txtStatusPlano.setText("");
        txtStatusDesenho.setText("");
        cbAlteraLinha.setSelectedIndex(-1);
        cbAlteraMaterial.setSelectedIndex(-1);
        txtAlteraDesc.setText("");
        txtAlteraProjeto.setText("");
        txtAlteraPlano.setText("");
        txtAlteraDesenho.setText("");
        txtAlteraSolicitante.setText("");
        cbRodFichaLinha.setSelectedIndex(-1);
        cbRodFichaMaterial.setSelectedIndex(-1);
        cbRodPlanoLinha.setSelectedIndex(-1);
        cbDeletaLinha1.setSelectedIndex(-1);
        cbDeletaMaterial1.setSelectedIndex(-1);
        txtDeletaDesc1.setText("");
        txtDeletaProjeto1.setText("");
        txtDeletaPlano1.setText("");
        txtDeletaDesenho1.setText("");
        cbStatusLinha1.setSelectedIndex(-1);
        cbStatusMaterial1.setSelectedIndex(-1);
        txtStatusDesc1.setText("");
        txtStatusProjeto1.setText("");
        txtStatusPlano1.setText("");
        txtStatusDesenho1.setText("");
        cbAlteraLinha1.setSelectedIndex(-1);
        cbAlteraMaterial1.setSelectedIndex(-1);
        txtAlteraDesc1.setText("");
        txtAlteraProjeto1.setText("");
        txtAlteraPlano1.setText("");
        txtAlteraDesenho1.setText("");
        txtAlteraSolicitante1.setText("");
        cbRodFichaLinha1.setSelectedIndex(-1);
        cbRodFichaMaterial1.setSelectedIndex(-1);
        cbRodPlanoLinha1.setSelectedIndex(-1);
        cbCopiaMaterial.setSelectedIndex(-1);
        cbCopiaLinha.setSelectedIndex(-1);
        txtCopiaDesc.setText("");
        txtCopiaProjeto.setText("");
        txtCopiaPlano.setText("");
        txtCopiaDesenho.setText("");
        cbCopiaLinha2.setSelectedIndex(-1);
        txtCopiaDesc2.setText("");
        cbCopiaMaterial1.setSelectedIndex(-1);
        cbCopiaLinha1.setSelectedIndex(-1);
        txtCopiaDesc1.setText("");
        txtCopiaProjeto1.setText("");
        txtCopiaPlano1.setText("");
        txtCopiaDesenho1.setText("");
        cbCopiaLinha3.setSelectedIndex(-1);
        txtCopiaDesc3.setText("");
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
            java.util.logging.Logger.getLogger(ViewQualidade.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewQualidade.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewQualidade.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewQualidade.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewQualidade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox JcbStatusLancamento;
    private javax.swing.JCheckBox JcbStatusLancamento1;
    private javax.swing.JCheckBox JcbStatusProducao;
    private javax.swing.JCheckBox JcbStatusProducao1;
    private javax.swing.JCheckBox JcbStatusPrototipo;
    private javax.swing.JCheckBox JcbStatusPrototipo1;
    private javax.swing.JComboBox<String> cbAlteraLinha;
    private javax.swing.JComboBox<String> cbAlteraLinha1;
    private javax.swing.JComboBox<String> cbAlteraMaterial;
    private javax.swing.JComboBox<String> cbAlteraMaterial1;
    private javax.swing.JComboBox<String> cbAlteraSetor;
    private javax.swing.JComboBox<String> cbAlteraSetor1;
    private javax.swing.JComboBox<String> cbCopiaLinha;
    private javax.swing.JComboBox<String> cbCopiaLinha1;
    private javax.swing.JComboBox<String> cbCopiaLinha2;
    private javax.swing.JComboBox<String> cbCopiaLinha3;
    private javax.swing.JComboBox<String> cbCopiaMaterial;
    private javax.swing.JComboBox<String> cbCopiaMaterial1;
    private javax.swing.JComboBox<String> cbDeletaLinha;
    private javax.swing.JComboBox<String> cbDeletaLinha1;
    private javax.swing.JComboBox<String> cbDeletaMaterial;
    private javax.swing.JComboBox<String> cbDeletaMaterial1;
    private javax.swing.JComboBox<String> cbRodFichaLinha;
    private javax.swing.JComboBox<String> cbRodFichaLinha1;
    private javax.swing.JComboBox<String> cbRodFichaMaterial;
    private javax.swing.JComboBox<String> cbRodFichaMaterial1;
    private javax.swing.JComboBox<String> cbRodPlanoLinha;
    private javax.swing.JComboBox<String> cbRodPlanoLinha1;
    private javax.swing.JComboBox<String> cbStatusLinha;
    private javax.swing.JComboBox<String> cbStatusLinha1;
    private javax.swing.JComboBox<String> cbStatusMaterial;
    private javax.swing.JComboBox<String> cbStatusMaterial1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JLabel lbAlteraDesc;
    private javax.swing.JLabel lbAlteraDesc1;
    private javax.swing.JLabel lbAlteraDesenho;
    private javax.swing.JLabel lbAlteraDesenho1;
    private javax.swing.JLabel lbAlteraLinha;
    private javax.swing.JLabel lbAlteraLinha1;
    private javax.swing.JLabel lbAlteraMaterial;
    private javax.swing.JLabel lbAlteraMaterial1;
    private javax.swing.JLabel lbAlteraPlano;
    private javax.swing.JLabel lbAlteraPlano1;
    private javax.swing.JLabel lbAlteraProjeto;
    private javax.swing.JLabel lbAlteraProjeto1;
    private javax.swing.JLabel lbAlteraSetor;
    private javax.swing.JLabel lbAlteraSetor1;
    private javax.swing.JLabel lbAlteraSolicitante;
    private javax.swing.JLabel lbAlteraSolicitante1;
    private javax.swing.JLabel lbCopiaDesc;
    private javax.swing.JLabel lbCopiaDesc1;
    private javax.swing.JLabel lbCopiaDesc2;
    private javax.swing.JLabel lbCopiaDesc3;
    private javax.swing.JLabel lbCopiaDesenho;
    private javax.swing.JLabel lbCopiaDesenho1;
    private javax.swing.JLabel lbCopiaLinha;
    private javax.swing.JLabel lbCopiaLinha1;
    private javax.swing.JLabel lbCopiaLinha2;
    private javax.swing.JLabel lbCopiaLinha3;
    private javax.swing.JLabel lbCopiaPerfil;
    private javax.swing.JLabel lbCopiaPerfil1;
    private javax.swing.JLabel lbCopiaPlano;
    private javax.swing.JLabel lbCopiaPlano1;
    private javax.swing.JLabel lbCopiaProjeto;
    private javax.swing.JLabel lbCopiaProjeto1;
    private javax.swing.JTable tbAltera;
    private javax.swing.JTable tbAltera1;
    private javax.swing.JTextField txtAlteraDesc;
    private javax.swing.JTextField txtAlteraDesc1;
    private javax.swing.JTextField txtAlteraDesenho;
    private javax.swing.JTextField txtAlteraDesenho1;
    private javax.swing.JTextField txtAlteraPlano;
    private javax.swing.JTextField txtAlteraPlano1;
    private javax.swing.JTextField txtAlteraProjeto;
    private javax.swing.JTextField txtAlteraProjeto1;
    private javax.swing.JTextField txtAlteraSolicitante;
    private javax.swing.JTextField txtAlteraSolicitante1;
    private javax.swing.JTextField txtCopiaDesc;
    private javax.swing.JTextField txtCopiaDesc1;
    private javax.swing.JTextField txtCopiaDesc2;
    private javax.swing.JTextField txtCopiaDesc3;
    private javax.swing.JTextField txtCopiaDesenho;
    private javax.swing.JTextField txtCopiaDesenho1;
    private javax.swing.JTextField txtCopiaPlano;
    private javax.swing.JTextField txtCopiaPlano1;
    private javax.swing.JTextField txtCopiaProjeto;
    private javax.swing.JTextField txtCopiaProjeto1;
    private javax.swing.JTextField txtDeletaDesc;
    private javax.swing.JTextField txtDeletaDesc1;
    private javax.swing.JTextField txtDeletaDesenho;
    private javax.swing.JTextField txtDeletaDesenho1;
    private javax.swing.JTextField txtDeletaPlano;
    private javax.swing.JTextField txtDeletaPlano1;
    private javax.swing.JTextField txtDeletaProjeto;
    private javax.swing.JTextField txtDeletaProjeto1;
    private javax.swing.JTextField txtStatusDesc;
    private javax.swing.JTextField txtStatusDesc1;
    private javax.swing.JTextField txtStatusDesenho;
    private javax.swing.JTextField txtStatusDesenho1;
    private javax.swing.JTextField txtStatusPlano;
    private javax.swing.JTextField txtStatusPlano1;
    private javax.swing.JTextField txtStatusProjeto;
    private javax.swing.JTextField txtStatusProjeto1;
    // End of variables declaration//GEN-END:variables
}

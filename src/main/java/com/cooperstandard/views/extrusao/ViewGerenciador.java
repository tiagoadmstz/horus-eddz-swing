package com.cooperstandard.views.extrusao;

import com.cooperstandard.views.qualidade.ViewVersao;
import com.cooperstandard.controller.extrusao.ControllerFichaControle;
import com.cooperstandard.controller.extrusao.ControllerHistorico;
import com.cooperstandard.controller.extrusao.ControllerLinha;
import com.cooperstandard.controller.extrusao.ControllerMaterial;
import com.cooperstandard.controller.extrusao.ControllerProducao;
import com.cooperstandard.model.ModelFichaControle;
import com.cooperstandard.model.ModelHistorico;
import com.cooperstandard.model.ModelLinha;
import com.cooperstandard.model.ModelMaterial;
import com.cooperstandard.model.ModelProducao;
import com.cooperstandard.util.ButtonColumnCPK;
import com.cooperstandard.util.EstiloTablaRenderer;
import com.cooperstandard.util.HeaderRenderer;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
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
public class ViewGerenciador extends javax.swing.JFrame {

    ModelHistorico modelHistorico = new ModelHistorico();
    ControllerHistorico controllerHistorico = new ControllerHistorico();
    ArrayList<ModelHistorico> listaModelHistorico = new ArrayList<ModelHistorico>();
    ControllerLinha controllerLinha = new ControllerLinha();
    ArrayList<ModelLinha> listaModelLinha = new ArrayList<ModelLinha>();
    ControllerMaterial controllerMaterial = new ControllerMaterial();
    ArrayList<ModelMaterial> listaModelMaterial = new ArrayList<ModelMaterial>();
    ControllerProducao controllerProducao = new ControllerProducao();
    ArrayList<ModelProducao> listaModelProducao = new ArrayList<ModelProducao>();
    ModelFichaControle modelFichaControle = new ModelFichaControle();
    ControllerFichaControle controllerFichaControle = new ControllerFichaControle();
    ArrayList<ModelFichaControle> listaModelFichaControle = new ArrayList<ModelFichaControle>();
    String status = "Protótipo";

    public ViewGerenciador() {
        initComponents();
        tbAltera.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbAltera));
        tbAltera.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
        tbAltera.setDefaultRenderer(String.class, new EstiloTablaRenderer());
        tbAltera.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        tbVersao.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbVersao));
        tbVersao.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
        tbVersao.setDefaultRenderer(String.class, new EstiloTablaRenderer());
        tbVersao.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        tbNova.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbNova));
        tbNova.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
        tbNova.setDefaultRenderer(String.class, new EstiloTablaRenderer());
        tbNova.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        tbCopia.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbCopia));
        tbCopia.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
        tbCopia.setDefaultRenderer(String.class, new EstiloTablaRenderer());
        tbCopia.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        carregaTabela();
        carregaTabela3();
        ButtonGroup bG = new ButtonGroup();
        bG.add(jcPrototipo);
        bG.add(jcProducao);
        bG.add(jcPreLancamento);
        ButtonColumnCPK buttonColumn = new ButtonColumnCPK(tbNova, 5);
        ButtonColumnCPK buttonColumn1 = new ButtonColumnCPK(tbAltera, 4);
        ButtonColumnCPK buttonColumn2 = new ButtonColumnCPK(tbCopia, 4);
    }

    //copia dados de uma tabela para outra (Painel Alter)
    public void Copiadados() {
        try {
            java.util.Date currentDate = GregorianCalendar.getInstance().getTime();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = df.format(currentDate);
            String values = dateString;
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "INSERT INTO Cad_Espec_Teste (ORDEM ,ESP_LINHA ,ESP_MATERIAL ,ESP_TESTE ,ESP_EQUIPAMENTO ,MINIMO ,MAXIMO ,UNID_MEDIDA ,TEXTO ,"
                    + "REFERENCIA ,FREQUENCIA ,UNID_FREQUENCIA ,PRODUTO ,ORIGEM ,TIPO_ESPEC ,ESPEC_COMPLETO ,FREQ_COMPLETO ,LAB ,COMPLEMENTO ,ESP_COMPOSTO,STATUS,PENDENCIA_ALTER, RESPONSAVEL_ALTER,DATA_ALTER ) SELECT ORDEM ,ESP_LINHA ,ESP_MATERIAL ,ESP_TESTE ,ESP_EQUIPAMENTO ,MINIMO ,MAXIMO ,UNID_MEDIDA ,TEXTO ,REFERENCIA ,FREQUENCIA ,UNID_FREQUENCIA ,PRODUTO ,ORIGEM ,TIPO_ESPEC ,ESPEC_COMPLETO ,"
                    + "FREQ_COMPLETO ,LAB ,COMPLEMENTO ,ESP_COMPOSTO,STATUS,'Alteração' as PENDENCIA,'" + txtAlteraSolicitante.getText() + "' as RESPONSAVEL, '" + values + "' AS DATA FROM Ficha_Controle WHERE ESP_MATERIAL='" + cbAlteraMaterial.getSelectedItem() + "' and ESP_LINHA='" + cbAlteraLinha.getSelectedItem() + "'";
            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
        } catch (Exception e) {
        }

    }

    public void Copiaficha() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "INSERT INTO Cad_Espec_Teste (ORDEM,ESP_LINHA,ESP_MATERIAL,ESP_TESTE ,ESP_EQUIPAMENTO ,MINIMO ,MAXIMO ,UNID_MEDIDA ,TEXTO ,"
                    + "REFERENCIA ,FREQUENCIA ,UNID_FREQUENCIA,PRODUTO ,ORIGEM ,TIPO_ESPEC ,ESPEC_COMPLETO ,FREQ_COMPLETO ,LAB ,COMPLEMENTO,ESP_COMPOSTO,PENDENCIA_ALTER )SELECT  ORDEM,ESP_LINHA  ,ESP_MATERIAL ,ESP_TESTE ,ESP_EQUIPAMENTO ,MINIMO ,MAXIMO ,UNID_MEDIDA ,TEXTO ,REFERENCIA ,FREQUENCIA ,UNID_FREQUENCIA ,PRODUTO ,ORIGEM ,TIPO_ESPEC ,ESPEC_COMPLETO ,"
                    + "FREQ_COMPLETO ,LAB ,COMPLEMENTO,ESP_COMPOSTO,'Cópia' as PENDENCIA FROM Ficha_Controle WHERE ESP_MATERIAL='" + cbCopiaMaterial.getSelectedItem() + "'";
            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
        } catch (Exception e) {

        }

    }

    public void updateperfillinha() {
        try {
            java.util.Date currentDate = GregorianCalendar.getInstance().getTime();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = df.format(currentDate);
            String values = dateString;
            
            Connection con = new ConexaoSql().getCon();
            String sql = "UPDATE Cad_Espec_Teste set ESP_MATERIAL='" + cbCopiaMaterial2.getSelectedItem() + "',ESP_LINHA='" + cbCopiaLinha2.getSelectedItem().toString() + "',RESPONSAVEL_ALTER='" + txtCopiaSolicitante.getText() + "',DATA_ALTER='" + values + "' where ESP_MATERIAL='" + cbCopiaMaterial.getSelectedItem().toString() + "'";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception ex) {
            if (ex.getMessage().contains("Violation of PRIMARY KEY constraint")) {
                JOptionPane.showMessageDialog(null, "Ficha já está em aberto!", "ERRO", JOptionPane.ERROR_MESSAGE);
                deletaficha();
            } else {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    public void deletaficha() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String sql = "DELETE FROM Cad_Espec_Teste WHERE ESP_MATERIAL='" + cbCopiaMaterial.getSelectedItem().toString() + "'";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lbNovaLinha = new javax.swing.JLabel();
        lbNovaMaterial = new javax.swing.JLabel();
        cbNovaLinha = new javax.swing.JComboBox<>();
        cbNovaMaterial = new javax.swing.JComboBox<>();
        lbNovaProjeto = new javax.swing.JLabel();
        txtNovaProjeto = new javax.swing.JTextField();
        lbNovaPlano = new javax.swing.JLabel();
        txtNovaPlano = new javax.swing.JTextField();
        txtNovaDescricao = new javax.swing.JTextField();
        lbNovaDescricao = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jcPrototipo = new javax.swing.JCheckBox();
        jcPreLancamento = new javax.swing.JCheckBox();
        lbNovaStatus = new javax.swing.JLabel();
        lbNovaDesenho = new javax.swing.JLabel();
        txtNovaDesenho = new javax.swing.JTextField();
        lbNovaSolicitante = new javax.swing.JLabel();
        txtNovaSolicitante = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jcProducao = new javax.swing.JCheckBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbNova = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cbAlteraLinha = new javax.swing.JComboBox<>();
        lbAlteraLinha = new javax.swing.JLabel();
        cbAlteraMaterial = new javax.swing.JComboBox<>();
        lbAlteraMaterial = new javax.swing.JLabel();
        txtAlteraProjeto = new javax.swing.JTextField();
        lbAlteraProjeto = new javax.swing.JLabel();
        txtAlteraPlano = new javax.swing.JTextField();
        lbAlteraPlano = new javax.swing.JLabel();
        lbAlteraDescricao = new javax.swing.JLabel();
        txtAlteraDesc = new javax.swing.JTextField();
        lbAlteraSolicitante = new javax.swing.JLabel();
        txtAlteraSolicitante = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        txtAlteraDesenho = new javax.swing.JTextField();
        lbAlteraDesenho = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbAltera = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
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
        jPanel7 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        lbCopiaLinha2 = new javax.swing.JLabel();
        cbCopiaLinha2 = new javax.swing.JComboBox<>();
        lbCopiaMaterial2 = new javax.swing.JLabel();
        cbCopiaMaterial2 = new javax.swing.JComboBox<>();
        txtCopiaSolicitante = new javax.swing.JTextField();
        lbCopiaSolicitante = new javax.swing.JLabel();
        lbCopiaDesc2 = new javax.swing.JLabel();
        txtCopiaDesc2 = new javax.swing.JTextField();
        txtCopiaProjeto2 = new javax.swing.JTextField();
        lbCopiaDesenho2 = new javax.swing.JLabel();
        lbCopiaProjeto2 = new javax.swing.JLabel();
        txtCopiaDesenho2 = new javax.swing.JTextField();
        lbCopiaPlano2 = new javax.swing.JLabel();
        txtCopiaPlano2 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbCopia = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbVersao = new javax.swing.JTable();
        lbVersaoLinha = new javax.swing.JLabel();
        lbVersaoMaterial = new javax.swing.JLabel();
        txtVersaoProjeto = new javax.swing.JTextField();
        lbVersaoProjeto = new javax.swing.JLabel();
        txtVersaoPlano = new javax.swing.JTextField();
        lbVersaoPlano = new javax.swing.JLabel();
        lbVersaoDesc = new javax.swing.JLabel();
        txtVersaoDesc = new javax.swing.JTextField();
        lbVersaoSolicitante = new javax.swing.JLabel();
        txtVersaoSolicitante = new javax.swing.JTextField();
        lbVersaoData = new javax.swing.JLabel();
        lbVersaoHora = new javax.swing.JLabel();
        txtVersaoHora = new javax.swing.JFormattedTextField();
        txtVersaoDesenho = new javax.swing.JTextField();
        lbVersaoDesenho = new javax.swing.JLabel();
        cbVersaoLinha = new javax.swing.JComboBox<>();
        cbVersaoMaterial = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        txtVersaoData = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Painel de Alteração");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N

        lbNovaLinha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNovaLinha.setText("Linha:");

        lbNovaMaterial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNovaMaterial.setText("Material:");

        cbNovaLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNovaLinhaActionPerformed(evt);
            }
        });

        cbNovaMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNovaMaterialActionPerformed(evt);
            }
        });

        lbNovaProjeto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNovaProjeto.setText("Projeto:");

        txtNovaProjeto.setEditable(false);
        txtNovaProjeto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNovaProjeto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNovaProjeto.setEnabled(false);
        txtNovaProjeto.setFocusable(false);

        lbNovaPlano.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNovaPlano.setText("Número do Plano:");

        txtNovaPlano.setEditable(false);
        txtNovaPlano.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNovaPlano.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNovaPlano.setEnabled(false);
        txtNovaPlano.setFocusable(false);

        txtNovaDescricao.setEditable(false);
        txtNovaDescricao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNovaDescricao.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNovaDescricao.setEnabled(false);
        txtNovaDescricao.setFocusable(false);

        lbNovaDescricao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNovaDescricao.setText("Descrição da Peça:");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-joyent-filled-20 (1).png"))); // NOI18N
        jButton1.setText("Nova Ficha");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jcPrototipo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jcPrototipo.setSelected(true);
        jcPrototipo.setText("Protótipo");
        jcPrototipo.setBorderPainted(true);
        jcPrototipo.setFocusable(false);
        jcPrototipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcPrototipoActionPerformed(evt);
            }
        });

        jcPreLancamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jcPreLancamento.setText("Pré-Lançamento (Try Out)");
        jcPreLancamento.setBorderPainted(true);
        jcPreLancamento.setFocusable(false);
        jcPreLancamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcPreLancamentoActionPerformed(evt);
            }
        });

        lbNovaStatus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNovaStatus.setText("Status:");

        lbNovaDesenho.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNovaDesenho.setText("Número do Desenho:");

        txtNovaDesenho.setEditable(false);
        txtNovaDesenho.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNovaDesenho.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNovaDesenho.setEnabled(false);
        txtNovaDesenho.setFocusable(false);

        lbNovaSolicitante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNovaSolicitante.setText("Solicitante:");

        jButton11.setBackground(new java.awt.Color(255, 255, 255));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-n¦o-perturbe-filled-50.png"))); // NOI18N
        jButton11.setText("Cancelar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jcProducao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jcProducao.setText("Produção");
        jcProducao.setBorderPainted(true);
        jcProducao.setFocusable(false);
        jcProducao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcProducaoActionPerformed(evt);
            }
        });

        tbNova.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Data", "Linha", "Material", "Responsável", "Status", "Deletar Ficha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbNova.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbNova.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tbNova);
        if (tbNova.getColumnModel().getColumnCount() > 0) {
            tbNova.getColumnModel().getColumn(0).setMinWidth(120);
            tbNova.getColumnModel().getColumn(0).setMaxWidth(120);
            tbNova.getColumnModel().getColumn(1).setMinWidth(100);
            tbNova.getColumnModel().getColumn(1).setMaxWidth(100);
            tbNova.getColumnModel().getColumn(2).setMinWidth(100);
            tbNova.getColumnModel().getColumn(2).setMaxWidth(100);
            tbNova.getColumnModel().getColumn(3).setMinWidth(180);
            tbNova.getColumnModel().getColumn(3).setMaxWidth(180);
            tbNova.getColumnModel().getColumn(4).setMinWidth(120);
            tbNova.getColumnModel().getColumn(4).setMaxWidth(120);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Novas Fichas em Aberto:");

        jButton13.setBackground(new java.awt.Color(255, 255, 255));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-selecionado-filled-50.png"))); // NOI18N
        jButton13.setText("Selecionar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(255, 255, 255));
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-atualizaçSes-disponíveis-filled-50.png"))); // NOI18N
        jButton16.setText("Atualizar");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addComponent(txtNovaSolicitante, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNovaProjeto)
                            .addComponent(txtNovaProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNovaPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNovaPlano))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNovaDesenho)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbNovaDesenho)
                                .addGap(0, 79, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNovaLinha)
                            .addComponent(cbNovaLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNovaMaterial)
                            .addComponent(cbNovaMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbNovaDescricao)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNovaDescricao)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNovaSolicitante)
                            .addComponent(lbNovaStatus)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jcPrototipo)
                                .addGap(18, 18, 18)
                                .addComponent(jcProducao)
                                .addGap(18, 18, 18)
                                .addComponent(jcPreLancamento)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbNovaSolicitante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNovaSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbNovaLinha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbNovaLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbNovaDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNovaDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbNovaMaterial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbNovaMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNovaProjeto)
                    .addComponent(lbNovaPlano)
                    .addComponent(lbNovaDesenho))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNovaProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNovaPlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNovaDesenho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbNovaStatus)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcPrototipo)
                    .addComponent(jcProducao)
                    .addComponent(jcPreLancamento))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jButton1)
                    .addComponent(jButton13))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Nova Ficha de Controle", jPanel1);

        cbAlteraLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlteraLinhaActionPerformed(evt);
            }
        });

        lbAlteraLinha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbAlteraLinha.setText("Linha:");

        cbAlteraMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlteraMaterialActionPerformed(evt);
            }
        });

        lbAlteraMaterial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbAlteraMaterial.setText("Material:");

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

        lbAlteraDescricao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbAlteraDescricao.setText("Descrição da Peça:");

        txtAlteraDesc.setEditable(false);
        txtAlteraDesc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAlteraDesc.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAlteraDesc.setEnabled(false);
        txtAlteraDesc.setFocusable(false);

        lbAlteraSolicitante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbAlteraSolicitante.setText("Solicitante:");

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-selecionado-filled-50.png"))); // NOI18N
        jButton2.setText("Selecionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel34.setText("Fichas em Aberto:");

        txtAlteraDesenho.setEditable(false);
        txtAlteraDesenho.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAlteraDesenho.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAlteraDesenho.setEnabled(false);
        txtAlteraDesenho.setFocusable(false);

        lbAlteraDesenho.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbAlteraDesenho.setText("Número do Desenho:");

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-atualizaçSes-disponíveis-filled-50.png"))); // NOI18N
        jButton7.setText("Atualizar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-n¦o-perturbe-filled-50.png"))); // NOI18N
        jButton10.setText("Cancelar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-editar-filled-50.png"))); // NOI18N
        jButton4.setText("Alterar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAlteraSolicitante)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cbAlteraLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbAlteraMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbAlteraMaterial))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lbAlteraDescricao)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtAlteraDesc)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtAlteraProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAlteraPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbAlteraPlano))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lbAlteraDesenho)
                                        .addGap(0, 77, Short.MAX_VALUE))
                                    .addComponent(txtAlteraDesenho)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbAlteraSolicitante)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbAlteraLinha)
                                    .addComponent(lbAlteraProjeto))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAlteraLinha)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbAlteraMaterial)
                        .addComponent(lbAlteraDescricao)))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbAlteraLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAlteraMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlteraDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAlteraProjeto)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbAlteraPlano)
                        .addComponent(lbAlteraDesenho)))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAlteraProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlteraPlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlteraDesenho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbAlteraSolicitante)
                .addGap(7, 7, 7)
                .addComponent(txtAlteraSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Alterar Ficha de Controle", jPanel2);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-dados-em-ambas-as-direçSes-filled-50.png"))); // NOI18N
        jButton3.setText("Copiar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-n¦o-perturbe-filled-50.png"))); // NOI18N
        jButton9.setText("Cancelar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 112, 112));

        jLabel31.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Escolha o Material Para Copiar");

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCopiaLinha)
                            .addComponent(cbCopiaLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCopiaPerfil)
                            .addComponent(cbCopiaMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lbCopiaDesc)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtCopiaDesc)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCopiaProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCopiaProjeto))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCopiaPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCopiaPlano))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lbCopiaDesenho)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtCopiaDesenho))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(lbCopiaLinha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCopiaLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(lbCopiaDesc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCopiaDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(lbCopiaPerfil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCopiaMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbCopiaProjeto)
                            .addComponent(lbCopiaPlano))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCopiaProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCopiaPlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbCopiaDesenho)
                        .addGap(7, 7, 7)
                        .addComponent(txtCopiaDesenho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(146, 249, 158));

        jLabel32.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Defina o Novo Material");

        lbCopiaLinha2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCopiaLinha2.setText("Linha:");

        cbCopiaLinha2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCopiaLinha2ActionPerformed(evt);
            }
        });

        lbCopiaMaterial2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCopiaMaterial2.setText("Material:");

        cbCopiaMaterial2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCopiaMaterial2ActionPerformed(evt);
            }
        });

        lbCopiaSolicitante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCopiaSolicitante.setText("Solicitante:");

        lbCopiaDesc2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCopiaDesc2.setText("Descrição da Peça:");

        txtCopiaDesc2.setEditable(false);
        txtCopiaDesc2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCopiaDesc2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCopiaDesc2.setEnabled(false);
        txtCopiaDesc2.setFocusable(false);

        txtCopiaProjeto2.setEditable(false);
        txtCopiaProjeto2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCopiaProjeto2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCopiaProjeto2.setEnabled(false);
        txtCopiaProjeto2.setFocusable(false);

        lbCopiaDesenho2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCopiaDesenho2.setText("Número do Desenho:");

        lbCopiaProjeto2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCopiaProjeto2.setText("Projeto:");

        txtCopiaDesenho2.setEditable(false);
        txtCopiaDesenho2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCopiaDesenho2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCopiaDesenho2.setEnabled(false);
        txtCopiaDesenho2.setFocusable(false);

        lbCopiaPlano2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCopiaPlano2.setText("Número do Plano:");

        txtCopiaPlano2.setEditable(false);
        txtCopiaPlano2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCopiaPlano2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCopiaPlano2.setEnabled(false);
        txtCopiaPlano2.setFocusable(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCopiaLinha2)
                            .addComponent(cbCopiaLinha2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCopiaMaterial2)
                            .addComponent(cbCopiaMaterial2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(lbCopiaDesc2)
                                .addGap(143, 143, 143))
                            .addComponent(txtCopiaDesc2)))
                    .addComponent(txtCopiaSolicitante)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lbCopiaSolicitante)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCopiaProjeto2)
                            .addComponent(txtCopiaProjeto2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(lbCopiaPlano2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtCopiaPlano2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCopiaDesenho2)
                            .addComponent(txtCopiaDesenho2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCopiaSolicitante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCopiaSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(lbCopiaLinha2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCopiaLinha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(lbCopiaMaterial2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCopiaMaterial2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(lbCopiaDesc2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCopiaDesc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCopiaProjeto2)
                            .addComponent(lbCopiaPlano2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCopiaProjeto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCopiaPlano2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(lbCopiaDesenho2)
                        .addGap(7, 7, 7)
                        .addComponent(txtCopiaDesenho2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel35.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel35.setText("Fichas em Aberto:");

        tbCopia.setModel(new javax.swing.table.DefaultTableModel(
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
        tbCopia.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(tbCopia);

        jButton14.setBackground(new java.awt.Color(255, 255, 255));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-selecionado-filled-50.png"))); // NOI18N
        jButton14.setText("Selecionar");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(255, 255, 255));
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-arquivo-filled-50.png"))); // NOI18N
        jButton15.setText("Abrir");
        jButton15.setEnabled(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton9)
                    .addComponent(jButton14)
                    .addComponent(jButton15))
                .addGap(7, 7, 7))
        );

        jTabbedPane1.addTab("Copiar Ficha de Controle", jPanel3);

        tbVersao.setAutoCreateRowSorter(true);
        tbVersao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Data Alteração", "Hora", "Linha", "Material"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbVersao.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tbVersao);

        lbVersaoLinha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbVersaoLinha.setText("Linha:");

        lbVersaoMaterial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbVersaoMaterial.setText("Material:");

        txtVersaoProjeto.setEditable(false);
        txtVersaoProjeto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVersaoProjeto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtVersaoProjeto.setEnabled(false);
        txtVersaoProjeto.setFocusable(false);

        lbVersaoProjeto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbVersaoProjeto.setText("Projeto:");

        txtVersaoPlano.setEditable(false);
        txtVersaoPlano.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVersaoPlano.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtVersaoPlano.setEnabled(false);
        txtVersaoPlano.setFocusable(false);

        lbVersaoPlano.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbVersaoPlano.setText("Número do Plano:");

        lbVersaoDesc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbVersaoDesc.setText("Descrição da Peça:");

        txtVersaoDesc.setEditable(false);
        txtVersaoDesc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVersaoDesc.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtVersaoDesc.setEnabled(false);
        txtVersaoDesc.setFocusable(false);

        lbVersaoSolicitante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbVersaoSolicitante.setText("Solicitante:");

        txtVersaoSolicitante.setEnabled(false);

        lbVersaoData.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbVersaoData.setText("Data:");

        lbVersaoHora.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbVersaoHora.setText("Hora:");

        try {
            txtVersaoHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtVersaoHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVersaoHora.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtVersaoHora.setEnabled(false);

        txtVersaoDesenho.setEditable(false);
        txtVersaoDesenho.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVersaoDesenho.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtVersaoDesenho.setEnabled(false);
        txtVersaoDesenho.setFocusable(false);

        lbVersaoDesenho.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbVersaoDesenho.setText("Número do Desenho:");

        cbVersaoLinha.setEnabled(false);
        cbVersaoLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVersaoLinhaActionPerformed(evt);
            }
        });

        cbVersaoMaterial.setEnabled(false);
        cbVersaoMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVersaoMaterialActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-pesquisar-filled-50.png"))); // NOI18N
        jButton6.setText("Visualizar");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        txtVersaoData.setEditable(false);
        txtVersaoData.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVersaoData.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtVersaoData.setEnabled(false);
        txtVersaoData.setFocusable(false);

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-atualizaçSes-disponíveis-filled-50.png"))); // NOI18N
        jButton8.setText("Atualizar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-n¦o-perturbe-filled-50.png"))); // NOI18N
        jButton5.setText("Cancelar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(255, 255, 255));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-selecionado-filled-50.png"))); // NOI18N
        jButton12.setText("Selecionar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cbVersaoLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbVersaoMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtVersaoDesc))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lbVersaoSolicitante)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtVersaoSolicitante))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbVersaoData)
                            .addComponent(txtVersaoData, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtVersaoHora, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbVersaoHora)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtVersaoProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbVersaoProjeto))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbVersaoPlano)
                            .addComponent(txtVersaoPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lbVersaoDesenho)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtVersaoDesenho)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lbVersaoLinha)
                        .addGap(92, 92, 92)
                        .addComponent(lbVersaoMaterial)
                        .addGap(82, 82, 82)
                        .addComponent(lbVersaoDesc)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lbVersaoLinha)
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbVersaoMaterial)
                            .addComponent(lbVersaoDesc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVersaoDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbVersaoLinha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbVersaoMaterial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbVersaoProjeto)
                            .addComponent(lbVersaoPlano))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtVersaoProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtVersaoPlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtVersaoDesenho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addComponent(lbVersaoSolicitante)
                                .addGap(7, 7, 7)
                                .addComponent(txtVersaoSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(lbVersaoHora)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtVersaoHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(lbVersaoData)
                                .addGap(7, 7, 7)
                                .addComponent(txtVersaoData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lbVersaoDesenho))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton5)
                    .addComponent(jButton12))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Voltar Versão Anterior", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbNovaLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNovaLinhaActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select * from Qry_Material where MAT_LINHA= ? and SETOR ='Extrusão' and MATERIAL NOT IN(Select ESP_MATERIAL from Ficha_Controle) ORDER BY MATERIAL ASC ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbNovaLinha.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            cbNovaMaterial.removeAllItems();

            while (rs.next()) {

                cbNovaMaterial.addItem(rs.getString("MATERIAL"));

            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbNovaLinhaActionPerformed

    private void cbNovaMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNovaMaterialActionPerformed
        try {

            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select * from Qry_Material where MATERIAL=? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbNovaMaterial.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                //
                txtNovaDesenho.setText(rs.getString("N_DESENHO"));
                txtNovaPlano.setText(rs.getString("N_PLANO"));
                txtNovaProjeto.setText(rs.getString("MAT_PROJETO"));
                txtNovaDescricao.setText(rs.getString("DESC_MATERIAL"));

            }

        } catch (Exception e) {
//JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_cbNovaMaterialActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (cbNovaLinha.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbNovaLinha.requestFocusInWindow();
        } else if (txtNovaSolicitante.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            txtNovaSolicitante.requestFocusInWindow();
        } else if (txtNovaDescricao.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "A descrição do perfil " + cbNovaMaterial.getSelectedItem().toString() + " ainda não está cadastrado corretamente. Verifique a aba 'Cadastro de Ficha'", "", JOptionPane.WARNING_MESSAGE);
            txtNovaDescricao.requestFocusInWindow();
        } else if (txtNovaProjeto.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "A descrição do perfil " + cbNovaMaterial.getSelectedItem().toString() + " ainda não está cadastrado corretamente. Verifique a aba 'Cadastro de Ficha'", "", JOptionPane.WARNING_MESSAGE);
            txtNovaProjeto.requestFocusInWindow();
        } else {
            ViewFichaControle tela2 = new ViewFichaControle(cbNovaMaterial.getSelectedItem().toString(), cbNovaLinha.getSelectedItem().toString(), status, txtNovaSolicitante.getText(), "Novo");
            tela2.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jcPrototipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcPrototipoActionPerformed
        if (jcPrototipo.isSelected()) {
            status = "Protótipo";

        }
    }//GEN-LAST:event_jcPrototipoActionPerformed

    private void jcPreLancamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcPreLancamentoActionPerformed
        if (jcPreLancamento.isSelected()) {
            status = "Pré-Lançamento";
        }
    }//GEN-LAST:event_jcPreLancamentoActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        limparNova();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jcProducaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcProducaoActionPerformed
        if (jcProducao.isSelected()) {
            status = "Produção";
        }
    }//GEN-LAST:event_jcProducaoActionPerformed

    private void cbAlteraLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlteraLinhaActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select distinct ESP_MATERIAL from Qry_FichaControle where ESP_LINHA= ? and SETOR ='Extrusão' order by ESP_MATERIAL";
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

    private void cbAlteraMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlteraMaterialActionPerformed
        try {

            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select * from Qry_Material where MATERIAL=? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbAlteraMaterial.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                //
                txtAlteraDesenho.setText(rs.getString("N_DESENHO"));
                txtAlteraPlano.setText(rs.getString("N_PLANO"));
                txtAlteraProjeto.setText(rs.getString("MAT_PROJETO"));
                txtAlteraDesc.setText(rs.getString("DESC_MATERIAL"));

            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_cbAlteraMaterialActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int linhasselecionada = tbAltera.getSelectedRow();

        if (linhasselecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item na tabela antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            recuperarFichaControle2();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        carregaTabela();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        limparAltera();
    }//GEN-LAST:event_jButton10ActionPerformed

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

    private void cbCopiaMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCopiaMaterialActionPerformed
        try {

            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select * from Qry_Material where MATERIAL=? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbCopiaMaterial.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                //
                txtCopiaDesenho.setText(rs.getString("N_DESENHO"));
                txtCopiaPlano.setText(rs.getString("N_PLANO"));
                txtCopiaProjeto.setText(rs.getString("MAT_PROJETO"));
                txtCopiaDesc.setText(rs.getString("DESC_MATERIAL"));

            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_cbCopiaMaterialActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (cbCopiaLinha.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbCopiaLinha.requestFocusInWindow();
        } else if (txtCopiaSolicitante.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            txtCopiaSolicitante.requestFocusInWindow();
        } else if (cbCopiaLinha2.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbCopiaLinha2.requestFocusInWindow();
        } else if (cbCopiaMaterial.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbCopiaMaterial.requestFocusInWindow();
        } else if (txtCopiaDesc2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "A descrição do perfil " + cbCopiaMaterial2.getSelectedItem().toString() + " ainda não está cadastrado corretamente. Verifique a aba 'Cadastro de Ficha'", "", JOptionPane.WARNING_MESSAGE);
            txtCopiaDesc2.requestFocusInWindow();
        } else if (txtCopiaProjeto2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "A descrição do perfil " + cbCopiaMaterial2.getSelectedItem().toString() + " ainda não está cadastrado corretamente. Verifique a aba 'Cadastro de Ficha'", "", JOptionPane.WARNING_MESSAGE);
            txtCopiaProjeto2.requestFocusInWindow();
        } else {
            deletaficha();
            Copiaficha();
            updateperfillinha();
            ViewFichaControle t = new ViewFichaControle(cbCopiaMaterial2.getSelectedItem().toString(), cbCopiaLinha2.getSelectedItem().toString(), "Cópia de Ficha", txtCopiaSolicitante.getText(), "Cópia");
            t.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cbCopiaLinha2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCopiaLinha2ActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select * from Qry_Material where MAT_LINHA= ?  and SETOR='Extrusão' and MATERIAL NOT IN(Select ESP_MATERIAL from Ficha_Controle) order by  MATERIAL asc";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbCopiaLinha2.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            cbCopiaMaterial2.removeAllItems();

            while (rs.next()) {

                cbCopiaMaterial2.addItem(rs.getString("MATERIAL"));

            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbCopiaLinha2ActionPerformed

    private void cbCopiaMaterial2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCopiaMaterial2ActionPerformed
        try {

            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select * from Qry_Material where MATERIAL=? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbCopiaMaterial2.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                //
                txtCopiaDesenho2.setText(rs.getString("N_DESENHO"));
                txtCopiaPlano2.setText(rs.getString("N_PLANO"));
                txtCopiaProjeto2.setText(rs.getString("MAT_PROJETO"));
                txtCopiaDesc2.setText(rs.getString("DESC_MATERIAL"));

            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_cbCopiaMaterial2ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        limparCopia();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void cbVersaoLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVersaoLinhaActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select distinct HISTO_MATERIAL from Qry_FichaControleHisto where HISTO_LINHA= ? and SETOR = 'Extrusão' order by HISTO_MATERIAL asc ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbVersaoLinha.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            cbVersaoMaterial.removeAllItems();

            while (rs.next()) {

                cbVersaoMaterial.addItem(rs.getString("HISTO_MATERIAL"));

            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbVersaoLinhaActionPerformed

    private void cbVersaoMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVersaoMaterialActionPerformed
        try {

            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select * from Qry_Material where MATERIAL=? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbVersaoMaterial.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                txtVersaoDesenho.setText(rs.getString("N_DESENHO"));
                txtVersaoPlano.setText(rs.getString("N_PLANO"));
                txtVersaoProjeto.setText(rs.getString("MAT_PROJETO"));
                txtVersaoDesc.setText(rs.getString("DESC_MATERIAL"));

            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_cbVersaoMaterialActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (txtVersaoSolicitante.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            txtVersaoSolicitante.requestFocus();
        } else {

            ViewVersao tela2 = new ViewVersao(cbVersaoMaterial.getSelectedItem().toString(), txtVersaoData.getText(), txtVersaoHora.getText(), txtVersaoDesenho.getText(), txtVersaoProjeto.getText(), txtVersaoPlano.getText(), txtVersaoDesc.getText(), cbVersaoLinha.getSelectedItem().toString(), txtVersaoSolicitante.getText());
            tela2.setVisible(true);
            dispose();

        }
    }//GEN-LAST:event_jButton6ActionPerformed
//
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        carregaTabela2();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        limparVersao();
        jButton6.setEnabled(false);
        txtVersaoSolicitante.setEnabled(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        int linhasselecionada = tbVersao.getSelectedRow();

        if (linhasselecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item na tabela antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            recuperarHistorico();
            jButton6.setEnabled(true);
            txtVersaoSolicitante.setEnabled(true);
            txtVersaoSolicitante.requestFocus();
        }

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        int linhasselecionada = tbNova.getSelectedRow();

        if (linhasselecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item na tabela antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            recuperarFichaControle();
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (cbAlteraLinha.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbAlteraLinha.requestFocusInWindow();
        } else if (txtAlteraSolicitante.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            txtAlteraSolicitante.requestFocusInWindow();
        } else {
            Copiadados();
            ViewFichaControle t = new ViewFichaControle(cbAlteraMaterial.getSelectedItem().toString(), cbAlteraLinha.getSelectedItem().toString(), "Protótipo", txtAlteraSolicitante.getText(), "Alteração");
            t.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        int linhasselecionada = tbCopia.getSelectedRow();

        if (linhasselecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item na tabela antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            recuperarFichaControle3();
            jButton15.setEnabled(true);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        ViewFichaControle t = new ViewFichaControle(cbCopiaMaterial2.getSelectedItem().toString(), cbCopiaLinha2.getSelectedItem().toString(), "Cópia de Ficha", txtCopiaSolicitante.getText(), "Cópia");
        t.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        carregaTabela3();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        listarLinha();
        listarLinhaProducao();
        listarLinhaHistorico();
        carregaTabela2();
        carregaTabela4();
        limparGeral();

    }//GEN-LAST:event_formWindowOpened

    private void listarLinha() {
        listaModelLinha = controllerLinha.getListaLinhaController();
        cbNovaLinha.removeAllItems();
        cbCopiaLinha2.removeAllItems();
        for (int i = 0; i < listaModelLinha.size(); i++) {
            cbNovaLinha.addItem(listaModelLinha.get(i).getLinha());
            cbCopiaLinha2.addItem(listaModelLinha.get(i).getLinha());
        }
    }

    private void listarMaterialHistorico() {
        listaModelHistorico = controllerHistorico.getListaMaterialHistoController();
        cbVersaoMaterial.removeAllItems();
        for (int i = 0; i < listaModelHistorico.size(); i++) {
            cbVersaoMaterial.addItem(String.valueOf(listaModelHistorico.get(i).getHisto_material()));

        }
    }

    private void listarLinhaHistorico() {
        listaModelHistorico = controllerHistorico.getListaLinhaHistoController();
        cbVersaoLinha.removeAllItems();
        for (int i = 0; i < listaModelHistorico.size(); i++) {
            cbVersaoLinha.addItem(listaModelHistorico.get(i).getHisto_linha());

        }
    }

    private void listarLinhaProducao() {
        listaModelProducao = controllerProducao.getListaLinhaController();
        cbAlteraLinha.removeAllItems();
        cbCopiaLinha.removeAllItems();
        for (int i = 0; i < listaModelProducao.size(); i++) {
            cbAlteraLinha.addItem(listaModelProducao.get(i).getEsp_linha());
            cbCopiaLinha.addItem(listaModelProducao.get(i).getEsp_linha());

        }
    }

    private void listarPerfilProducao() {
        listaModelProducao = controllerProducao.getListaPerfilController();
        cbAlteraMaterial.removeAllItems();
        cbCopiaMaterial.removeAllItems();
        for (int i = 0; i < listaModelProducao.size(); i++) {
            cbAlteraMaterial.addItem(String.valueOf(listaModelProducao.get(i).getEsp_material()));
            cbCopiaMaterial.addItem(String.valueOf(listaModelProducao.get(i).getEsp_material()));
        }
    }

    private void listarMaterial() {
        listaModelMaterial = controllerMaterial.getListaMaterialController();
        cbNovaMaterial.removeAllItems();
        cbCopiaMaterial2.removeAllItems();
        for (int i = 0; i < listaModelMaterial.size(); i++) {
            cbNovaMaterial.addItem(String.valueOf(listaModelMaterial.get(i).getMaterial()));
            cbCopiaMaterial2.addItem(String.valueOf(listaModelMaterial.get(i).getMaterial()));
        }
    }

    private boolean recuperarHistorico() {
        int linha = this.tbVersao.getSelectedRow();
        Time hora = (Time) tbVersao.getValueAt(linha, 1);
        try {
            modelHistorico = controllerHistorico.getHistoricoController(hora);
            this.txtVersaoData.setText(String.valueOf(modelHistorico.getHisto_data_histo()));
            this.txtVersaoHora.setText(String.valueOf(modelHistorico.getHisto_hora()));
            this.cbVersaoLinha.setSelectedItem(modelHistorico.getHisto_linha());
            this.cbVersaoMaterial.setSelectedItem(String.valueOf(modelHistorico.getHisto_material()));
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código inválido ou nenhum registro selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private boolean recuperarFichaControle() {
        int linha = this.tbNova.getSelectedRow();
        Integer perfil = (Integer) tbNova.getValueAt(linha, 2);
        try {
            modelFichaControle = controllerFichaControle.getFichaController(perfil);
            this.cbNovaLinha.setSelectedItem(modelFichaControle.getEsp_linha());
            this.cbNovaMaterial.setSelectedItem(String.valueOf(modelFichaControle.getEsp_material()));
            this.txtNovaSolicitante.setText(modelFichaControle.getResponsavel_alter());
            String verstatus = modelFichaControle.getStatus();
            if (verstatus.equals("Protótipo")) {
                jcPrototipo.setSelected(true);
                status = "Protótipo";
            } else if (verstatus.equals("Produção")) {
                jcProducao.setSelected(true);
                status = "Produção";
            } else if (verstatus.equals("Pré-Lançamento")) {
                jcPreLancamento.setSelected(true);
                status = "Pré-Lançamento";
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código inválido ou nenhum registro selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private boolean recuperarFichaControle2() {
        int linha = this.tbAltera.getSelectedRow();
        Integer perfil = (Integer) tbAltera.getValueAt(linha, 2);
        try {
            modelFichaControle = controllerFichaControle.getFichaController(perfil);
            this.cbAlteraLinha.setSelectedItem(modelFichaControle.getEsp_linha());
            this.cbAlteraMaterial.setSelectedItem(String.valueOf(modelFichaControle.getEsp_material()));
            this.txtAlteraSolicitante.setText(modelFichaControle.getResponsavel_alter());
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código inválido ou nenhum registro selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private boolean recuperarFichaControle3() {
        int linha = this.tbCopia.getSelectedRow();
        Integer perfil = (Integer) tbCopia.getValueAt(linha, 2);
        try {
            modelFichaControle = controllerFichaControle.getFichaController(perfil);
            this.cbCopiaLinha2.setSelectedItem(modelFichaControle.getEsp_linha());
            this.cbCopiaMaterial2.setSelectedItem(String.valueOf(modelFichaControle.getEsp_material()));
            this.txtCopiaSolicitante.setText(modelFichaControle.getResponsavel_alter());
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código inválido ou nenhum registro selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private void carregaTabela() {
        listaModelFichaControle = controllerFichaControle.getListaFichaemAbertoAlterController();
        DefaultTableModel modelo = (DefaultTableModel) tbAltera.getModel();
        modelo.setNumRows(0);
        int cont = listaModelFichaControle.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelFichaControle.get(i).getData_alter(),
                listaModelFichaControle.get(i).getEsp_linha(),
                listaModelFichaControle.get(i).getEsp_material(),
                listaModelFichaControle.get(i).getResponsavel_alter(),});

        }

    }

    private void carregaTabela2() {
        listaModelHistorico = controllerHistorico.getLista2HistoricoController();
        DefaultTableModel modelo = (DefaultTableModel) tbVersao.getModel();
        modelo.setNumRows(0);
        int cont = listaModelHistorico.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelHistorico.get(i).getHisto_data_histo(),
                listaModelHistorico.get(i).getHisto_hora(),
                listaModelHistorico.get(i).getHisto_linha(),
                listaModelHistorico.get(i).getHisto_material()
            });

        }

    }

    private void carregaTabela3() {
        listaModelFichaControle = controllerFichaControle.getListaFichaemAbertoController();
        DefaultTableModel modelo = (DefaultTableModel) tbNova.getModel();
        modelo.setNumRows(0);
        int cont = listaModelFichaControle.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelFichaControle.get(i).getData_alter(),
                listaModelFichaControle.get(i).getEsp_linha(),
                listaModelFichaControle.get(i).getEsp_material(),
                listaModelFichaControle.get(i).getResponsavel_alter(),
                listaModelFichaControle.get(i).getStatus()
            });

        }

    }

    private void carregaTabela4() {
        listaModelFichaControle = controllerFichaControle.getListaFichaemAbertoCopiaController();
        DefaultTableModel modelo = (DefaultTableModel) tbCopia.getModel();
        modelo.setNumRows(0);
        int cont = listaModelFichaControle.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelFichaControle.get(i).getData_alter(),
                listaModelFichaControle.get(i).getEsp_linha(),
                listaModelFichaControle.get(i).getEsp_material(),
                listaModelFichaControle.get(i).getResponsavel_alter(),});

        }

    }

    private void limparNova() {
        txtNovaSolicitante.setText("");
        cbNovaLinha.setSelectedIndex(-1);
        cbNovaMaterial.setSelectedIndex(-1);
        txtNovaDescricao.setText("");
        txtNovaProjeto.setText("");
        txtNovaPlano.setText("");
        txtNovaDesenho.setText("");
        jcPrototipo.setSelected(true);
    }

    private void limparAltera() {
        txtAlteraSolicitante.setText("");
        cbAlteraLinha.setSelectedIndex(-1);
        cbAlteraMaterial.setSelectedIndex(-1);
        txtAlteraDesc.setText("");
        txtAlteraProjeto.setText("");
        txtAlteraPlano.setText("");
        txtAlteraDesenho.setText("");
    }

    private void limparCopia() {
        cbCopiaLinha.setSelectedIndex(-1);
        cbCopiaMaterial.setSelectedIndex(-1);
        txtCopiaDesc.setText("");
        txtCopiaProjeto.setText("");
        txtCopiaPlano.setText("");
        txtCopiaDesenho.setText("");
        txtCopiaSolicitante.setText("");
        cbCopiaLinha2.setSelectedIndex(-1);
        cbCopiaMaterial2.setSelectedIndex(-1);
        txtCopiaDesc2.setText("");
        txtCopiaProjeto2.setText("");
        txtCopiaPlano2.setText("");
        txtCopiaDesenho2.setText("");
        jButton15.setEnabled(false);
    }

    private void limparVersao() {
        cbVersaoLinha.setSelectedIndex(-1);
        cbVersaoMaterial.setSelectedIndex(-1);
        txtVersaoDesc.setText("");
        txtVersaoProjeto.setText("");
        txtVersaoPlano.setText("");
        txtVersaoDesenho.setText("");
        txtVersaoSolicitante.setText("");
        txtVersaoData.setText("");
        txtVersaoHora.setText("");
    }

    private void limparGeral() {
        cbVersaoLinha.setSelectedIndex(-1);
        cbVersaoMaterial.setSelectedIndex(-1);
        txtVersaoDesc.setText("");
        txtVersaoProjeto.setText("");
        txtVersaoPlano.setText("");
        txtVersaoDesenho.setText("");
        txtVersaoSolicitante.setText("");
        txtVersaoData.setText("");
        txtVersaoHora.setText("");
        cbCopiaLinha.setSelectedIndex(-1);
        cbCopiaMaterial.setSelectedIndex(-1);
        txtCopiaDesc.setText("");
        txtCopiaProjeto.setText("");
        txtCopiaPlano.setText("");
        txtCopiaDesenho.setText("");
        txtCopiaSolicitante.setText("");
        cbCopiaLinha2.setSelectedIndex(-1);
        cbCopiaMaterial2.setSelectedIndex(-1);
        txtCopiaDesc2.setText("");
        txtCopiaProjeto2.setText("");
        txtCopiaPlano2.setText("");
        txtCopiaDesenho2.setText("");
        txtAlteraSolicitante.setText("");
        cbAlteraLinha.setSelectedIndex(-1);
        cbAlteraMaterial.setSelectedIndex(-1);
        txtAlteraDesc.setText("");
        txtAlteraProjeto.setText("");
        txtAlteraPlano.setText("");
        txtAlteraDesenho.setText("");
        txtNovaSolicitante.setText("");
        cbNovaLinha.setSelectedIndex(-1);
        cbNovaMaterial.setSelectedIndex(-1);
        txtNovaDescricao.setText("");
        txtNovaProjeto.setText("");
        txtNovaPlano.setText("");
        txtNovaDesenho.setText("");
        jcPrototipo.setSelected(true);

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
            java.util.logging.Logger.getLogger(ViewGerenciador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewGerenciador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewGerenciador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewGerenciador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewGerenciador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbAlteraLinha;
    private javax.swing.JComboBox<String> cbAlteraMaterial;
    private javax.swing.JComboBox<String> cbCopiaLinha;
    private javax.swing.JComboBox<String> cbCopiaLinha2;
    private javax.swing.JComboBox<String> cbCopiaMaterial;
    private javax.swing.JComboBox<String> cbCopiaMaterial2;
    private javax.swing.JComboBox<String> cbNovaLinha;
    private javax.swing.JComboBox<String> cbNovaMaterial;
    private javax.swing.JComboBox<String> cbVersaoLinha;
    private javax.swing.JComboBox<String> cbVersaoMaterial;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JCheckBox jcPreLancamento;
    private javax.swing.JCheckBox jcProducao;
    private javax.swing.JCheckBox jcPrototipo;
    private javax.swing.JLabel lbAlteraDescricao;
    private javax.swing.JLabel lbAlteraDesenho;
    private javax.swing.JLabel lbAlteraLinha;
    private javax.swing.JLabel lbAlteraMaterial;
    private javax.swing.JLabel lbAlteraPlano;
    private javax.swing.JLabel lbAlteraProjeto;
    private javax.swing.JLabel lbAlteraSolicitante;
    private javax.swing.JLabel lbCopiaDesc;
    private javax.swing.JLabel lbCopiaDesc2;
    private javax.swing.JLabel lbCopiaDesenho;
    private javax.swing.JLabel lbCopiaDesenho2;
    private javax.swing.JLabel lbCopiaLinha;
    private javax.swing.JLabel lbCopiaLinha2;
    private javax.swing.JLabel lbCopiaMaterial2;
    private javax.swing.JLabel lbCopiaPerfil;
    private javax.swing.JLabel lbCopiaPlano;
    private javax.swing.JLabel lbCopiaPlano2;
    private javax.swing.JLabel lbCopiaProjeto;
    private javax.swing.JLabel lbCopiaProjeto2;
    private javax.swing.JLabel lbCopiaSolicitante;
    private javax.swing.JLabel lbNovaDescricao;
    private javax.swing.JLabel lbNovaDesenho;
    private javax.swing.JLabel lbNovaLinha;
    private javax.swing.JLabel lbNovaMaterial;
    private javax.swing.JLabel lbNovaPlano;
    private javax.swing.JLabel lbNovaProjeto;
    private javax.swing.JLabel lbNovaSolicitante;
    private javax.swing.JLabel lbNovaStatus;
    private javax.swing.JLabel lbVersaoData;
    private javax.swing.JLabel lbVersaoDesc;
    private javax.swing.JLabel lbVersaoDesenho;
    private javax.swing.JLabel lbVersaoHora;
    private javax.swing.JLabel lbVersaoLinha;
    private javax.swing.JLabel lbVersaoMaterial;
    private javax.swing.JLabel lbVersaoPlano;
    private javax.swing.JLabel lbVersaoProjeto;
    private javax.swing.JLabel lbVersaoSolicitante;
    private javax.swing.JTable tbAltera;
    private javax.swing.JTable tbCopia;
    private javax.swing.JTable tbNova;
    private javax.swing.JTable tbVersao;
    private javax.swing.JTextField txtAlteraDesc;
    private javax.swing.JTextField txtAlteraDesenho;
    private javax.swing.JTextField txtAlteraPlano;
    private javax.swing.JTextField txtAlteraProjeto;
    private javax.swing.JTextField txtAlteraSolicitante;
    private javax.swing.JTextField txtCopiaDesc;
    private javax.swing.JTextField txtCopiaDesc2;
    private javax.swing.JTextField txtCopiaDesenho;
    private javax.swing.JTextField txtCopiaDesenho2;
    private javax.swing.JTextField txtCopiaPlano;
    private javax.swing.JTextField txtCopiaPlano2;
    private javax.swing.JTextField txtCopiaProjeto;
    private javax.swing.JTextField txtCopiaProjeto2;
    private javax.swing.JTextField txtCopiaSolicitante;
    private javax.swing.JTextField txtNovaDescricao;
    private javax.swing.JTextField txtNovaDesenho;
    private javax.swing.JTextField txtNovaPlano;
    private javax.swing.JTextField txtNovaProjeto;
    private javax.swing.JTextField txtNovaSolicitante;
    private javax.swing.JTextField txtVersaoData;
    private javax.swing.JTextField txtVersaoDesc;
    private javax.swing.JTextField txtVersaoDesenho;
    private javax.swing.JFormattedTextField txtVersaoHora;
    private javax.swing.JTextField txtVersaoPlano;
    private javax.swing.JTextField txtVersaoProjeto;
    private javax.swing.JTextField txtVersaoSolicitante;
    // End of variables declaration//GEN-END:variables
}

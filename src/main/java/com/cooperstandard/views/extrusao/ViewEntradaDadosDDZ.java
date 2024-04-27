package com.cooperstandard.views.extrusao;

import com.cooperstandard.chart.ddz.ChartUtil3;
import com.cooperstandard.chart.ddz.DdzDataChart;
import com.cooperstandard.controller.extrusao.ControllerCausas;
import com.cooperstandard.controller.extrusao.ControllerDDZ;
import com.cooperstandard.controller.extrusao.ControllerDdzControle;
import com.cooperstandard.controller.extrusao.ControllerLinha;
import com.cooperstandard.controller.extrusao.ControllerProblema;
import com.cooperstandard.customtable.TableCustom;
import com.cooperstandard.model.ModelCausas;
import com.cooperstandard.model.ModelLinha;
import com.cooperstandard.model.ModelDDZ;
import com.cooperstandard.model.ModelDdzControle;
import com.cooperstandard.model.ModelMaterial;
import com.cooperstandard.model.ModelProblema;
import com.cooperstandard.util.ButtonColumnDdz;
import com.cooperstandard.util.ControleInstancias;
import com.cooperstandard.util.DisparaEmailFechaDDZ;
import com.cooperstandard.util.DisparaEmailMatrizaria;
import com.cooperstandard.util.Mascaras;
import com.cooperstandard.views.principal.AguardeAbrindo;
import com.cooperstandard.views.principal.AguardeSalvando;
import com.cooperstandard.views.principal.ViewResultadoLab;
import com.cooperstandard.views.principal.ViewSolicitaMtz;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.IntStream;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public final class ViewEntradaDadosDDZ extends javax.swing.JFrame {

    ControllerLinha controllerLinha = new ControllerLinha();
    ArrayList<ModelLinha> listaModelLinha = new ArrayList<>();

    ModelProblema modelproblema = new ModelProblema();
    ModelCausas modelcausas = new ModelCausas();
    ModelMaterial modelmaterial = new ModelMaterial();
    ModelDDZ modelddz = new ModelDDZ();
    ControllerDDZ controllerddz = new ControllerDDZ();
    ArrayList<ModelDDZ> listaModelddz = new ArrayList<>();
    ControllerProblema controllerProblema = new ControllerProblema();
    ArrayList<ModelProblema> listaModelProblema = new ArrayList<>();

    ModelDdzControle modelDdzControle = new ModelDdzControle();
    ControllerDdzControle controllerDdzControle = new ControllerDdzControle();
    ArrayList<ModelDdzControle> listaModelDdzControle = new ArrayList<>();
    DisparaEmailFechaDDZ email = new DisparaEmailFechaDDZ();
    DisparaEmailMatrizaria emailmatrizaria = new DisparaEmailMatrizaria();
    ControllerCausas controllerCausas = new ControllerCausas();
    ArrayList<ModelCausas> listaModelCausas = new ArrayList<>();
    int id_material = 0;
    String perfil = "";
    int id_controle = 0;
    String linha = "";
    int id_causa = 0;
    float custo = 0;
    float valormetros = 0;
    float valorreais = 0;
    float valorkg = 0;
    float peso = 0;
    String desc = "";
    ChartUtil3 chartUtil = new ChartUtil3();
    String date = "";
    float valor_reais = 0;
    float valor_metros = 0;
    double velocidade = 0;
    double onehour = 0;
    double fourhour = 0;
    long id = 0;
    String inicia = "";
    String emaillinha;
    int delay = 1;
    int interval = 300000;
    public static Timer timer;
    int qtd_teste = 0;
    String duplicado = "não";
    final AguardeSalvando carregando = new AguardeSalvando();
    final AguardeAbrindo abrindo = new AguardeAbrindo();
    private JFrame solicitante = null;
    float meta = 0;
    float m_matrizaria;
    float meta_matrizaria;
    String matriz;
    int id_matriz;
    String datahoraemail;

    public ViewEntradaDadosDDZ() {
        initComponents();
    }

    public ViewEntradaDadosDDZ(String _perfil, int _id_controle, String _linha, String _inicia) {
        initComponents();
        ButtonColumnDdz b = new ButtonColumnDdz(tbAcompanhamento, 12, this);
        TableCustom.apply(jScrollPane3, TableCustom.TableType.MULTI_LINE);
        getContentPane().setBackground(Color.WHITE);
        setExtendedState(MAXIMIZED_BOTH);
        jMenu4.setVisible(false);
        perfil = _perfil;
        linha = _linha;
        inicia = _inicia;
        pegadataatual();
        pegadata();
        listarLinha();
        listaproblema();
        perfil = _perfil;
        id_controle = _id_controle;
        linha = _linha;
        cbLinha.setSelectedItem(linha);
        cbPerfil.setSelectedItem(perfil);
        limparDados();
        atualizateste();
        if (inicia.equals("Sim")) {
            Iniciaddz();
            VerificaParada();
            if (lbStatus.getText().equals("Lançamento:")) {
                CancelaDDZ();
                pegadataatual();
                pegadata();
                jLabel27.setText(" - ");
                jMenu4.setVisible(true);
            }
        }
        if (inicia.equals("Nao")) {
            cbProblema.setEnabled(false);
            cbCausas.setEnabled(false);
            jMenu4.setVisible(true);
        }
    }

    public JTable getTbAcompanhamento() {
        return tbAcompanhamento;
    }

    public ViewEntradaDadosDDZ(JFrame frame) {
        initComponents();
        TableCustom.apply(jScrollPane3, TableCustom.TableType.MULTI_LINE);
        getContentPane().setBackground(Color.WHITE);
        setExtendedState(MAXIMIZED_BOTH);
        pegadataatual();
        pegadata();
        listarLinha();
        listaproblema();
        limparDados();
        metrosproduzidos();
        solicitante = frame;
    }

    public void setSolicitante(JFrame solicitante) {
        this.solicitante = solicitante;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        lbTotalMetros = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbTotalReais = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbTotalKg = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lbMProduzidos = new javax.swing.JLabel();
        tableScrollButton1 = new com.cooperstandard.customtable.TableScrollButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbAcompanhamento = new javax.swing.JTable();
        roundPanel1 = new com.cooperstandard.swing.RoundPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbImagem = new javax.swing.JLabel();
        cbProblema = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbLinha = new javax.swing.JComboBox<>();
        cbPerfil = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txt_Qtd_Scarp_Kg = new javax.swing.JTextField();
        cbCausas = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txt_Qtd_Scarp_reais = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel20 = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        txtHora = new javax.swing.JFormattedTextField();
        txt_Qtd_Scarp_metros = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        txtDescPerfil = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtBpcs = new javax.swing.JTextField();
        roundPanel2 = new com.cooperstandard.swing.RoundPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lbcusto = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new com.cooperstandard.swing.RoundPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        jMenuItem9.setText("jMenuItem9");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(2, 83, 161));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        jPanel3.setBackground(new java.awt.Color(241, 176, 19));

        lbTotalMetros.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbTotalMetros.setForeground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setText("Scrap total (M):");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setText("Scrap total (R$):");

        lbTotalReais.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbTotalReais.setForeground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel21.setText("Scrap total (KG):");

        lbTotalKg.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbTotalKg.setForeground(new java.awt.Color(255, 255, 255));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel28.setText("Metros Produzidos:");

        lbMProduzidos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbMProduzidos.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalMetros, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalReais, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalKg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMProduzidos, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(253, 253, 253))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTotalKg, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(lbTotalMetros, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbMProduzidos, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTotalReais, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbAcompanhamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbAcompanhamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Data", "Hora", "Problema", "Causa", "Scrap M", "Scrap R$", "Scrap Kg", "% Scrap Acumulado", "Observação", "Metros Bons", "M. Acumulado", "Ação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbAcompanhamento.setRowHeight(22);
        tbAcompanhamento.setRowMargin(2);
        tbAcompanhamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAcompanhamentoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbAcompanhamento);
        if (tbAcompanhamento.getColumnModel().getColumnCount() > 0) {
            tbAcompanhamento.getColumnModel().getColumn(0).setMinWidth(0);
            tbAcompanhamento.getColumnModel().getColumn(0).setMaxWidth(0);
            tbAcompanhamento.getColumnModel().getColumn(1).setMinWidth(110);
            tbAcompanhamento.getColumnModel().getColumn(1).setMaxWidth(110);
            tbAcompanhamento.getColumnModel().getColumn(2).setMinWidth(70);
            tbAcompanhamento.getColumnModel().getColumn(2).setMaxWidth(70);
            tbAcompanhamento.getColumnModel().getColumn(3).setMinWidth(150);
            tbAcompanhamento.getColumnModel().getColumn(5).setMinWidth(80);
            tbAcompanhamento.getColumnModel().getColumn(5).setMaxWidth(80);
            tbAcompanhamento.getColumnModel().getColumn(6).setMinWidth(80);
            tbAcompanhamento.getColumnModel().getColumn(6).setMaxWidth(80);
            tbAcompanhamento.getColumnModel().getColumn(7).setMinWidth(80);
            tbAcompanhamento.getColumnModel().getColumn(7).setMaxWidth(80);
            tbAcompanhamento.getColumnModel().getColumn(8).setMinWidth(90);
            tbAcompanhamento.getColumnModel().getColumn(8).setMaxWidth(90);
            tbAcompanhamento.getColumnModel().getColumn(10).setMinWidth(0);
            tbAcompanhamento.getColumnModel().getColumn(10).setMaxWidth(0);
            tbAcompanhamento.getColumnModel().getColumn(11).setMinWidth(0);
            tbAcompanhamento.getColumnModel().getColumn(11).setMaxWidth(0);
            tbAcompanhamento.getColumnModel().getColumn(12).setMinWidth(50);
            tbAcompanhamento.getColumnModel().getColumn(12).setMaxWidth(50);
        }

        tableScrollButton1.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        roundPanel1.setBackground(new java.awt.Color(2, 83, 161));

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-pesquisar-20 (1).png"))); // NOI18N
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("BPCS:");

        jPanel2.setBackground(new java.awt.Color(94, 94, 117));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbImagem.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbImagem, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        );

        cbProblema.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbProblema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProblemaActionPerformed(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Problema:");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Linha:");

        cbLinha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLinha.setEnabled(false);
        cbLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLinhaActionPerformed(evt);
            }
        });

        cbPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbPerfil.setEnabled(false);
        cbPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPerfilActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Perfil:");

        txt_Qtd_Scarp_Kg.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Qtd_Scarp_Kg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_Qtd_Scarp_KgFocusLost(evt);
            }
        });
        txt_Qtd_Scarp_Kg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_Qtd_Scarp_KgKeyPressed(evt);
            }
        });

        cbCausas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCausas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCausasActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Causa:");

        txt_Qtd_Scarp_reais.setEditable(false);
        txt_Qtd_Scarp_reais.setBackground(new java.awt.Color(255, 102, 102));
        txt_Qtd_Scarp_reais.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Qtd. Scrap (R$):");

        jCheckBox1.setBackground(new java.awt.Color(0, 0, 0));
        jCheckBox1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("R$");

        lbStatus.setForeground(new java.awt.Color(51, 255, 51));
        lbStatus.setText("Lançamento:");

        jDateChooser1 = new JDateChooser("dd/MM/yyyy", "##/##/#####", '_');

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Qtd. Scrap (M):");

        try {
            txtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_Qtd_Scarp_metros.setEditable(false);
        txt_Qtd_Scarp_metros.setBackground(new java.awt.Color(255, 255, 0));
        txt_Qtd_Scarp_metros.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Data:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("M");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hora:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("KG");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder("Observação"));
        jScrollPane1.setViewportView(jTextArea1);

        txtDescPerfil.setEditable(false);
        txtDescPerfil.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDescPerfil.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Descrição");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Qtd. Scrap (Kg):");

        txtBpcs.setEditable(false);
        txtBpcs.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBpcs.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(cbProblema, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cbCausas, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cbLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addComponent(txtDescPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtBpcs, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txt_Qtd_Scarp_Kg, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addComponent(txt_Qtd_Scarp_metros, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addComponent(txt_Qtd_Scarp_reais, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20))
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBpcs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCausas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(lbStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbProblema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_Qtd_Scarp_metros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_Qtd_Scarp_reais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_Qtd_Scarp_Kg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("jLabel22");

        jLabel23.setForeground(new java.awt.Color(255, 51, 51));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Peso por metro:");

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("jLabel22");

        jLabel26.setForeground(new java.awt.Color(255, 51, 51));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("% Atual de scrap:");

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("100%");

        jLabel32.setForeground(new java.awt.Color(255, 51, 51));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel32.setText("Custo por metro:");

        lbcusto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbcusto.setText("jLabel22");

        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Velocidade:");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbcusto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lbcusto, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Teste de laboratório", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("Você tem:");
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 0, 0));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("0");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("teste em aberto");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_laboratory_60px_1.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane2))
                    .addComponent(jTabbedPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jSeparator2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel1);

        jMenu1.setText("Menu");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Salvar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator3);

        jMenuItem4.setText("Iniciar DDZ");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem2.setText("Cancelar DDZ");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator4);

        jMenuItem5.setText("Tomada de ação");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);
        jMenu1.add(jSeparator5);

        jMenuItem6.setText("Sair");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actions-document-save-icon.png"))); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/printer.png"))); // NOI18N
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_waste_20px.png"))); // NOI18N
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
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
                cbPerfil.addItem(rs.getString("MATERIAL") + " - " + rs.getString("BPCS"));
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
            st.setString(1, cbPerfil.getSelectedItem().toString().split(" - ")[0]);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                desc = cbLinha.getSelectedItem().toString() + " - " + rs.getString("DESC_MATERIAL");
                txtDescPerfil.setText(rs.getString("DESC_MATERIAL"));
                txtBpcs.setText(rs.getString("BPCS"));
                ImprimiImagem(rs.getString("IMAGE"));
            }
            PegaCusto();
        } catch (Exception e) {

        }
        cbPerfil.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                jCheckBox1.setSelected(false);
                lbStatus.setText("Lançamento:");
                lbStatus.setForeground(Color.GREEN);
            }
        });
    }//GEN-LAST:event_cbPerfilActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        calculaConversao();
        String hora = txtHora.getText().split(":")[0];
        java.util.Date pegaini = jDateChooser1.getDate();
        SimpleDateFormat datachooseri = new SimpleDateFormat("dd/MM/yyyy");
        String datai = datachooseri.format(pegaini);
        String dhi = datai + " " + txtHora.getText() + ":00";
        if (hora.equals("00")) {
            int opcao = JOptionPane.showConfirmDialog(this, "Lembrou de atualizar a data após a meia noite (00:00h)?", "Atenção", JOptionPane.YES_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                VerificaDataHora();
                if (duplicado.equals("sim")) {
                    JOptionPane.showMessageDialog(null, "Data: " + new SimpleDateFormat("dd/MM/yyyy").format(jDateChooser1.getDate()) + " - Hora: " + txtHora.getText() + ", Duplicada! ", "ERRO", JOptionPane.WARNING_MESSAGE);
                } else {
                    BuscaInfoMatriz();
                    if (jCheckBox1.isSelected() && lbStatus.getText().equals("Parada:") && matriz != null) {
                        if (cbPerfil.getSelectedIndex() == -1) {
                            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                            cbPerfil.requestFocus();
                        } else if (cbProblema.getSelectedIndex() == -1 || cbCausas.getSelectedItem().equals("")) {
                            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                            cbProblema.requestFocus();
                        } else if (cbCausas.getSelectedIndex() == -1 || cbCausas.getSelectedItem().equals("")) {
                            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                            cbCausas.requestFocus();
                        } else if (txt_Qtd_Scarp_Kg.getText().equals("")) {
                            JOptionPane.showMessageDialog(this, "Necessário preencher a quantidade de SCRAP em KG!", "ERRO", JOptionPane.WARNING_MESSAGE);
                            txt_Qtd_Scarp_Kg.requestFocusInWindow();
                        } else if (jDateChooser1 == null) {
                            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                            jDateChooser1.requestFocus();
                        } else if (txtHora.getText().equals("")) {
                            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                            txtHora.requestFocus();
                        } else if ((cbProblema.getSelectedItem().toString().contains(("omposto")) || cbCausas.getSelectedItem().toString().contains(("omposto"))) && jTextArea1.getText().equals("")) {
                            JOptionPane.showMessageDialog(this, "Problemas relacionados a composto, é necessário preencher com nome do Composto/Nº da HU o campo de observação!", "ERRO", JOptionPane.WARNING_MESSAGE);
                            jTextArea1.requestFocus();
                        } else {
                            new ViewSolicitaMtz(id_matriz, dhi, matriz, cbPerfil.getSelectedItem().toString().split(" - ")[0], this).setVisible(true);
                        }
                    } else {
                        salvabanco();
                        txt_Qtd_Scarp_Kg.requestFocus();
                    }
                }
            }
        } else {
            VerificaDataHora();
            if (duplicado.equals("sim")) {
                JOptionPane.showMessageDialog(null, "Data: " + new SimpleDateFormat("dd/MM/yyyy").format(jDateChooser1.getDate()) + " - Hora: " + txtHora.getText() + ", Duplicada! ", "ERRO", JOptionPane.WARNING_MESSAGE);
            } else {
                BuscaInfoMatriz();
                if (jCheckBox1.isSelected() && lbStatus.getText().equals("Parada:") && matriz != null) {
                    if (cbPerfil.getSelectedIndex() == -1) {
                        JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                        cbPerfil.requestFocus();
                    } else if (cbProblema.getSelectedIndex() == -1 || cbCausas.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                        cbProblema.requestFocus();
                    } else if (cbCausas.getSelectedIndex() == -1 || cbCausas.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                        cbCausas.requestFocus();
                    } else if (txt_Qtd_Scarp_Kg.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Necessário preencher a quantidade de SCRAP em KG!", "ERRO", JOptionPane.WARNING_MESSAGE);
                        txt_Qtd_Scarp_Kg.requestFocusInWindow();
                    } else if (jDateChooser1 == null) {
                        JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                        jDateChooser1.requestFocus();
                    } else if (txtHora.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                        txtHora.requestFocus();
                    } else if ((cbProblema.getSelectedItem().toString().contains(("omposto")) || cbCausas.getSelectedItem().toString().contains(("omposto"))) && jTextArea1.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Problemas relacionados a composto, é necessário preencher com nome do Composto/Nº da HU o campo de observação!", "ERRO", JOptionPane.WARNING_MESSAGE);
                        jTextArea1.requestFocus();
                    } else {
                        new ViewSolicitaMtz(id_matriz, dhi, matriz, cbPerfil.getSelectedItem().toString().split(" - ")[0], this).setVisible(true);
                    }
                } else {
                    salvabanco();
                    txt_Qtd_Scarp_Kg.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void cbProblemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProblemaActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select DESC_CAUSA from Problemas INNER JOIN Causas ON Problemas.ID = ID_PROBLEMA_ID where DESC_PROBLEMA = ? and ID_PROBLEMA_ID != '51'";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbProblema.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            cbCausas.removeAllItems();
            if (!cbProblema.getSelectedItem().toString().equals("Lançamento")) {
                cbCausas.addItem("");
            }
            while (rs.next()) {
                cbCausas.addItem(rs.getString("DESC_CAUSA"));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbProblemaActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Iniciaddz();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        CancelaDDZ();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void cbCausasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCausasActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select ID from Causas where DESC_CAUSA = ?";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbCausas.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                id_causa = rs.getInt("ID");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbCausasActionPerformed

    private void txt_Qtd_Scarp_KgFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_Qtd_Scarp_KgFocusLost
        calculaConversao();
    }//GEN-LAST:event_txt_Qtd_Scarp_KgFocusLost

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new ViewTomadaAcao().setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected() && lbStatus.getText().equals("Lançamento:")) {
            cbCausas.setSelectedItem("Lançamento");
            cbProblema.setSelectedItem("Lançamento");
            jTextArea1.setText("Lançamento - ");
            cbCausas.setEnabled(false);
            cbProblema.setEnabled(false);
        } else if (jCheckBox1.isSelected() && lbStatus.getText().equals("Parada:")) {
            cbProblema.setSelectedItem("Parada não Programada");
            jTextArea1.setText("Parada de linha - ");
            cbProblema.removeAllItems();
            cbProblema.addItem("");
            cbProblema.addItem("Parada não Programada");
            cbProblema.addItem("Parada Programada");
            jTextArea1.requestFocus();
            jLabel24.setVisible(false);
        } else {
            cbCausas.setSelectedIndex(-1);
            cbProblema.setSelectedIndex(-1);
            jTextArea1.setText("");
            listaproblema();
            jLabel24.setVisible(true);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void txt_Qtd_Scarp_KgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Qtd_Scarp_KgKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                calcula();
            } catch (Exception ex) {
            }
            if (txt_Qtd_Scarp_Kg.getText().equals("0")) {
                if (jCheckBox1.isSelected() == false) {
                    cbProblema.setSelectedItem("Não houve problemas (SCRAP 0)");
                    cbCausas.setSelectedItem("Não houve problema (SCRAP 0)");
                }
            }
        }
    }//GEN-LAST:event_txt_Qtd_Scarp_KgKeyPressed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        String hora = txtHora.getText().split(":")[0];
        java.util.Date pegaini = jDateChooser1.getDate();
        SimpleDateFormat datachooseri = new SimpleDateFormat("dd/MM/yyyy");
        String datai = datachooseri.format(pegaini);
        String dhi = datai + " " + txtHora.getText() + ":00";
        if (hora.equals("00")) {
            int opcao = JOptionPane.showConfirmDialog(this, "Lembrou de atualizar a data após a meia noite (00:00h)?", "Atenção", JOptionPane.YES_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                VerificaDataHora();
                if (duplicado.equals("sim")) {
                    JOptionPane.showMessageDialog(null, "Data: " + new SimpleDateFormat("dd/MM/yyyy").format(jDateChooser1.getDate()) + " - Hora: " + txtHora.getText() + ", Duplicada! ", "ERRO", JOptionPane.WARNING_MESSAGE);
                } else {
                    BuscaInfoMatriz();
                    if (jCheckBox1.isSelected() && lbStatus.getText().equals("Parada:") && matriz != null) {
                        if (cbPerfil.getSelectedIndex() == -1) {
                            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                            cbPerfil.requestFocus();
                        } else if (cbProblema.getSelectedIndex() == -1 || cbProblema.getSelectedItem().equals("")) {
                            JOptionPane.showMessageDialog(this, "Campo 'Problema' obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                            cbProblema.requestFocus();
                        } else if (cbCausas.getSelectedIndex() == -1 || cbCausas.getSelectedItem().equals("")) {
                            JOptionPane.showMessageDialog(this, "Campo 'Causa' obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                            cbCausas.requestFocus();
                        } else if (txt_Qtd_Scarp_Kg.getText().equals("")) {
                            JOptionPane.showMessageDialog(this, "Necessário preencher a quantidade de SCRAP em KG!", "ERRO", JOptionPane.WARNING_MESSAGE);
                            txt_Qtd_Scarp_Kg.requestFocusInWindow();
                        } else if (jDateChooser1 == null) {
                            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                            jDateChooser1.requestFocus();
                        } else if (txtHora.getText().equals("")) {
                            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                            txtHora.requestFocus();
                        } else if ((cbProblema.getSelectedItem().toString().contains(("omposto")) || cbCausas.getSelectedItem().toString().contains(("omposto"))) && jTextArea1.getText().equals("")) {
                            JOptionPane.showMessageDialog(this, "Problemas relacionados a composto, é necessário preencher com nome do Composto/Nº da HU o campo de observação!", "ERRO", JOptionPane.WARNING_MESSAGE);
                            jTextArea1.requestFocus();
                        } else {
                            new ViewSolicitaMtz(id_matriz, dhi, matriz, cbPerfil.getSelectedItem().toString().split(" - ")[0], this).setVisible(true);
                        }
                    } else {
                        salvabanco();
                        txt_Qtd_Scarp_Kg.requestFocus();
                    }
                }
            }
        } else {
            VerificaDataHora();
            if (duplicado.equals("sim")) {
                JOptionPane.showMessageDialog(null, "Data: " + new SimpleDateFormat("dd/MM/yyyy").format(jDateChooser1.getDate()) + " - Hora: " + txtHora.getText() + ", Duplicada! ", "ERRO", JOptionPane.WARNING_MESSAGE);
            } else {
                BuscaInfoMatriz();
                if (jCheckBox1.isSelected() && lbStatus.getText().equals("Parada:") && matriz != null) {
                    if (cbPerfil.getSelectedIndex() == -1) {
                        JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                        cbPerfil.requestFocus();
                    } else if (cbProblema.getSelectedIndex() == -1 || cbProblema.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(this, "Campo 'Problema' obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                        cbProblema.requestFocus();
                    } else if (cbCausas.getSelectedIndex() == -1 || cbCausas.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(this, "Campo 'Causa' obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                        cbCausas.requestFocus();
                    } else if (txt_Qtd_Scarp_Kg.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Necessário preencher a quantidade de SCRAP em KG!", "ERRO", JOptionPane.WARNING_MESSAGE);
                        txt_Qtd_Scarp_Kg.requestFocusInWindow();
                    } else if (jDateChooser1 == null) {
                        JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                        jDateChooser1.requestFocus();
                    } else if (txtHora.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                        txtHora.requestFocus();
                    } else if ((cbProblema.getSelectedItem().toString().contains(("omposto")) || cbCausas.getSelectedItem().toString().contains(("omposto"))) && jTextArea1.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Problemas relacionados a composto, é necessário preencher com nome do Composto/Nº da HU o campo de observação!", "ERRO", JOptionPane.WARNING_MESSAGE);
                        jTextArea1.requestFocus();
                    } else {
                        new ViewSolicitaMtz(id_matriz, dhi, matriz, cbPerfil.getSelectedItem().toString().split(" - ")[0], this).setVisible(true);
                    }
                } else {
                    salvabanco();
                    txt_Qtd_Scarp_Kg.requestFocus();
                }

            }
        }
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        ViewPesquisaProblema vm = null;

        if (ControleInstancias.isInstaced(ViewPesquisaProblema.class
        )) {
            vm = (ViewPesquisaProblema) ControleInstancias.getInstance(ViewPesquisaProblema.class
                    .getName(), ViewPesquisaProblema.class
            );
            vm.setSolicitante(this);
        } else {
            vm = new ViewPesquisaProblema(this);
        }
        vm.setVisible(true);
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        timer.cancel();
        new ViewResultadoLab().setVisible(true);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        timer.cancel();
        new ViewResultadoLab().setVisible(true);
    }//GEN-LAST:event_jLabel29MouseClicked

    private void tbAcompanhamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAcompanhamentoMouseClicked

    }//GEN-LAST:event_tbAcompanhamentoMouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        timer.cancel();
        new ViewResultadoLab().setVisible(true);
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        new ViewSolicitaImpressao(cbLinha.getSelectedItem().toString(), cbPerfil.getSelectedItem().toString(), txtBpcs.getText(), txtDescPerfil.getText()).setVisible(true);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        timer.cancel();
        verificateste();
        if ("0".equals(jLabel30.getText())) {
            atualizateste();
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        timer.cancel();
    }//GEN-LAST:event_formWindowClosed

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja deletar esse DDZ?", "Atenção", JOptionPane.YES_OPTION);
        if (opcao == JOptionPane.OK_OPTION) {
            deletaid_controle();
            JOptionPane.showMessageDialog(null, "DDZ deletado com sucesso!");
            dispose();
        }
    }//GEN-LAST:event_jMenu4MouseClicked

    public void calculaConversao() {
        try {
            this.txt_Qtd_Scarp_Kg.setText(new Mascaras().converterVirgulaParaPonto(txt_Qtd_Scarp_Kg.getText()));
            valor_metros = (Float.parseFloat(txt_Qtd_Scarp_Kg.getText()) / (peso));
            txt_Qtd_Scarp_metros.setText(new Mascaras().converterVirgulaParaPonto(String.valueOf(String.format("%1$,.0f", valor_metros))));
            valor_reais = custo * valor_metros;
            txt_Qtd_Scarp_reais.setText(new Mascaras().converterVirgulaParaPonto(String.valueOf(String.format("%1$,.0f", valor_reais))));
            if (txt_Qtd_Scarp_Kg.getText().equals("0")) {
                if (jCheckBox1.isSelected() == false) {
                    cbProblema.setSelectedItem("Não houve problemas (SCRAP 0)");
                    cbCausas.setSelectedItem("Não houve problema (SCRAP 0)");
                }
            }
        } catch (Exception e) {

        }
    }

    public void addItemLista(String item) {
        cbProblema.addItem(item);
        cbCausas.addItem(item);
        listaproblema();
    }

    public void addItemCampo(String item) {
        cbProblema.setSelectedItem(item);
    }

    private void listarLinha() {
        listaModelLinha = controllerLinha.getListaLinhaDDZController();
        cbLinha.removeAllItems();
        for (int i = 0; i < listaModelLinha.size(); i++) {
            cbLinha.addItem(listaModelLinha.get(i).getLinha());
        }
    }

    private void listaproblema() {
        listaModelProblema = controllerProblema.getListaProblemasController();
        cbProblema.removeAllItems();
        for (int i = 0; i < listaModelProblema.size(); i++) {
            cbProblema.addItem(listaModelProblema.get(i).getDesc_problema());
        }
    }

    private void pegadata() {
        SimpleDateFormat sdfh = new SimpleDateFormat("HH:mm");
        sdfh.setTimeZone(TimeZone.getTimeZone("GMT-03:00"));
        String hora = sdfh.format(new Date());
        txtHora.setText(hora);
        java.util.Date data = Calendar.getInstance().getTime();
        jDateChooser1.setDate(data);
    }

    public void ImprimiImagem(String imagem) {
        ImageIcon img = new ImageIcon(imagem);
        lbImagem.setIcon(img);
        ImageIcon image = new ImageIcon(imagem);
        lbImagem.setIcon(new ImageIcon(image.getImage().getScaledInstance(lbImagem.getWidth(), lbImagem.getHeight(), Image.SCALE_DEFAULT)));
    }

    public void desabilitarCampos() {
        cbLinha.setEnabled(false);
        cbPerfil.setEnabled(false);
        cbCausas.setEnabled(false);
        txt_Qtd_Scarp_Kg.setEnabled(false);
        cbProblema.setEnabled(false);
    }

    private void limparDados() {
        txt_Qtd_Scarp_Kg.setText("");
        txt_Qtd_Scarp_metros.setText("");
        txt_Qtd_Scarp_reais.setText("");
        jTextArea1.setText("");
        jCheckBox1.setSelected(false);
        jCheckBox1.setEnabled(true);
        cbProblema.setSelectedIndex(-1);
        cbCausas.setSelectedIndex(-1);

    }

    public void novoProjeto() {
        habilitarCampos();
        cbLinha.setSelectedIndex(-1);
        cbPerfil.setSelectedIndex(-1);
        cbCausas.setSelectedIndex(-1);
        cbProblema.setSelectedIndex(-1);
        txtDescPerfil.setText("");
        txtBpcs.setText("");
        txt_Qtd_Scarp_Kg.setText("");
        ImprimiImagem("");
        jTextArea1.setText("");
    }

    public void habilitarCampos() {
        cbCausas.setEnabled(true);
        txt_Qtd_Scarp_Kg.setEnabled(true);
        cbProblema.setEnabled(true);
    }

    private void createLineChart(Connection conn, String desc, int metaonehour, int metafourhour) {
        List<DdzDataChart> list = getDdz(conn);
        jTabbedPane1.add(chartUtil.createXYChart((list), 65, 45, new Integer[]{metaonehour, metafourhour}, desc, meta));
    }

    private List<DdzDataChart> getDdz(Connection conn) {
        return executeQuery(conn,
                //           "SELECT data_hora_input, data_input, hora_input, qtd_scrap FROM vw_ddz_datahora WHERE id_m_material = '" + cbPerfil.getSelectedItem().toString().split(" - ")[0] + "' and id_controle = dbo.ObterDdzIdControle(ID_M_MATERIAL, (SELECT MAX(data_hora_input) from vw_ddz_datahora WHERE id_causa_id = 34 AND ID_M_MATERIAL = '" + cbPerfil.getSelectedItem().toString().split(" - ")[0] + "'))",
                "SELECT data_hora_input, data_input, hora_input, qtd_scrap FROM vw_ddz_datahora WHERE id_m_material = '" + cbPerfil.getSelectedItem().toString().split(" - ")[0] + "' and id_controle IN (SELECT MAX(id_controle) FROM vw_ddz_datahora WHERE id_causa_id = 34 AND ID_M_MATERIAL = '" + cbPerfil.getSelectedItem().toString().split(" - ")[0] + "')",
                null,
                rst -> {
                    List<DdzDataChart> list = new ArrayList();
                    while (rst.next()) {
                        list.add(new DdzDataChart(LocalDateTime.of(
                                rst.getTimestamp(2).toLocalDateTime().toLocalDate(),
                                rst.getTimestamp(3).toLocalDateTime().toLocalTime()
                        ), (long) rst.getDouble(4)));
                    }
                    return list;
                }
        );
    }

    private Map<String, Integer> getCountCausas(Connection conn) {
        return executeQuery(conn,
                "SELECT "
                + " CS.DESC_CAUSA,"
                + " COUNT(*) QUANTIDADE"
                + " FROM dbo.vw_ddz_datahora"
                + " INNER JOIN dbo.Causas CS ON CS.ID = ID_CAUSA_ID"
                + " where ID_M_MATERIAL = '" + cbPerfil.getSelectedItem().toString().split(" - ")[0] + "'"
                + "AND id_causa_id <> 59 AND data_hora_input >= (SELECT MAX(data_hora_input) FROM dbo.vw_ddz_datahora WHERE id_causa_id = 34  AND ID_M_MATERIAL= '" + cbPerfil.getSelectedItem().toString().split(" - ")[0] + "')"
                + " GROUP BY DESC_CAUSA ORDER BY DESC_CAUSA ASC",
                null,
                rst -> {
                    Map<String, Integer> map = new HashMap();
                    while (rst.next()) {
                        map.put(rst.getString(1), rst.getInt(2));
                    }
                    return map;
                });
    }

    private <R extends Object> R executeQuery(Connection conn, String sql, Map<Integer, Object> parameters, ExceptionFunction<ResultSet, R> function) {
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            if (parameters != null) {
                for (Map.Entry<Integer, Object> entry : parameters.entrySet()) {
                    pst.setObject(entry.getKey(), entry.getValue());
                }
            }
            R result = function.apply(pst.executeQuery());
            pst.close();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @FunctionalInterface
    public interface ExceptionFunction<T, R> {

        R apply(T t) throws Exception;
    }

    private Connection getConnection() {
        try {
            
            return new ConexaoSql().getCon();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private void createBarChart() {
        Map<String, Integer> countCausas = getCountCausas(getConnection());
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String rowKey = "Causa";
        countCausas.entrySet().forEach(entry -> dataset.addValue(entry.getValue(), rowKey, entry.getKey()));
        JFreeChart barChart = ChartFactory.createBarChart("",
                "", "Quantidade", dataset);
        barChart.getTitle().setVisible(false);
        CategoryPlot categoryPlot = barChart.getCategoryPlot();
        categoryPlot.setBackgroundPaint(Color.LIGHT_GRAY);
        CategoryAxis da = categoryPlot.getDomainAxis();
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        renderer.setDefaultItemLabelsVisible(true);
        Font font = new Font("Causa", Font.PLAIN, 9);
        da.setTickLabelFont(font);
        renderer.setDefaultItemLabelPaint(Color.BLACK);
        ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, org.jfree.chart.ui.TextAnchor.TOP_CENTER.TOP_CENTER);
        BarRenderer br = (BarRenderer) categoryPlot.getRenderer();
        renderer.setDefaultPositiveItemLabelPosition(position);
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        br.setMaximumBarWidth(.03);
        ChartPanel chartPanel = new ChartPanel(barChart);
        jTabbedPane2.setSize(100, 100);
        jTabbedPane2.add(chartPanel);
        jTabbedPane2.setVisible(true);
    }

    private boolean salvaDDZ() {
        modelddz.setId_material(Integer.parseInt(cbPerfil.getSelectedItem().toString().split(" - ")[0]));
        modelddz.setId_causa(id_causa);
        modelddz.setTurno("");
        modelddz.setQtd_scrap_kg(Float.parseFloat(this.txt_Qtd_Scarp_Kg.getText()));
        modelddz.setQtd_scrap(valor_metros);
        modelddz.setAcao_tomada("");
        Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
        modelddz.setData_real(dataDeHoje);
        modelddz.setData_input(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.s").format(jDateChooser1.getDate()));
        modelddz.setHora_input(String.valueOf(this.txtHora.getText()));
        modelddz.setObservacao(String.valueOf(this.jTextArea1.getText()));
        modelddz.setQtd_scrap_reais(valor_reais);
        modelddz.setVelocidade((float) velocidade);
        modelddz.setPeso(peso);
        if (lbStatus.getText().contains("Lançamento") && jCheckBox1.isSelected()) {
            modelddz.setFlag("E");
        } else if (lbStatus.getText().contains("Parada") && jCheckBox1.isSelected()) {
            modelddz.setFlag("P");
        } else {
            modelddz.setFlag("L");
        }
        modelddz.setId_controle(id_controle);
        if (controllerddz.salvarDDZController(modelddz) > 0) {
            JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao tentar gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void PegaCusto() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "SELECT CUSTO, PESO,VELOCIDADE, META FROM Velocidade_Perfil FULL OUTER JOIN Qry_Material ON ID_MATERIAL_ID = ID_MATERIAL where MATERIAL=? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbPerfil.getSelectedItem().toString().split(" - ")[0]);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                custo = 0;
                custo = rs.getFloat("CUSTO");
                lbcusto.setText(String.valueOf(String.format("%1$,.2f", custo)) + " R$");
                peso = 0;
                peso = rs.getFloat("PESO");
                jLabel25.setText(String.valueOf(peso));
                velocidade = 0;
                velocidade = rs.getDouble("VELOCIDADE");
                jLabel22.setText(String.valueOf(velocidade));
                meta = rs.getFloat("META");
            }
        } catch (Exception e) {
        }
    }

    private void carregatabela(String perfil) {
        listaModelddz = controllerddz.getListaDDZController(perfil);
        DefaultTableModel modelo = (DefaultTableModel) tbAcompanhamento.getModel();
        modelo.setNumRows(0);
        int cont = listaModelddz.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelddz.get(i).getId(),
                new SimpleDateFormat("dd/MM/yyyy").format(listaModelddz.get(i).getData()),
                new SimpleDateFormat("HH:mm").format(listaModelddz.get(i).getHora()),
                listaModelddz.get(i).getDesc_problema(),
                listaModelddz.get(i).getDesc_causa(),
                String.valueOf(String.format("%1$,.0f", listaModelddz.get(i).getQtd_scrap())),
                String.valueOf(String.format("%1$,.0f", listaModelddz.get(i).getQtd_scrap_reais())),
                listaModelddz.get(i).getQtd_scrap_kg(),
                listaModelddz.get(i).getTurno(),
                listaModelddz.get(i).getObservacao()
            });
        }
    }

    private void pegatotalmetros() {
        valormetros = 0;
        for (int i = 0; i < tbAcompanhamento.getRowCount(); i++) {
            valormetros = valormetros + Float.parseFloat(tbAcompanhamento.getModel().getValueAt(i, 5).toString());
        }
//        lbTotalMetros.setText(String.valueOf(valormetros + " M"));
        lbTotalMetros.setText(new Mascaras().converterVirgulaParaPonto(String.valueOf(String.format("%1$,.0f", valormetros) + " M")));
    }

    private void pegatotalreais() {
        BigDecimal valorreais = IntStream.range(0, tbAcompanhamento.getRowCount())
                .boxed().map(i -> tbAcompanhamento.getModel().getValueAt(i, 6).toString())
                .map(sValue -> sValue.replace(".", "").replace(",", "."))
                .map(BigDecimal::new)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
        lbTotalReais.setText(NumberFormat.getCurrencyInstance(Locale.getDefault()).format(valorreais.doubleValue()));
    }

    private void pegatotalkg() {
        valorkg = 0;
        for (int i = 0; i < tbAcompanhamento.getRowCount(); i++) {
            valorkg = valorkg + Float.parseFloat(tbAcompanhamento.getModel().getValueAt(i, 7).toString());
        }
        lbTotalKg.setText(new Mascaras().converterVirgulaParaPonto(String.valueOf(String.format("%1$,.0f", valorkg) + " Kg")));

    }

    private void pegadataatual() {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
        java.util.Date hora1 = Calendar.getInstance().getTime();
        String dataFormatada1 = sdf1.format(hora1);
        date = dataFormatada1;
    }

    private void calcula() {
        txt_Qtd_Scarp_metros.requestFocus();
        txt_Qtd_Scarp_Kg.requestFocus();
        this.txt_Qtd_Scarp_Kg.setText(new Mascaras().converterVirgulaParaPonto(txt_Qtd_Scarp_Kg.getText()));
        valor_metros = peso * Float.parseFloat(txt_Qtd_Scarp_Kg.getText());
        txt_Qtd_Scarp_metros.setText(new Mascaras().converterVirgulaParaPonto(String.valueOf(String.format("%1$,.0f", valor_metros))));
        valor_reais = custo * Float.parseFloat(txt_Qtd_Scarp_metros.getText());
        txt_Qtd_Scarp_reais.setText(new Mascaras().converterVirgulaParaPonto(String.valueOf(String.format("%1$,.0f", valor_reais))));
    }

    private void calculameta() {
        double metros_hora = velocidade * 60;
        double total_metros_produzido = (metros_hora * 5);
        double scrap = (total_metros_produzido * meta) * (0.01);
        onehour = scrap * 0.5;
        fourhour = onehour / 4;
    }

    public boolean verificahora() {
        DefaultTableModel m = (DefaultTableModel) getTbAcompanhamento().getModel();
        boolean vazia = true;
        for (int r = 0; r < m.getRowCount(); r++) {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            if (!"".equals(txtHora.getText())) {
                if (LocalTime.parse(txtHora.getText(), timeFormatter).compareTo(LocalTime.parse(m.getValueAt(r, 2).toString(), timeFormatter)) == 0) {
                    vazia = false;
                    break;
                }
            }
        }
        return vazia;
    }

    /**
     * Faz o parse de acordo com os dados de data e hora da tabela
     *
     * @param date Object de String dd/MM/yyyy
     * @param time Object de String HH:mm
     * @return data e hora convertidos em um LocalDateTime
     * @throws Exception qualquer erro de conversão
     */
    private LocalDateTime parseObjectToLocalDateTime(Object date, Object time) throws Exception {
        return LocalDateTime.of(
                LocalDate.parse(date.toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                LocalTime.parse(time.toString(), DateTimeFormatter.ofPattern("HH:mm"))
        );
    }

    /**
     * Calcula a hora residual de acordo com o número da linha da tabela
     * informado
     *
     * @param currentRow número da linha para calcular
     * @return BigDecimal com a diferente entre a data anterior e atual em
     * minutos
     * @throws Exception
     */
    public BigDecimal getHoraResidual(int currentRow) throws Exception {
        int rows = tbAcompanhamento.getRowCount();
        BigDecimal horaResidual = new BigDecimal(0);
        LocalDateTime currentHour = LocalDateTime.of(LocalDate.now(), LocalTime.of(1, 50, 0));
        LocalDateTime beforeHour = LocalDateTime.of(LocalDate.of(2022, 9, 12), LocalTime.of(23, 50, 0));
        if (rows == 0 || currentRow == 0) {
            return horaResidual;
        } else if (rows >= currentRow) {
            int beforeRow = currentRow - 1;
            /*
             - coluna 1 - data
             - coluna 2 - hora
             */
            currentHour = this.parseObjectToLocalDateTime(tbAcompanhamento.getValueAt(currentRow, 1), tbAcompanhamento.getValueAt(currentRow, 2));
            beforeHour = this.parseObjectToLocalDateTime(tbAcompanhamento.getValueAt(beforeRow, 1), tbAcompanhamento.getValueAt(beforeRow, 2));
        }
        horaResidual = BigDecimal.valueOf(beforeHour.until(currentHour, ChronoUnit.MINUTES));
        return horaResidual;
    }

    public void calcularMetrosBons() throws Exception {
        BigDecimal valor = new BigDecimal(0);
        /*
         - coluna 10 - metros bons
         - calcula metros bons
         */
        for (int row = 0; row < tbAcompanhamento.getRowCount(); row++) {
            valor = valor.add(this.getHoraResidual(row).multiply(BigDecimal.valueOf(velocidade)));
            tbAcompanhamento.setValueAt(valor.intValue(), row, 10);
        }
        this.calcularScrapAcumulado();
    }

    private void calcularScrapAcumulado() {
        /*
         - coluna 5 - scrap em metros
         - coluna 11 - scrap acumulado
         - calcula scrap acumulado
         */
        double scrapAcumulado = 0;
        for (int row = 0; row <= tbAcompanhamento.getRowCount(); row++) {
            if (row > 0) {
                int beforeRow = row - 1;
                String scrap = tbAcompanhamento.getValueAt(beforeRow, 5).toString();
                scrapAcumulado += Double.parseDouble(scrap);
                tbAcompanhamento.setValueAt(scrapAcumulado, beforeRow, 11);
            }
        }
    }

    public void calcularMetrosBonsPorcetagem() throws Exception {
        BigDecimal porcent;
        if (tbAcompanhamento.getRowCount() > 0) {
            tbAcompanhamento.setValueAt(" - ", 0, 8);
            for (int row = 1; row <= tbAcompanhamento.getRowCount(); row++) {
                if (row > 1) {
                    try {
                        String str1 = formatValueString(tbAcompanhamento.getValueAt((row - 1), 11).toString());
                        String str2 = formatValueString(tbAcompanhamento.getValueAt((row - 1), 10).toString());
                        BigDecimal var1 = new BigDecimal(str1);
                        BigDecimal var2 = new BigDecimal(str2);
                        porcent = var1.divide(var2, 9, RoundingMode.HALF_UP);
                        porcent = porcent.multiply(new BigDecimal(100));
                        tbAcompanhamento.setValueAt(new Mascaras().converterVirgulaParaPonto(String.valueOf(String.format("%1$,.2f", porcent))) + " %", row - 1, 8);
                        jLabel27.setText(new Mascaras().converterVirgulaParaPonto(String.valueOf(String.format("%1$,.2f", porcent))) + " %");
                    } catch (Exception ex) {
                        jLabel27.setText(" - ");
                    }
                }
            }
        }
    }

    public void metrosbons() {
        try {
            this.calcularMetrosBons();
            this.calcularMetrosBonsPorcetagem();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String formatValueString(String value) {
        try {
            int dotIndex = value.indexOf(".");
            if (dotIndex > 1) {
                return value;
            }
            return value.replace(".", "");
        } catch (Exception e) {
        }
        return value;
    }

    public void deletaddz(String pCodigo) {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "DELETE FROM DDZ "
                    + "WHERE "
                    + " ID= '" + pCodigo + "'"
                    + ";";
            PreparedStatement st = con.prepareStatement(query1);
            st.executeQuery();
        } catch (Exception e) {
        }
    }

    public void salvabanco() {
        if (cbPerfil.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            cbPerfil.requestFocus();
        } else if (cbProblema.getSelectedIndex() == -1 || cbProblema.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo 'Problema' obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            cbProblema.requestFocus();
        } else if (cbCausas.getSelectedIndex() == -1 || cbCausas.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo 'Causa' obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            cbCausas.requestFocus();
        } else if (txt_Qtd_Scarp_Kg.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Necessário preencher a quantidade de SCRAP em KG!", "ERRO", JOptionPane.WARNING_MESSAGE);
            txt_Qtd_Scarp_Kg.requestFocusInWindow();
        } else if (jDateChooser1 == null) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            jDateChooser1.requestFocus();
        } else if (txtHora.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            txtHora.requestFocus();
        } else if ((cbProblema.getSelectedItem().toString().contains(("omposto")) || cbCausas.getSelectedItem().toString().contains(("omposto"))) && jTextArea1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Problemas relacionados a composto, é necessário preencher com nome do Composto/Nº da HU o campo de observação!", "ERRO", JOptionPane.WARNING_MESSAGE);
            jTextArea1.requestFocus();
        } else {
            txt_Qtd_Scarp_Kg.requestFocus();
            cbLinha.requestFocus();
            salvaDDZ();
            cbCausas.setEnabled(true);
            cbProblema.setEnabled(true);
            if (jCheckBox1.isSelected() && lbStatus.getText().equals("Lançamento:")) {
                lbStatus.setText("Parada:");
                jMenu4.setVisible(false);
                lbStatus.setForeground(Color.ORANGE);
                cbLinha.setEnabled(false);
                cbPerfil.setEnabled(false);
            } else if (jCheckBox1.isSelected() && lbStatus.getText().equals("Parada:")) {
                lbStatus.setText("Lançamento:");
                lbStatus.setForeground(Color.GREEN);
                cbLinha.setEnabled(true);
                cbPerfil.setEnabled(true);
                metrosproduzidos();
                BuscaInfoMatrizaria();
                AlimentaVidaUtil();
                VerificaEmailMatrizaria();
                RelacaoLinha();
                enviaemailanexo();
                if (cbProblema.getSelectedItem().toString().equals("Parada Programada") && cbCausas.getSelectedItem().toString().equals("Try Out")) {
                    alteraddzTryOut("Y");
                }
                dispose();
            }
            carregatabela(cbPerfil.getSelectedItem().toString().split(" - ")[0]);
            pegatotalmetros();
            pegatotalreais();
            alterDDZControle();
            pegatotalkg();
            try {
                String myTime = txtHora.getText();
                SimpleDateFormat df = new SimpleDateFormat("HH:mm");
                Date d = df.parse(myTime);
                Calendar cal = Calendar.getInstance();
                cal.setTime(d);
                cal.add(Calendar.HOUR, 1);
                String newTime = df.format(cal.getTime());
                txtHora.setText(newTime);
            } catch (Exception e) {
            }
            jTabbedPane1.removeAll();
            jTabbedPane2.removeAll();
            calculameta();
            createLineChart(getConnection(), desc, (int) onehour, (int) fourhour);
            limparDados();
            createBarChart();
            metrosbons();
            metrosproduzidos();
            carregando.setVisible(false);
        }
    }

    public void VerificaParada() {
        for (int i = 0; i < tbAcompanhamento.getRowCount(); i++) {
            String tb = tbAcompanhamento.getValueAt(i, 9).toString();
            if (tb.contains("Parada")) {
                lbStatus.setText("Lançamento:");
                lbStatus.setForeground(Color.GREEN);
                cbProblema.setEnabled(false);
                cbCausas.setEnabled(false);
            } else {
                lbStatus.setText("Parada:");
                lbStatus.setForeground(Color.ORANGE);
                String hora = tbAcompanhamento.getValueAt(i, 2).toString();
                String h = hora;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                LocalTime hh = LocalTime.parse(h, formatter).plusHours(1);
                txtHora.setText(String.valueOf(hh));
            }
        }
    }

    public final void Iniciaddz() {
        if (cbLinha.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            cbLinha.requestFocus();
        } else if (cbPerfil.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
            cbPerfil.requestFocus();
        } else {
            pegadata();
            jTabbedPane1.removeAll();
            jTabbedPane2.removeAll();
            calculameta();
            createLineChart(getConnection(), desc, (int) onehour, (int) fourhour);
            createBarChart();
            carregatabela(cbPerfil.getSelectedItem().toString().split(" - ")[0]);
            pegatotalmetros();
            pegatotalreais();
            pegatotalkg();
            metrosbons();
            VerificaParada();
            metrosproduzidos();
        }
    }

    private boolean alterDDZControle() {
        modelDdzControle.setScrap_total(Float.valueOf(lbTotalReais.getText().replaceAll("[^\\d+,]", "").replace(",", ".")));
        modelDdzControle.setCusto(custo);
        modelDdzControle.setVelocidade((float) velocidade);
        modelDdzControle.setPeso(peso);
        if (controllerDdzControle.atualizarDdzControleController(modelDdzControle, id_controle)) {
            limparDados();
            return true;
        } else {
            return false;
        }
    }

    public void metrosproduzidos() {
        for (int i = 0; i < tbAcompanhamento.getRowCount(); i++) {
            int tb = (int) tbAcompanhamento.getValueAt(i, 10);
            float total = tb - valormetros;
            lbMProduzidos.setText(new Mascaras().converterVirgulaParaPonto(String.valueOf(String.format("%1$,.0f", total) + " M")));
        }
    }

    private void RelacaoLinha() {
        Map<String, String> emailLinhaMap = new HashMap<>();
        emailLinhaMap.put("L07", "lucas.coelho@cooperstandard.com");
        emailLinhaMap.put("L08", "lucas.coelho@cooperstandard.com");
        emailLinhaMap.put("L04", "ricardo.porto@cooperstandard.com");
        emailLinhaMap.put("L06", "ricardo.porto@cooperstandard.com");
        emailLinhaMap.put("L12", "carlos.marangon@cooperstandard.com");
        emailLinhaMap.put("L17", "raphael.vilela@cooperstandard.com");
        emailLinhaMap.put("L09", "carlos.ferreira2@cooperstandard.com");
        emailLinhaMap.put("L11", "carlos.ferreira2@cooperstandard.com");
        emailLinhaMap.put("L19", "wesley.oliveira@cooperstandard.com,maykon.silva@cooperstandard.com");
        emailLinhaMap.put("L26", "wesley.oliveira@cooperstandard.com,maykon.silva@cooperstandard.com");
        emailLinhaMap.put("L27", "wesley.oliveira@cooperstandard.com,maykon.silva@cooperstandard.com");
        emailLinhaMap.put("L28", "wesley.oliveira@cooperstandard.com,maykon.silva@cooperstandard.com");
        emaillinha = emailLinhaMap.getOrDefault(cbLinha.getSelectedItem().toString(), "");
    }

    public void VerificaDataHora() {
        int rowCount = tbAcompanhamento.getRowCount();
        if (rowCount == 0) {
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String startDateString = dateFormat.format(jDateChooser1.getDate());

        for (int i = 0; i < rowCount; i++) {
            String data = tbAcompanhamento.getValueAt(i, 1).toString();
            String hora = tbAcompanhamento.getValueAt(i, 2).toString();
            if (data.equals(startDateString) && hora.equals(txtHora.getText())) {
                duplicado = "sim";
                break;
            } else {
                duplicado = "não";
            }
        }
    }

    public boolean isTableEmpty() {
        DefaultTableModel m = (DefaultTableModel) getTbAcompanhamento().getModel();
        for (int r = 0; r < m.getRowCount(); r++) {
            if (m.getValueAt(r, 0) == null || m.getValueAt(r, 0) == "") {
                return false;
            }
        }
        return true;
    }

    public void atualizateste() {
        if (piscapanel.isAlive()) {
            // Thread já está em execução, interrompe antes de iniciar novamente
            piscapanel.interrupt();
            try {
                piscapanel.join();
            } catch (InterruptedException ex) {
                // tratamento de exceção
            }
        }
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                verificateste();
                if (!"0".equals(jLabel30.getText())) {
                    piscapanel.start();
                    piscapanel.resume();
                } else {
                    piscapanel.suspend();
                    jLabel14.setVisible(false);
                }
            }
        }, delay, interval);
    }
    Thread piscapanel = new Thread(() -> {
        try {
            while (true) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        jLabel14.setVisible(!jLabel14.isVisible());
                    }
                });
                Thread.sleep(900);
            }
        } catch (InterruptedException ex) {
            //ex.printStackTrace();
        }

    });

    public final void verificateste() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "SELECT "
                    + " COUNT (ID_CONTROLE) AS SOMA"
                    + " FROM (SELECT DISTINCT ID_CONTROLE FROM INSP_Controle INNER JOIN Cad_ResultadoInsp ON INSP_Controle.ID = Cad_ResultadoInsp.ID_CONTROLE "
                    + " INNER JOIN Cad_Material ON PERFIL = MATERIAL   "
                    + " AND MAT_LINHA LIKE '%" + linha + "%' and RECONHECIMENTO is null and INSP_Controle.STATUS != 'Pendente' and INSP_Controle.STATUS != 'null'"
                    + " GROUP BY ID_CONTROLE) tb";
            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                jLabel30.setText(rs.getString("SOMA"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deletaddz() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "DELETE FROM DDZ where ID_CONTROLE = '" + id_controle + "' ";
            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void buttonjtable() {
        int index = getTbAcompanhamento().getSelectedRow();
        String qtd_scrap = tbAcompanhamento.getValueAt(index, 0).toString();
        String lancamento = tbAcompanhamento.getValueAt(index, 3).toString();

        if (lancamento.equals("Lançamento")) {
            int opcao = JOptionPane.showConfirmDialog(this, "Após excluir um lançamento,"
                    + " será necessário recomeçar um novo DDZ. Deseja mesmo assim continuar?", "Atenção", JOptionPane.YES_OPTION);
            if (opcao == JOptionPane.OK_OPTION) {
                deletaid_controle();
                JOptionPane.showMessageDialog(null, "Registros deletados com sucesso!");
                dispose();
            }
        } else {
            String hora = tbAcompanhamento.getValueAt(index, 2).toString();
            String data = tbAcompanhamento.getValueAt(index, 1).toString();
            int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
                    + " excluir o registro: " + data + " - " + hora + " ?", "Atenção", JOptionPane.YES_OPTION);
            if (opcao == JOptionPane.OK_OPTION) {
                deletaddz(qtd_scrap);

                try {
                    jDateChooser1.setDate(new SimpleDateFormat("dd/MM/yyyyy").parse(data));
                } catch (ParseException ex) {
                }
                txtHora.setText(hora);
                String problema = tbAcompanhamento.getValueAt(index, 3).toString();
                cbProblema.setSelectedItem(problema);
                String causa = tbAcompanhamento.getValueAt(index, 4).toString();
                cbCausas.setSelectedItem(causa);
                String qtd_kg = tbAcompanhamento.getValueAt(index, 7).toString();
                txt_Qtd_Scarp_Kg.setText(String.valueOf(qtd_kg));
                String obs = tbAcompanhamento.getValueAt(index, 9).toString();
                jTextArea1.setText(obs);
                txt_Qtd_Scarp_Kg.requestFocus();
                jTabbedPane1.removeAll();
                jTabbedPane2.removeAll();
                calculameta();
                createLineChart(getConnection(), desc, (int) onehour, (int) fourhour);
                createBarChart();
                carregatabela(cbPerfil.getSelectedItem().toString().split(" - ")[0]);
                pegatotalmetros();
                pegatotalreais();
                pegatotalkg();
                metrosbons();
                VerificaParada();
                metrosproduzidos();

                atualizateste();
            }
        }
    }

    ////-----Matrizaria//////
    public final void BuscaInfoMatrizaria() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "SELECT "
                    + " M_PRODUZIDO,"
                    + " META,"
                    + " MATRIZ,"
                    + "ID_CONTROLE"
                    + " FROM Registro_Manutencao AS tb1 INNER JOIN Matriz_Controle ON Matriz_Controle.ID = tb1.ID_CONTROLE  "
                    + " WHERE "
                    + " ID_PERFIL = '" + cbPerfil.getSelectedItem().toString().split(" - ")[0] + "' AND STATUS = 'A'";

            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                m_matrizaria = rs.getFloat("M_PRODUZIDO");
                meta_matrizaria = rs.getFloat("META");
                matriz = rs.getString("MATRIZ");
                id_matriz = rs.getInt("ID_CONTROLE");
            }
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public final void BuscaInfoMatriz() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "SELECT "
                    + " MATRIZ,"
                    + "ID"
                    + " FROM  Matriz_Controle  "
                    + " WHERE "
                    + " ID_PERFIL = '" + cbPerfil.getSelectedItem().toString().split(" - ")[0] + "'";

            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                matriz = rs.getString("MATRIZ");
                id_matriz = rs.getInt("ID");
            }
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    private BigDecimal getTotalMatrizaria() {
        if (tbAcompanhamento.getRowCount() > 0) {
            int lastRowValue = (int) tbAcompanhamento.getValueAt(tbAcompanhamento.getRowCount() - 1, 10);
            BigDecimal metrosBons = new BigDecimal(lastRowValue);
            BigDecimal totalMatriz = metrosBons.add(BigDecimal.valueOf(m_matrizaria));
            return totalMatriz;
        }
        return BigDecimal.valueOf(0);
    }

    public void AlimentaVidaUtil() {
        try {
            if (tbAcompanhamento.getRowCount() > 0) {
                
                Connection con = new ConexaoSql().getCon();
                BigDecimal totalMatriz = this.getTotalMatrizaria();
                String query1 = "UPDATE tb1 SET "
                        + " M_PRODUZIDO = '" + totalMatriz.toPlainString() + "'"
                        + " FROM Registro_Manutencao AS tb1 INNER JOIN Matriz_Controle ON Matriz_Controle.ID = tb1.ID_CONTROLE"
                        + " WHERE "
                        + " ID_PERFIL = '" + cbPerfil.getSelectedItem().toString().split(" - ")[0] + "' AND STATUS = 'A'"
                        + ";";
                PreparedStatement st = con.prepareStatement(query1);
                st.executeQuery();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void VerificaEmailMatrizaria() {
        BigDecimal totalMatriz = this.getTotalMatrizaria();
        if (totalMatriz.floatValue() > meta_matrizaria && meta_matrizaria > 0) {
            emailmatrizaria.Email(cbPerfil.getSelectedItem().toString(), cbLinha.getSelectedItem().toString(), "arcisio.paula@cooperstandard.com", matriz, meta_matrizaria, totalMatriz.floatValue());
        }
    }

    public void CancelaDDZ() {
        jTabbedPane1.removeAll();
        jTabbedPane2.removeAll();
        limparDados();
        ((DefaultTableModel) tbAcompanhamento.getModel()).setNumRows(0);
        lbTotalKg.setText("0.0 KG");
        lbTotalMetros.setText("0.0 M");
        lbMProduzidos.setText("0.0 M");
        lbTotalReais.setText("0.0 R$");
        lbStatus.setText("Lançamento:");
        lbStatus.setForeground(Color.GREEN);
    }

    public void deletaid_controle() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "DELETE FROM DDZ_Controle where ID = '" + id_controle + "' ";
            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
        } catch (Exception e) {
        }
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "DELETE FROM DDZ where ID_CONTROLE = '" + id_controle + "' ";
            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
        } catch (Exception e) {
        }
    }

    public void enviaemailanexo() {
        String data = tbAcompanhamento.getValueAt(0, 1).toString();
        String hora = tbAcompanhamento.getValueAt(0, 2).toString();
        try {
            String datahora = data + " " + hora;
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date lancamento = inputFormat.parse(datahora);
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            datahoraemail = outputFormat.format(lancamento);
        } catch (ParseException e) {
        }
        try {
            String logo = "/images/logocooper.png";
            
            Connection con = new ConexaoSql().getCon();
            Map p = new HashMap();
            p.put("datetimeinput", datahoraemail);
            p.put("perfil", cbPerfil.getSelectedItem().toString().split(" - ")[0]);
            p.put("logo", this.getClass().getResourceAsStream(logo));
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Relatorios/ddzrodadaA3.jasper"));
            JasperPrint print = JasperFillManager.fillReport(jr, p, con);
            byte[] pdfContent = JasperExportManager.exportReportToPdf(print);
            email.Email(String.valueOf(cbPerfil.getSelectedItem().toString()), cbLinha.getSelectedItem().toString(), emaillinha, lbTotalKg.getText(), lbTotalMetros.getText(), lbTotalReais.getText(), jLabel27.getText(), lbMProduzidos.getText(), jTextArea1.getText(), pdfContent);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "deu erro =" + erro);
            System.out.println(erro);
        }
    }

    private void alteraddzTryOut(String flag) {
        try {
            
            Connection con = new ConexaoSql().getCon();

            String query1 = "UPDATE DDZ_TryOut SET TRY_OUT = ? WHERE LINHA = ?";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, flag);
            st.setString(2, cbLinha.getSelectedItem().toString());

            st.executeUpdate();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            // Trate a exceção de acordo com suas necessidades
        }
    }

    ////-----Matrizaria//////
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
            java.util.logging.Logger.getLogger(ViewEntradaDadosDDZ.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewEntradaDadosDDZ.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewEntradaDadosDDZ.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewEntradaDadosDDZ.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewEntradaDadosDDZ view = new ViewEntradaDadosDDZ();
                view.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbCausas;
    private javax.swing.JComboBox<String> cbLinha;
    private javax.swing.JComboBox<String> cbPerfil;
    private javax.swing.JComboBox<String> cbProblema;
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private com.cooperstandard.swing.RoundPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbImagem;
    private javax.swing.JLabel lbMProduzidos;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel lbTotalKg;
    private javax.swing.JLabel lbTotalMetros;
    private javax.swing.JLabel lbTotalReais;
    private javax.swing.JLabel lbcusto;
    private com.cooperstandard.swing.RoundPanel roundPanel1;
    private com.cooperstandard.swing.RoundPanel roundPanel2;
    private com.cooperstandard.customtable.TableScrollButton tableScrollButton1;
    private javax.swing.JTable tbAcompanhamento;
    private javax.swing.JTextField txtBpcs;
    private javax.swing.JTextField txtDescPerfil;
    private javax.swing.JFormattedTextField txtHora;
    private javax.swing.JTextField txt_Qtd_Scarp_Kg;
    private javax.swing.JTextField txt_Qtd_Scarp_metros;
    private javax.swing.JTextField txt_Qtd_Scarp_reais;
    // End of variables declaration//GEN-END:variables
}

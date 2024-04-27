package com.cooperstandard.views.extrusao;

import com.cooperstandard.chart.ddz.ChartUtil3;
import com.cooperstandard.chart.ddz.DdzDataChart;
import com.cooperstandard.controller.extrusao.ControllerCausas;
import com.cooperstandard.controller.extrusao.ControllerDDZ;
import com.cooperstandard.controller.extrusao.ControllerDdzControle;
import com.cooperstandard.controller.extrusao.ControllerLinha;
import com.cooperstandard.controller.extrusao.ControllerProblema;
import com.cooperstandard.model.ModelCausas;
import com.cooperstandard.model.ModelLinha;
import com.cooperstandard.model.ModelDDZ;
import com.cooperstandard.model.ModelDdzControle;
import com.cooperstandard.model.ModelMaterial;
import com.cooperstandard.model.ModelProblema;
import com.cooperstandard.util.ControleInstancias;
import com.cooperstandard.util.DisparaEmailFechaDDZ;
import com.cooperstandard.util.Mascaras;
import com.cooperstandard.views.principal.ViewRelatorio;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import java.util.stream.IntStream;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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

/**
 *
 * @author rsouza10
 */
public final class ViewAlteraDDZ extends javax.swing.JFrame {

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
    String idtabela;
    private JFrame solicitante = null;
    float meta = 0;

    public ViewAlteraDDZ() {
        initComponents();

    }

    public ViewAlteraDDZ(String _perfil, int _id_controle, String _linha, String _inicia) {
        initComponents();
        perfil = _perfil;
        id_controle = _id_controle;
        linha = _linha;
        inicia = _inicia;
        setExtendedState(MAXIMIZED_BOTH);
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
        jMenuItem9.addActionListener((ActionEvent e) -> {
            int index = getTbAcompanhamento().getSelectedRow();
            String qtd_scrap = tbAcompanhamento.getValueAt(index, 0).toString();
            int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
                    + " excluir o registro?", "Atenção", JOptionPane.YES_OPTION);
            if (opcao == JOptionPane.OK_OPTION) {
                deletaddz(qtd_scrap);
                String data = tbAcompanhamento.getValueAt(index, 1).toString();
                try {
                    jDateChooser1.setDate(new SimpleDateFormat("dd/MM/yyyyy").parse(data));
                } catch (ParseException ex) {
                }
                String hora = tbAcompanhamento.getValueAt(index, 2).toString();
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
            }
        });
        jMenuItem5.addActionListener((ActionEvent e) -> {
            int index = getTbAcompanhamento().getSelectedRow();
            idtabela = tbAcompanhamento.getValueAt(index, 0).toString();
            int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
                    + " alterar o registro?", "Atenção", JOptionPane.YES_OPTION);
            if (opcao == JOptionPane.OK_OPTION) {
                String data = tbAcompanhamento.getValueAt(index, 1).toString();
                try {
                    jDateChooser1.setDate(new SimpleDateFormat("dd/MM/yyyyy").parse(data));
                } catch (ParseException ex) {
                }
                String hora = tbAcompanhamento.getValueAt(index, 2).toString();
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
            }
        });
        if (inicia.equals("Sim")) {
            Iniciaddz();
            VerificaParada();
        }
    }

    public JTable getTbAcompanhamento() {
        return tbAcompanhamento;
    }

    public ViewAlteraDDZ(JFrame frame) {
        initComponents();
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbLinha = new javax.swing.JComboBox<>();
        cbPerfil = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbCausas = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        txtHora = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        txtDescPerfil = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtBpcs = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbImagem = new javax.swing.JLabel();
        cbProblema = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        txt_Qtd_Scarp_Kg = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        lbStatus = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_Qtd_Scarp_metros = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbAcompanhamento = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lbTotalMetros = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbTotalReais = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbTotalKg = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lbMProduzidos = new javax.swing.JLabel();
        txt_Qtd_Scarp_reais = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jMenuItem5.setText("Alterar");
        jPopupMenu1.add(jMenuItem5);

        jMenuItem9.setForeground(new java.awt.Color(255, 51, 51));
        jMenuItem9.setText("Excluir");
        jPopupMenu1.add(jMenuItem9);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(2, 83, 161));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Linha:");

        cbLinha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLinha.setFocusable(false);
        cbLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLinhaActionPerformed(evt);
            }
        });

        cbPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbPerfil.setEnabled(false);
        cbPerfil.setFocusable(false);
        cbPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPerfilActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Perfil:");

        cbCausas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCausas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCausasActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Causa:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-adicionar-20 (2).png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jDateChooser1 = new JDateChooser("dd/MM/yyyy", "##/##/#####", '_');
        jDateChooser1.setEnabled(false);

        try {
            txtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.setEnabled(false);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Data:");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hora:");

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
        jLabel9.setText("Qtd. Scarp (Kg):");

        txtBpcs.setEditable(false);
        txtBpcs.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBpcs.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("BPCS:");

        jPanel2.setBackground(new java.awt.Color(94, 94, 117));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbImagem.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbImagem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        cbProblema.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbProblema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProblemaActionPerformed(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Problema:");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-adicionar-20 (2).png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        txt_Qtd_Scarp_Kg.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Qtd_Scarp_Kg.setEnabled(false);
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

        jCheckBox1.setEnabled(false);
        jCheckBox1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        lbStatus.setForeground(new java.awt.Color(51, 255, 51));
        lbStatus.setText("Lançamento:");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Qtd. Scarp (M):");

        txt_Qtd_Scarp_metros.setEditable(false);
        txt_Qtd_Scarp_metros.setBackground(new java.awt.Color(255, 255, 0));
        txt_Qtd_Scarp_metros.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Qtd_Scarp_metros.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("M");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("KG");

        tbAcompanhamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbAcompanhamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Data", "Hora", "Problema", "Causa", "Scrap M", "Scrap R$", "Scrap Kg", "% Scrap Acumulado", "Observação", "Metros Bons", "M. Acumulado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
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
            tbAcompanhamento.getColumnModel().getColumn(1).setMinWidth(90);
            tbAcompanhamento.getColumnModel().getColumn(1).setMaxWidth(90);
            tbAcompanhamento.getColumnModel().getColumn(2).setMinWidth(60);
            tbAcompanhamento.getColumnModel().getColumn(2).setMaxWidth(60);
            tbAcompanhamento.getColumnModel().getColumn(3).setMinWidth(150);
            tbAcompanhamento.getColumnModel().getColumn(5).setMinWidth(80);
            tbAcompanhamento.getColumnModel().getColumn(5).setMaxWidth(80);
            tbAcompanhamento.getColumnModel().getColumn(6).setMinWidth(80);
            tbAcompanhamento.getColumnModel().getColumn(6).setMaxWidth(80);
            tbAcompanhamento.getColumnModel().getColumn(7).setMinWidth(80);
            tbAcompanhamento.getColumnModel().getColumn(7).setMaxWidth(80);
            tbAcompanhamento.getColumnModel().getColumn(8).setMinWidth(80);
            tbAcompanhamento.getColumnModel().getColumn(8).setMaxWidth(80);
            tbAcompanhamento.getColumnModel().getColumn(10).setMinWidth(0);
            tbAcompanhamento.getColumnModel().getColumn(10).setMaxWidth(0);
            tbAcompanhamento.getColumnModel().getColumn(11).setMinWidth(0);
            tbAcompanhamento.getColumnModel().getColumn(11).setMaxWidth(0);
        }

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMProduzidos, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(lbTotalMetros, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbMProduzidos, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addGap(17, 17, 17)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTotalReais, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_Qtd_Scarp_reais.setEditable(false);
        txt_Qtd_Scarp_reais.setBackground(new java.awt.Color(255, 102, 102));
        txt_Qtd_Scarp_reais.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Qtd_Scarp_reais.setEnabled(false);

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Qtd. Scarp (R$):");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("R$");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Velocidade:");

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-pesquisar-20 (1).png"))); // NOI18N
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_Qtd_Scarp_Kg))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_Qtd_Scarp_metros, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_Qtd_Scarp_reais, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel20)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel6)
                                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(cbLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(cbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(326, 326, 326))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtDescPerfil)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(txtBpcs, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel12))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(cbProblema, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel24)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbCausas, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4))
                                    .addComponent(jLabel3))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtBpcs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel8))
                                    .addComponent(txtDescPerfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbCausas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(lbStatus))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbProblema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(3, 3, 3)
                                                    .addComponent(jLabel9)
                                                    .addGap(29, 29, 29))
                                                .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(23, 23, 23)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txt_Qtd_Scarp_Kg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txt_Qtd_Scarp_metros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txt_Qtd_Scarp_reais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addGap(29, 29, 29))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(23, 23, 23))
                                                .addComponent(txtHora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel1);

        jMenu1.setText("Menu");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Alterar");
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

        jMenuItem8.setText("Velocidade/Custo");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem3.setText("Material");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setText("Relatórios");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);
        jMenu1.add(jSeparator5);

        jMenuItem6.setText("Sair");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save_1.png"))); // NOI18N
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
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
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

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        new ViewCausas().setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        ViewProblema vm = null;
        if (ControleInstancias.isInstaced(ViewProblema.class)) {
            vm = (ViewProblema) ControleInstancias.getInstance(ViewProblema.class.getName(), ViewProblema.class);
            vm.setSolicitante(this);
        } else {
            vm = new ViewProblema(this);
        }
        vm.setVisible(true);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void cbProblemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProblemaActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select DESC_CAUSA from Problemas INNER JOIN Causas ON Problemas.ID = ID_PROBLEMA_ID where DESC_PROBLEMA = ?";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbProblema.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            cbCausas.removeAllItems();
            while (rs.next()) {
                cbCausas.addItem(rs.getString("DESC_CAUSA"));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbProblemaActionPerformed

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
        try {
            this.txt_Qtd_Scarp_Kg.setText(new Mascaras().converterVirgulaParaPonto(txt_Qtd_Scarp_Kg.getText()));
            valor_metros = (Float.parseFloat(txt_Qtd_Scarp_Kg.getText()) / (peso));
            txt_Qtd_Scarp_metros.setText(new Mascaras().converterVirgulaParaPonto(String.valueOf(String.format("%1$,.0f", valor_metros))));
            valor_reais = custo * valor_metros;
            txt_Qtd_Scarp_reais.setText(new Mascaras().converterVirgulaParaPonto(String.valueOf(String.format("%1$,.0f", valor_reais))));
            if (txt_Qtd_Scarp_Kg.getText().equals("0")) {
                cbProblema.setSelectedItem("Não houve problemas (SCRAP 0)");
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_txt_Qtd_Scarp_KgFocusLost

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected() && lbStatus.getText().equals("Lançamento:")) {
            cbCausas.setSelectedItem("Lançamento");
            cbProblema.setSelectedItem("Lançamento");
            jTextArea1.setText("Lançamento - ");
            cbCausas.setEnabled(false);
            cbProblema.setEnabled(false);
        } else if (jCheckBox1.isSelected() && lbStatus.getText().equals("Parada:")) {
            jTextArea1.setText("Parada de linha - ");
            jTextArea1.requestFocus();
        } else {
            cbCausas.setSelectedIndex(-1);
            cbProblema.setSelectedIndex(-1);
            jTextArea1.setText("");
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void txt_Qtd_Scarp_KgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Qtd_Scarp_KgKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                calcula();

            } catch (Exception ex) {
            }
            if (txt_Qtd_Scarp_Kg.getText().equals("0")) {
                cbProblema.setSelectedItem("Não houve problemas (SCRAP 0)");
            }
        }
    }//GEN-LAST:event_txt_Qtd_Scarp_KgKeyPressed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        String hora = txtHora.getText().split(":")[0];
        if (hora.equals("00")) {
            int opcao = JOptionPane.showConfirmDialog(this, "Lembrou de atualizar a data após a meia noite (00:00h)?", "Atenção", JOptionPane.YES_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                salvabanco();
            }
        } else {
            salvabanco();
        }
    }//GEN-LAST:event_jMenu2MouseClicked

    private void tbAcompanhamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAcompanhamentoMouseClicked
        int linhasselecionada = tbAcompanhamento.getSelectedRow();
        if (linhasselecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item antes de clicar com o mouse!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            if (evt.getButton() == MouseEvent.BUTTON3) {
                jPopupMenu1.show(tbAcompanhamento, evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_tbAcompanhamentoMouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        ViewPesquisaProblema vm = null;
        if (ControleInstancias.isInstaced(ViewPesquisaProblema.class)) {
            vm = (ViewPesquisaProblema) ControleInstancias.getInstance(ViewPesquisaProblema.class.getName(), ViewPesquisaProblema.class);
            vm.setSolicitante(this);
        } else {
            vm = new ViewPesquisaProblema(this);
        }
        vm.setVisible(true);
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        new ViewRelatorio().setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ViewMaterial vm = null;
        if (ControleInstancias.isInstaced(ViewMaterial.class)) {
            vm = (ViewMaterial) ControleInstancias.getInstance(ViewMaterial.class.getName(), ViewMaterial.class);
            vm.setSolicitante(this);
        } else {
            vm = new ViewMaterial(this);
        }
        vm.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        new ViewVelocidade().setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
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
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Iniciaddz();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        String hora = txtHora.getText().split(":")[0];
        if (hora.equals("00")) {
            int opcao = JOptionPane.showConfirmDialog(this, "Lembrou de atualizar a data após a meia noite (00:00h)?", "Atenção", JOptionPane.YES_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                salvabanco();
            }
        } else {
            salvabanco();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
                "SELECT data_hora_input, data_input, hora_input, qtd_scrap FROM vw_ddz_datahora WHERE id_m_material = '" + cbPerfil.getSelectedItem().toString().split(" - ")[0] + "' and id_controle = '" + id_controle + "'",
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
                + "AND id_causa_id <> 59 and id_controle = '" + id_controle + "' "
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
        JFreeChart barChart = ChartFactory.createBarChart("LINHA '" + cbLinha.getSelectedItem() + "' - '" + txtDescPerfil.getText(),
                "", "Quantidade", dataset);
        CategoryPlot categoryPlot = barChart.getCategoryPlot();
        CategoryAxis da = categoryPlot.getDomainAxis();
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        renderer.setDefaultItemLabelsVisible(true);
//        da.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
        Font font = new Font("Causa", Font.PLAIN, 9);
        da.setTickLabelFont(font);

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

    private boolean alterarDDZ() {
        modelddz.setId(Long.valueOf(idtabela));
        modelddz.setId_causa(id_causa);
        modelddz.setObservacao(String.valueOf(this.jTextArea1.getText()));
        if (controllerddz.atualizarDDZController(modelddz)) {
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
            this.desabilitarCampos();
            carregatabela(cbPerfil.getSelectedItem().toString().split(" - ")[0]);
            limparDados();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
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
        listaModelddz = controllerddz.getListaDDZEditController(perfil, id_controle);
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
        } else {
            txt_Qtd_Scarp_Kg.requestFocus();
            cbLinha.requestFocus();
            alterarDDZ();
            cbCausas.setEnabled(true);
            cbProblema.setEnabled(true);
            if (jCheckBox1.isSelected() && lbStatus.getText().equals("Lançamento:")) {
                lbStatus.setText("Parada:");
                lbStatus.setForeground(Color.ORANGE);
                cbLinha.setEnabled(false);
                cbPerfil.setEnabled(false);
            } else if (jCheckBox1.isSelected() && lbStatus.getText().equals("Parada:")) {
                lbStatus.setText("Lançamento:");
                lbStatus.setForeground(Color.GREEN);
                cbLinha.setEnabled(true);
                cbPerfil.setEnabled(true);
                metrosproduzidos();
                RelacaoLinha();
//                email.Email(String.valueOf(cbPerfil.getSelectedItem().toString()), cbLinha.getSelectedItem().toString(), emaillinha, lbTotalKg.getText(), lbTotalMetros.getText(), lbTotalReais.getText(), jLabel27.getText(), lbMProduzidos.getText(), jTextArea1.getText());
                dispose();
                new ViewDdzGerenciador().setVisible(true);
            }
            carregatabela(cbPerfil.getSelectedItem().toString().split(" - ")[0]);
            pegatotalmetros();
            pegatotalreais();
            altertopfive();
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

        }
    }

    public void VerificaParada() {
        for (int i = 0; i < tbAcompanhamento.getRowCount(); i++) {
            String tb = tbAcompanhamento.getValueAt(i, 9).toString();
            if (tb.contains("Parada")) {
                lbStatus.setText("Lançamento:");
                lbStatus.setForeground(Color.GREEN);

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

    private boolean altertopfive() {
        modelDdzControle.setScrap_total(Float.valueOf(lbTotalReais.getText().replaceAll("[^\\d+,]", "").replace(",", ".")));
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
        switch (cbLinha.getSelectedItem().toString()) {
            case "L07":
            case "L08":
                emaillinha = "lucas.coelho@cooperstandard.com";
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
            java.util.logging.Logger.getLogger(ViewAlteraDDZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAlteraDDZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAlteraDDZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAlteraDDZ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAlteraDDZ().setVisible(true);
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
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
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
    private javax.swing.JTable tbAcompanhamento;
    private javax.swing.JTextField txtBpcs;
    private javax.swing.JTextField txtDescPerfil;
    private javax.swing.JFormattedTextField txtHora;
    private javax.swing.JTextField txt_Qtd_Scarp_Kg;
    private javax.swing.JTextField txt_Qtd_Scarp_metros;
    private javax.swing.JTextField txt_Qtd_Scarp_reais;
    // End of variables declaration//GEN-END:variables
}

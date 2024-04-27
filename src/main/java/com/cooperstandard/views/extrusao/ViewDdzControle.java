package com.cooperstandard.views.extrusao;

import com.cooperstandard.chart.ddz.ChartUtil3;
import com.cooperstandard.controller.extrusao.ControllerDdzControle;
import com.cooperstandard.controller.extrusao.ControllerLinha;
import com.cooperstandard.controller.extrusao.ControllerUsuario;
import com.cooperstandard.controller.extrusao.ControllerVelocidade;
import com.cooperstandard.model.ModelCausas;
import com.cooperstandard.model.ModelDdzControle;
import com.cooperstandard.model.ModelLinha;
import com.cooperstandard.model.ModelMaterial;
import com.cooperstandard.model.ModelProblema;
import com.cooperstandard.model.ModelSessaoUsuario;
import com.cooperstandard.model.ModelUsuario;
import com.cooperstandard.model.ModelVelocidade;
import com.cooperstandard.util.ControleInstancias;
import com.cooperstandard.util.EstiloTablaRenderer;
import com.cooperstandard.util.HeaderRenderer;
import com.cooperstandard.views.principal.AguardeAbrindo;
import com.cooperstandard.views.principal.ViewResultadoLab;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 * @author rsouza10
 */
public final class ViewDdzControle extends javax.swing.JFrame {

    ControllerLinha controllerLinha = new ControllerLinha();
    ArrayList<ModelLinha> listaModelLinha = new ArrayList<>();
    ModelProblema modelproblema = new ModelProblema();
    ModelCausas modelcausas = new ModelCausas();
    ModelMaterial modelmaterial = new ModelMaterial();
    ModelDdzControle modelddz = new ModelDdzControle();
    ControllerDdzControle controllerDdzControle = new ControllerDdzControle();
    ArrayList<ModelDdzControle> listaModelDdzControle = new ArrayList<>();
    ModelUsuario modelusuario = new ModelUsuario();
    ControllerUsuario controllerUsuario = new ControllerUsuario();
    ChartUtil3 chartUtil = new ChartUtil3();
    int id_conrtole;
    int verifica = 0;
    int id_planta = 0;
    String pNomeUsuario = "";
    String pPlantaUsuario = "";
    int pCodigoUsuario = 0;
    float velocidade = 0;
    double scrap = 0.0;
    double scrap_bom = 0.0;
    String linha = "";
    int perfil;
    String bpcs;
    String desc_perfil;
    final AguardeAbrindo carregando = new AguardeAbrindo();
    private JDialog imageDialog = null;
    int ddzemproducao;
    int ddzemsetup;
    double onehour = 0;
    double fourhour = 0;
    String desc = "DDZ";
    float meta = 7;
    String database;
    float custo;
    float peso;
    float speed;
    String problema;
    String causa;
    String obs_problema;

    public ViewDdzControle() {
        initComponents();
        configurar();
        jLabel2.setVisible(false);
        carregatabeladdz();
        jTable3.getTableHeader().setDefaultRenderer(new HeaderRenderer(jTable3));
        jTable3.setDefaultRenderer(String.class, new EstiloTablaRenderer());
        jTable3.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
        jTable3.setDefaultRenderer(Float.class, new EstiloTablaRenderer());
        verificametodos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.cooperstandard.swing.RoundPanel();
        roundPanel2 = new com.cooperstandard.swing.RoundPanel();
        jLabel4 = new javax.swing.JLabel();
        button2 = new com.cooperstandard.swing.Button();
        tableScrollButton1 = new com.cooperstandard.customtable.TableScrollButton();
        jScrollPane2 = new com.cooperstandard.swing.ScrollPaneWin11();
        jTable3 = new javax.swing.JTable();
        myTextField1 = new com.cooperstandard.swing.MyTextField();
        jLabel1 = new javax.swing.JLabel();
        roundPanel3 = new com.cooperstandard.swing.RoundPanel();
        button1 = new com.cooperstandard.swing.Button();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        button3 = new com.cooperstandard.swing.Button();
        button4 = new com.cooperstandard.swing.Button();
        roundPanel5 = new com.cooperstandard.swing.RoundPanel();
        roundPanel6 = new com.cooperstandard.swing.RoundPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel31 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        roundPanel4 = new com.cooperstandard.swing.RoundPanel();
        lbScrap = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbTermino = new javax.swing.JLabel();
        lbInicio = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbPerfil = new javax.swing.JLabel();
        lbMBons = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        progress2 = new com.cooperstandard.swing.progress.Progress();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        roundPanel2.setBackground(new java.awt.Color(241, 176, 19));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Registrar novo DDZ:");

        button2.setText("Registrar DDZ");
        button2.setEnabled(false);
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        jTable3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Perfil", "Descrição", "Velocidade", "Peso", "Custo", "IMAGEM"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class
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
        jTable3.setRowHeight(27);
        jScrollPane2.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setMinWidth(0);
            jTable3.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable3.getColumnModel().getColumn(1).setMinWidth(110);
            jTable3.getColumnModel().getColumn(1).setMaxWidth(110);
            jTable3.getColumnModel().getColumn(3).setMinWidth(90);
            jTable3.getColumnModel().getColumn(3).setMaxWidth(90);
            jTable3.getColumnModel().getColumn(4).setMinWidth(90);
            jTable3.getColumnModel().getColumn(4).setMaxWidth(90);
            jTable3.getColumnModel().getColumn(5).setMinWidth(90);
            jTable3.getColumnModel().getColumn(5).setMaxWidth(90);
            jTable3.getColumnModel().getColumn(6).setMinWidth(0);
            jTable3.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        tableScrollButton1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        myTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                myTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                myTextField1KeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Search:");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(myTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(myTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tableScrollButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel3.setBackground(new java.awt.Color(2, 83, 161));

        button1.setText("Abrir DDZ");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("DDZ em produção:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 179, 103));
        jLabel2.setText("--");

        button3.setBackground(new java.awt.Color(255, 255, 0));
        button3.setText("Try Out");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button4.setBackground(new java.awt.Color(102, 255, 255));
        button4.setText("Testes de laboratório");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        roundPanel5.setBackground(new java.awt.Color(255, 255, 255));

        roundPanel6.setBackground(new java.awt.Color(12, 67, 121));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Status atual da linha:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 179, 103));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Aguardando lançamento...");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 102, 0));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Motivo");

        javax.swing.GroupLayout roundPanel6Layout = new javax.swing.GroupLayout(roundPanel6);
        roundPanel6.setLayout(roundPanel6Layout);
        roundPanel6Layout.setHorizontalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundPanel6Layout.setVerticalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensddz/icons8_speedometer_30px.png"))); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Velocidade:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 179, 103));
        jLabel10.setText("--");

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensddz/icons8_money_bag_30px_2.png"))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Custo:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 179, 103));
        jLabel26.setText("--");

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensddz/icons8_weight_kg_30px.png"))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Peso:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 179, 103));
        jLabel25.setText("--");

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Perfil:");

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensddz/icons8_chart_30px.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 179, 103));
        jLabel3.setText("--");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 179, 103));
        jLabel8.setText("--");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 179, 103));
        jLabel9.setText("--");

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensddz/icons8_calendar_30px.png"))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Data:");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(roundPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel20)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel22)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(roundPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel29)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel23)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                        .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(36, 36, 36)
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(roundPanel3Layout.createSequentialGroup()
                                    .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                                            .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(48, 48, 48))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(10, 10, 10))
                                .addComponent(jSeparator4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)))))
                .addContainerGap())
        );

        roundPanel4.setBackground(new java.awt.Color(2, 83, 161));

        lbScrap.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbScrap.setForeground(new java.awt.Color(255, 179, 103));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Início:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Término:");

        lbTermino.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbTermino.setForeground(new java.awt.Color(255, 179, 103));

        lbInicio.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbInicio.setForeground(new java.awt.Color(255, 179, 103));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Bons:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Perfil:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Scrap:");

        lbPerfil.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbPerfil.setForeground(new java.awt.Color(255, 179, 103));

        lbMBons.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbMBons.setForeground(new java.awt.Color(255, 179, 103));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Total produzido");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("% Scrap");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 0));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Último DDZ lançado");

        jPanel2.setBackground(new java.awt.Color(241, 176, 19));

        progress2.setBackground(new java.awt.Color(0, 255, 0));
        progress2.setBorder(null);
        progress2.setForeground(new java.awt.Color(0, 255, 0));
        progress2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(progress2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(progress2, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbMBons, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(roundPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbScrap, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel4Layout.createSequentialGroup()
                .addContainerGap(139, Short.MAX_VALUE)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTermino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24))
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbMBons, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbScrap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(11, 11, 11)
                        .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(roundPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        verificametodos();
    }//GEN-LAST:event_formWindowGainedFocus

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        verifica_ddzemproducao();
        verifica_ddzemsetup();
        if (ddzemproducao != 0) {
            JOptionPane.showMessageDialog(null, "Já existe um ddz em produção!");
        } else if (ddzemsetup != 0) {
            JOptionPane.showMessageDialog(null, "Já existe um ddz em setup!");
        } else {
            registraid();
            pegaid();
            verificametodos();
            alteraddzTryOut("N");
            JOptionPane.showMessageDialog(null, "DDZ Registrado!");
            final AguardeAbrindo abrindo = new AguardeAbrindo();
            abrindo.setVisible(true);
            Thread t = new Thread() {
                public void run() {
                    if (!ControleInstancias.isInstaced(ViewEntradaDadosDDZ.class)) {
                        ControleInstancias.addInstance(ViewEntradaDadosDDZ.class.getName(), new ViewEntradaDadosDDZ(perfil + " - " + bpcs, Integer.valueOf(jLabel2.getText()), linha, "Nao"));
                    }
                    ViewEntradaDadosDDZ viewDDZ = (ViewEntradaDadosDDZ) ControleInstancias.getInstance(ViewEntradaDadosDDZ.class.getName(), ViewEntradaDadosDDZ.class);
                    viewDDZ.setVisible(true);
                    abrindo.dispose();

                }
            };
            t.start();

        }

    }//GEN-LAST:event_button2ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        if (ddzemsetup == 0 && ddzemproducao == 0) {
            JOptionPane.showMessageDialog(null, "Não há DDZ em aberto.");
        } else {
//            final AguardeAbrindo abrindo = new AguardeAbrindo();
//            abrindo.setVisible(true);
//            Thread t = new Thread() {
//                public void run() {
            if (!ControleInstancias.isInstaced(ViewEntradaDadosDDZ.class)) {
                ControleInstancias.addInstance(ViewEntradaDadosDDZ.class.getName(), new ViewEntradaDadosDDZ(perfil + " - " + bpcs, Integer.valueOf(jLabel2.getText()), linha, "Sim"));
            }
            ViewEntradaDadosDDZ viewDDZ = (ViewEntradaDadosDDZ) ControleInstancias.getInstance(ViewEntradaDadosDDZ.class.getName(), ViewEntradaDadosDDZ.class);
            viewDDZ.setVisible(true);
//                    abrindo.dispose();
//                }
//            };
//            t.start();
        }
    }//GEN-LAST:event_button1ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        new ViewResultadoLab().setVisible(true);
    }//GEN-LAST:event_button4ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        new ViewTryOut().setVisible(true);
    }//GEN-LAST:event_button3ActionPerformed

    private void myTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_myTextField1KeyPressed

    }//GEN-LAST:event_myTextField1KeyPressed

    private void myTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_myTextField1KeyReleased
        DefaultTableModel tabela = (DefaultTableModel) this.jTable3.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabela);
        this.jTable3.setRowSorter(sorter);
        String text = myTextField1.getText();
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
    }//GEN-LAST:event_myTextField1KeyReleased

    private boolean registraid() {
        int selectedRow = jTable3.getSelectedRow();
        String tb_perfil = (String) jTable3.getValueAt(selectedRow, 1);
        Float tb_custo = (Float) jTable3.getValueAt(selectedRow, 5);
        Float tb_peso = (Float) jTable3.getValueAt(selectedRow, 4);
        Float tb_speed = (Float) jTable3.getValueAt(selectedRow, 3);
        modelddz.setMaterial(Integer.parseInt(tb_perfil.split(" - ")[0]));
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.s");
        Date data = new Date();
        modelddz.setData_base(format.format(data));
        modelddz.setLinha(linha);
        modelddz.setCusto(tb_custo);
        modelddz.setPeso(tb_peso);
        modelddz.setVelocidade(tb_speed);
        if (controllerDdzControle.salvarDdzControleController(modelddz) > 0) {
//            carregatabela();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao tentar gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void verificametodos() {
        jLabel2.setVisible(false);
        verifica_ddzemsetup();
        verifica_ddzemproducao();
        ultimoddz();
        calculahora();
        calculapercent(scrap_bom, scrap);
        jLabel2.setText(ddzemproducao != 0 ? String.valueOf(ddzemproducao) : String.valueOf(ddzemsetup));
        if (ddzemproducao != 0) {
            jLabel8.setText(String.valueOf(perfil));
            jLabel3.setText(String.valueOf(desc_perfil));
            jLabel2.setText(String.valueOf(ddzemproducao));
            jLabel7.setText("Produzindo");
            jLabel9.setText(database);
            jLabel10.setText(String.valueOf(speed) + " m/min");
            jLabel26.setText(String.valueOf(custo) + " R$");
            jLabel25.setText(String.valueOf(peso) + " Kg");
            jProgressBar1.setIndeterminate(true);
            this.setLocationRelativeTo(null);
            jLabel7.setForeground(Color.green);
            jProgressBar1.setVisible(true);
            jLabel31.setVisible(false);
        }
        if (ddzemsetup != 0) {
            jLabel8.setText(String.valueOf(perfil));
            jLabel3.setText(String.valueOf(desc_perfil));
            jLabel2.setText(String.valueOf(ddzemsetup));
            jLabel7.setText("Setup");
            jLabel9.setText(database);
            jLabel10.setText(String.valueOf(speed) + " m/min");
            jLabel26.setText(String.valueOf(custo) + " R$");
            jLabel25.setText(String.valueOf(peso) + " Kg");
            jProgressBar1.setIndeterminate(false);
            this.setLocationRelativeTo(null);
            jProgressBar1.setBackground(Color.YELLOW);
            jProgressBar1.setVisible(true);
            jLabel7.setForeground(Color.YELLOW);
            jLabel31.setVisible(false);
        }
        if (ddzemsetup == 0 && ddzemproducao == 0) {
            verifica_motivoparada();
            jLabel7.setText("Parada");
            jLabel31.setText(causa);
            jLabel7.setForeground(Color.RED);
            jProgressBar1.setVisible(false);
            jLabel31.setVisible(true);
            jLabel8.setText("--");
            jLabel3.setText("--");
            jLabel9.setText("--");
            jLabel25.setText("--");
            jLabel10.setText("--");
            jLabel26.setText("--");
        }
    }

    private void pegaid() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select top (1) ID from DDZ_Controle WHERE LINHA = '" + linha + "' order by id desc";
            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                id_conrtole = rs.getInt("ID");
            }
        } catch (Exception e) {

        }
    }

    public int retornarUsuarioLogado() {
        return new ModelSessaoUsuario().codigo;
    }

    public String retornarUsuarioLogadoNome() {
        return new ModelSessaoUsuario().nome;
    }

    public String retornarUsuarioLogadoPlanta() {
        return new ModelSessaoUsuario().planta;
    }

    private void configurar() {
        pCodigoUsuario = retornarUsuarioLogado();
        pNomeUsuario = retornarUsuarioLogadoNome();
        pPlantaUsuario = retornarUsuarioLogadoPlanta();
        switch (pPlantaUsuario) {
            case "Varginha":
                id_planta = 1;
                break;
            case "Atibaia":
                id_planta = 2;
                break;
            default:
                id_planta = 1;
                break;
        }
        switch (pNomeUsuario) {
            case "DDZL4":
                linha = "L04";
                break;
            case "DDZL6":
                linha = "L06";
                break;
            case "DDZL7":
                linha = "L07";
                break;
            case "DDZL8":
                linha = "L08";
                break;
            case "DDZL9":
                linha = "L09";
                break;
            case "DDZL11":
                linha = "L11";
                break;
            case "DDZL12":
                linha = "L12";
                break;
            case "DDZL17":
                linha = "L17";
                break;
            case "DDZL19":
                linha = "L19";
                break;
            case "DDZL27":
                linha = "L27";
                break;
            case "DDZL26":
                linha = "L26";
                break;
            case "DDZL28":
                linha = "L28";
                break;
            default:
                linha = "L";
                break;
        }
    }

    private String calcularMinutosProduzidos(JLabel labelDataInicial, JLabel labelDataFinal, float velocidade) {
        if (labelDataInicial.getText().isEmpty() || labelDataFinal.getText().isEmpty()) {
            return "";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        Long minutosProduzidos = LocalDateTime.parse(labelDataInicial.getText(), formatter).until(LocalDateTime.parse(labelDataFinal.getText(), formatter), ChronoUnit.MINUTES);
        scrap_bom = (minutosProduzidos * velocidade);
        return String.format("%1$,.0f m", (minutosProduzidos * velocidade));
    }

    private static PieDataset createDataset(Double minutosBons, Double minutosScrap) {
        Double porcScrap = (minutosScrap / minutosBons) * 100;
        Double porcProducao = 100 - porcScrap;
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("% Scrap", porcScrap);
        dataset.setValue("Produção", porcProducao);
        return dataset;
    }

    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "", // chart title 
                dataset, // data    
                false, // include legend   
                true,
                false);
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionPaint(0, Color.red);
        plot.setSectionPaint(1, Color.white);
        plot.setExplodePercent(0, 0.10);
        plot.setBackgroundPaint(Color.black);
        plot.setSimpleLabels(true);
        chart.setBackgroundPaint(Color.black);
        plot.setLabelGenerator(null);
        return chart;
    }

    public static JPanel createDemoPanel(double scrap_bom, double scrap) {
        JFreeChart chart = createChart(createDataset(scrap_bom, scrap));
        return new ChartPanel(chart);
    }

    ModelVelocidade modelvelocidade = new ModelVelocidade();
    ControllerVelocidade controllerVelocidade = new ControllerVelocidade();
    ArrayList<ModelVelocidade> listaModelVelocidade = new ArrayList<>();

    private void carregatabeladdz() {
        jTable3.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jTable3.getSelectedRow();
                    button2.setEnabled(true);
                    if (selectedRow != -1) {
                        String imagePath = (String) jTable3.getValueAt(selectedRow, 6);
                        if (imagePath != null) {
                            if (imageDialog != null) {
                                imageDialog.dispose();
                            }
                            imageDialog = new JDialog();
                            JLabel imageLabel = new JLabel();
                            ImageIcon imageIcon = new ImageIcon(imagePath);
                            int width = 150;
                            int height = 150;
                            imageLabel.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
                            imageLabel.setPreferredSize(new Dimension(width, height));
                            imageDialog.add(imageLabel);
                            imageDialog.pack();
                            imageDialog.setLocationRelativeTo(null);
                            imageDialog.setLocation(new Point(imageDialog.getLocation().x - 200, imageDialog.getLocation().y));
                            imageDialog.setVisible(true);

                            // Adiciona WindowFocusListener para detectar quando o diálogo perde o foco
                            imageDialog.addWindowFocusListener(new WindowFocusListener() {
                                @Override
                                public void windowGainedFocus(WindowEvent e) {
                                    // Não fazer nada
                                }

                                @Override
                                public void windowLostFocus(WindowEvent e) {
                                    imageDialog.dispose();
                                }
                            });
                        }
                    }
                }
            }
        });

        listaModelVelocidade = controllerVelocidade.getListaVelocidadeLinhaController(linha);
        DefaultTableModel modelo = (DefaultTableModel) jTable3.getModel();
        modelo.setNumRows(0);
        int cont = listaModelVelocidade.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelVelocidade.get(i).getId(),
                listaModelVelocidade.get(i).getMaterial() + " - " + listaModelVelocidade.get(i).getBpcs(),
                listaModelVelocidade.get(i).getDesc_perfil(),
                listaModelVelocidade.get(i).getVelocidade(),
                listaModelVelocidade.get(i).getPeso(),
                listaModelVelocidade.get(i).getCusto(),
                listaModelVelocidade.get(i).getImagem()});
        }

    }

    public void verifica_ddzemsetup() {
        try {
            ddzemsetup = 0;
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "SELECT TOP 10 DDZ_Controle.ID,DDZ_Controle.MATERIAL,Cad_Material.DESC_MATERIAL,BPCS,DDZ_Controle.DATA_BASE,DDZ_Controle.CUSTO,DDZ_Controle.VELOCIDADE,DDZ_Controle.PESO  FROM DDZ_CONTROLE INNER JOIN Cad_Material ON Cad_Material.MATERIAL = DDZ_CONTROLE.MATERIAL WHERE LINHA = '" + linha + "' AND SCRAP_TOTAL is null ORDER BY DATA_BASE DESC";
            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ddzemsetup = rs.getInt("ID");
                perfil = rs.getInt("MATERIAL");
                desc_perfil = rs.getString("DESC_MATERIAL");
                bpcs = rs.getString("BPCS");
                database = rs.getString("DATA_BASE");
                peso = rs.getFloat("PESO");
                speed = rs.getFloat("VELOCIDADE");
                custo = rs.getFloat("CUSTO");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void verifica_ddzemproducao() {
        try {
            ddzemproducao = 0;
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "SELECT a.ID,a.MATERIAL,Cad_Material.DESC_MATERIAL,BPCS,a.DATA_BASE,a.CUSTO,a.VELOCIDADE,a.PESO FROM DDZ_Controle a INNER JOIN Cad_Material ON Cad_Material.MATERIAL = a.MATERIAL WHERE Linha NOT LIKE '%ATB%' AND LINHA = '" + linha + "' AND SCRAP_TOTAL != '' AND NOT EXISTS (SELECT b.id_controle FROM ddz b WHERE b.id_controle = a.id AND  b.flag = 'P') ORDER BY ID DESC";
            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ddzemproducao = rs.getInt("ID");
                perfil = rs.getInt("MATERIAL");
                desc_perfil = rs.getString("DESC_MATERIAL");
                bpcs = rs.getString("BPCS");
                database = rs.getString("DATA_BASE");
                peso = rs.getFloat("PESO");
                speed = rs.getFloat("VELOCIDADE");
                custo = rs.getFloat("CUSTO");
            }
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public void verifica_motivoparada() {
        try {
            ddzemsetup = 0;
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "SELECT TOP (1)  dbo.Causas.DESC_CAUSA, dbo.Problemas.DESC_PROBLEMA, dbo.DDZ.OBSERVACAO, dbo.DDZ_Controle.LINHA, dbo.DDZ.ID_CONTROLE "
                    + "FROM dbo.DDZ INNER JOIN "
                    + "dbo.Causas ON dbo.DDZ.ID_CAUSA_ID = dbo.Causas.ID INNER JOIN "
                    + "dbo.Problemas ON dbo.Causas.ID_PROBLEMA_ID = dbo.Problemas.ID INNER JOIN "
                    + "dbo.DDZ_Controle ON dbo.DDZ.ID_CONTROLE = dbo.DDZ_Controle.ID "
                    + "WHERE (dbo.DDZ.FLAG = 'P') AND (dbo.DDZ_Controle.LINHA = '" + linha + "') "
                    + "ORDER BY dbo.DDZ.ID_CONTROLE DESC";
            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                problema = rs.getString("DESC_CAUSA");
                causa = rs.getString("DESC_PROBLEMA");
                obs_problema = rs.getString("OBSERVACAO");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void ultimoddz() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "SELECT top 1 * from Qry_DdzLinha where MAT_LINHA LIKE '%" + linha + "%' and ID_CONTROLE =(select top 1 id_controle from Qry_DdzLinha where MAT_LINHA LIKE '%" + linha + "%' and flag = 'P'  ORDER BY ID DESC) ";
            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                lbPerfil.setText(rs.getString("ID_M_MATERIAL"));
                lbInicio.setText(new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("DATA_INPUT")) + " - " + (new SimpleDateFormat("HH:mm:ss").format(rs.getTime("HORA_INPUT"))));
                velocidade = rs.getFloat("VELOCIDADE");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "SELECT * from Qry_DdzLinha where MAT_LINHA LIKE '%" + linha + "%' and  ID_CONTROLE =(select top 1 id_controle from Qry_DdzLinha where MAT_LINHA LIKE '%" + linha + "%' and  flag = 'P'  ORDER BY ID DESC) ";
            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                lbPerfil.setText(rs.getString("ID_M_MATERIAL"));
                lbTermino.setText(new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("DATA_INPUT")) + " - " + (new SimpleDateFormat("HH:mm:ss").format(rs.getTime("HORA_INPUT"))));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "SELECT  SUM(QTD_SCRAP) as TOTAL_SCRAP_M from Qry_DdzLinha where MAT_LINHA LIKE '%" + linha + "%' and  ID_CONTROLE =(select top 1 id_controle from Qry_DdzLinha where MAT_LINHA LIKE '%" + linha + "%' and  flag = 'P'  ORDER BY ID DESC)  ";
            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                scrap = rs.getFloat("TOTAL_SCRAP_M");
                lbScrap.setText(String.valueOf(String.format("%1$,.0f m", rs.getFloat("TOTAL_SCRAP_M"))));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void calculahora() {
        lbMBons.setText(calcularMinutosProduzidos(lbInicio, lbTermino, velocidade));
    }

    private void calculapercent(Double minutosBons, Double minutosScrap) {
        Double porcScrap = (minutosScrap / minutosBons) * 100;
        progress2.setMaximum(10000);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        int valor = (int) Math.round(porcScrap * 100);
        progress2.setValue(valor);
        progress2.setString(decimalFormat.format(porcScrap) + "%");
        progress2.start();
    }

    private void alteraddzTryOut(String flag) {
        try {
            
            Connection con = new ConexaoSql().getCon();

            String query1 = "UPDATE DDZ_TryOut SET TRY_OUT = ? WHERE LINHA = ?";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, flag);
            st.setString(2, linha);

            st.executeUpdate();
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            // Trate a exceção de acordo com suas necessidades
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
            java.util.logging.Logger.getLogger(ViewDdzControle.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewDdzControle.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewDdzControle.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewDdzControle.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewDdzControle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.cooperstandard.swing.Button button1;
    private com.cooperstandard.swing.Button button2;
    private com.cooperstandard.swing.Button button3;
    private com.cooperstandard.swing.Button button4;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel lbInicio;
    private javax.swing.JLabel lbMBons;
    private javax.swing.JLabel lbPerfil;
    private javax.swing.JLabel lbScrap;
    private javax.swing.JLabel lbTermino;
    private com.cooperstandard.swing.MyTextField myTextField1;
    private com.cooperstandard.swing.progress.Progress progress2;
    private com.cooperstandard.swing.RoundPanel roundPanel1;
    private com.cooperstandard.swing.RoundPanel roundPanel2;
    private com.cooperstandard.swing.RoundPanel roundPanel3;
    private com.cooperstandard.swing.RoundPanel roundPanel4;
    private com.cooperstandard.swing.RoundPanel roundPanel5;
    private com.cooperstandard.swing.RoundPanel roundPanel6;
    private com.cooperstandard.customtable.TableScrollButton tableScrollButton1;
    // End of variables declaration//GEN-END:variables
}

package com.cooperstandard.views.extrusao;

import com.cooperstandard.controller.extrusao.ControllerDdzControle;
import com.cooperstandard.controller.extrusao.ControllerLinha;
import com.cooperstandard.controller.extrusao.ControllerUsuario;
import com.cooperstandard.model.ModelCausas;
import com.cooperstandard.model.ModelDdzControle;
import com.cooperstandard.model.ModelLinha;
import com.cooperstandard.model.ModelMaterial;
import com.cooperstandard.model.ModelProblema;
import com.cooperstandard.model.ModelSessaoUsuario;
import com.cooperstandard.model.ModelUsuario;
import com.cooperstandard.util.ButtonColumnDdzControle;
import com.cooperstandard.util.EstiloTablaRenderer;
import com.cooperstandard.util.HeaderRenderer;
import com.cooperstandard.views.principal.AguardeAbrindo;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 * @author rsouza10
 */
public class ViewDdzGerenciador extends javax.swing.JFrame {

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
    final AguardeAbrindo carregando = new AguardeAbrindo();

    public ViewDdzGerenciador() {
        initComponents();
        jButton1.setVisible(false);
        listarLinha();
        configurar();
        ultimoddz();
        carregatabela();
        ButtonColumnDdzControle b = new ButtonColumnDdzControle(jTable2, 4);
        jTable2.getTableHeader().setDefaultRenderer(new HeaderRenderer(jTable2));
        jTable2.setDefaultRenderer(String.class, new EstiloTablaRenderer());
        jTable2.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
        jTable2.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        LimpaCampo();
        calculahora();
        jPanel5.add(createDemoPanel(scrap_bom, scrap)).setSize(new java.awt.Dimension((int) jPanel5.getSize().getWidth(), (int) jPanel5.getSize().getHeight()));
        jPanel5.setVisible(true);
        calculaporc(scrap_bom, scrap);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cbLinha = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cbPerfil = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtDescPerfil = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbImagem = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbInicio = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbPerfil = new javax.swing.JLabel();
        lbMBons = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        lbScrap = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbTermino = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(2, 83, 161));

        jPanel2.setBackground(new java.awt.Color(241, 176, 19));

        cbLinha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLinhaActionPerformed(evt);
            }
        });

        jLabel1.setText("Linha:");

        cbPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPerfilActionPerformed(evt);
            }
        });

        jLabel2.setText("Perfil:");

        txtDescPerfil.setEditable(false);
        txtDescPerfil.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDescPerfil.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel8.setText("Descrição");

        jPanel3.setBackground(new java.awt.Color(94, 94, 117));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbImagem.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbImagem, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lbImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cbLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtDescPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel8))
                            .addComponent(txtDescPerfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Linha", "Perfil", "Data", "Botão"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
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
        jTable2.setGridColor(new java.awt.Color(255, 255, 255));
        jTable2.setRowHeight(22);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable2);

        jButton1.setText("Registrar DDZ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DDZ em aberto:");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Replace_16px.png"))); // NOI18N
        jButton2.setText("Atualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(489, 489, 489)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Último DDZ lançado");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("Início:");

        lbInicio.setForeground(new java.awt.Color(255, 0, 0));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("Perfil:");

        lbPerfil.setForeground(new java.awt.Color(255, 0, 0));
        lbPerfil.setText("SASA");

        lbMBons.setForeground(new java.awt.Color(255, 0, 0));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Total produzido");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("% Scrap");

        lbScrap.setForeground(new java.awt.Color(255, 0, 0));
        lbScrap.setText("SASA");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 0));
        jLabel18.setText("Término:");

        lbTermino.setForeground(new java.awt.Color(255, 0, 0));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Bons:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Scrap:");

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("20%");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator3)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 140, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbTermino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbMBons, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(20, 20, 20))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbScrap, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49))))))
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbPerfil))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTermino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbMBons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbScrap)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(384, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 620, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                txtDescPerfil.setText(rs.getString("DESC_MATERIAL"));
                ImprimiImagem(rs.getString("IMAGE"));
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_cbPerfilActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VerificaPerfilAberto();
        if (cbLinha.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!");
            cbLinha.requestFocus();
        } else if (cbPerfil.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!");
            cbPerfil.requestFocus();
        } else if (verifica == 1) {
            JOptionPane.showMessageDialog(null, "Já existe um DDZ aberto para esse perfil!", "Erro", JOptionPane.WARNING_MESSAGE);
        } else {
            salvaDDZ();
            pegaid();
            final AguardeAbrindo abrindo = new AguardeAbrindo();
            abrindo.setVisible(true);
            Thread t = new Thread() {
                public void run() {
                    new ViewEntradaDadosDDZ(cbPerfil.getSelectedItem().toString(), id_conrtole, cbLinha.getSelectedItem().toString(), "Nao").setVisible(true);
                    abrindo.dispose();
                }
            };
            t.start();
            dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        carregatabela();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        carregatabela();
    }//GEN-LAST:event_formWindowGainedFocus

    public void ImprimiImagem(String imagem) {
        ImageIcon img = new ImageIcon(imagem);
        lbImagem.setIcon(img);
        ImageIcon image = new ImageIcon(imagem);
        lbImagem.setIcon(new ImageIcon(image.getImage().getScaledInstance(lbImagem.getWidth(), lbImagem.getHeight(), Image.SCALE_DEFAULT)));
    }

    private void listarLinha() {
        if (id_planta == 2) {
            listaModelLinha = controllerLinha.getListaLinhaATBDDZController();
        } else {
            listaModelLinha = controllerLinha.getListaLinhaDDZController();
        }
        cbLinha.removeAllItems();
        for (int i = 0; i < listaModelLinha.size(); i++) {
            cbLinha.addItem(listaModelLinha.get(i).getLinha());
        }
    }

    private void LimpaCampo() {
//        cbLinha.setSelectedIndex(-1);
        cbPerfil.setSelectedIndex(-1);
        txtDescPerfil.setText("");
    }

    private boolean salvaDDZ() {
        modelddz.setMaterial(Integer.parseInt(cbPerfil.getSelectedItem().toString().split(" - ")[0]));
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.s");
        Date data = new Date();
        modelddz.setData_base(format.format(data));
        modelddz.setLinha(cbLinha.getSelectedItem().toString());
        if (controllerDdzControle.salvarDdzControleController(modelddz) > 0) {
            JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
            carregatabela();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao tentar gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void carregatabela() {
        if (id_planta == 2) {
            listaModelDdzControle = controllerDdzControle.getListaDdzATBControleController();
        } else {
            listaModelDdzControle = controllerDdzControle.getListaDdzControleController(linha);
        }
        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
        modelo.setNumRows(0);
        int cont = listaModelDdzControle.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelDdzControle.get(i).getId(),
                listaModelDdzControle.get(i).getLinha(),
                listaModelDdzControle.get(i).getMaterial(),
                LocalDateTime.parse(listaModelDdzControle.get(i).getData_base().substring(0, 19), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),});
        }
    }

    private void pegaid() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select top (1) ID from DDZ_Controle order by id desc";
            PreparedStatement st = con.prepareStatement(query1);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                id_conrtole = rs.getInt("ID");
            }
        } catch (Exception e) {

        }
    }

    public void VerificaPerfilAberto() {
        String perfil = cbPerfil.getSelectedItem().toString();
        for (int i = 0; i < jTable2.getRowCount(); i++) {
            String tb = jTable2.getValueAt(i, 2).toString();
            if ((perfil).contains(tb)) {
                verifica = 1;
                break;
            } else {
                verifica = 0;
            }
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
                cbLinha.setEnabled(false);
                cbLinha.setSelectedItem("L04");
                break;
            case "DDZL6":
                linha = "L06";
                cbLinha.setEnabled(false);
                cbLinha.setSelectedItem("L06");
                break;
            case "DDZL7":
                linha = "L07";
                cbLinha.setEnabled(false);
                cbLinha.setSelectedItem("L07");
                break;
            case "DDZL8":
                linha = "L08";
                cbLinha.setEnabled(false);
                cbLinha.setSelectedItem("L08");
                break;
            case "DDZL9":
                linha = "L09";
                cbLinha.setEnabled(false);
                cbLinha.setSelectedItem("L09");
                break;
            case "DDZL11":
                linha = "L11";
                cbLinha.setEnabled(false);
                cbLinha.setSelectedItem("L11");
                break;
            case "DDZL12":
                linha = "L12";
                cbLinha.setEnabled(false);
                cbLinha.setSelectedItem("L12");
                break;
            case "DDZL17":
                linha = "L17";
                cbLinha.setEnabled(false);
                cbLinha.setSelectedItem("L17");
                break;
            case "DDZL19":
                linha = "L19";
                cbLinha.setEnabled(false);
                cbLinha.setSelectedItem("L19");
                break;
            case "DDZL27":
                linha = "L27";
                cbLinha.setEnabled(false);
                cbLinha.setSelectedItem("L27");
                break;
            case "DDZL26":
                linha = "L26";
                cbLinha.setEnabled(false);
                cbLinha.setSelectedItem("L26");
                break;
            case "DDZL28":
                linha = "L28";
                cbLinha.setEnabled(false);
                cbLinha.setSelectedItem("L28");
                break;
            default:
                linha = "L";
                break;
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

    private String calcularMinutosProduzidos(JLabel labelDataInicial, JLabel labelDataFinal, float velocidade) {
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

    private void calculaporc(Double minutosBons, Double minutosScrap) {
        Double porcScrap = (minutosScrap / minutosBons) * 100;
        jLabel11.setText(String.format("%1$,.1f", porcScrap) + " %");
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
            java.util.logging.Logger.getLogger(ViewDdzGerenciador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewDdzGerenciador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewDdzGerenciador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewDdzGerenciador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewDdzGerenciador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbLinha;
    private javax.swing.JComboBox<String> cbPerfil;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lbImagem;
    private javax.swing.JLabel lbInicio;
    private javax.swing.JLabel lbMBons;
    private javax.swing.JLabel lbPerfil;
    private javax.swing.JLabel lbScrap;
    private javax.swing.JLabel lbTermino;
    private javax.swing.JTextField txtDescPerfil;
    // End of variables declaration//GEN-END:variables
}

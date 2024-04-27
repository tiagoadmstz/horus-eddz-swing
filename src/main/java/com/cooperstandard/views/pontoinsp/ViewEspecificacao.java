package com.cooperstandard.views.pontoinsp;

import com.cooperstandard.views.extrusao.*;
import com.cooperstandard.util.Mascaras;
import com.cooperstandard.controller.extrusao.ControllerComposto;
import com.cooperstandard.controller.extrusao.ControllerEquipamento;
import com.cooperstandard.controller.extrusao.ControllerMaterial;
import com.cooperstandard.controller.extrusao.ControllerUnidFreq;
import com.cooperstandard.controller.extrusao.ControllerUnidMedida;
import com.cooperstandard.controller.pontoinsp.ControllerEspecLab;
import com.cooperstandard.controller.pontoinsp.ControllerTeste;
import com.cooperstandard.model.ModelComposto;
import com.cooperstandard.model.ModelEquipamento;
import com.cooperstandard.model.ModelEspecLab;
import com.cooperstandard.model.ModelMaterial;
import com.cooperstandard.model.ModelTeste;
import com.cooperstandard.model.ModelUnidFreq;
import com.cooperstandard.model.ModelUnidMedida;
import com.cooperstandard.util.ControleInstancias;
import com.cooperstandard.util.HeaderRenderer;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rsouza10
 */
public final class ViewEspecificacao extends javax.swing.JFrame {

    private static final long serialVersionUID = -2633970475618354793L;

    ModelEspecLab modelEspecLab = new ModelEspecLab();
    ControllerEspecLab controllerEspecLab = new ControllerEspecLab();
    ArrayList<ModelEspecLab> listaModelEspecLab = new ArrayList<>();
    ControllerTeste controllerTeste = new ControllerTeste();
    ArrayList<ModelTeste> listaModelTeste = new ArrayList<>();
    ControllerEquipamento controllerEquipamento = new ControllerEquipamento();
    ArrayList<ModelEquipamento> listaModelEquipamento = new ArrayList<>();
    ControllerComposto controllerComposto = new ControllerComposto();
    ArrayList<ModelComposto> listaModelComposto = new ArrayList<>();
    ControllerMaterial controllerMaterial = new ControllerMaterial();
    ArrayList<ModelMaterial> listaModelMaterial = new ArrayList<>();
    ControllerUnidFreq controllerUnidFreq = new ControllerUnidFreq();
    ArrayList<ModelUnidFreq> listaModelUnidFreq = new ArrayList<>();
    ControllerUnidMedida controllerUnidMedida = new ControllerUnidMedida();
    ArrayList<ModelUnidMedida> listaModelUnidMedida = new ArrayList<>();
    String perfil;
    String divisao;
    String atributo = "false";
    String inf = "false";
    String sup = "false";
    String bilateral = "false";
    String informativo = "false";
    String cod_teste = "false";

    public ViewEspecificacao() {
        initComponents();
    }

    public ViewEspecificacao(String _perfil) {
        initComponents();
        perfil = _perfil;
        txtMaterial.setText(perfil);
        this.carregaEspecLab();
        this.listarUnidadeMedida();
        this.limparDados();
        listarTeste();
        tbEspec.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbEspec));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtEspecTexto = new javax.swing.JTextField();
        lbReferencia = new javax.swing.JLabel();
        cbTeste = new javax.swing.JComboBox<>();
        cbReferencia = new javax.swing.JComboBox<>();
        lbTeste = new javax.swing.JLabel();
        lbTipo = new javax.swing.JLabel();
        lbEquipamento = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        lbEspecMin = new javax.swing.JLabel();
        lbObs = new javax.swing.JLabel();
        lbEspecMax = new javax.swing.JLabel();
        txtObs = new javax.swing.JTextField();
        cbUnidMed = new javax.swing.JComboBox<>();
        lbUnidMed = new javax.swing.JLabel();
        lbPerfil = new javax.swing.JLabel();
        lbEspecTexto = new javax.swing.JLabel();
        lbOrdem = new javax.swing.JLabel();
        txtEspecMin = new javax.swing.JTextField();
        txtEspecMax = new javax.swing.JTextField();
        txtOrdem = new javax.swing.JSpinner();
        txtMaterial = new javax.swing.JTextField();
        lbCod = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lbId = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jcbAtributo = new javax.swing.JCheckBox();
        jcbInf = new javax.swing.JCheckBox();
        jcbSup = new javax.swing.JCheckBox();
        jcbBilateral = new javax.swing.JCheckBox();
        jcbInform = new javax.swing.JCheckBox();
        txtHist = new javax.swing.JTextField();
        lbObs1 = new javax.swing.JLabel();
        txtEquipamento = new javax.swing.JTextField();
        txtCod = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbEspec = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnSalvar1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Especificação");

        jPanel3.setBackground(new java.awt.Color(2, 83, 161));

        jPanel2.setBackground(new java.awt.Color(241, 176, 19));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtEspecTexto.setEnabled(false);

        lbReferencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbReferencia.setText("Referência:");

        cbTeste.setEnabled(false);
        cbTeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTesteActionPerformed(evt);
            }
        });

        cbReferencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        cbReferencia.setEnabled(false);

        lbTeste.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbTeste.setText("Teste:");

        lbTipo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbTipo.setText("Tipo:");

        lbEquipamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbEquipamento.setText("Equipamento:");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Min e Max", "Texto", "No Min", "No Max", "ValorUnico" }));
        cbTipo.setEnabled(false);
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });

        lbEspecMin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbEspecMin.setText("Espec Mín:");

        lbObs.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbObs.setText("Observação:");

        lbEspecMax.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbEspecMax.setText("Espec Máx:");

        txtObs.setEnabled(false);

        cbUnidMed.setEnabled(false);

        lbUnidMed.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbUnidMed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUnidMed.setText("Unidade:");

        lbPerfil.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbPerfil.setText("Perfil:");

        lbEspecTexto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbEspecTexto.setText("Espec. Texto:");

        lbOrdem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbOrdem.setText("Ordem de criação:");

        txtEspecMin.setEnabled(false);
        txtEspecMin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEspecMinFocusLost(evt);
            }
        });

        txtEspecMax.setEnabled(false);
        txtEspecMax.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEspecMaxFocusLost(evt);
            }
        });

        txtOrdem.setModel(new javax.swing.SpinnerNumberModel(0, null, null, 1000));
        txtOrdem.setEnabled(false);

        txtMaterial.setEditable(false);
        txtMaterial.setBackground(new java.awt.Color(255, 255, 204));
        txtMaterial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMaterial.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMaterial.setEnabled(false);
        txtMaterial.setFocusable(false);

        lbCod.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCod.setText("Cód. Teste:");

        txtId.setEditable(false);
        txtId.setBackground(new java.awt.Color(255, 255, 204));
        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtId.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtId.setEnabled(false);
        txtId.setFocusable(false);

        lbId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbId.setText("Código:");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-adicionar-filled-50.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-adicionar-filled-50.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        jcbAtributo.setText("Atributo");
        jcbAtributo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAtributoActionPerformed(evt);
            }
        });

        jcbInf.setText("INF");
        jcbInf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbInfActionPerformed(evt);
            }
        });

        jcbSup.setText("SUP");
        jcbSup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSupActionPerformed(evt);
            }
        });

        jcbBilateral.setText("Bilateral");
        jcbBilateral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBilateralActionPerformed(evt);
            }
        });

        jcbInform.setText("Informativo");
        jcbInform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbInformActionPerformed(evt);
            }
        });

        txtHist.setEnabled(false);

        lbObs1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbObs1.setText("Historico:");

        txtEquipamento.setEditable(false);
        txtEquipamento.setBackground(new java.awt.Color(255, 255, 204));
        txtEquipamento.setText("Laboratório");

        txtCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodKeyTyped(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-pesquisar-filled-50.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHist)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbId)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbPerfil)
                            .addComponent(txtMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbOrdem)
                            .addComponent(txtOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEquipamento)
                            .addComponent(txtEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCod)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cbTeste, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbTeste)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jcbAtributo)
                                .addGap(18, 18, 18)
                                .addComponent(jcbInf)
                                .addGap(18, 18, 18)
                                .addComponent(jcbSup)
                                .addGap(18, 18, 18)
                                .addComponent(jcbBilateral)
                                .addGap(18, 18, 18)
                                .addComponent(jcbInform)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEspecMin)
                                    .addComponent(lbEspecMin, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEspecMax, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbEspecMax))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbUnidMed, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cbUnidMed, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13)))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbEspecTexto)
                                    .addComponent(txtEspecTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbReferencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbObs)
                                    .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbObs1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbPerfil)
                                        .addComponent(lbId))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtOrdem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lbTeste)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbTeste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lbOrdem)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(lbCod)
                                        .addGap(26, 26, 26))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(lbEquipamento)
                                            .addGap(27, 27, 27))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(21, 21, 21)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel12)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(txtEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbAtributo)
                        .addComponent(jcbInf)
                        .addComponent(jcbSup)
                        .addComponent(jcbBilateral)
                        .addComponent(jcbInform))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(lbObs)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbEspecTexto)
                                .addComponent(lbReferencia))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtEspecTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(txtEspecMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(lbUnidMed)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbUnidMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbEspecMax)
                            .addComponent(lbEspecMin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEspecMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lbObs1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHist, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbEspec.setAutoCreateRowSorter(true);
        tbEspec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Ordem", "Perfil", "Desc. Teste", "Atributo", "INF", "SUP", "Bilateral", "Informativo", "Tipo", "Espec. Mín.", "Espec. Máx.", "Espec. Unid.", "Espec. Texto", "Referência", "Obseração", "Histórico"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbEspec.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbEspec.setFocusable(false);
        tbEspec.setMaximumSize(new java.awt.Dimension(83, 25));
        tbEspec.setMinimumSize(new java.awt.Dimension(83, 25));
        tbEspec.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbEspec);
        if (tbEspec.getColumnModel().getColumnCount() > 0) {
            tbEspec.getColumnModel().getColumn(0).setMinWidth(0);
            tbEspec.getColumnModel().getColumn(0).setMaxWidth(0);
            tbEspec.getColumnModel().getColumn(3).setMinWidth(200);
            tbEspec.getColumnModel().getColumn(4).setMinWidth(40);
            tbEspec.getColumnModel().getColumn(5).setMinWidth(40);
            tbEspec.getColumnModel().getColumn(6).setMinWidth(40);
            tbEspec.getColumnModel().getColumn(7).setMinWidth(40);
            tbEspec.getColumnModel().getColumn(8).setMinWidth(40);
            tbEspec.getColumnModel().getColumn(10).setMinWidth(80);
            tbEspec.getColumnModel().getColumn(11).setMinWidth(80);
            tbEspec.getColumnModel().getColumn(12).setMinWidth(110);
            tbEspec.getColumnModel().getColumn(13).setMinWidth(110);
            tbEspec.getColumnModel().getColumn(14).setMinWidth(90);
            tbEspec.getColumnModel().getColumn(15).setMinWidth(110);
            tbEspec.getColumnModel().getColumn(16).setMinWidth(150);
        }

        btnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-salvar-filled-50.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnNovo.setBackground(new java.awt.Color(255, 255, 255));
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-joyent-filled-20 (1).png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setBackground(new java.awt.Color(255, 255, 255));
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-editar-filled-50.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(255, 255, 255));
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-excluir-filled-50.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setPreferredSize(new java.awt.Dimension(97, 27));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnLimpar.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-n¦o-perturbe-filled-50.png"))); // NOI18N
        btnLimpar.setText("Cancelar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnSalvar1.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-salvar-filled-50.png"))); // NOI18N
        btnSalvar1.setText("Salvar Alteração");
        btnSalvar1.setEnabled(false);
        btnSalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-baixar-filled-50.png"))); // NOI18N
        jMenu2.setText("Reordenar Ordem");

        jMenuItem3.setText("Reordenar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
        if (cbTipo.getSelectedIndex() == -1) {
            txtEspecMin.setEnabled(false);
            txtEspecMax.setEnabled(false);
            cbUnidMed.setEnabled(false);
            txtEspecTexto.setEnabled(false);
        } else if (cbTipo.getSelectedItem().equals("Min e Max")) {
            txtEspecMin.setEnabled(true);
            txtEspecMax.setEnabled(true);
            cbUnidMed.setEnabled(true);
            txtEspecTexto.setEnabled(false);
            txtEspecTexto.setText(null);
        } else if (cbTipo.getSelectedItem().equals("Texto")) {
            txtEspecMin.setEnabled(false);
            txtEspecMin.setText("0.0");
            txtEspecMax.setEnabled(false);
            txtEspecMax.setText("0.0");
            cbUnidMed.setEnabled(false);
            cbUnidMed.setSelectedItem("");
            txtEspecTexto.setEnabled(true);
        } else if (cbTipo.getSelectedItem().equals("No Max")) {
            txtEspecMin.setEnabled(false);
            txtEspecMin.setText("0.0");
            txtEspecMax.setEnabled(true);
            cbUnidMed.setEnabled(true);
            txtEspecTexto.setEnabled(false);
            txtEspecTexto.setText(null);
        } else if (cbTipo.getSelectedItem().equals("No Min")) {
            txtEspecMin.setEnabled(true);
            txtEspecMax.setEnabled(false);
            txtEspecMax.setText("0.0");
            cbUnidMed.setEnabled(true);
            txtEspecTexto.setEnabled(false);
            txtEspecTexto.setText(null);
        } else if (cbTipo.getSelectedItem().equals("ValorUnico")) {
            txtEspecMin.setEnabled(true);
            txtEspecMax.setEnabled(false);
            txtEspecMax.setText("0.0");
            cbUnidMed.setEnabled(true);
            txtEspecTexto.setEnabled(false);
            txtEspecTexto.setText(null);
        }
    }//GEN-LAST:event_cbTipoActionPerformed

    private void txtEspecMinFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEspecMinFocusLost
        this.txtEspecMin.setText(new Mascaras().converterVirgulaParaPonto(txtEspecMin.getText()));
    }//GEN-LAST:event_txtEspecMinFocusLost

    private void txtEspecMaxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEspecMaxFocusLost
        this.txtEspecMax.setText(new Mascaras().converterVirgulaParaPonto(txtEspecMax.getText()));
    }//GEN-LAST:event_txtEspecMaxFocusLost

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        this.desabilitarCampos();
        limparDados();
        btnSalvar.setEnabled(false);
        btnSalvar1.setEnabled(false);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linhasselecionada = tbEspec.getSelectedRow();
        if (linhasselecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            this.excluirTeste();
            limparDados();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linhasselecionada = tbEspec.getSelectedRow();
        if (linhasselecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            novoProjeto();
            btnSalvar.setEnabled(true);
            btnSalvar1.setEnabled(true);
            habilitarCampos();
            recuperarEspecLab();
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        novoProjeto();
        btnSalvar.setEnabled(true);
        habilitarCampos();
        txtOrdem.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if (txtOrdem.getValue().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            txtOrdem.requestFocus();
        } else if (cbTipo.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbTipo.requestFocus();
        } else if (cbReferencia.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbReferencia.requestFocus();
        } else if (cbTeste.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbTeste.requestFocus();
        } else {
            salvarEspec();
            btnSalvar.setEnabled(false);
            btnSalvar1.setEnabled(false);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        ViewTeste vm = null;
        if (ControleInstancias.isInstaced(ViewTeste.class)) {
            vm = (ViewTeste) ControleInstancias.getInstance(ViewTeste.class.getName(), ViewTeste.class);
            vm.setSolicitante(this);
        } else {
            vm = new ViewTeste(this);
        }
        vm.setVisible(true);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        ViewUnidMed vm = null;
        if (ControleInstancias.isInstaced(ViewUnidMed.class)) {
            vm = (ViewUnidMed) ControleInstancias.getInstance(ViewUnidMed.class.getName(), ViewUnidMed.class);
            vm.setSolicitante(this);
        } else {
            vm = new ViewUnidMed(this);
        }
        vm.setVisible(true);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void cbTesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTesteActionPerformed
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select * from Qry_Teste_Insp where DESC_TESTE= ?";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbTeste.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                cod_teste = rs.getString("COD_TESTE");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbTesteActionPerformed

    private void btnSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvar1ActionPerformed

        if (txtOrdem.getValue().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            txtOrdem.requestFocus();
        } else if (cbTipo.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbTipo.requestFocus();
        } else if (cbReferencia.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbReferencia.requestFocus();
        } else if (cbTeste.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbTeste.requestFocus();
        } else {
            alterarEspecLab();
            btnSalvar.setEnabled(false);
            btnSalvar1.setEnabled(false);
        }

    }//GEN-LAST:event_btnSalvar1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        getValorOrdena().stream().forEach(mr -> controllerEspecLab.atualizarEspecLabController((ModelEspecLab) mr));
        carregaEspecLab();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void txtCodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodKeyTyped
        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select * from Qry_Teste_Insp where ORDEM Like ?  order by ORDEM asc";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, "%" + txtCod.getText() + "%");
            ResultSet rs = st.executeQuery();
            cbTeste.removeAllItems();
            while (rs.next()) {
                cbTeste.addItem(rs.getString("DESC_TESTE"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        if (txtCod.getText().equals("")) {
            listarTeste();
        }
    }//GEN-LAST:event_txtCodKeyTyped

    private void jcbAtributoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAtributoActionPerformed
        if (jcbAtributo.isSelected()) {
            jcbAtributo.setSelected(true);
            atributo = "true";
        } else {
            jcbAtributo.setSelected(false);
            atributo = "false";
        }
    }//GEN-LAST:event_jcbAtributoActionPerformed

    private void jcbInfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbInfActionPerformed
        if (jcbInf.isSelected()) {
            jcbInf.setSelected(true);
            inf = "true";
        } else {
            jcbInf.setSelected(false);
            inf = "false";
        }
    }//GEN-LAST:event_jcbInfActionPerformed

    private void jcbSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSupActionPerformed
        if (jcbSup.isSelected()) {
            jcbSup.setSelected(true);
            sup = "true";
        } else {
            jcbSup.setSelected(false);
            sup = "false";
        }
    }//GEN-LAST:event_jcbSupActionPerformed

    private void jcbBilateralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBilateralActionPerformed
        if (jcbBilateral.isSelected()) {
            jcbBilateral.setSelected(true);
            bilateral = "true";
        } else {
            jcbBilateral.setSelected(false);
            bilateral = "false";
        }
    }//GEN-LAST:event_jcbBilateralActionPerformed

    private void jcbInformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbInformActionPerformed
        if (jcbInform.isSelected()) {
            jcbInform.setSelected(true);
            informativo = "true";
            cbReferencia.setSelectedItem("Sim");
        } else {
            jcbInform.setSelected(false);
            informativo = "false";
            cbReferencia.setSelectedItem("Não");
        }
    }//GEN-LAST:event_jcbInformActionPerformed

    public void addItemLista(String item) {
        cbTeste.addItem(item);
        cbUnidMed.addItem(item);
        listarTeste();
        listarMaterial();
        listarUnidadeMedida();
    }

    private void listarTeste() {
        listaModelTeste = controllerTeste.getListaTesteController();
        cbTeste.removeAllItems();
        for (int i = 0; i < listaModelTeste.size(); i++) {
            cbTeste.addItem(listaModelTeste.get(i).getDesc_teste());
        }
    }

    private void listarMaterial() {
        listaModelMaterial = controllerMaterial.getListaMaterialController();
    }

    private void listarUnidadeMedida() {
        listaModelUnidMedida = controllerUnidMedida.getListaUnidMedidaController();
        cbUnidMed.removeAllItems();
        cbUnidMed.addItem("");
        for (int i = 0; i < listaModelUnidMedida.size(); i++) {
            cbUnidMed.addItem(String.valueOf(listaModelUnidMedida.get(i).getUnidade_medida()));
        }
    }

    private void excluirTeste() {
        int linhatb = tbEspec.getSelectedRow();
        String nome = (String) tbEspec.getValueAt(linhatb, 3);
        int codigo = (Integer) tbEspec.getValueAt(linhatb, 0);
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
                + " excluir o registro \nNome: "
                + nome + " ?", "Atenção", JOptionPane.YES_OPTION);

        if (opcao == JOptionPane.OK_OPTION) {
            if (controllerEspecLab.excluirEspecLabController(codigo)) {
                JOptionPane.showMessageDialog(this, "Registro excluido com sucesso!");
                carregaEspecLab();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean salvarEspec() {
        String tipo_teste = cbTipo.getSelectedItem().toString();
        modelEspecLab.setId_material_id(this.txtMaterial.getText());
        modelEspecLab.setOrdem(Integer.parseInt(this.txtOrdem.getValue().toString()));
        modelEspecLab.setId_teste_id(cod_teste);
        modelEspecLab.setAtributo(atributo);
        modelEspecLab.setInf(inf);
        modelEspecLab.setSup(sup);
        modelEspecLab.setBilateral(bilateral);
        modelEspecLab.setInformativo(informativo);
        modelEspecLab.setTipo_espec(this.cbTipo.getSelectedItem().toString());
        modelEspecLab.setMinimo(Float.valueOf(this.txtEspecMin.getText()));
        modelEspecLab.setMaximo(Float.valueOf(this.txtEspecMax.getText()));
        modelEspecLab.setUnid_medida(this.cbUnidMed.getSelectedItem().toString());
        modelEspecLab.setTexto(this.txtEspecTexto.getText());
        modelEspecLab.setReferencia(this.cbReferencia.getSelectedItem().toString());
        modelEspecLab.setObservacao(this.txtObs.getText());
        modelEspecLab.setHistorico(this.txtHist.getText());
        if (tipo_teste.contains("Min e Max")) {
            if (cbReferencia.getSelectedItem().equals("Sim")) {
                modelEspecLab.setEspec_completo(this.txtEspecMin.getText() + " à " + this.txtEspecMax.getText() + " " + this.cbUnidMed.getSelectedItem().toString() + " " + "(referência*)");
            } else {
                modelEspecLab.setEspec_completo(this.txtEspecMin.getText() + " à " + this.txtEspecMax.getText() + " " + this.cbUnidMed.getSelectedItem().toString());
            }
        } else {
            if (tipo_teste.contains("Texto")) {
                if (cbReferencia.getSelectedItem().equals("Sim")) {
                    modelEspecLab.setEspec_completo(this.txtEspecTexto.getText() + " " + "(referência*)");
                } else {
                    modelEspecLab.setEspec_completo(txtEspecTexto.getText());
                }
            }
            if (tipo_teste.contains("No Max")) {
                if (cbReferencia.getSelectedItem().equals("Sim")) {
                    modelEspecLab.setEspec_completo("Máx. " + this.txtEspecMax.getText() + " " + this.cbUnidMed.getSelectedItem().toString() + " " + "(referência*)");
                } else {
                    modelEspecLab.setEspec_completo("Máx. " + this.txtEspecMax.getText() + " " + this.cbUnidMed.getSelectedItem().toString());
                }
            }
            if (tipo_teste.contains("No Min")) {
                if (cbReferencia.getSelectedItem().equals("Sim")) {
                    modelEspecLab.setEspec_completo("Min. " + this.txtEspecMin.getText() + " " + this.cbUnidMed.getSelectedItem().toString() + " " + "(referência*)");
                } else {
                    modelEspecLab.setEspec_completo("Min. " + this.txtEspecMin.getText() + " " + this.cbUnidMed.getSelectedItem().toString());
                }
            }
            if (tipo_teste.contains("ValorUnico")) {
                if (cbReferencia.getSelectedItem().equals("Sim")) {
                    modelEspecLab.setEspec_completo(this.txtEspecMin.getText() + " " + this.cbUnidMed.getSelectedItem().toString() + " " + "(referência*)");
                } else {
                    modelEspecLab.setEspec_completo(this.txtEspecMin.getText() + " " + this.cbUnidMed.getSelectedItem().toString());
                }
            }
        }
        if (controllerEspecLab.salvarEspecLabController(modelEspecLab) > 0) {
            JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
            this.desabilitarCampos();
            this.carregaEspecLab();
            this.carregaEspecLab();
            limparDados();
            return true;
        } else {

            JOptionPane.showMessageDialog(this, "Erro ao tentar gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;

        }

    }

    private boolean recuperarEspecLab() {
        limparDados();
        int linhatb = this.tbEspec.getSelectedRow();
        int codigo = (Integer) tbEspec.getValueAt(linhatb, 0);
        try {
            modelEspecLab = controllerEspecLab.getEspecLabController(codigo);
            this.txtId.setText(String.valueOf(modelEspecLab.getId()));
            this.txtOrdem.setValue(modelEspecLab.getOrdem());
            this.txtEquipamento.setText("Laboratório");
            this.txtCod.setText(modelEspecLab.getCod_teste());
            this.cbTeste.setSelectedItem(modelEspecLab.getDesc_teste());
            if (modelEspecLab.getAtributo().equals("true")) {
                jcbAtributo.setSelected(true);
                atributo = "true";
            }
            if (modelEspecLab.getInf().equals("true")) {
                jcbInf.setSelected(true);
                inf = "true";
            }
            if (modelEspecLab.getSup().equals("true")) {
                jcbSup.setSelected(true);
                sup = "true";
            }
            if (modelEspecLab.getBilateral().equals("true")) {
                jcbBilateral.setSelected(true);
                bilateral = "true";
            }
            if (modelEspecLab.getInformativo().equals("true")) {
                jcbInform.setSelected(true);
                informativo = "true";
            }
            this.cbTipo.setSelectedItem(modelEspecLab.getTipo_espec());
            this.txtEspecMin.setText(String.valueOf(modelEspecLab.getMinimo()));
            this.txtEspecMax.setText(String.valueOf(modelEspecLab.getMaximo()));
            this.cbUnidMed.setSelectedItem(modelEspecLab.getUnid_medida());
            this.txtEspecTexto.setText(modelEspecLab.getTexto());
            this.cbReferencia.setSelectedItem(modelEspecLab.getReferencia());
            this.txtObs.setText(modelEspecLab.getObservacao());
            this.txtHist.setText(modelEspecLab.getHistorico());
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código inválido ou nenhum registro selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
            btnSalvar.setEnabled(true);
            btnSalvar1.setEnabled(true);
            return false;
        }
    }

    private boolean alterarEspecLab() {
        String tipo_teste = cbTipo.getSelectedItem().toString();
        modelEspecLab.setId_material_id(this.txtMaterial.getText());
        modelEspecLab.setOrdem(Integer.parseInt(this.txtOrdem.getValue().toString()));
        modelEspecLab.setId_teste_id(cod_teste);
        modelEspecLab.setAtributo(atributo);
        modelEspecLab.setInf(inf);
        modelEspecLab.setSup(sup);
        modelEspecLab.setBilateral(bilateral);
        modelEspecLab.setInformativo(informativo);
        modelEspecLab.setTipo_espec(this.cbTipo.getSelectedItem().toString());
        modelEspecLab.setMinimo(Float.valueOf(this.txtEspecMin.getText()));
        modelEspecLab.setMaximo(Float.valueOf(this.txtEspecMax.getText()));
        modelEspecLab.setUnid_medida(this.cbUnidMed.getSelectedItem().toString());
        modelEspecLab.setTexto(this.txtEspecTexto.getText());
        modelEspecLab.setReferencia(this.cbReferencia.getSelectedItem().toString());
        modelEspecLab.setObservacao(this.txtObs.getText());
        modelEspecLab.setHistorico(this.txtHist.getText());
        if (tipo_teste.contains("Min e Max")) {
            if (cbReferencia.getSelectedItem().equals("Sim")) {
                modelEspecLab.setEspec_completo(this.txtEspecMin.getText() + " à " + this.txtEspecMax.getText() + " " + this.cbUnidMed.getSelectedItem().toString() + " " + "(referência*)");
            } else {
                modelEspecLab.setEspec_completo(this.txtEspecMin.getText() + " à " + this.txtEspecMax.getText() + " " + this.cbUnidMed.getSelectedItem().toString());
            }
        } else {
            if (tipo_teste.contains("Texto")) {
                if (cbReferencia.getSelectedItem().equals("Sim")) {
                    modelEspecLab.setEspec_completo(this.txtEspecTexto.getText() + " " + "(referência*)");
                } else {
                    modelEspecLab.setEspec_completo(txtEspecTexto.getText());
                }
            }
            if (tipo_teste.contains("No Max")) {
                if (cbReferencia.getSelectedItem().equals("Sim")) {
                    modelEspecLab.setEspec_completo("Máx. " + this.txtEspecMax.getText() + " " + this.cbUnidMed.getSelectedItem().toString() + " " + "(referência*)");
                } else {
                    modelEspecLab.setEspec_completo("Máx. " + this.txtEspecMax.getText() + " " + this.cbUnidMed.getSelectedItem().toString());
                }
            }
            if (tipo_teste.contains("No Min")) {
                if (cbReferencia.getSelectedItem().equals("Sim")) {
                    modelEspecLab.setEspec_completo("Min. " + this.txtEspecMin.getText() + " " + this.cbUnidMed.getSelectedItem().toString() + " " + "(referência*)");
                } else {
                    modelEspecLab.setEspec_completo("Min. " + this.txtEspecMin.getText() + " " + this.cbUnidMed.getSelectedItem().toString());
                }
            }
            if (tipo_teste.contains("ValorUnico")) {
                if (cbReferencia.getSelectedItem().equals("Sim")) {
                    modelEspecLab.setEspec_completo(this.txtEspecMin.getText() + " " + this.cbUnidMed.getSelectedItem().toString() + " " + "(referência*)");
                } else {
                    modelEspecLab.setEspec_completo(this.txtEspecMin.getText() + " " + this.cbUnidMed.getSelectedItem().toString());
                }
            }
        }
        if (controllerEspecLab.atualizarEspecLabController(modelEspecLab)) {
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
            this.desabilitarCampos();
            this.carregaEspecLab();
            limparDados();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {

        }

    }

    private void carregaEspecLab() {
        listaModelEspecLab = controllerEspecLab.getListaEspecLabController(perfil);
        DefaultTableModel modelo = (DefaultTableModel) tbEspec.getModel();
        modelo.setNumRows(0);
        int cont = listaModelEspecLab.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelEspecLab.get(i).getId(),
                listaModelEspecLab.get(i).getOrdem(),
                listaModelEspecLab.get(i).getId_material_id(),
                listaModelEspecLab.get(i).getDesc_teste(),
                listaModelEspecLab.get(i).getAtributo(),
                listaModelEspecLab.get(i).getInf(),
                listaModelEspecLab.get(i).getSup(),
                listaModelEspecLab.get(i).getBilateral(),
                listaModelEspecLab.get(i).getInformativo(),
                listaModelEspecLab.get(i).getTipo_espec(),
                listaModelEspecLab.get(i).getMinimo(),
                listaModelEspecLab.get(i).getMaximo(),
                listaModelEspecLab.get(i).getUnid_medida(),
                listaModelEspecLab.get(i).getTexto(),
                listaModelEspecLab.get(i).getReferencia(),
                listaModelEspecLab.get(i).getObservacao(),
                listaModelEspecLab.get(i).getHistorico()
            });
        }
    }

    public void desabilitarCampos() {
        cbTeste.setEnabled(false);
        txtObs.setEnabled(false);
        cbTipo.setEnabled(false);
        cbReferencia.setEnabled(false);
        txtCod.setEnabled(false);
        txtHist.setEnabled(false);
        jcbAtributo.setSelected(false);
        jcbInf.setSelected(false);
        jcbSup.setSelected(false);
        jcbBilateral.setSelected(false);
        jcbInform.setSelected(false);
    }

    public void limparDados() {
        txtId.setText("");
        txtOrdem.setValue(0);
        cbTeste.setSelectedIndex(-1);
        txtCod.setText("");
        txtObs.setText("");
        cbTipo.setSelectedIndex(-1);
        txtEspecMin.setText("");
        txtEspecMax.setText("");
        cbUnidMed.setSelectedIndex(-1);
        txtEspecTexto.setText("");
        txtHist.setText("");
        jcbAtributo.setSelected(false);
        jcbInf.setSelected(false);
        jcbSup.setSelected(false);
        jcbBilateral.setSelected(false);
        jcbInform.setSelected(false);
        inf = "false";
        atributo = "false";
        sup = "false";
        bilateral = "false";
        informativo = "false";
    }

    public void novoProjeto() {
        habilitarCampos();
        txtId.setText("Novo");
        txtOrdem.setValue(0);
        cbTeste.setSelectedIndex(-1);
        txtCod.setText("");
        txtObs.setText("");
        cbTipo.setSelectedIndex(-1);
        txtEspecMin.setText("");
        txtEspecMax.setText("");
        cbUnidMed.setSelectedIndex(-1);
        txtEspecTexto.setText("");
        txtHist.setText("");
        jcbAtributo.setSelected(false);
        jcbInf.setSelected(false);
        jcbSup.setSelected(false);
        jcbBilateral.setSelected(false);
        jcbInform.setSelected(false);
    }

    public void habilitarCampos() {
        txtOrdem.setEnabled(true);
        cbTeste.setEnabled(true);
        txtObs.setEnabled(true);
        cbTipo.setEnabled(true);
        cbReferencia.setEnabled(true);
        txtCod.setEnabled(true);
        txtHist.setEnabled(true);
    }

    private ModelEspecLab getModelOrdena(int row) {
        int valor = 0;
        for (int i = 0; i < tbEspec.getRowCount(); i++) {
            tbEspec.setValueAt(valor += 1000, i, 1);
        }
        int teste = (Integer) tbEspec.getValueAt(row, 1);
        int codigo = (Integer) tbEspec.getValueAt(row, 0);
        modelEspecLab = controllerEspecLab.getEspecLabController(codigo);
        modelEspecLab.setOrdem(teste);
        if (controllerEspecLab.atualizarEspecLabController(modelEspecLab)) {
            return null;
        }
        return null;
    }

    public List<Object> getValorOrdena() {
        List<Object> lista = new ArrayList();
        for (int i = 0; i < tbEspec.getRowCount(); i++) {
            Object ob = getModelOrdena(i);
            if (ob != null) {
                lista.add(ob);
            }
        }
        return lista;
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
            java.util.logging.Logger.getLogger(ViewEspecificacao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewEspecificacao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewEspecificacao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewEspecificacao.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewEspecificacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSalvar1;
    private javax.swing.JComboBox<String> cbReferencia;
    private javax.swing.JComboBox<String> cbTeste;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JComboBox<String> cbUnidMed;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox jcbAtributo;
    private javax.swing.JCheckBox jcbBilateral;
    private javax.swing.JCheckBox jcbInf;
    private javax.swing.JCheckBox jcbInform;
    private javax.swing.JCheckBox jcbSup;
    private javax.swing.JLabel lbCod;
    private javax.swing.JLabel lbEquipamento;
    private javax.swing.JLabel lbEspecMax;
    private javax.swing.JLabel lbEspecMin;
    private javax.swing.JLabel lbEspecTexto;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbObs;
    private javax.swing.JLabel lbObs1;
    private javax.swing.JLabel lbOrdem;
    private javax.swing.JLabel lbPerfil;
    private javax.swing.JLabel lbReferencia;
    private javax.swing.JLabel lbTeste;
    private javax.swing.JLabel lbTipo;
    private javax.swing.JLabel lbUnidMed;
    private javax.swing.JTable tbEspec;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtEquipamento;
    private javax.swing.JTextField txtEspecMax;
    private javax.swing.JTextField txtEspecMin;
    private javax.swing.JTextField txtEspecTexto;
    private javax.swing.JTextField txtHist;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMaterial;
    private javax.swing.JTextField txtObs;
    private javax.swing.JSpinner txtOrdem;
    // End of variables declaration//GEN-END:variables
}

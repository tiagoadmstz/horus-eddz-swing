package com.cooperstandard.views.extrusao;

import com.cooperstandard.util.Mascaras;
import com.cooperstandard.controller.extrusao.ControllerComposto;
import com.cooperstandard.controller.extrusao.ControllerEquipamento;
import com.cooperstandard.controller.extrusao.ControllerFichaControle;
import com.cooperstandard.controller.extrusao.ControllerMaterial;
import com.cooperstandard.controller.extrusao.ControllerTeste;
import com.cooperstandard.controller.extrusao.ControllerUnidFreq;
import com.cooperstandard.controller.extrusao.ControllerUnidMedida;
import com.cooperstandard.views.principal.AguardeGerandoRelatório;
import com.cooperstandard.model.ModelComposto;
import com.cooperstandard.model.ModelEquipamento;
import com.cooperstandard.model.ModelFichaControle;
import com.cooperstandard.model.ModelMaterial;
import com.cooperstandard.model.ModelTeste;
import com.cooperstandard.model.ModelUnidFreq;
import com.cooperstandard.model.ModelUnidMedida;
import com.cooperstandard.util.ControleInstancias;
import com.cooperstandard.util.CustomRenderer;
import com.cooperstandard.util.Datas;
import com.cooperstandard.util.EstiloTablaRenderer2;
import com.cooperstandard.util.HeaderRenderer;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author rsouza10
 */
public class ViewFichaControle extends javax.swing.JFrame {
    
    private static final long serialVersionUID = -2633970475618354793L;

    ModelFichaControle modelFichaControle = new ModelFichaControle();
    ControllerFichaControle controllerFichaControle = new ControllerFichaControle();
    ArrayList<ModelFichaControle> listaModelFichaControle = new ArrayList<ModelFichaControle>();
    ControllerTeste controllerTeste = new ControllerTeste();
    ArrayList<ModelTeste> listaModelTeste = new ArrayList<ModelTeste>();
    ControllerEquipamento controllerEquipamento = new ControllerEquipamento();
    ArrayList<ModelEquipamento> listaModelEquipamento = new ArrayList<ModelEquipamento>();
    ControllerComposto controllerComposto = new ControllerComposto();
    ArrayList<ModelComposto> listaModelComposto = new ArrayList<ModelComposto>();
    ControllerMaterial controllerMaterial = new ControllerMaterial();
    ArrayList<ModelMaterial> listaModelMaterial = new ArrayList<ModelMaterial>();
    ControllerUnidFreq controllerUnidFreq = new ControllerUnidFreq();
    ArrayList<ModelUnidFreq> listaModelUnidFreq = new ArrayList<ModelUnidFreq>();
    ControllerUnidMedida controllerUnidMedida = new ControllerUnidMedida();
    ArrayList<ModelUnidMedida> listaModelUnidMedida = new ArrayList<ModelUnidMedida>();
    String perfil;
    String responsavel;
    String status;
    String linha;
    String pendente = "Pendente";
    String divisao;

    public ViewFichaControle() {
        initComponents();
    }

    public ViewFichaControle(String _perfil, String _linha, String _status, String _responsavel, String _divisao) {
        initComponents();
        lbObservacaoQL.setVisible(false);
        txtObservacaoQL.setVisible(false);
        linha = _linha;
        txtLinha.setText(linha);
        perfil = _perfil;
        txtMaterial.setText(perfil);
        status = _status;
        responsavel = _responsavel;
        divisao = _divisao;
        this.carregaFichaControle();
        this.listarEquipamento();
        this.listarUnidadeMedida();
        this.listarUnidadeFreq();
        this.limparDados();
        tbFicha.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbFicha));
        tbFicha.setDefaultRenderer(Integer.class, new EstiloTablaRenderer2());
        tbFicha.setDefaultRenderer(String.class, new EstiloTablaRenderer2());
        tbFicha.setDefaultRenderer(Float.class, new EstiloTablaRenderer2());
        tbFicha.getColumnModel().getColumn(5).setCellRenderer(new CustomRenderer());
        if (divisao.equals("Alteração")) {
            lbObservacaoQL.setVisible(true);
            txtObservacaoQL.setVisible(true);
        }
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
        lbProduto = new javax.swing.JLabel();
        lbFrequencia = new javax.swing.JLabel();
        lbTeste = new javax.swing.JLabel();
        lbUnidFreq = new javax.swing.JLabel();
        lbTipo = new javax.swing.JLabel();
        lbEquipamento = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        cbEquipamento = new javax.swing.JComboBox<>();
        lbEspecMin = new javax.swing.JLabel();
        lbLinha = new javax.swing.JLabel();
        lbObs = new javax.swing.JLabel();
        lbEspecMax = new javax.swing.JLabel();
        txtObs = new javax.swing.JTextField();
        cbUnidFreq = new javax.swing.JComboBox<>();
        lbLaboratorio = new javax.swing.JLabel();
        cbUnidMed = new javax.swing.JComboBox<>();
        cbOrigem = new javax.swing.JComboBox<>();
        lbUnidMed = new javax.swing.JLabel();
        lbPerfil = new javax.swing.JLabel();
        cbLaboratorio = new javax.swing.JComboBox<>();
        lbOrigem = new javax.swing.JLabel();
        lbEspecTexto = new javax.swing.JLabel();
        lbOrdem = new javax.swing.JLabel();
        cbProduto = new javax.swing.JComboBox<>();
        txtEspecMin = new javax.swing.JTextField();
        txtEspecMax = new javax.swing.JTextField();
        txtOrdem = new javax.swing.JSpinner();
        txtFrequencia = new javax.swing.JSpinner();
        txtLinha = new javax.swing.JTextField();
        txtMaterial = new javax.swing.JTextField();
        cbComposto = new javax.swing.JComboBox<>();
        lbComposto = new javax.swing.JLabel();
        lbCod = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        lbId = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbObservacaoQL = new javax.swing.JLabel();
        txtObservacaoQL = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbFicha = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnSalvar1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Ficha de Controle");

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

        lbProduto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbProduto.setText("Produto:");

        lbFrequencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbFrequencia.setText("Frequência:");

        lbTeste.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbTeste.setText("Teste:");

        lbUnidFreq.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbUnidFreq.setText("Unidade:");

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

        cbEquipamento.setEnabled(false);
        cbEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEquipamentoActionPerformed(evt);
            }
        });

        lbEspecMin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbEspecMin.setText("Espec Mín:");

        lbLinha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbLinha.setText("Linha:");

        lbObs.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbObs.setText("Observação:");

        lbEspecMax.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbEspecMax.setText("Espec Máx:");

        txtObs.setEnabled(false);

        cbUnidFreq.setEnabled(false);

        lbLaboratorio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbLaboratorio.setText("Teste Laboratório: ");

        cbUnidMed.setEnabled(false);

        cbOrigem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ficha Máquina" }));
        cbOrigem.setEnabled(false);

        lbUnidMed.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbUnidMed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUnidMed.setText("Unidade:");

        lbPerfil.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbPerfil.setText("Perfil:");

        cbLaboratorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        cbLaboratorio.setEnabled(false);

        lbOrigem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbOrigem.setText("Origem:");

        lbEspecTexto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbEspecTexto.setText("Espec. Texto:");

        lbOrdem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbOrdem.setText("Ordem:");

        cbProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não" }));
        cbProduto.setEnabled(false);

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

        txtOrdem.setModel(new javax.swing.SpinnerNumberModel(0, null, null, 100));
        txtOrdem.setEnabled(false);

        txtFrequencia.setModel(new javax.swing.SpinnerNumberModel());
        txtFrequencia.setEnabled(false);

        txtLinha.setEditable(false);
        txtLinha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLinha.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtLinha.setEnabled(false);
        txtLinha.setFocusable(false);

        txtMaterial.setEditable(false);
        txtMaterial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMaterial.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMaterial.setEnabled(false);
        txtMaterial.setFocusable(false);

        cbComposto.setToolTipText("Informe o numero do composto relacionado ao teste.");
        cbComposto.setEnabled(false);

        lbComposto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbComposto.setText("Comp/Mater:");

        lbCod.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCod.setText("Cód. Teste:");

        txtCod.setEditable(false);
        txtCod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCod.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCod.setEnabled(false);
        txtCod.setFocusable(false);

        txtId.setEditable(false);
        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtId.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtId.setEnabled(false);
        txtId.setFocusable(false);

        lbId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbId.setText("Código:");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-adicionar-filled-50.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-adicionar-filled-50.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-adicionar-filled-50.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-adicionar-filled-50.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-adicionar-filled-50.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        lbObservacaoQL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbObservacaoQL.setText("Observação de Alteração para Extrusão:");

        txtObservacaoQL.setBackground(new java.awt.Color(255, 255, 204));
        txtObservacaoQL.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbFrequencia)
                            .addComponent(txtFrequencia, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(lbUnidFreq))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cbUnidFreq, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbLaboratorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbLaboratorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbProduto)
                            .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbOrigem)
                            .addComponent(cbOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbObservacaoQL)
                            .addComponent(txtObservacaoQL, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE))
                        .addGap(28, 28, 28))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbId)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbOrdem)
                                    .addComponent(txtOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtLinha)
                                    .addComponent(lbLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbPerfil)
                                    .addComponent(txtMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbEquipamento)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cbEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cbTeste, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11)
                                        .addGap(8, 8, 8))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lbTeste)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbComposto)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cbComposto, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12)))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lbCod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(11, 11, 11))
                                    .addComponent(txtCod)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtObs)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lbObs)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEspecMin)
                                    .addComponent(lbEspecMin, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                                    .addComponent(cbReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(lbTeste)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbTeste)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbComposto)
                                        .addComponent(lbCod))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbComposto)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbLinha)
                                                .addComponent(txtLinha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(lbPerfil)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(lbEquipamento)))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbId)
                                        .addComponent(lbOrdem)))))
                        .addComponent(txtCod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOrdem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTipo)
                            .addComponent(lbObs))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbUnidMed)
                            .addComponent(lbEspecMax)
                            .addComponent(lbEspecMin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbUnidMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEspecMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEspecMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbProduto)
                                    .addComponent(lbLaboratorio)
                                    .addComponent(lbOrigem))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbObservacaoQL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtObservacaoQL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbUnidFreq, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbFrequencia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFrequencia)
                            .addComponent(cbUnidFreq)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        tbFicha.setAutoCreateRowSorter(true);
        tbFicha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Ordem", "Linha", "Perfil", "Equipamento", "Desc. Teste", "Cod. Teste", "Obseração", "Tipo", "Espec. Mín.", "Espec. Máx.", "Espec. Unid.", "Espec. Texto", "Referência", "Frequência", "Freq. Unid.", "Produto", "Origem", "Lab.", "COMPOSTO", "IDENTIFICACAO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbFicha.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbFicha.setFocusable(false);
        tbFicha.setMaximumSize(new java.awt.Dimension(83, 25));
        tbFicha.setMinimumSize(new java.awt.Dimension(83, 25));
        tbFicha.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbFicha);
        if (tbFicha.getColumnModel().getColumnCount() > 0) {
            tbFicha.getColumnModel().getColumn(0).setMinWidth(0);
            tbFicha.getColumnModel().getColumn(0).setMaxWidth(0);
            tbFicha.getColumnModel().getColumn(4).setMinWidth(200);
            tbFicha.getColumnModel().getColumn(5).setMinWidth(200);
            tbFicha.getColumnModel().getColumn(6).setMinWidth(100);
            tbFicha.getColumnModel().getColumn(7).setMinWidth(110);
            tbFicha.getColumnModel().getColumn(9).setMinWidth(110);
            tbFicha.getColumnModel().getColumn(10).setMinWidth(110);
            tbFicha.getColumnModel().getColumn(11).setMinWidth(110);
            tbFicha.getColumnModel().getColumn(12).setMinWidth(110);
            tbFicha.getColumnModel().getColumn(13).setMinWidth(90);
            tbFicha.getColumnModel().getColumn(14).setMinWidth(90);
            tbFicha.getColumnModel().getColumn(15).setMinWidth(90);
            tbFicha.getColumnModel().getColumn(19).setMinWidth(0);
            tbFicha.getColumnModel().getColumn(19).setMaxWidth(0);
            tbFicha.getColumnModel().getColumn(20).setMinWidth(0);
            tbFicha.getColumnModel().getColumn(20).setMaxWidth(0);
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
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

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-à-direita-dentro-de-um-círculo-filled-50.png"))); // NOI18N
        jMenu1.setText("Enviar para Qualidade");

        jMenuItem2.setText("Enviar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-pesquisar-filled-50.png"))); // NOI18N
        jMenu3.setText("Visualizar Ficha");

        jMenuItem1.setText("Visualizar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

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

    private void cbEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEquipamentoActionPerformed

        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select * from Qry_Teste where TES_EQUIPAMENTO= ? and OPE_SETOR='Extrusão' order by DESC_TESTE asc";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbEquipamento.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();
            cbTeste.removeAllItems();
            while (rs.next()) {

                cbTeste.addItem(rs.getString("DESC_TESTE"));
            }

        } catch (Exception e) {

        }

        cbTeste.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (cbEquipamento.getSelectedItem().toString().contains("Laboratório")) {
                        cbLaboratorio.setSelectedItem("Sim");
                    } else {
                        cbLaboratorio.setSelectedItem("Não");
                    }
                }
            }
        });

    }//GEN-LAST:event_cbEquipamentoActionPerformed

    private void txtEspecMinFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEspecMinFocusLost
        this.txtEspecMin.setText(new Mascaras().converterVirgulaParaPonto(txtEspecMin.getText()));

//        if (txtEspecMin.getText().equals("")) {
//        } else {
//            txtEspecMin.setText(new Mascaras().arredondamentoComPontoDuasCasasString(Float.valueOf(txtEspecMin.getText())));
//        }
    }//GEN-LAST:event_txtEspecMinFocusLost

    private void txtEspecMaxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEspecMaxFocusLost
        this.txtEspecMax.setText(new Mascaras().converterVirgulaParaPonto(txtEspecMax.getText()));

//        if (txtEspecMax.getText().equals("")) {
//
//        } else {
//            txtEspecMax.setText(new Mascaras().arredondamentoComPontoDuasCasasString(Float.valueOf(txtEspecMax.getText())));
//        }
    }//GEN-LAST:event_txtEspecMaxFocusLost

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        this.desabilitarCampos();
        limparDados();
        btnSalvar.setEnabled(false);
        btnSalvar1.setEnabled(false);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tbFicha.getSelectedRow();
        if (tbFicha.getValueAt(linha, 16).equals("Sim")) {
            JOptionPane.showMessageDialog(null, "Apenas setor de Qualidade poderá efetuar exclusão desta linha.");
        } else {
            if (divisao.equals("Alteração")) {
                int linhasselecionada = tbFicha.getSelectedRow();
                if (linhasselecionada < 0) {
                    JOptionPane.showMessageDialog(this, "Você deve selecionar um item antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                } else {
                    recuperarFichaControle();
                    this.alterarExcluir();
                    limparDados();
                }
            } else {
                int linhasselecionada = tbFicha.getSelectedRow();
                if (linhasselecionada < 0) {
                    JOptionPane.showMessageDialog(this, "Você deve selecionar um item antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                } else {
                    this.excluirTeste();
                    limparDados();
                }
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linha = tbFicha.getSelectedRow();
        if (tbFicha.getValueAt(linha, 16).equals("Sim")) {
            JOptionPane.showMessageDialog(null, "Apenas setor de Qualidade poderá efetuar alteração desta linha.");
        } else {
            int linhasselecionada = tbFicha.getSelectedRow();

            if (linhasselecionada < 0) {
                JOptionPane.showMessageDialog(this, "Você deve selecionar um item antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            } else {
                novoProjeto();
                btnSalvar.setEnabled(true);
                btnSalvar1.setEnabled(true);
                habilitarCampos();
                recuperarFichaControle();

            }
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
        } else if (cbUnidFreq.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbUnidFreq.requestFocus();
        } else if (cbLaboratorio.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbLaboratorio.requestFocus();
        } else if (cbEquipamento.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbEquipamento.requestFocus();
        } else if (cbTeste.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbTeste.requestFocus();
        } else if (divisao.equals("Alteração") && txtObservacaoQL == null) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            txtObservacaoQL.requestFocus();
        } else {
            salvarFicha();
            btnSalvar.setEnabled(false);
            btnSalvar1.setEnabled(false);
        }


    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked

        ViewEquipamento vm = null;
        if (ControleInstancias.isInstaced(ViewEquipamento.class)) {
            vm = (ViewEquipamento) ControleInstancias.getInstance(ViewEquipamento.class.getName(), ViewEquipamento.class);
            vm.setSolicitante(this);
        } else {
            vm = new ViewEquipamento(this);
        }
        vm.setVisible(true);
    }//GEN-LAST:event_jLabel10MouseClicked

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

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        Object[] opcoes = {"Composto", "Material"};
        Object res = JOptionPane.showInputDialog(null, "Tela", "Seleção de tela",
                JOptionPane.PLAIN_MESSAGE, null, opcoes, "");
        String respsota = (String) res;

        if (respsota.equals("Composto")) {
            ViewComposto vm = null;
            if (ControleInstancias.isInstaced(ViewComposto.class)) {
                vm = (ViewComposto) ControleInstancias.getInstance(ViewComposto.class.getName(), ViewComposto.class);
                vm.setSolicitante(this);
            } else {
                vm = new ViewComposto(this);
            }
            vm.setVisible(true);
        } else {

        }
        if (respsota.equals("Material")) {
            ViewMaterial vm = null;
            if (ControleInstancias.isInstaced(ViewMaterial.class)) {
                vm = (ViewMaterial) ControleInstancias.getInstance(ViewMaterial.class.getName(), ViewMaterial.class);
                vm.setSolicitante(this);
            } else {
                vm = new ViewMaterial(this);
            }
            vm.setVisible(true);
        } else {

        }
    }//GEN-LAST:event_jLabel12MouseClicked

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

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        ViewUnidFreq vm = null;
        if (ControleInstancias.isInstaced(ViewUnidFreq.class)) {
            vm = (ViewUnidFreq) ControleInstancias.getInstance(ViewUnidFreq.class.getName(), ViewUnidFreq.class);
            vm.setSolicitante(this);
        } else {
            vm = new ViewUnidFreq(this);
        }
        vm.setVisible(true);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void cbTesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTesteActionPerformed

        try {
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select * from Qry_Teste where DESC_TESTE=? and TES_EQUIPAMENTO=? and OPE_SETOR='Extrusão' order by ORDEM asc";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, cbTeste.getSelectedItem().toString());
            st.setString(2, cbEquipamento.getSelectedItem().toString());
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                txtCod.setText(rs.getString("COD_TESTE"));
            }

        } catch (Exception e) {
        }

        cbTeste.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (cbTeste.getSelectedItem().equals("Densidade do Composto") || cbTeste.getSelectedItem().equals("MV do Composto") || cbTeste.getSelectedItem().equals("T5 do Composto") || cbTeste.getSelectedItem().equals("T90 do Composto") || (cbTeste.getSelectedItem().equals("Código do Material") && cbEquipamento.getSelectedItem().toString().contains("Extrusora"))) {
                        if (cbComposto.getSelectedIndex() == -1) {
                            listarComposto();
                        }

                    } else if (cbTeste.getSelectedItem().toString().contains("Comprimento")) {
                        if (cbComposto.getSelectedIndex() == -1) {
                            listarMaterial();
                        }

                    } else if (cbTeste.getSelectedItem().toString().contains("Validade do Material")) {
                        txtObs.setText("Conforme Etiqueta");
                    } else if (cbTeste.getSelectedItem().toString().contains("Número da Etiqueta")) {
                        txtObs.setText("Número da HU / UC (Unidade Comercial)");
                    } else if (cbTeste.getSelectedItem().toString().contains("Data de Fabricação do Material")) {
                        txtObs.setText("Conforme Etiqueta");
                    } else if (cbTeste.getSelectedItem().toString().contains("Controle de Geometria do Perfil")) {
                        txtObs.setText("Conforme Mylar - Anexar na planilha de coleta de amostra");
                    } else if (cbTeste.getSelectedItem().toString().contains("Identificação da 1º Peça")) {
                        txtObs.setText("Validação da 1ª peça conforme aprovação dos resultados das características do produto.");
                    } else if (cbTeste.getSelectedItem().toString().contains("Defeitos Visuais")) {
                        txtObs.setText("Conforme Book de Defeitos");
                    } else if (cbTeste.getSelectedItem().toString().contains("Embalagem")) {
                        txtObs.setText("Conforme IO de embalagem");
                    } else {
                        cbComposto.removeAllItems();
                        txtObs.setText("");
                    }
                }
            }
        });
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
        } else if (cbUnidFreq.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbUnidFreq.requestFocus();
        } else if (cbLaboratorio.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbLaboratorio.requestFocus();
        } else if (cbEquipamento.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbEquipamento.requestFocus();
        } else if (cbTeste.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            cbTeste.requestFocus();
        } else if (divisao.equals("Alteração") && txtObservacaoQL.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo obrigatório!", "", JOptionPane.WARNING_MESSAGE);
            txtObservacaoQL.requestFocus();
        } else {
            alterarFichaControle();
            btnSalvar.setEnabled(false);
            btnSalvar1.setEnabled(false);
        }


    }//GEN-LAST:event_btnSalvar1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (divisao.equals("Cópia")) {
            int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
                    + " enviar os registro para qualidade?", "Atenção", JOptionPane.YES_OPTION);
            if (opcao == JOptionPane.OK_OPTION) {
                updatecopiaStatus();
                dispose();
            }
        }
        if (divisao.equals("Alteração")) {
            int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
                    + " enviar os registro para qualidade?", "Atenção", JOptionPane.YES_OPTION);
            if (opcao == JOptionPane.OK_OPTION) {
                updatStatusAlterar();
                dispose();
            }
        }
        if (divisao.equals("Novo")) {
            int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
                    + " enviar os registro para qualidade?", "Atenção", JOptionPane.YES_OPTION);
            if (opcao == JOptionPane.OK_OPTION) {
                updatStatus();
                dispose();
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        final AguardeGerandoRelatório carregando = new AguardeGerandoRelatório();
        carregando.setVisible(true);
        Thread t = new Thread() {
            public void run() {

                try {
                    String logo = "/images/logocooper.jpg";
                    
                    Connection con = new ConexaoSql().getCon();
                    Map p = new HashMap();
                    p.put("perfil", txtMaterial.getText());
                    p.put("logo", this.getClass().getResourceAsStream(logo));
                    JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Relatorios/fichacontroleEspec.jasper"));
                    JasperPrint print = JasperFillManager.fillReport(jr, p, con);
                    JasperViewer view = new JasperViewer(print, false);
                    view.setTitle("Ficha de Controle");

                    view.setVisible(true);
                } catch (Exception erro) {

                    JOptionPane.showMessageDialog(null, "deu erro =" + erro);
                    System.out.println(erro);

                }

                carregando.dispose();
            }
        };
        t.start();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        getValorOrdena().stream().forEach(mr -> controllerFichaControle.atualizarFichaControleController((ModelFichaControle) mr));
        carregaFichaControle();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    public void addItemLista(String item) {
        cbEquipamento.addItem(item);
        cbTeste.addItem(item);
        cbComposto.addItem(item);
        cbUnidMed.addItem(item);
        cbUnidFreq.addItem(item);
        listarEquipamento();
        listarTeste();
        listarComposto();
        listarMaterial();
        listarUnidadeFreq();
        listarUnidadeMedida();
    }

    private void listarEquipamento() {
        listaModelEquipamento = controllerEquipamento.getListaEquipamentoController();
        cbEquipamento.removeAllItems();
        for (int i = 0; i < listaModelEquipamento.size(); i++) {
            cbEquipamento.addItem(listaModelEquipamento.get(i).getEquipamento());

        }
    }

    private void listarTeste() {
        listaModelTeste = controllerTeste.getListaTesteController();
        cbTeste.removeAllItems();
        for (int i = 0; i < listaModelTeste.size(); i++) {
            cbTeste.addItem(listaModelTeste.get(i).getDesc_teste());
        }
    }

    private void listarComposto() {
        listaModelComposto = controllerComposto.getListaCompostoController();
        cbComposto.removeAllItems();
        for (int i = 0; i < listaModelComposto.size(); i++) {
            cbComposto.addItem(String.valueOf(listaModelComposto.get(i).getComposto()));
        }
    }

    private void listarMaterial() {
        listaModelMaterial = controllerMaterial.getListaMaterialController();
        cbComposto.removeAllItems();
        for (int i = 0; i < listaModelMaterial.size(); i++) {
            cbComposto.addItem(String.valueOf(listaModelMaterial.get(i).getMaterial()));
        }
    }

    private void listarUnidadeFreq() {
        listaModelUnidFreq = controllerUnidFreq.getListaUnidFreqController();
        cbUnidFreq.removeAllItems();
        for (int i = 0; i < listaModelUnidFreq.size(); i++) {
            cbUnidFreq.addItem(String.valueOf(listaModelUnidFreq.get(i).getUnidade_frequencia()));
        }
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
        int linhatb = tbFicha.getSelectedRow();
        String nome = (String) tbFicha.getValueAt(linhatb, 5);
        int codigo = (Integer) tbFicha.getValueAt(linhatb, 0);
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
                + " excluir o registro \nNome: "
                + nome + " ?", "Atenção", JOptionPane.YES_OPTION);

        if (opcao == JOptionPane.OK_OPTION) {
            if (controllerFichaControle.excluirFichaControleController(codigo)) {
                JOptionPane.showMessageDialog(this, "Registro excluido com sucesso!");
                carregaFichaControle();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean updatStatus() {
        for (int i = 0; i < tbFicha.getRowCount(); i++) {
            modelFichaControle.setPendencia_alter(status);
            modelFichaControle.setResponsavel_alter(responsavel);

            if (controllerFichaControle.updateStatusFichaControleController(perfil, status, responsavel)) {
                JOptionPane.showMessageDialog(this, "Registros enviado com sucesso!");
                this.desabilitarCampos();
                this.carregaFichaControle();
                limparDados();
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao enviar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }

    private boolean updatStatusAlterar() {
        for (int i = 0; i < tbFicha.getRowCount(); i++) {
            modelFichaControle.setPendencia_alter("Pendente");
            modelFichaControle.setResponsavel_alter(responsavel);

            if (controllerFichaControle.updateStatusAlterarFichaControleController(modelFichaControle, perfil)) {
                JOptionPane.showMessageDialog(this, "Registros enviado com sucesso!");
                this.desabilitarCampos();
                this.carregaFichaControle();
                limparDados();
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao enviar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }

    private boolean updatecopiaStatus() {
        Object[] opcoes = {"Protótipo", "Pré-Lançamento", "Produção"};
        Object res = JOptionPane.showInputDialog(null, "Escolha um Status", "Seleção de status",
                JOptionPane.PLAIN_MESSAGE, null, opcoes, "");
        for (int i = 0; i < tbFicha.getRowCount(); i++) {
            modelFichaControle.setPendencia_alter(status);
            modelFichaControle.setResponsavel_alter(responsavel);
            modelFichaControle.setObservacao_alter("Emissão de Ficha");
            modelFichaControle.setStatus((String) res);
            if (controllerFichaControle.updatecopiaStatusFichaControleController(modelFichaControle, perfil)) {
                JOptionPane.showMessageDialog(this, "Registros enviado com sucesso!");
                this.desabilitarCampos();
                this.carregaFichaControle();
                limparDados();
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao enviar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }

    private boolean alterarExcluir() {
        modelFichaControle.setId(Integer.parseInt(this.txtId.getText()));
        modelFichaControle.setResponsavel_alter(responsavel);
        modelFichaControle.setPendencia_alter("Alteração");
        modelFichaControle.setAlter_indentificacao(3);
        String x;
        x = JOptionPane.showInputDialog(null, "Informe o motivo da exclusão!");
        if (x.equals("")) {
            txtObservacaoQL.setText("Sem Informação");
        } else {
            txtObservacaoQL.setText(x);
        }
        modelFichaControle.setObservacao_alter(this.txtObservacaoQL.getText());
        try {
            Datas data = new Datas();
            modelFichaControle.setData_alter(data.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));

        } catch (Exception ex) {
            Logger.getLogger(ViewFichaControle.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (controllerFichaControle.atualizarFichaControleController(modelFichaControle)) {
            JOptionPane.showMessageDialog(this, "Registro excluido com sucesso!");
            this.desabilitarCampos();
            this.carregaFichaControle();
            limparDados();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao excluir!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private boolean salvarFicha() {
        String tipo_teste = cbTipo.getSelectedItem().toString();
        modelFichaControle.setOrdem(Integer.parseInt(this.txtOrdem.getValue().toString()));
        modelFichaControle.setEsp_linha(this.txtLinha.getText());
        modelFichaControle.setEsp_material(Integer.parseInt(this.txtMaterial.getText()));
        modelFichaControle.setEsp_equipamento(this.cbEquipamento.getSelectedItem().toString());
        if (cbComposto.getSelectedIndex() != -1) {
            modelFichaControle.setEsp_composto(Integer.parseInt(this.cbComposto.getSelectedItem().toString()));
        }
        modelFichaControle.setEsp_teste(this.txtCod.getText());
        modelFichaControle.setComplemento(this.txtObs.getText());
        modelFichaControle.setTipo_espec(this.cbTipo.getSelectedItem().toString());
        modelFichaControle.setMinimo(Float.valueOf(this.txtEspecMin.getText()));
        modelFichaControle.setMaximo(Float.valueOf(this.txtEspecMax.getText()));
        modelFichaControle.setUnid_medida(this.cbUnidMed.getSelectedItem().toString());
        modelFichaControle.setTexto(this.txtEspecTexto.getText());
        modelFichaControle.setReferencia(this.cbReferencia.getSelectedItem().toString());
        modelFichaControle.setFrequencia(Integer.parseInt(this.txtFrequencia.getValue().toString()));
        modelFichaControle.setUnid_frequencia(this.cbUnidFreq.getSelectedItem().toString());
        modelFichaControle.setLab(this.cbLaboratorio.getSelectedItem().toString());
        modelFichaControle.setProduto(this.cbProduto.getSelectedItem().toString());
        modelFichaControle.setOrigem(this.cbOrigem.getSelectedItem().toString());
        modelFichaControle.setFreq_completo("A cada " + this.txtFrequencia.getValue().toString() + " " + this.cbUnidFreq.getSelectedItem().toString() + "");
        if (tipo_teste.contains("Min e Max")) {
            if (cbReferencia.getSelectedItem().equals("Sim")) {
                modelFichaControle.setEspec_completo(this.txtEspecMin.getText() + " à " + this.txtEspecMax.getText() + " " + this.cbUnidMed.getSelectedItem().toString() + " " + "(referência*)");
            } else if (cbTeste.getSelectedItem().toString().contains("Comprimento")) {
                modelFichaControle.setEspec_completo("(" + cbComposto.getSelectedItem() + ")" + " " + this.txtEspecMin.getText() + " à " + this.txtEspecMax.getText() + " " + this.cbUnidMed.getSelectedItem().toString());
            } else {
                modelFichaControle.setEspec_completo(this.txtEspecMin.getText() + " à " + this.txtEspecMax.getText() + " " + this.cbUnidMed.getSelectedItem().toString());
            }
        } else {
            if (tipo_teste.contains("Texto")) {
                if (cbReferencia.getSelectedItem().equals("Sim")) {
                    modelFichaControle.setEspec_completo(this.txtEspecTexto.getText() + " " + "(referência*)");
                } else {
                    modelFichaControle.setEspec_completo(txtEspecTexto.getText());
                }
            }
            if (tipo_teste.contains("No Max")) {
                if (cbReferencia.getSelectedItem().equals("Sim")) {
                    modelFichaControle.setEspec_completo("Máx. " + this.txtEspecMax.getText() + " " + this.cbUnidMed.getSelectedItem().toString() + " " + "(referência*)");
                } else {
                    modelFichaControle.setEspec_completo("Máx. " + this.txtEspecMax.getText() + " " + this.cbUnidMed.getSelectedItem().toString());
                }
            }
            if (tipo_teste.contains("No Min")) {
                if (cbReferencia.getSelectedItem().equals("Sim")) {
                    modelFichaControle.setEspec_completo("Min. " + this.txtEspecMin.getText() + " " + this.cbUnidMed.getSelectedItem().toString() + " " + "(referência*)");
                } else {
                    modelFichaControle.setEspec_completo("Min. " + this.txtEspecMin.getText() + " " + this.cbUnidMed.getSelectedItem().toString());
                }
            }
            if (tipo_teste.contains("ValorUnico")) {
                if (cbReferencia.getSelectedItem().equals("Sim")) {
                    modelFichaControle.setEspec_completo(this.txtEspecMin.getText() + " " + this.cbUnidMed.getSelectedItem().toString() + " " + "(referência*)");
                } else {
                    modelFichaControle.setEspec_completo(this.txtEspecMin.getText() + " " + this.cbUnidMed.getSelectedItem().toString());
                }
            }
        }
        modelFichaControle.setResponsavel_alter(responsavel);
        if (divisao.equals("Alteração")) {
            modelFichaControle.setPendencia_alter("Alteração");
            modelFichaControle.setAlter_indentificacao(2);
        }
        if (divisao.equals("Novo")) {
            modelFichaControle.setPendencia_alter("");
        }

        if (divisao.equals("Cópia")) {
            modelFichaControle.setPendencia_alter("Cópia");
        }
        modelFichaControle.setDate_valid_alter("");
        modelFichaControle.setStatus(status);
        if (status.equals("Protótipo")) {
            if (divisao.equals("Alteração")) {
                modelFichaControle.setObservacao_alter(this.txtObservacaoQL.getText());
            } else {
                modelFichaControle.setObservacao_alter("Emissão Inicial");
            }
        }
        if (status.equals("Produção")) {
            modelFichaControle.setObservacao_alter("Ficha Existente");
        }
        if (status.equals("Pré-Lançamento")) {
            modelFichaControle.setObservacao_alter("Try Out");
        }
        try {
            Datas data = new Datas();
            modelFichaControle.setData_alter(data.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));

        } catch (Exception ex) {
            Logger.getLogger(ViewFichaControle.class.getName()).log(Level.SEVERE, null, ex);

        }

        if (controllerFichaControle.salvarFichaControleController(modelFichaControle) > 0) {
            JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
            this.desabilitarCampos();
            this.carregaFichaControle();
            this.carregaFichaControle();
            limparDados();
            return true;
        } else {

            JOptionPane.showMessageDialog(this, "Erro ao tentar gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;

        }

    }

    private boolean recuperarFichaControle() {
        int linhatb = this.tbFicha.getSelectedRow();
        int codigo = (Integer) tbFicha.getValueAt(linhatb, 0);
        try {
            modelFichaControle = controllerFichaControle.getFichaControleController(codigo);
            this.txtId.setText(String.valueOf(modelFichaControle.getId()));
            this.txtOrdem.setValue(modelFichaControle.getOrdem());
            this.txtLinha.setText(modelFichaControle.getEsp_linha());
            this.txtMaterial.setText(String.valueOf(modelFichaControle.getEsp_material()));
            this.cbEquipamento.setSelectedItem(modelFichaControle.getEsp_equipamento());
            this.cbTeste.setSelectedItem(modelFichaControle.getDesc_teste());
            this.cbComposto.setSelectedItem(String.valueOf(modelFichaControle.getEsp_composto()));
            this.txtCod.setText(modelFichaControle.getEsp_teste());
            this.txtObs.setText(modelFichaControle.getComplemento());
            this.cbTipo.setSelectedItem(modelFichaControle.getTipo_espec());
            this.txtEspecMin.setText(String.valueOf(modelFichaControle.getMinimo()));
            this.txtEspecMax.setText(String.valueOf(modelFichaControle.getMaximo()));
            this.cbUnidMed.setSelectedItem(modelFichaControle.getUnid_medida());
            this.txtEspecTexto.setText(modelFichaControle.getTexto());
            this.cbReferencia.setSelectedItem(modelFichaControle.getReferencia());
            this.txtFrequencia.setValue(modelFichaControle.getFrequencia());
            this.cbUnidFreq.setSelectedItem(modelFichaControle.getUnid_frequencia());
            this.cbLaboratorio.setSelectedItem(modelFichaControle.getLab());
            this.cbProduto.setSelectedItem(modelFichaControle.getProduto());
            this.cbOrigem.setSelectedItem(modelFichaControle.getOrigem());
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código inválido ou nenhum registro selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
            btnSalvar.setEnabled(true);
            btnSalvar1.setEnabled(true);
            return false;
        }
    }

    private boolean alterarFichaControle() {
        String tipo_teste = cbTipo.getSelectedItem().toString();
        modelFichaControle.setId(Integer.parseInt(this.txtId.getText()));
        modelFichaControle.setOrdem(Integer.parseInt(this.txtOrdem.getValue().toString()));
        modelFichaControle.setEsp_linha(this.txtLinha.getText());
        modelFichaControle.setEsp_material(Integer.parseInt(this.txtMaterial.getText()));
        modelFichaControle.setEsp_equipamento(this.cbEquipamento.getSelectedItem().toString());
        if (cbComposto.getSelectedIndex() != -1) {
            modelFichaControle.setEsp_composto(Integer.parseInt(this.cbComposto.getSelectedItem().toString()));
        }
        modelFichaControle.setEsp_teste(this.txtCod.getText());
        modelFichaControle.setComplemento(this.txtObs.getText());
        modelFichaControle.setTipo_espec(this.cbTipo.getSelectedItem().toString());
        modelFichaControle.setMinimo(Float.parseFloat(this.txtEspecMin.getText()));
        modelFichaControle.setMaximo(Float.parseFloat(this.txtEspecMax.getText()));
        modelFichaControle.setUnid_medida(this.cbUnidMed.getSelectedItem().toString());
        modelFichaControle.setTexto(this.txtEspecTexto.getText());
        modelFichaControle.setReferencia(this.cbReferencia.getSelectedItem().toString());
        modelFichaControle.setFrequencia(Integer.parseInt(this.txtFrequencia.getValue().toString()));
        modelFichaControle.setUnid_frequencia(this.cbUnidFreq.getSelectedItem().toString());
        modelFichaControle.setLab(this.cbLaboratorio.getSelectedItem().toString());
        modelFichaControle.setProduto(this.cbProduto.getSelectedItem().toString());
        modelFichaControle.setOrigem(this.cbOrigem.getSelectedItem().toString());
        modelFichaControle.setFreq_completo("A cada " + this.txtFrequencia.getValue().toString() + " " + this.cbUnidFreq.getSelectedItem().toString() + "");
        if (tipo_teste.contains("Min e Max")) {
            if (cbReferencia.getSelectedItem().equals("Sim")) {
                modelFichaControle.setEspec_completo(this.txtEspecMin.getText() + " à " + this.txtEspecMax.getText() + " " + this.cbUnidMed.getSelectedItem().toString() + " " + "(referência*)");
            } else if (cbTeste.getSelectedItem().toString().contains("Comprimento")) {
                modelFichaControle.setEspec_completo("(" + cbComposto.getSelectedItem() + ")" + " " + this.txtEspecMin.getText() + " à " + this.txtEspecMax.getText() + " " + this.cbUnidMed.getSelectedItem().toString());
            } else {
                modelFichaControle.setEspec_completo(this.txtEspecMin.getText() + " à " + this.txtEspecMax.getText() + " " + this.cbUnidMed.getSelectedItem().toString());
            }
        } else {
            if (tipo_teste.contains("Texto")) {
                if (cbReferencia.getSelectedItem().equals("Sim")) {
                    modelFichaControle.setEspec_completo(this.txtEspecTexto.getText() + " " + "(referência*)");
                } else {
                    modelFichaControle.setEspec_completo(txtEspecTexto.getText());
                }
            }
            if (tipo_teste.contains("No Max")) {
                if (cbReferencia.getSelectedItem().equals("Sim")) {
                    modelFichaControle.setEspec_completo("Máx. " + this.txtEspecMax.getText() + " " + this.cbUnidMed.getSelectedItem().toString() + " " + "(referência*)");
                } else {
                    modelFichaControle.setEspec_completo("Máx. " + this.txtEspecMax.getText() + " " + this.cbUnidMed.getSelectedItem().toString());
                }
            }
            if (tipo_teste.contains("No Min")) {
                if (cbReferencia.getSelectedItem().equals("Sim")) {
                    modelFichaControle.setEspec_completo("Min. " + this.txtEspecMin.getText() + " " + this.cbUnidMed.getSelectedItem().toString() + " " + "(referência*)");
                } else {
                    modelFichaControle.setEspec_completo("Min. " + this.txtEspecMin.getText() + " " + this.cbUnidMed.getSelectedItem().toString());
                }
            }
            if (tipo_teste.contains("ValorUnico")) {
                if (cbReferencia.getSelectedItem().equals("Sim")) {
                    modelFichaControle.setEspec_completo(this.txtEspecMin.getText() + " " + this.cbUnidMed.getSelectedItem().toString() + " " + "(referência*)");
                } else {
                    modelFichaControle.setEspec_completo(this.txtEspecMin.getText() + " " + this.cbUnidMed.getSelectedItem().toString());
                }
            }
        }
        if (divisao.equals("Alteração") || divisao.equals("Cópia")) {
            modelFichaControle.setResponsavel_alter(responsavel);
            if (divisao.equals("Alteração")) {
                modelFichaControle.setPendencia_alter("Alteração");
                modelFichaControle.setAlter_indentificacao(1);

            }
            if (divisao.equals("Novo")) {
                modelFichaControle.setPendencia_alter("");
            }
            if (divisao.equals("Cópia")) {
                modelFichaControle.setPendencia_alter("Cópia");
            }
            modelFichaControle.setDate_valid_alter("");
            modelFichaControle.setStatus(status);
            if (status.equals("Protótipo")) {
                if (divisao.equals("Alteração")) {
                    modelFichaControle.setObservacao_alter(this.txtObservacaoQL.getText());
                } else {
                    modelFichaControle.setObservacao_alter("Emissão Inicial");
                }
            }
            if (status.equals("Produção")) {
                modelFichaControle.setObservacao_alter("Ficha Existente");
            }
            if (status.equals("Pré-Lançamento")) {
                modelFichaControle.setObservacao_alter("Try Out");
            }
            try {
                Datas data = new Datas();
                modelFichaControle.setData_alter(data.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));

            } catch (Exception ex) {
                Logger.getLogger(ViewFichaControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (controllerFichaControle.atualizarFichaControleController(modelFichaControle)) {
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
            this.desabilitarCampos();
            this.carregaFichaControle();
            limparDados();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void carregaFichaControle() {
        if (divisao.equals("Novo") || divisao.equals("Cópia")) {
            listaModelFichaControle = controllerFichaControle.getListaFichaControleController(perfil);
        }
        if (divisao.equals("Alteração")) {
            listaModelFichaControle = controllerFichaControle.getListaFichaControleEditController(perfil);
        }
        DefaultTableModel modelo = (DefaultTableModel) tbFicha.getModel();
        modelo.setNumRows(0);
        int cont = listaModelFichaControle.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelFichaControle.get(i).getId(),
                listaModelFichaControle.get(i).getOrdem(),
                listaModelFichaControle.get(i).getEsp_linha(),
                listaModelFichaControle.get(i).getEsp_material(),
                listaModelFichaControle.get(i).getEsp_equipamento(),
                listaModelFichaControle.get(i).getDesc_teste(),
                listaModelFichaControle.get(i).getEsp_teste(),
                listaModelFichaControle.get(i).getComplemento(),
                listaModelFichaControle.get(i).getTipo_espec(),
                listaModelFichaControle.get(i).getMinimo(),
                listaModelFichaControle.get(i).getMaximo(),
                listaModelFichaControle.get(i).getUnid_medida(),
                listaModelFichaControle.get(i).getTexto(),
                listaModelFichaControle.get(i).getReferencia(),
                listaModelFichaControle.get(i).getFrequencia(),
                listaModelFichaControle.get(i).getUnid_frequencia(),
                listaModelFichaControle.get(i).getProduto(),
                listaModelFichaControle.get(i).getOrigem(),
                listaModelFichaControle.get(i).getLab(),
                listaModelFichaControle.get(i).getEsp_composto(),
                listaModelFichaControle.get(i).getAlter_indentificacao()

            });

        }

    }

    public void desabilitarCampos() {
        txtOrdem.setEnabled(false);
        cbEquipamento.setEnabled(false);
        cbTeste.setEnabled(false);
        cbComposto.setEnabled(false);
        txtObs.setEnabled(false);
        cbTipo.setEnabled(false);
        cbReferencia.setEnabled(false);
        txtFrequencia.setEnabled(false);
        cbUnidFreq.setEnabled(false);
        cbLaboratorio.setEnabled(false);
        cbProduto.setEnabled(false);
        cbOrigem.setEnabled(false);
        txtObservacaoQL.setEnabled(false);

    }

    public void limparDados() {
        txtId.setText("");
        txtOrdem.setValue(0);
        cbEquipamento.setSelectedIndex(-1);
        cbTeste.setSelectedIndex(-1);
        cbComposto.setSelectedIndex(-1);
        txtCod.setText("");
        txtObs.setText("");
        cbTipo.setSelectedIndex(-1);
        txtEspecMin.setText("");
        txtEspecMax.setText("");
        cbUnidMed.setSelectedIndex(-1);
        txtEspecTexto.setText("");
        txtFrequencia.setValue(0);
        cbUnidFreq.setSelectedIndex(-1);
    }

    public void novoProjeto() {
        habilitarCampos();
        txtId.setText("Novo");
        txtOrdem.setValue(0);
        cbEquipamento.setSelectedIndex(-1);
        cbTeste.setSelectedIndex(-1);
        cbComposto.setSelectedIndex(-1);
        txtCod.setText("");
        txtObs.setText("");
        cbTipo.setSelectedIndex(-1);
        txtEspecMin.setText("");
        txtEspecMax.setText("");
        cbUnidMed.setSelectedIndex(-1);
        txtEspecTexto.setText("");
        txtFrequencia.setValue(0);
        cbUnidFreq.setSelectedIndex(-1);
    }

    public void habilitarCampos() {
        txtOrdem.setEnabled(true);
        cbEquipamento.setEnabled(true);
        cbTeste.setEnabled(true);
        cbComposto.setEnabled(true);
        txtObs.setEnabled(true);
        cbTipo.setEnabled(true);
        cbReferencia.setEnabled(true);
        txtFrequencia.setEnabled(true);
        cbUnidFreq.setEnabled(true);
        cbLaboratorio.setEnabled(true);
        cbProduto.setEnabled(true);
        cbOrigem.setEnabled(true);
        txtObservacaoQL.setEnabled(true);
    }

    private ModelFichaControle getModelOrdena(int row) {
        int valor = 0;
        for (int i = 0; i < tbFicha.getRowCount(); i++) {
            tbFicha.setValueAt(valor += 100, i, 1);
        }
        int teste = (Integer) tbFicha.getValueAt(row, 1);
        int codigo = (Integer) tbFicha.getValueAt(row, 0);
        modelFichaControle = controllerFichaControle.getFichaControleController(codigo);
        modelFichaControle.setOrdem(teste);
        if (controllerFichaControle.atualizarFichaControleController(modelFichaControle)) {
            return null;
        }
        return null;
    }

    public List<Object> getValorOrdena() {
        List<Object> lista = new ArrayList();
        for (int i = 0; i < tbFicha.getRowCount(); i++) {
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
            java.util.logging.Logger.getLogger(ViewFichaControle.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewFichaControle.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewFichaControle.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewFichaControle.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewFichaControle().setVisible(true);
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
    private javax.swing.JComboBox<String> cbComposto;
    private javax.swing.JComboBox<String> cbEquipamento;
    private javax.swing.JComboBox<String> cbLaboratorio;
    private javax.swing.JComboBox<String> cbOrigem;
    private javax.swing.JComboBox<String> cbProduto;
    private javax.swing.JComboBox<String> cbReferencia;
    private javax.swing.JComboBox<String> cbTeste;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JComboBox<String> cbUnidFreq;
    private javax.swing.JComboBox<String> cbUnidMed;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCod;
    private javax.swing.JLabel lbComposto;
    private javax.swing.JLabel lbEquipamento;
    private javax.swing.JLabel lbEspecMax;
    private javax.swing.JLabel lbEspecMin;
    private javax.swing.JLabel lbEspecTexto;
    private javax.swing.JLabel lbFrequencia;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbLaboratorio;
    private javax.swing.JLabel lbLinha;
    private javax.swing.JLabel lbObs;
    private javax.swing.JLabel lbObservacaoQL;
    private javax.swing.JLabel lbOrdem;
    private javax.swing.JLabel lbOrigem;
    private javax.swing.JLabel lbPerfil;
    private javax.swing.JLabel lbProduto;
    private javax.swing.JLabel lbReferencia;
    private javax.swing.JLabel lbTeste;
    private javax.swing.JLabel lbTipo;
    private javax.swing.JLabel lbUnidFreq;
    private javax.swing.JLabel lbUnidMed;
    private javax.swing.JTable tbFicha;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtEspecMax;
    private javax.swing.JTextField txtEspecMin;
    private javax.swing.JTextField txtEspecTexto;
    private javax.swing.JSpinner txtFrequencia;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLinha;
    private javax.swing.JTextField txtMaterial;
    private javax.swing.JTextField txtObs;
    private javax.swing.JTextField txtObservacaoQL;
    private javax.swing.JSpinner txtOrdem;
    // End of variables declaration//GEN-END:variables
}

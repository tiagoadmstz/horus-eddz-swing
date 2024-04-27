package com.cooperstandard.views.acabamento;

import com.cooperstandard.views.extrusao.ViewProjeto;
import com.cooperstandard.views.qualidade.ViewFichaControleQualidadeAc;
import com.cooperstandard.controller.extrusao.ControllerProjeto;
import com.cooperstandard.views.principal.AguardeGerandoRelatório;
import com.cooperstandard.model.ModelLinha;
import com.cooperstandard.model.ModelMaterial;
import com.cooperstandard.model.ModelProjeto;
import com.cooperstandard.util.ControleInstancias;
import com.cooperstandard.util.EstiloTablaRenderer;
import com.cooperstandard.util.HeaderRenderer;
import com.cooperstandard.util.SalvarImagem;
import com.cooperstandard.controller.acabamento.ControllerLinhaAc;
import com.cooperstandard.controller.acabamento.ControllerMaterial;
import java.awt.Image;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author rsouza10
 */
public class ViewMaterialAc extends javax.swing.JFrame {

    ModelMaterial modelMaterial = new ModelMaterial();
    ControllerMaterial controllerMaterial = new ControllerMaterial();
    ArrayList<ModelMaterial> listaModelMaterial = new ArrayList<>();
    ControllerLinhaAc controllerLinha = new ControllerLinhaAc();
    ArrayList<ModelLinha> listaModelLinha = new ArrayList<>();
    ControllerProjeto controllerProjeto = new ControllerProjeto();
    ArrayList<ModelProjeto> listaModelProjeto = new ArrayList<>();
    String tipoCadastro;
    private JFrame solicitante = null;

    public ViewMaterialAc() {
        initComponents();
        carregaMaterial();
        listarLinha();
        listarProjeto();
        tbMaterial.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbMaterial));
        tbMaterial.setDefaultRenderer(String.class, new EstiloTablaRenderer());
        tbMaterial.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
    }

    public ViewMaterialAc(JFrame frame) {
        initComponents();
        carregaMaterial();
        listarLinha();
        listarProjeto();
        solicitante = frame;
        tbMaterial.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbMaterial));
        tbMaterial.setDefaultRenderer(String.class, new EstiloTablaRenderer());
        tbMaterial.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
    }

    public void setSolicitante(JFrame solicitante) {
        this.solicitante = solicitante;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbMaterial = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lbBpcs = new javax.swing.JLabel();
        txtBpcs = new javax.swing.JTextField();
        lbDescPerfil = new javax.swing.JLabel();
        txtDescMaterial = new javax.swing.JTextField();
        lbLinha = new javax.swing.JLabel();
        lbProjeto = new javax.swing.JLabel();
        lbDesenho = new javax.swing.JLabel();
        txtDesenho = new javax.swing.JTextField();
        lbPlano = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPlano = new javax.swing.JTextField();
        txtImagem = new javax.swing.JTextField();
        btnImagem = new javax.swing.JButton();
        cbLinha = new javax.swing.JComboBox<>();
        cbProjeto = new javax.swing.JComboBox<>();
        lbMaterial = new javax.swing.JLabel();
        lbId1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        txtBusca = new javax.swing.JTextField();
        lbImagem = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtId = new javax.swing.JFormattedTextField();
        lbId = new javax.swing.JLabel();
        txtMaterial = new javax.swing.JFormattedTextField();
        btnImagem1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtImagem1 = new javax.swing.JTextField();
        lbl_img = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Material");

        tbMaterial.setAutoCreateRowSorter(true);
        tbMaterial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Material", "Bpcs", "Desc. Material", "Célula", "Projeto", "N. Desenho", "N. Plano", "Imagem Topo", "Imagem Rodapé"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbMaterial.setFocusable(false);
        tbMaterial.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tbMaterial);
        if (tbMaterial.getColumnModel().getColumnCount() > 0) {
            tbMaterial.getColumnModel().getColumn(0).setMinWidth(0);
            tbMaterial.getColumnModel().getColumn(0).setMaxWidth(0);
            tbMaterial.getColumnModel().getColumn(1).setMinWidth(110);
            tbMaterial.getColumnModel().getColumn(1).setMaxWidth(110);
            tbMaterial.getColumnModel().getColumn(2).setMinWidth(70);
            tbMaterial.getColumnModel().getColumn(2).setMaxWidth(70);
            tbMaterial.getColumnModel().getColumn(3).setMinWidth(300);
            tbMaterial.getColumnModel().getColumn(3).setMaxWidth(300);
            tbMaterial.getColumnModel().getColumn(4).setMinWidth(70);
            tbMaterial.getColumnModel().getColumn(4).setMaxWidth(70);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbBpcs.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbBpcs.setText("BPCS:");

        txtBpcs.setEnabled(false);

        lbDescPerfil.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbDescPerfil.setText("Desc. Material:");

        txtDescMaterial.setEnabled(false);

        lbLinha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbLinha.setText("Célula:");

        lbProjeto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbProjeto.setText("Projeto:");

        lbDesenho.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbDesenho.setText("Nº Desenho:");

        txtDesenho.setEnabled(false);

        lbPlano.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbPlano.setText("Nº Plano:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Imagem do Topo:");

        txtPlano.setEnabled(false);
        txtPlano.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPlanoFocusGained(evt);
            }
        });

        txtImagem.setEnabled(false);

        btnImagem.setBackground(new java.awt.Color(255, 255, 255));
        btnImagem.setText("...");
        btnImagem.setEnabled(false);
        btnImagem.setFocusable(false);
        btnImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagemActionPerformed(evt);
            }
        });

        cbLinha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLinha.setEnabled(false);

        cbProjeto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbProjeto.setEnabled(false);

        lbMaterial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbMaterial.setText("Material:");

        lbId1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbId1.setText("Buscar:");

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-pdf-2-filled-50.png"))); // NOI18N
        jButton3.setText("Visualizar/Imprimir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtBusca.setBackground(new java.awt.Color(255, 255, 204));
        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaKeyReleased(evt);
            }
        });

        lbImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-binóculos-filled-50.png"))); // NOI18N

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

        txtId.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##########"))));
        txtId.setEnabled(false);

        lbId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbId.setText("Código:");

        txtMaterial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("######"))));
        txtMaterial.setEnabled(false);

        btnImagem1.setBackground(new java.awt.Color(255, 255, 255));
        btnImagem1.setText("...");
        btnImagem1.setEnabled(false);
        btnImagem1.setFocusable(false);
        btnImagem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagem1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Imagem do Rodapé:");

        txtImagem1.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbId)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMaterial)
                            .addComponent(txtMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbBpcs)
                            .addComponent(txtBpcs, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescMaterial)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbDescPerfil)
                                .addGap(0, 428, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLinha)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbProjeto)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDesenho)
                            .addComponent(txtDesenho, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbPlano)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtPlano))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(29, 29, 29))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtImagem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(btnImagem)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtImagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnImagem1))
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbId1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtBusca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(txtDescMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lbId)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbMaterial)
                            .addComponent(lbBpcs)
                            .addComponent(lbDescPerfil))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBpcs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtImagem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnImagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lbLinha)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbLinha)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lbPlano)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbDesenho)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDesenho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbProjeto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbProjeto)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbId1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3)
                    .addComponent(lbImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl_img.setFocusable(false);

        jPanel2.setBackground(new java.awt.Color(94, 94, 117));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnLimpar.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-n¦o-perturbe-filled-50.png"))); // NOI18N
        btnLimpar.setText("Cancelar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(255, 255, 255));
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-excluir-filled-50.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
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

        btnNovo.setBackground(new java.awt.Color(255, 255, 255));
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-joyent-filled-20 (1).png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-salvar-filled-50.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 456, Short.MAX_VALUE)
                        .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnExcluir)
                        .addComponent(btnAlterar)
                        .addComponent(btnNovo)
                        .addComponent(btnLimpar))
                    .addComponent(btnSalvar))
                .addContainerGap())
        );

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

    private void btnImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagemActionPerformed
        SalvarImagem t = new SalvarImagem();
        txtImagem.setText(t.selecionarArquivoSalvarOutraPastaEPegarPathNovo("Selecionar imagem"));
        ImprimiImagem();
    }//GEN-LAST:event_btnImagemActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        this.desabilitarCampos();
        limparDados();
        btnSalvar.setEnabled(false);
        btnImagem.setEnabled(false);
        btnImagem1.setEnabled(false);
        ImprimiImagem();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linhasselecionada = tbMaterial.getSelectedRow();

        if (linhasselecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            this.excluirMaterial();
            limparDados();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linhasselecionada = tbMaterial.getSelectedRow();

        if (linhasselecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            novoProjeto();
            btnSalvar.setEnabled(true);
            btnImagem.setEnabled(true);
            btnImagem1.setEnabled(true);
            habilitarCampos();
            recuperarMaterial();
            tipoCadastro = "alteracao";

        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        novoProjeto();
        btnSalvar.setEnabled(true);
        btnImagem.setEnabled(true);
        btnImagem1.setEnabled(true);
        habilitarCampos();
        tipoCadastro = "novo";
        txtMaterial.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (tipoCadastro.equals("novo")) {
            if (txtMaterial.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtMaterial.requestFocus();
            } else if (txtBpcs.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtBpcs.requestFocus();
            } else if (txtDescMaterial.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtDescMaterial.requestFocus();
            } else if (cbLinha.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                cbLinha.requestFocus();
            } else if (cbProjeto.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                cbProjeto.requestFocus();
            } else if (txtDesenho.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtDesenho.requestFocus();
            } else if (txtPlano.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtPlano.requestFocus();
            } else {
                salvarMaterial();
            }
        } else if (tipoCadastro.equals("alteracao")) {
            if (txtMaterial.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtMaterial.requestFocus();
            } else if (txtBpcs.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtBpcs.requestFocus();
            } else if (txtDescMaterial.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtDescMaterial.requestFocus();
            } else if (cbLinha.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                cbLinha.requestFocus();
            } else if (cbProjeto.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                cbProjeto.requestFocus();
            } else if (txtDesenho.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtDesenho.requestFocus();
            } else if (txtPlano.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo obrigatório!", "ERRO", JOptionPane.WARNING_MESSAGE);
                txtPlano.requestFocus();
            } else {
                alterarMaterial();
                btnSalvar.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyReleased
        DefaultTableModel tabela = (DefaultTableModel) this.tbMaterial.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabela);
        this.tbMaterial.setRowSorter(sorter);
        String text = txtBusca.getText();
        sorter.setRowFilter(RowFilter.regexFilter(text, 1, 2, 3));
    }//GEN-LAST:event_txtBuscaKeyReleased

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked

        ViewProjeto vm = null;
        if (ControleInstancias.isInstaced(ViewProjeto.class)) {
            vm = (ViewProjeto) ControleInstancias.getInstance(ViewProjeto.class.getName(), ViewProjeto.class);
            vm.setSolicitante(this);
        } else {
            vm = new ViewProjeto(this);
        }
        vm.setVisible(true);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked

        ViewLinhaAc vm = null;
        if (ControleInstancias.isInstaced(ViewLinhaAc.class)) {
            vm = (ViewLinhaAc) ControleInstancias.getInstance(ViewLinhaAc.class.getName(), ViewLinhaAc.class);
            vm.setSolicitante(this);
        } else {
            vm = new ViewLinhaAc(this);
        }
        vm.setVisible(true);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        final AguardeGerandoRelatório carregando = new AguardeGerandoRelatório();
        carregando.setVisible(true);
        Thread t = new Thread() {
            public void run() {
                try {
                    String logo = "/images/logocooper.jpg";
                    
                    Connection con = new ConexaoSql().getCon();
                    Map p = new HashMap();
                    p.put("logo", this.getClass().getResourceAsStream(logo));
                    JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Relatorios/listagemmaterialAC.jasper"));

                    JasperPrint print = JasperFillManager.fillReport(jr, p, con);
                    JasperViewer view = new JasperViewer(print, false);
                    view.setTitle("Material");

                    view.setVisible(true);
                } catch (Exception erro) {

                    JOptionPane.showMessageDialog(null, "deu erro =" + erro);
                    System.out.println(erro);

                }
                carregando.dispose();
            }
        };
        t.start();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtPlanoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPlanoFocusGained
        txtPlano.setText(txtMaterial.getText() + " - " + cbLinha.getSelectedItem());
    }//GEN-LAST:event_txtPlanoFocusGained

    private void btnImagem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagem1ActionPerformed
        SalvarImagem t = new SalvarImagem();
        txtImagem1.setText(t.selecionarArquivoSalvarOutraPastaEPegarPathNovo("Selecionar imagem"));
        ImprimiImagem2();        // TODO add your handling code here:
    }//GEN-LAST:event_btnImagem1ActionPerformed

    public void addItemLista(String item) {
        cbLinha.addItem(item);
        cbProjeto.addItem(item);
        listarLinha();
        listarProjeto();
    }

    private void listarLinha() {
        listaModelLinha = controllerLinha.getListaLinhaAcController();
        cbLinha.removeAllItems();
        for (int i = 0; i < listaModelLinha.size(); i++) {
            cbLinha.addItem(listaModelLinha.get(i).getLinha());
        }
    }

    private void listarProjeto() {
        listaModelProjeto = controllerProjeto.getListaProjetoController();
        cbProjeto.removeAllItems();
        for (int i = 0; i < listaModelProjeto.size(); i++) {
            cbProjeto.addItem(listaModelProjeto.get(i).getProjeto());
        }
    }

    private void excluirMaterial() {
        int linha = tbMaterial.getSelectedRow();
        int nome = (Integer) tbMaterial.getValueAt(linha, 1);
        int codigo = (Integer) tbMaterial.getValueAt(linha, 0);
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
                + " excluir o registro \nNome: "
                + nome + " ?", "Atenção", JOptionPane.YES_OPTION);

        if (opcao == JOptionPane.OK_OPTION) {
            if (controllerMaterial.excluirMaterialAcController(codigo)) {
                JOptionPane.showMessageDialog(this, "Registro excluido com sucesso!");
                carregaMaterial();
                if (solicitante != null) {
                    if (solicitante instanceof ViewFichaControleAc) {
                        ViewFichaControleAc vp = (ViewFichaControleAc) solicitante;
                        vp.addItemLista(txtMaterial.getText());
                    } else if (solicitante instanceof ViewFichaControleQualidadeAc) {
                        ViewFichaControleQualidadeAc vp = (ViewFichaControleQualidadeAc) solicitante;
                        vp.addItemLista(txtMaterial.getText());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean salvarMaterial() {
        modelMaterial.setMaterial(Integer.parseInt(this.txtMaterial.getText()));
        modelMaterial.setBpcs(this.txtBpcs.getText());
        modelMaterial.setDesc_material(this.txtDescMaterial.getText());
        modelMaterial.setMat_linha(this.cbLinha.getSelectedItem().toString());
        modelMaterial.setMat_projeto(this.cbProjeto.getSelectedItem().toString());
        modelMaterial.setN_desenho(this.txtDesenho.getText());
        modelMaterial.setN_plano(this.txtPlano.getText());
        modelMaterial.setImagem(this.txtImagem.getText());
        modelMaterial.setImagemr(this.txtImagem1.getText());
        if (controllerMaterial.salvarMaterialAcController(modelMaterial) > 0) {
            JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
            this.desabilitarCampos();
            this.carregaMaterial();
            if (solicitante != null) {
                if (solicitante instanceof ViewFichaControleAc) {
                    ViewFichaControleAc vp = (ViewFichaControleAc) solicitante;
                    vp.addItemLista(txtMaterial.getText());
                } else if (solicitante instanceof ViewFichaControleQualidadeAc) {
                    ViewFichaControleQualidadeAc vp = (ViewFichaControleQualidadeAc) solicitante;
                    vp.addItemLista(txtMaterial.getText());
                }
            }
            limparDados();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao tentar gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private boolean recuperarMaterial() {
        int linha = this.tbMaterial.getSelectedRow();
        int codigo = (Integer) tbMaterial.getValueAt(linha, 0);
        try {
            modelMaterial = controllerMaterial.getMaterialAcController(codigo);
            this.txtId.setText(String.valueOf(modelMaterial.getId_material()));
            this.txtMaterial.setText(String.valueOf(modelMaterial.getMaterial()));
            this.txtBpcs.setText(modelMaterial.getBpcs());
            this.txtDescMaterial.setText(modelMaterial.getDesc_material());
            this.cbLinha.setSelectedItem(modelMaterial.getMat_linha());
            this.cbProjeto.setSelectedItem(modelMaterial.getMat_projeto());
            this.txtDesenho.setText(modelMaterial.getN_desenho());
            this.txtPlano.setText(modelMaterial.getN_plano());
            this.txtImagem.setText(modelMaterial.getImagem());
            this.txtImagem1.setText(modelMaterial.getImagemr());
            ImprimiImagem();
            ImprimiImagem2();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código inválido ou nenhum registro selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private boolean alterarMaterial() {
        modelMaterial.setMaterial(Integer.parseInt(this.txtMaterial.getText()));
        modelMaterial.setBpcs(this.txtBpcs.getText());
        modelMaterial.setDesc_material(this.txtDescMaterial.getText());
        modelMaterial.setMat_linha(this.cbLinha.getSelectedItem().toString());
        modelMaterial.setMat_projeto(this.cbProjeto.getSelectedItem().toString());
        modelMaterial.setN_desenho(this.txtDesenho.getText());
        modelMaterial.setN_plano(this.txtPlano.getText());
        modelMaterial.setImagem(this.txtImagem.getText());
        modelMaterial.setImagemr(this.txtImagem1.getText());
        if (controllerMaterial.atualizarMaterialAcController(modelMaterial)) {
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
            this.desabilitarCampos();
            this.carregaMaterial();
            if (solicitante != null) {
                if (solicitante instanceof ViewFichaControleAc) {
                    ViewFichaControleAc vp = (ViewFichaControleAc) solicitante;
                    vp.addItemLista(txtMaterial.getText());
                } else if (solicitante instanceof ViewFichaControleQualidadeAc) {
                    ViewFichaControleQualidadeAc vp = (ViewFichaControleQualidadeAc) solicitante;
                    vp.addItemLista(txtMaterial.getText());
                }
            }
            limparDados();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void carregaMaterial() {
        listaModelMaterial = controllerMaterial.getListaMaterialAcController();
        DefaultTableModel modelo = (DefaultTableModel) tbMaterial.getModel();
        modelo.setNumRows(0);
        int cont = listaModelMaterial.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelMaterial.get(i).getId_material(),
                listaModelMaterial.get(i).getMaterial(),
                listaModelMaterial.get(i).getBpcs(),
                listaModelMaterial.get(i).getDesc_material(),
                listaModelMaterial.get(i).getMat_linha(),
                listaModelMaterial.get(i).getMat_projeto(),
                listaModelMaterial.get(i).getN_desenho(),
                listaModelMaterial.get(i).getN_plano(),
                listaModelMaterial.get(i).getImagem(),
                listaModelMaterial.get(i).getImagemr()

            });

        }

    }

    public void desabilitarCampos() {
        txtMaterial.setEnabled(false);
        txtBpcs.setEnabled(false);
        txtDescMaterial.setEnabled(false);
        cbLinha.setEnabled(false);
        cbProjeto.setEnabled(false);
        txtDesenho.setEnabled(false);
        txtPlano.setEnabled(false);
        btnImagem.setEnabled(false);
        btnImagem1.setEnabled(false);
    }

    public void limparDados() {
        txtId.setText("");
        txtBusca.setText("");
        txtMaterial.setText("");
        txtBpcs.setText("");
        txtDescMaterial.setText("");
        cbLinha.setSelectedIndex(-1);
        cbProjeto.setSelectedIndex(-1);
        txtDesenho.setText("");
        txtPlano.setText("");
        txtImagem.setText("");
        txtImagem1.setText("");
    }

    public void novoProjeto() {
        habilitarCampos();
        txtBusca.setText("");
        txtMaterial.setText("");
        txtBpcs.setText("N/A");
        txtDescMaterial.setText("");
        cbLinha.setSelectedIndex(-1);
        cbProjeto.setSelectedIndex(-1);
        txtDesenho.setText("");
        txtPlano.setText("");
        txtId.setText("Novo");
    }

    public void habilitarCampos() {
        txtMaterial.setEnabled(true);
        txtBpcs.setEnabled(true);
        txtDescMaterial.setEnabled(true);
        cbLinha.setEnabled(true);
        cbProjeto.setEnabled(true);
        txtDesenho.setEnabled(true);
        txtPlano.setEnabled(true);
    }

    public void ImprimiImagem() {
        ImageIcon img = new ImageIcon(txtImagem.getText());
        jLabel9.setIcon(img);
        ImageIcon image = new ImageIcon(txtImagem.getText());
        jLabel9.setIcon(new ImageIcon(image.getImage().getScaledInstance(jLabel9.getWidth(), jLabel9.getHeight(), Image.SCALE_DEFAULT)));
    }

    public void ImprimiImagem2() {
        ImageIcon img = new ImageIcon(txtImagem1.getText());
        jLabel9.setIcon(img);
        ImageIcon image = new ImageIcon(txtImagem1.getText());
        jLabel9.setIcon(new ImageIcon(image.getImage().getScaledInstance(jLabel9.getWidth(), jLabel9.getHeight(), Image.SCALE_DEFAULT)));
    }

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
            java.util.logging.Logger.getLogger(ViewMaterialAc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMaterialAc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMaterialAc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMaterialAc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMaterialAc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnImagem;
    private javax.swing.JButton btnImagem1;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbLinha;
    private javax.swing.JComboBox<String> cbProjeto;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbBpcs;
    private javax.swing.JLabel lbDescPerfil;
    private javax.swing.JLabel lbDesenho;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbId1;
    private javax.swing.JLabel lbImagem;
    private javax.swing.JLabel lbLinha;
    private javax.swing.JLabel lbMaterial;
    private javax.swing.JLabel lbPlano;
    private javax.swing.JLabel lbProjeto;
    private javax.swing.JLabel lbl_img;
    private javax.swing.JTable tbMaterial;
    private javax.swing.JTextField txtBpcs;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtDescMaterial;
    private javax.swing.JTextField txtDesenho;
    private javax.swing.JFormattedTextField txtId;
    private javax.swing.JTextField txtImagem;
    private javax.swing.JTextField txtImagem1;
    private javax.swing.JFormattedTextField txtMaterial;
    private javax.swing.JTextField txtPlano;
    // End of variables declaration//GEN-END:variables

}

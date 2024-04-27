package com.cooperstandard.views.extrusao;

import com.cooperstandard.controller.extrusao.ControllerProducao;
import com.cooperstandard.controller.extrusao.ControllerResultado;
import com.cooperstandard.controller.extrusao.ControllerRodape;
import com.cooperstandard.model.ModelProducao;
import com.cooperstandard.model.ModelResultado;
import com.cooperstandard.model.ModelRodape;
import com.cooperstandard.model.ModelSessaoUsuario;
import com.cooperstandard.util.CustomRenderer2;
import com.cooperstandard.util.Datas;
import com.cooperstandard.util.EstiloTablaRenderer;
import com.cooperstandard.util.EstiloTablaRenderer1;
import com.cooperstandard.util.HeaderRenderer;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import com.cooperstandard.dbs.ConexaoSql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rsouza10
 */
public class ViewResultado extends javax.swing.JFrame {
    
    private static final long serialVersionUID = 752246168589400763L;
    
    ModelRodape modelRodape = new ModelRodape();
    ControllerRodape controllerRodape = new ControllerRodape();
    ArrayList<ModelRodape> listaModelRodape = new ArrayList<ModelRodape>();
    ModelProducao modelProducao = new ModelProducao();
    ControllerProducao controllerProducao = new ControllerProducao();
    ArrayList<ModelProducao> listaModelProducao = new ArrayList<ModelProducao>();
    ModelResultado modelResultado = new ModelResultado();
    ControllerResultado controllerResultado = new ControllerResultado();
    ArrayList<ModelResultado> listaModelResultado = new ArrayList<ModelResultado>();
    int pNomeUsuario;
    String datahora;
    String perfil;
    String registro;
    String status;
    String hora;
    String linha;
    
    public ViewResultado() {
        initComponents();
    }
    
    public ViewResultado(String _datahora, String _perfil, String _registro, String _status, String _hora, String _linha) {
        initComponents();
        registro = _registro;
        txtRegistro.setText(registro);
        perfil = _perfil;
        txtMaterial.setText(perfil);
        datahora = _datahora;
        hora = _hora;
        linha = _linha;
        lbl_envialinha.setText(linha);
        status = _status;
        if (status.equals("supervisorio")) {
            txtData.setText(datahora.split(" ")[0]);
            txtHora.setText(datahora.split(" ")[1]);
        }
        if (status.equals("fichanormal")) {
            txtData.setText(datahora);
            txtHora.setText(hora);
        }
        jPanel6.setVisible(false);
        btnDown.setVisible(false);
        tbResultado.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbResultado));
        tbResultado.setDefaultRenderer(String.class, new EstiloTablaRenderer1());
        tbResultado.setDefaultRenderer(Integer.class, new EstiloTablaRenderer1());
        tbResultado.setDefaultRenderer(Float.class, new EstiloTablaRenderer1());
        tbDiario.getTableHeader().setDefaultRenderer(new HeaderRenderer(tbDiario));
        tbDiario.setDefaultRenderer(String.class, new EstiloTablaRenderer());
        tbDiario.setDefaultRenderer(Integer.class, new EstiloTablaRenderer());
        tbResultado.getColumnModel().getColumn(3).setCellRenderer(new CustomRenderer2());
        tbResultado.setRowHeight(22);
        tbResultado.setColumnSelectionAllowed(true);
        setExtendedState(MAXIMIZED_BOTH);
        this.getvalor();
        carregaFicha();
        configurar();
        carregarodape();
        this.verifica();
        
    }
    
    public void VerificarResultdo() {
        int linha = tbResultado.getSelectedRow();
        int coluna = tbResultado.getSelectedColumn();
        String tipo = tbResultado.getValueAt(linha, 9).toString();
        String snreferencia = tbResultado.getValueAt(linha, 8).toString();
        if (tipo.contains("Texto") && !snreferencia.contains("Sim")) {
            
            String valor1 = tbResultado.getValueAt(linha, 7).toString(); //Especificacao
            String valor2 = tbResultado.getValueAt(linha, 14).toString(); //Valor digitado pelo usuario  
            if (valor1.equals(valor2)) {
                tbResultado.setValueAt("Aprovado", linha, 16);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 16);
            }
            Object obj = tbResultado.getValueAt(linha, 14);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 16);
            }
        } else if (tipo.contains("Min e Max") && !snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 13);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 16);
            }
            Float valornumerico = Float.parseFloat(tbResultado.getValueAt(linha, 13).toString()); //Valor digitado pelo usuario   
            if (valornumerico >= Float.parseFloat(tbResultado.getValueAt(linha, 5).toString()) && valornumerico <= Float.parseFloat(tbResultado.getValueAt(linha, 6).toString())) {
                tbResultado.setValueAt("Aprovado", linha, 16);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 16);
            }
        } else if (tipo.contains("No Min") && !snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 13);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 16);
            }
            Float valornumerico = Float.parseFloat(tbResultado.getValueAt(linha, 13).toString()); //Valor digitado pelo usuario   
            if (valornumerico >= Float.parseFloat(tbResultado.getValueAt(linha, 5).toString())) {
                tbResultado.setValueAt("Aprovado", linha, 16);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 16);
            }
        } else if (tipo.contains("No Max") && !snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 13);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 16);
            }
            Float valornumerico = Float.parseFloat(tbResultado.getValueAt(linha, 13).toString()); //Valor digitado pelo usuario   
            if (valornumerico <= Float.parseFloat(tbResultado.getValueAt(linha, 6).toString())) {
                tbResultado.setValueAt("Aprovado", linha, 16);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 16);
            }
        } else if (tipo.contains("ValorUnico") && !snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 13);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 16);
            }
            Float valornumerico = Float.parseFloat(tbResultado.getValueAt(linha, 13).toString()); //Valor digitado pelo usuario 
            if (valornumerico == Float.parseFloat(tbResultado.getValueAt(linha, 5).toString())) {
                tbResultado.setValueAt("Aprovado", linha, 16);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 16);
            }
        } else if (snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 13);
            Object obj2 = tbResultado.getValueAt(linha, 14);
            
            if ((obj == null || obj.toString().equals("")) && (obj2 == null || obj2.toString().equals(""))) {
                tbResultado.setValueAt("", linha, 16);
            } else {
                tbResultado.setValueAt("Referência", linha, 16);
            }
            
        }
    }
    
    public void VerificarResultdoEnter() {
        int linha = tbResultado.getSelectedRow() - 1;
        int coluna = tbResultado.getSelectedColumn();
        String tipo = tbResultado.getValueAt(linha, 9).toString();
        String snreferencia = tbResultado.getValueAt(linha, 8).toString();
        if (tipo.contains("Texto") && !snreferencia.contains("Sim")) {
            
            String valor1 = tbResultado.getValueAt(linha, 7).toString(); //Especificacao
            String valor2 = tbResultado.getValueAt(linha, 14).toString(); //Valor digitado pelo usuario  
            if (valor1.equals(valor2)) {
                tbResultado.setValueAt("Aprovado", linha, 16);
//                tbResultado.isCellEditable(linha, 15);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 16);
            }
            Object obj = tbResultado.getValueAt(linha, 14);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 16);
            }
        } else if (tipo.contains("Min e Max") && !snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 13);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 16);
            }
            Float valornumerico = Float.parseFloat(tbResultado.getValueAt(linha, 13).toString()); //Valor digitado pelo usuario   
            if (valornumerico >= Float.parseFloat(tbResultado.getValueAt(linha, 5).toString()) && valornumerico <= Float.parseFloat(tbResultado.getValueAt(linha, 6).toString())) {
                tbResultado.setValueAt("Aprovado", linha, 16);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 16);
//                tbResultado.isCellEditable(linha, 15);
            }
        } else if (tipo.contains("No Min") && !snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 13);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 16);
            }
            Float valornumerico = Float.parseFloat(tbResultado.getValueAt(linha, 13).toString()); //Valor digitado pelo usuario   
            if (valornumerico >= Float.parseFloat(tbResultado.getValueAt(linha, 5).toString())) {
                tbResultado.setValueAt("Aprovado", linha, 16);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 16);
//                tbResultado.isCellEditable(linha, 15);
            }
        } else if (tipo.contains("No Max") && !snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 13);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 16);
            }
            Float valornumerico = Float.parseFloat(tbResultado.getValueAt(linha, 13).toString()); //Valor digitado pelo usuario   
            if (valornumerico <= Float.parseFloat(tbResultado.getValueAt(linha, 6).toString())) {
                tbResultado.setValueAt("Aprovado", linha, 16);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 16);
//                tbResultado.isCellEditable(linha, 15);
            }
        } else if (tipo.contains("ValorUnico") && !snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 13);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 16);
            }
            Float valornumerico = Float.parseFloat(tbResultado.getValueAt(linha, 13).toString()); //Valor digitado pelo usuario 
            if (valornumerico == Float.parseFloat(tbResultado.getValueAt(linha, 5).toString())) {
                tbResultado.setValueAt("Aprovado", linha, 16);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 16);
//                tbResultado.isCellEditable(linha, 15);
            }
        } else if (snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 13);
            Object obj2 = tbResultado.getValueAt(linha, 14);
            
            if ((obj == null || obj.toString().equals("")) && (obj2 == null || obj2.toString().equals(""))) {
                tbResultado.setValueAt("", linha, 16);
            } else {
                tbResultado.setValueAt("Referência", linha, 16);
            }
            
        }
    }
    
    public void VerificarResultdoUltimaLinha() {
        int linha = tbResultado.getRowCount() - 1;
        int coluna = tbResultado.getSelectedColumn();
        String tipo = tbResultado.getValueAt(linha, 9).toString();
        String snreferencia = tbResultado.getValueAt(linha, 8).toString();
        String valor1 = tbResultado.getValueAt(linha, 7).toString(); //Especificacao
        String valor2 = tbResultado.getValueAt(linha, 14).toString(); //Valor digitado pelo usuario  
        if (tipo.contains("Texto") && !snreferencia.contains("Sim")) {
            if (valor1.equals(valor2)) {
                tbResultado.setValueAt("Aprovado", linha, 16);
//                tbResultado.isCellEditable(linha, 15);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 16);
            }
            Object obj = tbResultado.getValueAt(linha, 14);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 16);
            }
        } else if (tipo.contains("Min e Max") && !snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 13);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 16);
            }
            Float valornumerico = Float.parseFloat(tbResultado.getValueAt(linha, 13).toString()); //Valor digitado pelo usuario   
            if (valornumerico >= Float.parseFloat(tbResultado.getValueAt(linha, 5).toString()) && valornumerico <= Float.parseFloat(tbResultado.getValueAt(linha, 6).toString())) {
                tbResultado.setValueAt("Aprovado", linha, 16);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 16);
//                tbResultado.isCellEditable(linha, 15);
            }
        } else if (tipo.contains("No Min") && !snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 13);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 16);
            }
            Float valornumerico = Float.parseFloat(tbResultado.getValueAt(linha, 13).toString()); //Valor digitado pelo usuario   
            if (valornumerico >= Float.parseFloat(tbResultado.getValueAt(linha, 5).toString())) {
                tbResultado.setValueAt("Aprovado", linha, 16);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 16);
//                tbResultado.isCellEditable(linha, 15);
            }
        } else if (tipo.contains("No Max") && !snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 13);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 16);
            }
            Float valornumerico = Float.parseFloat(tbResultado.getValueAt(linha, 13).toString()); //Valor digitado pelo usuario   
            if (valornumerico <= Float.parseFloat(tbResultado.getValueAt(linha, 6).toString())) {
                tbResultado.setValueAt("Aprovado", linha, 16);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 16);
//                tbResultado.isCellEditable(linha, 15);
            }
        } else if (tipo.contains("ValorUnico") && !snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 13);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 16);
            }
            Float valornumerico = Float.parseFloat(tbResultado.getValueAt(linha, 13).toString()); //Valor digitado pelo usuario 
            if (valornumerico == Float.parseFloat(tbResultado.getValueAt(linha, 5).toString())) {
                tbResultado.setValueAt("Aprovado", linha, 16);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 16);
//                tbResultado.isCellEditable(linha, 15);
            }
        } else if (snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 13);
            Object obj2 = tbResultado.getValueAt(linha, 14);
            
            if ((obj == null || obj.toString().equals("")) && (obj2 == null || obj2.toString().equals(""))) {
                tbResultado.setValueAt("", linha, 16);
            } else {
                tbResultado.setValueAt("Referência", linha, 16);
            }
            
        }
    }
    
    private void TabPreenchimento() {
        int coluna = tbResultado.getSelectedColumn();
        int linha = tbResultado.getSelectedRow();
        
        if (tbResultado.getValueAt(linha + 1, 9).toString().contains("Texto")) {
            tbResultado.changeSelection(linha + 1, 14, false, false);
        } else if (tbResultado.getValueAt(linha + 1, 9).toString().contains("Min e Max")) {
            tbResultado.changeSelection(linha + 1, 13, false, false);
        } else if (tbResultado.getValueAt(linha + 1, 9).toString().contains("No Max")) {
            tbResultado.changeSelection(linha + 1, 13, false, false);
        } else if (tbResultado.getValueAt(linha + 1, 9).toString().contains("No Min")) {
            tbResultado.changeSelection(linha + 1, 13, false, false);
        } else if (tbResultado.getValueAt(linha + 1, 9).toString().contains("ValorUnico")) {
            tbResultado.changeSelection(linha + 1, 13, false, false);
        }
    }
    
    private void EnterPreenchimento() {
        int coluna = tbResultado.getSelectedColumn();
        int linha = tbResultado.getSelectedRow();
        
        if (tbResultado.getValueAt(linha, 9).toString().contains("Texto")) {
            tbResultado.changeSelection(linha, 14, false, false);
        } else if (tbResultado.getValueAt(linha, 9).toString().contains("Min e Max")) {
            tbResultado.changeSelection(linha, 13, false, false);
        } else if (tbResultado.getValueAt(linha, 9).toString().contains("No Max")) {
            tbResultado.changeSelection(linha, 13, false, false);
        } else if (tbResultado.getValueAt(linha, 9).toString().contains("No Min")) {
            tbResultado.changeSelection(linha, 13, false, false);
        } else if (tbResultado.getValueAt(linha, 9).toString().contains("ValorUnico")) {
            tbResultado.changeSelection(linha, 13, false, false);
        }
    }
    
    public JTable getTbResultado() {
        return tbResultado;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbl_envialinha = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbMaterial = new javax.swing.JLabel();
        txtMaterial = new javax.swing.JTextField();
        lbCliente = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        lbDescMaterial = new javax.swing.JLabel();
        txtDescMaterial = new javax.swing.JTextField();
        lbDesenho = new javax.swing.JLabel();
        txtDesenho = new javax.swing.JTextField();
        lbPlano = new javax.swing.JLabel();
        txtPlano = new javax.swing.JTextField();
        lbData = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        lbHora = new javax.swing.JLabel();
        lbRegistro = new javax.swing.JLabel();
        txtRegistro = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        txtProcesso = new javax.swing.JTextField();
        lbProcesso = new javax.swing.JLabel();
        txtProduto = new javax.swing.JTextField();
        lbProduto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbResultado = new javax.swing.JTable();
        btnUp = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbDiario = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDiario = new javax.swing.JTextArea();
        btnDown = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Resultado");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Ficha de Controle de Extrusão");

        lbl_envialinha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cooper-standard-original_1.jpg"))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbMaterial.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbMaterial.setText("Número da Peça:");

        txtMaterial.setEditable(false);
        txtMaterial.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMaterial.setEnabled(false);

        lbCliente.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbCliente.setText("Cliente:");

        txtCliente.setEditable(false);
        txtCliente.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCliente.setEnabled(false);

        lbDescMaterial.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbDescMaterial.setText("Descrição da Peça:");

        txtDescMaterial.setEditable(false);
        txtDescMaterial.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDescMaterial.setEnabled(false);

        lbDesenho.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbDesenho.setText("Número do Desenho:");

        txtDesenho.setEditable(false);
        txtDesenho.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDesenho.setEnabled(false);

        lbPlano.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbPlano.setText("Número do Plano:");

        txtPlano.setEditable(false);
        txtPlano.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPlano.setEnabled(false);

        lbData.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbData.setText("Data de Entrada:");

        txtData.setEditable(false);
        txtData.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtData.setEnabled(false);

        lbHora.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbHora.setText("Hora de Entrada:");

        lbRegistro.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbRegistro.setText("Registro:");

        txtRegistro.setEditable(false);
        txtRegistro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtRegistro.setEnabled(false);

        txtHora.setEditable(false);
        txtHora.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtHora.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lbMaterial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaterial))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lbCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCliente)))
                        .addGap(18, 18, 18)
                        .addComponent(lbDesenho)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDesenho, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lbDescMaterial)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(233, 233, 233)
                                .addComponent(lbPlano)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPlano, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDescMaterial)))))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lbHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(lbRegistro)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtRegistro))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(lbData)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaterial)
                    .addComponent(txtMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDesenho)
                    .addComponent(txtDesenho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHora)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCliente)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPlano)
                    .addComponent(txtPlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbData)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDescMaterial)
                    .addComponent(txtDescMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbRegistro)
                    .addComponent(txtRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtProcesso.setEditable(false);
        txtProcesso.setBackground(new java.awt.Color(153, 153, 153));
        txtProcesso.setFocusable(false);

        lbProcesso.setText("Processo");

        txtProduto.setEditable(false);
        txtProduto.setFocusable(false);

        lbProduto.setText("Produto");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbProcesso)
                        .addGap(18, 18, 18)
                        .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbProduto))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbProcesso)
                    .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbProduto))
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

        tbResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Operação", "Equipamento", "Desc. Teste", "Complemento", "Min", "Max", "Texto", "Referência", "Tipo", "Especificações", "Produto", "Frequência", "Resultado", "Resultado Texto", "Observação", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbResultado.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbResultado.getTableHeader().setReorderingAllowed(false);
        tbResultado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbResultadoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbResultado);
        if (tbResultado.getColumnModel().getColumnCount() > 0) {
            tbResultado.getColumnModel().getColumn(0).setMinWidth(0);
            tbResultado.getColumnModel().getColumn(0).setMaxWidth(0);
            tbResultado.getColumnModel().getColumn(1).setMinWidth(180);
            tbResultado.getColumnModel().getColumn(2).setMinWidth(200);
            tbResultado.getColumnModel().getColumn(3).setMinWidth(200);
            tbResultado.getColumnModel().getColumn(4).setMinWidth(200);
            tbResultado.getColumnModel().getColumn(5).setMinWidth(0);
            tbResultado.getColumnModel().getColumn(5).setMaxWidth(0);
            tbResultado.getColumnModel().getColumn(6).setMinWidth(0);
            tbResultado.getColumnModel().getColumn(6).setMaxWidth(0);
            tbResultado.getColumnModel().getColumn(7).setMinWidth(0);
            tbResultado.getColumnModel().getColumn(7).setMaxWidth(0);
            tbResultado.getColumnModel().getColumn(8).setMinWidth(0);
            tbResultado.getColumnModel().getColumn(8).setMaxWidth(0);
            tbResultado.getColumnModel().getColumn(9).setMinWidth(0);
            tbResultado.getColumnModel().getColumn(9).setMaxWidth(0);
            tbResultado.getColumnModel().getColumn(10).setMinWidth(200);
            tbResultado.getColumnModel().getColumn(11).setMinWidth(0);
            tbResultado.getColumnModel().getColumn(11).setMaxWidth(0);
            tbResultado.getColumnModel().getColumn(12).setMinWidth(120);
            tbResultado.getColumnModel().getColumn(13).setMinWidth(87);
            tbResultado.getColumnModel().getColumn(14).setMinWidth(87);
            tbResultado.getColumnModel().getColumn(15).setMinWidth(85);
            tbResultado.getColumnModel().getColumn(15).setMaxWidth(0);
            tbResultado.getColumnModel().getColumn(16).setMinWidth(100);
            tbResultado.getColumnModel().getColumn(16).setMaxWidth(100);
        }

        btnUp.setBackground(new java.awt.Color(255, 255, 255));
        btnUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Collapse_Arrow_12px.png"))); // NOI18N
        btnUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpMouseClicked(evt);
            }
        });

        tbDiario.setAutoCreateRowSorter(true);
        tbDiario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Data", "Rev", "Descrição", "Emitente", "Setor", "Responsável"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tbDiario.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane3.setViewportView(tbDiario);
        if (tbDiario.getColumnModel().getColumnCount() > 0) {
            tbDiario.getColumnModel().getColumn(0).setMinWidth(0);
            tbDiario.getColumnModel().getColumn(0).setMaxWidth(0);
            tbDiario.getColumnModel().getColumn(1).setMinWidth(90);
            tbDiario.getColumnModel().getColumn(2).setMinWidth(60);
            tbDiario.getColumnModel().getColumn(3).setMinWidth(680);
            tbDiario.getColumnModel().getColumn(4).setMinWidth(140);
            tbDiario.getColumnModel().getColumn(5).setMinWidth(140);
            tbDiario.getColumnModel().getColumn(6).setMinWidth(140);
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Diário de Bordo:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel4.setText("*Referência: Valor ajustado/programado para início/stup de produção,podendo ser alterado conforme necessidade do produto/processo.");

        txtDiario.setColumns(20);
        txtDiario.setRows(5);
        txtDiario.setToolTipText("Digite aqui.");
        jScrollPane4.setViewportView(txtDiario);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane4)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        btnDown.setBackground(new java.awt.Color(255, 255, 255));
        btnDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Expand_Arrow_12px.png"))); // NOI18N
        btnDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(btnUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnDown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDown)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu1.setText("Arquivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Salvar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem2.setText("Anexar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem4.setText("Sair");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpMouseClicked
        jPanel6.setVisible(true);
        btnUp.setVisible(false);
        btnDown.setVisible(true);
    }//GEN-LAST:event_btnUpMouseClicked

    private void btnDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownActionPerformed
        jPanel6.setVisible(false);
        btnUp.setVisible(true);
        btnDown.setVisible(false);
    }//GEN-LAST:event_btnDownActionPerformed

    private void tbResultadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbResultadoKeyReleased
        try {
            int coluna = tbResultado.getSelectedColumn();
            
            if (evt.getKeyCode() == KeyEvent.VK_TAB) {
                int linha = tbResultado.getSelectedRow();
                Object obj = tbResultado.getValueAt(linha, 13);
                Object obj2 = tbResultado.getValueAt(linha, 14);
                Object obj3 = tbResultado.getValueAt(linha, 15);
                
                if ((obj == null || obj.toString().equals("")) && (obj2 == null || obj2.toString().equals(""))) {
                    TabPreenchimento();
                } else {
                    VerificarResultdo();
                    if (tbResultado.getValueAt(linha, 16).equals("Reprovado")) {
                        if (obj3 == null || tbResultado.getValueAt(linha, 15).equals("")) {
                            tbResultado.changeSelection(linha, 15, false, false);
                        } else {
                            TabPreenchimento();
                        }
                    } else {
                        TabPreenchimento();
                    }
                }
            } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                int linha = tbResultado.getSelectedRow() - 1;
                
                Object obj = tbResultado.getValueAt(linha, 13);
                Object obj2 = tbResultado.getValueAt(linha, 14);
                Object obj3 = tbResultado.getValueAt(linha, 15);
                
                if ((obj == null || obj.toString().equals("")) && (obj2 == null || obj2.toString().equals(""))) {
                    //VERIFICA SE A SELECAO ESTA NA ULTIMA LINHA
                    if (tbResultado.getSelectedRow() != tbResultado.getRowCount()) {
                        EnterPreenchimento();
                    } else {
                        TabPreenchimento();
                    }
                } else {
                    //VERIFICA SE A SELECAO ESTA NA ULTIMA LINHA
                    if (tbResultado.getSelectedRow() != tbResultado.getRowCount()) {
                        VerificarResultdoEnter();
                    } else {
                        VerificarResultdo();
                    }
                    if (tbResultado.getValueAt(linha, 16).equals("Reprovado")) {
                        if (obj3 == null || tbResultado.getValueAt(linha, 15).equals("")) {
                            tbResultado.changeSelection(linha, 15, false, false);
                        } else {
                            //VERIFICA SE A SELECAO ESTA NA ULTIMA LINHA
                            if (tbResultado.getSelectedRow() != tbResultado.getRowCount()) {
                                EnterPreenchimento();
                            } else {
                                TabPreenchimento();
                            }
                        }
                    } else {
                        //VERIFICA SE A SELECAO ESTA NA ULTIMA LINHA
                        if (tbResultado.getSelectedRow() != tbResultado.getRowCount()) {
                            EnterPreenchimento();
                        } else {
                            TabPreenchimento();
                        }
                    }
                }
            }
        } catch (Exception ex) {
            VerificarResultdoUltimaLinha();
        }
        

    }//GEN-LAST:event_tbResultadoKeyReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        tbResultado.editCellAt(0, 12);
        isTableEmpty();
        if (isTableEmpty() == true) {
            JOptionPane.showMessageDialog(this, "Há campo reprovado sem observação.");
        } else {
            salva();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            
            
            Connection con = new ConexaoSql().getCon();
            String query1 = "Select * from Qry_Result where ESP_MATERIAL=? ";
            PreparedStatement st = con.prepareStatement(query1);
            st.setString(1, txtMaterial.getText());
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                //
                txtCliente.setText(rs.getString("PRO_OEM"));
                txtDescMaterial.setText(rs.getString("DESC_MATERIAL"));
                txtDesenho.setText(rs.getString("N_DESENHO"));
                txtPlano.setText(rs.getString("N_PLANO"));
            }
            
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_formWindowOpened

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       dispose();
       new ViewEntradaDados().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

    }//GEN-LAST:event_jMenuItem2ActionPerformed
    
    private void carregaFicha() {
        listaModelProducao = controllerProducao.getListaPreecheTabaleController(txtMaterial.getText());
        DefaultTableModel modelo = (DefaultTableModel) tbResultado.getModel();
        modelo.setNumRows(0);
        int cont = listaModelProducao.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelProducao.get(i).getId(),
                listaModelProducao.get(i).getOperacao(),
                listaModelProducao.get(i).getEsp_equipamento(),
                listaModelProducao.get(i).getDesc_teste(),
                listaModelProducao.get(i).getComplemento(),
                listaModelProducao.get(i).getMinimo(),
                listaModelProducao.get(i).getMaximo(),
                listaModelProducao.get(i).getTexto(),
                listaModelProducao.get(i).getReferencia(),
                listaModelProducao.get(i).getTipo_espec(),
                listaModelProducao.get(i).getEspec_completo(),
                listaModelProducao.get(i).getProduto(),
                listaModelProducao.get(i).getFreq_completo(),
                listaModelProducao.get(i).getResultado()
            });
        }
    }
    
    private void carregarodape() {
        listaModelRodape = controllerRodape.getListaRodapeController("31078414");
        DefaultTableModel modelo = (DefaultTableModel) tbDiario.getModel();
        modelo.setNumRows(0);
        int cont = listaModelRodape.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelRodape.get(i).getId(),
                listaModelRodape.get(i).getRod_data(),
                listaModelRodape.get(i).getRod_rev(),
                listaModelRodape.get(i).getRod_descricao(),
                listaModelRodape.get(i).getRod_emitente(),
                listaModelRodape.get(i).getRod_setor(),
                listaModelRodape.get(i).getRod_responsavel()
            });
        }
    }
    
    private ModelResultado getModelResultado(int row) {
        String operacao = tbResultado.getValueAt(row, 1).toString();
        String descteste = tbResultado.getValueAt(row, 3).toString();
        String equipamento = tbResultado.getValueAt(row, 2).toString();
        String min = tbResultado.getValueAt(row, 5).toString();
        String max = tbResultado.getValueAt(row, 6).toString();
        String texto = tbResultado.getValueAt(row, 7).toString();
        String espec_completo = tbResultado.getValueAt(row, 10).toString();
        String referencia = tbResultado.getValueAt(row, 8).toString();
        String freq_completo = tbResultado.getValueAt(row, 12).toString();
        Object enct_numero = (Object) tbResultado.getValueAt(row, 13);
        String enct_obs = (String) tbResultado.getValueAt(row, 15);
        String encont_status = (String) tbResultado.getValueAt(row, 16);
        String encont_texto = (String) tbResultado.getValueAt(row, 14);
        modelResultado.setOrdem(listaModelProducao.get(row).getOrdem());
        modelResultado.setData(this.txtData.getText());
        modelResultado.setHora(this.txtHora.getText());
        modelResultado.setRegistro(Integer.parseInt(this.txtRegistro.getText()));
        modelResultado.setMaterial(Integer.parseInt(this.txtMaterial.getText()));
        modelResultado.setDesc_material(txtDescMaterial.getText());
        modelResultado.setCod_teste(listaModelProducao.get(row).getEsp_teste());
        modelResultado.setDesc_teste(descteste);
        modelResultado.setOperacao(operacao);
        modelResultado.setEquipamento(equipamento);
        modelResultado.setMinimo(Float.parseFloat(min));
        modelResultado.setMaximo(Float.parseFloat(max));
        modelResultado.setUnid_medida(listaModelProducao.get(row).getUnid_med());
        modelResultado.setTexto(texto);
        modelResultado.setEspec_completo(espec_completo);
        modelResultado.setReferencia(referencia);
        modelResultado.setLinha(listaModelProducao.get(row).getEsp_linha());
        modelResultado.setFrequencia(listaModelProducao.get(row).getFrequencia());
        modelResultado.setFreq_completo(freq_completo);
        modelResultado.setUnid_frequencia(listaModelProducao.get(row).getUnid_freq());
        modelResultado.setProduto(listaModelProducao.get(row).getProduto());
        modelResultado.setProjeto(listaModelProducao.get(row).getProjeto());
        modelResultado.setOem(txtCliente.getText());
        modelResultado.setN_desenho(txtDesenho.getText());
        modelResultado.setN_plano(txtPlano.getText());
        modelResultado.setTipo_linha(listaModelProducao.get(row).getTipo_linha());
        modelResultado.setLinha_setor(listaModelProducao.get(row).getLinha_setor());
        if (enct_numero == null) {
            modelResultado.setEncontrado_numerico(Float.parseFloat("0.0"));
        } else {
            modelResultado.setEncontrado_numerico((float) enct_numero);
        }
        if (enct_obs == null) {
            modelResultado.setEncontrado_obs("");
        } else {
            modelResultado.setEncontrado_obs(enct_obs);
        }
        if (encont_status == null) {
            modelResultado.setStatus("");
        } else {
            modelResultado.setStatus(encont_status);
        }
        if (encont_texto == null) {
            modelResultado.setEncontrado_texto("");
        } else {
            modelResultado.setEncontrado_texto(encont_texto);
        }
        try {
            Datas data = new Datas();
            modelResultado.setDatam(data.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
        } catch (Exception ex) {
            Logger.getLogger(ViewFichaControle.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        modelResultado.setUsuario(String.valueOf(pNomeUsuario));
        modelResultado.setOrigem(listaModelProducao.get(row).getOrigem());
        modelResultado.setTipo_espec(listaModelProducao.get(row).getTipo_espec());
        modelResultado.setLab(listaModelProducao.get(row).getLab());
        modelResultado.setBpcs(listaModelProducao.get(row).getBpcs());
        modelResultado.setComplemento(listaModelProducao.get(row).getComplemento());
        modelResultado.setDiariobordo(txtDiario.getText());
        if (listaModelProducao.get(row).getComposto() == null) {
        } else {
            modelResultado.setComposto(Integer.parseInt(listaModelProducao.get(row).getComposto()));
        }
        if (controllerResultado.salvarResultadoController(modelResultado) > 0) {
            return null;
        } else {
            return null;
        }
    }
    
    public List<Object> getValoresTabela() {
        List<Object> lista = new ArrayList();
        for (int i = 0; i < tbResultado.getRowCount(); i++) {
            Object ob = getModelResultado(i);
            if (ob != null) {
                lista.add(ob);
            }
        }
        return lista;
    }
    
    public void verifica() {
        for (int i = 0; i < tbResultado.getRowCount(); i++) {
            Object obj = tbResultado.getValueAt(i, 13);
            Object obj2 = tbResultado.getValueAt(i, 14);
            String tipo = tbResultado.getValueAt(i, 9).toString();
            String snreferencia = tbResultado.getValueAt(i, 8).toString();
            if (obj != null) {
                if (tipo.contains("Min e Max") && !snreferencia.contains("Sim")) {
                    Float valornumerico = Float.parseFloat(tbResultado.getValueAt(i, 13).toString());
                    if (valornumerico >= Float.parseFloat(tbResultado.getValueAt(i, 5).toString()) && valornumerico <= Float.parseFloat(tbResultado.getValueAt(i, 6).toString())) {
                        tbResultado.setValueAt("Aprovado", i, 16);
                    } else {
                        tbResultado.setValueAt("Reprovado", i, 16);
                    }
                } else if (snreferencia.contains("Sim")) {
                    
                    if ((obj == null || obj.toString().equals("")) && (obj2 == null || obj2.toString().equals(""))) {
                        tbResultado.setValueAt("", i, 16);
                    } else {
                        tbResultado.setValueAt("Referência", i, 16);
                    }
                } else if (tipo.contains("No Min") && !snreferencia.contains("Sim")) {
                    Float valornumerico = Float.parseFloat(tbResultado.getValueAt(i, 13).toString()); //Valor digitado pelo usuario   
                    if (valornumerico >= Float.parseFloat(tbResultado.getValueAt(i, 5).toString())) {
                        tbResultado.setValueAt("Aprovado", i, 16);
                    } else {
                        tbResultado.setValueAt("Reprovado", i, 16);
                    }
                } else if (tipo.contains("No Max") && !snreferencia.contains("Sim")) {
                    if (obj == null || obj.toString().trim().isEmpty()) {
                        tbResultado.setValueAt("", i, 16);
                    }
                    Float valornumerico = Float.parseFloat(tbResultado.getValueAt(i, 13).toString()); //Valor digitado pelo usuario   
                    if (valornumerico <= Float.parseFloat(tbResultado.getValueAt(i, 6).toString())) {
                        tbResultado.setValueAt("Aprovado", i, 16);
                    } else {
                        tbResultado.setValueAt("Reprovado", i, 16);
                    }
                } else if (tipo.contains("ValorUnico") && !snreferencia.contains("Sim")) {
                    
                    if (obj == null || obj.toString().trim().isEmpty()) {
                        tbResultado.setValueAt("", i, 16);
                    }
                    Float valornumerico = Float.parseFloat(tbResultado.getValueAt(i, 13).toString()); //Valor digitado pelo usuario 
                    if (valornumerico == Float.parseFloat(tbResultado.getValueAt(i, 5).toString())) {
                        tbResultado.setValueAt("Aprovado", i, 16);
                    } else {
                        tbResultado.setValueAt("Reprovado", i, 16);
                    }
                }
            }
        }
    }
    
    public void getvalor() {
        try {
            
            Connection con = new ConexaoSql().getCon();
            CallableStatement cs = con.prepareCall("Exec RetornaParametros  @FiltroData= '" + datahora + "'");
            cs.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public int retornarUsuarioLogado() {
        return new ModelSessaoUsuario().codigo;
    }
    
    private void configurar() {
        pNomeUsuario = retornarUsuarioLogado();
    }
    
    public boolean isTableEmpty() {
        DefaultTableModel m = (DefaultTableModel) getTbResultado().getModel();
        boolean vazia = false;
        for (int r = 0; r < m.getRowCount(); r++) {
            if ("Reprovado".equals(m.getValueAt(r, 16))) {
                if (m.getValueAt(r, 15) == null) {
                    vazia = true;
                    break;
                }
            }
        }
        return vazia;
    }
    
    public void salva() {
        getValoresTabela().stream().forEach(mr -> controllerResultado.salvarResultadoController((ModelResultado) mr));
        JOptionPane.showMessageDialog(this, "Registros gravados com sucesso!");
        dispose();
        new ViewEntradaDados().setVisible(true);
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
            java.util.logging.Logger.getLogger(ViewResultado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewResultado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewResultado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewResultado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewResultado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnUp;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbDescMaterial;
    private javax.swing.JLabel lbDesenho;
    private javax.swing.JLabel lbHora;
    private javax.swing.JLabel lbMaterial;
    private javax.swing.JLabel lbPlano;
    private javax.swing.JLabel lbProcesso;
    private javax.swing.JLabel lbProduto;
    private javax.swing.JLabel lbRegistro;
    private javax.swing.JLabel lbl_envialinha;
    private javax.swing.JTable tbDiario;
    private javax.swing.JTable tbResultado;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtDescMaterial;
    private javax.swing.JTextField txtDesenho;
    private javax.swing.JTextArea txtDiario;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtMaterial;
    private javax.swing.JTextField txtPlano;
    private javax.swing.JTextField txtProcesso;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JTextField txtRegistro;
    // End of variables declaration//GEN-END:variables
}

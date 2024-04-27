package com.cooperstandard.views.pontoinsp;

import com.cooperstandard.controller.pontoinsp.ControllerEspecLab;
import com.cooperstandard.controller.pontoinsp.ControllerResultInsp;
import com.cooperstandard.model.ModelEspecLab;
import com.cooperstandard.model.ModelResultInsp;
import com.cooperstandard.model.ModelSessaoUsuario;
import static com.cooperstandard.model.ModelSessaoUsuario.codigo;
import com.cooperstandard.util.CustomTableCellRenderer;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewLancamentoReteste extends javax.swing.JFrame {
    
    ModelEspecLab modelEspecLab = new ModelEspecLab();
    ControllerEspecLab controllerEspecLab = new ControllerEspecLab();
    ArrayList<ModelEspecLab> listaModelEspecLab = new ArrayList<>();
    ModelResultInsp modelResultInsp = new ModelResultInsp();
    ControllerResultInsp controllerResultInsp = new ControllerResultInsp();
    ArrayList<ModelResultInsp> listaModelResultInsp = new ArrayList<>();
    
    int perfil = 0;
    String solicitante = "";
    String data = "";
    String hora = "";
    String status = "";
    int pCodigoUsuario = 0;
    String pNomeUsuario = "";
    String pSobreNomeUsuario = "";
    int id_controle_reteste = 0;
    
    public ViewLancamentoReteste() {
        initComponents();
    }
    
    public ViewLancamentoReteste(int _perfil, String _solicitante, String _data, String _hora, String _status, int _id_controle_reteste) {
        initComponents();
        perfil = _perfil;
        id_controle_reteste = _id_controle_reteste;
        jLabel2.setText(String.valueOf(perfil));
        carregaEspecLab();
        solicitante = _solicitante;
        jLabel8.setText(solicitante);
        data = _data;
        jLabel4.setText(data);
        hora = _hora;
        jLabel6.setText(hora);
        status = _status;
        jLabel10.setText(status);
        tbResultado.setDefaultRenderer(String.class, new CustomTableCellRenderer());
        tbResultado.setDefaultRenderer(Integer.class, new CustomTableCellRenderer());
        tbResultado.setCellSelectionEnabled(true);
        configurar();
    }
    
    public JTable getTbResultado() {
        return tbResultado;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbResultado = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(2, 83, 161));

        tbResultado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "COD", "Teste", "Tipo", "Complemento", "min", "max", "texto", "referencia", "Especificação", "Resultado", "Resultado Texto", "Observação", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbResultado.setRowHeight(25);
        tbResultado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbResultadoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbResultado);
        if (tbResultado.getColumnModel().getColumnCount() > 0) {
            tbResultado.getColumnModel().getColumn(0).setMinWidth(0);
            tbResultado.getColumnModel().getColumn(0).setMaxWidth(0);
            tbResultado.getColumnModel().getColumn(1).setMinWidth(50);
            tbResultado.getColumnModel().getColumn(1).setMaxWidth(50);
            tbResultado.getColumnModel().getColumn(3).setMinWidth(90);
            tbResultado.getColumnModel().getColumn(3).setMaxWidth(90);
            tbResultado.getColumnModel().getColumn(5).setMinWidth(0);
            tbResultado.getColumnModel().getColumn(5).setMaxWidth(0);
            tbResultado.getColumnModel().getColumn(6).setMinWidth(0);
            tbResultado.getColumnModel().getColumn(6).setMaxWidth(0);
            tbResultado.getColumnModel().getColumn(7).setMinWidth(0);
            tbResultado.getColumnModel().getColumn(7).setMaxWidth(0);
            tbResultado.getColumnModel().getColumn(8).setMinWidth(0);
            tbResultado.getColumnModel().getColumn(8).setMaxWidth(0);
            tbResultado.getColumnModel().getColumn(10).setMinWidth(80);
            tbResultado.getColumnModel().getColumn(10).setMaxWidth(80);
            tbResultado.getColumnModel().getColumn(11).setMinWidth(100);
            tbResultado.getColumnModel().getColumn(11).setMaxWidth(100);
            tbResultado.getColumnModel().getColumn(13).setMinWidth(80);
            tbResultado.getColumnModel().getColumn(13).setMaxWidth(80);
        }

        jPanel2.setBackground(new java.awt.Color(241, 176, 19));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Perfil:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("3133");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Data videojet:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("21/07/2021");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Hora videojet:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("15:00");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Solicitante:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Paulo");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Tipo:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("jLabel10");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        btnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-salvar-filled-50.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

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

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        salvarLancamento();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed

    }//GEN-LAST:event_btnLimparActionPerformed

    private void tbResultadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbResultadoKeyReleased
        try {
            if (evt.getKeyCode() == KeyEvent.VK_TAB) {
                int linha = tbResultado.getSelectedRow();
                Object obj = tbResultado.getValueAt(linha, 10);
                Object obj2 = tbResultado.getValueAt(linha, 11);
                Object obj3 = tbResultado.getValueAt(linha, 12);
                if ((obj == null || obj.toString().equals("")) && (obj2 == null || obj2.toString().equals(""))) {
                    TabPreenchimento();
                } else {
                    VerificarResultdo();
                    if (tbResultado.getValueAt(linha, 13).equals("Reprovado")) {
                        if (obj3 == null || tbResultado.getValueAt(linha, 12).equals("")) {
                            tbResultado.changeSelection(linha, 12, false, false);
                        } else {
                            TabPreenchimento();
                        }
                    } else {
                        TabPreenchimento();
                    }
                }
            } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                int linha = tbResultado.getSelectedRow() - 1;
                Object obj = tbResultado.getValueAt(linha, 10);
                Object obj2 = tbResultado.getValueAt(linha, 11);
                Object obj3 = tbResultado.getValueAt(linha, 12);
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
                    if (tbResultado.getValueAt(linha, 13).equals("Reprovado")) {
                        if (obj3 == null || tbResultado.getValueAt(linha, 12).equals("")) {
                            tbResultado.changeSelection(linha, 12, false, false);
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
        } catch (ArrayIndexOutOfBoundsException ex) {
            VerificarResultdoUltimaLinha();
        }
    }//GEN-LAST:event_tbResultadoKeyReleased
    
    private void carregaEspecLab() {
        listaModelEspecLab = controllerEspecLab.getListaEspecLabController(String.valueOf(perfil));
        DefaultTableModel modelo = (DefaultTableModel) tbResultado.getModel();
        modelo.setNumRows(0);
        int cont = listaModelEspecLab.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelEspecLab.get(i).getId(),//0
                listaModelEspecLab.get(i).getOrdem(),//1
                listaModelEspecLab.get(i).getDesc_teste(),//2
                listaModelEspecLab.get(i).getTipo_espec(),//3
                listaModelEspecLab.get(i).getObservacao(),//4
                listaModelEspecLab.get(i).getMinimo(),//5
                listaModelEspecLab.get(i).getMaximo(),//6
                listaModelEspecLab.get(i).getTexto(),//7
                listaModelEspecLab.get(i).getReferencia(),//8
                listaModelEspecLab.get(i).getEspec_completo()//9
            });
        }
    }
    
    private void TabPreenchimento() {
        int linha = tbResultado.getSelectedRow();
        if (tbResultado.getValueAt(linha + 1, 3).toString().contains("Texto")) {
            tbResultado.changeSelection(linha + 1, 11, false, false);
        } else if (tbResultado.getValueAt(linha + 1, 3).toString().contains("Min e Max")) {
            tbResultado.changeSelection(linha + 1, 10, false, false);
        } else if (tbResultado.getValueAt(linha + 1, 3).toString().contains("No Max")) {
            tbResultado.changeSelection(linha + 1, 10, false, false);
        } else if (tbResultado.getValueAt(linha + 1, 3).toString().contains("No Min")) {
            tbResultado.changeSelection(linha + 1, 10, false, false);
        } else if (tbResultado.getValueAt(linha + 1, 3).toString().contains("ValorUnico")) {
            tbResultado.changeSelection(linha + 1, 10, false, false);
        }
    }
    
    private void EnterPreenchimento() {
        int linha = tbResultado.getSelectedRow();
        if (tbResultado.getValueAt(linha, 3).toString().contains("Texto")) {
            tbResultado.changeSelection(linha, 11, false, false);
        } else if (tbResultado.getValueAt(linha, 3).toString().contains("Min e Max")) {
            tbResultado.changeSelection(linha, 10, false, false);
        } else if (tbResultado.getValueAt(linha, 3).toString().contains("No Max")) {
            tbResultado.changeSelection(linha, 10, false, false);
        } else if (tbResultado.getValueAt(linha, 3).toString().contains("No Min")) {
            tbResultado.changeSelection(linha, 10, false, false);
        } else if (tbResultado.getValueAt(linha, 3).toString().contains("ValorUnico")) {
            tbResultado.changeSelection(linha, 10, false, false);
        }
    }
    
    public void VerificarResultdoUltimaLinha() {
        int linha = tbResultado.getRowCount() - 1;
        String tipo = tbResultado.getValueAt(linha, 3).toString();
        String snreferencia = tbResultado.getValueAt(linha, 8).toString();
        if (tipo.contains("Texto") && !snreferencia.contains("Sim")) {
            String valor1 = tbResultado.getValueAt(linha, 7).toString(); //Especificacao
            String valor2 = tbResultado.getValueAt(linha, 11).toString(); //Valor digitado pelo usuario  
            if (valor1.equals(valor2)) {
                tbResultado.setValueAt("Aprovado", linha, 13);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 13);
            }
            Object obj = tbResultado.getValueAt(linha, 11);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 13);
            }
        } else if (tipo.contains("Min e Max") && !snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 10);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 13);
            }
            Float valornumerico = Float.parseFloat(tbResultado.getValueAt(linha, 10).toString()); //Valor digitado pelo usuario   
            if (valornumerico >= Float.parseFloat(tbResultado.getValueAt(linha, 5).toString()) && valornumerico <= Float.parseFloat(tbResultado.getValueAt(linha, 6).toString())) {
                tbResultado.setValueAt("Aprovado", linha, 13);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 13);
            }
        } else if (tipo.contains("No Min") && !snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 10);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 13);
            }
            Float valornumerico = Float.parseFloat(tbResultado.getValueAt(linha, 10).toString()); //Valor digitado pelo usuario   
            if (valornumerico >= Float.parseFloat(tbResultado.getValueAt(linha, 5).toString())) {
                tbResultado.setValueAt("Aprovado", linha, 13);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 13);
            }
        } else if (tipo.contains("No Max") && !snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 10);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 13);
            }
            Float valornumerico = Float.parseFloat(tbResultado.getValueAt(linha, 10).toString()); //Valor digitado pelo usuario   
            if (valornumerico <= Float.parseFloat(tbResultado.getValueAt(linha, 6).toString())) {
                tbResultado.setValueAt("Aprovado", linha, 13);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 13);
            }
        } else if (tipo.contains("ValorUnico") && !snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 10);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 13);
            }
            Float valornumerico = Float.parseFloat(tbResultado.getValueAt(linha, 10).toString()); //Valor digitado pelo usuario 
            if (valornumerico == Float.parseFloat(tbResultado.getValueAt(linha, 5).toString())) {
                tbResultado.setValueAt("Aprovado", linha, 13);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 13);
            }
        } else if (snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 10);
            Object obj2 = tbResultado.getValueAt(linha, 11);
            if ((obj == null || obj.toString().equals("")) && (obj2 == null || obj2.toString().equals(""))) {
                tbResultado.setValueAt("", linha, 13);
            } else {
                tbResultado.setValueAt("Referência", linha, 13);
            }
            
        }
    }
    
    public void VerificarResultdoEnter() {
        int linha = tbResultado.getSelectedRow() - 1;
        String tipo = tbResultado.getValueAt(linha, 3).toString();
        String snreferencia = tbResultado.getValueAt(linha, 8).toString();
        if (tipo.contains("Texto") && !snreferencia.contains("Sim")) {
            String valor1 = tbResultado.getValueAt(linha, 7).toString(); //Especificacao
            String valor2 = tbResultado.getValueAt(linha, 11).toString(); //Valor digitado pelo usuario
            if (valor1.equals(valor2)) {
                tbResultado.setValueAt("Aprovado", linha, 13);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 13);
            }
            Object obj = tbResultado.getValueAt(linha, 11);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 13);
            }
        } else if (tipo.contains("Min e Max") && !snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 10);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 13);
            }
            Float valornumerico = Float.parseFloat(tbResultado.getValueAt(linha, 10).toString()); //Valor digitado pelo usuario   
            if (valornumerico >= Float.parseFloat(tbResultado.getValueAt(linha, 5).toString()) && valornumerico <= Float.parseFloat(tbResultado.getValueAt(linha, 6).toString())) {
                tbResultado.setValueAt("Aprovado", linha, 13);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 13);
            }
        } else if (tipo.contains("No Min") && !snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 10);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 13);
            }
            Float valornumerico = Float.parseFloat(tbResultado.getValueAt(linha, 10).toString()); //Valor digitado pelo usuario   
            if (valornumerico >= Float.parseFloat(tbResultado.getValueAt(linha, 5).toString())) {
                tbResultado.setValueAt("Aprovado", linha, 13);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 13);
            }
        } else if (tipo.contains("No Max") && !snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 10);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 13);
            }
            Float valornumerico = Float.parseFloat(tbResultado.getValueAt(linha, 10).toString()); //Valor digitado pelo usuario   
            if (valornumerico <= Float.parseFloat(tbResultado.getValueAt(linha, 6).toString())) {
                tbResultado.setValueAt("Aprovado", linha, 13);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 13);
            }
        } else if (tipo.contains("ValorUnico") && !snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 10);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 13);
            }
            Float valornumerico = Float.parseFloat(tbResultado.getValueAt(linha, 10).toString()); //Valor digitado pelo usuario 
            if (valornumerico == Float.parseFloat(tbResultado.getValueAt(linha, 5).toString())) {
                tbResultado.setValueAt("Aprovado", linha, 13);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 13);
            }
        } else if (snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 10);
            Object obj2 = tbResultado.getValueAt(linha, 11);
            if ((obj == null || obj.toString().equals("")) && (obj2 == null || obj2.toString().equals(""))) {
                tbResultado.setValueAt("", linha, 13);
            } else {
                tbResultado.setValueAt("Referência", linha, 13);
            }
            
        }
    }
    
    public void VerificarResultdo() {
        int linha = tbResultado.getSelectedRow();
        String tipo = tbResultado.getValueAt(linha, 3).toString();
        String snreferencia = tbResultado.getValueAt(linha, 8).toString();
        if (tipo.contains("Texto") && !snreferencia.contains("Sim")) {
            String valor1 = tbResultado.getValueAt(linha, 7).toString();
            String valor2 = tbResultado.getValueAt(linha, 11).toString();
            if (valor1.equals(valor2)) {
                tbResultado.setValueAt("Aprovado", linha, 13);
                
            } else {
                tbResultado.setValueAt("Reprovado", linha, 13);
            }
            Object obj = tbResultado.getValueAt(linha, 11);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 13);
            }
        } else if (tipo.contains("Min e Max") && !snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 10);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 13);
            }
            Float valornumerico = Float.parseFloat(tbResultado.getValueAt(linha, 10).toString());
            if (valornumerico >= Float.parseFloat(tbResultado.getValueAt(linha, 5).toString()) && valornumerico <= Float.parseFloat(tbResultado.getValueAt(linha, 6).toString())) {
                tbResultado.setValueAt("Aprovado", linha, 13);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 13);
                
            }
        } else if (tipo.contains("No Min") && !snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 10);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 13);
            }
            Float valornumerico = Float.parseFloat(tbResultado.getValueAt(linha, 10).toString()); //Valor digitado pelo usuario   
            if (valornumerico >= Float.parseFloat(tbResultado.getValueAt(linha, 5).toString())) {
                tbResultado.setValueAt("Aprovado", linha, 13);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 13);
                
            }
        } else if (tipo.contains("No Max") && !snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 10);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 13);
            }
            Float valornumerico = Float.parseFloat(tbResultado.getValueAt(linha, 10).toString()); //Valor digitado pelo usuario   
            if (valornumerico <= Float.parseFloat(tbResultado.getValueAt(linha, 6).toString())) {
                tbResultado.setValueAt("Aprovado", linha, 13);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 13);
                
            }
        } else if (tipo.contains("ValorUnico") && !snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 10);
            if (obj == null || obj.toString().trim().isEmpty()) {
                tbResultado.setValueAt("", linha, 13);
            }
            Float valornumerico = Float.parseFloat(tbResultado.getValueAt(linha, 10).toString()); //Valor digitado pelo usuario 
            if (valornumerico == Float.parseFloat(tbResultado.getValueAt(linha, 5).toString())) {
                tbResultado.setValueAt("Aprovado", linha, 13);
            } else {
                tbResultado.setValueAt("Reprovado", linha, 13);
                
            }
        } else if (snreferencia.contains("Sim")) {
            Object obj = tbResultado.getValueAt(linha, 10);
            Object obj2 = tbResultado.getValueAt(linha, 11);
            
            if ((obj == null || obj.toString().equals("")) && (obj2 == null || obj2.toString().equals(""))) {
                tbResultado.setValueAt("", linha, 13);
            } else {
                tbResultado.setValueAt("Referência", linha, 13);
            }
            
        }
    }
    
    private void salvarLancamento() {
        getValoresResult().stream().forEach(mr -> controllerResultInsp.salvarResultInspController((ModelResultInsp) mr));
        JOptionPane.showMessageDialog(this, "Registros gravados com sucesso!");
        dispose();
    }
    
    private ModelResultInsp getModelResultInsp(int row) {
        String reslt_text = (String) tbResultado.getValueAt(row, 11);
        Object result_num = (Object) tbResultado.getValueAt(row, 10);
        String result_obs = (String) tbResultado.getValueAt(row, 12);
        String result_status = (String) tbResultado.getValueAt(row, 13);
        Object id_espec = (Object) tbResultado.getValueAt(row, 0);
        modelResultInsp.setId_espec_id((int) id_espec);
        Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
        modelResultInsp.setData_registro(dataDeHoje);
        modelResultInsp.setTipo(this.jLabel10.getText());
        modelResultInsp.setResultado_texto(reslt_text);
        modelResultInsp.setAnalista(codigo);
        modelResultInsp.setObs(result_obs);
        modelResultInsp.setStatus(result_status);
        modelResultInsp.setReconhecimento("");
        modelResultInsp.setAprovador("");
        modelResultInsp.setId_controle(id_controle_reteste);
        if (result_num == null) {
            modelResultInsp.setResultado_num(Float.parseFloat("0.0"));
        } else {
            modelResultInsp.setResultado_num((float) result_num);
        }
        if (reslt_text == null) {
            modelResultInsp.setResultado_texto("");
        } else {
            modelResultInsp.setResultado_texto(reslt_text);
        }
        if (result_status == null) {
            modelResultInsp.setStatus("");
        } else {
            modelResultInsp.setStatus(result_status);
        }
        if (result_obs == null) {
            modelResultInsp.setObs("");
        } else {
            modelResultInsp.setObs(result_obs);
        }
        if (result_status != null) {
            if (controllerResultInsp.salvarResultInspController(modelResultInsp) > 0) {
                return null;
            } else {
                return null;
            }
        }
        return null;
    }
    
    public int retornarUsuarioLogado() {
        return new ModelSessaoUsuario().codigo;
    }
    
    public String retornarUsuarioLogadoNome() {
        return new ModelSessaoUsuario().nome;
    }
    
    public String retornarUsuarioLogadoSobreNome() {
        return new ModelSessaoUsuario().sobrenome;
    }
    
    private void configurar() {
        pCodigoUsuario = retornarUsuarioLogado();
        pNomeUsuario = retornarUsuarioLogadoNome();
        pSobreNomeUsuario = retornarUsuarioLogadoSobreNome();
    }
    
    public List<Object> getValoresResult() {
        List<Object> lista = new ArrayList();
        for (int i = 0; i < tbResultado.getRowCount(); i++) {
            Object ob = getModelResultInsp(i);
            if (ob != null) {
                lista.add(ob);
            }
        }
        return lista;
    }
    
    public boolean isTableEmpty() {
        DefaultTableModel m = (DefaultTableModel) getTbResultado().getModel();
        for (int r = 0; r < m.getRowCount(); r++) {
            if (m.getValueAt(r, 13) == null || m.getValueAt(r, 13) == "") {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewLancamentoReteste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewLancamentoReteste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewLancamentoReteste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewLancamentoReteste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewLancamentoReteste().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbResultado;
    // End of variables declaration//GEN-END:variables
}

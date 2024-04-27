package com.cooperstandard.views.pontoinsp;

import com.cooperstandard.frames.seletores.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author tiago.teixeira
 */
public final class ViewSeletorTeste extends ManipulaFrames {

    private static final long serialVersionUID = 7733847633007050104L;
    private final Listener_SeletorListaVarios listener;
    private List<?> resultado;

    /**
     * Creates new form SeletorVarios
     *
     */
    public ViewSeletorTeste() {
        setImageIcon();
        initComponents();
        listener = new Listener_SeletorListaVarios(this);
        //teste();
    }

    public ViewSeletorTeste(TableModelDefaultAdapter modelTbDestino_1, List<?> resultado) {
        setImageIcon();
        initComponents();
        listener = new Listener_SeletorListaVarios(this);
        listener.comportamento(modelTbDestino_1, resultado);
    }

    public void setParametrosComportamento(TableModelDefaultAdapter modelTbDestino_1, List<?> resultado) {
        listener.comportamento(modelTbDestino_1, resultado);
    }

    public List<?> getResultado() {
        return listener.getResultado();
    }

    public JButton getBtConfirmar() {
        return btConfirmar;
    }

    public void setValoresIniciais(List<?> valores) {
        listener.setValoresIniciais(valores);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelMain = new javax.swing.JPanel();
        scTabelaDestOpcao = new javax.swing.JScrollPane();
        tbTabelaDestOpcao = new javax.swing.JTable();
        btAdicionar = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        btAddTodas = new javax.swing.JButton();
        btRemoverTodas = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        scTabelaDestSelecionada = new javax.swing.JScrollPane();
        tbTabelaDestSelecionada = new javax.swing.JTable();
        cbPesquisa = new javax.swing.JComboBox<>();
        txtPesquisa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Filtro de Listas");

        painelMain.setBackground(new java.awt.Color(2, 83, 161));

        scTabelaDestOpcao.setPreferredSize(new java.awt.Dimension(195, 313));

        tbTabelaDestOpcao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scTabelaDestOpcao.setViewportView(tbTabelaDestOpcao);

        btAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/setaDireita.gif"))); // NOI18N
        btAdicionar.setActionCommand("adicionar");

        btRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/setaEsquerda.gif"))); // NOI18N
        btRemover.setActionCommand("remover");

        btAddTodas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/setaDireitaFinal.gif"))); // NOI18N
        btAddTodas.setActionCommand("adicionarTodas");

        btRemoverTodas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/setaEsquerdaInicio.gif"))); // NOI18N
        btRemoverTodas.setActionCommand("removerTodas");

        btConfirmar.setText("Confirmar");
        btConfirmar.setActionCommand("confirmar");
        btConfirmar.setPreferredSize(new java.awt.Dimension(85, 23));
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.setActionCommand("cancelar");
        btCancelar.setPreferredSize(new java.awt.Dimension(85, 23));

        scTabelaDestSelecionada.setPreferredSize(new java.awt.Dimension(195, 313));

        tbTabelaDestSelecionada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scTabelaDestSelecionada.setViewportView(tbTabelaDestSelecionada);

        javax.swing.GroupLayout painelMainLayout = new javax.swing.GroupLayout(painelMain);
        painelMain.setLayout(painelMainLayout);
        painelMainLayout.setHorizontalGroup(
            painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelMainLayout.createSequentialGroup()
                        .addComponent(cbPesquisa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisa))
                    .addComponent(scTabelaDestOpcao, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
                .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelMainLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btAddTodas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btRemoverTodas))
                        .addGap(6, 6, 6)
                        .addComponent(scTabelaDestSelecionada, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelMainLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        painelMainLayout.setVerticalGroup(
            painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMainLayout.createSequentialGroup()
                .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelMainLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(btAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAddTodas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRemoverTodas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(painelMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scTabelaDestOpcao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scTabelaDestSelecionada, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(painelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed

    }//GEN-LAST:event_btConfirmarActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewSeletorTeste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewSeletorTeste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewSeletorTeste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewSeletorTeste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewSeletorTeste().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddTodas;
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btRemover;
    private javax.swing.JButton btRemoverTodas;
    private javax.swing.JComboBox<String> cbPesquisa;
    private javax.swing.JPanel painelMain;
    private javax.swing.JScrollPane scTabelaDestOpcao;
    private javax.swing.JScrollPane scTabelaDestSelecionada;
    private javax.swing.JTable tbTabelaDestOpcao;
    private javax.swing.JTable tbTabelaDestSelecionada;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
    private final class Listener_SeletorListaVarios extends ListenerPatternAdapter<ViewSeletorTeste> {

        private TableModelDefaultAdapter modelTbDestino_1;
        private TableModelDefaultAdapter modelTbDestino_2;
        private List<?> resultado;
        private TableRowSorter sorter1;
        private TableRowSorter sorter2;

        public Listener_SeletorListaVarios(ViewSeletorTeste form) {
            super(form);
            initComponents();
        }

        @Override
        protected void attachListener() {
            btAddTodas.addActionListener(this);
            btAdicionar.addActionListener(this);
            btCancelar.addActionListener(this);
            btRemover.addActionListener(this);
            btRemoverTodas.addActionListener(this);
            tbTabelaDestOpcao.addMouseListener(this);
            txtPesquisa.addCaretListener(carEvent -> {
                sorter1.setRowFilter(RowFilter.regexFilter(RegexUtil.getRegex(REGEX.CONTEM, txtPesquisa.getText()), cbPesquisa.getSelectedIndex()));
            });
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "cancelar":
                    dispose();
                    break;
                case "adicionar":
                    adicionarRegistros();
                    break;
                case "adicionarTodas":
                    adicionarTodos();
                    break;
                case "remover":
                    removerRegistros();
                    break;
                case "removerTodas":
                    removerTodos();
                    break;
            }
        }

        private void setValoresIniciais(List<?> valores) {
            modelTbDestino_1.deletarObjects(valores);
            modelTbDestino_2.addLista(valores);
        }

        private void adicionarRegistros() {
            if (tbTabelaDestOpcao.getSelectedRowCount() == 1) {
                Object tabela = modelTbDestino_1.getObject(sorter1.convertRowIndexToModel(tbTabelaDestOpcao.getSelectedRow()));
                modelTbDestino_2.addObject(tabela);
                modelTbDestino_1.removeObject(tabela);
            } else if (tbTabelaDestOpcao.getSelectedRowCount() > 1) {
                List<Integer> rows = new ArrayList();
                for (int r : tbTabelaDestOpcao.getSelectedRows()) {
                    rows.add(sorter1.convertRowIndexToModel(r));
                }
                List<?> tabela = modelTbDestino_1.getObjects(rows);
                modelTbDestino_2.addLista(tabela);
                modelTbDestino_1.deletarObjects(tabela);
            }
        }

        private void adicionarTodos() {
            if (sorter1.getRowFilter() != null) {
                List<Integer> rows = new ArrayList();
                tbTabelaDestOpcao.getSelectionModel().setSelectionInterval(0, tbTabelaDestOpcao.getRowCount() - 1);
                for (int r : tbTabelaDestOpcao.getSelectedRows()) {
                    rows.add(sorter1.convertRowIndexToModel(r));
                }
                List<?> tabela = modelTbDestino_1.getObjects(rows);
                modelTbDestino_2.addLista(tabela);
                modelTbDestino_1.deletarObjects(tabela);
            } else {
                modelTbDestino_2.addLista(modelTbDestino_1.getLista());
                modelTbDestino_1.deletarLista();
            }
        }

        private void removerRegistros() {
            if (tbTabelaDestSelecionada.getSelectedRowCount() == 1) {
                Object tabela = modelTbDestino_2.getObject(tbTabelaDestSelecionada.getSelectedRow());
                modelTbDestino_1.addObject(tabela);
                modelTbDestino_2.removeObject(tabela);
            } else if (tbTabelaDestSelecionada.getSelectedRowCount() > 1) {
                List<Integer> rows = new ArrayList();
                for (int r : tbTabelaDestOpcao.getSelectedRows()) {
                    rows.add(sorter1.convertRowIndexToModel(r));
                }
                List<?> tabela = modelTbDestino_2.getObjects(rows);
                modelTbDestino_1.addLista(tabela);
                modelTbDestino_2.deletarObjects(tabela);
            }
        }

        private void removerTodos() {
            modelTbDestino_1.addLista(modelTbDestino_2.getLista());
            modelTbDestino_2.deletarLista();
        }

        private void comportamento(TableModelDefaultAdapter modelTbDestino_1, List<?> resultado) {
            try {
                this.modelTbDestino_1 = modelTbDestino_1;
                sorter1 = new TableRowSorter(modelTbDestino_1);
                tbTabelaDestOpcao.setModel(modelTbDestino_1);
                tbTabelaDestOpcao.setRowSorter(sorter1);
                //setColumnFilter(tbTabelaDestOpcao, sorter1);

                this.modelTbDestino_2 = modelTbDestino_1.getClass().getConstructor().newInstance();
                sorter2 = new TableRowSorter(modelTbDestino_2);
                tbTabelaDestSelecionada.setModel(modelTbDestino_2);
                tbTabelaDestSelecionada.setRowSorter(sorter2);

                modelTbDestino_1.getColumnsName().forEach(coluna -> cbPesquisa.addItem(coluna.toString()));
                this.resultado = resultado;
            } catch (Exception ex) {
            }
        }

        private List<?> getResultado() {
            resultado.clear();
            resultado.addAll(modelTbDestino_2.getLista());
            return resultado;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                if (e.getClickCount() == 2) {
                    Object tabela = modelTbDestino_1.getObject(sorter1.convertRowIndexToModel(tbTabelaDestOpcao.getSelectedRow()));
                    modelTbDestino_2.addObject(tabela);
                    modelTbDestino_1.removeObject(tabela);
                }
            } catch (Exception ex) {
            }
        }

    }
}

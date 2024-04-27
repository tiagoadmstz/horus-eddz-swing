package com.cooperstandard.views.principal;

import com.cooperstandard.controller.pontoinsp.ControllerInspControle;
import com.cooperstandard.controller.pontoinsp.ControllerResultInsp;
import com.cooperstandard.model.ModelInspControle;
import com.cooperstandard.model.ModelResultInsp;
import com.cooperstandard.model.ModelSessaoUsuario;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author rsouza10
 */
public class ViewResultadoLab extends javax.swing.JFrame {

    ModelResultInsp modelResultInsp = new ModelResultInsp();
    ControllerResultInsp controllerResultInsp = new ControllerResultInsp();
    ArrayList<ModelResultInsp> listaModelResultInsp = new ArrayList<>();
    ModelInspControle modelInspControle = new ModelInspControle();
    ControllerInspControle controllerInspControle = new ControllerInspControle();
    ArrayList<ModelInspControle> listaModelInspControle = new ArrayList<>();
    int pCodigoUsuario = 0;
    String pNomeUsuario = "";
    String pPlantaUsuario = "";
    String linha;
    String aprovador = "";
    String entrada;

    public ViewResultadoLab() {
        initComponents();
        configurar();
        carregaResultadoOpen();
        carregaResultadoClose();
        setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbOpen = new com.cooperstandard.swing.TableStatus();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbClose = new com.cooperstandard.swing.TableStatus();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        tbOpen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Data/Hora JET", "Solicitante", "Entrada", "Perfil", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbOpen.setGridColor(new java.awt.Color(255, 255, 255));
        tbOpen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbOpenMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbOpen);
        if (tbOpen.getColumnModel().getColumnCount() > 0) {
            tbOpen.getColumnModel().getColumn(0).setMinWidth(0);
            tbOpen.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        tbClose.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Data/Hora JET", "Solicitante", "Entrada", "Perfil", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbClose.setGridColor(new java.awt.Color(255, 255, 255));
        tbClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCloseMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbClose);
        if (tbClose.getColumnModel().getColumnCount() > 0) {
            tbClose.getColumnModel().getColumn(0).setMinWidth(0);
            tbClose.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Testes reconhecidos:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Testes aguardando reconhecimento:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
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

    private void tbOpenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbOpenMouseClicked
        if (evt.getClickCount() == 2) {
            int i = tbOpen.getSelectedRow();
            TableModel model = tbOpen.getModel();
            String id_controle = model.getValueAt(i, 0).toString();
            String datahora = model.getValueAt(i, 1).toString();
            String solicitante = model.getValueAt(i, 2).toString();
            String perfil = model.getValueAt(i, 4).toString();
            if (model.getValueAt(i, 3).toString().equals("Re-Teste")) {
                entrada = "re-teste";
            } else {
                entrada = "produção";
            }
            new ViewTesteLab(id_controle, datahora, solicitante, perfil, entrada).setVisible(true);
        }
    }//GEN-LAST:event_tbOpenMouseClicked

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        carregaResultadoOpen();
        carregaResultadoClose();
    }//GEN-LAST:event_formWindowGainedFocus

    private void tbCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCloseMouseClicked
        if (evt.getClickCount() == 2) {
            int i = tbClose.getSelectedRow();
            TableModel model = tbClose.getModel();
            String id_controle = model.getValueAt(i, 0).toString();
            String datahora = model.getValueAt(i, 1).toString();
            String solicitante = model.getValueAt(i, 2).toString();
            String perfil = model.getValueAt(i, 4).toString();
            if (model.getValueAt(i, 3).toString().equals("Re-Teste")) {
                entrada = "re-teste";
            } else {
                entrada = "produção";
            }
            new ViewTesteLabAprovador(id_controle, datahora, solicitante, perfil, entrada).setVisible(true);
        }
    }//GEN-LAST:event_tbCloseMouseClicked

    private void carregaResultadoOpen() {
        listaModelInspControle = controllerInspControle.getListaInspControleController(linha);
        DefaultTableModel modelo = (DefaultTableModel) tbOpen.getModel();
        modelo.setNumRows(0);
        int cont = listaModelInspControle.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelInspControle.get(i).getId(),
                "   " + listaModelInspControle.get(i).getData_jet() + " - " + listaModelInspControle.get(i).getHora_jet(),
                listaModelInspControle.get(i).getSolicitante(),
                listaModelInspControle.get(i).getTipoteste(),
                listaModelInspControle.get(i).getPerfil(),
                listaModelInspControle.get(i).getStatus() == null ? "Aguardando" : listaModelInspControle.get(i).getStatus().equals("Pendente") ? "Em Andamento" : listaModelInspControle.get(i).getStatus().equals("null") ? "Aguardando" : listaModelInspControle.get(i).getStatus()
            });
        }
    }

    private void carregaResultadoClose() {
        listaModelInspControle = controllerInspControle.getListaInspControleCloseController(linha);
        DefaultTableModel modelo = (DefaultTableModel) tbClose.getModel();
        modelo.setNumRows(0);
        int cont = listaModelInspControle.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelInspControle.get(i).getId(),
                "   " + listaModelInspControle.get(i).getData_jet() + " - " + listaModelInspControle.get(i).getHora_jet(),
                listaModelInspControle.get(i).getSolicitante(),
                listaModelInspControle.get(i).getTipoteste(),
                listaModelInspControle.get(i).getPerfil(),
                listaModelInspControle.get(i).getStatus().equals("") ? "Aguardando" : listaModelInspControle.get(i).getStatus().equals("Pendente") ? "Em Andamento" : listaModelInspControle.get(i).getStatus()
            });
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
            java.util.logging.Logger.getLogger(ViewResultadoLab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewResultadoLab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewResultadoLab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewResultadoLab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewResultadoLab().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private com.cooperstandard.swing.TableStatus tbClose;
    private com.cooperstandard.swing.TableStatus tbOpen;
    // End of variables declaration//GEN-END:variables
}

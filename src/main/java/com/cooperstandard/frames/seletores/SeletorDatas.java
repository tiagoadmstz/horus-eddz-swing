package com.cooperstandard.frames.seletores;

import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import javax.swing.JButton;

public final class SeletorDatas extends ManipulaFrames {

    private static final long serialVersionUID = -6473306764459348826L;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final ZoneId zone = ZoneOffset.systemDefault();
    private LocalDateTime dataInicial;
    private LocalDateTime dataFinal;
//    private JDateChooser dateChooserInicial;
//    private JDateChooser dateChooserFinal;

    /**
     * Creates new form SeletorDatas
     */
    public SeletorDatas() {
        setImageIcon();
        initComponents();
        comportamento();

//        // Crie os objetos JDateChooser
//        dateChooserInicial = new JDateChooser();
//        dateChooserFinal = new JDateChooser();

//        // Adicione os objetos JDateChooser ao painel
//        // (substitua os valores de x, y, width e height de acordo com a sua necessidade)
//        dateChooserInicial.setBounds(x, y, width, height);
//        add(dateChooserInicial);
//
//        dateChooserFinal.setBounds(x, y, width, height);
//        add(dateChooserFinal);
    }

    public JButton getBtConfirmar() {
        return btConfirmar;
    }

    public void setBtConfirmar(JButton btConfirmar) {
        this.btConfirmar = btConfirmar;
    }

    private void getDatas() {
        dataInicial = LocalDateTime.ofInstant(dateChooserInicial.getDate().toInstant(), zone);
        dataFinal = LocalDateTime.ofInstant(dateChooserFinal.getDate().toInstant(), zone);
    }

    public LocalDate[] getArrayDatas() {
        LocalDate[] datas = new LocalDate[2];
        datas[0] = dateChooserInicial.getDate().toInstant().atZone(zone).toLocalDate();
        datas[1] = dateChooserFinal.getDate().toInstant().atZone(zone).toLocalDate();
        return datas;
    }

    public boolean validarData() {
        try {
            getDatas();
            return dataInicial.isBefore(dataFinal) || dataInicial.isEqual(dataFinal);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public long[] getDatesTimeMillis() {
        return new long[]{
            dateChooserInicial.getDate().getTime(),
            dateChooserFinal.getDate().getTime()
        };
    }

    public long getInitDateTimeMillis() {
        return dateChooserInicial.getDate().getTime();
    }

    public long getEndDateTimeMillis() {
        return dateChooserFinal.getDate().getTime();
    }

    private void comportamento() {
        ListenerPatternAdapter lca = new ListenerPatternAdapter<SeletorDatas>(this) {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (Objects.equals("di", e.getComponent().getAccessibleContext().getAccessibleName())) {
                        lbDataInicial.requestFocus();
                        dateChooserInicial.requestFocus();
                    } else if (Objects.equals("df", e.getComponent().getAccessibleContext().getAccessibleName())) {
                        lbDataFinal.requestFocus();
                        dateChooserFinal.requestFocus();
                    }
                }
            }
        };
        dateChooserInicial.addFocusListener(lca);
        dateChooserFinal.addFocusListener(lca);
        dateChooserInicial.addKeyListener(lca);
        dateChooserFinal.addKeyListener(lca);
        btConfirmar.addActionListener(lca);
    }

    public JDateChooser getDateChooserInicial() {
        return dateChooserInicial;
    }

    public void setDateChooserInicial(JDateChooser dateChooserInicial) {
        this.dateChooserInicial = dateChooserInicial;
    }

    public JDateChooser getDateChooserFinal() {
        return dateChooserFinal;
    }

    public void setDateChooserFinal(JDateChooser dateChooserFinal) {
        this.dateChooserFinal = dateChooserFinal;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbDataInicial = new javax.swing.JLabel();
        lbDataFinal = new javax.swing.JLabel();
        btConfirmar = new javax.swing.JButton();
        dateChooserInicial = new com.toedter.calendar.JDateChooser();
        dateChooserFinal = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seletor de Datas");

        lbDataInicial.setText("Data Inicial:");

        lbDataFinal.setText("Data Final:");

        btConfirmar.setText("Confirmar");
        btConfirmar.setActionCommand("confirmar");

        dateChooserInicial = new JDateChooser("dd/MM/yyyy", "##/##/#####", '_');
        dateChooserInicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        dateChooserFinal = new JDateChooser("dd/MM/yyyy", "##/##/#####", '_');
        dateChooserFinal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbDataFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbDataInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateChooserInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(dateChooserFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(btConfirmar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btConfirmar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(dateChooserInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(lbDataInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateChooserFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(SeletorDatas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeletorDatas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeletorDatas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeletorDatas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new SeletorDatas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirmar;
    private com.toedter.calendar.JDateChooser dateChooserFinal;
    private com.toedter.calendar.JDateChooser dateChooserInicial;
    private javax.swing.JLabel lbDataFinal;
    private javax.swing.JLabel lbDataInicial;
    // End of variables declaration//GEN-END:variables
}

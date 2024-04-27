/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.util;

/**
 *
 * @author rsouza10
 */
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class EstiloTablaRenderer1 extends DefaultTableCellRenderer {

    private Component componenete;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        componenete = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        this.setHorizontalAlignment(0);
        this.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));

        if (row % 2 == 0) {
            componenete.setForeground(Color.BLACK);
            componenete.setBackground(new Color(232, 232, 232));
        } else {
            componenete.setForeground(Color.BLACK);
            componenete.setBackground(Color.WHITE);
        }
        if (isSelected) {
            componenete.setForeground(Color.WHITE);
            componenete.setBackground(new Color(28, 134, 238));
        }
        if (value instanceof String) {
            String valor = (String) value;
            if (valor.equalsIgnoreCase("Reprovado")) {
//                cell.setBackground(new Color(252, 119, 119));
                componenete.setBackground(Color.red);
                componenete.setForeground(Color.WHITE);
            }
            if (valor.equalsIgnoreCase("Aprovado") || valor.equalsIgnoreCase("Referência")) {
                componenete.setBackground(new Color(58, 197, 105));
//                cell.setBackground(new Color(12,182,69));
                componenete.setForeground(Color.BLACK);
            }
        }

        return componenete;

    }

}

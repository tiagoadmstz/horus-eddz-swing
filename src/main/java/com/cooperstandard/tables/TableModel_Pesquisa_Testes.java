/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.tables;

import com.cooperstandard.entitie.Teste;
import com.cooperstandard.frames.seletores.TableModelDefaultAdapter;
import java.util.List;

/**
 *
 * @author Rafael
 */
public final class TableModel_Pesquisa_Testes extends TableModelDefaultAdapter<Teste> {

    private static final long serialVersionUID = -6638017745789126030L;
    private final String[] columnsNames = new String[]{"Testes"};

    public TableModel_Pesquisa_Testes() {
        setColmunName(columnsNames);
    }

    public TableModel_Pesquisa_Testes(List<Teste> lista) {
        super(lista);
        setColmunName(columnsNames);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Teste teste = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return teste.getDteste();
            default:
                return null;
        }
    }

}

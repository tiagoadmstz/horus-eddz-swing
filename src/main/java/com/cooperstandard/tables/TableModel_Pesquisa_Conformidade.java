///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.cooperstandard.tables;
//
//import br.com.recebimento.entite.Conformidade;
//import br.com.recebimento.frames.seletores.TableModelDefaultAdapter;
//import java.util.List;
//
///**
// *
// * @author Rafael
// */
//public final class TableModel_Pesquisa_Conformidade extends TableModelDefaultAdapter<Conformidade> {
//
//    private static final long serialVersionUID = 7217812546685745417L;
//    private final String[] columnsName = new String[]{"Descrição"};
//
//    public TableModel_Pesquisa_Conformidade() {
//        setColmunName(columnsName);
//    }
//
//    public TableModel_Pesquisa_Conformidade(List<Conformidade> lista) {
//        super(lista);
//        setColmunName(columnsName);
//    }
//
//    @Override
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        Conformidade descricao = lista.get(rowIndex);
//        switch (columnIndex) {
//            case 0:
//                return descricao.getDescricao();
//            default:
//                return null;
//        }
//    }
//
//}

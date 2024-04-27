package com.cooperstandard.tables;


import com.cooperstandard.entitie.Report_Filter;
import com.cooperstandard.frames.seletores.TableModelDefaultAdapter;
import java.util.List;

/**
 *
 * @author tiago.teixeira
 */
public final class TableModel_Filtros extends TableModelDefaultAdapter<Report_Filter> {

    private static final long serialVersionUID = -8104928841906356738L;
    private final String[] columnName = new String[]{"Filtro", "Valor"};

    public TableModel_Filtros() {
        setColmunName(columnName);
    }

    public TableModel_Filtros(List<Report_Filter> lista) {
        super(lista);
        setColmunName(columnName);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Report_Filter filtro = (Report_Filter) lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return filtro.getNome();
            case 1:
                return filtro.getValor();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Report_Filter filtro = (Report_Filter) lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                filtro.setNome(aValue.toString());
                break;
            case 1:
                filtro.setValor(aValue.toString());
                break;
        }
    }

}

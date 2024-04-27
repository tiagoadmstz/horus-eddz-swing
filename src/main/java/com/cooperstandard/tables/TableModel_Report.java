package com.cooperstandard.tables;


import com.cooperstandard.entitie.Report;
import com.cooperstandard.frames.seletores.TableModelDefaultAdapter;
import java.util.List;

/**
 *
 * @author tiago.teixeira
 */
public final class TableModel_Report extends TableModelDefaultAdapter<Report> {

    private static final long serialVersionUID = -2521268252808690658L;
    private final String[] columnsName = new String[]{"Relatórios"};

    public TableModel_Report() {
        setColmunName(columnsName);
    }

    public TableModel_Report(List<Report> lista) {
        super(lista);
        setColmunName(columnsName);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Report report = (Report) lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                return report.getNome();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Report report = (Report) lista.get(rowIndex);
        switch(columnIndex){
            case 0:
                report.setNome(aValue.toString());
                break;
        }
    }
    
}

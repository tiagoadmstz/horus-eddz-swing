package com.cooperstandard.tables;

import com.cooperstandard.entitie.Report_Group;
import com.cooperstandard.frames.seletores.TableModelDefaultAdapter;
import java.util.List;

/**
 *
 * @author rsouza10
 */
public class TableModel_ReportGroup extends TableModelDefaultAdapter<Report_Group> {

    private static final long serialVersionUID = 1333428913836012196L;

    private final String[] columsName = new String[]{"Grupos"};

    public TableModel_ReportGroup() {
        setColmunName(columsName);
    }

    public TableModel_ReportGroup(List lista) {
        super(lista);
        setColmunName(columsName);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Report_Group report = (Report_Group) lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return report.getNome();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Report_Group report = (Report_Group) lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                report.setNome(aValue.toString());
                break;

        }
    }

}

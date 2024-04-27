package com.cooperstandard.reports.factorys;

import com.cooperstandard.dbs.ConexaoSql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Factory_EtiquetaEmergencia implements ReportFactory<EtiquetaEmergenciaBean> {

    private static final long serialVersionUID = -7052238441071935826L;
    private final String sql = "SELECT TCPERFIL, BPCS, DPERFIL, [Blooming(cataplasma)] AS Blooming,"
            + " [C-Chart] AS CChart, [Densidade] AS Densidade,[MH] AS MH, [ML] AS ML, [MV] AS MV, [T5] AS T5,"
            + " [T90] AS T90, [TS2] AS TS2 FROM QRY_ETIQUEMERGENCY PIVOT (MAX(ESPECTEXTO)"
            + " FOR DTESTE IN ([Blooming(cataplasma)],[C-Chart],[Densidade],[MH],[ML],[MV],[T5],[T90],[TS2]))P WHERE TCPERFIL = ?";

    @Override
    public List<EtiquetaEmergenciaBean> generateCollection() {
        return Collections.emptyList();
    }

    @Override
    public List<EtiquetaEmergenciaBean> generateCollection(String perfil, int batch) {
        List<EtiquetaEmergenciaBean> list = new ArrayList();
        EtiquetaEmergenciaBean etiqueta = null;
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setObject(1, perfil);
            ResultSet rst = ps.executeQuery();
            while (rst.next()) {
                etiqueta = new EtiquetaEmergenciaBean(
                        rst.getInt(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getString(5),
                        rst.getString(6),
                        rst.getString(7),
                        rst.getString(8),
                        rst.getString(9),
                        rst.getString(10),
                        rst.getString(11),
                        rst.getString(12)
                );
            }

            for (int count = +1; count <= batch; count++) {
                EtiquetaEmergenciaBean etq = new EtiquetaEmergenciaBean(etiqueta);
                etq.setBatch(count);
                list.add(etq);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    private Connection getConnection() {
        return new ConexaoSql().getCon();
    }
}

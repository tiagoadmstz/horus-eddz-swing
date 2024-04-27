package com.cooperstandard.reports.factorys;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.frames.seletores.Datas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author rsouza10
 */
public class Factory_SelfLife implements ReportFactory<SelfLifeBean> {

    private final String SQL = "SELECT "
            + "DATA, HORA, RCPERFIL, BPCS, N_ETIQUETA, LINHA, TIPOTESTE,"
            + "TMV,EMV_MIN,EMV_MAX,TT5,ET5_MIN,ET5_MAX,TTS2,ETS2_MIN,ETS2_MAX,TT90,ET90_MIN,ET90_MAX,"
            + "TDENS,EDENS_MIN,EDENS_MAX,TML,EML_MIN,EML_MAX,TMH,EMH_MIN,EMH_MAX,[EC-CHART],EBLOOMING,OBS,USUARIO,PLANTA "
            + "FROM "
            + "\"dbo\".\"Cad_Usuario\" Cad_Usuario INNER JOIN \"Tabela_Acompanhamento_02OBS\" ON Cad_Usuario.\"PK_ID\" = \"USUARIO\" "
            + "WHERE "
            + "DATA BETWEEN ? AND ? AND "
            + "N_ETIQUETA = ?";

    @Override
    public List<SelfLifeBean> generateCollection() {
        return null;
    }

    public List<SelfLifeBean> generateCollection(String dataInicial, String dataFinal, String etiqueta, String observacao) {
        final List<SelfLifeBean> list = new ArrayList<>();
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            final PreparedStatement ps = new ConexaoSql().getCon().prepareStatement(SQL);
            ps.setObject(1, new Timestamp(sdf.parse(dataInicial).toInstant().toEpochMilli()));
            ps.setObject(2, new Timestamp(sdf.parse(dataFinal).toInstant().toEpochMilli()));
            ps.setObject(3, etiqueta);
            final ResultSet rst = ps.executeQuery();
            while (rst.next()) {
                final SelfLifeBean selfLifeBean = new SelfLifeBean(
                        Datas.getDateString(LocalDateTime.parse(rst.getString(1), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")).toLocalDate()),
                        Datas.getTimeString(LocalDateTime.parse(rst.getString(2), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")).toLocalTime()),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getString(5),
                        rst.getString(6),
                        rst.getString(7),
                        rst.getString(8),
                        rst.getString(9),
                        rst.getString(10),
                        rst.getString(11),
                        rst.getString(12),
                        rst.getString(13),
                        rst.getString(14),
                        rst.getString(15),
                        rst.getString(16),
                        rst.getString(17),
                        rst.getString(18),
                        rst.getString(19),
                        rst.getString(20),
                        rst.getString(21),
                        rst.getString(22),
                        rst.getString(23),
                        rst.getString(24),
                        rst.getString(25),
                        rst.getString(26),
                        rst.getString(27),
                        rst.getString(28),
                        rst.getString(29),
                        rst.getString(30),
                        rst.getString(31),
                        rst.getString(32),
                        rst.getString(33)
                );
                list.add(selfLifeBean);
            }

            return list.stream().map(sl -> {
                int index = list.indexOf(sl);
                if (index > 0) {
                    Period period = Period.between(Datas.stringToLocalDate(list.get(index - 1).getDATA()), Datas.stringToLocalDate(sl.getDATA()));
                    sl.setDias(period.getDays() + list.get(index - 1).getDias());
                }
                return sl;
            }).collect(Collectors.toList());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public List<SelfLifeBean> generateCollection(String param1, int param2) {
        return null;
    }
}

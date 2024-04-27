package com.cooperstandard.dao.extrusao;

import com.cooperstandard.model.ModelResultado;
import com.cooperstandard.dbs.ConexaoSql;
import java.util.ArrayList;

/**
 *
 * @author rsouza10
 */
public class DAOResultado extends ConexaoSql {

    public int salvarResultadoDAO(ModelResultado pModelResultado) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO Cad_Resultado ("
                    + "ORDEM,"
                    + "RESULT_DATA,"
                    + "RESULT_HORA,"
                    + "RESULT_REGISTRO,"
                    + "RESULT_MATERIAL,"
                    + "RESULT_DESC_MATERIAL,"
                    + "RESULT_COD_TESTE,"
                    + "RESULT_DESC_TESTE,"
                    + "RESULT_OPERACAO,"
                    + "RESULT_EQUIPAMENTO,"
                    + "RESULT_MINIMO,"
                    + "RESULT_MAXIMO,"
                    + "RESULT_UNID_MEDIDA,"
                    + "RESULT_TEXTO,"
                    + "RESULT_ESPEC_COMPLETO,"
                    + "RESULT_REFERENCIA,"
                    + "RESULT_FREQUENCIA,"
                    + "RESULT_FREQ_COMPLETO,"
                    + "RESULT_UNID_FREQUENCIA,"
                    + "RESULT_PRODUTO,"
                    + "RESULT_LINHA,"
                    + "RESULT_PROJETO,"
                    + "RESULT_OEM,"
                    + "RESULT_N_DESENHO,"
                    + "RESULT_N_PLANO,"
                    + "RESULT_TIPO_LINHA,"
                    + "RESULT_LINHA_SETOR,"
                    + "RESULT_ENCONTRADO_NUMERO,"
                    + "RESULT_ENCONTRADO_OBS,"
                    + "RESULT_STATUS,"
                    + "RESULT_ENCONTRADO_TEXTO,"
                    + "RESULT_DATAM,"
                    + "RESULT_USUARIO,"
                    + "RESULT_ORIGEM,"
                    + "RESULT_TIPO_ESPEC,"
                    + "RESULT_LAB,"
                    + "RESULT_BPCS,"
                    + "RESULT_COMPLEMENTO,"
                    + "RESULT_DIARIOBORDO,"
                    + "RESULT_COMPOSTO"
                    + ") VALUES ("
                    + "'" + pModelResultado.getOrdem() + "',"
                    + "'" + pModelResultado.getData() + "',"
                    + "'" + pModelResultado.getHora() + "',"
                    + "'" + pModelResultado.getRegistro() + "',"
                    + "'" + pModelResultado.getMaterial() + "',"
                    + "'" + pModelResultado.getDesc_material() + "',"
                    + "'" + pModelResultado.getCod_teste() + "',"
                    + "'" + pModelResultado.getDesc_teste() + "',"
                    + "'" + pModelResultado.getOperacao() + "',"
                    + "'" + pModelResultado.getEquipamento() + "',"
                    + "'" + pModelResultado.getMinimo() + "',"
                    + "'" + pModelResultado.getMaximo() + "',"
                    + "'" + pModelResultado.getUnid_medida() + "',"
                    + "'" + pModelResultado.getTexto() + "',"
                    + "'" + pModelResultado.getEspec_completo() + "',"
                    + "'" + pModelResultado.getReferencia() + "',"
                    + "'" + pModelResultado.getFrequencia() + "',"
                    + "'" + pModelResultado.getFreq_completo() + "',"
                    + "'" + pModelResultado.getUnid_frequencia() + "',"
                    + "'" + pModelResultado.getProduto() + "',"
                    + "'" + pModelResultado.getLinha() + "',"
                    + "'" + pModelResultado.getProjeto() + "',"
                    + "'" + pModelResultado.getOem() + "',"
                    + "'" + pModelResultado.getN_desenho() + "',"
                    + "'" + pModelResultado.getN_plano() + "',"
                    + "'" + pModelResultado.getTipo_linha() + "',"
                    + "'" + pModelResultado.getLinha_setor() + "',"
                    + "'" + pModelResultado.getEncontrado_numerico() + "',"
                    + "'" + pModelResultado.getEncontrado_obs() + "',"
                    + "'" + pModelResultado.getStatus() + "',"
                    + "'" + pModelResultado.getEncontrado_texto() + "',"
                    + "'" + pModelResultado.getDatam() + "',"
                    + "'" + pModelResultado.getUsuario() + "',"
                    + "'" + pModelResultado.getOrigem() + "',"
                    + "'" + pModelResultado.getTipo_espec() + "',"
                    + "'" + pModelResultado.getLab() + "',"
                    + "'" + pModelResultado.getBpcs() + "',"
                    + "'" + pModelResultado.getComplemento() + "',"
                    + "'" + pModelResultado.getDiariobordo() + "',"
                    + "'" + pModelResultado.getComposto() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    public ModelResultado getResultadoDAO(int pCodigo) {
        ModelResultado modelResultado = new ModelResultado();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_RESULT,"
                    + "ORDEM,"
                    + "RESULT_DATA,"
                    + "RESULT_HORA,"
                    + "RESULT_REGISTRO,"
                    + "RESULT_MATERIAL,"
                    + "RESULT_DESC_MATERIAL,"
                    + "RESULT_COD_TESTE,"
                    + "RESULT_DESC_TESTE,"
                    + "RESULT_OPERACAO,"
                    + "RESULT_EQUIPAMENTO,"
                    + "RESULT_MINIMO,"
                    + "RESULT_MAXIMO,"
                    + "RESULT_UNID_MEDIDA,"
                    + "RESULT_TEXTO,"
                    + "RESULT_ESPEC_COMPLETO,"
                    + "RESULT_REFERENCIA,"
                    + "RESULT_FREQUENCIA,"
                    + "RESULT_FREQ_COMPLETO,"
                    + "RESULT_UNID_FREQUENCIA,"
                    + "RESULT_PRODUTO,"
                    + "RESULT_LINHA,"
                    + "RESULT_PROJETO,"
                    + "RESULT_OEM,"
                    + "RESULT_N_DESENHO,"
                    + "RESULT_N_PLANO,"
                    + "RESULT_TIPO_LINHA,"
                    + "RESULT_LINHA_SETOR,"
                    + "RESULT_ENCONTRADO_NUMERO,"
                    + "RESULT_ENCONTRADO_OBS,"
                    + "RESULT_STATUS,"
                    + "RESULT_ENCONTRADO_TEXTO,"
                    + "RESULT_DATAM,"
                    + "RESULT_USUARIO,"
                    + "RESULT_ORIGEM,"
                    + "RESULT_TIPO_ESPEC,"
                    + "RESULT_LAB,"
                    + "RESULT_BPCS,"
                    + "RESULT_COMPLEMENTO,"
                    + "RESULT_COMPOSTO,"
                    + "RESULT_DIARIOBORDO"
                    + " FROM "
                    + "Cad_Resultado"
                    + " WHERE"
                    + " ID_RESULT= '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelResultado.setId(this.getResultSet().getInt(1));
                modelResultado.setOrdem(this.getResultSet().getInt(2));
                modelResultado.setData(this.getResultSet().getString(3));
                modelResultado.setHora(this.getResultSet().getString(4));
                modelResultado.setRegistro(this.getResultSet().getInt(5));
                modelResultado.setMaterial(this.getResultSet().getInt(6));
                modelResultado.setDesc_material(this.getResultSet().getString(7));
                modelResultado.setCod_teste(this.getResultSet().getString(8));
                modelResultado.setDesc_teste(this.getResultSet().getString(9));
                modelResultado.setOperacao(this.getResultSet().getString(10));
                modelResultado.setEquipamento(this.getResultSet().getString(11));
                modelResultado.setMinimo(this.getResultSet().getFloat(12));
                modelResultado.setMaximo(this.getResultSet().getFloat(13));
                modelResultado.setUnid_medida(this.getResultSet().getString(14));
                modelResultado.setTexto(this.getResultSet().getString(15));
                modelResultado.setEspec_completo(this.getResultSet().getString(16));
                modelResultado.setReferencia(this.getResultSet().getString(17));
                modelResultado.setFrequencia(this.getResultSet().getInt(18));
                modelResultado.setFreq_completo(this.getResultSet().getString(19));
                modelResultado.setUnid_frequencia(this.getResultSet().getString(20));
                modelResultado.setProduto(this.getResultSet().getString(21));
                modelResultado.setLinha(this.getResultSet().getString(22));
                modelResultado.setProjeto(this.getResultSet().getString(23));
                modelResultado.setOem(this.getResultSet().getString(24));
                modelResultado.setN_desenho(this.getResultSet().getString(25));
                modelResultado.setN_plano(this.getResultSet().getString(26));
                modelResultado.setTipo_linha(this.getResultSet().getString(27));
                modelResultado.setLinha_setor(this.getResultSet().getString(28));
                modelResultado.setEncontrado_numerico(this.getResultSet().getFloat(29));
                modelResultado.setEncontrado_obs(this.getResultSet().getString(30));
                modelResultado.setStatus(this.getResultSet().getString(31));
                modelResultado.setEncontrado_texto(this.getResultSet().getString(32));
                modelResultado.setDatam(this.getResultSet().getDate(33));
                modelResultado.setUsuario(this.getResultSet().getString(34));
                modelResultado.setOrigem(this.getResultSet().getString(35));
                modelResultado.setTipo_espec(this.getResultSet().getString(36));
                modelResultado.setLab(this.getResultSet().getString(37));
                modelResultado.setBpcs(this.getResultSet().getString(38));
                modelResultado.setComplemento(this.getResultSet().getString(39));
                modelResultado.setComposto(this.getResultSet().getInt(40));
                modelResultado.setDiariobordo(this.getResultSet().getString(41));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelResultado;
    }

    public ModelResultado getResultadoDAO(Integer pNome) {
        ModelResultado modelResultado = new ModelResultado();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_RESULT,"
                    + "ORDEM,"
                    + "RESULT_DATA,"
                    + "RESULT_HORA,"
                    + "RESULT_REGISTRO,"
                    + "RESULT_MATERIAL,"
                    + "RESULT_DESC_MATERIAL,"
                    + "RESULT_COD_TESTE,"
                    + "RESULT_DESC_TESTE,"
                    + "RESULT_OPERACAO,"
                    + "RESULT_EQUIPAMENTO,"
                    + "RESULT_MINIMO,"
                    + "RESULT_MAXIMO,"
                    + "RESULT_UNID_MEDIDA,"
                    + "RESULT_TEXTO,"
                    + "RESULT_ESPEC_COMPLETO,"
                    + "RESULT_REFERENCIA,"
                    + "RESULT_FREQUENCIA,"
                    + "RESULT_FREQ_COMPLETO,"
                    + "RESULT_UNID_FREQUENCIA,"
                    + "RESULT_PRODUTO,"
                    + "RESULT_LINHA,"
                    + "RESULT_PROJETO,"
                    + "RESULT_OEM,"
                    + "RESULT_N_DESENHO,"
                    + "RESULT_N_PLANO,"
                    + "RESULT_TIPO_LINHA,"
                    + "RESULT_LINHA_SETOR,"
                    + "RESULT_ENCONTRADO_NUMERO,"
                    + "RESULT_ENCONTRADO_OBS,"
                    + "RESULT_STATUS,"
                    + "RESULT_ENCONTRADO_TEXTO,"
                    + "RESULT_DATAM,"
                    + "RESULT_USUARIO,"
                    + "RESULT_ORIGEM,"
                    + "RESULT_TIPO_ESPEC,"
                    + "RESULT_LAB,"
                    + "RESULT_BPCS,"
                    + "RESULT_COMPLEMENTO,"
                    + "RESULT_COMPOSTO,"
                    + "RESULT_DIARIOBORDO"
                    + " FROM "
                    + "Cad_Resultado"
                    + " WHERE"
                    + " MATERIAL= '" + pNome + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelResultado.setId(this.getResultSet().getInt(1));
                modelResultado.setOrdem(this.getResultSet().getInt(2));
                modelResultado.setData(this.getResultSet().getString(3));
                modelResultado.setHora(this.getResultSet().getString(4));
                modelResultado.setRegistro(this.getResultSet().getInt(5));
                modelResultado.setMaterial(this.getResultSet().getInt(6));
                modelResultado.setDesc_material(this.getResultSet().getString(7));
                modelResultado.setCod_teste(this.getResultSet().getString(8));
                modelResultado.setDesc_teste(this.getResultSet().getString(9));
                modelResultado.setOperacao(this.getResultSet().getString(10));
                modelResultado.setEquipamento(this.getResultSet().getString(11));
                modelResultado.setMinimo(this.getResultSet().getFloat(12));
                modelResultado.setMaximo(this.getResultSet().getFloat(13));
                modelResultado.setUnid_medida(this.getResultSet().getString(14));
                modelResultado.setTexto(this.getResultSet().getString(15));
                modelResultado.setEspec_completo(this.getResultSet().getString(16));
                modelResultado.setReferencia(this.getResultSet().getString(17));
                modelResultado.setFrequencia(this.getResultSet().getInt(18));
                modelResultado.setFreq_completo(this.getResultSet().getString(19));
                modelResultado.setUnid_frequencia(this.getResultSet().getString(20));
                modelResultado.setProduto(this.getResultSet().getString(21));
                modelResultado.setLinha(this.getResultSet().getString(22));
                modelResultado.setProjeto(this.getResultSet().getString(23));
                modelResultado.setOem(this.getResultSet().getString(24));
                modelResultado.setN_desenho(this.getResultSet().getString(25));
                modelResultado.setN_plano(this.getResultSet().getString(26));
                modelResultado.setTipo_linha(this.getResultSet().getString(27));
                modelResultado.setLinha_setor(this.getResultSet().getString(28));
                modelResultado.setEncontrado_numerico(this.getResultSet().getFloat(29));
                modelResultado.setEncontrado_obs(this.getResultSet().getString(30));
                modelResultado.setStatus(this.getResultSet().getString(31));
                modelResultado.setEncontrado_texto(this.getResultSet().getString(32));
                modelResultado.setDatam(this.getResultSet().getDate(33));
                modelResultado.setUsuario(this.getResultSet().getString(34));
                modelResultado.setOrigem(this.getResultSet().getString(35));
                modelResultado.setTipo_espec(this.getResultSet().getString(36));
                modelResultado.setLab(this.getResultSet().getString(37));
                modelResultado.setBpcs(this.getResultSet().getString(38));
                modelResultado.setComplemento(this.getResultSet().getString(39));
                modelResultado.setComposto(this.getResultSet().getInt(40));
                modelResultado.setDiariobordo(this.getResultSet().getString(41));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelResultado;
    }

    public ArrayList<ModelResultado> getListaResultadoDAO(String perfil) {
        ArrayList<ModelResultado> listaResultado = new ArrayList();
        ModelResultado modelResultado = new ModelResultado();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID_RESULT,"
                    + "ORDEM,"
                    + "RESULT_DATA,"
                    + "RESULT_HORA,"
                    + "RESULT_REGISTRO,"
                    + "RESULT_MATERIAL,"
                    + "RESULT_DESC_MATERIAL,"
                    + "RESULT_COD_TESTE,"
                    + "RESULT_DESC_TESTE,"
                    + "RESULT_OPERACAO,"
                    + "RESULT_EQUIPAMENTO,"
                    + "RESULT_MINIMO,"
                    + "RESULT_MAXIMO,"
                    + "RESULT_UNID_MEDIDA,"
                    + "RESULT_TEXTO,"
                    + "RESULT_ESPEC_COMPLETO,"
                    + "RESULT_REFERENCIA,"
                    + "RESULT_FREQUENCIA,"
                    + "RESULT_FREQ_COMPLETO,"
                    + "RESULT_UNID_FREQUENCIA,"
                    + "RESULT_PRODUTO,"
                    + "RESULT_LINHA,"
                    + "RESULT_PROJETO,"
                    + "RESULT_OEM,"
                    + "RESULT_N_DESENHO,"
                    + "RESULT_N_PLANO,"
                    + "RESULT_TIPO_LINHA,"
                    + "RESULT_LINHA_SETOR,"
                    + "RESULT_ENCONTRADO_NUMERO,"
                    + "RESULT_ENCONTRADO_OBS,"
                    + "RESULT_STATUS,"
                    + "RESULT_ENCONTRADO_TEXTO,"
                    + "RESULT_DATAM,"
                    + "RESULT_USUARIO,"
                    + "RESULT_ORIGEM,"
                    + "RESULT_TIPO_ESPEC,"
                    + "RESULT_LAB,"
                    + "RESULT_BPCS,"
                    + "RESULT_COMPLEMENTO,"
                    + "RESULT_COMPOSTO,"
                    + "RESULT_DIARIOBORDO"
                    + " FROM"
                    + " Cad_Resultado WHERE RESULT_MATERIAL='" + perfil + "'  ORDER BY ORDEM ASC"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelResultado.setId(this.getResultSet().getInt(1));
                modelResultado.setOrdem(this.getResultSet().getInt(2));
                modelResultado.setData(this.getResultSet().getString(3));
                modelResultado.setHora(this.getResultSet().getString(4));
                modelResultado.setRegistro(this.getResultSet().getInt(5));
                modelResultado.setMaterial(this.getResultSet().getInt(6));
                modelResultado.setDesc_material(this.getResultSet().getString(7));
                modelResultado.setCod_teste(this.getResultSet().getString(8));
                modelResultado.setDesc_teste(this.getResultSet().getString(9));
                modelResultado.setOperacao(this.getResultSet().getString(10));
                modelResultado.setEquipamento(this.getResultSet().getString(11));
                modelResultado.setMinimo(this.getResultSet().getFloat(12));
                modelResultado.setMaximo(this.getResultSet().getFloat(13));
                modelResultado.setUnid_medida(this.getResultSet().getString(14));
                modelResultado.setTexto(this.getResultSet().getString(15));
                modelResultado.setEspec_completo(this.getResultSet().getString(16));
                modelResultado.setReferencia(this.getResultSet().getString(17));
                modelResultado.setFrequencia(this.getResultSet().getInt(18));
                modelResultado.setFreq_completo(this.getResultSet().getString(19));
                modelResultado.setUnid_frequencia(this.getResultSet().getString(20));
                modelResultado.setProduto(this.getResultSet().getString(21));
                modelResultado.setLinha(this.getResultSet().getString(22));
                modelResultado.setProjeto(this.getResultSet().getString(23));
                modelResultado.setOem(this.getResultSet().getString(24));
                modelResultado.setN_desenho(this.getResultSet().getString(25));
                modelResultado.setN_plano(this.getResultSet().getString(26));
                modelResultado.setTipo_linha(this.getResultSet().getString(27));
                modelResultado.setLinha_setor(this.getResultSet().getString(28));
                modelResultado.setEncontrado_numerico(this.getResultSet().getFloat(29));
                modelResultado.setEncontrado_obs(this.getResultSet().getString(30));
                modelResultado.setStatus(this.getResultSet().getString(31));
                modelResultado.setEncontrado_texto(this.getResultSet().getString(32));
                modelResultado.setDatam(this.getResultSet().getDate(33));
                modelResultado.setUsuario(this.getResultSet().getString(34));
                modelResultado.setOrigem(this.getResultSet().getString(35));
                modelResultado.setTipo_espec(this.getResultSet().getString(36));
                modelResultado.setLab(this.getResultSet().getString(37));
                modelResultado.setBpcs(this.getResultSet().getString(38));
                modelResultado.setComplemento(this.getResultSet().getString(39));
                modelResultado.setComposto(this.getResultSet().getInt(40));
                modelResultado.setDiariobordo(this.getResultSet().getString(41));
                listaResultado.add(modelResultado);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaResultado;
    }

    public ArrayList<ModelResultado> getListaDigitadoDAO() {
        ArrayList<ModelResultado> listaResultado = new ArrayList();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT DISTINCT "
                    + "RESULT_DATA,"
                    + "RESULT_HORA,"
                    + "RESULT_MATERIAL,"
                    + "RESULT_LINHA,"
                    + "RESULT_REGISTRO"
                    + " FROM "
                    + " Cad_Resultado ORDER BY RESULT_DATA DESC"
                    + ";"
            );

            while (this.getResultSet().next()) {
                ModelResultado modelResultado = new ModelResultado();
                modelResultado.setData(this.getResultSet().getString(1));
                modelResultado.setHora(this.getResultSet().getString(2));
                modelResultado.setMaterial(this.getResultSet().getInt(3));
                modelResultado.setLinha(this.getResultSet().getString(4));
                modelResultado.setRegistro(this.getResultSet().getInt(5));
                listaResultado.add(modelResultado);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaResultado;
    }

    public boolean atualizarResultadoDAO(ModelResultado pModelResultado) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Cad_Resultado SET "
                    + " ORDEM= '" + pModelResultado.getOrdem() + "',"
                    + " RESULT_DATA= '" + pModelResultado.getData() + "',"
                    + " RESULT_HORA= '" + pModelResultado.getHora() + "',"
                    + " RESULT_REGISTRO= '" + pModelResultado.getRegistro() + "',"
                    + " RESULT_MATERIAL= '" + pModelResultado.getMaterial() + "',"
                    + " RESULT_DESC_MATERIAL= '" + pModelResultado.getDesc_material() + "',"
                    + " RESULT_COD_TESTE= '" + pModelResultado.getCod_teste() + "',"
                    + " RESULT_DESC_TESTE= '" + pModelResultado.getDesc_teste() + "',"
                    + " RESULT_OPERACAO= '" + pModelResultado.getOperacao() + "',"
                    + " RESULT_EQUIPAMENTO= '" + pModelResultado.getEquipamento() + "',"
                    + " RESULT_MINIMO= '" + pModelResultado.getMinimo() + "',"
                    + " RESULT_MAXIMO= '" + pModelResultado.getMaximo() + "',"
                    + " RESULT_UNID_MEDIDA= '" + pModelResultado.getUnid_medida() + "',"
                    + " RESULT_TEXTO= '" + pModelResultado.getTexto() + "',"
                    + " RESULT_ESPEC_COMPLETO= '" + pModelResultado.getEspec_completo() + "',"
                    + " RESULT_REFERENCIA= '" + pModelResultado.getReferencia() + "',"
                    + " RESULT_FREQUENCIA= '" + pModelResultado.getFrequencia() + "',"
                    + " RESULT_FREQ_COMPLETO= '" + pModelResultado.getFreq_completo() + "',"
                    + " RESULT_UNID_FREQUENCIA= '" + pModelResultado.getUnid_frequencia() + "',"
                    + " RESULT_PRODUTO= '" + pModelResultado.getProduto() + "',"
                    + " RESULT_LINHA= '" + pModelResultado.getLinha() + "',"
                    + " RESULT_PROJETO= '" + pModelResultado.getProjeto() + "',"
                    + " RESULT_OEM= '" + pModelResultado.getOem() + "',"
                    + " RESULT_N_DESENHO= '" + pModelResultado.getN_desenho() + "',"
                    + " RESULT_N_PLANO= '" + pModelResultado.getN_plano() + "',"
                    + " RESULT_TIPO_LINHA= '" + pModelResultado.getTipo_linha() + "',"
                    + " RESULT_LINHA_SETOR= '" + pModelResultado.getLinha_setor() + "',"
                    + " RESULT_ENCONTRADO_NUMERO= '" + pModelResultado.getEncontrado_numerico() + "',"
                    + " RESULT_ENCONTRADO_OBS= '" + pModelResultado.getEncontrado_obs() + "',"
                    + " RESULT_STATUS= '" + pModelResultado.getStatus() + "',"
                    + " RESULT_ENCONTRADO_TEXTO= '" + pModelResultado.getEncontrado_texto() + "',"
                    + " RESULT_DATAM= '" + pModelResultado.getDatam() + "',"
                    + " RESULT_USUARIO= '" + pModelResultado.getUsuario() + "',"
                    + " RESULT_ORIGEM= '" + pModelResultado.getOrigem() + "',"
                    + " RESULT_TIPO_ESPEC= '" + pModelResultado.getTipo_espec() + "',"
                    + " RESULT_LAB= '" + pModelResultado.getLab() + "',"
                    + " RESULT_BPCS= '" + pModelResultado.getBpcs() + "',"
                    + " RESULT_COMPLEMENTO= '" + pModelResultado.getComplemento() + "',"
                    + " RESULT_COMPOSTO= '" + pModelResultado.getComposto() + "',"
                    + " RESULT_DIARIOBORDO= '" + pModelResultado.getDiariobordo() + "',"
                    + " WHERE "
                    + " ID_RESULT= '" + pModelResultado.getId() + "'"
                    + ";"
            );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();

        }

    }

    public boolean excluirResultadoDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM Cad_Resultado "
                    + "WHERE "
                    + " ID_RESULT= '" + pCodigo + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}

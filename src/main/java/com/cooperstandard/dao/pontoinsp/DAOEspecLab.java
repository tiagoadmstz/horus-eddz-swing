package com.cooperstandard.dao.pontoinsp;

import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.model.ModelEspecLab;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author rsouza10
 */
public class DAOEspecLab extends ConexaoSql {

    public int salvarEspecLabDAO(ModelEspecLab pModelEspecLab) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO Cad_EspecLab ("
                    + "ORDEM,"
                    + "MINIMO,"
                    + "MAXIMO,"
                    + "UNID_MEDIDA,"
                    + "TEXTO,"
                    + "REFERENCIA,"
                    + "TIPO_ESPEC,"
                    + "OBSERVACAO,"
                    + "HISTORICO,"
                    + "ATRIBUTO,"
                    + "INF,"
                    + "SUP,"
                    + "BILATERAL,"
                    + "INFORMATIVO,"
                    + "ID_MATERIAL_ID,"
                    + "ID_TESTE_ID,"
                    + "ESPEC_COMPLETO"
                    + ") VALUES ("
                    + "'" + pModelEspecLab.getOrdem() + "',"
                    + "'" + pModelEspecLab.getMinimo() + "',"
                    + "'" + pModelEspecLab.getMaximo() + "',"
                    + "'" + pModelEspecLab.getUnid_medida() + "',"
                    + "'" + pModelEspecLab.getTexto() + "',"
                    + "'" + pModelEspecLab.getReferencia() + "',"
                    + "'" + pModelEspecLab.getTipo_espec() + "',"
                    + "'" + pModelEspecLab.getObservacao() + "',"
                    + "'" + pModelEspecLab.getHistorico() + "',"
                    + "'" + pModelEspecLab.getAtributo() + "',"
                    + "'" + pModelEspecLab.getInf() + "',"
                    + "'" + pModelEspecLab.getSup() + "',"
                    + "'" + pModelEspecLab.getBilateral() + "',"
                    + "'" + pModelEspecLab.getInformativo() + "',"
                    + "'" + pModelEspecLab.getId_material_id() + "',"
                    + "'" + pModelEspecLab.getId_teste_id() + "',"
                    + "'" + pModelEspecLab.getEspec_completo() + "'"
                    + ");"
            );

        } catch (Exception e) {
            if (e.getMessage().contains("Violation of PRIMARY KEY constraint")) {
                JOptionPane.showMessageDialog(null, "Código do teste duplicado!", "ERRO", JOptionPane.ERROR_MESSAGE);
            } else {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "ok");
            }

            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    public ModelEspecLab getEspecLabDAO(int pCodigo) {
        ModelEspecLab modelEspecLab = new ModelEspecLab();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "Cad_EspecLab.ORDEM as ORDEM,"
                    + "MINIMO,"
                    + "MAXIMO,"
                    + "UNID_MEDIDA,"
                    + "TEXTO,"
                    + "REFERENCIA,"
                    + "TIPO_ESPEC,"
                    + "OBSERVACAO,"
                    + "HISTORICO,"
                    + "ATRIBUTO,"
                    + "INF,"
                    + "SUP,"
                    + "BILATERAL,"
                    + "INFORMATIVO,"
                    + "ID_MATERIAL_ID,"
                    + "ID_TESTE_ID,"
                    + "Cad_Teste.ORDEM as ORDEMTeste,"
                    + "DESC_TESTE,"
                    + "ESPEC_COMPLETO"
                    + " FROM "
                    + "Cad_Teste INNER JOIN Cad_EspecLab ON COD_TESTE = ID_TESTE_ID "
                    + " WHERE"
                    + " ID = '" + pCodigo + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelEspecLab.setId(this.getResultSet().getInt(1));
                modelEspecLab.setOrdem(this.getResultSet().getInt(2));
                modelEspecLab.setMinimo(this.getResultSet().getFloat(3));
                modelEspecLab.setMaximo(this.getResultSet().getFloat(4));
                modelEspecLab.setUnid_medida(this.getResultSet().getString(5));
                modelEspecLab.setTexto(this.getResultSet().getString(6));
                modelEspecLab.setReferencia(this.getResultSet().getString(7));
                modelEspecLab.setTipo_espec(this.getResultSet().getString(8));
                modelEspecLab.setObservacao(this.getResultSet().getString(9));
                modelEspecLab.setHistorico(this.getResultSet().getString(10));
                modelEspecLab.setAtributo(this.getResultSet().getString(11));
                modelEspecLab.setInf(this.getResultSet().getString(12));
                modelEspecLab.setSup(this.getResultSet().getString(13));
                modelEspecLab.setBilateral(this.getResultSet().getString(14));
                modelEspecLab.setInformativo(this.getResultSet().getString(15));
                modelEspecLab.setId_material_id(this.getResultSet().getString(16));
                modelEspecLab.setId_teste_id(this.getResultSet().getString(17));
                modelEspecLab.setCod_teste(this.getResultSet().getString(18));
                modelEspecLab.setDesc_teste(this.getResultSet().getString(19));
                modelEspecLab.setEspec_completo(this.getResultSet().getString(20));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelEspecLab;
    }

    public ModelEspecLab getEspecLabDAO(String pNome) {
        ModelEspecLab modelEspecLab = new ModelEspecLab();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "ID,"
                    + "ORDEM,"
                    + "MINIMO,"
                    + "MAXIMO,"
                    + "UNID_MEDIDA,"
                    + "TEXTO,"
                    + "REFERENCIA,"
                    + "TIPO_ESPEC,"
                    + "OBSERVACAO,"
                    + "HISTORICO,"
                    + "ATRIBUTO,"
                    + "INF,"
                    + "SUP,"
                    + "BILATERAL,"
                    + "INFORMATIVO,"
                    + "ID_MATERIAL_ID,"
                    + "ID_TESTE_ID,"
                    + "ESPEC_COMPLETO"
                    + "FROM "
                    + " Cad_EspecLab "
                    + " WHERE"
                    + " ID_TESTE_ID= '" + pNome + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelEspecLab.setId(this.getResultSet().getInt(1));
                modelEspecLab.setOrdem(this.getResultSet().getInt(2));
                modelEspecLab.setMinimo(this.getResultSet().getFloat(3));
                modelEspecLab.setMaximo(this.getResultSet().getFloat(4));
                modelEspecLab.setUnid_medida(this.getResultSet().getString(5));
                modelEspecLab.setTexto(this.getResultSet().getString(6));
                modelEspecLab.setReferencia(this.getResultSet().getString(7));
                modelEspecLab.setTipo_espec(this.getResultSet().getString(8));
                modelEspecLab.setObservacao(this.getResultSet().getString(9));
                modelEspecLab.setHistorico(this.getResultSet().getString(10));
                modelEspecLab.setAtributo(this.getResultSet().getString(11));
                modelEspecLab.setInf(this.getResultSet().getString(12));
                modelEspecLab.setSup(this.getResultSet().getString(13));
                modelEspecLab.setBilateral(this.getResultSet().getString(14));
                modelEspecLab.setInformativo(this.getResultSet().getString(15));
                modelEspecLab.setId_material_id(this.getResultSet().getString(16));
                modelEspecLab.setId_teste_id(this.getResultSet().getString(17));
                modelEspecLab.setEspec_completo(this.getResultSet().getString(18));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelEspecLab;
    }

    public ArrayList<ModelEspecLab> getListaEspecLabIDDAO(String id_controle) {
        ArrayList<ModelEspecLab> listaEspecLab = new ArrayList();
        ModelEspecLab modelEspecLab = new ModelEspecLab();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "dbo.Cad_ResultadoInsp.ID,"
                    + "Cad_EspecLab.ORDEM as ORDEM,"
                    + " MINIMO,"
                    + " MAXIMO,"
                    + "UNID_MEDIDA,"
                    + "TEXTO,"
                    + "REFERENCIA,"
                    + "TIPO_ESPEC,"
                    + "OBSERVACAO,"
                    + "HISTORICO,"
                    + "ATRIBUTO,"
                    + "INF,"
                    + "SUP,"
                    + "BILATERAL,"
                    + "INFORMATIVO,"
                    + "ID_MATERIAL_ID,"
                    + "ID_TESTE_ID,"
                    + "DESC_TESTE,"
                    + "EQUIPAMENTO,"
                    + "ESPEC_COMPLETO"
                    + " FROM "
                    + "Cad_Teste INNER JOIN Cad_EspecLab ON COD_TESTE = ID_TESTE_ID INNER JOIN Cad_Equipamento ON TES_EQUIPAMENTO = EQUIPAMENTO INNER JOIN Cad_ResultadoInsp ON Cad_EspecLab.ID = Cad_ResultadoInsp.ID_ESPECIFICACAO_ID WHERE ID_CONTROLE = '" + id_controle + "' order by ordem"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelEspecLab = new ModelEspecLab();
                modelEspecLab.setId(this.getResultSet().getInt(1));
                modelEspecLab.setOrdem(this.getResultSet().getInt(2));
                modelEspecLab.setMinimo(this.getResultSet().getFloat(3));
                modelEspecLab.setMaximo(this.getResultSet().getFloat(4));
                modelEspecLab.setUnid_medida(this.getResultSet().getString(5));
                modelEspecLab.setTexto(this.getResultSet().getString(6));
                modelEspecLab.setReferencia(this.getResultSet().getString(7));
                modelEspecLab.setTipo_espec(this.getResultSet().getString(8));
                modelEspecLab.setObservacao(this.getResultSet().getString(9));
                modelEspecLab.setHistorico(this.getResultSet().getString(10));
                modelEspecLab.setAtributo(this.getResultSet().getString(11));
                modelEspecLab.setInf(this.getResultSet().getString(12));
                modelEspecLab.setSup(this.getResultSet().getString(13));
                modelEspecLab.setBilateral(this.getResultSet().getString(14));
                modelEspecLab.setInformativo(this.getResultSet().getString(15));
                modelEspecLab.setId_material_id(this.getResultSet().getString(16));
                modelEspecLab.setId_teste_id(this.getResultSet().getString(17));
                modelEspecLab.setDesc_teste(this.getResultSet().getString(18));
                modelEspecLab.setEquipamento(this.getResultSet().getString(19));
                modelEspecLab.setEspec_completo(this.getResultSet().getString(20));
                listaEspecLab.add(modelEspecLab);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaEspecLab;
    }

    public ArrayList<ModelEspecLab> getListaEspecLabIDCompletoDAO(String id_controle) {
        ArrayList<ModelEspecLab> listaEspecLab = new ArrayList();
        ModelEspecLab modelEspecLab = new ModelEspecLab();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "dbo.Cad_ResultadoInsp.ID,"
                    + "Cad_EspecLab.ORDEM as ORDEM,"
                    + " MINIMO,"
                    + " MAXIMO,"
                    + "UNID_MEDIDA,"
                    + "TEXTO,"
                    + "REFERENCIA,"
                    + "TIPO_ESPEC,"
                    + "OBSERVACAO,"
                    + "HISTORICO,"
                    + "ATRIBUTO,"
                    + "INF,"
                    + "SUP,"
                    + "BILATERAL,"
                    + "INFORMATIVO,"
                    + "ID_MATERIAL_ID,"
                    + "ID_TESTE_ID,"
                    + "DESC_TESTE,"
                    + "EQUIPAMENTO,"
                    + "ESPEC_COMPLETO,"
                    + "RESULTADO_NUM,"
                    + "RESULTADO_TEXTO,"
                    + "Cad_ResultadoInsp.OBS,"
                    + "Cad_ResultadoInsp.STATUS,"
                    + "DATA_REGISTRO"
                    + " FROM "
                    + "Cad_Teste INNER JOIN Cad_EspecLab ON COD_TESTE = ID_TESTE_ID INNER JOIN Cad_Equipamento ON TES_EQUIPAMENTO = EQUIPAMENTO INNER JOIN Cad_ResultadoInsp ON Cad_EspecLab.ID = Cad_ResultadoInsp.ID_ESPECIFICACAO_ID WHERE ID_CONTROLE = '" + id_controle + "' and TIPO <> 'Re-Teste' order by ordem"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelEspecLab = new ModelEspecLab();
                modelEspecLab.setId(this.getResultSet().getInt(1));
                modelEspecLab.setOrdem(this.getResultSet().getInt(2));
                modelEspecLab.setMinimo(this.getResultSet().getFloat(3));
                modelEspecLab.setMaximo(this.getResultSet().getFloat(4));
                modelEspecLab.setUnid_medida(this.getResultSet().getString(5));
                modelEspecLab.setTexto(this.getResultSet().getString(6));
                modelEspecLab.setReferencia(this.getResultSet().getString(7));
                modelEspecLab.setTipo_espec(this.getResultSet().getString(8));
                modelEspecLab.setObservacao(this.getResultSet().getString(9));
                modelEspecLab.setHistorico(this.getResultSet().getString(10));
                modelEspecLab.setAtributo(this.getResultSet().getString(11));
                modelEspecLab.setInf(this.getResultSet().getString(12));
                modelEspecLab.setSup(this.getResultSet().getString(13));
                modelEspecLab.setBilateral(this.getResultSet().getString(14));
                modelEspecLab.setInformativo(this.getResultSet().getString(15));
                modelEspecLab.setId_material_id(this.getResultSet().getString(16));
                modelEspecLab.setId_teste_id(this.getResultSet().getString(17));
                modelEspecLab.setDesc_teste(this.getResultSet().getString(18));
                modelEspecLab.setEquipamento(this.getResultSet().getString(19));
                modelEspecLab.setEspec_completo(this.getResultSet().getString(20));
                modelEspecLab.setResult_num(this.getResultSet().getFloat(21));
                modelEspecLab.setResult_text(this.getResultSet().getString(22));
                modelEspecLab.setObs(this.getResultSet().getString(23));
                modelEspecLab.setStatus(this.getResultSet().getString(24));
                modelEspecLab.setData_registro(this.getResultSet().getString(25));
                listaEspecLab.add(modelEspecLab);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaEspecLab;
    }

    public ArrayList<ModelEspecLab> getListaEspecLabIDCompletoRetesteDAO(String id_controle) {
        ArrayList<ModelEspecLab> listaEspecLab = new ArrayList();
        ModelEspecLab modelEspecLab = new ModelEspecLab();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "dbo.Cad_ResultadoInsp.ID,"
                    + "Cad_EspecLab.ORDEM as ORDEM,"
                    + " MINIMO,"
                    + " MAXIMO,"
                    + "UNID_MEDIDA,"
                    + "TEXTO,"
                    + "REFERENCIA,"
                    + "TIPO_ESPEC,"
                    + "OBSERVACAO,"
                    + "HISTORICO,"
                    + "ATRIBUTO,"
                    + "INF,"
                    + "SUP,"
                    + "BILATERAL,"
                    + "INFORMATIVO,"
                    + "ID_MATERIAL_ID,"
                    + "ID_TESTE_ID,"
                    + "DESC_TESTE,"
                    + "EQUIPAMENTO,"
                    + "ESPEC_COMPLETO,"
                    + "RESULTADO_NUM,"
                    + "RESULTADO_TEXTO,"
                    + "Cad_ResultadoInsp.OBS,"
                    + "Cad_ResultadoInsp.STATUS,"
                    + "DATA_REGISTRO"
                    + " FROM "
                    + "Cad_Teste INNER JOIN Cad_EspecLab ON COD_TESTE = ID_TESTE_ID INNER JOIN Cad_Equipamento ON TES_EQUIPAMENTO = EQUIPAMENTO INNER JOIN Cad_ResultadoInsp ON Cad_EspecLab.ID = Cad_ResultadoInsp.ID_ESPECIFICACAO_ID WHERE ID_CONTROLE = '" + id_controle + "' and TIPO = 'Re-Teste' order by data_registro,ordem"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelEspecLab = new ModelEspecLab();
                modelEspecLab.setId(this.getResultSet().getInt(1));
                modelEspecLab.setOrdem(this.getResultSet().getInt(2));
                modelEspecLab.setMinimo(this.getResultSet().getFloat(3));
                modelEspecLab.setMaximo(this.getResultSet().getFloat(4));
                modelEspecLab.setUnid_medida(this.getResultSet().getString(5));
                modelEspecLab.setTexto(this.getResultSet().getString(6));
                modelEspecLab.setReferencia(this.getResultSet().getString(7));
                modelEspecLab.setTipo_espec(this.getResultSet().getString(8));
                modelEspecLab.setObservacao(this.getResultSet().getString(9));
                modelEspecLab.setHistorico(this.getResultSet().getString(10));
                modelEspecLab.setAtributo(this.getResultSet().getString(11));
                modelEspecLab.setInf(this.getResultSet().getString(12));
                modelEspecLab.setSup(this.getResultSet().getString(13));
                modelEspecLab.setBilateral(this.getResultSet().getString(14));
                modelEspecLab.setInformativo(this.getResultSet().getString(15));
                modelEspecLab.setId_material_id(this.getResultSet().getString(16));
                modelEspecLab.setId_teste_id(this.getResultSet().getString(17));
                modelEspecLab.setDesc_teste(this.getResultSet().getString(18));
                modelEspecLab.setEquipamento(this.getResultSet().getString(19));
                modelEspecLab.setEspec_completo(this.getResultSet().getString(20));
                modelEspecLab.setResult_num(this.getResultSet().getFloat(21));
                modelEspecLab.setResult_text(this.getResultSet().getString(22));
                modelEspecLab.setObs(this.getResultSet().getString(23));
                modelEspecLab.setStatus(this.getResultSet().getString(24));
                modelEspecLab.setData_registro(this.getResultSet().getString(25));
                listaEspecLab.add(modelEspecLab);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaEspecLab;
    }

    public ArrayList<ModelEspecLab> getListaEspecLabDAO(String perfil) {
        ArrayList<ModelEspecLab> listaEspecLab = new ArrayList();
        ModelEspecLab modelEspecLab = new ModelEspecLab();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "dbo.Cad_EspecLab.ID,"
                    + "Cad_EspecLab.ORDEM as ORDEM,"
                    + " MINIMO,"
                    + " MAXIMO,"
                    + "UNID_MEDIDA,"
                    + "TEXTO,"
                    + "REFERENCIA,"
                    + "TIPO_ESPEC,"
                    + "OBSERVACAO,"
                    + "HISTORICO,"
                    + "ATRIBUTO,"
                    + "INF,"
                    + "SUP,"
                    + "BILATERAL,"
                    + "INFORMATIVO,"
                    + "ID_MATERIAL_ID,"
                    + "ID_TESTE_ID,"
                    + "DESC_TESTE,"
                    + "EQUIPAMENTO,"
                    + "ESPEC_COMPLETO"
                    + " FROM "
                    + "Cad_Teste INNER JOIN Cad_EspecLab ON COD_TESTE = ID_TESTE_ID INNER JOIN Cad_Equipamento ON TES_EQUIPAMENTO = EQUIPAMENTO WHERE ID_MATERIAL_ID = '" + perfil + "' order by ordem"
                    + ";"
            );
            while (this.getResultSet().next()) {
                modelEspecLab = new ModelEspecLab();
                modelEspecLab.setId(this.getResultSet().getInt(1));
                modelEspecLab.setOrdem(this.getResultSet().getInt(2));
                modelEspecLab.setMinimo(this.getResultSet().getFloat(3));
                modelEspecLab.setMaximo(this.getResultSet().getFloat(4));
                modelEspecLab.setUnid_medida(this.getResultSet().getString(5));
                modelEspecLab.setTexto(this.getResultSet().getString(6));
                modelEspecLab.setReferencia(this.getResultSet().getString(7));
                modelEspecLab.setTipo_espec(this.getResultSet().getString(8));
                modelEspecLab.setObservacao(this.getResultSet().getString(9));
                modelEspecLab.setHistorico(this.getResultSet().getString(10));
                modelEspecLab.setAtributo(this.getResultSet().getString(11));
                modelEspecLab.setInf(this.getResultSet().getString(12));
                modelEspecLab.setSup(this.getResultSet().getString(13));
                modelEspecLab.setBilateral(this.getResultSet().getString(14));
                modelEspecLab.setInformativo(this.getResultSet().getString(15));
                modelEspecLab.setId_material_id(this.getResultSet().getString(16));
                modelEspecLab.setId_teste_id(this.getResultSet().getString(17));
                modelEspecLab.setDesc_teste(this.getResultSet().getString(18));
                modelEspecLab.setEquipamento(this.getResultSet().getString(19));
                modelEspecLab.setEspec_completo(this.getResultSet().getString(20));
                listaEspecLab.add(modelEspecLab);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();

        }
        return listaEspecLab;
    }

    public boolean atualizarEspecLabDAO(ModelEspecLab pModelEspecLab) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE Cad_EspecLab SET "
                    + " ORDEM = '" + pModelEspecLab.getOrdem() + "',"
                    + " MINIMO = '" + pModelEspecLab.getMinimo() + "',"
                    + " MAXIMO = '" + pModelEspecLab.getMaximo() + "',"
                    + " UNID_MEDIDA = '" + pModelEspecLab.getUnid_medida() + "',"
                    + " TEXTO = '" + pModelEspecLab.getTexto() + "',"
                    + " REFERENCIA = '" + pModelEspecLab.getReferencia() + "',"
                    + " TIPO_ESPEC = '" + pModelEspecLab.getTipo_espec() + "',"
                    + " OBSERVACAO = '" + pModelEspecLab.getObservacao() + "',"
                    + " HISTORICO = '" + pModelEspecLab.getHistorico() + "',"
                    + " ATRIBUTO = '" + pModelEspecLab.getAtributo() + "',"
                    + " INF = '" + pModelEspecLab.getInf() + "',"
                    + " SUP = '" + pModelEspecLab.getSup() + "',"
                    + " BILATERAL ='" + pModelEspecLab.getBilateral() + "',"
                    + " INFORMATIVO ='" + pModelEspecLab.getInformativo() + "',"
                    + " ID_MATERIAL_ID ='" + pModelEspecLab.getId_material_id() + "',"
                    + " ID_TESTE_ID = '" + pModelEspecLab.getId_teste_id() + "',"
                    + " ESPEC_COMPLETO = '" + pModelEspecLab.getEspec_completo() + "'"
                    + " WHERE "
                    + " ID= '" + pModelEspecLab.getId() + "'"
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

    public boolean excluirEspecLabDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM  Cad_EspecLab "
                    + " WHERE "
                    + " ID = '" + pCodigo + "'"
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

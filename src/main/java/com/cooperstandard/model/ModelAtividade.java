package com.cooperstandard.model;

import java.sql.Timestamp;
import lombok.Data;

/**
 *
 * @author rsouza10
 */
@Data
public class ModelAtividade {

    private long id;
    private String solicitante, ocorrencia, obs_solicitacao, matrizeiro, obs_manutencao, bpcs, linha, matriz, flag;
    private int id_controle, perfil;
    private Timestamp data_a, data_f;

}

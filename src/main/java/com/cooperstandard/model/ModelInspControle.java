package com.cooperstandard.model;

import java.sql.Timestamp;
import lombok.Data;

/**
 *
 * @author rsouza10
 */
@Data
public class ModelInspControle {

    private long id;
    private int perfil;
    private String solicitante;
    private String data_jet;
    private String hora_jet;
    private String data_base;
    private String linha;
    private String status;
    private String tipoteste;
}

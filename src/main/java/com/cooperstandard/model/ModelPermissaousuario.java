package com.cooperstandard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelPermissaousuario implements Serializable {

    private Integer codigo;
    private Integer codigo_usuario;
    private String permissao;

    public ModelPermissaousuario(Integer userCode, String permission) {
        this.codigo_usuario = userCode;
        this.permissao = permission;
    }

    public ModelPermissaousuario(String permission) {
        this.permissao = permission;
    }
}
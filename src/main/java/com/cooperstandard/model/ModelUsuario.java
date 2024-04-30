package com.cooperstandard.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class ModelUsuario implements Serializable {

    private Integer codigo;
    private String nome;
    private String login;
    private String senha;
    private String setor;
    private String planta;
    private String sobrenome;
    private String email;
    private List<ModelPermissaousuario> permissions;

    public ModelUsuario(String username, String password) {
        this.login = username;
        this.senha = password;
    }
}

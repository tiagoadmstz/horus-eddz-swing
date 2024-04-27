package com.cooperstandard.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ModelUsuario implements Serializable {

    private int codigo;
    private String nome;
    private String login;
    private String senha;
    private String setor;
    private String planta;
    private String sobrenome;
    private String email;

    public ModelUsuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
}

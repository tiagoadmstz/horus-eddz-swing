package com.cooperstandard.model;

public class ModelSessaoUsuario {

    public static int codigo;
    public static String login;
    public static String nome;
    public static String setor;
    public static String planta;
    public static String sobrenome;

    public static void setModelSessaoUsuario(final ModelUsuario modelUsuario) {
        ModelSessaoUsuario.codigo = modelUsuario.getCodigo();
        ModelSessaoUsuario.login = modelUsuario.getLogin();
        ModelSessaoUsuario.nome = modelUsuario.getNome();
        ModelSessaoUsuario.setor = modelUsuario.getSetor();
        ModelSessaoUsuario.planta = modelUsuario.getPlanta();
        ModelSessaoUsuario.sobrenome = modelUsuario.getSobrenome();
    }
}

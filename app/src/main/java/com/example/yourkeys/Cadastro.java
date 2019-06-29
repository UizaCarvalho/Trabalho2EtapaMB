package com.example.yourkeys;

public class Cadastro {
    int id;
    String usuario;
    String senha;
    String aplicativo;
    String email;


    public Cadastro() {
    }

    public Cadastro(int id, String usuario, String senha, String aplicativo, String email) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.aplicativo = aplicativo;
        this.email = email;
    }

    public Cadastro(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAplicativo() {
        return aplicativo;
    }

    public void setAplicativo(String aplicativo) {
        this.aplicativo = aplicativo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

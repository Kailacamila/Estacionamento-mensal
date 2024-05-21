package org.example.model.Entity;


import javax.persistence.Column;

public class Login {


    @Column(name = "nome" )
    private String nome;


    @Column(name = "senha" )
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}



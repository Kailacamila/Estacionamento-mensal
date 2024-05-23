package org.example.model.Entity;

import javax.persistence.*;


@Entity
@Table(name = "tb_funcionario", schema = "public")
public class Funcionario {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
   private Long id;


  @Column(name = "nome" )
   private String nome;


    @Column(name = "cpf" )
   private String cpf;


    public Long getId() {
       return id;
   }

    public void setId(Long id) {
       this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
   }

}



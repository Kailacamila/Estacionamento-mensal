package org.example.model.Entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "tb_modelo", schema = "public")
public class Modelo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column (name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "marca_Id", nullable = false)
    private Marca marcaId;


    @Column(name = "modelo", nullable = false, unique = true, length = 50)
    private String nome;

    public Modelo(Long id, Marca marcaId, String nome) {
        this.id = id;
        this.marcaId = marcaId;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Modelo() {
    }

    public Marca getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Marca marcaId) {
        this.marcaId = marcaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}


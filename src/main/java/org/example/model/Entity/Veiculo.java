package org.example.model.Entity;

import javax.persistence.*;

@Entity

@Table(name = "tb_veiculo", schema = "public")
public class Veiculo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column (name = "id")
        private Long id;


        @Column(name = "placa", length = 10, nullable = false, unique = true)
        private String placa;


        @Column(name = "cor", length = 15, nullable = false)
        private String cor;

        @JoinColumn(name = "modelo_id", nullable = false)
        private Modelo modeloId;



        @Column(name = "tipo", length = 5, nullable = false)
        private String tipo;


        @Column(name = "ano", nullable = false)
        private int ano;
    }


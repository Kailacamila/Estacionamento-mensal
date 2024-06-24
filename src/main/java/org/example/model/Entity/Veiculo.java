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

        @OneToOne
        @JoinColumn(name = "modelo_id", nullable = false)
        private Modelo modeloId;



        @Column(name = "tipo", length = 5, nullable = false)
        private String tipo;


        @Column(name = "ano", nullable = false)
        private long ano;
        
        

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getPlaca() {
                return placa;
        }

        public void setPlaca(String placa) {
                this.placa = placa;
        }

        public String getCor() {
                return cor;
        }

        public void setCor(String cor) {
                this.cor = cor;
        }

        public Modelo getModeloId() {
                return modeloId;
        }

        public void setModeloId(Modelo modeloId) {
                this.modeloId = modeloId;
        }

        public String getTipo() {
                return tipo;
        }

        public void setTipo(String tipo) {
                this.tipo = tipo;
        }

        public long getAno() {
                return ano;
        }

        public void setAno(long ano) {
                this.ano = ano;
        }
}


package org.example.model.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Table(name = "tb_configuracao", schema = "public")
public class Configuracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column(name = "valor_hora")
    private BigDecimal valorHora;

    @Column(name = "inicio_expediente")
    private LocalTime inicioExpediente;

    @Column(name = "fim_expediente")
    private LocalTime fimExpediente;

    @Column(name = "vagas_carro")
    private int vagasCarro;

    @Column(name = "vagas_moto")
    private int vagasMoto;

    @Column(name = "vagas_van")
    private int vagasVan;

    public BigDecimal getValorHora() {
        return valorHora;
    }

    public void setValorHora(BigDecimal valorHora) {
        this.valorHora = valorHora;
    }

    public int getVagasVan() {
        return vagasVan;
    }

    public void setVagasVan(int vagasVan) {
        this.vagasVan = vagasVan;
    }

    public int getVagasMoto() {
        return vagasMoto;
    }

    public void setVagasMoto(int vagasMoto) {
        this.vagasMoto = vagasMoto;
    }

    public int getVagasCarro() {
        return vagasCarro;
    }

    public void setVagasCarro(int vagasCarro) {
        this.vagasCarro = vagasCarro;
    }

    public LocalTime getInicioExpediente() {
        return inicioExpediente;
    }

    public void setInicioExpediente(LocalTime inicioExpediente) {
        this.inicioExpediente = inicioExpediente;
    }

    public LocalTime getFimExpediente() {
        return fimExpediente;
    }

    public void setFimExpediente(LocalTime fimExpediente) {
        this.fimExpediente = fimExpediente;
    }
}

package org.example.model.Service;

import org.example.model.Entity.Marca;
import org.example.model.Entity.Movimento;
import org.example.model.Repositories.MarcaRepository;
import org.example.model.Repositories.MovimentoRepository;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class MovimentoService {

    private MovimentoRepository movimentoRepository = new MovimentoRepository();

    public MovimentoService(MovimentoRepository movimentoRepository) {
    }

    public Movimento findMovimentoById(Long id) {
        return (Movimento) movimentoRepository.findById(id);
    }

    public List<Movimento> findAll() {
        return movimentoRepository.findAll();
    }

    public void updateMovimento(Movimento movimento) {
        movimentoRepository.update(movimento);
    }

    public void deleteMovimento(Long id) {
        movimentoRepository.delete(id);
    }

    public Movimento createMovimento(Movimento movimento) {
        movimento.setEntrada(LocalTime.now());
        return (Movimento) movimentoRepository.create(movimento);
    }
    public Movimento finalizarMovimento(Long id) {
        Movimento movimento = (Movimento) movimentoRepository.findById(id);
        if (movimento != null && !movimento.isFinalizado()) {
            LocalTime now = LocalTime.now();
            movimento.setSaida(now);
            movimento.setFinalizado(true);

            Duration duration = Duration.between(movimento.getEntrada(), now);
            long minutes = duration.toMinutes();
            BigDecimal hours = BigDecimal.valueOf(minutes).divide(BigDecimal.valueOf(60), 2, BigDecimal.ROUND_HALF_UP);
            BigDecimal total = hours.multiply(movimento.getValorHora());

            movimento.setTempo(LocalTime.of((int) hours.doubleValue(), (int) (hours.doubleValue() * 60) % 60));
            movimento.setValorTotal(total);

            movimentoRepository.update(movimento);
        }
        return movimento;
    }
}
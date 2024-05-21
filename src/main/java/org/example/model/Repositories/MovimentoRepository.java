package org.example.model.Repositories;

import org.example.model.Entity.Movimento;

import java.util.List;

@Repository

public interface MovimentoRepository extends  JpaRepository<Movimento, Long> {
    List<Movimento> findAll();
}

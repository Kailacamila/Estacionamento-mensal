package org.example.model.Repositories;


import org.example.model.Entity.Marca;
import org.example.model.Entity.Veiculo;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class VeiculoRepository implements BasicCrud{
    EntityManager em = Persistence.createEntityManagerFactory("Bancoestacionamento").createEntityManager();

    @Override
    public Object create(Object object) {
        Veiculo veiculo1 = (Veiculo) object;
        em.getTransaction().begin();
        em.persist(veiculo1);
        em.getTransaction().commit();
        return findById(veiculo1.getId());
    }

    @Override
    public Object update(Object object) {
        Veiculo veiculoUpdate = (Veiculo) object;
        em.getTransaction().begin();
        em.merge(veiculoUpdate);
        em.getTransaction().commit();
        return null;
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        var veiculo = (Veiculo) findById(id);
        em.remove(veiculo);
        em.getTransaction().commit();
    }
    public List<Veiculo> findAll(){
        System.out.println("teste");
        return new ArrayList<Veiculo>();
        //return em.createQuery("aa",FuncionariosEntity.class).getResultList();
    }

    public Object findById(Object id) {
        try {
            return em.find(Veiculo.class, id);
        } catch (Exception e) {
            System.out.println(e.getCause().toString());
        }
        return null;
    }

}


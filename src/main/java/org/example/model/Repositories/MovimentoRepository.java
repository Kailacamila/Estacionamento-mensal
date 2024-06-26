package org.example.model.Repositories;

import org.example.model.Entity.Funcionario;
import org.example.model.Entity.Marca;
import org.example.model.Entity.Movimento;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class MovimentoRepository implements BasicCrud{
    EntityManager em = Persistence.createEntityManagerFactory("Bancoestacionamento").createEntityManager();

    @Override
    public Object create(Object object) {
        Movimento movimento1 = (Movimento) object;
        em.getTransaction().begin();
        em.persist(movimento1);
        em.getTransaction().commit();
        return findById(movimento1.getId());
    }

    @Override
    public Object update(Object object) {
        Movimento movimentoUpdate = (Movimento) object;
        em.getTransaction().begin();
        em.merge(movimentoUpdate);
        em.getTransaction().commit();
        return null;
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        var movimento = (Movimento) findById(id);
        em.remove(movimento);
        em.getTransaction().commit();
    }
    public List<Movimento> findAll(){
        return em.createQuery("SELECT m FROM Movimento m", Movimento.class).getResultList();
 }


    public Object findById(Object id) {
        try {
            return em.find(Movimento.class, id);
        } catch (Exception e) {
            System.out.println(e.getCause().toString());
        }
        return null;
    }

}

// creat  // update // delete // fibyid//


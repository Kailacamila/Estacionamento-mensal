package org.example.model.Repositories;

import org.example.model.Entity.Marca;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public interface MarcaRepository extends BasicCrud{
    EntityManager em = Persistence.createEntityManagerFactory("Bancoestacionamento").createEntityManager();

    @Override
    public default Object create(Object object) {
        Marca marca1 = (Marca) object;
        em.getTransaction().begin();
        em.persist(marca1);
        em.getTransaction().commit();
        return findById(marca1.getId());
    }

    @Override
    public default Object update(Object object) {
        Marca marcaUpdate = (Marca) object;
        em.getTransaction().begin();
        em.merge(marcaUpdate);
        em.getTransaction().commit();
        return null;
    }

    @Override
    public default void delete(Long id) {
        em.getTransaction().begin();
        var marca = (Marca) findById(id);
        em.remove(marca);
        em.getTransaction().commit();
    }
    public default List<Marca> findAll(){
        System.out.println("teste");
        return new ArrayList<Marca>();
        //return em.createQuery("aa",FuncionariosEntity.class).getResultList();
    }

    @Override
    public default Object findById(Object id) {
        try {
            Marca marcaInBd = em.find(Marca.class, id);
            return marcaInBd;
        } catch (Exception e) {

        }
        return null;
    }

}


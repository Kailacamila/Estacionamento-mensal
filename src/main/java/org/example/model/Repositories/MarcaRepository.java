package org.example.model.Repositories;

import org.example.model.Entity.Configuracao;
import org.example.model.Entity.Marca;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class MarcaRepository implements BasicCrud{
	
    EntityManager em = Persistence.createEntityManagerFactory("Bancoestacionamento").createEntityManager();

    @Override
    public Object create(Object object) {
        Marca marca1 = (Marca) object;
        em.getTransaction().begin(); 
        em.persist(marca1);
        em.getTransaction().commit();
        return findById(marca1.getId());
    }

    @Override
    public Object update(Object object) {
        Marca marcaUpdate = (Marca) object;
        em.getTransaction().begin();
        em.merge(marcaUpdate);
        em.getTransaction().commit();
        return null;
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        var marca = (Marca) findById(id);
        em.remove(marca);
        em.getTransaction().commit();
    }
    public List<Marca> findAll(){
        return em.createQuery("SELECT m FROM Marca m", Marca.class).getResultList();

    }


    public Object findById(Object id) {
        try {
            return em.find(Marca.class, id);
        } catch (Exception e) {
            System.out.println(e.getCause().toString());
        }
        return null;
    }

}

// creat  // update // delete // fibyid//


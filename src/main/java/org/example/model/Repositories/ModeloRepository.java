package org.example.model.Repositories;

import org.example.model.Entity.Funcionario;
import org.example.model.Entity.Marca;
import org.example.model.Entity.Modelo;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class ModeloRepository implements BasicCrud{
	
    EntityManager em = Persistence.createEntityManagerFactory("Bancoestacionamento").createEntityManager();

    @Override
    public Object create(Object object) {
        Modelo modelo1 = (Modelo) object;
        em.getTransaction().begin();
        em.persist(modelo1);
        em.getTransaction().commit();
        return findById(modelo1.getId());
    }
    

    @Override
    public Object update(Object object) {
        Modelo modeloUpdate = (Modelo) object;
        em.getTransaction().begin();
        em.merge(modeloUpdate);
        em.getTransaction().commit();
        return null;
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        var modelo = (Modelo) findById(id);
        em.remove(modelo);
        em.getTransaction().commit();
    }
    public List<Modelo> findAll(){
        return em.createQuery("SELECT m FROM Modelo m", Modelo.class).getResultList();

    }

    @Override
    public Object findById(Object id) {
    	var modelo = (Modelo) id;
        try {
            return em.find(Modelo.class, modelo.getId());
        } catch (Exception e) {
            System.out.println(e.getCause().toString());
        }
        return null;
    }


}



// creat  // update // delete // fibyid//


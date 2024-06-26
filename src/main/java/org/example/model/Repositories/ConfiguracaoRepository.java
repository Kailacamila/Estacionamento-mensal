package org.example.model.Repositories;

import org.example.model.Entity.Configuracao;
import org.example.model.Entity.Marca;
import org.example.model.Entity.Veiculo;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class ConfiguracaoRepository implements BasicCrud{
    EntityManager em = Persistence.createEntityManagerFactory("Bancoestacionamento").createEntityManager();

    @Override
    public Object create(Object object) {
        Configuracao configuracao1 = (Configuracao) object;
        em.getTransaction().begin();
        em.persist(configuracao1);
        em.getTransaction().commit();
        return findById(configuracao1.getId());
    }

    @Override
    public Object update(Object object) {
        Configuracao configuracaoUpdate = (Configuracao) object;
        em.getTransaction().begin();
        em.merge(configuracaoUpdate);
        em.getTransaction().commit();
        return null;
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        var configuracao = (Configuracao) findById(id);
        em.remove(configuracao);
        em.getTransaction().commit();
    }
    public List<Configuracao> findAll(){
        return em.createQuery("SELECT c FROM Configuracao c", Configuracao.class).getResultList();
        }


    public Object findById(Object id) {
        try {
            return em.find(Configuracao.class, id);
        } catch (Exception e) {
            System.out.println(e.getCause().toString());
        }
        return null;
    }

}

// creat  // update // delete // fibyid//


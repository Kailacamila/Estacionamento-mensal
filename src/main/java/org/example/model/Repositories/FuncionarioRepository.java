package org.example.model.Repositories;

import org.example.model.Entity.Funcionario;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository implements BasicCrud {
    EntityManager em = Persistence.createEntityManagerFactory("Bancoestacionamento").createEntityManager();

    @Override
    public Object create(Object object) {
        Funcionario funcionario1 = (Funcionario) object;
        validateCPF(funcionario1.getCpf());
        em.getTransaction().begin();
        em.persist(funcionario1);
        em.getTransaction().commit();
        return findById(funcionario1.getId());
    }

    @Override
    public Object update(Object object) {
        Funcionario funcionarioUpdate = (Funcionario) object;
        validateCPF(funcionarioUpdate.getCpf());
        em.getTransaction().begin();
        em.merge(funcionarioUpdate);
        em.getTransaction().commit();
        return findById(funcionarioUpdate.getId());
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        var funcionario = (Funcionario) findById(id);
        em.remove(funcionario);
        em.getTransaction().commit();
    }

    public List<Funcionario> findAll() {
        return em.createQuery("SELECT f FROM Funcionario f", Funcionario.class).getResultList();
    }

    public Object findById(Object id) {
        try {
            return em.find(Funcionario.class, id);
        } catch (Exception e) {
            System.out.println(e.getCause().toString());
        }
        return null;
    }

    private void validateCPF(String cpf) {
        if (!cpf.matches("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}")) {
            throw new IllegalArgumentException("Formato do CPF inválido!");
        }
    }
}

package org.example.model.Repositories;

import org.example.model.Entity.Login;

import java.util.List;

@Repository

public interface LoginRepository extends JpaRepository <Login , Long > {
    List<Login> findAll();
}

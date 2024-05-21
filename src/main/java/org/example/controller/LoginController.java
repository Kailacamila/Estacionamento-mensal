package org.example.controller;


import org.example.model.Entity.Login;
import org.example.model.Repositories.LoginRepository;

import java.util.List;

public class LoginController {
    private LoginRepository loginRepository;

    public List<Login> findAll() {
        return loginRepository.findAll();
    }
}

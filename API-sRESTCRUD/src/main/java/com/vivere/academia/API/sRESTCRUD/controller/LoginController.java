package com.vivere.academia.API.sRESTCRUD.controller;

import com.vivere.academia.API.sRESTCRUD.model.Usuario;
import com.vivere.academia.API.sRESTCRUD.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value="/api")
public class LoginController {

    @Autowired
    private LoginService loginService;


    @PostMapping("/login")
    public Optional<Usuario> login(@RequestParam (value = "login") String login, @RequestParam (value = "senha") String senha){
        return loginService.usuarioLogin(login, senha);
    }

}

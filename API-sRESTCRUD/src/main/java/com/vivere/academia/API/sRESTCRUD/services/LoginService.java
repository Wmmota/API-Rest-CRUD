package com.vivere.academia.API.sRESTCRUD.services;

import com.vivere.academia.API.sRESTCRUD.exceptions.ObjectNotFoundException;
import com.vivere.academia.API.sRESTCRUD.model.Usuario;
import com.vivere.academia.API.sRESTCRUD.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    private String message = "Usuario logado com sucesso";

//    public Optional<Usuario> loginUsuario(String login, String senha) {
//        Optional<Usuario> user = usuarioRepository.findByLoginAndSenha(login, senha);
//        if (user.get().getLogin().isEmpty() && user.get().getSenha().isEmpty()) {
//            throw new ObjectNotFoundException("Login ou senha inválido");
//        } else if (usuarioRepository.findByStatus(user.get().getStatus()).equals("C")){
//            throw new ObjectNotFoundException("Estado com situação de Cancelado");
//        } else {
//            System.out.println("entrou na service");
//            return user;
//        }
//    }

    public Optional<Usuario> usuarioLogin(String login, String senha){
        Optional<Usuario> usuario = usuarioRepository.findByLoginAndSenha(login, senha);
        if(usuario.isPresent()){
            if(login.equals(usuario.get().getLogin()) && senha.equals(usuario.get().getSenha()) && usuario.get().getStatus().equals("A")){
                return usuario;
            } else if(login.equals(usuario.get().getLogin()) && senha.equals(usuario.get().getSenha()) && usuario.get().getStatus().equals("C")){
                throw new ObjectNotFoundException("Usuario cancelado");
            } else {
                throw new ObjectNotFoundException("Erro");
            }
        } else {
            throw new ObjectNotFoundException("Erro, usuario ou senha inválidos");
        }
    }
}



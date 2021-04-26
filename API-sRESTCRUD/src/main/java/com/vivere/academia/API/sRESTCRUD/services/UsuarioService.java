package com.vivere.academia.API.sRESTCRUD.services;

import com.vivere.academia.API.sRESTCRUD.exceptions.ObjectNotFoundException;
import com.vivere.academia.API.sRESTCRUD.model.Usuario;
import com.vivere.academia.API.sRESTCRUD.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listAll(){
        return usuarioRepository.findAll();
    }

    public Usuario save(Usuario usuario){
        if(usuario.getNome().equals("")
                || usuario.getLogin().equals("")
                || usuario.getSenha().equals("")
                || usuario.getPerfil().equals("")
                || usuario.getStatus().equals("")){
            throw new ObjectNotFoundException("Campo obrigatorio não informado");
        } else {
        if((usuario.getStatus().equals("A") || usuario.getStatus().equals("C")) &&
        (usuario.getPerfil().equals("A") || usuario.getPerfil().equals("O"))
        ){
        usuario.setEmail(usuario.getEmail().toLowerCase());
        usuario.setNome(usuario.getNome().toUpperCase());
        usuarioRepository.save(usuario);
        return usuario;
        } else if (usuario.getStatus().equals("A") || usuario.getStatus().equals("C")
        ){
            throw new ObjectNotFoundException("Perfil diferente de Administrador ou operador");
        } else {
            throw new ObjectNotFoundException("Status diferente de Ativo ou Cancelado");
        }
        }
    }



    public Usuario get(Long id) {
        if (usuarioRepository.findById(id).isPresent()) {
            return usuarioRepository.findById(id).get();
        } else {
            throw new ObjectNotFoundException("Usuario não encontrado pelo id " + id);
        }
    }

    public void delete(Long id){
        if (usuarioRepository.findById(id).isPresent()){
            usuarioRepository.deleteById(id);
        } else {
            throw new ObjectNotFoundException("Usuario não encontrado pelo id " + id);
        }

    }







}

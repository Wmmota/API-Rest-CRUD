package com.vivere.academia.API.sRESTCRUD.services;

import com.vivere.academia.API.sRESTCRUD.model.Clientes;
import com.vivere.academia.API.sRESTCRUD.model.Usuario;
import com.vivere.academia.API.sRESTCRUD.repository.ClientesRepository;
import com.vivere.academia.API.sRESTCRUD.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.time.LocalDateTime;


@Service
public class DbService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    private ClientesRepository clientesRepository;

    public void instantiateTestDataBase() throws ParseException {
        Usuario user1 = new Usuario(LocalDateTime.now(), "Milly", "Mylly6", "teste", "119865747", "milly@milly","C", "A");
        Usuario user2 = new Usuario(LocalDateTime.now(), "Miguel", "Miguel53", "teste", "119865747", "migul@miguel","C", "C");
        //Clientes cliente1 = new Clientes(LocalDateTime.now(), "Milly", "23651000827", "rua teste", "São Paulo", "SP", "00000", "99999999", "teste@teste.com");
        //Clientes cliente2 = new Clientes(LocalDateTime.now(), "Miguel", "23652000827                  ", "rua teste", "São Paulo", "SP", "00000", "99999999", "teste@teste.com");
        usuarioRepository.save(user1);
        usuarioRepository.save(user2);
        //clientesRepository.save(cliente1);
        //clientesRepository.save(cliente2);
    }

}

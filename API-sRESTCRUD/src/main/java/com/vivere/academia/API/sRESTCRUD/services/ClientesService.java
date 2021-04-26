package com.vivere.academia.API.sRESTCRUD.services;

import com.vivere.academia.API.sRESTCRUD.exceptions.ObjectNotFoundException;
import com.vivere.academia.API.sRESTCRUD.model.Clientes;
import com.vivere.academia.API.sRESTCRUD.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesService {
    @Autowired
    private ClientesRepository clientesRepository;

    public List<Clientes> listAll(){

        return clientesRepository.findAll();
    }

    public Clientes save(Clientes clientes){
        if(clientes.getNome().equals("")
                || clientes.getCpfCnpj().equals("")
                || clientes.getLogradouro().equals("")
                || clientes.getCidade().equals("")
                || clientes.getUf().equals("")
                || clientes.getCep().equals("")){
            throw new ObjectNotFoundException("Campo obrigatorio não informado");
        } else {
            clientes.setNome(clientes.getNome().toUpperCase());
            clientesRepository.save(clientes);
            return clientes;
        }
    }

    public Clientes get(Long id) {
        if (clientesRepository.findById(id).isPresent()) {
            return clientesRepository.findById(id).get();
        } else {
            throw new ObjectNotFoundException("Cliente não encontrado pelo id " + id);
        }
    }

    public void delete(Long id){
        if (clientesRepository.findById(id).isPresent()){
        clientesRepository.deleteById(id);
        } else {
            throw new ObjectNotFoundException("Cliente não encontrado pelo id "+ id);
        }

    }

}

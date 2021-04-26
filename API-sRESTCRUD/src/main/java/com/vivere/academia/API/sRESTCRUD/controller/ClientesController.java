package com.vivere.academia.API.sRESTCRUD.controller;

import com.vivere.academia.API.sRESTCRUD.model.Clientes;
import com.vivere.academia.API.sRESTCRUD.repository.ClientesRepository;
import com.vivere.academia.API.sRESTCRUD.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value="/api")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @Autowired
    private ClientesRepository clientesRepository;

    @RequestMapping("/clientes")
    public ResponseEntity<List<Clientes>> listaClientes(){
        List<Clientes> clientesList = clientesService.listAll();
        return ResponseEntity.ok().body(clientesList);
    }

    @RequestMapping("/cliente/{id}")
    public ResponseEntity<Clientes> listaCliente(@Valid @PathVariable(value = "id") Long id){
        Clientes obj = clientesService.get(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/cliente")
    public ResponseEntity<Clientes> criarCliente(@Valid @RequestBody Clientes cliente){
        Clientes obj = clientesService.save(cliente);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<Long> deletaCliente(@Valid @PathVariable("id") Long id){
        clientesService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/cliente")
    public ResponseEntity<Clientes> atualizaCliente(@RequestBody Clientes clientes){
        Clientes obj = clientesService.save(clientes);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/cliente/busca")
    public List<Clientes> findByContains(
            @RequestParam(value = "nome", defaultValue = "") String nome,
            @RequestParam(value = "cpfCnpj", defaultValue = "") String cpfCnpj,
            @RequestParam(value = "cidade", defaultValue = "") String cidade,
            @RequestParam(value = "uf", defaultValue = "") String uf){
        return clientesRepository.findByNomeOrCpfCnpjOrCidadeOrUfContaining(nome.toUpperCase(), cpfCnpj, cidade, uf)
                .stream()
                .map(Clientes::converter)
                .collect(Collectors.toList());
    }
}

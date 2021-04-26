package com.vivere.academia.API.sRESTCRUD.controller;

import com.vivere.academia.API.sRESTCRUD.model.LivroCaixa;
import com.vivere.academia.API.sRESTCRUD.repository.LivroCaixaRepository;
import com.vivere.academia.API.sRESTCRUD.services.LivroCaixaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class LivroCaixaController {

    @Autowired
    private LivroCaixaService livroCaixaService;

    @Autowired
    private LivroCaixaRepository livroCaixaRepository;

    @RequestMapping("/livrocaixa")
    public ResponseEntity<List<LivroCaixa>> listaLivroCaixa(){
        List<LivroCaixa> livroCaixaList = livroCaixaService.listAll();
        return ResponseEntity.ok().body(livroCaixaList);
    }

    @GetMapping("/livrocaixa/cliente/{id}")
    public ResponseEntity <List<LivroCaixa>> listaLivroCaixa(@PathVariable(value = "id") Long id){
        List<LivroCaixa> obj = livroCaixaService.findIdClientes(id);
        return ResponseEntity.ok().body(obj);
    }

 @RequestMapping("/livrocaixa/{id}")
    public ResponseEntity<LivroCaixa> listaCliente(@Valid @PathVariable(value = "id") Long id){
        LivroCaixa obj = livroCaixaService.get(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/livrocaixa")
    public ResponseEntity<LivroCaixa> criarLivroCaixa(@RequestBody LivroCaixa livroCaixa){
        LivroCaixa obj = livroCaixaService.save(livroCaixa);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/livrocaixa/{id}")
    public ResponseEntity<Long> deletaLivrocaixa(@PathVariable("id") Long id){
        livroCaixaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/livrocaixa")
    public ResponseEntity<LivroCaixa> atualizaLivroCAixa(@RequestBody LivroCaixa livroCaixa){
        LivroCaixa obj = livroCaixaService.save(livroCaixa);
        return ResponseEntity.ok().body(obj);
    }
}

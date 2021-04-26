package com.vivere.academia.API.sRESTCRUD.controller;
import com.vivere.academia.API.sRESTCRUD.model.Usuario;
import com.vivere.academia.API.sRESTCRUD.repository.UsuarioRepository;
import com.vivere.academia.API.sRESTCRUD.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping("/usuarios")
    public ResponseEntity< List<Usuario>> listaUsuarios(){
        List<Usuario> usuarioList = usuarioService.listAll();
        return ResponseEntity.ok().body(usuarioList);
    }

    @RequestMapping("/usuario/{id}")
    public ResponseEntity<Usuario> listaUsuario(@PathVariable(value = "id") Long id){
    Usuario obj = usuarioService.get(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/usuario")
    public ResponseEntity<Void> criarUsuario(@RequestBody Usuario usuario){
        usuario = usuarioService.save(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").build(usuario.getId());

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Long> deletaUsuario(@PathVariable("id") Long id){
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/usuario")
    public ResponseEntity<Usuario> atualizaUsuario(@RequestBody Usuario usuario){
        Usuario obj = usuarioService.save(usuario);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/usuario/busca")
    public List<Usuario> findByNomeEmail(
            @RequestParam(value = "nome", defaultValue = "") String nome,
            @RequestParam(value = "email", defaultValue = "") String email){
        return usuarioRepository.findByNomeOrEmailContaining(nome.toUpperCase(), email.toLowerCase())
                .stream()
                .map(Usuario::converter)
                .collect(Collectors.toList());
    }



}

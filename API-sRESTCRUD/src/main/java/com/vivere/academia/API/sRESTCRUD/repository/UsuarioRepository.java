package com.vivere.academia.API.sRESTCRUD.repository;
import com.vivere.academia.API.sRESTCRUD.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

     List<Usuario> findByNomeOrEmailContaining (String nome, String email);

     Optional<Usuario> findByLoginAndSenha(String login, String senha);


    Optional<Usuario> findByStatus(String estado);

}

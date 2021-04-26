package com.vivere.academia.API.sRESTCRUD.repository;
import com.vivere.academia.API.sRESTCRUD.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {

     List<Clientes> findByNomeOrCpfCnpjOrCidadeOrUfContaining (String nome, String cpfCnpj, String cidade, String uf);

}

package com.vivere.academia.API.sRESTCRUD.repository;

import com.vivere.academia.API.sRESTCRUD.model.LivroCaixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroCaixaRepository extends JpaRepository<LivroCaixa, Long> {
    @Query("SELECT t FROM LivroCaixa t WHERE t.clientes.id = :clientes")
    List<LivroCaixa> findIdClientes (Long clientes);
}

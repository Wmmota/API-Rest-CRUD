package com.vivere.academia.API.sRESTCRUD.services;

import com.vivere.academia.API.sRESTCRUD.exceptions.ObjectNotFoundException;
import com.vivere.academia.API.sRESTCRUD.model.LivroCaixa;
import com.vivere.academia.API.sRESTCRUD.repository.LivroCaixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroCaixaService {

    @Autowired
    private LivroCaixaRepository livroCaixaRepository;

    public List<LivroCaixa> listAll() {

        return livroCaixaRepository.findAll();
    }

    public LivroCaixa save(LivroCaixa livroCaixa) {
        if(livroCaixa.getClientes().getId() == null || livroCaixa.getDataLancamento() == null || livroCaixa.getDescricao() == null || livroCaixa.getTipo() == null || livroCaixa.getValor() == null){
            throw new ObjectNotFoundException("Não são permitidos campos marcados como null no livro caixa");
        } else if (livroCaixa.getTipo().equals("C") || livroCaixa.getTipo().equals("D")){
            livroCaixaRepository.save(livroCaixa);
            return livroCaixa;
        } else {
            throw new ObjectNotFoundException("Tipo de pagamento diferente de Crédito ou Débito");
        }
    }

    public LivroCaixa get(Long id) {
        return livroCaixaRepository.findById(id).get();
    }

    public List<LivroCaixa> findIdClientes(Long id) {
        return livroCaixaRepository.findIdClientes(id);
    }


    public void delete(Long id) {
        if (livroCaixaRepository.findById(id).isPresent()) {
            livroCaixaRepository.deleteById(id);
        } else {
            throw new ObjectNotFoundException("LivroCaixa não encontrado pelo id " + id);
        }

    }
}

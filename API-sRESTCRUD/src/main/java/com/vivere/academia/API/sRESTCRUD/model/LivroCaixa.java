package com.vivere.academia.API.sRESTCRUD.model;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;



@Entity
@Table(name="TB_LIVRO_CAIXA")
public class LivroCaixa {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "cliente_id")
        private Clientes clientes;

        @NotNull
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @Column(nullable = false)
        private LocalDate dataLancamento;

        @NotNull
        @NotBlank(message = "Error")
        @Column(columnDefinition = "VARCHAR(50)", nullable = false)
        private String descricao;

        @NotNull
        @Column(columnDefinition = "CHAR(1)", nullable = false)
        private String tipo;

        //@NotNull
        //@Digits(integer=12, fraction=2)
        @Column(length = 12 , scale = 2)
        private BigDecimal valor;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}


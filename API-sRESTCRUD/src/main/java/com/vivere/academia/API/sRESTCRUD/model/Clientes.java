package com.vivere.academia.API.sRESTCRUD.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tb_clientes")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @NotEmpty(message = "Preenchimento Obrigatório")
    @Column(columnDefinition="VARCHAR(30)", nullable = false)
    private String nome;

    @Pattern(regexp = "^[0-9]{1,14}$")
    @NotBlank(message = "Inválido")
    @Size(max = 14, message = "CPF/CNPJ inválido")
    @Column(length = 14, nullable = false)
    private String cpfCnpj;

    @NotNull
    @Column(columnDefinition="VARCHAR(50)", nullable = false)
    private String logradouro;

    @NotNull
    @Column(columnDefinition="VARCHAR(40)", nullable = false)
    private String cidade;

    @NotNull
    @Column(columnDefinition="CHAR(2)", nullable = false)
    private String uf;

    @NotNull
    @Column(columnDefinition="CHAR(8)", nullable = false)
    private String cep;

    @Column(columnDefinition="VARCHAR(11)")
    private String telefone;

    @Column(columnDefinition="VARCHAR(100)")
    private String email;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientes")
    private List<LivroCaixa> livroCaixa = new ArrayList<>();



    public static Clientes converter(Clientes c){
        Clientes client = new Clientes();
        client.setId(c.getId());
        client.setNome(c.getNome());
        client.setCpfCnpj(c.getCpfCnpj());
        client.setLogradouro(c.getLogradouro());
        client.setCidade(c.getCidade());
        client.setUf(c.getUf());
        client.setCep(c.getCep());
        client.setTelefone(c.getTelefone());
        client.setEmail(c.getEmail());
        return client;
    }

//    public Clientes(){
//
//    }
//
//    public Clientes(
//            LocalDateTime dataCadastro,
//            String nome,
//            String cpfCnpj,
//            String logradouro,
//            String cidade,
//            String uf,
//            String cep,
//            String telefone,
//            String email) {
//        this.dataCadastro = dataCadastro;
//        this.nome = nome;
//        this.cpfCnpj = cpfCnpj;
//        this.logradouro = logradouro;
//        this.cidade = cidade;
//        this.uf = uf;
//        this.cep = cep;
//        this.telefone = telefone;
//        this.email = email;
//    }


    public List<LivroCaixa> getLivroCaixa() {
        return livroCaixa;
    }

    public void setLivroCaixa(List<LivroCaixa> livroCaixa) {
        this.livroCaixa = livroCaixa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "id=" + id +
                ", dataCadastro=" + dataCadastro +
                ", nome='" + nome + '\'' +
                ", cpfCnpj='" + cpfCnpj + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                ", cep='" + cep + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", livroCaixa=" + livroCaixa +
                '}';
    }
}

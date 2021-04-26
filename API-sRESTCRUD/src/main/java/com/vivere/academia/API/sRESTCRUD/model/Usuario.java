package com.vivere.academia.API.sRESTCRUD.model;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;


@Entity
@Table(name="tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @NotNull
    @NotEmpty
    @Column(columnDefinition = "VARCHAR(30)", nullable = false)
    private String nome;

    @NotNull
    @NotEmpty
    @Column(unique = true, columnDefinition = "VARCHAR(15)", nullable = false)
    private String login;

    @NotNull
    @NotEmpty
    @Column(columnDefinition = "VARCHAR(10)", nullable = false)
    private String senha;

    @Column(columnDefinition = "VARCHAR(11)")
    private String telefone;

    @Email
    @Column(columnDefinition = "VARCHAR(100)")
    private String email;

    @NotNull
    @NotEmpty
    @Column(columnDefinition = "CHAR(1)", nullable = false)
    private String perfil;

    @NotNull
    @NotEmpty
    @Column(columnDefinition = "CHAR(1)", nullable = false)
    private String status;

    public Usuario() {

    }


    public static Usuario converter(Usuario u) {
        Usuario user = new Usuario();
        user.setId(u.getId());
        user.setNome(u.getNome());
        user.setLogin(u.getLogin());
        user.setSenha(u.getSenha());
        user.setTelefone(u.getTelefone());
        user.setEmail(u.getEmail());
        user.setPerfil(u.getPerfil());
        user.setStatus(u.getStatus());
        return user;
    }

    public Usuario(LocalDateTime dataCadastro, String nome, String login, String senha, String telefone, String email, String perfil, String status) {
        this.dataCadastro = dataCadastro;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.telefone = telefone;
        this.email = email;
        this.perfil = perfil;
        this.status = status;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


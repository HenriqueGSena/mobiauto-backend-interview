package com.mobiauto.backend_interview.dto;

import com.mobiauto.backend_interview.entities.Revenda;
import com.mobiauto.backend_interview.entities.Usuario;
import com.mobiauto.backend_interview.entities.enums.Cargos;

public class UsuarioDTO {

    private String id;
    private String nome;
    private String email;
    private String senha;
    private Cargos cargos;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String id, String nome, String email, String senha, Cargos cargos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cargos = cargos;
    }

    public UsuarioDTO(Usuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.cargos = usuario.getCargos();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cargos getCargos() {
        return cargos;
    }

    public void setCargos(Cargos cargos) {
        this.cargos = cargos;
    }
}

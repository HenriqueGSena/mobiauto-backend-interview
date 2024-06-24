package com.mobiauto.backend_interview.dto;

import com.mobiauto.backend_interview.entities.Oportunidade;

import java.util.ArrayList;
import java.util.List;


public class RevendaDTO {

    private Long id;
    private String nomeSocial;
    private String cnpj;
    private List<Oportunidade> oportunidades = new ArrayList<Oportunidade>();
    private List<UsuarioDTO> usuarios = new ArrayList<>();

    public RevendaDTO() {
    }

    public RevendaDTO(Long id, String nomeSocial, String cnpj, List<Oportunidade> oportunidades, List<UsuarioDTO> usuarios) {
        this.id = id;
        this.nomeSocial = nomeSocial;
        this.cnpj = cnpj;
        this.oportunidades = oportunidades;
        this.usuarios = usuarios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Oportunidade> getOportunidades() {
        return oportunidades;
    }

    public void setOportunidades(List<Oportunidade> oportunidades) {
        this.oportunidades = oportunidades;
    }

    public List<UsuarioDTO> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioDTO> usuarios) {
        this.usuarios = usuarios;
    }
}

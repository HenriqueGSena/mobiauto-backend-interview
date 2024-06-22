package com.mobiauto.backend_interview.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "revenda")
public class Revenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "nome_social")
    private String nomeSocial;

    @NotBlank
    @Column(name = "cnpj")
    private String cnpj;

    @OneToMany(mappedBy = "revenda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Oportunidade> oportunidades = new ArrayList<>();

    public Revenda() {
    }

    public Revenda(Long id, String nomeSocial, String cnpj, List<Oportunidade> oportunidades) {
        this.id = id;
        this.nomeSocial = nomeSocial;
        this.cnpj = cnpj;
        this.oportunidades = oportunidades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(@NotBlank String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public @NotBlank String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotBlank String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Oportunidade> getOportunidades() {
        return oportunidades;
    }

    public void setOportunidades(List<Oportunidade> oportunidades) {
        this.oportunidades = oportunidades;
    }
}

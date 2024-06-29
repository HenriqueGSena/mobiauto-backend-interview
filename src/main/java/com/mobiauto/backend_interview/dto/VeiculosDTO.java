package com.mobiauto.backend_interview.dto;

public class VeiculosDTO {

    private Long id;
    private String marca;
    private String modelo;
    private String versao;
    private String anoModelo;

    public VeiculosDTO() {
    }

    public VeiculosDTO(Long id, String marca, String modelo, String versao, String anoModelo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.versao = versao;
        this.anoModelo = anoModelo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(String anoModelo) {
        this.anoModelo = anoModelo;
    }
}

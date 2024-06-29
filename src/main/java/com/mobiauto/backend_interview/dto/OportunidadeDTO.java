package com.mobiauto.backend_interview.dto;

import com.mobiauto.backend_interview.entities.enums.Status;

import java.time.LocalDateTime;

public class OportunidadeDTO {

    private Long id;
    private Status status;
    private String description;
    private LocalDateTime dataAtribuicao;
    private LocalDateTime dataCriacao;

    public OportunidadeDTO() {
    }

    public OportunidadeDTO(Long id, Status status, String description, LocalDateTime dataAtribuicao, LocalDateTime dataCriacao) {
        this.id = id;
        this.status = status;
        this.description = description;
        this.dataAtribuicao = dataAtribuicao;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDataAtribuicao() {
        return dataAtribuicao;
    }

    public void setDataAtribuicao(LocalDateTime dataAtribuicao) {
        this.dataAtribuicao = dataAtribuicao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}

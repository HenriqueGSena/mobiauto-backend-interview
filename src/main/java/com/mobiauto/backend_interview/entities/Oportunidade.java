package com.mobiauto.backend_interview.entities;

import com.mobiauto.backend_interview.entities.enums.Status;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "oportunidade")
public class Oportunidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "description")
    private String description;

    @Column(name = "atribuicao")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataAtribuicao;

    @Column(name = "criacao")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "veiculos_id")
    private Veiculos veiculos;

    @ManyToOne
    @JoinColumn(name = "revenda_id")
    private Revenda revenda;

    public Oportunidade() {
    }

    public Oportunidade(Long id, Status status, String description, LocalDateTime dataAtribuicao, LocalDateTime dataCriacao, Cliente cliente, Veiculos veiculos, Revenda revenda) {
        this.id = id;
        this.status = status;
        this.description = description;
        this.dataAtribuicao = dataAtribuicao;
        this.dataCriacao = dataCriacao;
        this.cliente = cliente;
        this.veiculos = veiculos;
        this.revenda = revenda;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculos getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Veiculos veiculos) {
        this.veiculos = veiculos;
    }

    public Revenda getRevenda() {
        return revenda;
    }

    public void setRevenda(Revenda revenda) {
        this.revenda = revenda;
    }
}

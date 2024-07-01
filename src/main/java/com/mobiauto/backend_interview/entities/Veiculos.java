package com.mobiauto.backend_interview.entities;

import com.mobiauto.backend_interview.dto.VeiculosDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "veiculos")
@Table(name = "veiculos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Veiculos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "versao")
    private String versao;

    @Column(name = "anoModelo")
    private String anoModelo;

    @ManyToOne
    private AtendimentoNegociacao atendimentoNegociacao;

    public Veiculos(VeiculosDTO body) {
        this.marca = body.getMarca();
        this.modelo = body.getModelo();
        this.versao = body.getVersao();
        this.anoModelo = body.getAnoModelo();
    }
}

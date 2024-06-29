package com.mobiauto.backend_interview.entities;

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

    @Column(name = "ano_modelo")
    private String anoModelo;

    @ManyToOne
    @JoinColumn(name = "veiculos", nullable = false)
    private AtendimentoNegociacao atendimentoNegociacao;

}

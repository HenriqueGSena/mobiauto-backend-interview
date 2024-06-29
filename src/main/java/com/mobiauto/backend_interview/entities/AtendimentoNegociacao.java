package com.mobiauto.backend_interview.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity(name = "atendimento_negociacao")
@Table(name = "atendimento_negociacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AtendimentoNegociacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "oportunidade_id", nullable = false)
    private Oportunidade oportunidades;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "veiculos_id", nullable = false)
    private Veiculos veiculos;

    @ManyToOne
    @JoinColumn(name = "revenda_id", nullable = false)
    private Revenda revenda;
}

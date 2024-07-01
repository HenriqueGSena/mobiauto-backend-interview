package com.mobiauto.backend_interview.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @ManyToOne
    @JoinColumn(name = "oportunidade_id", nullable = false)
    private Oportunidade oportunidades;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "veiculos_id", nullable = false)
    private Veiculos veiculos;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "revenda_id", nullable = false)
    private Revenda revenda;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}

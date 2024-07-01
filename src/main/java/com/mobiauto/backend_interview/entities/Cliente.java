package com.mobiauto.backend_interview.entities;

import com.mobiauto.backend_interview.dto.ClienteDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity(name = "cliente")
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @OneToMany(mappedBy = "cliente")
    private Set<AtendimentoNegociacao> atendimentoNegociacaos;

    public Cliente(ClienteDTO body) {
        this.nome = body.getNome();
        this.email = body.getEmail();
        this.telefone = body.getTelefone();
    }
}

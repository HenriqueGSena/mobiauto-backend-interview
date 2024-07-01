package com.mobiauto.backend_interview.entities;

import com.mobiauto.backend_interview.dto.OportunidadeDTO;
import com.mobiauto.backend_interview.entities.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity(name = "oportunidade")
@Table(name = "oportunidade")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Oportunidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "description")
    private String description;

    @Column(name = "data_atribuicao")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataAtribuicao;

    @Column(name = "data_criacao")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataCriacao;

    @OneToMany(mappedBy = "oportunidades")
    private List<AtendimentoNegociacao> atendimentoNegociacaos;

    public Oportunidade(OportunidadeDTO body) {
        this.status = body.getStatus();
        this.description = body.getDescription();
        this.dataAtribuicao = body.getDataAtribuicao();
        this.dataCriacao = body.getDataCriacao();
    }
}

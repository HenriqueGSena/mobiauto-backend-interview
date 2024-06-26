package com.mobiauto.backend_interview.entities;

import com.mobiauto.backend_interview.dto.RevendaRequestDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "revenda")
@Table(name = "revenda")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
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

    @ManyToMany(mappedBy = "revendas")
    private Set<Usuario> usuarios = new HashSet<>();

    public Revenda(RevendaRequestDTO body) {
        this.nomeSocial = body.nomeSocial();
        this.cnpj = body.cnpj();
    }
}

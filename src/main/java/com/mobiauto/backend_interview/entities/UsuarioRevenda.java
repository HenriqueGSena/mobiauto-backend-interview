package com.mobiauto.backend_interview.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios_revenda")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsuarioRevenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "revenda_id", nullable = false)
    private Revenda revenda;
}

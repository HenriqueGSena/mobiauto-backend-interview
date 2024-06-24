package com.mobiauto.backend_interview.entities;

import com.mobiauto.backend_interview.entities.enums.Cargos;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table
@Entity(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "cargos")
    private Cargos cargos;

    @ManyToOne
    @JoinColumn(name = "revenda_id")
    private Revenda revenda;

    public Usuario(String nome, String email, String senha, Cargos cargos) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cargos = cargos;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.cargos == Cargos.ADMIN) {
            return  List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_PROPRIETARIO"),
                    new SimpleGrantedAuthority("ROLE_GERENTE"),
                    new SimpleGrantedAuthority("ROLE_ASSISTENTE")
            );
        }

        if (this.cargos == Cargos.PROPRIETARIO) {
            return List.of(new SimpleGrantedAuthority("ROLE_PROPRIETARIO"));
        }

        if (this.cargos == Cargos.GERENTE) {
            return List.of(new SimpleGrantedAuthority("ROLE_GERENTE"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_ASSISTENTE"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return nome;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

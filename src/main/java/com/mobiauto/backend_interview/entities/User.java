package com.mobiauto.backend_interview.entities;

import com.mobiauto.backend_interview.entities.enums.Role;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany
    @JoinTable(
        name = "revenda_veiculo_usuario",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "relase_id"))
    private Set<Resale> resales = new HashSet<>();

    public User() {
    }

    public User(Long id, String name, String mail, String password, Role role, Set<Resale> resales) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.role = role;
        this.resales = resales;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Resale> getResales() {
        return resales;
    }

    public void setResales(Set<Resale> resales) {
        this.resales = resales;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        return getId().equals(user.getId()) && getName().equals(user.getName()) && getMail().equals(user.getMail()) && getPassword().equals(user.getPassword()) && getRole() == user.getRole() && getResales().equals(user.getResales());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getMail().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getRole().hashCode();
        result = 31 * result + getResales().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", mail='" + mail + '\'' +
            ", password='" + password + '\'' +
            ", role=" + role +
            ", resales=" + resales +
            '}';
    }
}

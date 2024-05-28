package com.mobiauto.backend_interview.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "resale")
public class Resale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "social_name")
    private String socialName;

    @Column(name = "cnpj")
    private String cnpj;

    public Resale() {
    }

    public Resale(Long id, String socialName, String cnpj) {
        this.id = id;
        this.socialName = socialName;
        this.cnpj = cnpj;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSocialName() {
        return socialName;
    }

    public void setSocialName(String socialName) {
        this.socialName = socialName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resale resale)) return false;

        return getId().equals(resale.getId()) && getSocialName().equals(resale.getSocialName()) && getCnpj().equals(resale.getCnpj());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getSocialName().hashCode();
        result = 31 * result + getCnpj().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "resale{" +
                "id=" + id +
                ", socialName='" + socialName + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }
}

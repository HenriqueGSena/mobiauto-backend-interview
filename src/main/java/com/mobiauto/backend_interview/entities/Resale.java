package com.mobiauto.backend_interview.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "resale")
public class Resale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "social_name")
    private String socialName;

    @NotBlank
    @Column(name = "cnpj")
    private String cnpj;

    @OneToMany(mappedBy = "resale", cascade = CascadeType.ALL)
    private List<Opportunity> opportunities;

    public Resale() {
    }

    public Resale(Long id, String socialName, String cnpj, List<Opportunity> opportunities) {
        this.id = id;
        this.socialName = socialName;
        this.cnpj = cnpj;
        this.opportunities = opportunities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getSocialName() {
        return socialName;
    }

    public void setSocialName(@NotBlank String socialName) {
        this.socialName = socialName;
    }

    public @NotBlank String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotBlank String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Opportunity> getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(List<Opportunity> opportunities) {
        this.opportunities = opportunities;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resale resale)) return false;

        return getId().equals(resale.getId()) && getSocialName().equals(resale.getSocialName()) && getCnpj().equals(resale.getCnpj()) && getOpportunities().equals(resale.getOpportunities());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getSocialName().hashCode();
        result = 31 * result + getCnpj().hashCode();
        result = 31 * result + getOpportunities().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Resale{" +
            "id=" + id +
            ", socialName='" + socialName + '\'' +
            ", cnpj='" + cnpj + '\'' +
            ", opportunities=" + opportunities +
            '}';
    }
}

package com.mobiauto.backend_interview.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "version")
    private String version;

    @Column(name = "model_year")
    private String modelYear;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Opportunity> opportunities;

    public Vehicle() {
    }

    public Vehicle(Long id, String brand, String model, String version, String modelYear, List<Opportunity> opportunities) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.version = version;
        this.modelYear = modelYear;
        this.opportunities = opportunities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
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
        if (!(o instanceof Vehicle vehicle)) return false;

        return getId().equals(vehicle.getId()) && getBrand().equals(vehicle.getBrand()) && getModel().equals(vehicle.getModel()) && getVersion().equals(vehicle.getVersion()) && getModelYear().equals(vehicle.getModelYear()) && getOpportunities().equals(vehicle.getOpportunities());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getBrand().hashCode();
        result = 31 * result + getModel().hashCode();
        result = 31 * result + getVersion().hashCode();
        result = 31 * result + getModelYear().hashCode();
        result = 31 * result + getOpportunities().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", version='" + version + '\'' +
                ", modelYear='" + modelYear + '\'' +
                ", opportunities=" + opportunities +
                '}';
    }
}

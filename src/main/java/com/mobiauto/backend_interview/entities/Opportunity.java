package com.mobiauto.backend_interview.entities;

import com.mobiauto.backend_interview.entities.enums.Status;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "opportunity")
public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "resale_id", nullable = false)
    private Resale resale;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dateAssignment;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dateCreate;

    public Opportunity() {
    }

    public Opportunity(Long id, Status status, String description, Client client, User user, Vehicle vehicle, Resale resale, LocalDateTime dateAssignment, LocalDateTime dateCreate) {
        this.id = id;
        this.status = status;
        this.description = description;
        this.client = client;
        this.user = user;
        this.vehicle = vehicle;
        this.resale = resale;
        this.dateAssignment = dateAssignment;
        this.dateCreate = dateCreate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Resale getResale() {
        return resale;
    }

    public void setResale(Resale resale) {
        this.resale = resale;
    }

    public LocalDateTime getDateAssignment() {
        return dateAssignment;
    }

    public void setDateAssignment(LocalDateTime dateAssignment) {
        this.dateAssignment = dateAssignment;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Opportunity that)) return false;

        return getId().equals(that.getId()) && getStatus() == that.getStatus() && getDescription().equals(that.getDescription()) && getClient().equals(that.getClient()) && getUser().equals(that.getUser()) && getVehicle().equals(that.getVehicle()) && getResale().equals(that.getResale()) && getDateAssignment().equals(that.getDateAssignment()) && getDateCreate().equals(that.getDateCreate());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getStatus().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getClient().hashCode();
        result = 31 * result + getUser().hashCode();
        result = 31 * result + getVehicle().hashCode();
        result = 31 * result + getResale().hashCode();
        result = 31 * result + getDateAssignment().hashCode();
        result = 31 * result + getDateCreate().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Opportunity{" +
            "id=" + id +
            ", status=" + status +
            ", description='" + description + '\'' +
            ", client=" + client +
            ", user=" + user +
            ", vehicle=" + vehicle +
            ", resale=" + resale +
            ", dateAssignment=" + dateAssignment +
            ", dateCreate=" + dateCreate +
            '}';
    }
}

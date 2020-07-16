package com.reesemedia.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Kit {

    @Id
    @Column(name = "kit_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUsers user;

    @Column
    private LocalDate dateCreated;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "kit_toys",
            joinColumns = {@JoinColumn(name = "kit_id")},
            inverseJoinColumns = {@JoinColumn(name = "toy_id")}
    )
    private List<Toy> toys;

    //adds new toy to the list of toys for a kit
    public void addToysToKit(Toy newToy){
        if (toys == null) toys = new ArrayList<Toy>();
        this.toys.add(newToy);
    }

    public Kit() {
    }

    public Kit(int id, AppUsers user, LocalDate dateCreated, List<Toy> toys) {
        this.id = id;
        this.user = user;
        this.dateCreated = dateCreated;
        this.toys = toys;
    }

    public Kit(AppUsers user) {
        this.user = user;
        this.dateCreated = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AppUsers getUser() {
        return user;
    }

    public void setUser(AppUsers user) {
        this.user = user;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<Toy> getToys() {
        return toys;
    }

    public void setToys(List<Toy> toys) {
        this.toys = toys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kit)) return false;
        Kit kit = (Kit) o;
        return getId() == kit.getId() &&
                Objects.equals(getUser(), kit.getUser()) &&
                Objects.equals(getDateCreated(), kit.getDateCreated()) &&
                Objects.equals(getToys(), kit.getToys());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getDateCreated(), getToys());
    }

    @Override
    public String toString() {
        return "Kit{" +
                "id=" + id +
                ", user=" + user +
                ", dateCreated=" + dateCreated +
                ", toys=" + toys +
                '}';
    }
}

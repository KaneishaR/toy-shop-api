package com.reesemedia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "toys")
public class Toy {

    @Column(name = "toy_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String vibration;

    @Column(nullable = false)
    private String material;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String imageUrl;

    @ManyToMany(mappedBy = "toys")
    @JsonIgnore
    private List<Kit> kits;

    public Toy() {
    }

    public Toy(int id, String name, String description, String type, String vibration, String material, String color, String imageUrl, List<Kit> kits) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.vibration = vibration;
        this.material = material;
        this.color = color;
        this.imageUrl = imageUrl;
        this.kits = kits;
    }

    public Toy(String name, String description, String type, String vibration, String material, String color, String imageUrl) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.vibration = vibration;
        this.material = material;
        this.color = color;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVibration() {
        return vibration;
    }

    public void setVibration(String vibration) {
        this.vibration = vibration;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Kit> getKits() {
        return kits;
    }

    public void setKits(List<Kit> kits) {
        this.kits = kits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Toy)) return false;
        Toy toy = (Toy) o;
        return getId() == toy.getId() &&
                Objects.equals(getName(), toy.getName()) &&
                Objects.equals(getDescription(), toy.getDescription()) &&
                Objects.equals(getType(), toy.getType()) &&
                Objects.equals(getVibration(), toy.getVibration()) &&
                Objects.equals(getMaterial(), toy.getMaterial()) &&
                Objects.equals(getColor(), toy.getColor()) &&
                Objects.equals(getImageUrl(), toy.getImageUrl()) &&
                Objects.equals(getKits(), toy.getKits());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getType(), getVibration(), getMaterial(), getColor(), getImageUrl(), getKits());
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", vibration='" + vibration + '\'' +
                ", material='" + material + '\'' +
                ", color='" + color + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", kits=" + kits +
                '}';
    }
}

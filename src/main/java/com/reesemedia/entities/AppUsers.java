package com.reesemedia.entities;

import javax.persistence.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class AppUsers {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private LocalDate dob;
    @Column
    private int age;

    @Column
    private UserRole role;

    @Column
    private boolean active;

    @OneToMany(mappedBy = "user")
    private Set<Kit> kits;

    public AppUsers() {
    }

    public AppUsers(int id, String username, String password, String firstName, String lastname, String dob) throws ParseException {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastname = lastname;
        this.dob =  LocalDate.parse(dob);
        this.age = Period.between(this.dob, LocalDate.now()).getYears();
        this.role = UserRole.USER;
        this.active = true;

    }

    public AppUsers( String username, String password, String firstName, String lastname, String dob) throws ParseException {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastname = lastname;
        this.dob =  LocalDate.parse(dob);
        this.age = Period.between(this.dob, LocalDate.now()).getYears();
        this.role = UserRole.USER;
        this.active = true;

    }

    public AppUsers(int id, String username, String password, String firstName, String lastname, String dob, UserRole role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastname = lastname;
        this.dob =  LocalDate.parse(dob);
        this.age = Period.between(this.dob, LocalDate.now()).getYears();
        this.role = role;
        this.active = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppUsers)) return false;
        AppUsers appUsers = (AppUsers) o;
        return getId() == appUsers.getId() &&
                getAge() == appUsers.getAge() &&
                isActive() == appUsers.isActive() &&
                getUsername().equals(appUsers.getUsername()) &&
                getPassword().equals(appUsers.getPassword()) &&
                getFirstName().equals(appUsers.getFirstName()) &&
                getLastname().equals(appUsers.getLastname()) &&
                getDob().equals(appUsers.getDob()) &&
                getRole() == appUsers.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword(), getFirstName(), getLastname(), getDob(), getAge(), getRole(), isActive());
    }

    @Override
    public String toString() {
        return "AppUsers{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                ", role=" + role +
                ", active=" + active +
                '}';
    }
}

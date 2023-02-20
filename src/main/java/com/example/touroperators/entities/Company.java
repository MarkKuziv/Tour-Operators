package com.example.touroperators.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String companyName;
    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<UserEntities> users;

    public Company(String companyName, List<UserEntities> users) {
        this.companyName = companyName;
        this.users = users;
    }

    public Company() {

    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<UserEntities> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntities> users) {
        this.users = users;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", users=" + users +
                '}';
    }
}

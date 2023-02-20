package com.example.touroperators.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Tour {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String tourType;

    public Tour(String name, String tourType) {
        this.name = name;
        this.tourType = tourType;
    }

    public Tour() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTourType() {
        return tourType;
    }

    public void setTourType(String tourType) {
        this.tourType = tourType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tourType='" + tourType + '\'' +
                '}';
    }
}

package com.example.touroperators.entities;

import jakarta.persistence.*;

@Entity
public class UserEntities {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String userName;
    @Column
    private String lastName;
    @Column
    private String birthDay;
    @Column
    private long identificationCode;
    @Column
    private String role;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_id")
    private Tour tour;

    public UserEntities(String userName, String lastName, String birthDay, long identificationCode, String role, Company company, Tour tour) {
        this.userName = userName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.identificationCode = identificationCode;
        this.role = role;
        this.company = company;
        this.tour = tour;
    }

    public UserEntities() {

    }

    public long getIdentificationCode() {
        return identificationCode;
    }

    public void setIdentificationCode(long identificationCode) {
        this.identificationCode = identificationCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", identificationCode=" + identificationCode +
                ", role='" + role + '\'' +
                ", company=" + company +
                ", tour=" + tour +
                '}';
    }
}

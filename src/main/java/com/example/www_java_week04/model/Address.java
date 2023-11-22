package com.example.www_java_week04.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "address")
public class Address{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "add_id",columnDefinition = "BIGINT(20)")
    private long id;
    @Column(name = "zipcode", columnDefinition = "VARCHAR(7)")
    private String zipCode;
    @Column(columnDefinition = "VARCHAR(20)")
    private String number;
    @Column(columnDefinition = "VARCHAR(50)")
    private String city;
    @Column(columnDefinition = "VARCHAR(150)")
    private String street;
    @Column(name="country",columnDefinition = "VARCHAR(50)")
    private String country;
    @OneToOne(mappedBy = "address",fetch = FetchType.EAGER)
    private Candidate candidate;
    @OneToOne(mappedBy = "address",fetch = FetchType.LAZY)
    private Company company;

    public Address(long id) {
        this.id = id;
    }

    public Address(long id, String zipCode, String number, String city, String street, String country, Candidate candidate, Company company) {
        this.id = id;
        this.zipCode = zipCode;
        this.number = number;
        this.city = city;
        this.street = street;
        this.country = country;
        this.candidate = candidate;
        this.company = company;
    }
    public Address(String zipCode, String number, String city, String street, String countryCode) {
        this.zipCode = zipCode;
        this.number = number;
        this.city = city;
        this.street = street;
        this.country = country;
    }

    public Address() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String countryCode) {
        this.country = countryCode;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", zipCode='" + zipCode + '\'' +
                ", number='" + number + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", country='" + country + '\'' +
                ", candidate=" + candidate +
                ", company=" + company +
                '}';
    }
}

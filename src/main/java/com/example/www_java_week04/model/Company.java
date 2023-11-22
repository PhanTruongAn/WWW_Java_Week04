package com.example.www_java_week04.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="com_id",columnDefinition = "BIGINT(20)")
    private long id;
    @Column(columnDefinition = "VARCHAR(2000)")
    private String about;
    @Column(name="comp_name",columnDefinition = "VARCHAR(255)")
    private String compName;
    @Column(columnDefinition = "VARCHAR(255)")
    private String email;
    @Column(columnDefinition = "VARCHAR(255)")
    private String phone;
    @Column(name = "web_url",columnDefinition = "VARCHAR(255)")
    private String url;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="address",referencedColumnName = "add_id")
    private Address address;
    @OneToMany(mappedBy = "company",fetch = FetchType.EAGER)
    private List<Job> job;

    public Company(long id, String about, String compName, String email, String phone, String url, Address address, List<Job> job) {
        this.id = id;
        this.about = about;
        this.compName = compName;
        this.email = email;
        this.phone = phone;
        this.url = url;
        this.address = address;
        this.job = job;
    }

    public Company(long id) {
        this.id = id;
    }

    public Company() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Job> getJob() {
        return job;
    }

    public void setJob(List<Job> job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", about='" + about + '\'' +
                ", compName='" + compName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", url='" + url + '\'' +
                ", address=" + address +
                ", job=" + job +
                '}';
    }
}

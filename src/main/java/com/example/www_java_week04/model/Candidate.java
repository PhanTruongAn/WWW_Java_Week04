package com.example.www_java_week04.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "candidate")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id", columnDefinition = "BIGINT(20)")
    private long id;
    @Column(name="dob",columnDefinition = "DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    @Column(columnDefinition = "VARCHAR(15)",unique = true)
    private String phone;
    @Column(columnDefinition = "VARCHAR(255)", unique = true)
    private String email;
    @Column(columnDefinition = "VARCHAR(255)")
    private String fullName;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="address")
    private Address address;
    @OneToMany(mappedBy = "candidate",fetch = FetchType.EAGER)
    private List<Experience> experiences;
    @OneToMany(mappedBy = "candidate",fetch = FetchType.EAGER)
    private List<CandidateSkill> candidateSkills;



    public Candidate() {
    }

    public Candidate(long id) {
        this.id = id;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public List<CandidateSkill> getCandidateSkills() {
        return candidateSkills;
    }

    public void setCandidateSkills(List<CandidateSkill> candidateSkills) {
        this.candidateSkills = candidateSkills;
    }

    public Candidate(long id, LocalDate dob, String phone, String email, String fullName, Address address, List<Experience> experiences, List<CandidateSkill> candidateSkills) {
        this.id = id;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.fullName = fullName;
        this.address = address;
        this.experiences = experiences;
        this.candidateSkills = candidateSkills;
    }
    public Candidate(long id, LocalDate dob, String phone, String email, String fullName, Address address) {
        this.id = id;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.fullName = fullName;
        this.address = address;

    }
    public Candidate(LocalDate dob, String phone, String email, String fullName, Address address) {
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.fullName = fullName;
        this.address = address;
    }



    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", dob=" + dob +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address=" + address +
                '}';
    }
}

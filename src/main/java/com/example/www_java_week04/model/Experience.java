package com.example.www_java_week04.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id",columnDefinition = "BIGINT(20)")
    private long id;

    @Column(columnDefinition = "DATE")
    private LocalDate from_date;
    @Column(columnDefinition = "DATE")
    private LocalDate to_date;
    @Column(columnDefinition = "VARCHAR(100)")
    private String role;
    @Column(columnDefinition = "VARCHAR(120)")
    private String company;
    @Column(columnDefinition = "VARCHAR(400)")
    private String work_desc;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    public Experience(long id, LocalDate from_date, LocalDate to_date, String role, String company, String work_desc, Candidate candidate) {
        this.id = id;
        this.from_date = from_date;
        this.to_date = to_date;
        this.role = role;
        this.company = company;
        this.work_desc = work_desc;
        this.candidate = candidate;
    }

    public Experience() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getFrom_date() {
        return from_date;
    }

    public void setFrom_date(LocalDate from_date) {
        this.from_date = from_date;
    }

    public LocalDate getTo_date() {
        return to_date;
    }

    public void setTo_date(LocalDate to_date) {
        this.to_date = to_date;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWork_desc() {
        return work_desc;
    }

    public void setWork_desc(String work_desc) {
        this.work_desc = work_desc;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", from_date=" + from_date +
                ", to_date=" + to_date +
                ", role='" + role + '\'' +
                ", company='" + company + '\'' +
                ", work_desc='" + work_desc + '\'' +
                ", candidate=" + candidate +
                '}';
    }
}

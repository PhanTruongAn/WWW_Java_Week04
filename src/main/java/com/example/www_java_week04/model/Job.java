package com.example.www_java_week04.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="job_id",columnDefinition = "BIGINT(20)")
    private long id;
    @Column(name="job_desc",columnDefinition = "VARCHAR(2000)")
    private String jobDesc;
    @Column(name = "job_name",columnDefinition = "VARCHAR(255)")
    private String jobName;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "company")
    private Company company;
    @OneToMany(mappedBy = "job",fetch = FetchType.EAGER)
    private List<JobSkill> jobSkills;

    public Job(long id, String jobDesc, String jobName, Company company, List<JobSkill> jobSkills) {
        this.id = id;
        this.jobDesc = jobDesc;
        this.jobName = jobName;
        this.company = company;
        this.jobSkills = jobSkills;
    }

    public Job() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<JobSkill> getJobSkills() {
        return jobSkills;
    }

    public void setJobSkills(List<JobSkill> jobSkills) {
        this.jobSkills = jobSkills;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", jobDesc='" + jobDesc + '\'' +
                ", jobName='" + jobName + '\'' +
                ", company=" + company +
                ", jobSkills=" + jobSkills +
                '}';
    }
}

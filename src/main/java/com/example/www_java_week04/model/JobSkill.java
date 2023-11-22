package com.example.www_java_week04.model;

import com.example.www_java_week04.convert.SkillLevelConvert;
import com.example.www_java_week04.enums.SkillLevel;
import jakarta.persistence.*;

@Entity
@Table(name="job_skill")
public class JobSkill {

    @Column(name = "more_infos",columnDefinition = "VARCHAR(1000)")
    private String moreInfo;
    @Id
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="job_id")
    private Job job;
    @Id
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="skill_id")
    private Skill skill;
    @Column(name = "skill_level",columnDefinition = "TINYINT(4)")
    @Convert(converter = SkillLevelConvert.class)
    private SkillLevel skillLevel;

    public JobSkill(String moreInfo, Job job, Skill skill, SkillLevel skillLevel) {
        this.moreInfo = moreInfo;
        this.job = job;
        this.skill = skill;
        this.skillLevel = skillLevel;
    }

    public JobSkill() {
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(SkillLevel skillLevel) {
        this.skillLevel = skillLevel;
    }

    @Override
    public String toString() {
        return "JobSkill{" +
                "moreInfo='" + moreInfo + '\'' +
                ", job=" + job +
                ", skill=" + skill +
                ", skillLevel=" + skillLevel +
                '}';
    }
}

package com.example.www_java_week04.model;

import com.example.www_java_week04.convert.SkillLevelConvert;
import com.example.www_java_week04.enums.SkillLevel;
import jakarta.persistence.*;

@Entity
@Table(name = "candidate_skill")
public class CandidateSkill {
    @Column(name="skill_level",columnDefinition = "TINYINT(4)")
    @Convert(converter = SkillLevelConvert.class)
    private SkillLevel skillLevel;
    @Column(name="more_infos",columnDefinition = "VARCHAR(1000)")
    private String moreInfo;
    @Id
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="can_id")
    private Candidate candidate;
    @Id
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="skill_id")
    private Skill skill;

    public CandidateSkill(SkillLevel skillLevel, String moreInfo, Candidate candidate, Skill skill) {
        this.skillLevel = skillLevel;
        this.moreInfo = moreInfo;
        this.candidate = candidate;
        this.skill = skill;
    }

    public CandidateSkill() {
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(SkillLevel skillLevel) {
        this.skillLevel = skillLevel;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "CandidateSkill{" +
                "skillLevel=" + skillLevel +
                ", moreInfo='" + moreInfo + '\'' +
                ", candidate=" + candidate +
                ", skill=" + skill +
                '}';
    }
}

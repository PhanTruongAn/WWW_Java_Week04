package com.example.www_java_week04.model;

import com.example.www_java_week04.convert.SkillTypeConvert;
import com.example.www_java_week04.enums.SkillType;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="skill_id",columnDefinition = "BIGINT(20)")
    private long id;
    @Column(name = "skill_name",columnDefinition = "VARCHAR(150)")
    private String skillName;
    @Column(name = "skill_desc",columnDefinition = "VARCHAR(150)")
    private String skillDescription;

    @Column(name = "skill_type",columnDefinition = "TINYINT(4)")
    @Convert(converter = SkillTypeConvert.class)
    private SkillType type;
    @OneToMany(mappedBy = "skill",fetch = FetchType.EAGER)
    private List<JobSkill> jobSkills;


    public Skill(String skillName, String skillDescription, SkillType type, List<JobSkill> jobSkills) {
        this.skillName = skillName;
        this.skillDescription = skillDescription;
        this.type = type;
        this.jobSkills = jobSkills;
    }
    public Skill(String skillName, String skillDescription, SkillType type) {
        this.skillName = skillName;
        this.skillDescription = skillDescription;
        this.type = type;
    }
    public Skill() {
    }

    public Skill(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public SkillType getType() {
        return type;
    }

    public void setType(SkillType type) {
        this.type = type;
    }

    public List<JobSkill> getJobSkills() {
        return jobSkills;
    }

    public void setJobSkills(List<JobSkill> jobSkills) {
        this.jobSkills = jobSkills;
    }



    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", skillName='" + skillName + '\'' +
                ", skillDescription='" + skillDescription + '\'' +
                ", type=" + type +
                ", jobSkills=" + jobSkills +
                '}';
    }
}

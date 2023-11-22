package com.example.www_java_week04.mapper;

import com.example.www_java_week04.model.Candidate;
import com.example.www_java_week04.model.CandidateSkill;
import com.example.www_java_week04.model.Skill;
import com.example.www_java_week04.enums.SkillLevel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CandidateSkillMapper implements RowMapper<CandidateSkill> {

    @Override
    public CandidateSkill mapRow(ResultSet resultSet, int rowNum) throws SQLException {
       CandidateSkill candidateSkill = new CandidateSkill();
        candidateSkill.setMoreInfo(resultSet.getString("more_info"));
        candidateSkill.setCandidate(new Candidate(resultSet.getLong("can_id")));
        candidateSkill.setSkill(new Skill(resultSet.getLong("skill_id")));
        return candidateSkill ;
    }
}

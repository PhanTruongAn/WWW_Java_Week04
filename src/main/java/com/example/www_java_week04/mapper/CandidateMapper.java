package com.example.www_java_week04.mapper;

import com.example.www_java_week04.model.Address;
import com.example.www_java_week04.model.Candidate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class CandidateMapper implements RowMapper<Candidate> {

    @Override
    public Candidate mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Candidate candidate = new Candidate();
        candidate.setId(resultSet.getLong("can_id"));
        candidate.setDob(resultSet.getObject("dob", LocalDate.class));
        candidate.setEmail(resultSet.getString("email"));
        candidate.setPhone(resultSet.getString("phone"));
        candidate.setFullName(resultSet.getString("full_name"));
        Address address = new AddressMapper().mapRow(resultSet, rowNum);
        candidate.setAddress(address);
        return candidate;
    }
}

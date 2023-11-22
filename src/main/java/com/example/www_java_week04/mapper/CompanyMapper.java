package com.example.www_java_week04.mapper;

import com.example.www_java_week04.model.Address;
import com.example.www_java_week04.model.Company;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyMapper implements RowMapper<Company> {
    @Override
    public Company mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Company company = new Company();
        company.setId(resultSet.getLong("com_id"));
        company.setAbout(resultSet.getString("about"));
        company.setEmail(resultSet.getString("email"));
        company.setPhone(resultSet.getString("phone"));
        company.setUrl(resultSet.getString("web_url"));
        company.setCompName(resultSet.getString("comp_name"));
        company.setAddress(new Address(resultSet.getLong("add_id")));
        return company;
    }
}

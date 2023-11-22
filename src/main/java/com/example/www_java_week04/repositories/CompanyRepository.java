package com.example.www_java_week04.repositories;

import com.example.www_java_week04.mapper.CompanyMapper;
import com.example.www_java_week04.model.Company;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class CompanyRepository {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public CompanyRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public boolean create(Company company){
        String sql = "INSERT INTO company (com_id, name, about, address, email, phone, web_url) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, company.getId(), company.getCompName(), company.getAbout(), company.getAddress().getId(), company.getEmail(), company.getPhone(), company.getUrl()) > 0;
    }

    public boolean update(Company company){
        String sql = "UPDATE company SET com_id = ?, name = ?, about = ?, address = ?, email = ?, phone = ?, web_url = ?";
        return jdbcTemplate.update(sql, company.getId(), company.getCompName(), company.getAbout(), company.getAddress().getId(), company.getEmail(), company.getPhone(), company.getUrl()) > 0;
    }

    public boolean delete(long id){
        String sql = "DELETE FROM company WHERE com_id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    public Optional<Company> findById(long id){
        String sql = "SELECT * FROM company WHERE com_id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new CompanyMapper(), id));
    }

    public List<Company> findAll(){
        String sql = "SELECT * FROM company";
        return jdbcTemplate.query(sql, new CompanyMapper());
    }
}

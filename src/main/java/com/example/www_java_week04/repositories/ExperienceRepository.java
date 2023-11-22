package com.example.www_java_week04.repositories;

import com.example.www_java_week04.model.Experience;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class ExperienceRepository {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public ExperienceRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public boolean create(Experience experience){
        String sql = "INSERT INTO experience (exp_id, toDate, can_id, from_date, company, role, work_desc) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, experience.getId(), experience.getTo_date(), experience.getCandidate().getId(), experience.getFrom_date(), experience.getCompany(), experience.getRole(), experience.getWork_desc()) > 0;
    }

    public boolean update(Experience experience){
        String sql = "UPDATE experience SET exp_id = ?, toDate = ?, can_id = ?, fromDate = ?, company = ?, role = ?, work_desc = ?";
        return jdbcTemplate.update(sql, experience.getId(), experience.getTo_date(), experience.getCandidate().getId(), experience.getFrom_date(), experience.getCompany(), experience.getRole(), experience.getWork_desc()) > 0;
    }

    public boolean delete(long id){
        String sql = "DELETE FROM experience WHERE exp_id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    public Optional<Experience> findById(long id){
        String sql = "SELECT * FROM experience WHERE exp_id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, Experience.class, id));
    }

    public List<Experience> findAll(){
        String sql = "SELECT * FROM experience";
        return jdbcTemplate.queryForList(sql, Experience.class);
    }
}

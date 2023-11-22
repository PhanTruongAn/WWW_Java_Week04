package com.example.www_java_week04.repositories;

import com.example.www_java_week04.mapper.JobMapper;
import com.example.www_java_week04.model.Job;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class JobRepository {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public JobRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public boolean create(Job job){
        String sql = "INSERT INTO job (job_id, job_name, company, job_desc) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, job.getId(), job.getJobName(), job.getCompany().getId(), job.getJobDesc()) > 0;
    }

    public boolean update(Job job){
        String sql = "UPDATE job SET job_id = ?, job_name = ?, company = ?, job_desc = ?";
        return jdbcTemplate.update(sql, job.getId(), job.getJobName(), job.getCompany().getId(), job.getJobDesc()) > 0;
    }

    public boolean delete(long id){
        String sql = "DELETE FROM job WHERE job_id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    public Optional<Job> findById(long id){
        String sql = "SELECT * FROM job WHERE job_id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new JobMapper(), id));
    }

    public List<Job> findAll(){
        String sql = "SELECT * FROM job";
        return jdbcTemplate.query(sql, new JobMapper());
    }
}

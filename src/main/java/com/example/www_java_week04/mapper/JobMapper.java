package com.example.www_java_week04.mapper;


import com.example.www_java_week04.model.Address;
import com.example.www_java_week04.model.Company;
import com.example.www_java_week04.model.Job;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JobMapper implements RowMapper<Job> {
    @Override
    public Job mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Job job = new Job();
        job.setId(resultSet.getLong("job_id"));
        job.setJobName(resultSet.getString("job_name"));
        job.setJobDesc(resultSet.getString("job_desc"));
        job.setCompany(new Company(resultSet.getLong("com_id")));
        return job;
    }

}

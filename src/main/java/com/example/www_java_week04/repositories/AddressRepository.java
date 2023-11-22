package com.example.www_java_week04.repositories;


import com.example.www_java_week04.mapper.AddressMapper;
import com.example.www_java_week04.model.Address;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class AddressRepository {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;


    public AddressRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public boolean create(Address address){
        String sql = "INSERT INTO address (add_id, city, country, zipcode, street, number) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, address.getId(), address.getCity(), address.getCountry(), address.getZipCode(), address.getStreet(), address.getNumber()) > 0;
    }

    public boolean update(Address address){
        String sql = "UPDATE address SET add_id = ?, city = ?, country = ?, zipcode = ?, street = ?, number = ?";
        return jdbcTemplate.update(sql, address.getId(), address.getCity(), address.getCountry(), address.getZipCode(), address.getStreet(), address.getNumber()) > 0;
    }

    public boolean delete(long id){
        String sql = "DELETE FROM address WHERE add_id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    public Optional<Address> findById(long id){
        String sql = "SELECT * FROM address WHERE add_id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new AddressMapper(), id));
    }

    public List<Address> findAll(){
        String sql = "SELECT * FROM address";
        return jdbcTemplate.query(sql, new AddressMapper());
    }
}

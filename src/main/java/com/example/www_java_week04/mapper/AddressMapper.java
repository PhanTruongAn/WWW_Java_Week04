package com.example.www_java_week04.mapper;

import com.example.www_java_week04.model.Address;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressMapper implements RowMapper<Address> {
    @Override
    public Address mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Address address = new Address();
        address.setId(resultSet.getLong("add_id"));
        address.setCity(resultSet.getString("city"));
        address.setCountry(resultSet.getString("country"));
        address.setZipCode(resultSet.getString("zipcode"));
        address.setStreet(resultSet.getString("street"));
        address.setNumber(resultSet.getString("number"));
        return address;
    }
}

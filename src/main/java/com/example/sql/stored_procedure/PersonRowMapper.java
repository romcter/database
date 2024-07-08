package com.example.sql.stored_procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.example.sql.app.entity.Person;
import org.springframework.jdbc.core.RowMapper;

public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();
        person.setId(rs.getLong("id"));
        person.setName(rs.getString("name"));
        person.setCreated(rs.getObject("created", LocalDateTime.class));
        person.setDeleted(rs.getObject("deleted", LocalDateTime.class));
        person.setUpdated(rs.getObject("updated", LocalDateTime.class));
        return person;
    }
}

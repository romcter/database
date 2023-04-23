package com.example.sql.app.repository;

import com.example.sql.app.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
//    List<Person> ge;
}

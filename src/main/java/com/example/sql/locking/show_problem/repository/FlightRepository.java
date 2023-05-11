package com.example.sql.locking.show_problem.repository;

import com.example.sql.locking.show_problem.entity.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Long> { }

package com.example.sql.locking.app.repository;

import com.example.sql.locking.app.entity.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Long> { }

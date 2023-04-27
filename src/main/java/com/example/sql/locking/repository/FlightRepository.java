package com.example.sql.locking.repository;

import com.example.sql.locking.entity.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Long> { }

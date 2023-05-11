package com.example.sql.locking.optimistic.repository;

import com.example.sql.locking.optimistic.entity.Flight;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FlightRepository extends CrudRepository<Flight, Long> {

    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    Optional<Flight> findWithLockingById(Long id);

}

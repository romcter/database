package com.example.sql.app.repository;

import com.example.sql.app.entity.Building;
import com.example.sql.app.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuidingRepository extends JpaRepository<Building, Long> {
}

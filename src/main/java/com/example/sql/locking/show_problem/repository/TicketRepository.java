package com.example.sql.locking.show_problem.repository;


import com.example.sql.locking.show_problem.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> { }

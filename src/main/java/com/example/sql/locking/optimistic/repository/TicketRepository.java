package com.example.sql.locking.optimistic.repository;


import com.example.sql.locking.optimistic.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> { }

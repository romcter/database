package com.example.sql.locking.repository;

import com.example.sql.locking.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> { }

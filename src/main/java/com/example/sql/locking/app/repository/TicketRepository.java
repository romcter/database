package com.example.sql.locking.app.repository;

import com.example.sql.locking.app.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> { }

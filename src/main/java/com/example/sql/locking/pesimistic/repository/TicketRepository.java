package com.example.sql.locking.pesimistic.repository;


import com.example.sql.locking.pesimistic.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> { }

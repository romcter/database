package com.example.sql.locking.app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "flights")
@Data
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private LocalDateTime departureTime;

    private Integer capacity;

    @OneToMany(mappedBy = "flight")
    private Set<Ticket> tickets;

    public void addTicket(Ticket ticket) {
        ticket.setFlight(this);
        getTickets().add(ticket);
    }

}
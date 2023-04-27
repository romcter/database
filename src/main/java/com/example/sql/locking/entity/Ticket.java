package com.example.sql.locking.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id")
    private Flight flight;

    private String firstName;

    private String lastName;
}

package com.example.sql.locking.app.service;

import com.example.sql.locking.app.entity.Flight;
import com.example.sql.locking.app.entity.Ticket;
import com.example.sql.locking.app.repository.FlightRepository;
import com.example.sql.locking.app.repository.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DbService {

    private final FlightRepository flightRepository;

    private final TicketRepository ticketRepository;

    public DbService(FlightRepository flightRepository, TicketRepository ticketRepository) {
        this.flightRepository = flightRepository;
        this.ticketRepository = ticketRepository;
    }

    private void saveNewTicket(String firstName, String lastName, Flight flight) throws Exception {
        if (flight.getCapacity() <= flight.getTickets().size()) {
            throw new Exception();
        }
        var ticket = new Ticket();
        ticket.setFirstName(firstName);
        ticket.setLastName(lastName);
        flight.addTicket(ticket);
        ticketRepository.save(ticket);
    }

    @Transactional
    public void changeFlight1() throws Exception {
        var flight = flightRepository.findById(1L).get();
        saveNewTicket("Robert", "Smith", flight);
        Thread.sleep(1_000);
    }

    @Transactional
    public void changeFlight2() throws Exception {
        var flight = flightRepository.findById(1L).get();
        saveNewTicket("Kate", "Brown", flight);
        Thread.sleep(1_000);
    }

}

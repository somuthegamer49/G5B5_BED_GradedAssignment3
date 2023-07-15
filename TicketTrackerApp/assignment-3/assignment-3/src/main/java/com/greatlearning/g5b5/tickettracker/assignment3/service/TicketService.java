package com.greatlearning.g5b5.tickettracker.assignment3.service;

import java.util.List;

import com.greatlearning.g5b5.tickettracker.assignment3.entity.Ticket;

public interface TicketService {

	Ticket createTicket(Ticket ticket);

	List<Ticket> showTicket();

	Ticket findTicketById(int id);

	Ticket updateTicket(int id, Ticket ticket);

	void deleteTicket(int id);

	List<Ticket> findSearchTicket(String input);
}

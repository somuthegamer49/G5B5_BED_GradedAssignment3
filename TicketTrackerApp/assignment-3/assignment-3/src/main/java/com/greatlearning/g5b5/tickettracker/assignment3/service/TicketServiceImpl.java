package com.greatlearning.g5b5.tickettracker.assignment3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.greatlearning.g5b5.tickettracker.assignment3.entity.Ticket;
import com.greatlearning.g5b5.tickettracker.assignment3.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	public TicketRepository repo;

	@Override
	public Ticket createTicket(Ticket ticket) {
		return this.repo.save(ticket);
	}

	@Override
	public List<Ticket> showTicket() {
		List<Ticket> tickets = this.repo.findAll();
		return tickets;
	}

	@Override
	public Ticket findTicketById(int id) {
		Optional<Ticket> optionalTicket = this.repo.findById(id);

		if (optionalTicket.isPresent()) {
			return optionalTicket.get();
		} else {
			throw new IllegalArgumentException("Invalid id passed");
		}
	}

	@Override
	public Ticket updateTicket(int id, Ticket ticket) {
		Optional<Ticket> updatedTicket = this.repo.findById(id);
		if (updatedTicket.isPresent()) {
			Ticket temp = updatedTicket.get();
			temp.setTitle(ticket.getTitle());
			;
			temp.setDescription(ticket.getDescription());
			this.repo.save(temp);
			return temp;
		} else {
			throw new IllegalArgumentException("Invalid id passed");
		}
	}

	@Override
	public void deleteTicket(int id) {
		this.repo.deleteById(id);
	}

	@Override
	public List<Ticket> findSearchTicket(String input) {
		return repo.findSearchTicket(input);
	}

}

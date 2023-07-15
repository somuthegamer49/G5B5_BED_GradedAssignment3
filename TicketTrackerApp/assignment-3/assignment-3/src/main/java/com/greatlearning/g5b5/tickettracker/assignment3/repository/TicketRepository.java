package com.greatlearning.g5b5.tickettracker.assignment3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.greatlearning.g5b5.tickettracker.assignment3.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	@Query(value = "select * from Ticket t where t.description like %:input% or t.title like %:input%", nativeQuery = true)
	List<Ticket> findSearchTicket(@Param("input") String input);
}

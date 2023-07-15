package com.greatlearning.g5b5.tickettracker.assignment3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.g5b5.tickettracker.assignment3.entity.Ticket;
import com.greatlearning.g5b5.tickettracker.assignment3.service.TicketService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	private TicketService service;

	public TicketController(TicketService service) {
		this.service = service;
	}

	@GetMapping("/list")
	public String listTickets(Model model) {
		List<Ticket> tickets = this.service.showTicket();
		model.addAttribute("ticket", tickets);
		return "ticket/list-tickets";
	}

	@PostMapping("/save")
	public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
		this.service.createTicket(ticket);
		return "redirect:/tickets/list";
	}

	@PostMapping("/update")
	public String updateTicket(@ModelAttribute("ticket") Ticket ticket) {
		this.service.createTicket(ticket);
		return "redirect:/tickets/list";
	}

	@GetMapping("/add")
	public String showFormForAdd(Model model) {

		Ticket ticket = new Ticket();

		model.addAttribute("ticket", ticket);

		return "ticket/ticket-form";
	}

	@PostMapping("/delete")
	public String deleteBook(@RequestParam("id") int id) {
		this.service.deleteTicket(id);
		return "redirect:/tickets/list";
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {
		Ticket ticket = service.findTicketById(id);
		model.addAttribute("ticket", ticket);
		return "ticket/update-form";
	}

	@PostMapping("/showSearchTickets")
	public String showSearchTickets(Model model, String input) {
		if (input != null) {
			model.addAttribute("ticket", service.findSearchTicket(input));
		} else {
			model.addAttribute("ticket", service.showTicket());
		}
		return "ticket/list-tickets";
	}
}

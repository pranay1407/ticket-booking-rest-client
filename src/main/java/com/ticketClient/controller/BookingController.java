package com.ticketClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ticketClient.request.Passenger;
import com.ticketClient.response.Ticket;
import com.ticketClient.service.IBookingTicketService;

@Controller
public class BookingController 
{
	@Autowired
	private IBookingTicketService service;
	
	@PostMapping("/book-ticket")
	public String bookTicket(@ModelAttribute Passenger passenger, Model model)
	{
		System.out.println("Passenger from form in Controller "+ passenger);
		Ticket ticket = service.bookTicket(passenger);
		model.addAttribute("ticketNumber", "Ticket Number is : "+ticket.getTicketNumber());
		return "index";
	}
	
	
	@GetMapping("/form")
	public String getIndexPage( Model model)
	{
		model.addAttribute("passenger", new Passenger());
		return "index";
	}
	
	@GetMapping("/ticket")
	public String getTicketForm( Model model)
	{
		System.out.println("control in ticket endpoint mapped method");
		model.addAttribute("ticket", new Ticket());
		return "ticket-form";
	}
	
	@GetMapping("/get-ticket")
	public String getTicket(@RequestParam("ticketNumber")Integer ticketNumber, Model model)
	{
		Ticket ticket = service.fetchTicketInfo(ticketNumber);
		model.addAttribute("ticket", ticket);
		return "ticket-form";
	}

}

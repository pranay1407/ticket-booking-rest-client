package com.ticketClient.service;

import com.ticketClient.request.Passenger;
import com.ticketClient.response.Ticket;

public interface IBookingTicketService 
{
	public Ticket bookTicket(Passenger passenger);
	public Ticket fetchTicketInfo(Integer ticketNumber);

}

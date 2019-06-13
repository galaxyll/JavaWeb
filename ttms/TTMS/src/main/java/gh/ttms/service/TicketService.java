package gh.ttms.service;

import gh.ttms.pojo.Ticket;

import java.util.List;

public interface TicketService {
    public void addTicket(Ticket ticket);
    public List<Ticket> getTicketList(String username);
    public void takeTicket(Ticket ticket);
    public void markTicket(Ticket ticket);
    public void delTicket(Ticket ticket);
}

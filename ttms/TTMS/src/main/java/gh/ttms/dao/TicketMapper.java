package gh.ttms.dao;

import gh.ttms.pojo.Ticket;

import java.util.List;

public interface TicketMapper {
    public void addTicket(Ticket ticket);
    public List<Ticket> getTicketList(String username);
    public void alterTicketStatus(Ticket ticket);
    public void alterTicketMark(Ticket ticket);
    public void delTicket(Ticket ticket);
}

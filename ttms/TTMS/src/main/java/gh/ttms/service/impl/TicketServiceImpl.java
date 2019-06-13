package gh.ttms.service.impl;

import gh.ttms.dao.TicketMapper;
import gh.ttms.pojo.Ticket;
import gh.ttms.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketMapper ticketMapper;

    @Override
    public void addTicket(Ticket ticket) {
        ticketMapper.addTicket(ticket);
    }

    @Override
    public List<Ticket> getTicketList(String username) {
        return ticketMapper.getTicketList(username);
    }

    @Override
    public void takeTicket(Ticket ticket) {
        ticketMapper.alterTicketStatus(ticket);
    }

    @Override
    public void markTicket(Ticket ticket) {
        ticketMapper.alterTicketMark(ticket);
    }

    @Override
    public void delTicket(Ticket ticket) {
        ticketMapper.delTicket(ticket);
    }
}

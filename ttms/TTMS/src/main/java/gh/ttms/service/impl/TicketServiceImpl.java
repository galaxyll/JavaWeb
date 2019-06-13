package gh.ttms.service.impl;

import gh.ttms.dao.TicketMapper;
import gh.ttms.pojo.Ticket;
import gh.ttms.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketMapper ticketMapper;

    @Override
    public void addTicket(Ticket ticket) {
        ticketMapper.addTicket(ticket);
    }
}

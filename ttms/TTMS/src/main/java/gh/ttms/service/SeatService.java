package gh.ttms.service;

import gh.ttms.pojo.Plan;
import gh.ttms.pojo.Seat;
import gh.ttms.pojo.param.InquireSeatStatusPojo;

public interface SeatService {
    public void initSeat(Plan plan);
    public int getSeatStatus(InquireSeatStatusPojo param);
    public void alterSeatStatus(Seat seat);
}

package gh.ttms.dao;

import gh.ttms.pojo.Seat;
import gh.ttms.pojo.param.InquireSeatStatusPojo;

import java.util.Date;

public interface SeatMapper {
    public void addSeat(Seat seat);
    public int getSeatStatus(InquireSeatStatusPojo param);
    public void delSeat(Date date);
    public void updateStatus(Seat seat);
}

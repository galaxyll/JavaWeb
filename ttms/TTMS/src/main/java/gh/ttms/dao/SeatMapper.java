package gh.ttms.dao;

import gh.ttms.pojo.Seat;

import java.util.Date;

public interface SeatMapper {
    public void addSeat(Seat seat);
    public Seat getSeat();
    public void delSeat(Date date);
}

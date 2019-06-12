package gh.ttms.service;

import gh.ttms.pojo.Plan;
import gh.ttms.pojo.param.InquireSeatStatusPojo;

public interface SeatService {
    public void initSeat(Plan plan);
    public Integer getSeatStatus(InquireSeatStatusPojo param);
}

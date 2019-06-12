package gh.ttms.service.impl;

import gh.ttms.dao.SeatMapper;
import gh.ttms.pojo.Hall;
import gh.ttms.pojo.Plan;
import gh.ttms.pojo.Seat;
import gh.ttms.pojo.param.InquireSeatStatusPojo;
import gh.ttms.service.HallService;
import gh.ttms.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatMapper seatMapper;
    @Autowired
    private HallService hallService;

    @Override
    public void initSeat(Plan plan) {
        Seat seat = new Seat();
        Integer id = plan.getHallID();
        seat.setSeatID(id);
        Hall hall = hallService.getHallByID(id);
        for (int i=1;i<=hall.getHallRow();i++) {
            for (int j = 1; j <= hall.getHallColumn(); j++) {
                seat.setSeatRow(i);
                seat.setSeatColumn(j);
                seatMapper.addSeat(seat);
            }

        }
    }

    @Override
    public Integer getSeatStatus(InquireSeatStatusPojo param) {
        return seatMapper.getSeatStatus(param);
    }
}

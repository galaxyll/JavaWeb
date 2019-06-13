package gh.ttms.controller;

import gh.ttms.pojo.Hall;
import gh.ttms.pojo.param.InquireSeatStatusPojo;
import gh.ttms.service.HallService;
import gh.ttms.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SeatController {

    @Autowired
    private SeatService seatService;
    @Autowired
    private HallService hallService;

    @RequestMapping("/getSeatStatusArray")
    @ResponseBody
    public int[][] getSeatStatusArray(@RequestBody InquireSeatStatusPojo param)
    {
        param.setHallID(hallService.getHallID(param.getHallname()));
        Hall hall = hallService.getHallByID(param.getHallID());
        param.setSeatRow(hall.getHallRow());
        param.setSeatCol(hall.getHallColumn());
        int[][] seatStatus = new int[param.getSeatRow()][param.getSeatCol()];
        for (int i=1;i<=param.getSeatRow();i++){
            for (int j=1;j<=param.getSeatCol();j++){
                param.setSeatRow(i);
                param.setSeatCol(j);
                seatStatus[i-1][j-1] = seatService.getSeatStatus(param);
            }
        }
        return seatStatus;
    }
}

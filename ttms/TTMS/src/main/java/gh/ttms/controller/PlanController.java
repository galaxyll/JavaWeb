package gh.ttms.controller;

import gh.ttms.pojo.Movie;
import gh.ttms.pojo.Plan;
import gh.ttms.pojo.param.DateAndName;
import gh.ttms.service.MovieService;
import gh.ttms.service.PlanService;
import gh.ttms.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class PlanController {

    @Autowired
    private PlanService planService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private SeatService seatService;

    @RequestMapping("/addPlan")
    @ResponseBody
    public Map<String,String> addPlan(@RequestBody Plan plan)
    {
        Map<String,String> map = new HashMap<>();
        map.put("status","500");
        map.put("message","时间冲突！！！");
        Date lastDate = planService.getMaxDateINHall(plan.getHallID());

        if (lastDate==null||plan.getPlayDate().getTime()>lastDate.getTime())
        {
            Date endDate = new Date(plan.getPlayDate().getTime()+((movieService.getMovieByName(plan.getMoviename()).getDuration())*1000*60));
            plan.setEndDate(endDate);
            planService.addPlan(plan);
            seatService.initSeat(plan);
            map.put("status","200");
            map.put("message","OK");
        }
        return map;
    }

    @RequestMapping("/getDateByName")
    @ResponseBody
    public Set<Date> getShowDateByName(@RequestBody Map<String,String> param)
    {
        return planService.getShowDateByName(param.get("moviename"));
    }

    @ResponseBody
    @RequestMapping("/getNewMovie")
    public List<Movie> getNewMovie()
    {
        return planService.getNewMovie();
    }

    @ResponseBody
    @RequestMapping("/getMoviePlanByDate")
    public List<Plan> getMoviePlan(@RequestBody DateAndName param)
    {

        return planService.getMoviePlanByDate(param);
    }
}

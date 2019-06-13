package gh.ttms.service.impl;

import gh.ttms.dao.PlanMapper;
import gh.ttms.pojo.Movie;
import gh.ttms.pojo.Plan;
import gh.ttms.pojo.param.DateAndName;
import gh.ttms.pojo.param.IDAndDate;
import gh.ttms.pojo.param.PlanAddNameType;
import gh.ttms.service.MovieService;
import gh.ttms.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanMapper planMapper;
    @Autowired
    private MovieService  movieService;

    @Override
    public void addPlan(Plan plan) {
        planMapper.addPlan(plan);
    }

    @Override
    public Date getMaxDateINHall(Integer hallID) {
        return planMapper.getHallLastDate(hallID);
    }


    @Override
    public List<Date> getShowDateByName(String moviename) {
        return planMapper.getShowDateByName(moviename);
//        Set<Date> dateSet = new HashSet<>();
//        Date dateTmp = null;
//        for (Date date : dateList){
//            System.out.println("前："+date.toString());
//            dateTmp = new Date(date.getTime()-date.getTime()%(1000*60*60*32));
//            System.out.println("后："+dateTmp.toString());
//            dateSet.add(dateTmp);
//        }
//        return dateSet;
    }

    @Override
    public List<Movie> getNewMovie() {
        List<String> nameList = planMapper.getNewMovienameList();
        List<Movie> movieList  = new LinkedList<>();
        Movie movie = null;
        for (String moviename:nameList){
            movie = movieService.getMovieByName(moviename);
            movieList.add(movie);
        }
        return movieList;
    }

    @Override
    public List<PlanAddNameType> getMoviePlanByDate(DateAndName param) {
        return planMapper.getMoviePlanByDate(param);
    }

    @Override
    public void delPlan(IDAndDate param) {
        planMapper.delPlan(param);
    }

    @Override
    public Double getPlanPrice(IDAndDate param) {
        return planMapper.getPlanPrice(param);
    }

    @Override
    public String getPlanMoviename(IDAndDate param) {
        return planMapper.getPlanMoviename(param);
    }


}

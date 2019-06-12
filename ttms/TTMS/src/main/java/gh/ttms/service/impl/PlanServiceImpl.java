package gh.ttms.service.impl;

import gh.ttms.dao.PlanMapper;
import gh.ttms.pojo.Movie;
import gh.ttms.pojo.Plan;
import gh.ttms.pojo.param.DateAndName;
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
    public Set<Date> getShowDateByName(String moviename) {
        List<Date> dateList = planMapper.getShowDateByName(moviename);
        Set<Date> dateSet = new HashSet<>();
        Date dateTmp = null;
        for (Date date : dateList){
            dateTmp = new Date(date.getTime()-date.getTime()%(1000*60*60*24));
            dateSet.add(dateTmp);
        }
        return dateSet;
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
    public List<Plan> getMoviePlanByDate(DateAndName param) {
        return planMapper.getMoviePlanByDate(param);
    }


}

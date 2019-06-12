package gh.ttms.service;

import gh.ttms.pojo.Movie;
import gh.ttms.pojo.Plan;
import gh.ttms.pojo.param.DateAndName;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface PlanService {
    public void addPlan(Plan plan);
    public Date getMaxDateINHall(Integer hallID);
    public Set<Date> getShowDateByName(String moviename);
    public List<Movie> getNewMovie();
    public List<Plan> getMoviePlanByDate(DateAndName param);
}

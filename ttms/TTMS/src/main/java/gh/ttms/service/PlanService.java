package gh.ttms.service;

import gh.ttms.pojo.Movie;
import gh.ttms.pojo.Plan;
import gh.ttms.pojo.param.DateAndName;
import gh.ttms.pojo.param.IDAndDate;
import gh.ttms.pojo.param.PlanAddNameType;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PlanService {
    public void addPlan(Plan plan);
    public Date getMaxDateINHall(Integer hallID);
    public List<Date> getShowDateByName(String moviename);
    public List<Movie> getNewMovie();
    public List<PlanAddNameType> getMoviePlanByDate(DateAndName param);
    public void delPlan(IDAndDate param);
}

package gh.ttms.dao;

import gh.ttms.pojo.Plan;
import gh.ttms.pojo.param.DateAndName;

import java.util.Date;
import java.util.List;

public interface PlanMapper {
    public void addPlan(Plan plan);
    public Date getHallLastDate(Integer hallID);
    public List<Date> getShowDateByName(String moviename);
    public List<String> getNewMovienameList();
    public List<Plan> getMoviePlanByDate(DateAndName param);
}

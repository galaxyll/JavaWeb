package gh.ttms.dao;

import gh.ttms.pojo.Plan;

import java.util.Date;

public interface PlanMapper {
    public void addPlan(Plan plan);
    public Date getHallLastDate(Integer hallID);
}

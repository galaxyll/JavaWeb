package gh.ttms.service;

import gh.ttms.pojo.Plan;

import java.util.Date;

public interface PlanService {
    public void addPlan(Plan plan);
    public Date getMaxDateINHall(Integer hallID);
}

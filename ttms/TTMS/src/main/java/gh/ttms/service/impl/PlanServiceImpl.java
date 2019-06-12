package gh.ttms.service.impl;

import gh.ttms.dao.PlanMapper;
import gh.ttms.pojo.Plan;
import gh.ttms.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanMapper planMapper;

    @Override
    public void addPlan(Plan plan) {
        planMapper.addPlan(plan);
    }

    @Override
    public Date getMaxDateINHall(Integer hallID) {
        return planMapper.getHallLastDate(hallID);
    }
}

package gh.ttms.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import gh.ttms.pojo.Plan;
import gh.ttms.pojo.param.DateAndName;
import gh.ttms.pojo.param.IDAndDate;
import gh.ttms.pojo.param.PlanAddNameType;
import gh.ttms.pojo.param.Stringstring;

import java.util.Date;
import java.util.List;

public interface PlanMapper {
    public void addPlan(Plan plan);
    public Date getHallLastDate(Integer hallID);
    public List<Date> getShowDateByName(String moviename);
    public List<String> getNewMovienameList();
    public List<PlanAddNameType> getMoviePlanByDate(DateAndName param);
    public void delPlan(IDAndDate param);
    public Double getPlanPrice(IDAndDate param);
    public String getPlanMoviename(IDAndDate param);
}

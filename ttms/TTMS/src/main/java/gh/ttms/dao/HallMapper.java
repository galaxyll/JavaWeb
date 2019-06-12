package gh.ttms.dao;

import gh.ttms.pojo.Hall;

import java.util.List;

public interface HallMapper {
    public Hall getHall(Integer id);
    public int getHallID(String hallname);
    public void addHall(Hall hall);
    public List<Hall> getHallList();
}

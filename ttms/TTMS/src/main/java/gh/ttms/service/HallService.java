package gh.ttms.service;

import gh.ttms.pojo.Hall;

import java.util.List;

public interface HallService {
    public void addHall(Hall hall);
    public Hall getHallByID(Integer id);
    public int getHallID(String hallname);
    public String getHallname(Integer id);
    public List<Hall> getHallList();
}

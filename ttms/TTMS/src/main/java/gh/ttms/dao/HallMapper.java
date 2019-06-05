package gh.ttms.dao;

import gh.ttms.pojo.Hall;

public interface HallMapper {
    public Hall getHall(Integer id);
    public void addHall(Hall hall);
}

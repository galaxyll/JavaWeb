package gh.ttms.service.impl;

import gh.ttms.dao.HallMapper;
import gh.ttms.pojo.Hall;
import gh.ttms.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallServiceImpl implements HallService {

    @Autowired
    private HallMapper hallMapper;

    @Override
    public void addHall(Hall hall) {
        hallMapper.addHall(hall);
    }

    @Override
    public Hall getHallByID(Integer id) {
        return hallMapper.getHall(id);
    }

    @Override
    public int getHallID(String hallname) {
        return hallMapper.getHallID(hallname);
    }

    @Override
    public String getHallname(Integer id) {
        return hallMapper.getHallname(id);
    }

    @Override
    public List<Hall> getHallList() {
        return hallMapper.getHallList();
    }
}

package gh.ttms.service.impl;

import gh.ttms.dao.HallMapper;
import gh.ttms.pojo.Hall;
import gh.ttms.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HallServiceImpl implements HallService {

    @Autowired
    private HallMapper hallMapper;

    @Override
    public void addHall(Hall hall) {
        hallMapper.addHall(hall);
    }
}

package gh.ttms.controller;

import gh.ttms.pojo.Hall;
import gh.ttms.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HallController {

    @Autowired
    private HallService hallService;

    @ResponseBody
    @RequestMapping("/addHall")
    public Map<String,String> addHall(@RequestBody Hall hall)
    {
        Map<String,String> map = new HashMap<>();
        hallService.addHall(hall);
        map.put("status","200");
        map.put("message","OjbK");
        return map;
    }
    @ResponseBody
    @RequestMapping("/getHallList")
    public List<Hall> getHallList()
    {
        return hallService.getHallList();
    }
}

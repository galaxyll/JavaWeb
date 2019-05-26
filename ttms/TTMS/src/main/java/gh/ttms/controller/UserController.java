package gh.ttms.controller;

import gh.ttms.pojo.User;
import gh.ttms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping("/register")
    @ResponseBody
    public Map<String,String> register(@RequestBody User user)
    {
        Map<String,String> map =new HashMap<>();
        if (userService.inquireByUsername(user.getUsername())) {
            userService.register(user.getUsername(), user.getPassword(), user.getMailbox());
            map.put("status","200");
            map.put("message","OK");
        }else {
            map.put("message","用户名重复！");
            map.put("status","500");
        }
        return map;
    }
    @RequestMapping("/login")
    @ResponseBody
    public Map<String,String> login(@RequestBody User user, HttpSession httpSession)
    {
        Map<String,String> map = new HashMap<>();
        User getuser = userService.login(user.getUsername(),user.getPassword());
        if (getuser!=null){
            httpSession.setAttribute("user",user);
            map.put("status","200");
            map.put("message","OK");
        }else {
            map.put("status","500");
            map.put("message","密码或用户名错误，请重新输入！");
        }
        System.out.println("进入login方法");
        return map;
    }
}

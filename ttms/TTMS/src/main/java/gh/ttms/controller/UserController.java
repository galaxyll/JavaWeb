package gh.ttms.controller;

import gh.ttms.pojo.User;
import gh.ttms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @PostMapping("/register")
    public ModelAndView register(@RequestParam (value = "username") String username,String password,String mailbox,ModelAndView modelAndView)
    {
        userService.register(username,password,mailbox);
        modelAndView.setViewName("loginForm");
        return modelAndView;
    }
    @PostMapping("/login")
    @ResponseBody
    public Map<String,String> login(@RequestBody User user, HttpSession httpSession)
    {
        Map<String,String> map = new HashMap<>();
        User getuser = userService.login(user.getName(),user.getPassword());
        if (getuser!=null){
            httpSession.setAttribute("user",user);
            map.put("status","200");
            map.put("message","OK");
        }else {
            map.put("status","500");
            map.put("message","密码或用户名错误，请重新输入！");
        }
        return map;
    }
}

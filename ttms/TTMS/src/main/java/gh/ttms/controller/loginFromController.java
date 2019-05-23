package gh.ttms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class loginFromController {
    @RequestMapping("/loginForm")
    public ModelAndView loginFrom(ModelAndView modelAndView)
    {
        modelAndView.setViewName("loginForm");
        return modelAndView;
    }
    @RequestMapping("/registerForm")
    public ModelAndView registerFrom(ModelAndView modelAndView)
    {
        modelAndView.setViewName("/registerForm");
        return modelAndView;
    }
}

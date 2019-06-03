package gh.ttms.controller;

import gh.ttms.pojo.User;
import gh.ttms.service.UserService;
import gh.ttms.service.impl.MailServiceImpl;
import gh.ttms.util.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;
    @Autowired
    private MailServiceImpl mailService;
    @Autowired
    private VerificationCode verificationCode;

    @RequestMapping("/checkName")
    @ResponseBody
    public Map<String,String> checkName(@RequestBody User user)
    {
        Map<String,String> map = new HashMap<>();
        if (userService.inquireByUsername(user.getUsername())){
            map.put("status","200");
            map.put("message","OK");
        }else {
            map.put("message","用户名重复！");
            map.put("status","500");
        }
        return map;
    }

    @RequestMapping("/checkMail")
    @ResponseBody
    public Map<String,String> checkMail(@RequestBody User user, HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        String code = "验证码："+verificationCode.getCode(6);
        session.setAttribute("code",code);
        Map<String,String> map = new HashMap<>();
        map.put("message","验证码已发送，请注意查收");
        map.put("status","200");
        try {
            mailService.sendSimpleMail(user.getMailbox(),code);
            System.out.println(user.getMailbox());
        } catch (MessagingException e) {
            map.put("message","验证码发送失败");
            map.put("status","500");
            //e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("/checkCode")
    @ResponseBody
    public Map<String,String> checkCode(HttpSession session,@RequestBody Map<String,String> argue)
    {
        Map<String,String> map = new HashMap<>();
        String cCode= (String) session.getAttribute("code");
        if (cCode.equals(argue.get("code"))){
            userService.register((User)session.getAttribute("user"));
            map.put("message","验证成功！请至登录界面登录！");
            map.put("status","200");
        }else {
            map.put("message","验证码错误，请重试！");
            map.put("status","500");
        }
        return map;
    }

//    @RequestMapping("/register")
//    @ResponseBody
//    public Map<String,String> register(@RequestBody User user)
//    {
//        Map<String,String> map =new HashMap<>();
//        if (userService.inquireByUsername(user.getUsername())) {
//            try {
//                mailService.sendSimpleMail(user.getMailbox(),verificationCode.getCode(6));
//                System.out.println(user.getMailbox());
//            } catch (MessagingException e) {
//                e.printStackTrace();
//            }
//            map.put("status","200");
//            map.put("message","OK");
//        }else {
//            map.put("message","用户名重复！");
//            map.put("status","500");
//        }
//        return map;
//    }
    @RequestMapping("/login")
    @ResponseBody
    public Map<String,String> login(@RequestBody User user, HttpSession httpSession)
    {
        httpSession.setAttribute("user",user);
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

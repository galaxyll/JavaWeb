package gh.ttms.controller;

import gh.ttms.pojo.Seat;
import gh.ttms.pojo.Ticket;
import gh.ttms.pojo.User;
import gh.ttms.pojo.param.IDAndDate;
import gh.ttms.service.*;
import gh.ttms.service.impl.MailServiceImpl;
import gh.ttms.util.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;
    @Autowired
    private PlanService planService;
    @Autowired
    private SeatService seatService;
    @Autowired
    private HallService hallService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private TicketService ticketService;
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
        Date date = new Date();
        System.out.println(date.toString());
        //HttpSession session = request.getSession();
        System.out.println(date.toString());
        //session.setAttribute("user",user);
        System.out.println(date.toString());
        String code = "验证码："+verificationCode.getCode(6);
        System.out.println(date.toString());
        //session.setAttribute("code",code);
        System.out.println(date.toString());
        Map<String,String> map = new HashMap<>();
        map.put("code",code);
        map.put("message","验证码已发送，请注意查收");
        map.put("status","200");
        try {
            System.out.println("发送前："+date.toString());
            mailService.sendSimpleMail(user.getMailbox(),code);
            System.out.println("发送后："+date.toString());
            System.out.println(user.getMailbox());
        } catch (MessagingException e) {
            map.put("message","验证码发送失败");
            map.put("status","500");
            e.printStackTrace();
        }
        return map;
    }

//    @RequestMapping("/checkCode")
//    @ResponseBody
//    public Map<String,String> checkCode(HttpSession session,@RequestBody Map<String,String> argue)
//    {
//        Map<String,String> map = new HashMap<>();
//        String cCode= (String) session.getAttribute("code");
//        if (cCode.equals(argue.get("code"))){
//            userService.register((User)session.getAttribute("user"));
//            map.put("message","验证成功！请至登录界面登录！");
//            map.put("status","200");
//        }else {
//            map.put("message","验证码错误，请重试！");
//            map.put("status","500");
//        }
//        return map;
//    }

    @RequestMapping("/register")
    @ResponseBody
    public Map<String,String> register(@RequestBody User user)
    {
        Map<String,String> respMap =new HashMap<>();
        userService.register(user);
        respMap.put("message","注册成功！");
        respMap.put("status","200");
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
        return respMap;
    }

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

    @ResponseBody
    @RequestMapping("/buyTicket/{username}")
    public Map<String,String> buyTicket(@PathVariable("username") String username, @RequestBody List<Seat> seatList)
    {
        Map<String,String> map = new HashMap<>();
        User user = userService.getUserByName(username);
        double amountMoney = 0;
        Ticket ticket = null;
        IDAndDate param = new IDAndDate();
        for (Seat seat:seatList){
            param.setId(seat.getSeatID());
            param.setShowDate(seat.getUseDate());
            System.out.println(planService.getPlanPrice(param));
            amountMoney += planService.getPlanPrice(param);
        }
        if (user.getMoney()<amountMoney){
            map.put("status","500");
            map.put("message","余额不足，请充值！");
        }else{
            user.setMoney(user.getMoney()-amountMoney);
            for (Seat seat:seatList){
                param.setId(seat.getSeatID());
                param.setShowDate(seat.getUseDate());
                seat.setStatus(1);
                seatService.alterSeatStatus(seat);
                ticket = new Ticket();
                ticket.setMoviename(planService.getPlanMoviename(param));
                ticket.setPlayDate(seat.getUseDate());
                ticket.setSeatRow(seat.getSeatRow());
                ticket.setSeatColumn(seat.getSeatColumn());
                ticket.setHallname(hallService.getHallname(seat.getSeatID()));
                ticket.setHallType(hallService.getHallByID(seat.getSeatID()).getType());
                ticketService.addTicket(ticket);
                movieService.addMovieQuantity(ticket.getMoviename());
            }
            map.put("status","200");
            map.put("message","购票成功！");
        }
        return map;
    }
}

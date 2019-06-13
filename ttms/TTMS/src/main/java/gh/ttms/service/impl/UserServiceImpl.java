package gh.ttms.service.impl;

import gh.ttms.dao.UserMapper;
import gh.ttms.pojo.User;
import gh.ttms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        userMapper.addUser(user);
    }

    @Override
    public User login(String username, String password) {
        User user = userMapper.getUserByName(username);
        if (user.getPassword().equals(password))
            return user;
        return null;
    }

    @Override
    public boolean inquireByUsername(String username) {
        User user = userMapper.getUserByName(username);
        if (user!=null){
            System.out.println(user.getUsername()+user.getMailbox());
            return false;
        }
        return true;
    }

    @Override
    public User getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public void addMoney(User user,int money) {
        user.setMoney(user.getMoney()+money);
        userMapper.addMoney(user);
    }

    @Override
    public void addMoney(User user, double money) {
        user.setMoney(user.getMoney()+money);
        userMapper.addMoney(user);
    }

    @Override
    public void addAdmin(User user) {
        user.setType(1);
        userMapper.addAdmin(user);
    }

}

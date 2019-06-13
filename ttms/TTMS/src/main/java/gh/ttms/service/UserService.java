package gh.ttms.service;

import gh.ttms.pojo.User;

public interface UserService  {
    void register(User user);
    User login(String username,String password);
    boolean inquireByUsername(String name);
    User getUserByName(String username);
    void addMoney(User user,int money);
    void addMoney(User user,double money);
    public void addAdmin(User user);
}

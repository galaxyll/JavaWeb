package gh.ttms.service;

import gh.ttms.pojo.User;

public interface UserService  {
    void register(User user);
    User login(String username,String password);
    boolean inquireByUsername(String name);
}

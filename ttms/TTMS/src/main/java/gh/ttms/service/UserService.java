package gh.ttms.service;

import gh.ttms.pojo.User;

public interface UserService  {
    void register(String username,String password,String mailbox);
    User login(String username,String password);
    boolean inquireByUsername(String name);
}

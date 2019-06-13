package gh.ttms.dao;


import gh.ttms.pojo.User;
import gh.ttms.pojo.param.IntAndString;

public interface UserMapper {
    public int addUser(User user);
    public int deleteUserByID(int id);
    public int deleteUserByName(String name);
    public int updateUser(User user);
    public User getUserByID(int id);
    public User getUserByName(String name);
    public void addMoney(User user);
    public void addAdmin(User user);

}
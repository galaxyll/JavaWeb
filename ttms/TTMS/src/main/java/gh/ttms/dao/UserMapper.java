package gh.ttms.dao;


import gh.ttms.pojo.User;

public interface UserMapper {
    public int addUser(User user);
    public int deleteUserByID(int id);
    public int deleteUserByName(String name);
    public int updateUser(User user);
    public User getUserByID(int id);
    public User getUserByName(String name);


}
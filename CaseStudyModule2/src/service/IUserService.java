package service;

import model.User;

import java.util.List;

public interface IUserService {

    List<User> getUser();

    abstract User adminLogin(String username, String password);
    void add(User newUser);
    void update(User newUser);
    boolean existById(long id);
    boolean existByName(String email);
    boolean existByPhone(String phone);
    boolean existByUserName(String userName);
    User findUserById(long id);

}

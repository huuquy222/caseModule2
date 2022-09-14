package service;

import model.Role;
import model.User;
import utils.CSVUtil;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    public final static String path = "data\\User.csv";

    private static UserService instance;

    private UserService(){

    }

    public static UserService getInstance(){
        if (instance == null)
            instance = new UserService();
        return instance;
    }

    @Override
    public List<User> getUser() {
        List<User> users = new ArrayList<>();
        List<String> records = CSVUtil.read(path);
        for (String record : records){
        users.add(User.parseUser(record));
    }
        return users;
}

    @Override
    public User adminLogin(String username, String password) {
        List<User> users = getUser();
        for (User user : users){
            if (user.getUsername().equals(username) && user.getPassword().equals(password)
                     && user.getRole().equals(Role.ADMIN)){
                return user;
            }
        }
        return null;
    }

    @Override
    public void add(User newUser) {
        newUser.setId(System.currentTimeMillis()/1000000);
        List<User> users = getUser();
        users.add(newUser);
        CSVUtil.write(path, users);
    }

    @Override
    public void update(User newUser) {
        List<User> users = getUser();
        for (User user : users){
            if (user.getId() == newUser.getId()){
                String name = user.getName();
                if (name != null && !name.isEmpty())
                    user.setName(newUser.getName());
                String phone = newUser.getPhone();
                if (phone!= null && !phone.isEmpty())
                    user.setPhone(newUser.getPhone());
                String address = newUser.getAddress();
                if (address != null && !address.isEmpty())
                    user.setAddress(newUser.getAddress());
                CSVUtil.write(path, users);
                break;
            }
        }
    }

    @Override
    public boolean existById(long id) {
        return findUserById(id) != null;
    }

    @Override
    public boolean existByName(String email) {
        List<User> users = getUser();
        for (User user: users) {
            if (user.getEmail().equals(email))
                return true;
        }
        return false;
    }

    @Override
    public boolean existByPhone(String phone) {
        List<User> users = getUser();
        for (User user : users){
            if (user.getPhone().equals(phone))
                return true;
        }
        return false;
    }

    @Override
    public boolean existByUserName(String userName) {
        List<User> users = getUser();
        for (User user: users) {
            if (user.getUsername().equals(userName))
                return true;
        }
        return false;
    }

    @Override
    public User findUserById(long id) {
        List<User> users = getUser();
        for (User user: users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

}

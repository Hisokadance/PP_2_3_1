package web.service;

import web.model.User;

import java.util.List;

public interface UserServices {

    List<User> getAllUser();

    void addUser(User user);

    User showUser(int id);

    void updateUser(int id, User updateuser);

    void deleteUser(int id);

}

package web.service;

import web.model.User;

import java.util.List;

public interface UserServices {

    List<User> getAllUser();

    void addUser(User user);

    User getUser(Integer  id);

    void updateUser(User updateuser);

    void deleteUser(Integer  id);
}

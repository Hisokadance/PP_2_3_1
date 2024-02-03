package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);

    User showUser(int id);

    void updateUser(int id, User updateuser);

    void deleteUser(int id);
}

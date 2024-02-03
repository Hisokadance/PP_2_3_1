package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(int id, User updateUser);

    void deleteUser(int id);

    User getUser(int id);
}

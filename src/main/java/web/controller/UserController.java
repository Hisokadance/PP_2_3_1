package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserServices;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    //рабочий метод
    @GetMapping
    public String getAllUsers(Model model) {
        List<User> userList = userServices.getAllUser();
        model.addAttribute("user", userList);
        return "users/allusers";
    }

    //рабочий метод
    @GetMapping("/addUser")
    public String addNewUser(Model model, User newUser) {
        model.addAttribute("user", newUser);
        return "users/adduser";
    }

    @PostMapping()
    public String saveNewUser(@ModelAttribute("user") User saveUser) {
        userServices.addUser(saveUser);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String updateUser(@ModelAttribute("id") int id, Model model) {
        User user = userServices.getUser(id);
        System.out.println("update from controller " + user);
        model.addAttribute("userUpdate", user);
        return "users/updateuser";
    }

    @PostMapping("/update")
    public String updateNewUser(@ModelAttribute("userUpdate") User updateUser) {
        userServices.updateUser(updateUser);
        return "redirect:/users";
    }

    //рабочий  метод но с RequestMapping
    @PostMapping("/delete/{id}")
    public String deleteUser(@ModelAttribute("id") int id) {
        userServices.deleteUser(id);
        return "redirect:/users";
    }

}

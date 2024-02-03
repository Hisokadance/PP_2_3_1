package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/addUser")
    public String addNewUser(Model model, User newUser) {
        model.addAttribute("newUser", newUser);
        return "users/adduser";
    }

    @PostMapping()
    public String saveNewUser(@ModelAttribute("user") User saveUser) {
        userServices.addUser(saveUser);
        return "redirect:/users";
    }

    @RequestMapping("/edit/{id}")
    public String updateEmployee(@PathVariable("id") int id, Model model) {
        User user = userServices.getUser(id);
        model.addAttribute("user", user);
        return "users/adduser";
    }

    @RequestMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        userServices.deleteUser(id);
        return "redirect:/users";
    }
}

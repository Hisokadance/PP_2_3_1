package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> userList = userServices.getAllUser();
        model.addAttribute("user", userList);
        return "users/allusers";
    }

    @GetMapping("/new")
    public String addUser(@ModelAttribute("user") User user) {
        return "users/adduser";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") User user) {
        userServices.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userServices.showUser(id));
        return "users/insideuser";
    }

//    @GetMapping("/{id}/edit")
//    public String edit(Model model) {
//        model.addAttribute("user", new User());
//        return "users/updateuser";
//    }
//
//    @PostMapping("/{id}")
//    public String updateUser(@ModelAttribute("id") User user) {
//        try {
//            userServices.updateUser(user.getId(), user);
//        }catch (Exception e){
//            System.out.println("ERROR UPDATE");
//        }
//        return "redirect:/users";
//    }

//    @PostMapping("/delete_user")
//    public String deleteUser(@ModelAttribute("user") User user) {
//        try {
//            userServices.deleteUser(user.getId());
//        } catch (Exception e) {
//            System.out.println("ERROR DELETE");
//        }
//        return "redirect:/users";
//    }
}

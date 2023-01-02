package kata.spring_security.controller;

import kata.spring_security.model.Role;
import kata.spring_security.model.User;
import kata.spring_security.service.RoleService;
import kata.spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminController(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String getUser(Model model) {
        model.addAttribute("userList", userService.getList());
        return "admin";
    }

    @GetMapping("/newUserAdmin")
    public String addNewUser(Model model) {
      User user = new User();
       model.addAttribute("newUser", user);

       List<Role> roles = roleService.getList();
        model.addAttribute("roleList", roles);

        return "newAdmin";
    }

    @PostMapping("/newUserAdmin")
    public String saveNewUser(
            @ModelAttribute("newUser") User user
            ) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.add(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/editUser/{id}")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("editUser", userService.getUser(id));
        model.addAttribute("roleList",roleService.getList());
        return "editAdmin";
    }

    @PatchMapping("/{id}")
    public String userSaveEdit(@PathVariable("id") int id, @ModelAttribute("user") User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.editUser(user);
        return "redirect:/admin";
    }
}
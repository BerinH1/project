package com.itakademija.mobileshop.controller;

import com.itakademija.mobileshop.model.Role;
import com.itakademija.mobileshop.model.User;
import com.itakademija.mobileshop.repository.UserRepository;
import com.itakademija.mobileshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String viewUsers(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        var user = userRepository.findByUsername(currentUserName);

        List<User> userList = userService.getAllUsers();
        model.addAttribute("listaKorisnika", userList);

        return "userControl";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Neisparavan korisnički ID: " + id));

        userRepository.delete(user);
        return "redirect:/users";
    }

    @GetMapping("/register")
    public String createNewUserByAdmin(Model model) {
        User user = new User();
        model.addAttribute("prazanKorisnik", user);
        return "register";
    }

    @PostMapping("/update-role/{id}")
    public String createNewUserByAdmin(
            @RequestParam Role role,
            @PathVariable("id") long id
    ) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Neisparavan korisnički ID: " + id));

        user.setRole(role);
        userRepository.save(user);

        return "redirect:/users";
    }

}

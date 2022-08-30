package com.itakademija.mobileshop.controller;

import com.itakademija.mobileshop.model.Product;
import com.itakademija.mobileshop.model.Role;
import com.itakademija.mobileshop.model.User;
import com.itakademija.mobileshop.repository.ProductRepository;
import com.itakademija.mobileshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ProductRepository productRepository;

  @GetMapping("/")
  public String homepage(Model model) {
      var productsIterator = this.productRepository.findAll();
      var products = new ArrayList<Product>();
      productsIterator.iterator().forEachRemaining(products::add);
      model.addAttribute("productsList", products);

      return "index";
    }

    @GetMapping("/admin")
    public String viewAdmin() {
        return "admin";
    }

    @GetMapping("/sign-in")
    public String showNewUserForm(Model model) {
        User user = new User();
        model.addAttribute("prazanKorisnik", user);
        return "sign-in";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

        @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("prazanKorisnik") User user) {
        user.setRole(Role.USER);
        String hashedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userService.saveUser(user);
        return "redirect:/login";
    }
}





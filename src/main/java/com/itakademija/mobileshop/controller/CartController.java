package com.itakademija.mobileshop.controller;

import com.itakademija.mobileshop.model.Cart;
import com.itakademija.mobileshop.model.OrderEntry;
import com.itakademija.mobileshop.repository.CartRepository;
import com.itakademija.mobileshop.repository.ProductRepository;
import com.itakademija.mobileshop.repository.UserRepository;
import com.itakademija.mobileshop.service.CartService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Objects;

@Controller
public class CartController {

  private final CartService cartService;
  private final ProductRepository productRepository;
  private final CartRepository cartRepository;
  private final UserRepository userRepository;

  public CartController(
          CartService cartService,
          ProductRepository productRepository,
          CartRepository cartRepository,
          UserRepository userRepository
  ) {
    this.cartService = cartService;
    this.productRepository = productRepository;
    this.cartRepository = cartRepository;
    this.userRepository = userRepository;
  }

  @GetMapping("/cart")
  public String viewCart(Model model) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String currentUserName = authentication.getName();
    var user = userRepository.findByUsername(currentUserName);
    var cart = user.getCart();
    if(cart == null) {
      cart = new Cart(user);
    }

    model.addAttribute("cart", cart);

    return "cart";
  }

  @GetMapping("/cart/orderEntry/{id}")
  public String viewCart(
          @PathVariable(required = false) Long id,
          Model model
  ) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String currentUserName = authentication.getName();
    var user = userRepository.findByUsername(currentUserName);

    var cart = user.getCart();
    var orderEntry = cart.getOrderEntryList().stream()
            .filter(value -> Objects.equals(value.getId(), id))
            .findFirst()
            .get();

    cart.setNumberOfItems(cart.getNumberOfItems() - orderEntry.getQuantity());
    cart.setTotalPrice(cart.getTotalPrice().subtract(orderEntry.getProduct().getPrice().multiply(BigDecimal.valueOf(orderEntry.getQuantity()))));
    cart.getOrderEntryList().remove(orderEntry);

    cartRepository.save(cart);

    return "redirect:/cart";
  }

  @PostMapping("/updateQuantity")
  public String updateQuantity(
          @RequestParam(value = "quantity", required = true) Integer quantity,
          @RequestParam(value = "productId", required = true) Long productId
  ) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String currentUserName = authentication.getName();
    var user = userRepository.findByUsername(currentUserName);

    var cart = user.getCart();
    var product = productRepository.findById(productId).get();
    var orderEntry = new OrderEntry(product, quantity);

    if(cart == null) {
      cart = new Cart(user);
    }

    cartService.updateCartEntry(orderEntry, cart);

    return "redirect:/product";
  }


}

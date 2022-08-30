package com.itakademija.mobileshop.controller;

import com.itakademija.mobileshop.model.OrderEntry;
import com.itakademija.mobileshop.model.Product;
import com.itakademija.mobileshop.repository.CartRepository;
import com.itakademija.mobileshop.repository.ProductRepository;
import com.itakademija.mobileshop.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Objects;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    public ProductController(
            ProductRepository productRepository,
            CartRepository cartRepository,
            UserRepository userRepository
    ) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/product")
    public String viewProduct(
            Model model,
            @RequestParam(value = "sort", required = false) String sort
    ) {
        if (sort == null) {
            sort = "id";
        }

        var productsIterator = this.productRepository.findAll(Sort.by(sort));
        var products = new ArrayList<Product>();
        productsIterator.iterator().forEachRemaining(products::add);
        model.addAttribute("products", products);

        return "product";
    }

    @GetMapping("/product-details/{id}")
    public String productDetails(@PathVariable(required = false) Long id, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        var user = userRepository.findByUsername(currentUserName);

        var cart = user.getCart();
        var product = productRepository.findById(id).get();
        if (cart != null) {
            var existingOrderEntry = cart.getOrderEntryList()
                    .stream()
                    .filter(orderEntry -> Objects.equals(orderEntry.getProduct().getId(), id))
                    .findFirst();

            existingOrderEntry.ifPresentOrElse(
                    existOE -> model.addAttribute("orderEntry", existOE),
                    () -> model.addAttribute("orderEntry", new OrderEntry(product, 0))
            );
        } else {
            model.addAttribute("orderEntry", new OrderEntry(product, 0));
        }
        var similarProducts = this.productRepository.findAll(PageRequest.of(0,4)).stream().toList();
        model.addAttribute("similarProducts", similarProducts);

        return "product-details";
    }
}

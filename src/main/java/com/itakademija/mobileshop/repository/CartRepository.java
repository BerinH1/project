package com.itakademija.mobileshop.repository;

import com.itakademija.mobileshop.model.Cart;
import com.itakademija.mobileshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findCartByUser(User user);

}

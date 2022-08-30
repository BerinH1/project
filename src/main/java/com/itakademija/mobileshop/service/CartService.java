package com.itakademija.mobileshop.service;

import com.itakademija.mobileshop.model.Cart;
import com.itakademija.mobileshop.model.OrderEntry;
import com.itakademija.mobileshop.repository.CartRepository;
import com.itakademija.mobileshop.repository.OrderEntryRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CartService {
    private final OrderEntryRepository orderEntryRepository;
    private final CartRepository cartRepository;


    public CartService(
            CartRepository cartRepository,
            OrderEntryRepository orderEntryRepository
    ) {
        this.cartRepository = cartRepository;
        this.orderEntryRepository = orderEntryRepository;
    }


    public Cart updateCartEntry(OrderEntry orderEntry, Cart cart) {
        Optional<OrderEntry> existingEntry = cart.getOrderEntryList()
                .stream()
                .filter(oldEntry -> Objects.equals(oldEntry.getProduct().getId(), orderEntry.getProduct().getId()))
                .findFirst();

        AtomicInteger oldQuantity = new AtomicInteger(0);
        existingEntry.ifPresentOrElse(
                value -> {
                    oldQuantity.set(value.getQuantity());
                    value.setQuantity(orderEntry.getQuantity());
                },
                () ->  cart.getOrderEntryList().add(orderEntry)
        );
        cart.setNumberOfItems(cart.getNumberOfItems() - oldQuantity.get() + orderEntry.getQuantity());
        cart.setTotalPrice(cart.getTotalPrice()
                .subtract(
                        orderEntry.getProduct().getPrice().multiply(BigDecimal.valueOf(oldQuantity.get()))
                )
                .add(
                        orderEntry.getProduct().getPrice().multiply(BigDecimal.valueOf(orderEntry.getQuantity()))
                ));

        if (orderEntry.getQuantity() == 0) {
            var emptyOrderEntry = cart.getOrderEntryList().stream()
                    .filter(oldEntry -> Objects.equals(oldEntry.getProduct().getId(), orderEntry.getProduct().getId()))
                    .findFirst().get();

            cart.getOrderEntryList().remove(emptyOrderEntry);
            orderEntryRepository.delete(emptyOrderEntry);

        }

        cartRepository.save(cart);
        return cart;
    }

}

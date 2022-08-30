package com.itakademija.mobileshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@NoArgsConstructor
@Transactional
@Data
public class Cart {

    public Cart(User user) {
        this.user = user;
        this.orderEntryList = new ArrayList<>();
        this.totalPrice = new BigDecimal(0);
        this.numberOfItems = 0;
    }

    @Id
    @GeneratedValue
    @Column(name = "cart_id")
    private Long id;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "cart_id")
    private Collection<OrderEntry> orderEntryList;

    private DeliveryType deliveryType;
    private BigDecimal totalPrice;
    private Integer numberOfItems;
}

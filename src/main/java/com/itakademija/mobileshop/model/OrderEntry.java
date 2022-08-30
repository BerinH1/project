package com.itakademija.mobileshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
@Data
@NoArgsConstructor
public class OrderEntry {

    public OrderEntry(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Product product;

    private Integer quantity;

}

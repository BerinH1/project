package com.itakademija.mobileshop.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.math.BigDecimal;
import java.util.Currency;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Lob
    @Column(name="CONTENT", length=512)
    private String description;
    private BigDecimal price;
    private Currency currency;
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    private Integer quantityInStock;
    private String image;
}

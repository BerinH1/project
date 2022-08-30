package com.itakademija.mobileshop.model;

import lombok.Getter;

@Getter
public enum ProductType {

    MOBILE("Mobile"), TABLET("Tablet");

    private final String name;

     ProductType(String name) {
        this.name = name;
    }
}

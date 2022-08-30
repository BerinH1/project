package com.itakademija.mobileshop.model;


import lombok.Getter;

@Getter
public enum Role {
    ADMIN("admin"),
    USER("user");
    private String name;
     Role(String name) {
        this.name=name;
    }
}

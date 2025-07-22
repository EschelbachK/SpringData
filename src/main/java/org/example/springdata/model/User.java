package org.example.springdata.model;

import java.util.List;

public record User(String username,
                   String password,
                   String email,
                   List<String> shoppingCart,
                   List<String> orderList) {
}

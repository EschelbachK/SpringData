package org.example.springdata.dto;

import java.util.List;

public record Userdto(String username,
                   List<String> shoppingCart,
                   List<String> orderList) {
}

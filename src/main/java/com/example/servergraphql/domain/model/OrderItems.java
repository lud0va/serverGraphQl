package com.example.servergraphql.domain.model;


public record OrderItems(int orderItemId,


                         String name,
                         double price,
                         int quantity,


                         Orders order) {
}

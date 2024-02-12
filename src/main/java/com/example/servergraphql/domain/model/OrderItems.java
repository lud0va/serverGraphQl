package com.example.servergraphql.domain.model;

import com.example.servergraphql.data.model.OrdersEntity;

public record OrderItems(int orderItemId,


                         String name,
                         double price,
                         int quantity,


                         Orders order) {
}

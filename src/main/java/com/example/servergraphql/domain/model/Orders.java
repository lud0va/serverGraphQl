package com.example.servergraphql.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public record Orders(
        int orderId,
        LocalDateTime orderDate,
        Customers customers,
        List<OrderItems> orderItems


        ) {
}

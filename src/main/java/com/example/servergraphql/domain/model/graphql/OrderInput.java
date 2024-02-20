package com.example.servergraphql.domain.model.graphql;


import java.time.LocalDateTime;

public record OrderInput(
        int orderId,
        LocalDateTime orderDate,
        int customerid
) {}

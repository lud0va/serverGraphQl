package com.example.servergraphql.domain.model;

import com.example.servergraphql.data.model.OrdersEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


public record RestaurantTables(
        int id,
        int numberOfSeats,
        List<Orders> orders

) {
}

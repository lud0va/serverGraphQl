package com.example.servergraphql.domain.model;



import java.util.List;


public record RestaurantTables(
        int id,
        int numberOfSeats,
        List<Orders> orders

) {
}

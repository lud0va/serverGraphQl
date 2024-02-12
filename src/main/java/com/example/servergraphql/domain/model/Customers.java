package com.example.servergraphql.domain.model;

import java.util.List;

public record Customers(
        int id,
         String firstName,
         String lastName,
         String email,
         String phone,
         String dateOfBirth,
         List<Orders> orders){
}

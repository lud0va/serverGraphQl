package com.example.servergraphql.domain.model;

import java.time.LocalDate;
import java.util.List;

public record Customers(int id,

                        String firstName,
                        String lastName,
                        String email,
                        String phone,
                        LocalDate dateOfBirth){
}
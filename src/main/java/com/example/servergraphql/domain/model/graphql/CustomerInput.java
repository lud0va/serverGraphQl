package com.example.servergraphql.domain.model.graphql;

import java.time.LocalDate;


public record CustomerInput(
         int id,

         String firstName,
         String lastName,
         String email,
         String phone,
         LocalDate dateOfBirth

) {



}

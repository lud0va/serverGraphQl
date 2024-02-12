package com.example.servergraphql.domain.model;

public record Command(
         int id,
         String commandName,
         int customerId
) {
}

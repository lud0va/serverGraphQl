package com.example.servergraphql.domain.model.graphql;




public record OrderItemsInput(
         int orderItemId,


         String name,
         double price,
         int quantity,


         OrderInput order
) {


}

package com.example.servergraphql.domain.model.graphql;

import com.example.servergraphql.data.model.OrdersEntity;


public record OrderItemsInput(
         int orderItemId,


         String name,
         double price,
         int quantity,


         OrderInput order
) {


}

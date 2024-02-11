package com.example.servergraphql.spring.graphql;

import com.example.servergraphql.data.model.OrderItemsEntity;
import com.example.servergraphql.domain.model.graphql.OrderItemsInput;
import com.example.servergraphql.domain.services.OrderItemsServices;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderItemsController {
    private final OrderItemsServices serv;

    public OrderItemsController(OrderItemsServices serv) {
        this.serv = serv;
    }
    @QueryMapping
   public List<OrderItemsEntity> getOrderItemsByOrder(int id){
        return serv.getOrderItemsByOrder(id);
    }
    @QueryMapping
    public OrderItemsEntity getOrderItemsByItem(int idItem){
        return serv.getOrderItemById(idItem);
    }
    @MutationMapping
    public OrderItemsEntity addOrderItem(@Argument OrderItemsInput input){return serv.saveOrderItem(input);}
}

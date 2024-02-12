package com.example.servergraphql.spring.graphql;

import com.example.servergraphql.data.model.OrderItemsEntity;
import com.example.servergraphql.domain.model.OrderItems;
import com.example.servergraphql.domain.model.Orders;
import com.example.servergraphql.domain.model.graphql.OrderItemsInput;
import com.example.servergraphql.domain.services.OrderItemsServices;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderItemsController {
    private final OrderItemsServices serv;

    public OrderItemsController(OrderItemsServices serv) {
        this.serv = serv;
    }
    @QueryMapping
    @PreAuthorize("hasRole('admin') OR hasRole('user')")
   public List<OrderItems> getOrderItemsByOrder(@Argument int id){
        return serv.getOrderItemsByOrder(id);
    }
    @QueryMapping
    @PreAuthorize("hasRole('admin') OR hasRole('user')")
    public OrderItems getOrderItemsByItem(@Argument int idItem){
        return serv.getOrderItemById(idItem);
    }
    @MutationMapping
    @PreAuthorize("hasRole('admin')")
    public OrderItems addOrderItem(@Argument OrderItemsInput input){return serv.saveOrderItem(input);}
}

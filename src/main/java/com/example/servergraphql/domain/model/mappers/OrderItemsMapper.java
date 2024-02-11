package com.example.servergraphql.domain.model.mappers;

import com.example.servergraphql.data.model.OrderItemsEntity;
import com.example.servergraphql.data.model.OrdersEntity;
import com.example.servergraphql.domain.model.Orders;
import com.example.servergraphql.domain.model.graphql.OrderInput;
import com.example.servergraphql.domain.model.graphql.OrderItemsInput;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface OrderItemsMapper {
    OrderItemsEntity toOrderItems(OrderItemsInput input);
    Orders toOrders(OrdersEntity ordersEntity);
    Orders toOrders(OrderInput orderInput);

}

package com.example.servergraphql.domain.model.mappers;

import com.example.servergraphql.data.model.OrdersEntity;
import com.example.servergraphql.domain.model.Orders;
import com.example.servergraphql.domain.model.graphql.OrderInput;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface OrdersMapper {
    OrdersEntity toOrderItems(OrderInput input);
    Orders toOrders(OrdersEntity ordersEntity);
    Orders toOrders(OrderInput orderInput);
}

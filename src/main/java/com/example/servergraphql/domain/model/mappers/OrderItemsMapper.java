package com.example.servergraphql.domain.model.mappers;

import com.example.servergraphql.data.model.OrderItemsEntity;
import com.example.servergraphql.domain.model.OrderItems;
import com.example.servergraphql.domain.model.graphql.OrderItemsInput;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface OrderItemsMapper {
    OrderItemsEntity toOrderItems(OrderItemsInput input);
    OrderItems toOrderItem(OrderItemsEntity ordersEntity);
    OrderItems toOrderItem(OrderItemsInput orderInput);

}

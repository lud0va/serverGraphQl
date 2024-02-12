package com.example.servergraphql.data.dao;

import com.example.servergraphql.data.model.CustomersEntity;
import com.example.servergraphql.data.model.OrderItemsEntity;
import com.example.servergraphql.data.model.OrdersEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderItemsDao extends ListCrudRepository<OrderItemsEntity,Long> {


    Optional<List<OrderItemsEntity>> findAllByOrder(OrdersEntity ordersEntity);

    Optional<OrderItemsEntity> findByOrderItemId(int Long);
}

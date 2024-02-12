package com.example.servergraphql.data.dao;

import com.example.servergraphql.data.model.OrdersEntity;
import com.example.servergraphql.data.model.RestaurantTablesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantTablesDao extends  ListCrudRepository<RestaurantTablesEntity,Long> {
    @Query("SELECT rt FROM RestaurantTablesEntity rt JOIN rt.orders o WHERE o.orderId = :order")
    List<RestaurantTablesEntity> findAllByOrders(OrdersEntity order);
}

package com.example.servergraphql.data.dao;

import com.example.servergraphql.data.model.CustomersEntity;
import com.example.servergraphql.data.model.OrdersEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersDao extends ListCrudRepository<OrdersEntity,Long> {
   Optional<List<OrdersEntity>> findAllByCustomersEntity(CustomersEntity customersEntity);
   Optional<OrdersEntity> findByOrderId(int id);
}

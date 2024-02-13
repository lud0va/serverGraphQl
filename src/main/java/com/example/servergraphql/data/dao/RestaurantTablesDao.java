package com.example.servergraphql.data.dao;


import com.example.servergraphql.common.Constantes;
import com.example.servergraphql.data.model.RestaurantTablesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantTablesDao extends  ListCrudRepository<RestaurantTablesEntity,Long> {

    @Query(Constantes.SELECT_RT_FROM_RESTAURANT_TABLES_ENTITY_RT_JOIN_RT_ORDERS_O_WHERE_O_ORDER_ID_ID)
    List<RestaurantTablesEntity> findAllByOrdersId(int id);
}

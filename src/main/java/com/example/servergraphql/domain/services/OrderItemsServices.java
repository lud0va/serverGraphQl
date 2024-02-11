package com.example.servergraphql.domain.services;

import com.example.servergraphql.data.dao.OrderItemsDao;
import com.example.servergraphql.data.model.OrderItemsEntity;
import com.example.servergraphql.data.model.OrdersEntity;
import com.example.servergraphql.domain.model.graphql.OrderItemsInput;
import com.example.servergraphql.domain.model.mappers.OrderItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class OrderItemsServices {
    private final OrderItemsMapper mapper;
   private final OrderItemsDao dao;
    @Autowired

    public OrderItemsServices(OrderItemsMapper mapper, OrderItemsDao dao) {
        this.mapper = mapper;
        this.dao = dao;
    }
    public List<OrderItemsEntity> getOrderItemsByOrder(int idorder){
        return dao.findAllByOrder(new OrdersEntity(idorder)).get();
    }
   public OrderItemsEntity saveOrderItem(OrderItemsInput items){
        OrderItemsEntity it=mapper.toOrderItems(items);

        return dao.save(it);
   }

   public OrderItemsEntity getOrderItemById(int idOrderItem){return dao.findById(Long.valueOf(idOrderItem)).get();}
}

package com.example.servergraphql.domain.services;

import com.example.servergraphql.data.dao.OrderItemsDao;
import com.example.servergraphql.data.model.OrderItemsEntity;
import com.example.servergraphql.data.model.OrdersEntity;
import com.example.servergraphql.domain.model.OrderItems;
import com.example.servergraphql.domain.model.graphql.OrderItemsInput;
import com.example.servergraphql.domain.model.mappers.OrderItemsMapper;
import com.example.servergraphql.spring.Errors.exceptions.IdInvalidaException;
import com.example.servergraphql.spring.Errors.exceptions.NotFoundElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service

public class OrderItemsServices {
    private final OrderItemsMapper mapper;
   private final OrderItemsDao dao;
    @Autowired

    public OrderItemsServices(OrderItemsMapper mapper, OrderItemsDao dao) {
        this.mapper = mapper;
        this.dao = dao;
    }
    public List<OrderItems> getOrderItemsByOrder(int idorder){
        try {
        List<OrderItemsEntity> itemsEn=dao.findAllByOrder(new OrdersEntity(idorder)).get();
        List<OrderItems> item=new ArrayList<>();
        for (OrderItemsEntity i:itemsEn){
            item.add(mapper.toOrderItem(i));

        }
        return item;
        }catch (NoSuchElementException s){
            throw new NotFoundElementException("OrderItem not found");
        }
    }
   public OrderItems saveOrderItem(OrderItemsInput items){
        try {
            OrderItemsEntity it=mapper.toOrderItems(items);
            it.setOrder(new OrdersEntity(items.orderId()));
            OrderItems or=mapper.toOrderItem(dao.save(it));
            return or;
        }catch (DataIntegrityViolationException s){
            throw new IdInvalidaException();
        }

   }

   public OrderItems getOrderItemById(int idOrderItem) {
       try {
           return mapper.toOrderItem(dao.findByOrderItemId(idOrderItem).get());
       } catch (NoSuchElementException s) {
           throw new NotFoundElementException("OrderItem not found");
       }
   }
}

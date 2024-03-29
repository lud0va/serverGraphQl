package com.example.servergraphql.domain.services;

import com.example.servergraphql.common.Constantes;
import com.example.servergraphql.data.dao.OrderItemsDao;
import com.example.servergraphql.data.model.OrderItemsEntity;
import com.example.servergraphql.data.model.OrdersEntity;
import com.example.servergraphql.domain.model.OrderItems;
import com.example.servergraphql.domain.model.graphql.OrderItemsInput;
import com.example.servergraphql.domain.model.mappers.OrderItemsMapper;
import com.example.servergraphql.spring.errors.exceptions.IdInvalidaException;
import com.example.servergraphql.spring.errors.exceptions.NotFoundElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<OrderItems> getOrderItemsByOrder(int idorder){
        List<OrderItemsEntity> itemsEn=dao.findAllByOrder(new OrdersEntity(idorder))
                .orElseThrow(()->new  NotFoundElementException(Constantes.ORDER_ITEM_NOT_FOUND));
        List<OrderItems> item=new ArrayList<>();
        for (OrderItemsEntity i:itemsEn){
            item.add(mapper.toOrderItem(i));

        }
        return item;

    }
   public OrderItems saveOrderItem(OrderItemsInput items){
        try {
            OrderItemsEntity it=mapper.toOrderItems(items);
            it.setOrder(new OrdersEntity(items.orderId()));
            return mapper.toOrderItem(dao.save(it));
        }catch (DataIntegrityViolationException s){
            throw new IdInvalidaException();
        }

   }

   public OrderItems getOrderItemById(int idOrderItem) {

           return mapper.toOrderItem(dao.findByOrderItemId(idOrderItem)
                   .orElseThrow(()->new NotFoundElementException(Constantes.ORDER_ITEM_NOT_FOUND)));

   }
}

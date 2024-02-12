package com.example.servergraphql.domain.services;

import com.example.servergraphql.data.dao.OrdersDao;
import com.example.servergraphql.data.model.CustomersEntity;
import com.example.servergraphql.data.model.Errors;
import com.example.servergraphql.data.model.OrdersEntity;
import com.example.servergraphql.domain.model.Orders;
import com.example.servergraphql.domain.model.mappers.OrdersMapper;
import io.vavr.control.Either;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServices {

 private final    OrdersDao dao;
private final OrdersMapper mapper;

    public OrdersServices(OrdersDao dao, OrdersMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    public List<Orders> getAllOrders(){
        List<OrdersEntity> o= dao.findAll();
        List<Orders> ord=new ArrayList<>();
        for (OrdersEntity c:o){
            ord.add(mapper.toOrders(c));
        }
        return ord;
    }
    public List<Orders> getOrdersDeCust(int idcust){
        List<OrdersEntity> o=dao.findAllByCustomersEntity(new CustomersEntity(idcust)).get();
        List<Orders> ord=new ArrayList<>();
        for (OrdersEntity c:o){
            ord.add(mapper.toOrders(c));
        }
        return  ord;
    }
    public Orders getOrder(int id){
      return mapper.toOrders(dao.findByOrderId(id).get());
    }

    public Either<Errors,Integer> deleteOrder(int idOrder){
        dao.deleteById(Long.valueOf(idOrder));
        return Either.right(0);
    }
}

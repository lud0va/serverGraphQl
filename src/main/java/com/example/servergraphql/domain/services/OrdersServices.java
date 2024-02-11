package com.example.servergraphql.domain.services;

import com.example.servergraphql.data.dao.OrdersDao;
import com.example.servergraphql.data.model.CustomersEntity;
import com.example.servergraphql.data.model.Errors;
import com.example.servergraphql.data.model.OrdersEntity;
import io.vavr.control.Either;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServices {

 private final    OrdersDao dao;


    public OrdersServices(OrdersDao dao) {
        this.dao = dao;
    }

    public List<OrdersEntity> getAllOrders(){
        return dao.findAll();
    }
    public List<OrdersEntity> getOrdersDeCust(int idcust){
        return dao.findAllByCustomers(new CustomersEntity(idcust)).get();
    }

    public Either<Errors,Integer> deleteOrder(int idOrder){
        dao.deleteById(Long.valueOf(idOrder));
        return Either.right(0);
    }
}

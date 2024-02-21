package com.example.servergraphql.domain.services;

import com.example.servergraphql.common.Constantes;
import com.example.servergraphql.data.dao.OrdersDao;
import com.example.servergraphql.data.model.CustomersEntity;
import com.example.servergraphql.domain.model.graphql.OrderInput;
import com.example.servergraphql.data.model.OrdersEntity;
import com.example.servergraphql.domain.model.Orders;
import com.example.servergraphql.domain.model.mappers.OrdersMapper;
import com.example.servergraphql.spring.errors.exceptions.IdInvalidaException;
import com.example.servergraphql.spring.errors.exceptions.NotFoundElementException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServices {

    private final OrdersDao dao;
    private final OrdersMapper mapper;

    public OrdersServices(OrdersDao dao, OrdersMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    public List<Orders> getAllOrders() {
        List<OrdersEntity> o = dao.findAll();
        List<Orders> ord = new ArrayList<>();
        for (OrdersEntity c : o) {
            ord.add(mapper.toOrders(c));
        }
        return ord;
    }

    public List<Orders> getOrdersDeCust(int idcust) {

        List<OrdersEntity> o = dao.findAllByCustomersEntity(new CustomersEntity(idcust))
                .orElseThrow(() -> new NotFoundElementException(Constantes.ORDER_NO_ENCONTRADA));
        List<Orders> ord = new ArrayList<>();
        for (OrdersEntity c : o) {
            ord.add(mapper.toOrders(c));

        }
        return ord;

    }

    public Orders saveOrder(OrderInput input) {
        try {
            OrdersEntity order = mapper.toOrderItems(input);
            order.setCustomersEntity(new CustomersEntity(input.customerid()));
            OrdersEntity o = dao.save(order);
            return mapper.toOrders(o);
        } catch (DataIntegrityViolationException s) {
            throw new IdInvalidaException();
        }
    }

    public Orders getOrder(int id) {

        return mapper.toOrders(dao.findByOrderId(id).orElseThrow(() -> new NotFoundElementException(Constantes.ORDER_NO_ENCONTRADA)));


    }

    public Boolean deleteOrder(int idOrder) {
        OrdersEntity o = dao.findByOrderId(idOrder).orElseThrow(() -> new NotFoundElementException(Constantes.ORDER_NO_ENCONTRADA));
        dao.delete(o);
        return true;
    }
}

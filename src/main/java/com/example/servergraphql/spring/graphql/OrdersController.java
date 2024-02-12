package com.example.servergraphql.spring.graphql;

import com.example.servergraphql.data.model.Errors;
import com.example.servergraphql.data.model.OrdersEntity;
import com.example.servergraphql.domain.services.OrdersServices;
import io.vavr.control.Either;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrdersController {
    private final OrdersServices serv;

    public OrdersController(OrdersServices serv) {
        this.serv = serv;
    }

    @QueryMapping
    public List<OrdersEntity> getOrdersDeCust(int idCust){
        return serv.getOrdersDeCust(idCust);
    }
    @QueryMapping
    public Boolean deleteOrder(@Argument int idOrder) {
        Either<Errors, Integer> result = serv.deleteOrder(idOrder);
        if (result.isRight()) {
            return true;
        }
    return false;
    }
}

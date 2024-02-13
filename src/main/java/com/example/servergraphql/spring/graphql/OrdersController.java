package com.example.servergraphql.spring.graphql;

import com.example.servergraphql.spring.Errors.Errors;
import com.example.servergraphql.domain.model.Orders;
import com.example.servergraphql.domain.services.OrdersServices;
import io.vavr.control.Either;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrdersController {
    private final OrdersServices serv;

    public OrdersController(OrdersServices serv) {
        this.serv = serv;
    }

    @QueryMapping

    public List<Orders> getAllOrders() {
        return serv.getAllOrders();
    }

    @QueryMapping
    @PreAuthorize("hasRole('admin') OR hasRole('user')")
    public List<Orders> getOrdersDeCust(@Argument int idCust) {
        return serv.getOrdersDeCust(idCust);
    }

    @QueryMapping
    @PreAuthorize("hasRole('admin') OR hasRole('user')")
    public Orders getOrder(@Argument int id) {
        return serv.getOrder(id);
    }

    @MutationMapping
    @PreAuthorize("hasRole('admin')")
    public Boolean deleteOrder(@Argument int idOrder) {
        Either<Errors, Integer> result = serv.deleteOrder(idOrder);
        if (result.isRight()) {
            return true;
        }
        return false;
    }
}

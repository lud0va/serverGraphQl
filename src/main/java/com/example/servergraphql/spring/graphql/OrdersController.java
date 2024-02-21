package com.example.servergraphql.spring.graphql;

import com.example.servergraphql.common.Constantes;
import com.example.servergraphql.domain.model.graphql.OrderInput;
import com.example.servergraphql.domain.model.Orders;
import com.example.servergraphql.domain.services.OrdersServices;
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
    @PreAuthorize(Constantes.HAS_ROLE_ADMIN_OR_HAS_ROLE_USER)
    public List<Orders> getAllOrders() {
        return serv.getAllOrders();
    }

    @QueryMapping
    @PreAuthorize(Constantes.HAS_ROLE_ADMIN_OR_HAS_ROLE_USER)
    public List<Orders> getOrdersDeCust(@Argument int idCust) {
        return serv.getOrdersDeCust(idCust);
    }

    @QueryMapping
    @PreAuthorize(Constantes.HAS_ROLE_ADMIN_OR_HAS_ROLE_USER)
    public Orders getOrder(@Argument int id) {
        return serv.getOrder(id);
    }

    @MutationMapping
    @PreAuthorize(Constantes.HAS_ROLE_ADMIN)
    public Boolean deleteOrder(@Argument int idOrder) {

        return   serv.deleteOrder(idOrder);
    }

    @MutationMapping
    @PreAuthorize(Constantes.HAS_ROLE_ADMIN)
    public Orders saveOrder(@Argument OrderInput input) {
        return serv.saveOrder(input);
    }
}

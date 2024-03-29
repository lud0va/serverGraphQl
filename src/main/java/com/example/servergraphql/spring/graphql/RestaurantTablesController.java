package com.example.servergraphql.spring.graphql;

import com.example.servergraphql.common.Constantes;
import com.example.servergraphql.domain.model.RestaurantTables;
import com.example.servergraphql.domain.services.RestaurantTablesServices;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RestaurantTablesController {
   private final RestaurantTablesServices restaurantTablesServices;

    public RestaurantTablesController(RestaurantTablesServices restaurantTablesServices) {
        this.restaurantTablesServices = restaurantTablesServices;
    }

    @QueryMapping
    @PreAuthorize(Constantes.HAS_ROLE_ADMIN_OR_HAS_ROLE_USER)
    public List<RestaurantTables> getAllTablesByCustomer(@Argument int idCust){
        return restaurantTablesServices.getAllTablesByCustomer(idCust);
    }
}
